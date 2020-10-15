plugins {
    id("java")
    kotlin("jvm") version "1.4.10"
}

group ="org.dxworks"
version ="1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    testImplementation("org.junit.jupiter:junit-jupiter:5.4.2")
}

tasks.withType<Test> {
    useJUnitPlatform()
}


publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = "https://maven.pkg.github.com/dxworks/argumenthor"
            credentials {
                username = project.findProperty("gpr.user") as String ?: System.getenv("GITHUB_ACTOR")
                password =  project.findProperty("gpr.key") as String ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        register("jar", MavenPublication) {
            from(components.java)
            pom {
                url.set("https://github.com/dxworks/argumenthor.git")
            }
        }
    }
}
