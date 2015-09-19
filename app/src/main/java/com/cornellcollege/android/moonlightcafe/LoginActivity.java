package com.cornellcollege.android.moonlightcafe;

import android.view.View;
import android.widget.EditText;

/**
 * Created by akashsurti on 9/19/15.
 */

public class LoginActivity {
    EditText username = (EditText) findViewById(R.id.login_id);
    EditText password = (EditText) findViewById(R.id.login_password);
    public void login(View view){

        // Correct password
        if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){

        // Wrong password
        } else{

        }
}
