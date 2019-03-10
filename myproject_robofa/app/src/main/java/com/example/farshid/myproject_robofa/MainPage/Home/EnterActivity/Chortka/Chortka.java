package com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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
import com.example.farshid.myproject_robofa.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class Chortka extends AppCompatActivity implements View.OnClickListener {
    CardView term1, term2, term3, term4, term5, term6, term7, term8, term9, term10, term11, term12, term, term06;
    int Count = 0, Count1 = 0;
    boolean Acc = false;
    private int time_interval = 2000;
    ImageView IMterm1, IMterm2, IMterm3, IMterm4, IMterm5, IMterm6, IMterm7, IMterm8, IMterm9, IMterm10, IMterm11, IMterm12;
    TextView TEterm1, TEterm2, TEterm3, TEterm4, TEterm5, TEterm6, TEterm7, TEterm8, TEterm9, TEterm10, TEterm11, TEterm12;
    private long oldCurrentTimeMillis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chortka);
        Initialize();
        SetFont();
         SetImageCard();
        term1.setOnClickListener(this);
        term2.setOnClickListener(this);
        term3.setOnClickListener(this);
        term4.setOnClickListener(this);

    }

    private void SetImageCard() {
        SharedPreferences pref3 = getApplicationContext().getSharedPreferences("AccTCH", 0); // 0 - for private mode
        if (pref3.getBoolean("key_AccTCH1", false)) {
            IMterm1.setBackgroundResource(R.drawable.image_accept3);
            term1.setEnabled(true);
        } else {
            IMterm1.setBackgroundResource(R.drawable.image_stop3);
            term1.setEnabled(false);
        }
        if (pref3.getBoolean("key_AccTCH2", false)) {
            IMterm2.setBackgroundResource(R.drawable.image_accept3);
            term2.setEnabled(true);
        } else {
            IMterm2.setBackgroundResource(R.drawable.image_stop3);
            term2.setEnabled(false);
        }
        if (pref3.getBoolean("key_AccTCH3", false)) {
            IMterm3.setBackgroundResource(R.drawable.image_accept3);
            term3.setEnabled(true);
        } else {
            IMterm3.setBackgroundResource(R.drawable.image_stop3);
            term3.setEnabled(false);
        }
        if (pref3.getBoolean("key_AccTCH4", false)) {
            IMterm4.setBackgroundResource(R.drawable.image_accept3);
            term4.setEnabled(true);
        } else {
            IMterm4.setBackgroundResource(R.drawable.image_stop3);
            term4.setEnabled(false);
        }
        if (pref3.getBoolean("key_AccTCH5", false)) {
            IMterm5.setBackgroundResource(R.drawable.image_accept3);
            term5.setEnabled(true);
        } else {
            IMterm5.setBackgroundResource(R.drawable.image_stop3);
            term5.setEnabled(false);
        }
        if (pref3.getBoolean("key_AccTCH6", false)) {
            IMterm6.setBackgroundResource(R.drawable.image_accept3);
            term6.setEnabled(true);
        } else {
            IMterm6.setBackgroundResource(R.drawable.image_stop3);
            term6.setEnabled(false);
        }
        if (pref3.getBoolean("key_AccTCH7", false)) {
            IMterm7.setBackgroundResource(R.drawable.image_accept3);
            term7.setEnabled(true);
        } else {
            IMterm7.setBackgroundResource(R.drawable.image_stop3);
            term7.setEnabled(false);
        }
        if (pref3.getBoolean("key_AccTCH8", false)) {
            IMterm8.setBackgroundResource(R.drawable.image_accept3);
            term8.setEnabled(true);
        } else {
            IMterm8.setBackgroundResource(R.drawable.image_stop3);
            term8.setEnabled(false);
        }
        if (pref3.getBoolean("key_AccTCH9", false)) {
            IMterm9.setBackgroundResource(R.drawable.image_accept3);
            term9.setEnabled(true);
        } else {
            IMterm9.setBackgroundResource(R.drawable.image_stop3);
            term9.setEnabled(false);
        }
        if (pref3.getBoolean("key_AccTCH10", false)) {
            IMterm10.setBackgroundResource(R.drawable.image_accept3);
            term10.setEnabled(true);
        } else {
            IMterm10.setBackgroundResource(R.drawable.image_stop3);
            term10.setEnabled(false);
        }
        if (pref3.getBoolean("key_AccTCH11", false)) {
            IMterm11.setBackgroundResource(R.drawable.image_accept3);
            term11.setEnabled(true);
        } else {
            IMterm11.setBackgroundResource(R.drawable.image_stop3);
            term11.setEnabled(false);
        }
        if (pref3.getBoolean("key_AccTCH12", false)) {
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
            Intent in = new Intent(Chortka.this, Button_Navigation.class);
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

    private void Initialize() {
        term1 = (CardView) findViewById(R.id.MainPage_Home_Chortka_Term1);
        term2 = (CardView) findViewById(R.id.MainPage_Home_Chortka_Term2);
        term3 = (CardView) findViewById(R.id.MainPage_Home_Chortka_Term3);
        term4 = (CardView) findViewById(R.id.MainPage_Home_Chortka_Term4);
        term5 = (CardView) findViewById(R.id.MainPage_Home_Chortka_Term5);
        term6 = (CardView) findViewById(R.id.MainPage_Home_Chortka_Term6);
        term7 = (CardView) findViewById(R.id.MainPage_Home_Chortka_Term7);
        term8 = (CardView) findViewById(R.id.MainPage_Home_Chortka_Term8);
        term9 = (CardView) findViewById(R.id.MainPage_Home_Chortka_Term9);

        term10 = (CardView) findViewById(R.id.MainPage_Home_Chortka_Term10);
        term11 = (CardView) findViewById(R.id.MainPage_Home_Chortka_Term11);
        term12 = (CardView) findViewById(R.id.MainPage_Home_Chortka_Term12);


        IMterm1 = (ImageView) findViewById(R.id.imageterm1);
        IMterm2 = (ImageView) findViewById(R.id.imageterm2);
        IMterm3 = (ImageView) findViewById(R.id.imageterm3);
        IMterm4 = (ImageView) findViewById(R.id.imageterm4);
        IMterm5 = (ImageView) findViewById(R.id.imageterm5);
        IMterm6 = (ImageView) findViewById(R.id.imageterm6);
        IMterm7 = (ImageView) findViewById(R.id.imageterm7);
        IMterm8 = (ImageView) findViewById(R.id.imageterm8);
        IMterm9 = (ImageView) findViewById(R.id.imageterm9);
        IMterm10 = (ImageView) findViewById(R.id.imageterm10);
        IMterm11 = (ImageView) findViewById(R.id.imageterm11);
        IMterm12 = (ImageView) findViewById(R.id.imageterm12);


        TEterm1 = (TextView) findViewById(R.id.Teterm1);
        TEterm2 = (TextView) findViewById(R.id.Teterm2);
        TEterm3 = (TextView) findViewById(R.id.Teterm3);
        TEterm4 = (TextView) findViewById(R.id.Teterm4);
        TEterm5 = (TextView) findViewById(R.id.Teterm5);
        TEterm6 = (TextView) findViewById(R.id.Teterm6);
        TEterm7 = (TextView) findViewById(R.id.Teterm7);
        TEterm8 = (TextView) findViewById(R.id.Teterm8);
        TEterm9 = (TextView) findViewById(R.id.Teterm9);
        TEterm10 = (TextView) findViewById(R.id.Teterm10);
        TEterm11 = (TextView) findViewById(R.id.Teterm11);
        TEterm12 = (TextView) findViewById(R.id.Teterm12);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.MainPage_Home_Chortka_Term1: {
                Intent in = new Intent(Chortka.this, Term1.class);
                in.putExtra("Term", "1");
                startActivity(in);
                break;
            }
            case R.id.MainPage_Home_Chortka_Term2: {
                Intent in = new Intent(Chortka.this, Term1.class);
                in.putExtra("Term", "2");
                startActivity(in);
                break;
            }
            case R.id.MainPage_Home_Chortka_Term3: {
                Intent in = new Intent(Chortka.this, Term1.class);
                in.putExtra("Term", "3");
                startActivity(in);
                break;
            }
            case R.id.MainPage_Home_Chortka_Term4: {
                Intent in = new Intent(Chortka.this, Term1.class);
                in.putExtra("Term", "4");
                startActivity(in);
                break;
            }
            case R.id.MainPage_Home_Chortka_Term5: {
                Intent in = new Intent(Chortka.this, Term1.class);
                in.putExtra("Term", "5");
                startActivity(in);
                break;
            }
            case R.id.MainPage_Home_Chortka_Term6: {
                Intent in = new Intent(Chortka.this, Term1.class);
                in.putExtra("Term", "6");
                startActivity(in);
                break;
            }
            case R.id.MainPage_Home_Chortka_Term7: {
                Intent in = new Intent(Chortka.this, Term1.class);
                in.putExtra("Term", "7");
                startActivity(in);
                break;
            }
            case R.id.MainPage_Home_Chortka_Term8: {
                Intent in = new Intent(Chortka.this, Term1.class);
                in.putExtra("Term", "8");
                startActivity(in);
                break;
            }
            case R.id.MainPage_Home_Chortka_Term9: {
                Intent in = new Intent(Chortka.this, Term1.class);
                in.putExtra("Term", "9");
                startActivity(in);
                break;
            }
            case R.id.MainPage_Home_Chortka_Term10: {
                Intent in = new Intent(Chortka.this, Term1.class);
                in.putExtra("Term", "10");
                startActivity(in);
                break;
            }
            case R.id.MainPage_Home_Chortka_Term11: {
                Intent in = new Intent(Chortka.this, Term1.class);
                in.putExtra("Term", "11");
                startActivity(in);
                break;
            }
            case R.id.MainPage_Home_Chortka_Term12: {
                Intent in = new Intent(Chortka.this, Term1.class);
                in.putExtra("Term", "12");
                startActivity(in);
                break;
            }
        }
    }




}
