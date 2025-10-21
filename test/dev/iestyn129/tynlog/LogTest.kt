package dev.iestyn129.tynlog

import java.io.File

fun main() {
	TynLog.init(TynConfig(
		debug = true,
		logFolder = LogFolderConfig(
			folder = File("test/log"),
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
