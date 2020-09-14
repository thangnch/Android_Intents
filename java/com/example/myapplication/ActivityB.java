package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        Intent intent = getIntent();
        String text = intent.getStringExtra("Message");
//        int count = intent.getIntExtra("Count",0);



        TextView txtMessage = findViewById(R.id.txtMessage);
        txtMessage.setText(text);
    }
}