plugins {
    kotlin("jvm") version "1.6.0"
}

group = "dev.kirke"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.assertj:assertj-core:3.21.0")
    testCompileOnly("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks {
    wrapper {
        gradleVersion = "7.3"
    }

    test {
        useJUnitPlatform()
    }
}
