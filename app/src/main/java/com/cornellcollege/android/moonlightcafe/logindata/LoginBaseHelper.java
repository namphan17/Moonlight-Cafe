package com.cornellcollege.android.moonlightcafe.logindata;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Helper class used to create database for login information
 */
public class LoginBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "loginBase.db";

    public LoginBaseHelper(Context context) {

        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table " + LoginDbSchema.LoginTable.NAME + "(" +
                        " _id integer primary key autoincrement, " +
                        LoginDbSchema.LoginTable.Cols.USERNAME + ", " +
                        LoginDbSchema.LoginTable.Cols.FNAME + ", " +
                        LoginDbSchema.LoginTable.Cols.LNAME + ", " +
                        LoginDbSchema.LoginTable.Cols.EMAIL + ", " +
                        LoginDbSchema.LoginTable.Cols.SECURE_ANS + ", " +
                        LoginDbSchema.LoginTable.Cols.SECURE_QUES + ", " +
                        LoginDbSchema.LoginTable.Cols.PASSWORD +
                        ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
