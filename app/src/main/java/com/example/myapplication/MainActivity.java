package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    String beforeString = "",afterString = "";
    int beforeIndex = 0, afterIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText =findViewById(R.id.edit);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                beforeString = editText.getText().toString().trim();
                beforeIndex = editText.getSelectionStart();
                Log.d(TAG, "beforeTextChanged: this string :" + beforeString + " - - this is index: " + beforeIndex);
                Log.d(TAG, "beforeTextChanged: this start :" + start + " - - this is count: " + count + " - - this is after: " + after);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                Log.d(TAG, "onTextChanged: this start :" + start + " - - this is count: " + count + " - - this is before: " + before);


            }

            @Override
            public void afterTextChanged(Editable s) {


                afterString = editText.getText().toString().trim();
                afterIndex = editText.getSelectionStart();
                Log.d(TAG, "afterTextChanged: this string :" + afterString + " - - this is index: " + afterIndex);



                // 如果数字相同时
                if (!StringUtils.touzi_ed_values22.equals(editText.getText().toString().trim().replaceAll(",",""))) {
                    editText.setText(StringUtils.addComma(editText.getText().toString().trim().replaceAll(",",""),editText));
                    //editText.setSelection(StringUtils.addComma(editText.getText().toString().trim().replaceAll(",",""),editText).length());
                }
                // 如果数字相同，但是字符串不同


            }
        });
    }
}