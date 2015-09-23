package com.cornellcollege.android.moonlightcafe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tibuchuba.android.moonlightcafe.database.ItemBaseHelper;
import com.tibuchuba.android.moonlightcafe.database.ItemCursorWrapper;
import com.tibuchuba.android.moonlightcafe.database.ItemDbSchema.ItemTable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Tibuchuba on 9/21/2015.
 */
public class ItemLab {

    private static ItemLab sItemLab;
    private List<Item> mItems;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    // Assistant to write and update database
    private static ContentValues getContentValues(Item item) {
        ContentValues values = new ContentValues();
        values.put(ItemTable.Cols.UUID, item.getId().toString());
        values.put(ItemTable.Cols.NAME, item.getName());
        values.put(ItemTable.Cols.PRICE, item.getPrice());
        values.put(ItemTable.Cols.RESID, item.getLayoutResId());


        return values;
    }

    // Querying
    private ItemCursorWrapper queryItems(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                ItemTable.NAME,
                null, // select *
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null // order by
        );
        return new ItemCursorWrapper(cursor);
    }


    public static ItemLab get(Context context) {
        if (sItemLab == null) {
            sItemLab = new ItemLab(context);
        }
        return sItemLab;
    }

    private ItemLab(Context context) {
        mItems = MenuGenerator.itemsForMenu();

        mContext = context.getApplicationContext();
        mDatabase = new ItemBaseHelper(mContext)
                .getWritableDatabase();
//
//        for (Item item : mItems) {
//            this.addItem(item);
//        }

    }

    public List<Item> getItems() {

//        ItemCursorWrapper cursor = queryItems(null, null);
//
//        try {
//            cursor.moveToFirst();
//            while (!cursor.isAfterLast()) {
//                mItems.add(cursor.getItem());
//                cursor.moveToNext();
//            }
//        } finally {
//            cursor.close();
//        }
        return mItems;
    }

    public Item getItem(UUID id) {
        /**
         * for (Item item : mItems) {
         *  if (item.getId().equals(id) {
         *      return item;
         *  }
         *  return null;
         * }
         */
        for (Item item : mItems) {
            if (item.getId().equals(id)) {
                return item;
            }
        }

//        ItemCursorWrapper cursor = queryItems(
//                ItemTable.Cols.UUID + " = ?",
//                new String[]{id.toString()}
//        );
//        try {
//            if (cursor.getCount() == 0) {
//                return null;
//            }
//            cursor.moveToFirst();
//            return cursor.getItem();
//        } finally {
//            cursor.close();
//        }

        return null;
    }


    // Not sure if this works
    public Item getItem(String name) {
//        ItemCursorWrapper cursor = queryItems(
//                ItemTable.Cols.NAME + " = ?",
//                new String[]{name}
//        );
//        try {
//            if (cursor.getCount() == 0) {
//                return null;
//            }
//            cursor.moveToFirst();
//            return cursor.getItem();
//        } finally {
//            cursor.close();
//        }
        for (Item item : mItems) {
            if (item.getName().equals(name)) {
                return item;
            }
        }

        return null;
    }

    // Update Item
    public void updateItem(Item item) {
        String uuidString = item.getId().toString();
        ContentValues values = getContentValues(item);
        mDatabase.update(ItemTable.NAME, values,
                ItemTable.Cols.UUID + " =?",
                new String[]{uuidString});
    }
    public void addItem(Item item) {
        ContentValues values = getContentValues(item);
        mDatabase.insert(ItemTable.NAME, null, values);
    }
}
