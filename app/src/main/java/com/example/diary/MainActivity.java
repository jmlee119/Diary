package com.example.diary;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_diary;
    private FloatingActionButton btn_write;
    private ArrayList<Detailitem> detailitems;
    private DBHelper mDBHelper;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setInit();
    }

    private void setInit() {
        mDBHelper = new DBHelper(this);
        detailitems = new ArrayList<>();

    }


}
