pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "FormzApp"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":compose-example")
include(":mdc-example")
include(":formz")
