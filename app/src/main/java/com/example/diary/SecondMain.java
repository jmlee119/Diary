package com.example.diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SecondMain extends AppCompatActivity {
    TextView todaydate;
    private DBHelper mDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
//        todaydate =(TextView) findViewById(R.id.todayDate);
//        todaydate.setText(getTime());
        mDBHelper = new DBHelper(this);
        TextView date = findViewById(R.id.date);
        Button bt_save = findViewById(R.id.bt_save);
        EditText title = findViewById(R.id.title);
        EditText content = findViewById(R.id.content);

        Intent intent = getIntent();
        date.setText(intent.getStringExtra("SelectedDate"));

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentTime = new SimpleDateFormat("yyyy-M-dd").format(new Date()) ;
                // 현재 시간 받기
                mDBHelper.insertdiary(title.getText().toString(), content.getText().toString() ,currentTime);

                // insert UI


            }
        });


    }
}