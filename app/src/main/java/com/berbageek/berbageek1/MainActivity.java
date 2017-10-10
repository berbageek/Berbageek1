package com.berbageek.berbageek1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_NAME_VALUE = "NAME_VALUE";
    private static final String TAG = "MainActivity";
    EditText mainInputField;
    Button mainButton;
    Button mainToSecondButton;
    ImageView mainImage;

    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: called");
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            name = savedInstanceState.getString(KEY_NAME_VALUE, "");
        }
        Log.d(TAG, "onCreate: name = " + name);

        // bind layout id to variable
        mainInputField = (EditText) findViewById(R.id.main_input);
        mainButton = (Button) findViewById(R.id.main_button);
        mainImage = (ImageView) findViewById(R.id.main_image);
        mainToSecondButton = findViewById(R.id.main_to_second_button);

        // set OnClickListener for mainButton
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get input text
                final String inputText = mainInputField.getText().toString();
                // check input text content
                if (!TextUtils.isEmpty(inputText)) {
                    showToastMessage("Hello " + inputText);
                } else {
                    showToastMessage("Hello World");
                }
            }
        });

        mainToSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(SecondActivity.EXTRA_NAME, name);
                startActivity(intent);
            }
        });

        // load image into image view
        Picasso.with(MainActivity.this)
                .load("http://berbagaigadget.com/wp-content/uploads/2016/02/100-Gambar-dp-bbm-kucing-lucu-dan-gemesin-7.jpg")
                .placeholder(R.drawable.ic_home_black_48dp)
                .error(R.drawable.ic_broken_image_black_48dp)
                .into(mainImage);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: called");
        Log.v(TAG, "onResume: verbose");
        Log.w(TAG, "onResume: warning");
        Log.e(TAG, "onResume: error", null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: called");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(KEY_NAME_VALUE, name);
        super.onSaveInstanceState(outState);
    }

    private void showToastMessage(String message) {
        Toast.makeText(
                MainActivity.this,
                message,
                Toast.LENGTH_SHORT
        ).show();
    }

    // onClick method for R.id.relative_button
    public void relativeTest(View view) {
        name = mainInputField.getText().toString();
        Log.d(TAG, "relativeTest: name = " + name);
    }
}
