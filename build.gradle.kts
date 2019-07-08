import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        google()
        jcenter()

    }
    dependencies {
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

group = "dev.roteblume"

val version: String by project
java.sourceCompatibility = JavaVersion.VERSION_1_8

plugins {
    idea
    kotlin("jvm") version "1.3.21"
    id("io.gitlab.arturbosch.detekt").version("1.0.0-RC16")
    `maven-publish`
}

allprojects {
    repositories {
        jcenter()
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks {
    // Use the built-in JUnit support of Gradle.
    "test"(Test::class) {
        useJUnitPlatform()
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.2.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.2.0")
    testRuntime("org.junit.platform:junit-platform-console:1.2.0")
    testCompile("org.mockito:mockito-core:2+")
    testCompile("org.mockito:mockito-junit-jupiter:2.18.3")
    testCompile("com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0")
}

repositories {
    mavenCentral()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}

val userHome = System.getProperty("user.home")

detekt {
    idea {
        path = "$userHome/.idea"
        codeStyleScheme = "$userHome/.idea/idea-code-style.xml"
        inspectionsProfile = "$userHome/.idea/inspect.xml"
        report = "$project.projectDir/reports"
        mask = "*.kt,"
    }
}

val nexusUrl: String by project
val nexusUploadLogin: String by project
val nexusUploadPassword: String by project

publishing {

    publications {
        register("mavenJava", MavenPublication::class) {
            from(components["java"])
        }
    }

    repositories {
        maven {
            url = uri(nexusUrl)
            credentials {
                username = nexusUploadLogin
                password = nexusUploadPassword
            }
        }
    }
}
