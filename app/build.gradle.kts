buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:7.1.3'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10"
    }
}
plugins {
    id 'com.android.application'
    id 'kotlin-android'
    id 'kotlin-kapt'
}

android {
    namespace 'com.claucas90.sprintmodulo6'
    compileSdkVersion 33

    defaultConfig {
        applicationId "com.claucas90.sprintmodulo6"
        minSdkVersion 26
        targetSdkVersion 33
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
                targetCompatibility JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = '1.8'
    }

    tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile).configureEach {
        kotlinOptions {
            jvmTarget = '1.8'
        }
    }


    buildFeatures {
        viewBinding = true
    }

    dataBinding {
        enabled = true
    }
}

dependencies {

    implementation('androidx.fragment:fragment-ktx:1.5.4')

    def lifecycle_version = "2.2.0"
    // LiveData
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"


    def room_version = "2.2.5"

    implementation "androidx.room:room-ktx:$room_version"

    implementation "androidx.room:room-runtime:2.4.3"
    kapt "androidx.room:room-compiler:2.4.3"
    implementation 'org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.31'
    implementation 'androidx.navigation:navigation-fragment-ktx:2.3.5'
    implementation 'androidx.navigation:navigation-ui-ktx:2.3.5'

    implementation 'androidx.recyclerview:recyclerview:1.2.0'
    implementation 'androidx.core:core-ktx:1.8.0'
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.5.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
    implementation "androidx.cardview:cardview:1.0.0"

    //Glide
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    kapt 'com.github.bumptech.glide:compiler:4.12.0'

    //Retrofit
    implementation "com.squareup.retrofit2:retrofit:2.9.0"
    implementation'com.squareup.retrofit2:converter-gson:2.9.0'

    // Retrofit with Scalar Converter
    implementation "com.squareup.retrofit2:converter-scalars:2.9.0"


}