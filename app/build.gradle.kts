plugins {
    id("com.android.application") version "8.3.1" // Asegúrate de que esta línea solo aparece una vez
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.google.services)
}


android {
    namespace = "pe.pcs.firestorebasicoyt"
    compileSdk = 34

    defaultConfig {
        applicationId = "pe.pcs.firestorebasicoyt"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Firestore
    implementation(platform("com.google.firebase:firebase-bom:33.1.1"))
    implementation(libs.firebase.firestore)
    implementation("com.google.firebase:firebase-analytics")
    //Coroutines - Firebase
    implementation(libs.kotlinx.coroutines.play.services)

    // Libreria de utilidades
    implementation(libs.libreria.pcs)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

tasks.register<Wrapper>("wrapper") {
    gradleVersion = "8.6"
    distributionType = Wrapper.DistributionType.ALL
}

buildscript {
    val androidPluginVersion by extra("8.4.2")
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:$androidPluginVersion")
    }
}
