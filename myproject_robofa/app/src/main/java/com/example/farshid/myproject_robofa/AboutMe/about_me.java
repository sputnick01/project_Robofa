package com.example.farshid.myproject_robofa.AboutMe;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.farshid.myproject_robofa.R;

public class about_me extends AppCompatActivity {
    TextView textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView12,textView13,textView14,textView15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        InitilizeView();
        SetFont();
    }

    private void InitilizeView() {
        textView3=findViewById(R.id.textView3);
        textView4=findViewById(R.id.textView4);
        textView5=findViewById(R.id.textView5);
        textView6=findViewById(R.id.textView6);
        textView7=findViewById(R.id.textView7);
        textView8=findViewById(R.id.textView8);
        textView9=findViewById(R.id.textView9);
        textView12=findViewById(R.id.textView12);
        textView14=findViewById(R.id.textView14);
        textView15=findViewById(R.id.textView15);

    }

    private void SetFont() {
        Typeface tf = Typeface.createFromAsset(getAssets(), "font/irsans.ttf");
        textView3.setTypeface(tf);
        textView4.setTypeface(tf);
        textView5.setTypeface(tf);
        textView6.setTypeface(tf);
        textView7.setTypeface(tf);
        textView8.setTypeface(tf);
        textView9.setTypeface(tf);
        textView12.setTypeface(tf);
        textView14.setTypeface(tf);
        textView15.setTypeface(tf);
    }
}
