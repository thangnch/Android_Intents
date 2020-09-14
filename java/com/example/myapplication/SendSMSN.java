package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class SendSMSN extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_s_m_s_n);

        Button btnsendSMS = findViewById(R.id.btnSendSMS);
        btnsendSMS.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Thuc hien gui tin nhan SMS

                checkPermission();

            }
        });
    }

    // Kiểm tra permision đúng theo flow
    void checkPermission()
    {

            // Nếu HDH hiện tại lớn hơn hoặc bằng Android M
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                int hasSMSPermission = checkSelfPermission(Manifest.permission.SEND_SMS);
                int hasRSMS = checkSelfPermission(Manifest.permission.RECEIVE_SMS);

                List<String> permissions = new ArrayList<String>();

                if (hasSMSPermission != PackageManager.PERMISSION_GRANTED) {
                    permissions.add(Manifest.permission.SEND_SMS);
                }
                if (hasRSMS != PackageManager.PERMISSION_GRANTED) {
                    permissions.add(Manifest.permission.RECEIVE_SMS);
                }

                if (!permissions.isEmpty()) {
                    requestPermissions(permissions.toArray(new String[permissions.size()]), 9999);
                }
                else
                {
                    sendSMS();
                }
            }
            else {
                sendSMS();
            }

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch ( requestCode ) {
            case 9999: {

                int hasSMSPermission = checkSelfPermission(Manifest.permission.SEND_SMS);
                if (hasSMSPermission == PackageManager.PERMISSION_GRANTED)
                {
                    sendSMS();
                }
            }
            break;
            default: {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }
    }
    // Gui tin nhắn sau khi đã được cấp phép
    void sendSMS()
    {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("5556",
                null, "I love you",
                null, null);
    }
}