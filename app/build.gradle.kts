plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.dubaothoitiet"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.dubaothoitiet"
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("com.google.android.material:material:1.10.0")
    implementation("com.squareup.picasso:picasso:2.8")
    // Retrofit và Gson
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // RecyclerView
    implementation ("androidx.recyclerview:recyclerview:1.3.2")

    // Glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")

    // Các thư viện AndroidX cần thiết
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("com.squareup.okhttp3:okhttp:4.9.3")
    implementation ("com.android.support:recyclerview-v7:28.0.0")
    implementation ("com.squareup.okhttp3:okhttp:4.9.3")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.3")
    implementation ("com.google.android.material:material:1.12.0") // Hoặc phiên bản mới nhất
    implementation ("androidx.appcompat:appcompat:1.7.0-alpha03") // Hoặc phiên bản mới nhất
    implementation("androidx.drawerlayout:drawerlayout:1.2.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.7")
    implementation ("com.github.bumptech.glide:glide:4.16.0")

    // Add the annotation processor for Glide
    annotationProcessor ("com.github.bumptech.glide:compiler:4.16.0")

}