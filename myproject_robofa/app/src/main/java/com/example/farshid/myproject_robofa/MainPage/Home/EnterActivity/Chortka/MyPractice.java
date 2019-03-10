package com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.MyPractceRating;
import com.example.farshid.myproject_robofa.R;
import com.gdacciaro.iOSDialog.iOSDialog;
import com.gdacciaro.iOSDialog.iOSDialogBuilder;
import com.gdacciaro.iOSDialog.iOSDialogClickListener;

import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MyPractice extends AppCompatActivity implements View.OnClickListener {
    TextView txt_timer;
    Button btn_send_sms;
    Timer timer;
    long timercount;
    int i0, i1, i2, i11, i22, Count = 0;

    TextView textViewMain, textViewMain01, textViewMain02, textViewMain03, textViewMain04, textViewMain2,
            TextCountQestion, op1, op2, op3, op4, op5, TextPrac, Text_EnterCard1, Text_EnterCard2,
            Text_EnterCard3, Text_EnterCard4, Text_EnterCard5,
            Text_EnterCard6, Text_EnterCard7, Text_EnterCard8, Text_EnterCard9, Text_EnterCard0, Text_EnterCardDelet, Text_EnterCardNext;
    CardView c1, c2, c3, c4, c5, c6, c7, c8, c9, c0, cde, accept;
    String Term;
    int min, max, min3, max3;
    int Result2 = 0, Result = 0;
    int r11 = 1, Anser = 0;
    int BAM1 = 0, BAM2 = 0, BAM3 = 0, BAM4 = 0, BAM5 = 0, BAM6 = 0, BAM7 = 0, BAM8 = 0, BAM9 = 0, BAM10 = 0;
    int BAR1 = 0, BAR2 = 0, BAR3 = 0, BAR4 = 0, BAR5 = 0, BAR6 = 0, BAR7 = 0, BAR8 = 0, BAR9 = 0, BAR10 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_practice);

//        مقدار دهی مقادیر
        Initialize();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Term = extras.getString("Term2");
            SharedPreferences pref = getApplicationContext().getSharedPreferences("TermP", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("key_TermP", Term); // Storing string
            editor.commit(); // commit changes
        }
        SharedPreferences pref3 = getApplicationContext().getSharedPreferences("TermP", 0); // 0 - for private mode
        Term = pref3.getString("key_TermP", "");
//        برای مقدار دهی تایم
        gettime();
//  ست کردن فونت
        SetFont();
        SetData();
        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        c3.setOnClickListener(this);
        c4.setOnClickListener(this);
        c5.setOnClickListener(this);
        c6.setOnClickListener(this);
        c7.setOnClickListener(this);
        c8.setOnClickListener(this);
        c9.setOnClickListener(this);
        c0.setOnClickListener(this);
        cde.setOnClickListener(this);
        accept.setOnClickListener(this);
    }

    //    تابع فارسی ساز اعداد
    public static String faToEn(String num) {
        return num
                .replace("۰", "0")
                .replace("۱", "1")
                .replace("۲", "2")
                .replace("۳", "3")
                .replace("۴", "4")
                .replace("۵", "5")
                .replace("۶", "6")
                .replace("۷", "7")
                .replace("۸", "8")
                .replace("۹", "9");
    }

    private void SetData() {
        op5.setVisibility(View.VISIBLE);
        op3.setVisibility(View.VISIBLE);

        switch ("1") {
            case "1": {
                min = 1;
                max = 4;
                min3 = 9;
                max3 = 19;
                break;
            }
            case "2": {
                min = 1;
                max = 9;
                min3 = 10;
                max3 = 40;
                break;
            }
            case "3": {
                min = 1;
                max = 20;
                min3 = 40;
                max3 = 99;
                break;
            }
            case "4": {
                min = 1;
                max = 9;
                min3 = 10;
                max3 = 20;
                break;
            }
        }
        Random r = new Random();
        Count = r.nextInt(2 - 0 + 1) + 0;
        i1 = r.nextInt(max3 - min3 + 1) + min3;
        i2 = r.nextInt(max - min + 1) + min;
        i11 = r.nextInt(max3 - min3 + 1) + min3;
        i22 = r.nextInt(max - min + 1) + min;
        i0 = r.nextInt(max - min + 1) + min;

//        if (i1 == 4 && i2 > 1) {
//            i2 = 1;
//        }
//        if (i2 == 4 && i1 > 1) {
//            i1 = 1;
//        }
//        if (i2 == 3 && i1 == 3) {
//            i1 = 2;
//        }
//        if (Term.equals("3") && i2 >= 70 && i1 >=30 || Term.equals("3") && i1 >= 70 && i2 >= 30 ) {
//            int minn=0,maxx=9;
//            i1 = r.nextInt(maxx - minn + 1) + minn;
//        }
//        if ( Term.equals("3") && i1 >= 70 && i2 >=30 ) {
//            int minn=0,maxx=9;
//            i2 = r.nextInt(maxx - minn + 1) + minn;
//        }


        switch (Count) {
            case 0: {
                String y1 = String.valueOf(persian.PerisanNumber(String.valueOf(i1)));
                String y2 = String.valueOf(persian.PerisanNumber(String.valueOf(i2)));
                String y3 = String.valueOf(persian.PerisanNumber(String.valueOf(i0)));
                String y4 = String.valueOf(persian.PerisanNumber(String.valueOf(i11)));
                String y5 = String.valueOf(persian.PerisanNumber(String.valueOf(i22)));
                textViewMain.setText(y1);
                textViewMain01.setText(y2);
                textViewMain02.setText(y3);
                textViewMain03.setText(y4);
                textViewMain04.setText(y5);
//                op3.setVisibility(View.INVISIBLE);
//                op5.setVisibility(View.INVISIBLE);
                Result2 = Integer.parseInt(i1 + "") + Integer.parseInt(i2 + "")
                        - Integer.parseInt(i0 + "")
                        + Integer.parseInt(i11 + "") - Integer.parseInt(i22 + "");
// int w = i1+i2-i0+i11-i22;
                int w2 = Result2 - 2;
                String y6 = faToEn(w2 + "");
                Result = w2;
//                textViewMain2.setText(Result);
//                     SystemClock.sleep(2000);

                break;
            }
            case 1: {
//                int w = i1 + i2 - i0 + i11 + i22;
                String y1 = String.valueOf(persian.PerisanNumber(String.valueOf(i1)));
                String y2 = String.valueOf(persian.PerisanNumber(String.valueOf(i2)));
                String y3 = String.valueOf(persian.PerisanNumber(String.valueOf(i0)));
                String y4 = String.valueOf(persian.PerisanNumber(String.valueOf(i11)));
                String y5 = String.valueOf(persian.PerisanNumber(String.valueOf(i22)));
                textViewMain.setText(y1);
                textViewMain01.setText(y2);
                textViewMain02.setText(y3);
                textViewMain03.setText(y4);
                textViewMain04.setText(y5);
                op5.setVisibility(View.INVISIBLE);

                Result2 = Integer.parseInt(i1 + "") + Integer.parseInt(i2 + "")
                        - Integer.parseInt(i0 + "")
                        + Integer.parseInt(i11 + "") + Integer.parseInt(i22 + "");

                int w2 = Result2;
                String y6 = faToEn(w2 + "");
                Result = w2;

                break;
            }
            case 2: {
                String y1 = String.valueOf(persian.PerisanNumber(String.valueOf(i1)));
                String y2 = String.valueOf(persian.PerisanNumber(String.valueOf(i2)));
                String y3 = String.valueOf(persian.PerisanNumber(String.valueOf(i0)));
                String y4 = String.valueOf(persian.PerisanNumber(String.valueOf(i11)));
                String y5 = String.valueOf(persian.PerisanNumber(String.valueOf(i22)));
                textViewMain.setText(y1);
                textViewMain01.setText(y2);
                textViewMain02.setText(y3);
                textViewMain03.setText(y4);
                textViewMain04.setText(y5);
                op5.setVisibility(View.INVISIBLE);
                op3.setVisibility(View.INVISIBLE);
                Result2 = Integer.parseInt(i1 + "") + Integer.parseInt(i2 + "")
                        + Integer.parseInt(i0 + "")
                        + Integer.parseInt(i11 + "") + Integer.parseInt(i22 + "");


                int w2 = Result2 + 2;
                String y6 = faToEn(w2 + "");
                Result = w2;
                break;

            }
            case 3: {
//                int w = i1 + i2 - i0 + i11 + i22;
                String y1 = String.valueOf(persian.PerisanNumber(String.valueOf(i1)));
                String y2 = String.valueOf(persian.PerisanNumber(String.valueOf(i2)));
                String y3 = String.valueOf(persian.PerisanNumber(String.valueOf(i0)));
                String y4 = String.valueOf(persian.PerisanNumber(String.valueOf(i11)));
                String y5 = String.valueOf(persian.PerisanNumber(String.valueOf(i22)));
                textViewMain.setText(y1);
                textViewMain01.setText(y2);
                textViewMain02.setText(y3);
                textViewMain03.setText(y4);
                textViewMain04.setText(y5);
                op1.setVisibility(View.INVISIBLE);
                op2.setVisibility(View.INVISIBLE);
                op4.setVisibility(View.INVISIBLE);
                op5.setVisibility(View.INVISIBLE);

                int w = Integer.parseInt(textViewMain.getText().toString()) + Integer.parseInt(textViewMain01.getText().toString())
                        - Integer.parseInt(textViewMain02.getText().toString()) + Integer.parseInt(textViewMain03.getText().toString()) + Integer.parseInt(textViewMain04.getText().toString());


                Result2 = w;
                int w2 = w - 3;
                String y6 = faToEn(w2 + "");
                Result = w2;
                break;
            }
            case 4: {
//                int w = i1 + i2 - i0 + i11 - i22;
                String y1 = String.valueOf(persian.PerisanNumber(String.valueOf(i1)));
                String y2 = String.valueOf(persian.PerisanNumber(String.valueOf(i2)));
                String y3 = String.valueOf(persian.PerisanNumber(String.valueOf(i0)));
                String y4 = String.valueOf(persian.PerisanNumber(String.valueOf(i11)));
                String y5 = String.valueOf(persian.PerisanNumber(String.valueOf(i22)));
                textViewMain.setText(y1);
                textViewMain01.setText(y2);
                textViewMain02.setText(y3);
                textViewMain03.setText(y4);
                textViewMain04.setText(y5);
                op1.setVisibility(View.INVISIBLE);
                op2.setVisibility(View.INVISIBLE);
                op4.setVisibility(View.INVISIBLE);
                int w = Integer.parseInt(textViewMain.getText().toString()) + Integer.parseInt(textViewMain01.getText().toString())
                        - Integer.parseInt(textViewMain02.getText().toString()) + Integer.parseInt(textViewMain03.getText().toString()) - Integer.parseInt(textViewMain04.getText().toString());



                Result2 = w;
                int w2 = w - 4;
                String y6 = faToEn(w2 + "");
                Result = w2;
                break;
            }
            case 5: {
//                int w = i1 + i2 - i0 + i11 + i22;
                String y1 = String.valueOf(persian.PerisanNumber(String.valueOf(i1)));
                String y2 = String.valueOf(persian.PerisanNumber(String.valueOf(i2)));
                String y3 = String.valueOf(persian.PerisanNumber(String.valueOf(i0)));
                String y4 = String.valueOf(persian.PerisanNumber(String.valueOf(i11)));
                String y5 = String.valueOf(persian.PerisanNumber(String.valueOf(i22)));
                textViewMain.setText(y1);
                textViewMain01.setText(y2);
                textViewMain02.setText(y3);
                textViewMain03.setText(y4);
                textViewMain04.setText(y5);
                op1.setVisibility(View.INVISIBLE);
                op2.setVisibility(View.INVISIBLE);
                op4.setVisibility(View.INVISIBLE);
                op5.setVisibility(View.INVISIBLE);
                int w = Integer.parseInt(textViewMain.getText().toString()) + Integer.parseInt(textViewMain01.getText().toString())
                        - Integer.parseInt(textViewMain02.getText().toString()) + Integer.parseInt(textViewMain03.getText().toString()) + Integer.parseInt(textViewMain04.getText().toString());


                Result2 = w;
                int w2 = w + 1;
                String y6 = faToEn(w2 + "");
                Result = w2;
                break;
            }
            case 6: {
//                int w = i1 + i2 + i0 + i11 + i22;
                //                int w = i1 + i2 + i0 + i11 + i22;
                String y1 = String.valueOf(persian.PerisanNumber(String.valueOf(i1)));
                String y2 = String.valueOf(persian.PerisanNumber(String.valueOf(i2)));
                String y3 = String.valueOf(persian.PerisanNumber(String.valueOf(i0)));
                String y4 = String.valueOf(persian.PerisanNumber(String.valueOf(i11)));
                String y5 = String.valueOf(persian.PerisanNumber(String.valueOf(i22)));
                textViewMain.setText(y1);
                textViewMain01.setText(y2);
                textViewMain02.setText(y3);
                textViewMain03.setText(y4);
                textViewMain04.setText(y5);
                op1.setVisibility(View.INVISIBLE);
                op2.setVisibility(View.INVISIBLE);
                op4.setVisibility(View.INVISIBLE);
                op5.setVisibility(View.INVISIBLE);
                op3.setVisibility(View.INVISIBLE);
                int w = Integer.parseInt(textViewMain.getText().toString()) + Integer.parseInt(textViewMain01.getText().toString())
                        + Integer.parseInt(textViewMain02.getText().toString()) + Integer.parseInt(textViewMain03.getText().toString()) + Integer.parseInt(textViewMain04.getText().toString());


                Result2 = w;
                int w2 = w + 2;
                String y6 = faToEn(w2 + "");
                Result = w2;
                break;

            }
            case 7: {
//                int w = i1 + i2 - i0 + i11 + i22;
                String y1 = String.valueOf(persian.PerisanNumber(String.valueOf(i1)));
                String y2 = String.valueOf(persian.PerisanNumber(String.valueOf(i2)));
                String y3 = String.valueOf(persian.PerisanNumber(String.valueOf(i0)));
                String y4 = String.valueOf(persian.PerisanNumber(String.valueOf(i11)));
                String y5 = String.valueOf(persian.PerisanNumber(String.valueOf(i22)));
                textViewMain.setText(y1);
                textViewMain01.setText(y2);
                textViewMain02.setText(y3);
                textViewMain03.setText(y4);
                textViewMain04.setText(y5);
                op1.setVisibility(View.INVISIBLE);
                op2.setVisibility(View.INVISIBLE);
                op4.setVisibility(View.INVISIBLE);
                op5.setVisibility(View.INVISIBLE);
                int w = Integer.parseInt(textViewMain.getText().toString()) + Integer.parseInt(textViewMain01.getText().toString())
                        - Integer.parseInt(textViewMain02.getText().toString()) + Integer.parseInt(textViewMain03.getText().toString()) + Integer.parseInt(textViewMain04.getText().toString());



                Result2 = w;
                int w2 = w + 3;
                String y6 = faToEn(w2 + "");
                Result = w2;

                break;
            }
        }

    }

    public void onBackPressed() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(MyPractice.this);
        final View view = LayoutInflater.from(MyPractice.this).inflate(R.layout.dilog2, null);
//ست کردن لایه سفرشی به الرت دیالوگ
        Button buttonYes = view.findViewById(R.id.Text_YesButton);
        Button buttonNo = view.findViewById(R.id.Text_NoButton);

        builder.setCancelable(false);
        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MyPractice.this, Term1.class);
                startActivity(in);
                System.exit(0);
                finish();
            }
        });
        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MyPractice.this, Practice.class);
                startActivity(in);
                System.exit(0);
                finish();
            }
        });
        builder.setView(view);
        builder.show();


    }

    private void SetFont() {
        Typeface tf = Typeface.createFromAsset(getAssets(), "font/irsans.ttf");
        txt_timer.setTypeface(tf);
        textViewMain2.setTypeface(tf);
        textViewMain01.setTypeface(tf);
        textViewMain02.setTypeface(tf);
        textViewMain03.setTypeface(tf);
        textViewMain04.setTypeface(tf);
        TextCountQestion.setTypeface(tf);
        TextPrac.setTypeface(tf);

        Text_EnterCard0.setTypeface(tf);
        Text_EnterCard1.setTypeface(tf);
        Text_EnterCard2.setTypeface(tf);
        Text_EnterCard3.setTypeface(tf);
        Text_EnterCard4.setTypeface(tf);
        Text_EnterCard5.setTypeface(tf);
        Text_EnterCard6.setTypeface(tf);
        Text_EnterCard7.setTypeface(tf);
        Text_EnterCard8.setTypeface(tf);
        Text_EnterCard9.setTypeface(tf);
        Text_EnterCardDelet.setTypeface(tf);
        Text_EnterCardNext.setTypeface(tf);
    }

    private void Initialize() {
//       CardView
        c0 = (CardView) findViewById(R.id.EnterCard0);
        c1 = (CardView) findViewById(R.id.EnterCard1);
        c2 = (CardView) findViewById(R.id.EnterCard2);
        c3 = (CardView) findViewById(R.id.EnterCard3);
        c4 = (CardView) findViewById(R.id.EnterCard4);
        c5 = (CardView) findViewById(R.id.EnterCard5);
        c6 = (CardView) findViewById(R.id.EnterCard6);
        c7 = (CardView) findViewById(R.id.EnterCard7);
        c8 = (CardView) findViewById(R.id.EnterCard8);
        c9 = (CardView) findViewById(R.id.EnterCard9);
        cde = (CardView) findViewById(R.id.EnterCarddelet);
        accept = (CardView) findViewById(R.id.EnterCardaccept);


//        TextView
        txt_timer = findViewById(R.id.IdTimer);
        textViewMain = (TextView) findViewById(R.id.textViewMain0);
        textViewMain2 = (TextView) findViewById(R.id.textViewMain022);
        textViewMain01 = (TextView) findViewById(R.id.textViewMain001);
        textViewMain02 = (TextView) findViewById(R.id.textViewMain002);
        textViewMain03 = (TextView) findViewById(R.id.textViewMain003);
        textViewMain04 = (TextView) findViewById(R.id.textViewMain004);
        op1 = (TextView) findViewById(R.id.Op1);
        op2 = (TextView) findViewById(R.id.Op2);
        op3 = (TextView) findViewById(R.id.Op3);
        op4 = (TextView) findViewById(R.id.Op4);
        op5 = (TextView) findViewById(R.id.Op5);
        TextCountQestion = findViewById(R.id.TextCountQestion);
        TextPrac = findViewById(R.id.TextPrac);

        Text_EnterCard1 = findViewById(R.id.Text_EnterCard1);
        Text_EnterCard2 = findViewById(R.id.Text_EnterCard2);
        Text_EnterCard3 = findViewById(R.id.Text_EnterCard3);
        Text_EnterCard4 = findViewById(R.id.Text_EnterCard4);
        Text_EnterCard5 = findViewById(R.id.Text_EnterCard5);
        Text_EnterCard6 = findViewById(R.id.Text_EnterCard6);
        Text_EnterCard7 = findViewById(R.id.Text_EnterCard7);
        Text_EnterCard8 = findViewById(R.id.Text_EnterCard8);
        Text_EnterCard9 = findViewById(R.id.Text_EnterCard9);
        Text_EnterCard0 = findViewById(R.id.Text_EnterCard0);

        Text_EnterCardDelet = findViewById(R.id.Text_Enter_DeleteText);
        Text_EnterCardNext = findViewById(R.id.Text_Enter_AcceptText);


    }

    void gettime() {
        timercount = 0;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        timercount += 1000;
                        txt_timer.setText(gettimergn(timercount));
                        if (timercount == 3 * 60000) {
                            timer.cancel();
//                            txt_timer.setText("00 : 00 ");
                            MediaPlayer Pakhsh_bib = MediaPlayer.create(MyPractice.this, R.raw.mu);
                            Pakhsh_bib.start();
//                             دیالوگ پایان تمرین
                            new iOSDialogBuilder(MyPractice.this)
                                    .setTitle(getString(R.string.example_title))
                                    .setSubtitle(getString(R.string.example_subtitle))
                                    .setBoldPositiveLabel(true)
                                    .setCancelable(false)
                                    .setPositiveListener(getString(R.string.ok), new iOSDialogClickListener() {
                                        @Override
                                        public void onClick(iOSDialog dialog) {
                                            dialog.dismiss();
                                            Intent in = new Intent(MyPractice.this, MyPractceRating.class);
                                            in.putExtra("BAR1", BAR1);
                                            in.putExtra("BAR2", BAR2);
                                            in.putExtra("BAR3", BAR3);
                                            in.putExtra("BAR4", BAR4);
                                            in.putExtra("BAR5", BAR5);
                                            in.putExtra("BAR6", BAR6);
                                            in.putExtra("BAR7", BAR7);
                                            in.putExtra("BAR8", BAR8);
                                            in.putExtra("BAR9", BAR9);
                                            in.putExtra("BAR10", BAR10);

                                            in.putExtra("BAM1", BAM1);
                                            in.putExtra("BAM2", BAM2);
                                            in.putExtra("BAM3", BAM3);
                                            in.putExtra("BAM4", BAM4);
                                            in.putExtra("BAM5", BAM5);
                                            in.putExtra("BAM6", BAM6);
                                            in.putExtra("BAM7", BAM7);
                                            in.putExtra("BAM8", BAM8);
                                            in.putExtra("BAM9", BAM9);
                                            in.putExtra("BAM10", BAM10);
                                            startActivity(in);
                                            System.exit(0);

                                        }
                                    })
                                    .setNegativeListener(getString(R.string.dismiss), new iOSDialogClickListener() {
                                        @Override
                                        public void onClick(iOSDialog dialog) {
                                            dialog.dismiss();
                                            Intent in = new Intent(MyPractice.this, MyPractice.class);
                                            startActivity(in);
                                            System.exit(0);
                                        }
                                    })
                                    .build().show();


//                            txt_timer.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.Backgrand_Edittext));
                        }
//                        else if (timercount < 10000 && timercount > 0) {
//                            txt_timer.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink));
//                            blink();
//                        }
                    }
                });
            }
        }, 0, 1000);
    }


    public String gettimergn(long timercount) {
        long secound = (timercount / 1000);
        long mint = secound / 60;
        secound %= 60;
        return String.format(Locale.ENGLISH, "%02d", mint) + " : " + String.format(Locale.ENGLISH, "%02d", secound);
    }

    @Override
    public void onClick(View v) {
        if (!textViewMain2.getText().toString().equals("?") && !textViewMain2.getText().toString().equals("")) {
            Anser = Integer.parseInt(textViewMain2.getText().toString());
        } else {
            Anser = 0;
        }
        int id = v.getId();
        if (textViewMain2.getText().toString().equals("?")) {
            textViewMain2.setText("");
        }
        switch (id) {
            case R.id.EnterCardaccept: {

                if (r11 <= 10) {

                    switch (r11) {
                        case 1: {

                            BAM1 = Anser;
                            BAR1 = Result2;

                            break;
                        }
                        case 2: {

                            BAM2 = Anser;
                            BAR2 = Result2;

                            break;
                        }
                        case 3: {

                            BAM3 = Anser;
                            BAR3 = Result2;

                            break;
                        }
                        case 4: {

                            BAM4 = Anser;
                            BAR4 = Result2;

                            break;
                        }
                        case 5: {

                            BAM5 = Anser;
                            BAR5 = Result2;

                            break;
                        }
                        case 6: {

                            BAM6 = Anser;
                            BAR6 = Result2;
                            break;
                        }
                        case 7: {

                            BAM7 = Anser;
                            BAR7 = Result2;
                            break;
                        }
                        case 8: {

                            BAM8 = Anser;
                            BAR8 = Result2;

                            break;
                        }
                        case 9: {

                            BAM9 = Anser;
                            BAR9 = Result2;

                            break;
                        }

                        case 10: {

                            BAM10 = Anser;
                            BAR10 = Result2;
                            break;
                        }
                    }
                    r11++;
                    if (r11 <= 10) {
                        SetData();
                        textViewMain2.setText("?");
                        String text = String.valueOf(persian.PerisanNumber(String.valueOf(r11))) + "/" + String.valueOf(persian.PerisanNumber(String.valueOf(10)));
                        TextCountQestion.setText(text);
                    }

                } else {
                    MediaPlayer Pakhsh_bib = MediaPlayer.create(MyPractice.this, R.raw.mu);
                    Pakhsh_bib.start();
                    new iOSDialogBuilder(MyPractice.this)
                            .setTitle(getString(R.string.example_title))
                            .setSubtitle(getString(R.string.example_subtitle))
                            .setBoldPositiveLabel(true)
                            .setCancelable(false)
                            .setPositiveListener(getString(R.string.ok), new iOSDialogClickListener() {
                                @Override
                                public void onClick(iOSDialog dialog) {
                                    dialog.dismiss();
                                    Intent in = new Intent(MyPractice.this, MyPractceRating.class);
                                    in.putExtra("BAR1", BAR1);
                                    in.putExtra("BAR2", BAR2);
                                    in.putExtra("BAR3", BAR3);
                                    in.putExtra("BAR4", BAR4);
                                    in.putExtra("BAR5", BAR5);
                                    in.putExtra("BAR6", BAR6);
                                    in.putExtra("BAR7", BAR7);
                                    in.putExtra("BAR8", BAR8);
                                    in.putExtra("BAR9", BAR9);
                                    in.putExtra("BAR10", BAR10);

                                    in.putExtra("BAM1", BAM1);
                                    in.putExtra("BAM2", BAM2);
                                    in.putExtra("BAM3", BAM3);
                                    in.putExtra("BAM4", BAM4);
                                    in.putExtra("BAM5", BAM5);
                                    in.putExtra("BAM6", BAM6);
                                    in.putExtra("BAM7", BAM7);
                                    in.putExtra("BAM8", BAM8);
                                    in.putExtra("BAM9", BAM9);
                                    in.putExtra("BAM10", BAM10);

                                    startActivity(in);
                                    System.exit(0);


                                }
                            })
                            .setNegativeListener(getString(R.string.dismiss), new iOSDialogClickListener() {
                                @Override
                                public void onClick(iOSDialog dialog) {
                                    dialog.dismiss();
                                    Intent in = new Intent(MyPractice.this, MyPractice.class);
                                    startActivity(in);
                                    System.exit(0);
                                }
                            })
                            .build().show();
                }
                break;
            }
            case R.id.EnterCard0: {
                String s11 = textViewMain2.getText().toString();
                String i20 = persian.PerisanNumber(String.valueOf(s11));
                String i10 = persian.PerisanNumber(String.valueOf(0));
                String s113 = i20.concat(i10);
                textViewMain2.setText(s113);
                break;
            }
            case R.id.EnterCard1: {
                String s11 = textViewMain2.getText().toString();
                String i20 = persian.PerisanNumber(String.valueOf(s11));
                String i10 = persian.PerisanNumber(String.valueOf(1));
                String s113 = i20.concat(i10);
                textViewMain2.setText(s113);

                break;
            }
            case R.id.EnterCard2: {
                String s11 = textViewMain2.getText().toString();
                String i20 = persian.PerisanNumber(String.valueOf(s11));
                String i10 = persian.PerisanNumber(String.valueOf(2));
                String s113 = i20.concat(i10);
                textViewMain2.setText(s113);
                break;
            }
            case R.id.EnterCard3: {
                String s11 = textViewMain2.getText().toString();

                String i20 = persian.PerisanNumber(String.valueOf(s11));
                String i10 = persian.PerisanNumber(String.valueOf(3));
                String s113 = i20.concat(i10);
                textViewMain2.setText(s113);

                break;
            }
            case R.id.EnterCard4: {
                String s11 = textViewMain2.getText().toString();

                String i20 = persian.PerisanNumber(String.valueOf(s11));
                String i10 = persian.PerisanNumber(String.valueOf(4));
                String s113 = i20.concat(i10);
                textViewMain2.setText(s113);
                break;
            }
            case R.id.EnterCard5: {
                String s11 = textViewMain2.getText().toString();
                String i20 = persian.PerisanNumber(String.valueOf(s11));
                String i10 = persian.PerisanNumber(String.valueOf(5));
                String s113 = i20.concat(i10);
                textViewMain2.setText(s113);
                break;
            }
            case R.id.EnterCard6: {
                String s11 = textViewMain2.getText().toString();
                String i20 = persian.PerisanNumber(String.valueOf(s11));
                String i10 = persian.PerisanNumber(String.valueOf(6));
                String s113 = i20.concat(i10);
                textViewMain2.setText(s113);
                break;
            }
            case R.id.EnterCard7: {
                String s11 = textViewMain2.getText().toString();
                String i20 = persian.PerisanNumber(String.valueOf(s11));
                String i10 = persian.PerisanNumber(String.valueOf(7));
                String s113 = i20.concat(i10);
                textViewMain2.setText(s113);
                break;

            }
            case R.id.EnterCard8: {
                String s11 = textViewMain2.getText().toString();
                String i20 = persian.PerisanNumber(String.valueOf(s11));
                String i10 = persian.PerisanNumber(String.valueOf(8));
                String s113 = i20.concat(i10);
                textViewMain2.setText(s113);
                break;
            }
            case R.id.EnterCard9: {
                String s11 = textViewMain2.getText().toString();
                String i20 = persian.PerisanNumber(String.valueOf(s11));
                String i10 = persian.PerisanNumber(String.valueOf(9));
                String s113 = i20.concat(i10);
                textViewMain2.setText(s113);
                break;
            }
            case R.id.EnterCarddelet: {

                String qw = textViewMain2.getText().toString();

                if (qw.length() > 0) {
                    qw = qw.substring(0, qw.length() - 1);
                }
                textViewMain2.setText(qw);
                if (qw.equals("")) {
                    textViewMain2.setText("?");
                }

                break;
            }
        }
    }
}
