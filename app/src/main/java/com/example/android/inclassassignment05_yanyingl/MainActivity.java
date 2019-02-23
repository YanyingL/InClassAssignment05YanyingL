package com.example.android.inclassassignment05_yanyingl;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public EditText message_text;
    public EditText title_text;
    public Button launch_button;
    public Button camera_button;
    public Button email_button;
    public static final String message_content = "message";
    public static final String title_content = "title";
    public static final String checkbox = "box";
    static final int REQUEST_IMAGE_CAPTURE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox titleCheckBox = (CheckBox) findViewById(R.id.onlyTitle_checkbox);
        final boolean onlyTitle1 = titleCheckBox.isChecked();

        message_text=(EditText) findViewById(R.id.message_field);
        title_text=(EditText) findViewById(R.id.title_field);
        launch_button=(Button)findViewById(R.id.launch_activity);
        launch_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                String message=message_text.getText().toString();
                String content=title_text.getText().toString();
                intent.putExtra(message_content,message);
                intent.putExtra(title_content,content);
                startActivity(intent);
            }
        });

        email_button=(Button)findViewById(R.id.email_activity);
        email_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_SUBJECT, title_text.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, message_text.getText().toString());
                if(intent.resolveActivity(getPackageManager())!=null) {
                    startActivity(intent);
                }
            }
        });

        camera_button=(Button)findViewById(R.id.camera_activity);
        camera_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
                }

        });


    }


}
