// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id ("com.google.dagger.hilt.android") version "2.51.1" apply false

}
buildscript{
    repositories{
        google()
        mavenCentral()
    }
    dependencies{
        classpath(libs.hilt.android.gradle.plugin)
    }
}