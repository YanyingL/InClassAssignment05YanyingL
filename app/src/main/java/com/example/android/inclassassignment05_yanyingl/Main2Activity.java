package com.example.android.inclassassignment05_yanyingl;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.android.inclassassignment05_yanyingl.MainActivity.checkbox;

public class Main2Activity extends AppCompatActivity {

    public static final String showMessage="message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView MessageTextView = (TextView)this.findViewById(R.id.show_message);
        Intent intent=this.getIntent();
        String mmessage=intent.getStringExtra(MainActivity.message_content);
        MessageTextView.setText(mmessage);
        String ttitle=intent.getStringExtra(MainActivity.title_content);
        setTitle(ttitle);
    }
}
