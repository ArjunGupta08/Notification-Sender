package com.android.mynotificationadmin.api;

import static com.android.mynotificationadmin.Constants.API_KEY;
import static com.android.mynotificationadmin.Constants.CONTENT_TYPE;

import com.android.mynotificationadmin.model.PushNotificationData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @Headers({"Authorization: key=" + API_KEY, "Content_Type:"+CONTENT_TYPE})
//    @POST("/v1/projects/my-notification-5d6f4/messages:send")
    @POST("fcm/send")
    Call<PushNotificationData> sendNotification(@Body PushNotificationData pushNotificationData);

}