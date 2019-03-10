package com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Saze;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.farshid.myproject_robofa.Button_Navigation;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Zaban.Class_Zaban;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Zaban.TermZaban;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.riaze.Riaze;
import com.example.farshid.myproject_robofa.R;

public class Class_Saze extends AppCompatActivity implements View.OnClickListener {
    CardView term1, term2, term3, term4;
    int Count = 0, Count1 = 0;
    private int time_interval = 2000;
    private long oldCurrentTimeMillis;
    ImageView IMterm1, IMterm2, IMterm3, IMterm4, IMterm5, IMterm6, IMterm7, IMterm8, IMterm9, IMterm10, IMterm11, IMterm12;
    TextView TEterm1, TEterm2, TEterm3, TEterm4, TEterm5, TEterm6, TEterm7, TEterm8, TEterm9, TEterm10, TEterm11, TEterm12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class__saze);
        Initialize();
        SetFont();
        Saze();
        term1.setOnClickListener(this);
        term2.setOnClickListener(this);
        term3.setOnClickListener(this);
        term4.setOnClickListener(this);

    }

    private void Saze() {
        SharedPreferences pref3 = getApplicationContext().getSharedPreferences("AccTSa", 0); // 0 - for private mode
        if (pref3.getBoolean("key_AccTSa1", false)) {
            IMterm1.setBackgroundResource(R.drawable.image_accept3);
            term1.setEnabled(true);
        } else {
            IMterm1.setBackgroundResource(R.drawable.image_stop3);
            term1.setEnabled(false);
        }
        if (pref3.getBoolean("key_AccTSa2", false)) {
            IMterm2.setBackgroundResource(R.drawable.image_accept3);
            term2.setEnabled(true);
        } else {
            IMterm2.setBackgroundResource(R.drawable.image_stop3);
            term2.setEnabled(false);
        }
        if (pref3.getBoolean("key_AccTSa3", false)) {
            IMterm3.setBackgroundResource(R.drawable.image_accept3);
            term3.setEnabled(true);
        } else {
            IMterm3.setBackgroundResource(R.drawable.image_stop3);
            term3.setEnabled(false);
        }
        if (pref3.getBoolean("key_AccTSa4", false)) {
            IMterm4.setBackgroundResource(R.drawable.image_accept3);
            term4.setEnabled(true);
        } else {
            IMterm4.setBackgroundResource(R.drawable.image_stop3);
            term4.setEnabled(false);
        }



    }

    private void SetFont() {

        Typeface tf = Typeface.createFromAsset(getAssets(), "font/irsans.ttf");
        TEterm1.setTypeface(tf);
        TEterm2.setTypeface(tf);
        TEterm3.setTypeface(tf);
        TEterm4.setTypeface(tf);

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.MainPage_Home_Saze_Term1: {
                Intent in = new Intent(Class_Saze.this, TermSaze.class);
                in.putExtra("Term", "1");
                startActivity(in);
                break;
            }
            case R.id.MainPage_Home_Saze_Term2: {
                Intent in = new Intent(Class_Saze.this, TermSaze.class);
                in.putExtra("Term", "2");
                startActivity(in);
                break;
            }
            case R.id.MainPage_Home_Saze_Term3: {
                Intent in = new Intent(Class_Saze.this, TermSaze.class);
                in.putExtra("Term", "3");
                startActivity(in);
                break;
            }
            case R.id.MainPage_Home_Saze_Term4: {
                Intent in = new Intent(Class_Saze.this, TermSaze.class);
                in.putExtra("Term", "4");
                startActivity(in);
                break;
            }


        }
    }
    private void Initialize() {
        term1 = (CardView) findViewById(R.id.MainPage_Home_Saze_Term1);
        term2 = (CardView) findViewById(R.id.MainPage_Home_Saze_Term2);
        term3 = (CardView) findViewById(R.id.MainPage_Home_Saze_Term3);
        term4 = (CardView) findViewById(R.id.MainPage_Home_Saze_Term4);



        IMterm1 = (ImageView) findViewById(R.id.imagetermSa1);
        IMterm2 = (ImageView) findViewById(R.id.imagetermSa2);
        IMterm3 = (ImageView) findViewById(R.id.imagetermSa3);
        IMterm4 = (ImageView) findViewById(R.id.imagetermSa4);


        TEterm1 = (TextView) findViewById(R.id.TetermSa1);
        TEterm2 = (TextView) findViewById(R.id.TetermSa2);
        TEterm3 = (TextView) findViewById(R.id.TetermSa3);
        TEterm4 = (TextView) findViewById(R.id.TetermSa4);

    }

    //    exit the application
    @Override
    public void onBackPressed() {

        if (oldCurrentTimeMillis + time_interval > System.currentTimeMillis()) {
            super.onBackPressed();
            Intent in =new Intent(Class_Saze.this, Button_Navigation.class);
            startActivity(in);
            finish();
            System.exit(0);
            return;
        } else {
            onFirstBackPressed();

        }
        oldCurrentTimeMillis = System.currentTimeMillis();
    }
    public void onFirstBackPressed() {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.toast_exitapp, null);
        Toast toast = new Toast(this);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 300);
        toast.show();
    }
}
