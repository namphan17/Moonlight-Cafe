package com.cornellcollege.android.moonlightcafe.LoginActivities;

import android.app.Activity;
import android.content.Intent;
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

import org.w3c.dom.Text;

/**
 * Created by akashsurti on 9/21/15.
 */
public class ForgotPassword extends Activity {

    private Button cancel;
    private Button next;
    private EditText firstName;
    private EditText lastName;
    private EditText cornellId;
    private EditText securityAnswer;
    private TextView securityQuestion;
    private EditText userId;

    private String username;
    private String fname;
    private String lname;
    private String email;
    private String secureAnswer;
    private String secureQuestion;

    private String fetchFname;
    private String fetchLname;
    private String fetchmail;
    private String fetchQuestion;
    private String fetchAnswer;

    private boolean complete = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        userId = (EditText) findViewById(R.id.username);
        userId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                username = userId.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        firstName = (EditText) findViewById(R.id.first_name);
        firstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                fname = firstName.getText().toString();

                LoginData log = LoginData.get(ForgotPassword.this);
                LoginUser user = log.getLogin(username);
                fetchQuestion = user.getSecureQuestion();

                securityQuestion = (TextView) findViewById(R.id.security_question);
                secureQuestion = fetchQuestion;
                securityQuestion.setText(secureQuestion);
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
                lname = lastName.getText().toString();
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
                email = cornellId.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        securityAnswer = (EditText) findViewById(R.id.security_answer);
        securityAnswer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                secureAnswer = securityAnswer.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ForgotPassword.this, Login.class);
                startActivity(i);
            }
        });

        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginData log = LoginData.get(ForgotPassword.this);
                LoginUser user = log.getLogin(username);
                fetchFname = user.getFname();
                fetchLname = user.getLname();
                fetchAnswer = user.getSecureAnswer();
                fetchmail = user.getEmail();

                if (secureAnswer.equals(fetchAnswer) && email.equals(fetchmail) && fname.equals(fetchFname) && lname.equals(fetchLname)) {
                    complete = true;
                } else {
                    complete = false;
                }

                if (complete) {
                    Intent i = new Intent(ForgotPassword.this, MenuActivity.class);
                    Toast.makeText(ForgotPassword.this, "Congrates you have crakced the code!", Toast.LENGTH_SHORT).show();
                    startActivity(i);
                } else {
                    Toast.makeText(ForgotPassword.this, "You aren't breaking past this firewall", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
