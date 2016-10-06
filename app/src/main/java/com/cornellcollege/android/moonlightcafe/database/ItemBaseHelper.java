package com.cornellcollege.android.moonlightcafe.database;

/**
 * Created by Tibuchuba on 9/21/2015.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



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
        db.execSQL("create table " + ItemDbSchema.ItemTable.NAME + "(" +
                        " _id integer primary key autoincrement, " +
                        ItemDbSchema.ItemTable.Cols.UUID + ", " +
                        ItemDbSchema.ItemTable.Cols.NAME + ", " +
                        ItemDbSchema.ItemTable.Cols.PRICE + ", " +
                        ItemDbSchema.ItemTable.Cols.RESID +
                        ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}

