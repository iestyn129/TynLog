package dev.iestyn129.tynlog

enum class LogLevel {
	INF,
	WRN,
	ERR,
	DBG;

	override fun toString(): String = name.uppercase()
}
