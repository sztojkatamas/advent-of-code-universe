import com.adarshr.gradle.testlogger.theme.*
import org.gradle.api.logging.LogLevel

plugins {
    kotlin("jvm") version "1.7.21"
    application
    id("com.github.johnrengelman.shadow") version "7.1.0"
    id("com.adarshr.test-logger") version "3.2.0"
}

version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_17

application {
    mainClass.set("hu.advent.of.code.ApplicationKt")
}

tasks.shadowJar {
        minimize()
}

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.springframework:spring-context:6.0.0")
    implementation("io.github.microutils:kotlin-logging-jvm:2.1.23")
    implementation("ch.qos.logback:logback-classic:1.2.11")

    testImplementation("org.jetbrains.kotlin:kotlin-test:1.6.0")
}

tasks.compileKotlin {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}
tasks.test {
    useJUnitPlatform()
}

testlogger {
    theme = ThemeType.STANDARD
    showSummary = true
    showStandardStreams = true
    showPassedStandardStreams = true
    showSkippedStandardStreams = true
    showFailedStandardStreams = true
    logLevel = LogLevel.LIFECYCLE
}