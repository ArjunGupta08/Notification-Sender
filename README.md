# Admin -> User Notification Communication
### Using this application, admin can send notification to user app with custom title and message.

## Step - 1
 - Connect your admin application to Firebase Cloud Messaging.
 - Implement the following dependecies,

        // Add the dependency for the Google services Gradle plugin
        id("com.google.gms.google-services") version "4.4.1" apply false

        // Mention this id on top in gradle file
        id("com.google.gms.google-services")

        // Firebase
        implementation(platform("com.google.firebase:firebase-bom:32.7.2"))
        implementation("com.google.firebase:firebase-analytics")
        implementation("com.google.firebase:firebase-messaging")

        //RetroFit
        implementation ("com.squareup.retrofit2:retrofit:2.9.0")
        implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    
