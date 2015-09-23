package com.cornellcollege.android.moonlightcafe;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by akashsurti on 9/21/15.
 */
public class Register extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Spinner dropdown = (Spinner)findViewById(R.id.security_spinner);
        String[] items = new String[]{"What was your childhood nickname?", "What is the name of your best childhood friend?", "In what city did your mother and father meet?",
                "What is your favorite team?", "What is your favorite movie?", "What was your favorite sport in high school?", "What was your favorite food as a child?",
                "What is the first name of your first kiss?", "What was the make and model of your first car?", "Who is your childhood sports hero?",
                "In what town was your first job?"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

    }
}
