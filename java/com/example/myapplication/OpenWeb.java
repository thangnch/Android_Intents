package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OpenWeb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_web);

        Button btnSendSMS = findViewById(R.id.btnOpenWeb);
        btnSendSMS.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

//                // Chia sẻ
//                Intent sendIntent = new Intent();
//                sendIntent.setAction(Intent.ACTION_SEND);
//                sendIntent.putExtra(Intent.EXTRA_TEXT,
//                        "Hey check out my app at: https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID);
//                sendIntent.setType("text/plain");
//                startActivity(sendIntent);
//
//                // Mở web
//                Intent i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.fithou.edu.vn/"));
//                startActivity(i1);

                // Gọi điện
                Intent i2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:5556"));
                startActivity(i2);

            }
        });
    }
}