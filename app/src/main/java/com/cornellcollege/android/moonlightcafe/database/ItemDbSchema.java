package com.cornellcollege.android.moonlightcafe.database;

/**
 * Created by Tibuchuba on 9/21/2015.
 */
public class ItemDbSchema {
    public static final class ItemTable {
        public static final String NAME = "items";
        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String NAME = "name";
            public static final String PRICE = "price";
            public static final String RESID = "resId";
        }
    }
}
