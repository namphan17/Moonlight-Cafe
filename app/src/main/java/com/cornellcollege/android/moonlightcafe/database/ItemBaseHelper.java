package com.cornellcollege.android.moonlightcafe.database;

/**
 * Created by Tibuchuba on 9/21/2015.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tibuchuba.android.moonlightcafe.database.ItemDbSchema.ItemTable;

/**
 * Created by Tibuchuba on 9/9/2015.
 */
public class ItemBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "itemBase.db";

    public ItemBaseHelper(Context context) {

        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table " + ItemTable.NAME + "(" +
                        " _id integer primary key autoincrement, " +
                        ItemTable.Cols.UUID + ", " +
                        ItemTable.Cols.NAME + ", " +
                        ItemTable.Cols.PRICE + ", " +
                        ItemTable.Cols.RESID +
                        ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}

