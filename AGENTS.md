# AGENTS.md

This file provides guidance to AI coding agents when working with code in this repository.

## Project Overview

Argumenthor is a Kotlin library for parsing configuration values from multiple sources (command-line arguments, properties files, environment variables) with type-safe field definitions. Published to Maven Central under `org.dxworks.utils`.

## Build Commands

```bash
mvn clean verify    # Build and run tests
mvn test            # Run tests only
mvn install         # Install to local ~/.m2
```

## Release Workflow

- **Snapshots**: Auto-published on push to `main` branch
- **Releases**: Triggered by pushing a `v*` tag (e.g., `v1.0.1`)

To release:
1. Update version in `pom.xml` (remove `-SNAPSHOT`)
2. Commit: `git commit -am "Release 1.0.1"`
3. Tag: `git tag v1.0.1`
4. Push: `git push && git push --tags`
5. Bump to next snapshot in pom.xml: `<version>1.0.2-SNAPSHOT</version>`
6. Commit & push

## Architecture

### Core Components

- **Argumenthor** (`Argumenthor.kt`) - Main facade providing `getValue<T>(name)` and `getValue<T>(name, source)` methods
- **ArgumenthorConfiguration** - Holds field and source registrations; `setDefaultSources()` configures Args + Properties + Env sources

### Configuration Sources (`/config/sources/impl/`)

Sources implement `ConfigurationSource` interface with `get(field: FieldConfig<T>): T?`:

- **ArgsSource** - Parses `-argName=value` format from command-line
- **PropertiesSource** - Lazy-loads Java properties files
- **EnvSource** - Reads environment variables with optional prefix
- **YamlSource** - Stub (not implemented)

### Field Types (`/config/fields/impl/`)

Fields extend `FieldConfig<T>` with abstract `parse(value: String?): T?`:

- **StringField** - Basic strings with quote trimming
- **NumberField** - Numeric values using custom `+` operator
- **StringListField** / **NumberListField** - Comma-separated values

### Design Patterns

1. **Multi-source fallback** - Values are looked up across sources in priority order
2. **Pluggable sources** - Add custom sources by implementing `ConfigurationSource`
3. **Type-safe fields** - Generic field definitions provide compile-time type safety

## Tech Stack

- Kotlin 2.3.0 targeting Java 11
- JUnit 6.0.2 for testing
- Maven with central-publishing-maven-plugin for Maven Central Portal publishing
