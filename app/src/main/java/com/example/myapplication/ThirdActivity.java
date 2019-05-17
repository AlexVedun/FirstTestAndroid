package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {

    private EditText mEditText;
    public static final String THIRD_EDIT_TEXT_VALUE = "third_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent intent = getIntent();
        if (intent != null){
            String text = (String) intent.getSerializableExtra(MainActivity.EDIT_TEXT_VALUE);
            mEditText = (EditText) findViewById(R.id.thirdActivityTextEdit);
            mEditText.setText(text);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra(THIRD_EDIT_TEXT_VALUE, mEditText.getText().toString());
        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }
}
