import java.net.URI

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://www.jitpack.io") }

    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://www.jitpack.io") }

    }
}

rootProject.name = "FormzApp"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":compose-example")
include(":mdc-example")
include(":formz")
