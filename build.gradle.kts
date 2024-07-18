import org.jetbrains.intellij.platform.gradle.IntelliJPlatformType
import org.jetbrains.intellij.platform.gradle.TestFrameworkType

plugins {
    idea
    id("org.jetbrains.intellij.platform") version "2.0.0-SNAPSHOT"
}

apply {
    java
    plugin("org.jetbrains.intellij.platform")
}

repositories {
    mavenCentral()

    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        create(IntelliJPlatformType.IntellijIdeaUltimate, "2024.1")
        instrumentationTools()
        testFramework(TestFrameworkType.JUnit5)
    }

    testImplementation(platform("org.junit:junit-bom:5.10.3"))
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks {
    withType<Test>().configureEach {
        useJUnitPlatform()
    }
}

configure<JavaPluginExtension>() {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
