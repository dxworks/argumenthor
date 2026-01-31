# Argumenthor

A Kotlin library for parsing configuration values from multiple sources with type-safe field definitions.

[![Build](https://github.com/dxworks/argumenthor/actions/workflows/build.yml/badge.svg)](https://github.com/dxworks/argumenthor/actions/workflows/build.yml)
[![Maven Central](https://img.shields.io/maven-central/v/org.dxworks.utils/argumenthor)](https://central.sonatype.com/artifact/org.dxworks.utils/argumenthor)

## Installation

### Gradle (Kotlin DSL)
```kotlin
implementation("org.dxworks.utils:argumenthor:1.0.0")
```

### Gradle (Groovy)
```groovy
implementation 'org.dxworks.utils:argumenthor:1.0.0'
```

### Maven
```xml
<dependency>
    <groupId>org.dxworks.utils</groupId>
    <artifactId>argumenthor</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Features

- **Multi-source configuration** - Read values from command-line arguments, properties files, and environment variables
- **Type-safe fields** - Generic field definitions with compile-time type safety
- **Priority-based fallback** - Values are looked up across sources in configurable order
- **Pluggable architecture** - Add custom sources by implementing `ConfigurationSource`

## Usage

```kotlin
// Set up default sources (Args > Properties > Env)
ArgumenthorConfiguration.setDefaultSources()

// Register a field
val portField = NumberField("port")
ArgumenthorConfiguration.registerField(portField)

// Get value (checks all sources in priority order)
val port: Number? = Argumenthor.getValue("port")

// Or get from a specific source
val portFromEnv: Number? = Argumenthor.getValue("port", "env")
```

### Configuration Sources

- **ArgsSource** - Parses `-argName=value` format from command-line arguments
- **PropertiesSource** - Loads values from Java properties files
- **EnvSource** - Reads environment variables with optional prefix

### Field Types

- `StringField` - Basic strings
- `NumberField` - Numeric values
- `StringListField` - Comma-separated string lists
- `NumberListField` - Comma-separated number lists

## License

Apache License 2.0
