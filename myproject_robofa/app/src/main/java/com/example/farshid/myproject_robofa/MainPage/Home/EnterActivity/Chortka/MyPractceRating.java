package com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.farshid.myproject_robofa.R;

public class MyPractceRating extends AppCompatActivity {
    TextView TC1, TC2, TC3, TC4, TC5, TC6, TC7, TC8, TC9, TC10, TC0;
    TextView TAM1, TAM2, TAM3, TAM4, TAM5, TAM6, TAM7, TAM8, TAM9, TAM10, TAM0;
    TextView TAR1, TAR2, TAR3, TAR4, TAR5, TAR6, TAR7, TAR8, TAR9, TAR10, TAR0;
    int AM1, AM2, AM3, AM4, AM5, AM6, AM7, AM8, AM9, AM10;
    int AR1, AR2, AR3, AR4, AR5, AR6, AR7, AR8, AR9, AR10;
    ImageView icon_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_practce_rating);
//        مقداردهی مقادیر
        Initialize();
//        ست کردن فونت
        SetFont();
//        گرفتن مقادیر از باندل
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            AR1 = extras.getInt("BAR1");
            AR2 = extras.getInt("BAR2");
            AR3 = extras.getInt("BAR3");
            AR4 = extras.getInt("BAR4");
            AR5 = extras.getInt("BAR5");
            AR6 = extras.getInt("BAR6");
            AR7 = extras.getInt("BAR7");
            AR8 = extras.getInt("BAR8");
            AR9 = extras.getInt("BAR9");
            AR10 = extras.getInt("BAR10");


            AM1 = extras.getInt("BAM1");
            AM2 = extras.getInt("BAM2");
            AM3 = extras.getInt("BAM3");
            AM4 = extras.getInt("BAM4");
            AM5 = extras.getInt("BAM5");
            AM6 = extras.getInt("BAM6");
            AM7 = extras.getInt("BAM7");
            AM8 = extras.getInt("BAM8");
            AM9 = extras.getInt("BAM9");
            AM10 = extras.getInt("BAM10");
            if (AR1 == AM1 && AR1 != 0) {
                TAM1.setBackgroundColor(Color.GREEN);
            } else if (AR1 != 0) {
                TAM1.setBackgroundColor(Color.RED);
            }
            if (AR2 == AM2 && AR2 != 0) {
                TAM2.setBackgroundColor(Color.GREEN);
            } else if (AR2 != 0) {
                TAM2.setBackgroundColor(Color.RED);
            }
            if (AR3 == AM3 && AR3 != 0) {
                TAM3.setBackgroundColor(Color.GREEN);
            } else if (AR3 != 0) {
                TAM3.setBackgroundColor(Color.RED);
            }
            if (AR4 == AM4 && AR4 != 0) {
                TAM4.setBackgroundColor(Color.GREEN);
            } else if (AR4 != 0) {
                TAM4.setBackgroundColor(Color.RED);
            }
            if (AR5 == AM5 && AR5 != 0) {
                TAM5.setBackgroundColor(Color.GREEN);
            } else if (AR5 != 0) {
                TAM5.setBackgroundColor(Color.RED);
            }
            if (AR6 == AM6 && AR6 != 0) {
                TAM6.setBackgroundColor(Color.GREEN);
            } else if (AR6 != 0) {
                TAM6.setBackgroundColor(Color.RED);
            }
            if (AR7 == AM7 && AR7 != 0) {
                TAM7.setBackgroundColor(Color.GREEN);
            } else if (AR7 != 0) {
                TAM7.setBackgroundColor(Color.RED);
            }
            if (AR8 == AM8 && AR8 != 0) {
                TAM8.setBackgroundColor(Color.GREEN);
            } else if (AR8 != 0) {
                TAM8.setBackgroundColor(Color.RED);
            }
            if (AR9 == AM9 && AR9 != 0) {
                TAM9.setBackgroundColor(Color.GREEN);
            } else if (AR9 != 0) {
                TAM9.setBackgroundColor(Color.RED);
            }
            if (AR10 == AM10 && AR10 != 0) {
                TAM10.setBackgroundColor(Color.GREEN);
            } else if (AR10 != 0) {
                TAM10.setBackgroundColor(Color.RED);
            }

            icon_home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(MyPractceRating.this, Chortka.class);
                    startActivity(in);
                    System.exit(0);
                    finish();
                }
            });

        }
//    مقدار دهی امتیاز هاا
        SetData();

    }

    @Override
    public void onBackPressed() {

    }

    private void SetData() {
        TAM1.setText(persian.PerisanNumber(String.valueOf(AM1) + ""));
        TAM2.setText(persian.PerisanNumber(String.valueOf(AM2) + ""));
        TAM3.setText(persian.PerisanNumber(String.valueOf(AM3) + ""));
        TAM4.setText(persian.PerisanNumber(String.valueOf(AM4) + ""));
        TAM5.setText(persian.PerisanNumber(String.valueOf(AM5) + ""));
        TAM6.setText(persian.PerisanNumber(String.valueOf(AM6) + ""));
        TAM7.setText(persian.PerisanNumber(String.valueOf(AM7) + ""));
        TAM8.setText(persian.PerisanNumber(String.valueOf(AM8) + ""));
        TAM9.setText(persian.PerisanNumber(String.valueOf(AM9) + ""));
        TAM10.setText(persian.PerisanNumber(String.valueOf(AM10) + ""));


        TAR1.setText(persian.PerisanNumber(String.valueOf(AR1) + ""));
        TAR2.setText(persian.PerisanNumber(String.valueOf(AR2) + ""));
        TAR3.setText(persian.PerisanNumber(String.valueOf(AR3) + ""));
        TAR4.setText(persian.PerisanNumber(String.valueOf(AR4) + ""));
        TAR5.setText(persian.PerisanNumber(String.valueOf(AR5) + ""));
        TAR6.setText(persian.PerisanNumber(String.valueOf(AR6) + ""));
        TAR7.setText(persian.PerisanNumber(String.valueOf(AR7) + ""));
        TAR8.setText(persian.PerisanNumber(String.valueOf(AR8) + ""));
        TAR9.setText(persian.PerisanNumber(String.valueOf(AR9) + ""));
        TAR10.setText(persian.PerisanNumber(String.valueOf(AR10) + ""));


        if (TAR1.getText().toString().equals("۰")) {
            TAR1.setText("X");
        }
        if (TAR2.getText().toString().equals("۰")) {
            TAR2.setText("X");
        }
        if (TAR3.getText().toString().equals("۰")) {
            TAR3.setText("X");
        }
        if (TAR4.getText().toString().equals("۰")) {
            TAR4.setText("X");
        }
        if (TAR5.getText().toString().equals("۰")) {
            TAR5.setText("X");
        }
        if (TAR6.getText().toString().equals("۰")) {
            TAR6.setText("X");
        }
        if (TAR7.getText().toString().equals("۰")) {
            TAR7.setText("X");
        }
        if (TAR8.getText().toString().equals("۰")) {
            TAR8.setText("X");
        }
        if (TAR9.getText().toString().equals("۰")) {
            TAR9.setText("X");
        }
        if (TAR10.getText().toString().equals("۰")) {
            TAR10.setText("X");
        }


        if (TAM1.getText().toString().equals("۰")) {
            TAM1.setText("X");
        }

        if (TAM2.getText().toString().equals("۰")) {
            TAM2.setText("X");
        }
        if (TAM3.getText().toString().equals("۰")) {
            TAM3.setText("X");
        }
        if (TAM4.getText().toString().equals("۰")) {
            TAM4.setText("X");
        }

        if (TAM5.getText().toString().equals("۰")) {
            TAM5.setText("X");
        }

        if (TAM6.getText().toString().equals("۰")) {
            TAM6.setText("X");
        }
        if (TAM7.getText().toString().equals("۰")) {
            TAM7.setText("X");
        }
        if (TAM8.getText().toString().equals("۰")) {
            TAM8.setText("X");
        }

        if (TAM9.getText().toString().equals("۰")) {
            TAM9.setText("X");
        }
        if (TAM10.getText().toString().equals("۰")) {
            TAM10.setText("X");
        }


    }

    private void SetFont() {
        Typeface tf = Typeface.createFromAsset(getAssets(), "font/irsans.ttf");
        TC0.setTypeface(tf);
        TC1.setTypeface(tf);
        TC2.setTypeface(tf);
        TC3.setTypeface(tf);
        TC4.setTypeface(tf);
        TC5.setTypeface(tf);
        TC6.setTypeface(tf);
        TC7.setTypeface(tf);
        TC8.setTypeface(tf);
        TC9.setTypeface(tf);
        TC10.setTypeface(tf);

        TAM0.setTypeface(tf);
        TAM1.setTypeface(tf);
        TAM2.setTypeface(tf);
        TAM3.setTypeface(tf);
        TAM4.setTypeface(tf);
        TAM5.setTypeface(tf);
        TAM6.setTypeface(tf);
        TAM7.setTypeface(tf);
        TAM8.setTypeface(tf);
        TAM9.setTypeface(tf);
        TAM10.setTypeface(tf);

        TAR0.setTypeface(tf);
        TAR1.setTypeface(tf);
        TAR2.setTypeface(tf);
        TAR3.setTypeface(tf);
        TAR4.setTypeface(tf);
        TAR5.setTypeface(tf);
        TAR6.setTypeface(tf);
        TAR7.setTypeface(tf);
        TAR8.setTypeface(tf);
        TAR9.setTypeface(tf);
        TAR10.setTypeface(tf);


    }

    private void Initialize() {
        TC0 = findViewById(R.id.CountRow11);
        TC1 = findViewById(R.id.CountRow21);
        TC2 = findViewById(R.id.CountRow31);
        TC3 = findViewById(R.id.CountRow41);
        TC4 = findViewById(R.id.CountRow51);
        TC5 = findViewById(R.id.CountRow61);
        TC6 = findViewById(R.id.CountRow71);
        TC7 = findViewById(R.id.CountRow81);
        TC8 = findViewById(R.id.CountRow91);
        TC9 = findViewById(R.id.CountRow101);
        TC10 = findViewById(R.id.CountRow111);


        TAM0 = findViewById(R.id.CountRow13);
        TAM1 = findViewById(R.id.CountRow23);
        TAM2 = findViewById(R.id.CountRow33);
        TAM3 = findViewById(R.id.CountRow43);
        TAM4 = findViewById(R.id.CountRow53);
        TAM5 = findViewById(R.id.CountRow63);
        TAM6 = findViewById(R.id.CountRow73);
        TAM7 = findViewById(R.id.CountRow83);
        TAM8 = findViewById(R.id.CountRow93);
        TAM9 = findViewById(R.id.CountRow103);
        TAM10 = findViewById(R.id.CountRow113);

        TAR0 = findViewById(R.id.CountRow12);
        TAR1 = findViewById(R.id.CountRow22);
        TAR2 = findViewById(R.id.CountRow32);
        TAR3 = findViewById(R.id.CountRow42);
        TAR4 = findViewById(R.id.CountRow52);
        TAR5 = findViewById(R.id.CountRow62);
        TAR6 = findViewById(R.id.CountRow72);
        TAR7 = findViewById(R.id.CountRow82);
        TAR8 = findViewById(R.id.CountRow92);
        TAR9 = findViewById(R.id.CountRow102);
        TAR10 = findViewById(R.id.CountRow112);

        icon_home = findViewById(R.id.icon_home);


    }
}
