buildscript {
    extra.apply {
        set("compose_version", "1.1.1")
    }
    repositories {
        google()
    }
}

plugins {
    id("com.android.application") version "7.4.0-alpha02" apply false
    id("com.android.library") version "7.4.0-alpha02" apply false
    id("org.jetbrains.kotlin.android") version "1.6.10" apply false
}
repositories {
    google()
}
