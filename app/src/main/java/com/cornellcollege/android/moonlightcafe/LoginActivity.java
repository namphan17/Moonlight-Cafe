package com.cornellcollege.android.moonlightcafe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by akashsurti on 9/19/15.
 */

public class LoginActivity extends AppCompatActivity {

    private Button login;
    private EditText userEmail;
    private EditText userPassword;
    private TextView register;
    private TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        new GcmRegistrationAsyncTask(this).execute();

        userEmail = (EditText) findViewById(R.id.login_id);
        userPassword = (EditText) findViewById(R.id.login_password);
        login = (Button) findViewById(R.id.login);
        register = (TextView) findViewById(R.id.register);
        forgotPassword = (TextView) findViewById(R.id.forgot_password);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Register.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ForgotPassword.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });
    }


    public void login(View view) {

        // Correct password
        if (userEmail.getText().toString().equals("admin") && userPassword.getText().toString().equals("admin")) {

        // Wrong password
        } else {

        }

        // Counter to keep track of incorrect attempts
        int counter = 3;
        counter--;

        if(counter==0){

        }

    }
}
