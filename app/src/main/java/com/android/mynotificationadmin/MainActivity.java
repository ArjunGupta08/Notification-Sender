package com.android.mynotificationadmin;

import static com.android.mynotificationadmin.Constants.TOPIC;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.android.mynotificationadmin.api.ApiUtilities;
import com.android.mynotificationadmin.model.NotificationData;
import com.android.mynotificationadmin.model.PushNotificationData;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextInputEditText title, message;
    MaterialButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC);

        title = findViewById(R.id.title);
        message = findViewById(R.id.desc);

        btn = findViewById(R.id.send);

        btn.setOnClickListener(v -> {
            if (!title.getText().toString().isEmpty() || !message.getText().toString().isEmpty()) {
                PushNotificationData notificationData = new PushNotificationData(new NotificationData(title.getText().toString(), message.getText().toString()), TOPIC);
                sendNotification(notificationData);
            } else {
                Toast.makeText(this, "Please Insert Data", Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void sendNotification(PushNotificationData notificationData) {
        ApiUtilities.getClient().sendNotification(notificationData).enqueue(new Callback<PushNotificationData>() {
            @Override
            public void onResponse(Call<PushNotificationData> call, Response<PushNotificationData> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Succes", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, response.message().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PushNotificationData> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}