plugins {
	java
    id("org.springframework.boot") version "3.2.8"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.absn"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
