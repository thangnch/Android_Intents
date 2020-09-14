package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.PendingIntent;
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

public class SendSMS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);


        Button btnSendSMS = findViewById(R.id.btnSendSMS);
        btnSendSMS.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                checkPermission();
            }
        });


    }

    void checkPermission()
    {
        // Send SMS to 5556

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
                for( int i = 0; i < permissions.length; i++ ) {
                    if( grantResults[i] == PackageManager.PERMISSION_GRANTED ) {
                        Log.d( "Permissions", "Permission Granted: " + permissions[i] );
                    } else if( grantResults[i] == PackageManager.PERMISSION_DENIED ) {
                        Log.d( "Permissions", "Permission Denied: " + permissions[i] );
                    }
                }
                int hasSMSPermission = checkSelfPermission(Manifest.permission.SEND_SMS);
                if (hasSMSPermission== PackageManager.PERMISSION_GRANTED)
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

    void sendSMS()
    {
//        PendingIntent pi = PendingIntent.getActivity(this, 0,
//                new Intent(this, SendSMS.class), 0);
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("5556", null, "I love you", null, null);


//        Uri uri = Uri.parse("smsto:5556");
//        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
//        it.putExtra("sms_body", "Here you can set the SMS text to be sent");
//        startActivity(it);

        Log.d("Ok","Send roi ne");
    }


}