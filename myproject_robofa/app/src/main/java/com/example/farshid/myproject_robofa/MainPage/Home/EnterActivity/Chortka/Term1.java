package com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.Note.Note;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.YourRating.YourRating;
import com.example.farshid.myproject_robofa.R;

public class Term1 extends AppCompatActivity implements View.OnClickListener {
    String Term;
    TextView TextTermToolBar;
    private int time_interval = 2000;
    private long oldCurrentTimeMillis;
    Button MainPage_Home_Chortka_Term7, MainPage_Home_Chortka_Practice2, MainPage_Home_Chortka_Note, MainPage_Home_Chortka_YourRating;
     String Term2="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term1);
        Initilize();
        SetFont();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Term = extras.getString("Term");
            SharedPreferences pref = getApplicationContext().getSharedPreferences("Term", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("key_Term", Term); // Storing string
            editor.commit(); // commit changes
            if (Term.toString().equals("1")) {
                TextTermToolBar.setText("ترم اول");
            } else if (Term.toString().equals("2")) {
                TextTermToolBar.setText("ترم دوم");
            } else if (Term.toString().equals("3")) {
                TextTermToolBar.setText("ترم سوم");
            } else if (Term.toString().equals("4")) {
                TextTermToolBar.setText("ترم چهارم");
            } else if (Term.toString().equals("5")) {
                TextTermToolBar.setText("ترم پنچم");
            } else if (Term.toString().equals("6")) {
                TextTermToolBar.setText("ترم ششم");
            } else if (Term.toString().equals("7")) {
                TextTermToolBar.setText("ترم هفتم");
            } else if (Term.toString().equals("8")) {
                TextTermToolBar.setText("ترم هشتم");
            } else if (Term.toString().equals("9")) {
                TextTermToolBar.setText("ترم نهم");
            } else if (Term.toString().equals("10")) {
                TextTermToolBar.setText("ترم دهم");
            } else if (Term.toString().equals("11")) {
                TextTermToolBar.setText("ترم یازدهم");
            } else if (Term.toString().equals("12")) {
                TextTermToolBar.setText("ترم دوازدهم");
            }
        }
        SharedPreferences pref3 = getApplicationContext().getSharedPreferences("Term", 0); // 0 - for private mode
        Term2 = pref3.getString("key_Term", "");
        if (Term2.equals("1")) {
            MainPage_Home_Chortka_Practice2.setVisibility(View.GONE);
        }
        MainPage_Home_Chortka_Term7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Term1.this, Practice.class);
                in.putExtra("Term2", Term2);
                startActivity(in);
                finish();
                System.exit(0);
            }
        });
        MainPage_Home_Chortka_YourRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Term1.this, YourRating.class);
                in.putExtra("Term", Term2);

                in.putExtra("Class","چرتکه ومحاسبات ذهنی");
                startActivity(in);
                finish();
                System.exit(0);
            }
        });
        MainPage_Home_Chortka_Note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Term1.this, Note.class);
                in.putExtra("Term", Term2);
                in.putExtra("Kind", "Term");
                in.putExtra("Class","چرتکه ومحاسبات ذهنی");
                startActivity(in);
                finish();
                System.exit(0);
            }
        });
        MainPage_Home_Chortka_Practice2.setOnClickListener(this);
        setTerm();
    }

    private void setTerm() {
        SharedPreferences pref3 = getApplicationContext().getSharedPreferences("Term", 0); // 0 - for private mode
        String Term22 = pref3.getString("key_Term", "");
        if (Term22.toString().equals("1")) {
            TextTermToolBar.setText("ترم اول");

        } else if (Term22.toString().equals("2")) {
            TextTermToolBar.setText("ترم دوم");

        } else if (Term22.toString().equals("3")) {
            TextTermToolBar.setText("ترم سوم");
        } else if (Term22.toString().equals("4")) {
            TextTermToolBar.setText("ترم چهارم");
        } else if (Term22.toString().equals("5")) {
            TextTermToolBar.setText("ترم پنچم");
        } else if (Term22.toString().equals("6")) {
            TextTermToolBar.setText("ترم ششم");
        } else if (Term22.toString().equals("7")) {
            TextTermToolBar.setText("ترم هفتم");
        } else if (Term22.toString().equals("8")) {
            TextTermToolBar.setText("ترم هشتم");
        } else if (Term22.toString().equals("9")) {
            TextTermToolBar.setText("ترم نهم");
        } else if (Term22.toString().equals("10")) {
            TextTermToolBar.setText("ترم دهم");
        } else if (Term22.toString().equals("11")) {
            TextTermToolBar.setText("ترم یازدهم");
        } else if (Term22.toString().equals("12")) {
            TextTermToolBar.setText("ترم دوازدهم");
        }

    }

    private void SetFont() {
        Typeface tf = Typeface.createFromAsset(getAssets(), "font/irsans.ttf");
        TextTermToolBar.setTypeface(tf);
        MainPage_Home_Chortka_Term7.setTypeface(tf);
        MainPage_Home_Chortka_Note.setTypeface(tf);
    }

    public boolean hasInternetConnection() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiNetwork != null && wifiNetwork.isConnected()) {
            return true;
        }
        NetworkInfo mobileNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (mobileNetwork != null && mobileNetwork.isConnected()) {
            return true;
        }
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnected()) {
            return true;
        }
        return false;
    }


    private void Initilize() {
        TextTermToolBar = (TextView) findViewById(R.id.MainPage_toolbar_title2);
        MainPage_Home_Chortka_Term7 = (Button) findViewById(R.id.MainPage_Home_Chortka_Term7);
        MainPage_Home_Chortka_Note = (Button) findViewById(R.id.MainPage_Home_Chortka_Note);
        MainPage_Home_Chortka_YourRating = (Button) findViewById(R.id.MainPage_Home_Chortka_YourRating);
        MainPage_Home_Chortka_Practice2 = (Button) findViewById(R.id.MainPage_Home_Chortka_Practice2);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.MainPage_Home_Chortka_Practice2: {

                Intent in = new Intent(Term1.this, MyPractice.class);
                in.putExtra("Term22", Term2);
                startActivity(in);
                finish();
                System.exit(0);
                break;
            }
        }
    }
}
