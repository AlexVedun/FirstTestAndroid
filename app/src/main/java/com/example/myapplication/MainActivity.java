package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    private Button mButton;
    private Button mButton2;
    public static final String EDIT_TEXT_VALUE = "text";
    public static final int SECOND_ACTIVITY_REQUEST = 0;
    public static final int THIRD_ACTIVITY_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.mainActivityEditText);
        mButton = (Button) findViewById(R.id.mainActivityButton);
        mButton2 = (Button) findViewById(R.id.thirdActivityButton);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = mEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(EDIT_TEXT_VALUE, text);
                startActivityForResult(intent, SECOND_ACTIVITY_REQUEST);
            }
        }); //Tap
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = mEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                intent.putExtra(EDIT_TEXT_VALUE, text);
                startActivityForResult(intent, THIRD_ACTIVITY_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // super.onActivityResult(requestCode, resultCode, data);
        Log.d("my", String.valueOf(requestCode));
        Log.d("my", data.toString());
        String text = "";
        String activityName = "";
        switch (requestCode)        {
            case SECOND_ACTIVITY_REQUEST:
                if (data != null){
                    text = data.getSerializableExtra(SecondActivity.SECOND_EDIT_TEXT_VALUE).toString();
                    activityName = "Activity 2";
                }
                break;
            case THIRD_ACTIVITY_REQUEST:
                if (data != null){
                    text = data.getSerializableExtra(ThirdActivity.THIRD_EDIT_TEXT_VALUE).toString();
                    activityName = "Activity 3";
                }
                break;
        }
        mEditText.setText(text);
        Toast.makeText(
                this
                , activityName
                , Toast.LENGTH_LONG
        ).show();
    }
}
