package com.cornellcollege.android.moonlightcafe.logindata;

import android.database.Cursor;
import android.database.CursorWrapper;


/**
 * Created by Tibuchuba on 9/23/2015.
 */
public class LoginCursorWrapper extends CursorWrapper {

    public LoginCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public LoginUser getLogin() {

        String username = getString(getColumnIndex(LoginDbSchema.LoginTable.Cols.USERNAME));
        String fname = getString(getColumnIndex(LoginDbSchema.LoginTable.Cols.FNAME));
        String lname = getString(getColumnIndex(LoginDbSchema.LoginTable.Cols.LNAME));
        String email = getString(getColumnIndex(LoginDbSchema.LoginTable.Cols.EMAIL));
        String secureAns = getString(getColumnIndex(LoginDbSchema.LoginTable.Cols.SECURE_ANS));
        String secureQues = getString(getColumnIndex(LoginDbSchema.LoginTable.Cols.SECURE_QUES));
        String password = getString(getColumnIndex(LoginDbSchema.LoginTable.Cols.PASSWORD));

        LoginUser loginUser = new LoginUser();
        loginUser.setUsername(username);
        loginUser.setFname(fname);
        loginUser.setLname(lname);
        loginUser.setEmail(email);
        loginUser.setSecureAnswer(secureAns);
        loginUser.setSecureQuestion(secureQues);
        loginUser.setPassword(password);

        return loginUser;
    }
}
