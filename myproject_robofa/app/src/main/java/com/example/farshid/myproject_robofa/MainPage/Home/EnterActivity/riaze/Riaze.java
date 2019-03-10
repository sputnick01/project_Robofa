package com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.riaze;

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
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.Chortka;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.Term1;
import com.example.farshid.myproject_robofa.R;

public class Riaze extends AppCompatActivity implements View.OnClickListener {

    CardView term1, term2, term3, term4, term5, term6, term7, term8, term9, term10, term11, term12;
    int Count = 0, Count1 = 0;
    private int time_interval = 2000;
    private long oldCurrentTimeMillis;

    ImageView IMterm1, IMterm2, IMterm3, IMterm4, IMterm5, IMterm6, IMterm7, IMterm8, IMterm9, IMterm10, IMterm11, IMterm12;
    TextView TEterm1, TEterm2, TEterm3, TEterm4, TEterm5, TEterm6, TEterm7, TEterm8, TEterm9, TEterm10, TEterm11, TEterm12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riaze);
        Initialize();
        SetFont();
        Riazee();
        term1.setOnClickListener(this);
        term2.setOnClickListener(this);
        term3.setOnClickListener(this);
        term4.setOnClickListener(this);


    }

    private void Riazee() {
        SharedPreferences pref3 = getApplicationContext().getSharedPreferences("AccTRi", 0); // 0 - for private mode
        if (pref3.getBoolean("key_AccTRi1", false)) {
            IMterm1.setBackgroundResource(R.drawable.image_accept3);
            term1.setEnabled(true);
        } else {
            IMterm1.setBackgroundResource(R.drawable.image_stop3);
            term1.setEnabled(false);
        }
        if (pref3.getBoolean("key_AccTRi2", false)) {
            IMterm2.setBackgroundResource(R.drawable.image_accept3);
            term2.setEnabled(true);
        } else {
            IMterm2.setBackgroundResource(R.drawable.image_stop3);
            term2.setEnabled(false);
        }
        if (pref3.getBoolean("key_AccTRi3", false)) {
            IMterm3.setBackgroundResource(R.drawable.image_accept3);
            term3.setEnabled(true);
        } else {
            IMterm3.setBackgroundResource(R.drawable.image_stop3);
            term3.setEnabled(false);
        }
        if (pref3.getBoolean("key_AccTRi4", false)) {
            IMterm4.setBackgroundResource(R.drawable.image_accept3);
            term4.setEnabled(true);
        } else {
            IMterm4.setBackgroundResource(R.drawable.image_stop3);
            term4.setEnabled(false);
        }
        if (pref3.getBoolean("key_AccTRi5", false)) {
            IMterm5.setBackgroundResource(R.drawable.image_accept3);
            term5.setEnabled(true);
        } else {
            IMterm5.setBackgroundResource(R.drawable.image_stop3);
            term5.setEnabled(false);
        }
        if (pref3.getBoolean("key_AccTRi6", false)) {
            IMterm6.setBackgroundResource(R.drawable.image_accept3);
            term6.setEnabled(true);
        } else {
            IMterm6.setBackgroundResource(R.drawable.image_stop3);
            term6.setEnabled(false);
        }
        if (pref3.getBoolean("key_AccTRi7", false)) {
            IMterm7.setBackgroundResource(R.drawable.image_accept3);
            term7.setEnabled(true);
        } else {
            IMterm7.setBackgroundResource(R.drawable.image_stop3);
            term7.setEnabled(false);
        }
        if (pref3.getBoolean("key_AccTRi8", false)) {
            IMterm8.setBackgroundResource(R.drawable.image_accept3);
            term8.setEnabled(true);
        } else {
            IMterm8.setBackgroundResource(R.drawable.image_stop3);
            term8.setEnabled(false);
        }
        if (pref3.getBoolean("key_AccTRi9", false)) {
            IMterm9.setBackgroundResource(R.drawable.image_accept3);
            term9.setEnabled(true);
        } else {
            IMterm9.setBackgroundResource(R.drawable.image_stop3);
            term9.setEnabled(false);
        }
        if (pref3.getBoolean("key_AccTRi10", false)) {
            IMterm10.setBackgroundResource(R.drawable.image_accept3);
            term10.setEnabled(true);
        } else {
            IMterm10.setBackgroundResource(R.drawable.image_stop3);
            term10.setEnabled(false);
        }
        if (pref3.getBoolean("key_AccTRi11", false)) {
            IMterm11.setBackgroundResource(R.drawable.image_accept3);
            term11.setEnabled(true);
        } else {
            IMterm11.setBackgroundResource(R.drawable.image_stop3);
            term11.setEnabled(false);
        }
        if (pref3.getBoolean("key_AccTRi12", false)) {
            IMterm12.setBackgroundResource(R.drawable.image_accept3);
            term12.setEnabled(true);
        } else {
            IMterm12.setBackgroundResource(R.drawable.image_stop3);
            term12.setEnabled(false);
        }



    }

    //    exit the application
    @Override
    public void onBackPressed() {

        if (oldCurrentTimeMillis + time_interval > System.currentTimeMillis()) {
            super.onBackPressed();
            Intent in =new Intent(Riaze.this, Button_Navigation.class);
            startActivity(in);
            finish();
            System.exit(0);
            return;
        } else {
            onFirstBackPressed();

        }
        oldCurrentTimeMillis = System.currentTimeMillis();
    }


    private void SetFont() {
        Typeface tf = Typeface.createFromAsset(getAssets(), "font/irsans.ttf");
        TEterm1.setTypeface(tf);
        TEterm2.setTypeface(tf);
        TEterm3.setTypeface(tf);
        TEterm4.setTypeface(tf);
        TEterm5.setTypeface(tf);
        TEterm6.setTypeface(tf);
        TEterm7.setTypeface(tf);
        TEterm8.setTypeface(tf);
        TEterm9.setTypeface(tf);
        TEterm10.setTypeface(tf);
        TEterm11.setTypeface(tf);
        TEterm12.setTypeface(tf);
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
    private void Initialize() {
        term1 = (CardView) findViewById(R.id.MainPage_Home_Riaze_Term1);
        term2 = (CardView) findViewById(R.id.MainPage_Home_Riaze_Term2);
        term3 = (CardView) findViewById(R.id.MainPage_Home_Riaze_Term3);
        term4 = (CardView) findViewById(R.id.MainPage_Home_Riaze_Term4);
        term5 = (CardView) findViewById(R.id.MainPage_Home_Riaze_Term5);
        term6 = (CardView) findViewById(R.id.MainPage_Home_Riaze_Term6);
        term7 = (CardView) findViewById(R.id.MainPage_Home_Riaze_Term7);
        term8 = (CardView) findViewById(R.id.MainPage_Home_Riaze_Term8);
        term9 = (CardView) findViewById(R.id.MainPage_Home_Riaze_Term9);
        term10 = (CardView) findViewById(R.id.MainPage_Home_Riaze_Term10);
        term11 = (CardView) findViewById(R.id.MainPage_Home_Riaze_Term11);
        term12 = (CardView) findViewById(R.id.MainPage_Home_Riaze_Term12);


        IMterm1 = (ImageView) findViewById(R.id.imagetermRi1);
        IMterm2 = (ImageView) findViewById(R.id.imagetermRi2);
        IMterm3 = (ImageView) findViewById(R.id.imagetermRi3);
        IMterm4 = (ImageView) findViewById(R.id.imagetermRi4);
        IMterm5 = (ImageView) findViewById(R.id.imagetermRi5);
        IMterm6 = (ImageView) findViewById(R.id.imagetermRi6);
        IMterm7 = (ImageView) findViewById(R.id.imagetermRi7);
        IMterm8 = (ImageView) findViewById(R.id.imagetermRi8);
        IMterm9 = (ImageView) findViewById(R.id.imagetermRi9);
        IMterm10 = (ImageView) findViewById(R.id.imagetermRi10);
        IMterm11 = (ImageView) findViewById(R.id.imagetermRi11);
        IMterm12 = (ImageView) findViewById(R.id.imagetermRi12);


        TEterm1 = (TextView) findViewById(R.id.TetermRi1);
        TEterm2 = (TextView) findViewById(R.id.TetermRi2);
        TEterm3 = (TextView) findViewById(R.id.TetermRi3);
        TEterm4 = (TextView) findViewById(R.id.TetermRi4);
        TEterm5 = (TextView) findViewById(R.id.TetermRi5);
        TEterm6 = (TextView) findViewById(R.id.TetermRi6);
        TEterm7 = (TextView) findViewById(R.id.TetermRi7);
        TEterm8 = (TextView) findViewById(R.id.TetermRi8);
        TEterm9 = (TextView) findViewById(R.id.TetermRi9);
        TEterm10 = (TextView) findViewById(R.id.TetermRi10);
        TEterm11 = (TextView) findViewById(R.id.TetermRi11);
        TEterm12 = (TextView) findViewById(R.id.TetermRi12);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.MainPage_Home_Riaze_Term1: {
                Intent in = new Intent(Riaze.this, TermRiazee.class);
                in.putExtra("Term", "1");
                startActivity(in);
                break;
            }
            case R.id.MainPage_Home_Riaze_Term2: {
                Intent in = new Intent(Riaze.this, TermRiazee.class);
                in.putExtra("Term", "2");
                startActivity(in);
                break;
            }
            case R.id.MainPage_Home_Riaze_Term3: {
                Intent in = new Intent(Riaze.this, TermRiazee.class);
                in.putExtra("Term", "3");
                startActivity(in);
                break;
            }
            case R.id.MainPage_Home_Riaze_Term4: {
                Intent in = new Intent(Riaze.this, TermRiazee.class);
                in.putExtra("Term", "4");
                startActivity(in);
                break;
            }
        }
    }
}
