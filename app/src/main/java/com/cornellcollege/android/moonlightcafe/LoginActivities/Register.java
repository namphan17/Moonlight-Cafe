package com.cornellcollege.android.moonlightcafe.LoginActivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by akashsurti on 9/21/15.
 */

import com.cornellcollege.android.moonlightcafe.R;
import com.cornellcollege.android.moonlightcafe.logindata.LoginData;
import com.cornellcollege.android.moonlightcafe.logindata.LoginUser;

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

    private TextView firstNameError;
    private TextView lastNameError;
    private TextView emailEmptyError;
    private TextView emailInvalidError;
    private TextView emailAlreadyUsedError;
    private TextView differentPasswordError;
    private TextView securityAnswerError;

    private String username;
    private String fname;
    private String lname;
    private String email;
    private String secureAnswer;
    private String secureQuestion;
    private String finalpassword;

    private String temp_pass = "random";
    private String temp_pass2 = "random1";

    private boolean registerComplete = false;

    private boolean firstError = false;
    private boolean lastError = false;
    private boolean emptyError = false;
    private boolean invalidError = false;
    private boolean alreadyError = true;
    private boolean differentError = false;
    private boolean securityError = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstNameError = (TextView) findViewById(R.id.firstname_error);
        lastNameError = (TextView) findViewById(R.id.lastname_error);
        emailEmptyError = (TextView) findViewById(R.id.email_empty_error);
        emailInvalidError = (TextView) findViewById(R.id.email_incorrect_error);
        emailAlreadyUsedError = (TextView) findViewById(R.id.already_exists_error);
        differentPasswordError = (TextView) findViewById(R.id.password_doesnt_match);
        securityAnswerError = (TextView) findViewById(R.id.security_error);


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

                if(firstError && lastError && emptyError && invalidError && alreadyError && differentError && securityError){
                    registerComplete = true;
                }

                if (registerComplete) {
                    Intent i = new Intent(Register.this, Login.class);
                    LoginData log = LoginData.get(Register.this);
                    LoginUser loginUser = new LoginUser();
                    loginUser.setUsername(username);
                    loginUser.setEmail(email);
                    loginUser.setLname(lname);
                    loginUser.setFname(fname);
                    loginUser.setSecureAnswer(secureAnswer);
                    loginUser.setSecureQuestion(secureQuestion);
                    loginUser.setPassword(finalpassword);
                    log.addLogin(loginUser);
                    startActivity(i);
                } else {
                    Toast.makeText(Register.this, "Registration is Incomplete!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        firstName = (EditText) findViewById(R.id.first_name);
        firstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (firstName.getText().length() == 0) {
                    firstNameError.setVisibility(View.VISIBLE);
                    firstError = false;
                } else {
                    firstNameError.setVisibility(View.GONE);
                    firstError = true;
                    fname = firstName.getText().toString();
                }
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
                if(lastName.getText().length() == 0){
                    lastNameError.setVisibility(View.VISIBLE);
                    lastError = false;
                } else {
                    lastNameError.setVisibility(View.GONE);
                    lastError = true;
                    lname = lastName.getText().toString();
                }
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
                if (cornellId.getText().length() == 0) {
                    emailEmptyError.setVisibility(View.VISIBLE);
                    emailInvalidError.setVisibility(View.GONE);
                    emptyError = false;
                    return;
                } else {
                    emailEmptyError.setVisibility(View.GONE);
                    emptyError = true;
                    email = cornellId.getText().toString();

                    String validemail = "cornellcollege.edu";

                    if (email.contains(validemail)) {
                        invalidError = true;
                        emailInvalidError.setVisibility(View.GONE);

                        String extra = email;
                        String another = extra.replace("@cornellcollege.edu", "");
                        username = another;
                        userId = (TextView) findViewById(R.id.username);
                        userId.setText(username);

                    } else {
                        invalidError = false;
                        emailInvalidError.setVisibility(View.VISIBLE);
                        return;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        password = (EditText) findViewById(R.id.password1);
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                temp_pass = password.getText().toString();
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

                temp_pass2 = repassword.getText().toString();

                if (temp_pass.equals(temp_pass2)) {
                    differentPasswordError.setVisibility(View.GONE);
                    differentError = true;
                    finalpassword = repassword.getText().toString();
                } else {
                    differentPasswordError.setVisibility(View.VISIBLE);
                    differentError = false;
                }
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

        securityQuestion.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        secureQuestion = securityQuestion.getSelectedItem().toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        secureQuestion = securityQuestion.getSelectedItem().toString();
                    }
                }
        );

        securityAnswer = (EditText) findViewById(R.id.security_answer);
        securityAnswer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (securityAnswer.getText().length() == 0) {
                    securityAnswerError.setVisibility(View.VISIBLE);
                    securityError = false;
                } else {
                    securityAnswerError.setVisibility(View.GONE);
                    securityError = true;
                    secureAnswer = securityAnswer.getText().toString();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}
