package com.cornellcollege.android.moonlightcafe.LoginActivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.cornellcollege.android.moonlightcafe.R;


/**
 * Created by akashsurti on 9/21/15.
 */
public class Register extends Activity{

    private Button cancel;
    private Button signup;
    private EditText firstName;
    private EditText lastName;
    private EditText cornellId;
    private EditText password;
    private EditText repassword;
    private EditText securityAnswer;
    private Spinner securityQuestion;
    private TextView userId;

    private String username;
    private String fname;
    private String lname;
    private String email;
    private String secureAnswer;
    private String secureQuestion;
    private String finalpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Register.this, Login.class);
                startActivity(i);
            }
        });

        signup = (Button) findViewById(R.id.sign_up);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Register.this, Login.class);
                startActivity(i);
            }
        });

        firstName = (EditText) findViewById(R.id.first_name);
        firstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        lastName = (EditText) findViewById(R.id.last_name);
        lastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        cornellId = (EditText) findViewById(R.id.cornell_email);
        cornellId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        userId = (TextView) findViewById(R.id.username);
        userId.setText(username);

        password = (EditText) findViewById(R.id.password1);
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        repassword = (EditText) findViewById(R.id.password2);
        repassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        securityQuestion = (Spinner)findViewById(R.id.security_spinner);
        String[] items = new String[]{"What was your childhood nickname?", "What is the name of your best childhood friend?", "In what city did your mother and father meet?",
                "What is your favorite team?", "What is your favorite movie?", "What was your favorite sport in high school?", "What was your favorite food as a child?",
                "What is the first name of your first kiss?", "What was the make and model of your first car?", "Who is your childhood sports hero?",
                "In what town was your first job?"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        securityQuestion.setAdapter(adapter);

        securityAnswer = (EditText) findViewById(R.id.security_answer);
        securityAnswer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}
