# Setting gradle

```
plugins {
    id 'com.android.application'
    id 'kotlin-android'
}

android {
    compileSdkVersion 29
    buildToolsVersion "30.0.3"


    buildFeatures {
        viewBinding true
    }

    defaultConfig {
        applicationId "com.example.latihanframgent"
        minSdkVersion 22
        targetSdkVersion 29
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
}


def lifecycle_version = "2.2.0"

dependencies {
    def glide_version = "4.9.0"
    implementation "com.github.bumptech.glide:glide:$glide_version"
    implementation "androidx.navigation:navigation-fragment-ktx:2.3.3"
    implementation "androidx.navigation:navigation-ui-ktx:2.3.3"
    implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
    implementation 'androidx.core:core-ktx:1.2.0'
    implementation 'androidx.appcompat:appcompat:1.1.0'
    implementation 'com.google.android.material:material:1.1.0'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    implementation 'androidx.lifecycle:lifecycle-viewmodel-savedstate:2.2.0'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.1'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'
}
```

- Membuat enum ResourceStatus untuk status yang dignakan pada ResourceState
```
enum class ResourceStatus {
    SUCCESS,
    FAIL,
    LOADING
}
```

- Membuat ResourceState digunakan untuk penggunaan status ketika menekan tombol button
```
class ResourceState(val status: ResourceStatus, val data: Any?, val message: String?) {
    companion object {
        fun success(data: Any?) =
            ResourceState(status = ResourceStatus.SUCCESS, data = data, message = null)

        fun loading() = ResourceState(status = ResourceStatus.LOADING, data = null, message = null)

        fun fail(message: String?) =
            ResourceState(status = ResourceStatus.FAIL, data = null, message = message)
    }
}
```

- Membuat RegistrationViewModel yang dinakan untuk perpindahan data serta viewmodel dari registration

