package com.cornellcollege.android.moonlightcafe.LoginActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cornellcollege.android.moonlightcafe.MenuActivity;
import com.cornellcollege.android.moonlightcafe.R;
import com.cornellcollege.android.moonlightcafe.logindata.LoginData;
import com.cornellcollege.android.moonlightcafe.logindata.LoginUser;

/**
 * Activity used  to login to the page
 */
public class Login extends AppCompatActivity {

    private Button login;
    private EditText userEmail;
    private EditText userPassword;
    private TextView register;
    private TextView forgotPassword;

    private String username;
    private String password;

    private String fetchPassword;

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

        userEmail = (EditText) findViewById(R.id.login_id);
        userEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                username = userEmail.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        userPassword = (EditText) findViewById(R.id.login_password);
        userPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                password = userPassword.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, MenuActivity.class);
                LoginData log = LoginData.get(Login.this);
                LoginUser user = log.getLogin(username);
                fetchPassword = user.getPassword();
                if(password.equals(fetchPassword)){
                    startActivity(i);
                } else {
                    Toast.makeText(Login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}