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

## Step - 2
 - Implement the firebase post API provoided by FCM (Firebase Cloud Messaging) ,to send notification data.

 - Base URL -
 
        public static final String Base_URL = "https://fcm.googleapis.com";
 

- End URL

         @Headers({"Authorization: key=" + API_KEY, "Content_Type:"+CONTENT_TYPE})
         @POST("fcm/send")
         Call<PushNotificationData> sendNotification(@Body PushNotificationData pushNotificationData);
- Generate API Key from Firebase cloud messaging section.

       public static final String API_KEY = "AAAAcqyTd4U:APA91bGbtAXL0pzzBzXcg-G7K3rxDXTAXCkF9eVwN2b8a7UDAevhF1J6fc_yEJyyzp0Hz6_OO6d7gOHO8MJx8khpYFNoSokOF6e3-ujWVhUxcxDuSIXuhW-qDGvjzY2onKqHZRdx9brL";

        public static final String CONTENT_TYPE = "application/json".

- *NOTE - This base url is only valid till June 2024 becouse of changement in firebase policies.*

## Step - 3
- Now call this POST API in your MainActivity.

## Step - 4
 - Now come to notification reciever applicatioon
 - https://github.com/ArjunGupta08/Notification-Receiver
