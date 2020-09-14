package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Noti_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noti_);

        Button btnNoti = findViewById(R.id.btnNoti);
        btnNoti.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Tạo channel cho Ứng dụng
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                // Channel ID đặt bất kì
                String NOTIFICATION_CHANNEL_ID = "my_channel_id_01";

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "My Notifications", NotificationManager.IMPORTANCE_HIGH);
                    notificationManager.createNotificationChannel(notificationChannel);
                }

                // Trang trí cho thông báo
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(Noti_Activity.this,
                        NOTIFICATION_CHANNEL_ID);
                mBuilder.setSmallIcon(R.mipmap.ic_launcher);
                mBuilder.setContentTitle("Notification Alert, Click Me!");
                mBuilder.setContentText("Hi, This is Android Notification Detail!");
                mBuilder.setAutoCancel(true);

//                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
//                String[] events = new String[6];
//                events[0] = new String("This is first line....");
//                events[1] = new String("This is second line...");
//                events[2] = new String("This is third line...");
//                events[3] = new String("This is 4th line...");
//                events[4] = new String("This is 5th line...");
//                events[5] = new String("This is 6th line...");
//                // Sets a title for the Inbox style big view
//                inboxStyle.setBigContentTitle("Big Title Details:");
//                // Moves events into the big view
//                for (int i=0; i < events.length; i++) {
//                    inboxStyle.addLine(events[i]);
//                }
//                mBuilder.setStyle(inboxStyle);

                // Định nghĩa hành ododnjg sẽ thực hiện khi người dùng bấm Thông báo
                Intent resultIntent = new Intent( Noti_Activity.this, Noti_Display.class);
                PendingIntent resultPendingIntent = PendingIntent.getActivity( Noti_Activity.this, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT );
                mBuilder.setContentIntent(resultPendingIntent);

                notificationManager.notify(9999, mBuilder.build());


            }
        });
    }
}