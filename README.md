hileco-boot
===========

Java utilities for working with Spring, specifically Spring Boot

- Requires Java 1.8
- Builds with maven

hileco-boot-enabler
===================

Functionality for `@Enable` Spring-Data like functionality for scanning the classpath for interfaces we can implement, based on annotations. The
tests include a complete sample where marking an interface with an `@Mocked` annotation makes mock-implementations available for autowiring.

An end-user of this library would only have to mark their configuration with `@EnableMocking("package.with.services")`, and their services with `@Mocked`.

The implementation included in the tests then scans the given package for `@Mocked` annotated interfaces and publishes mock implementations for autowiring.