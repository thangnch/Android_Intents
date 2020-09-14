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

public class CallPhone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_phone);

        Button btnCall = findViewById(R.id.btnCallPhone);
        btnCall.setOnClickListener(new View.OnClickListener() {
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
            int hasCallPhone = checkSelfPermission(Manifest.permission.CALL_PHONE);
            int hasRCallPhone = checkSelfPermission(Manifest.permission.READ_PHONE_STATE);

            List<String> permissions = new ArrayList<String>();

            if (hasCallPhone != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.CALL_PHONE);
            }

            if (hasRCallPhone != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.READ_PHONE_STATE);
            }


            if (!permissions.isEmpty()) {
                requestPermissions(permissions.toArray(new String[permissions.size()]), 9999);
            }
            else
            {
                call();
            }
        }
        else {
            call();
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
                int hasCallPhone = checkSelfPermission(Manifest.permission.CALL_PHONE);
                if (hasCallPhone== PackageManager.PERMISSION_GRANTED)
                {
                    call();
                }
            }
            break;
            default: {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }
    }

    void call()
    {

        Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:5556"));
        startActivity(i);
    }
}