package com.berbageek.berbageek1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "EXTRA_NAME";

    TextView secondTextField;
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        secondTextField = findViewById(R.id.second_text_field);

        if (getIntent() != null) {
            // get EXTRA_NAME from intent
            if (getIntent().hasExtra(EXTRA_NAME)) {
                name = getIntent().getStringExtra(EXTRA_NAME);
            }
        }

        if (!TextUtils.isEmpty(name)) {
            secondTextField.setText("extra = " + name);
        } else {
            secondTextField.setText(R.string.hello_world);
        }
    }
}
