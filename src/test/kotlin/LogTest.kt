package dev.iestyn129.tynlog

import java.io.File

fun main() {
	TynLog.init(TynConfig(
		debug = true,
		//errorStream = System.err,
		logFolder = LogFolderConfig(
			folder = File("src/test/log"),
			//timeFormat = SimpleDateFormat("yyyy-MMM-dd"),
			autoDeleteTime = 60L * 1000L
		)
	))

	TynLog.info("info")
	TynLog.warn("warn")
	TynLog.error("error")
	TynLog.debug("debug")
	TynLog.info("info")
	TynLog.warn("warn")
	TynLog.error("error")
	TynLog.debug("debug")
	TynLog.info("info")
	TynLog.warn("warn")
	TynLog.error("error")
	TynLog.debug("debug")
	TynLog.info("info")
	TynLog.warn("warn")
	TynLog.error("error")
	TynLog.debug("debug")
}
