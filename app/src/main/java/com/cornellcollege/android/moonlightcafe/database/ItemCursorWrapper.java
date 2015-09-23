package com.cornellcollege.android.moonlightcafe.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.tibuchuba.android.moonlightcafe.Item;

import java.util.UUID;

/**
 * Created by Tibuchuba on 9/21/2015.
 */
public class ItemCursorWrapper extends CursorWrapper {
    public ItemCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Item getItem() {

        String uuidString = getString(getColumnIndex(ItemDbSchema.ItemTable.Cols.UUID));
        String name = getString(getColumnIndex(ItemDbSchema.ItemTable.Cols.NAME));
        double price = getDouble(getColumnIndex(ItemDbSchema.ItemTable.Cols.PRICE));
        int resId = getInt(getColumnIndex(ItemDbSchema.ItemTable.Cols.RESID));
        Item item = new Item(UUID.fromString(uuidString), name);
        item.setPrice(price);
        item.setLayoutResId(resId);

        return item;
    }
}
