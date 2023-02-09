package com.example.diary;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION =1;
    private static final String DB_NAME = "diray.db";
    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 데이터 베이스가 생성이 될때 호출

        // 데이터베이스 -> 테이블 -> 컬럼 -> 값
        db.execSQL("CREATE TABLE IF NOT EXISTS Detail (id Integer PRIMARY KEY AUTOINCREMENT, title TEXT, content TEXT,writeDate TEXT NOT NULL )");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    // select 문 (일기 조회)
    public ArrayList<Detailitem> getDetail() {
        ArrayList<Detailitem> detailitems =  new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Detail ORDER BY writeDate DESC",null);
        if (cursor.getCount() !=0 ) {
            //조회온 데이터가 있을때
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                String content = cursor.getString(cursor.getColumnIndexOrThrow("content"));
                String writeDate = cursor.getString(cursor.getColumnIndexOrThrow("writeDate"));

                Detailitem detailitem = new Detailitem();
                detailitem.setId(id);
                detailitem.setTitle(title);
                detailitem.setContent(content);
                detailitem.setWriteDate(writeDate);
                detailitems.add(detailitem);

            }
        }
        cursor.close();
        return detailitems;
    }

    public void insertdiary (String _title, String _content, String _writeDate)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO Detail(title , content, writeDate) VALUES('" + _title +"' ,'" + _content +"' ,'" + _writeDate +"'  ); ");
    }
    public void updatediary (String _title, String _content , String _writeDate, int _id) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE Detail SET title='" + _title + " ', content='" + _content + " ', writeDate='" + _writeDate + " ' WHERE id = '" +_id+"'");
    }
    public void deletediary(int _id) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM Detail Where id= '" + _id +"'");
    }
}
