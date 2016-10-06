package com.cornellcollege.android.moonlightcafe.logindata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cornellcollege.android.moonlightcafe.Item;
import com.cornellcollege.android.moonlightcafe.MenuGenerator;
import com.cornellcollege.android.moonlightcafe.logindata.LoginDbSchema.LoginTable;

/**
 * Class Used to input and query user information into the database
 */
public class LoginData {
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static LoginData sLoginData;


    private static ContentValues getContentValues(LoginUser loginUser) {
        ContentValues values = new ContentValues();
        values.put(LoginTable.Cols.USERNAME, loginUser.getUsername());
        values.put(LoginTable.Cols.FNAME, loginUser.getFname());
        values.put(LoginTable.Cols.LNAME, loginUser.getLname());
        values.put(LoginTable.Cols.EMAIL, loginUser.getEmail());
        values.put(LoginTable.Cols.SECURE_ANS, loginUser.getSecureAnswer());
        values.put(LoginTable.Cols.SECURE_QUES, loginUser.getSecureQuestion());
        values.put(LoginTable.Cols.PASSWORD, loginUser.getPassword());
        return values;
    }

    private LoginCursorWrapper queryLogins(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                LoginDbSchema.LoginTable.NAME,
                null, // select *
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null // order by
        );
        return new LoginCursorWrapper(cursor);
    }

// returns login information
    public static LoginData get(Context context) {
        if (sLoginData == null) {
            sLoginData = new LoginData(context);
        }
        return sLoginData;
    }

    private LoginData(Context context) {

        mContext = context.getApplicationContext();
        mDatabase = new LoginBaseHelper(mContext)
                .getWritableDatabase();
    }

    public LoginUser getLogin(String username) {
        LoginCursorWrapper cursor = queryLogins(
                LoginTable.Cols.USERNAME + " = ?",
                new String[]{username}
        );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getLogin();
        } finally {
            cursor.close();
        }
    }
    // Update Item
    public void updateItem(LoginUser loginUser) {
        String username = loginUser.getUsername();
        ContentValues values = getContentValues(loginUser);
        mDatabase.update(LoginTable.NAME, values,
                LoginTable.Cols.USERNAME + " =?",
                new String[]{username});
    }
    public void addLogin(LoginUser loginUser) {
        ContentValues values = getContentValues(loginUser);
        mDatabase.insert(LoginDbSchema.LoginTable.NAME, null, values);
    }
}
