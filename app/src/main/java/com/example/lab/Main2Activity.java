package com.example.lab;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;


public class Main2Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//横屏
        TextView textView=findViewById(R.id.textView2);




        try{
            InputStream Text = getResources().getAssets().open("james.txt");
            int size = Text.available();
            byte[] buffer =  new byte[size];
            Text.read(buffer);
            Text.close();

            String text = new String(buffer,"UTF-8");
            textView.setText(text);

        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void clickchange2(View v) {
        Intent intent =  new Intent(Main2Activity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void clickTrans2(View v) {
        try{
            TextView textView=findViewById(R.id.textView2);
            InputStream Text = getResources().getAssets().open("james_trans.txt");
            int size = Text.available();
            byte[] buffer =  new byte[size];
            Text.read(buffer);
            Text.close();

            String text = new String(buffer,"GB2312");
            textView.setText(text);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}