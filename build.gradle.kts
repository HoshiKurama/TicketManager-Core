plugins {
    kotlin("jvm") version "2.0.21"
    id("com.gradleup.shadow") version "8.3.5"
    id("com.github.ben-manes.versions") version "0.51.0"
    application
}

application.mainClass.set("com.github.hoshikurama.tmcore.Plugin")

group = "com.github.hoshikurama"
version = "11.1.2"

repositories {
    mavenCentral()
    maven(url = "https://repo.papermc.io/repository/maven-public/")
    maven(url = "https://jitpack.io")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.3-R0.1-SNAPSHOT")

    // Shade these in for Kotlin users
    implementation("org.jetbrains.kotlin:kotlin-reflect:2.0.21")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:2.0.21")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime-jvm:0.6.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json-jvm:1.7.3")

    implementation("com.github.HoshiKurama.TicketManager_API:Common:11.1.1")
    implementation("com.github.HoshiKurama.TicketManager_API:TMCoroutine:11.1.1")
    implementation("com.github.HoshiKurama.TicketManager_API:Java:11.1.1")
}

tasks {
    shadowJar {
        configurations = listOf(project.configurations.runtimeClasspath.get())

        dependencies {}

        relocate("kotlin", "com.github.hoshikurama.ticketmanager.shaded.kotlin")
        relocate("kotlinx", "com.github.hoshikurama.ticketmanager.shaded.kotlinx")
    }
}

kotlin {
    jvmToolchain(21)
}