package com.example.diary;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        TextView day_text = findViewById(R.id.day_text);

        TextView todaydate =(TextView) findViewById(R.id.day_text);
        todaydate.setText(getTime());
        //   오늘 날짜 부르는 법

            CalendarView calenderView = findViewById(R.id.calenderView);
        Button button= findViewById(R.id.btn);
        calenderView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                day_text.setVisibility(View.VISIBLE);
                day_text.setText(String.format("%d년 %d월 %d일",year,month+1,dayOfMonth));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SecondMain.class);
                SimpleDateFormat dateFormat = new SimpleDateFormat();
                String date = ""+day_text.getText();
                intent.putExtra("SelectedDate",date);
                startActivity(intent);
            }
        });

    }
    private String getTime() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 M월 d일");
        String getTime = dateFormat.format(date);
        return getTime;
    }

}
