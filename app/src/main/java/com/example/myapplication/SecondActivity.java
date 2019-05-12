package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private EditText mEditText;
    public static final String SECOND_EDIT_TEXT_VALUE = "second_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        if (intent != null){
            String text = (String) intent.getSerializableExtra(MainActivity.EDIT_TEXT_VALUE);
            mEditText = (EditText) findViewById(R.id.secondActivityEditText);
            mEditText.setText(text);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra(SECOND_EDIT_TEXT_VALUE, mEditText.getText().toString());
        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }

}
