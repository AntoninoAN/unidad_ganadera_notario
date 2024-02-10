plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.model"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    // Retrofit core
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // Retrofit Moshi
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    // Room DB Core
    implementation("androidx.room:room-runtime:2.6.1")
    // Room Annotation Processor
    ksp("androidx.room:room-compiler:2.6.1")
    // Room Coroutines
    implementation("androidx.room:room-ktx:2.6.1")



    // Hilt Core
    implementation("com.google.dagger:hilt-android:2.48.1")
    // Hilt Annotation Processor
    ksp("com.google.dagger:hilt-android-compiler:2.48.1")
}