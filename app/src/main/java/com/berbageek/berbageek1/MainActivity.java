package com.berbageek.berbageek1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    EditText mainInputField;
    Button mainButton;
    ImageView mainImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bind layout id to variable
        mainInputField = (EditText) findViewById(R.id.main_input);
        mainButton = (Button) findViewById(R.id.main_button);
        mainImage = (ImageView) findViewById(R.id.main_image);

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

        // load image into image view
        Picasso.with(MainActivity.this)
                .load("http://berbagaigadget.com/wp-content/uploads/2016/02/100-Gambar-dp-bbm-kucing-lucu-dan-gemesin-7.jpg")
//                .load(R.drawable.ic_home_black_48dp)
                .into(mainImage);
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
        mainInputField.setText("Dari Relative Layout Button");
    }
}
