hileco-boot
===========

Java utilities for working with Spring, specifically Spring Boot

- Requires Java 1.8
- Builds with maven

hileco-boot-enabler
===================

Functionality for `@Enable` Spring-Data like functionality for scanning the classpath for interfaces we can implement, based on annotations. The
tests include a complete sample where marking an interface with an `@Mocked` annotation makes mock-implementations available for autowiring.

An end-user of the sample library would only have to mark their configuration with `@EnableMocking("package.with.services")`, and their services with `@Mocked`.
The test implementation scans the referenced package for `@Mocked` annotated interfaces and registers mock implementations generated with Mockito to the applicationcontext.