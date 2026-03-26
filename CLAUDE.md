# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Spring Framework learning/demo project focused on demonstrating Spring IOC (Inversion of Control) and AOP (Aspect-Oriented Programming) concepts, as well as Java fundamentals including proxy patterns, reflection, IO, and threading.

## Build Commands

This is a Maven project. Use the following commands:

- Build project: `mvn compile`
- Run all tests: `mvn test`
- Run single test class: `mvn test -Dtest=ClassName`
- Run single test method: `mvn test -Dtest=ClassName#methodName`
- Package: `mvn package`

## Key Dependencies

- Spring Framework 3.1.1.RELEASE
- JUnit 4.8 (testing)
- CGLIB 2.2.2 (proxy)
- AspectJ Weaver 1.8.7 (AOP)
- Velocity 1.7 (templating)

## Code Architecture

### Main Source Directories

- `src/main/java/com/ioc/` - Spring IOC examples: BeanFactoryPostProcessor, property editors
- `src/main/java/com/aop/` - AOP aspects and interceptors
- `src/main/java/com/spring/bean/` - Bean implementations and FactoryBean examples
- `src/main/java/com/resource/` - Resource/ResourceLoader injection examples
- `src/main/java/com/service/` - Service interfaces and implementations

### Test Directories

- `src/test/java/com/ioc/` - IOC container tests: BeanFactory vs ApplicationContext, property placeholders, bean lifecycle
- `src/test/java/com/aop/` - AOP configuration tests (XML-based)
- `src/test/java/com/proxy/` - JDK dynamic proxy and CGLIB proxy examples
- `src/test/java/com/base/` - Java fundamentals: IO, encoding, reflection, classpath, properties
- `src/test/java/com/paramvalidator/` - Hibernate Validator examples
- `src/test/java/com/template/` - Velocity template examples

### Configuration Files

Spring XML configs are in `src/main/resources/`:
- `beans.xml` - Main bean configuration
- `simple-bean*.xml` - Various bean configuration examples
- `aop/aop_01.xml` - AOP configuration
- `factorybean/*.xml` - FactoryBean examples

## Important Notes

- Tests use both `BeanFactory` (programmatic) and `ApplicationContext` (declarative) approaches to demonstrate different Spring container usage patterns
- The project demonstrates both JDK dynamic proxy and CGLIB proxy implementations for AOP
- Property editors and BeanPostProcessors are used to show bean lifecycle customization