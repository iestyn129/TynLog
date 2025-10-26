plugins {
	kotlin("jvm") version "2.2.20"
}

group = "dev.iestyn129.tynlog"
version = "0.1.3"

repositories {
	mavenCentral()
}

dependencies {}

tasks.jar {
	archiveBaseName = project.name
	archiveVersion = "v${project.version}"
}

kotlin {
	jvmToolchain(8)
}
