package com.example.lab;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//竖屏
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//横屏
        /*if(getRequestedOrientation()!=ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        if(getRequestedOrientation()!=ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }*/
        TextView textView=findViewById(R.id.textView2);




        try{
            InputStream Text = getResources().getAssets().open("ada.txt");
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

    public void clickchange(View v) {
        Intent intent =  new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
        finish();
    }

    public void clickTrans1(View v) {
        try{
            TextView textView=findViewById(R.id.textView2);
            InputStream Text = getResources().getAssets().open("ada_trans.txt");
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


