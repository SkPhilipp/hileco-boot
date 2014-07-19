hileco-boot
===========

Java utilities for working with Spring, specifically Spring Boot

- Requires Java 1.8
- Builds with maven

[![Build Status](https://travis-ci.org/SkPhilipp/hileco-boot.svg)](https://travis-ci.org/SkPhilipp/hileco-boot)

hileco-boot-enabler
===================

Functionality so you can provide `@Enable` Spring-Data like functionality in your own libraries, for automated scanning of the classpath for usually proxy-implementable interfaces, based on annotation configuration.

The tests include a full sample where an end-user of the sample library would only have to mark their configuration with `@EnableMocking("package.with.services")`, and their services with `@Mocked`.
The test implementation then scans the referenced package for `@Mocked` annotated interfaces and registers mock implementations generated with Mockito to the applicationcontext, such that the mock implementations are used for autowiring.
