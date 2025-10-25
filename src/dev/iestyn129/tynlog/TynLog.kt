package dev.iestyn129.tynlog

import java.io.PrintStream
import java.time.LocalDateTime

object TynLog {
	private var initialised: Boolean = false
		set(value: Boolean) {
			if (!field) field = value
		}
	private lateinit var config: TynConfig

	fun init(config: TynConfig = TynConfig()) {
		if (initialised)
			throw IllegalStateException("TynLog has already been initialised")

		this.config = config
		
		initialised = true
	}

	fun info(message: Any?) = log(LogLevel.INF, message)

	fun warn(message: Any?) = log(LogLevel.WRN, message)

	fun error(message: Any?) = log(LogLevel.ERR, message)

	fun debug(message: Any? = "") = log(LogLevel.DBG, message)

	private fun log(logLevel: LogLevel, message: Any?) {
		if (!initialised || (logLevel == LogLevel.DBG && !config.debug))
			return

		val text: String = "[${LocalDateTime.now().format(config.timeFormat)}] [$logLevel] $message\n"

		val errorStream: PrintStream? = config.errorStream
		if (logLevel == LogLevel.ERR && errorStream != null)
			errorStream.print(text)
		else config.printStream?.print(text)

		config.logFolder?.log(text)
	}
}
