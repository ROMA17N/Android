plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.itvo.salary"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.itvo.salary"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)

    testImplementation(libs.junit.jupiter)
    //testRuntimeOnly(libs.junit.jupiter.engine)
   // testImplementation ("org.junit.jupiter:junit-jupiter-api:5.11.4")
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.11.4")

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
  }

tasks.withType<Test> {
    useJUnitPlatform() // Necesario para JUnit 5
}



