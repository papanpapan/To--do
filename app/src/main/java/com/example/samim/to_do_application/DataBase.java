package com.example.samim.to_do_application;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SAMIM on 10/10/2017.
 */

public class DataBase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="detail.db";
    public static final String TABLE_NAME="detail";




    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, 1);

        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME + " (KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT,KEY_DESCRIPTION TEXT,KEY_TITEL TEXT,KEY_DATE TEXT,KEY_STATUS INTEGER" );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_NAME);
        onCreate(db);

    }
    public boolean insertDeta(String Description,String Titel,String Date,Integer Status){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValus =new ContentValues();
        contentValus.put("KEY_DESCRIPTION",Description);
        contentValus.put("KEY_TITEL",Titel);
        contentValus.put("KEY_DATE",Date);
        contentValus.put("KEY_STATUS",Status);

        long result=db.insert(TABLE_NAME,null,contentValus);
        if (result==-1)
            return false;
            else
             return true;

        }

    }

