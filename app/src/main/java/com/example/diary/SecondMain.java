package com.example.diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SecondMain extends AppCompatActivity {
    TextView todaydate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        todaydate =(TextView) findViewById(R.id.todayDate);
//        todaydate.setText(getTime());
        TextView date = findViewById(R.id.date);
        Intent intent = getIntent();
        date.setText(intent.getStringExtra("SelectedDate"));
    }
}