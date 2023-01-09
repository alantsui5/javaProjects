plugins {
	java
	id("org.springframework.boot") version "3.0.1"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "com.book"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.0.1")
	implementation("org.springframework.boot:spring-boot-starter-security:3.0.1")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf:3.0.1")
	implementation("org.springframework.boot:spring-boot-starter-web:3.0.1")
	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6:3.1.0.M1")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.0")
	implementation("org.springframework.boot:spring-boot-starter-validation:3.0.1")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server:3.0.1")
	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test:3.0.1")
	testImplementation("org.springframework.security:spring-security-test:6.0.1")
	testImplementation("io.rest-assured:rest-assured:5.3.0")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
