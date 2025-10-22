package dev.iestyn129.tynlog

import java.io.File
import java.io.IOException
import java.io.PrintStream
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.Date

private const val FILE_EXTENSION: String = "log"

data class TynConfig(
	val debug: Boolean = false,
	val timeFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"),
	val printStream: PrintStream? = System.out,
	val errorStream: PrintStream? = null,
	val logFolder: LogFolderConfig? = null
)

data class LogFolderConfig(
	val folder: File,
	val timeFormat: SimpleDateFormat = SimpleDateFormat("yyyy-MMM-dd HH:mm:ss"),
	val autoDeleteTime: Long? = null,
) {
	private var initialised: Boolean = false
		set(value: Boolean) {
			if (!field) field = value
		}
	private lateinit var logFile: File

	init {
		if (folder.isFile)
			throw IllegalStateException("Log folder must not be a file")
	}

	@Synchronized
	fun log(message: String) {
		if (!initialised) {
			if (!folder.exists())
				folder.mkdirs()

			if (autoDeleteTime != null) folder.listFiles { it.isFile && it.extension == FILE_EXTENSION }?.forEach {
				if (System.currentTimeMillis() >= it.lastModified() + autoDeleteTime)
					if (!it.delete()) throw IOException("Failed to delete old file: ${it.name}")
			}

			if (!::logFile.isInitialized) {
				val fileName: String = "${timeFormat.format(Date())}"
				logFile = File(folder, "$fileName.$FILE_EXTENSION")

				var i: Int = 1
				while (logFile.exists()) {
					logFile = File(folder, "$fileName-$i.$FILE_EXTENSION")
					i++
				}

				logFile.createNewFile()
			}

			initialised = true
		}

		logFile.appendText(message)
	}
}
