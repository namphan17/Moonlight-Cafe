package com.cornellcollege.android.moonlightcafe.LoginActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cornellcollege.android.moonlightcafe.R;

public class Login extends AppCompatActivity {

    private Button login;
    private EditText userEmail;
    private EditText userPassword;
    private TextView register;
    private TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userEmail = (EditText) findViewById(R.id.login_id);
        userPassword = (EditText) findViewById(R.id.login_password);
        login = (Button) findViewById(R.id.login);
        register = (TextView) findViewById(R.id.register);
        forgotPassword = (TextView) findViewById(R.id.forgot_password);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, Register.class);
                startActivity(i);
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, ForgotPassword.class);
                startActivity(i);
            }
        });


    }
}