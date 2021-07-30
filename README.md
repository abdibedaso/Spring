# Spring
Spring-powered, production-grade applications and services with absolute minimum fuss.

## Modules

1. Spring-Basics
   - Spring Basics Annotation Configuration
   - Spring Basics Java Configuration
   - Spring Basics XML Configuration

   
2. Spring-Hibernate
   - Spring Hibernate Annotation Configuration
   - Spring Hibernate XML Configuration
   - Spring Hibernate Open Session In View

   
4. Spring-Job-Scheduling
    - Spring Job Scheduling Bank Application
    - Spring Job Scheduling Billing Application
    
## Setup



## Dependencies



## Bundles

Take note of the `pom.xml` file.

## Philosophy

I hate coding absolute paths in my build script, and I hate including
built files as part of the base project. My philosophy is that the
*environment* should be set up so that the tool can easily find the
external resources they need (JUnit, etc.) from the system or
dependency manager. It's the system or dependency manager that
provides the libraries. Anyone who has the proper development
environment set up -- one that works across many projects -- should be
able to clone the repository and do a build simply by running the
build program with no special arguments. There should be no need to
edit or install anything into the project space for the initial build.

# License
Geekcolab Spring is Open Source application programs under the https://www.apache.org/licenses/LICENSE-2.0.html[Apache 2.0 license].
