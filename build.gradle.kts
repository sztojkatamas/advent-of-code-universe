import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    application
    id("com.github.johnrengelman.shadow") version "7.1.0"
}

version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_17

application {
    mainClass.set("hu.advent.of.code.ApplicationKt")
}

tasks {
    named<ShadowJar>("shadowJar") {
        minimize()
    }
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

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}
tasks.withType<Test> {
    useJUnitPlatform()
}