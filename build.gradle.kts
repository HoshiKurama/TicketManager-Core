plugins {
    kotlin("jvm") version "1.9.21"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("com.github.ben-manes.versions") version "0.50.0"
    application
}

application.mainClass.set("com.github.hoshikurama.tmcore.Plugin")

group = "com.github.hoshikurama"
version = "11.0.1"

repositories {
    mavenCentral()
    maven(url = "https://papermc.io/repo/repository/maven-public/")
    maven(url = "https://jitpack.io")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20-R0.1-SNAPSHOT")

    // Shade these in for Kotlin users
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.21")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.21")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime-jvm:0.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json-jvm:1.6.2")

    implementation("com.github.HoshiKurama.TicketManager_API:Common:11.0.1")
    implementation("com.github.HoshiKurama.TicketManager_API:TMCoroutine:11.0.1")
    implementation("com.github.HoshiKurama.TicketManager_API:Java:11.0.1")
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
    jvmToolchain(17)
}