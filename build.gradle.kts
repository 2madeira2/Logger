plugins {
    java
}

group = "ru.madeira"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    implementation("org.jetbrains:annotations:20.1.0")
    implementation("com.google.inject:guice:5.0.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}