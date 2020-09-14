package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        Button btnSendSMS = findViewById(R.id.btnMove);
        btnSendSMS.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ActivityA.this, ActivityB.class);
                intent.putExtra("Message", "Will you marry me?");
                intent.putExtra("Count", 1);
                startActivity(intent);


                //
            }
        });
    }
}