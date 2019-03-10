package com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.farshid.myproject_robofa.R;

import org.w3c.dom.Text;

import java.util.Random;

public class Practice2 extends AppCompatActivity implements View.OnClickListener {

    CardView Card1, Card2, Card3, Card4;
    TextView TextCard1, TextCard2, TextCard3, TextCard4;
    ProgressBar progressBar;
    private int mProgressbarStatus = 0, mProgressbarStatus2 = 0;
    ImageView ImageUnaccept, Image_accept, back;
    private Handler mhandler = new Handler();
    int i1, i2, i11, i22;
    String Result = "", Result2 = "", Result3 = "", Result4 = "";
    TextView textViewMain, textViewMain2, MainPage_Practice_toolbar_question;
    int Point = 0, Point3 = 0, point2 = 0;
    int Count = 0;
    int Count_Question = 1;
    CardView card1, card2;
    int Anser = 0;
    MediaPlayer mediaPlayer;
    private int time_interval = 2000;
    private long oldCurrentTimeMillis;
    String Term;
    int min, max, min3, max3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice2);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Term = extras.getString("Term22");
            SharedPreferences pref = getApplicationContext().getSharedPreferences("TermP2", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("key_TermP2", Term); // Storing string
            editor.commit(); // commit changes
        }
        SharedPreferences pref3 = getApplicationContext().getSharedPreferences("TermP2", 0); // 0 - for private mode
        Term = pref3.getString("key_TermP2", "");
        Initialize();
        mediaPlayer = MediaPlayer.create(this, R.raw.mu);
        Setdata();

        Card1.setOnClickListener(this);
        Card2.setOnClickListener(this);
        Card3.setOnClickListener(this);
        Card4.setOnClickListener(this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(Practice2.this, Term1.class);
                startActivity(in);
            }
        });
    }

    private void Card1() {
        int i31 = i1 + i2;
        String i3 = String.valueOf(i31);
        if (TextCard1.getText().toString().equals(Result2)) {
            Point++;
            new Thread(new Runnable() {
                public void run() {
                    try {
                        mediaPlayer.start();
                        Thread.sleep(2000);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            Count_Question++;
            if (Anser == 3) {
                Card2.setEnabled(false);
                Card3.setEnabled(false);
                Card4.setEnabled(false);
                Card2.setCardBackgroundColor(Color.GRAY);
                Card3.setCardBackgroundColor(Color.GRAY);
                Card4.setCardBackgroundColor(Color.GRAY);
                progressBar.setProgress(100);
                AlertDialog.Builder builder = new AlertDialog.Builder(Practice2.this);
                View view = LayoutInflater.from(Practice2.this).inflate(R.layout.dilog, null);
//ست کردن لایه سفرشی به الرت دیالوگ
                TextView TextAcc = view.findViewById(R.id.text_Accept);
                TextView Max_Record = view.findViewById(R.id.Text_MaxRecord);
                Button button = view.findViewById(R.id.Button_dilog);
                builder.setCancelable(false);
                SharedPreferences pref3 = getApplicationContext().getSharedPreferences("Point22", 0); // 0 - for private mode
                if (Term.equals("1")) {
                    point2 = pref3.getInt("key_Point12", 0);
                } else if (Term.equals("2")) {
                    point2 = pref3.getInt("key_Point22", 0);

                } else if (Term.equals("3")) {
                    point2 = pref3.getInt("key_Point32", 0);

                } else if (Term.equals("4")) {
                    point2 = pref3.getInt("key_Point42", 0);
                }

                if (Point > point2) {
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("Point22", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    if (Term.equals("1")) {
                        editor.putInt("key_Point12", Point); // Storing string
                        editor.commit(); // commit changes
                    } else if (Term.equals("2")) {
                        editor.putInt("key_Point22", Point); // Storing string
                        editor.commit(); // commit changes
                    } else if (Term.equals("3")) {
                        editor.putInt("key_Point32", Point); // Storing string
                        editor.commit(); // commit changes
                    } else if (Term.equals("4")) {
                        editor.putInt("key_Point42", Point); // Storing string
                        editor.commit(); // commit changes
                    }

                    Point3 = Point;
                } else {
                    Point3 = point2;
                }
                TextAcc.setText(Point + "");
                Max_Record.setText(Point3 + "");
                builder.setPositiveButton("بله", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent in = new Intent(Practice2.this, Practice.class);
                        startActivity(in);

                    }

                });
                builder.setNegativeButton("خیر", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent in = new Intent(Practice2.this, Term1.class);
                        startActivity(in);
                        finish();
                        System.exit(0);
                    }
                });
                builder.setView(view);
                builder.show();
            } else {

                String y = Count_Question + "/10";
                MainPage_Practice_toolbar_question.setText(y);
                Setdata();
            }


        } else {
            Anser++;
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(1000);
            Count_Question++;
            if (Anser == 3) {
                Card2.setEnabled(false);
                Card3.setEnabled(false);
                Card4.setEnabled(false);
                Card2.setCardBackgroundColor(Color.GRAY);
                Card3.setCardBackgroundColor(Color.GRAY);
                Card4.setCardBackgroundColor(Color.GRAY);
                progressBar.setProgress(100);
                AlertDialog.Builder builder = new AlertDialog.Builder(Practice2.this);
                View view = LayoutInflater.from(Practice2.this).inflate(R.layout.dilog, null);
//ست کردن لایه سفرشی به الرت دیالوگ
                TextView TextAcc = view.findViewById(R.id.text_Accept);
                TextView Max_Record = view.findViewById(R.id.Text_MaxRecord);
                Button button = view.findViewById(R.id.Button_dilog);
                builder.setCancelable(false);
                SharedPreferences pref3 = getApplicationContext().getSharedPreferences("Point22", 0); // 0 - for private mode
                if (Term.equals("1")) {
                    point2 = pref3.getInt("key_Point12", 0);
                } else if (Term.equals("2")) {
                    point2 = pref3.getInt("key_Point22", 0);

                } else if (Term.equals("3")) {
                    point2 = pref3.getInt("key_Point32", 0);

                } else if (Term.equals("4")) {
                    point2 = pref3.getInt("key_Point42", 0);
                }

                if (Point > point2) {
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("Point22", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    if (Term.equals("1")) {
                        editor.putInt("key_Point12", Point); // Storing string
                        editor.commit(); // commit changes
                    } else if (Term.equals("2")) {
                        editor.putInt("key_Point22", Point); // Storing string
                        editor.commit(); // commit changes
                    } else if (Term.equals("3")) {
                        editor.putInt("key_Point32", Point); // Storing string
                        editor.commit(); // commit changes
                    } else if (Term.equals("4")) {
                        editor.putInt("key_Point42", Point); // Storing string
                        editor.commit(); // commit changes
                    }
                    Point3 = Point;
                } else {
                    Point3 = point2;
                }
                TextAcc.setText(Point + "");
                Max_Record.setText(Point3 + "");
                builder.setPositiveButton("بله", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent in = new Intent(Practice2.this, Practice.class);
                        startActivity(in);

                    }

                });
                builder.setNegativeButton("خیر", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent in = new Intent(Practice2.this, Term1.class);
                        startActivity(in);
                        finish();
                        System.exit(0);
                    }
                });
                builder.setView(view);
                builder.show();

            } else {
                String y = Count_Question + "/10";
                MainPage_Practice_toolbar_question.setText(y);
                Setdata();
            }

        }

    }

    private void Card2() {
        int i31 = i1 + i2;
        String i3 = String.valueOf(i31);
        if (TextCard2.getText().toString().equals(Result2)) {
            Point++;
            new Thread(new Runnable() {
                public void run() {
                    try {
                        mediaPlayer.start();
                        Thread.sleep(2000);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            Count_Question++;
            if (Anser == 3) {
                Card1.setEnabled(false);
                Card3.setEnabled(false);
                Card4.setEnabled(false);
                Card1.setCardBackgroundColor(Color.GRAY);
                Card3.setCardBackgroundColor(Color.GRAY);
                Card4.setCardBackgroundColor(Color.GRAY);
                progressBar.setProgress(100);
                AlertDialog.Builder builder = new AlertDialog.Builder(Practice2.this);
                View view = LayoutInflater.from(Practice2.this).inflate(R.layout.dilog, null);
//ست کردن لایه سفرشی به الرت دیالوگ
                TextView TextAcc = view.findViewById(R.id.text_Accept);
                TextView Max_Record = view.findViewById(R.id.Text_MaxRecord);
                Button button = view.findViewById(R.id.Button_dilog);
                builder.setCancelable(false);
                SharedPreferences pref3 = getApplicationContext().getSharedPreferences("Point22", 0); // 0 - for private mode
                if (Term.equals("1")) {
                    point2 = pref3.getInt("key_Point12", 0);
                } else if (Term.equals("2")) {
                    point2 = pref3.getInt("key_Point22", 0);

                } else if (Term.equals("3")) {
                    point2 = pref3.getInt("key_Point32", 0);

                } else if (Term.equals("4")) {
                    point2 = pref3.getInt("key_Point42", 0);
                }

                if (Point > point2) {
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("Point22", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    if (Term.equals("1")) {
                        editor.putInt("key_Point12", Point); // Storing string
                        editor.commit(); // commit changes
                    } else if (Term.equals("2")) {
                        editor.putInt("key_Point22", Point); // Storing string
                        editor.commit(); // commit changes
                    } else if (Term.equals("3")) {
                        editor.putInt("key_Point32", Point); // Storing string
                        editor.commit(); // commit changes
                    } else if (Term.equals("4")) {
                        editor.putInt("key_Point42", Point); // Storing string
                        editor.commit(); // commit changes
                    }

                    Point3 = Point;
                } else {
                    Point3 = point2;
                }
                TextAcc.setText(Point + "");
                Max_Record.setText(Point3 + "");
                builder.setPositiveButton("بله", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent in = new Intent(Practice2.this, Practice.class);
                        startActivity(in);

                    }

                });
                builder.setNegativeButton("خیر", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent in = new Intent(Practice2.this, Term1.class);
                        startActivity(in);
                        finish();
                        System.exit(0);
                    }
                });
                builder.setView(view);
                builder.show();
            } else {

                String y = Count_Question + "/10";
                MainPage_Practice_toolbar_question.setText(y);
                Setdata();
            }


        } else {
            Anser++;
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(1000);
            Count_Question++;
            if (Anser == 3) {
                Card1.setEnabled(false);
                Card3.setEnabled(false);
                Card4.setEnabled(false);
                Card1.setCardBackgroundColor(Color.GRAY);
                Card3.setCardBackgroundColor(Color.GRAY);
                Card4.setCardBackgroundColor(Color.GRAY);
                progressBar.setProgress(100);
                AlertDialog.Builder builder = new AlertDialog.Builder(Practice2.this);
                View view = LayoutInflater.from(Practice2.this).inflate(R.layout.dilog, null);
//ست کردن لایه سفرشی به الرت دیالوگ
                TextView TextAcc = view.findViewById(R.id.text_Accept);
                TextView Max_Record = view.findViewById(R.id.Text_MaxRecord);
                Button button = view.findViewById(R.id.Button_dilog);
                builder.setCancelable(false);
                SharedPreferences pref3 = getApplicationContext().getSharedPreferences("Point22", 0); // 0 - for private mode
                if (Term.equals("1")) {
                    point2 = pref3.getInt("key_Point12", 0);
                } else if (Term.equals("2")) {
                    point2 = pref3.getInt("key_Point22", 0);

                } else if (Term.equals("3")) {
                    point2 = pref3.getInt("key_Point32", 0);

                } else if (Term.equals("4")) {
                    point2 = pref3.getInt("key_Point42", 0);
                }

                if (Point > point2) {
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("Point22", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    if (Term.equals("1")) {
                        editor.putInt("key_Point12", Point); // Storing string
                        editor.commit(); // commit changes
                    } else if (Term.equals("2")) {
                        editor.putInt("key_Point22", Point); // Storing string
                        editor.commit(); // commit changes
                    } else if (Term.equals("3")) {
                        editor.putInt("key_Point32", Point); // Storing string
                        editor.commit(); // commit changes
                    } else if (Term.equals("4")) {
                        editor.putInt("key_Point42", Point); // Storing string
                        editor.commit(); // commit changes
                    }
                    Point3 = Point;
                } else {
                    Point3 = point2;
                }
                TextAcc.setText(Point + "");
                Max_Record.setText(Point3 + "");
                builder.setPositiveButton("بله", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent in = new Intent(Practice2.this, Practice.class);
                        startActivity(in);

                    }

                });
                builder.setNegativeButton("خیر", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent in = new Intent(Practice2.this, Term1.class);
                        startActivity(in);
                        finish();
                        System.exit(0);
                    }
                });
                builder.setView(view);
                builder.show();

            } else {
                String y = Count_Question + "/10";
                MainPage_Practice_toolbar_question.setText(y);
                Setdata();
            }

        }

    }

    private void Card3() {
        int i31 = i1 + i2;
        String i3 = String.valueOf(i31);
        if (TextCard3.getText().toString().equals(Result2)) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        mediaPlayer.start();
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            Point++;
            Count_Question++;
            if (Anser == 3) {
                Card1.setEnabled(false);
                Card2.setEnabled(false);
                Card4.setEnabled(false);
                Card1.setCardBackgroundColor(Color.GRAY);
                Card2.setCardBackgroundColor(Color.GRAY);
                Card4.setCardBackgroundColor(Color.GRAY);
                progressBar.setProgress(100);
                AlertDialog.Builder builder = new AlertDialog.Builder(Practice2.this);
                View view = LayoutInflater.from(Practice2.this).inflate(R.layout.dilog, null);
//ست کردن لایه سفرشی به الرت دیالوگ
                TextView TextAcc = view.findViewById(R.id.text_Accept);
                TextView Max_Record = view.findViewById(R.id.Text_MaxRecord);
                Button button = view.findViewById(R.id.Button_dilog);
                builder.setCancelable(false);
                SharedPreferences pref3 = getApplicationContext().getSharedPreferences("Point22", 0); // 0 - for private mode
                if (Term.equals("1")) {
                    point2 = pref3.getInt("key_Point12", 0);
                } else if (Term.equals("2")) {
                    point2 = pref3.getInt("key_Point22", 0);

                } else if (Term.equals("3")) {
                    point2 = pref3.getInt("key_Point32", 0);

                } else if (Term.equals("4")) {
                    point2 = pref3.getInt("key_Point42", 0);
                }

                if (Point > point2) {
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("Point22", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    if (Term.equals("1")) {
                        editor.putInt("key_Point12", Point); // Storing string
                        editor.commit(); // commit changes
                    } else if (Term.equals("2")) {
                        editor.putInt("key_Point22", Point); // Storing string
                        editor.commit(); // commit changes
                    } else if (Term.equals("3")) {
                        editor.putInt("key_Point32", Point); // Storing string
                        editor.commit(); // commit changes
                    } else if (Term.equals("4")) {
                        editor.putInt("key_Point42", Point); // Storing string
                        editor.commit(); // commit changes
                    }

                    Point3 = Point;
                } else {
                    Point3 = point2;
                }
                TextAcc.setText(Point + "");
                Max_Record.setText(Point3 + "");
                builder.setPositiveButton("بله", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent in = new Intent(Practice2.this, Practice.class);
                        startActivity(in);

                    }

                });
                builder.setNegativeButton("خیر", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent in = new Intent(Practice2.this, Term1.class);
                        startActivity(in);
                        finish();
                        System.exit(0);
                    }
                });
                builder.setView(view);
                builder.show();
            } else {

                String y = Count_Question + "/10";
                MainPage_Practice_toolbar_question.setText(y);
                Setdata();
            }


        } else {
            Anser++;
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(1000);
            Count_Question++;
            if (Anser == 3) {
                Card1.setEnabled(false);
                Card2.setEnabled(false);
                Card4.setEnabled(false);
                Card1.setCardBackgroundColor(Color.GRAY);
                Card2.setCardBackgroundColor(Color.GRAY);
                Card4.setCardBackgroundColor(Color.GRAY);
                progressBar.setProgress(100);
                AlertDialog.Builder builder = new AlertDialog.Builder(Practice2.this);
                View view = LayoutInflater.from(Practice2.this).inflate(R.layout.dilog, null);
//ست کردن لایه سفرشی به الرت دیالوگ
                TextView TextAcc = view.findViewById(R.id.text_Accept);
                TextView Max_Record = view.findViewById(R.id.Text_MaxRecord);
                Button button = view.findViewById(R.id.Button_dilog);
                builder.setCancelable(false);
                SharedPreferences pref3 = getApplicationContext().getSharedPreferences("Point22", 0); // 0 - for private mode
                if (Term.equals("1")) {
                    point2 = pref3.getInt("key_Point12", 0);
                } else if (Term.equals("2")) {
                    point2 = pref3.getInt("key_Point22", 0);

                } else if (Term.equals("3")) {
                    point2 = pref3.getInt("key_Point32", 0);

                } else if (Term.equals("4")) {
                    point2 = pref3.getInt("key_Point42", 0);
                }

                if (Point > point2) {
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("Point22", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    if (Term.equals("1")) {
                        editor.putInt("key_Point12", Point); // Storing string
                        editor.commit(); // commit changes
                    } else if (Term.equals("2")) {
                        editor.putInt("key_Point22", Point); // Storing string
                        editor.commit(); // commit changes
                    } else if (Term.equals("3")) {
                        editor.putInt("key_Point32", Point); // Storing string
                        editor.commit(); // commit changes
                    } else if (Term.equals("4")) {
                        editor.putInt("key_Point42", Point); // Storing string
                        editor.commit(); // commit changes
                    }
                    Point3 = Point;
                } else {
                    Point3 = point2;
                }
                TextAcc.setText(Point + "");
                Max_Record.setText(Point3 + "");
                builder.setPositiveButton("بله", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent in = new Intent(Practice2.this, Practice.class);
                        startActivity(in);

                    }

                });
                builder.setNegativeButton("خیر", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent in = new Intent(Practice2.this, Term1.class);
                        startActivity(in);
                        finish();
                        System.exit(0);
                    }
                });
                builder.setView(view);
                builder.show();

            } else {
                String y = Count_Question + "/10";
                MainPage_Practice_toolbar_question.setText(y);
                Setdata();
            }

        }

    }

    private void Card4() {
        int i31 = i1 + i2;
        String i3 = String.valueOf(i31);
        if (TextCard4.getText().toString().equals(Result2)) {
            Point++;
            new Thread(new Runnable() {
                public void run() {
                    try {
                        mediaPlayer.start();
                        Thread.sleep(2000);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            Count_Question++;
            if (Anser == 3) {
                Card1.setEnabled(false);
                Card2.setEnabled(false);
                Card3.setEnabled(false);
                Card1.setCardBackgroundColor(Color.GRAY);
                Card2.setCardBackgroundColor(Color.GRAY);
                Card3.setCardBackgroundColor(Color.GRAY);
                progressBar.setProgress(100);
                AlertDialog.Builder builder = new AlertDialog.Builder(Practice2.this);
                View view = LayoutInflater.from(Practice2.this).inflate(R.layout.dilog, null);
//ست کردن لایه سفرشی به الرت دیالوگ
                TextView TextAcc = view.findViewById(R.id.text_Accept);
                TextView Max_Record = view.findViewById(R.id.Text_MaxRecord);
                Button button = view.findViewById(R.id.Button_dilog);
                builder.setCancelable(false);
                SharedPreferences pref3 = getApplicationContext().getSharedPreferences("Point22", 0); // 0 - for private mode
                if (Term.equals("1")) {
                    point2 = pref3.getInt("key_Point12", 0);
                } else if (Term.equals("2")) {
                    point2 = pref3.getInt("key_Point22", 0);

                } else if (Term.equals("3")) {
                    point2 = pref3.getInt("key_Point32", 0);

                } else if (Term.equals("4")) {
                    point2 = pref3.getInt("key_Point42", 0);
                }

                if (Point > point2) {
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("Point22", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    if (Term.equals("1")) {
                        editor.putInt("key_Point12", Point); // Storing string
                        editor.commit(); // commit changes
                    } else if (Term.equals("2")) {
                        editor.putInt("key_Point22", Point); // Storing string
                        editor.commit(); // commit changes
                    } else if (Term.equals("3")) {
                        editor.putInt("key_Point32", Point); // Storing string
                        editor.commit(); // commit changes
                    } else if (Term.equals("4")) {
                        editor.putInt("key_Point42", Point); // Storing string
                        editor.commit(); // commit changes
                    }

                    Point3 = Point;
                } else {
                    Point3 = point2;
                }
                TextAcc.setText(Point + "");
                Max_Record.setText(Point3 + "");
                builder.setPositiveButton("بله", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent in = new Intent(Practice2.this, Practice.class);
                        startActivity(in);

                    }

                });
                builder.setNegativeButton("خیر", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent in = new Intent(Practice2.this, Term1.class);
                        startActivity(in);
                        finish();
                        System.exit(0);
                    }
                });
                builder.setView(view);
                builder.show();
            } else {

                String y = Count_Question + "/10";
                MainPage_Practice_toolbar_question.setText(y);
                Setdata();
            }


        } else {
            Anser++;
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(1000);
            Count_Question++;
            if (Anser == 3) {
                Card1.setEnabled(false);
                Card2.setEnabled(false);
                Card3.setEnabled(false);
                Card1.setCardBackgroundColor(Color.GRAY);
                Card2.setCardBackgroundColor(Color.GRAY);
                Card3.setCardBackgroundColor(Color.GRAY);
                progressBar.setProgress(100);
                AlertDialog.Builder builder = new AlertDialog.Builder(Practice2.this);
                View view = LayoutInflater.from(Practice2.this).inflate(R.layout.dilog, null);
//ست کردن لایه سفرشی به الرت دیالوگ
                TextView TextAcc = view.findViewById(R.id.text_Accept);
                TextView Max_Record = view.findViewById(R.id.Text_MaxRecord);
                Button button = view.findViewById(R.id.Button_dilog);
                builder.setCancelable(false);
                SharedPreferences pref3 = getApplicationContext().getSharedPreferences("Point22", 0); // 0 - for private mode
                if (Term.equals("1")) {
                    point2 = pref3.getInt("key_Point12", 0);
                } else if (Term.equals("2")) {
                    point2 = pref3.getInt("key_Point22", 0);

                } else if (Term.equals("3")) {
                    point2 = pref3.getInt("key_Point32", 0);

                } else if (Term.equals("4")) {
                    point2 = pref3.getInt("key_Point42", 0);
                }

                if (Point > point2) {
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("Point22", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    if (Term.equals("1")) {
                        editor.putInt("key_Point12", Point); // Storing string
                        editor.commit(); // commit changes
                    } else if (Term.equals("2")) {
                        editor.putInt("key_Point22", Point); // Storing string
                        editor.commit(); // commit changes
                    } else if (Term.equals("3")) {
                        editor.putInt("key_Point32", Point); // Storing string
                        editor.commit(); // commit changes
                    } else if (Term.equals("4")) {
                        editor.putInt("key_Point42", Point); // Storing string
                        editor.commit(); // commit changes
                    }
                    Point3 = Point;
                } else {
                    Point3 = point2;
                }
                TextAcc.setText(Point + "");
                Max_Record.setText(Point3 + "");
                builder.setPositiveButton("بله", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent in = new Intent(Practice2.this, Practice.class);
                        startActivity(in);

                    }

                });
                builder.setNegativeButton("خیر", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent in = new Intent(Practice2.this, Term1.class);
                        startActivity(in);
                        finish();
                        System.exit(0);
                    }
                });
                builder.setView(view);
                builder.show();

            } else {
                String y = Count_Question + "/10";
                MainPage_Practice_toolbar_question.setText(y);
                Setdata();
            }

        }

    }

    public void Progress() {
        progressBar.setProgress(0);
        mProgressbarStatus = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (mProgressbarStatus2 == 100) {
                    mProgressbarStatus = 100;
                }
                while (mProgressbarStatus < 100) {
                    mProgressbarStatus++;
                    android.os.SystemClock.sleep(800);
                    mhandler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(mProgressbarStatus);
                        }
                    });
                }
                mhandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (mProgressbarStatus2 != 100) {
                            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                            vibrator.vibrate(1000);
                            Anser++;
                            if (Anser > 3) {
                                mProgressbarStatus2 = 100;
                                Card1.setEnabled(false);
                                Card2.setEnabled(false);
                                Card3.setEnabled(false);
                                Card4.setEnabled(false);
                                Card1.setCardBackgroundColor(Color.GRAY);
                                Card2.setCardBackgroundColor(Color.GRAY);
                                Card3.setCardBackgroundColor(Color.GRAY);
                                Card4.setCardBackgroundColor(Color.GRAY);
                                progressBar.setProgress(100);
                                AlertDialog.Builder builder = new AlertDialog.Builder(Practice2.this);
                                View view = LayoutInflater.from(Practice2.this).inflate(R.layout.dilog, null);
//ست کردن لایه سفرشی به الرت دیالوگ
                                TextView TextAcc = view.findViewById(R.id.text_Accept);
                                TextView Max_Record = view.findViewById(R.id.Text_MaxRecord);
                                Button button = view.findViewById(R.id.Button_dilog);
                                builder.setCancelable(false);
                                SharedPreferences pref3 = getApplicationContext().getSharedPreferences("Point2", 0); // 0 - for private mode
                                if (Term.equals("1")) {
                                    point2 = pref3.getInt("key_Point1", 0);
                                } else if (Term.equals("2")) {
                                    point2 = pref3.getInt("key_Point2", 0);

                                } else if (Term.equals("3")) {
                                    point2 = pref3.getInt("key_Point3", 0);

                                } else if (Term.equals("4")) {
                                    point2 = pref3.getInt("key_Point4", 0);
                                }

                                if (Point > point2) {
                                    SharedPreferences pref = getApplicationContext().getSharedPreferences("Point2", 0); // 0 - for private mode
                                    SharedPreferences.Editor editor = pref.edit();
                                    if (Term.equals("1")) {
                                        editor.putInt("key_Point1", Point); // Storing string
                                        editor.commit(); // commit changes
                                    } else if (Term.equals("2")) {
                                        editor.putInt("key_Point2", Point); // Storing string
                                        editor.commit(); // commit changes
                                    } else if (Term.equals("3")) {
                                        editor.putInt("key_Point3", Point); // Storing string
                                        editor.commit(); // commit changes
                                    } else if (Term.equals("4")) {
                                        editor.putInt("key_Point4", Point); // Storing string
                                        editor.commit(); // commit changes
                                    }

                                    Point3 = Point;
                                } else {
                                    Point3 = point2;
                                }
                                TextAcc.setText(Point + "");
                                Max_Record.setText(Point3 + "");
                                builder.setPositiveButton("بله", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent in = new Intent(Practice2.this, Practice.class);
                                        startActivity(in);
                                        finish();
                                        System.exit(0);
                                    }

                                });
                                builder.setNegativeButton("خیر", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent in = new Intent(Practice2.this, Term1.class);
                                        startActivity(in);
                                        finish();
                                        System.exit(0);
                                    }
                                });
                                builder.setView(view);
                                builder.show();
                            } else {
                                String y = Count_Question + "/10";
                                MainPage_Practice_toolbar_question.setText(y);
                                progressBar.setProgress(0);
                                Setdata();
                            }

                        }
                    }
                });

            }
        }).start();
    }

    private void Setdata() {
        Card4.setCardBackgroundColor(Color.WHITE);
        Card3.setCardBackgroundColor(Color.WHITE);
        Card2.setCardBackgroundColor(Color.WHITE);
        Card1.setCardBackgroundColor(Color.WHITE);
        switch (Term) {
            case "1": {
                min = 1;
                max = 4;
                min3 = 0;
                max3 = 4;

                break;
            }
            case "2": {
                min = 0;
                max = 9;
                min3 = 0;
                max3 = 9;

                break;
            }
            case "3": {
                min = 0;
                max = 99;
                min3 = 0;
                max3 = 99;

                break;
            }
            case "4": {
                min = 10;
                max = 99;
                min3 = 10;
                max3 = 99;

                break;
            }
        }
        int min2 = 0;
        int max2 = 13;
        Progress();
        Random r = new Random();
        Count = r.nextInt(max2 - min2 + 1) + min2;
        i1 = r.nextInt(max - min + 1) + min;
        i2 = r.nextInt(max - min + 1) + min;
        i11 = r.nextInt(max3 - min3 + 1) + min3;
        i22 = r.nextInt(max3 - min3 + 1) + min3;
        if (i1 == 4 && i2 > 1) {
            i2 = 1;
        }
        if (i2 == 4 && i1 > 1) {
            i1 = 1;
        }
        if (i2 == 3 && i1 == 3) {
            i1 = 2;
        }
        if (Term.equals("3") && i2 >= 70 && i1 >= 30) {
            int minn = 0, maxx = 9;
            i1 = r.nextInt(maxx - minn + 1) + minn;
        }
        if (Term.equals("3") && i1 >= 70 && i2 >= 30) {
            int minn = 0, maxx = 9;
            i2 = r.nextInt(maxx - minn + 1) + minn;
        }
        if (Count == 0) {
            if (i1 > i2) {
                String re = i1 + "+" + i2 + "=";
                textViewMain.setText(re);
                Result2 = String.valueOf(i1 + i2);
                Result = String.valueOf(i1 + i2 - 1);
                Result3 = String.valueOf(i1 + i2 + 1);
                Result4 = String.valueOf(i1 + i2 + 2);
                TextCard3.setText(Result2);
                TextCard2.setText(Result3);
                TextCard1.setText(Result);
                TextCard4.setText(Result4);
            } else {

                String re = i2 + "+" + i1 + "=";
                textViewMain.setText(re);

                Result2 = String.valueOf(i1 + i2);
                Result = String.valueOf(i1 + i2 - 2);
                Result3 = String.valueOf(i1 + i2 + 1);
                Result4 = String.valueOf(i1 + i2 + 2);

                TextCard3.setText(Result2);
                TextCard2.setText(Result3);
                TextCard1.setText(Result);
                TextCard4.setText(Result4);

            }

        }
        if (Count == 1) {
            if (i1 > i2) {
                String re = i1 + "+" + i2 + "=";
                textViewMain.setText(re);

                Result2 = String.valueOf(i1 + i2);
                Result = String.valueOf(i1 + i2 - 2);
                Result3 = String.valueOf(i1 + i2 + 1);
                Result4 = String.valueOf(i1 + i2 + 2);

                TextCard1.setText(Result2);
                TextCard2.setText(Result3);
                TextCard3.setText(Result);
                TextCard4.setText(Result4);


            } else {
                String re = i2 + "+" + i1 + "=";
                textViewMain.setText(re);

                Result2 = String.valueOf(i1 + i2);
                Result = String.valueOf(i1 + i2 - 2);
                Result3 = String.valueOf(i1 + i2 + 1);
                Result4 = String.valueOf(i1 + i2 + 2);
                TextCard2.setText(Result2);
                TextCard1.setText(Result3);
                TextCard3.setText(Result);
                TextCard4.setText(Result4);

            }
        }
        if (Count == 2) {
            if (i11 > i22) {
                String re = i11 + "-" + i22 + "=";
                textViewMain.setText(re);

                Result2 = String.valueOf(i11 - i22);
                Result = String.valueOf((i11 - i22) + 2);
                Result3 = String.valueOf((i11 - i22) + 1);
                Result4 = String.valueOf((i11 - i22) + 2);

                TextCard4.setText(Result2);
                TextCard2.setText(Result3);
                TextCard3.setText(Result);
                TextCard1.setText(Result4);

            } else {
                String re = i22 + "-" + i11 + "=";
                textViewMain.setText(re);

                Result2 = String.valueOf(i22 - i11);
                Result = String.valueOf((i22 - i11) - 2);
                Result3 = String.valueOf((i22 - i11) + 1);
                Result4 = String.valueOf((i22 - i11) + 2);

                TextCard4.setText(Result2);
                TextCard2.setText(Result3);
                TextCard3.setText(Result);
                TextCard1.setText(Result4);

            }
        }
        if (Count == 3) {
            if (i1 > i2) {
                String re = i1 + "+" + i2 + "=";
                textViewMain.setText(re);

                Result2 = String.valueOf(i1 + i2);
                Result = String.valueOf((i1 + i2) - 2);
                Result3 = String.valueOf((i1 + i2) + 1);
                Result4 = String.valueOf((i1 + i2) + 2);

                TextCard3.setText(Result2);
                TextCard2.setText(Result3);
                TextCard1.setText(Result);
                TextCard4.setText(Result4);

            } else {
                String re = i2 + "+" + i1 + "=";
                textViewMain.setText(re);

                Result2 = String.valueOf(i1 + i2);
                Result = String.valueOf((i1 + i2) - 2);
                Result3 = String.valueOf((i1 + i2) + 1);
                Result4 = String.valueOf((i1 + i2) + 2);

                TextCard4.setText(Result2);
                TextCard2.setText(Result3);
                TextCard3.setText(Result);
                TextCard1.setText(Result4);

            }
        }
        if (Count == 4) {
            if (i11 > i22) {
                String re = i11 + "-" + i22 + "=";
                textViewMain.setText(re);

                Result2 = String.valueOf(i11 - i22);
                Result = String.valueOf((i11 - i22) - 2);
                Result3 = String.valueOf((i11 - i22) + 1);
                Result4 = String.valueOf((i11 - i22) + 2);

                TextCard1.setText(Result2);
                TextCard2.setText(Result3);
                TextCard3.setText(Result);
                TextCard4.setText(Result4);

            } else {
                String re = i22 + "-" + i11 + "=";
                textViewMain.setText(re);

                Result2 = String.valueOf(i22 - i11);
                Result = String.valueOf((i22 - i11) - 2);
                Result3 = String.valueOf((i22 - i11) + 1);
                Result4 = String.valueOf((i22 - i11) + 2);

                TextCard1.setText(Result2);
                TextCard2.setText(Result3);
                TextCard3.setText(Result);
                TextCard4.setText(Result4);

            }
        }
        if (Count == 5) {
            if (i11 > i22) {
                String re = i11 + "-" + i22 + "=";
                textViewMain.setText(re);

                Result2 = String.valueOf(i11 - i22);
                Result = String.valueOf((i11 - i22) - 2);
                Result3 = String.valueOf((i11 - i22) + 1);
                Result4 = String.valueOf((i11 - i22) + 2);

                TextCard2.setText(Result2);
                TextCard1.setText(Result3);
                TextCard3.setText(Result);
                TextCard4.setText(Result4);

            } else {
                String re = i22 + "-" + i11 + "=";
                textViewMain.setText(re);

                Result2 = String.valueOf(i22 - i11);
                Result = String.valueOf((i22 - i11) - 2);
                Result3 = String.valueOf((i22 - i11) + 1);
                Result4 = String.valueOf((i22 - i11) + 2);

                TextCard2.setText(Result2);
                TextCard1.setText(Result3);
                TextCard3.setText(Result);
                TextCard4.setText(Result4);

            }
        }
        if (Count == 6) {

            if (i1 > i2) {
                String re = i1 + "+" + i2 + "=";
                textViewMain.setText(re);

                Result2 = String.valueOf(i1 + i2);
                Result = String.valueOf((i1 + i2) - 2);
                Result3 = String.valueOf((i1 + i2) + 1);
                Result4 = String.valueOf((i1 + i2) + 2);

                TextCard4.setText(Result2);
                TextCard2.setText(Result3);
                TextCard3.setText(Result);
                TextCard1.setText(Result4);

            } else {
                String re = i2 + "+" + i1 + "=";
                textViewMain.setText(re);

                Result2 = String.valueOf(i1 + i2);
                Result = String.valueOf((i1 + i2) - 2);
                Result3 = String.valueOf((i1 + i2) + 1);
                Result4 = String.valueOf((i1 + i2) + 2);

                TextCard2.setText(Result2);
                TextCard1.setText(Result3);
                TextCard3.setText(Result);
                TextCard4.setText(Result4);

            }
        }
        if (Count == 7) {
            if (i1 > i2) {
                String re = i1 + "+" + i2 + "=";
                textViewMain.setText(re);

                Result2 = String.valueOf(i1 + i2);
                Result = String.valueOf((i1 + i2) - 2);
                Result3 = String.valueOf((i1 + i2) + 1);
                Result4 = String.valueOf((i1 + i2) + 2);

                TextCard3.setText(Result2);
                TextCard2.setText(Result3);
                TextCard1.setText(Result);
                TextCard4.setText(Result4);

            } else {
                String re = i2 + "+" + i1 + "=";
                textViewMain.setText(re);
                Result2 = String.valueOf(i1 + i2);
                Result = String.valueOf((i1 + i2) - 2);
                Result3 = String.valueOf((i1 + i2) + 1);
                Result4 = String.valueOf((i1 + i2) + 2);

                TextCard3.setText(Result2);
                TextCard2.setText(Result3);
                TextCard1.setText(Result);
                TextCard4.setText(Result4);

            }
        }
        if (Count == 8) {
            if (i1 > i2) {
                String re = i1 + "+" + i2 + "=";
                textViewMain.setText(re);

                Result2 = String.valueOf(i1 + i2);
                Result = String.valueOf((i1 + i2) - 2);
                Result3 = String.valueOf((i1 + i2) + 1);
                Result4 = String.valueOf((i1 + i2) + 2);

                TextCard1.setText(Result2);
                TextCard2.setText(Result3);
                TextCard3.setText(Result);
                TextCard4.setText(Result4);

            } else {
                String re = i2 + "+" + i1 + "=";
                textViewMain.setText(re);

                Result2 = String.valueOf(i1 + i2);
                Result = String.valueOf((i1 + i2) - 2);
                Result3 = String.valueOf((i1 + i2) + 1);
                Result4 = String.valueOf((i1 + i2) + 2);

                TextCard3.setText(Result2);
                TextCard2.setText(Result3);
                TextCard1.setText(Result);
                TextCard4.setText(Result4);

            }
        }
        if (Count == 9) {
            if (i1 > i2) {
                String re = i1 + "+" + i2 + "=";
                textViewMain.setText(re);

                Result2 = String.valueOf(i1 + i2);
                Result = String.valueOf((i1 + i2) - 2);
                Result3 = String.valueOf((i1 + i2) + 1);
                Result4 = String.valueOf((i1 + i2) + 2);

                TextCard1.setText(Result2);
                TextCard2.setText(Result3);
                TextCard3.setText(Result);
                TextCard4.setText(Result4);

            } else {
                String re = i2 + "+" + i1 + "=";
                textViewMain.setText(re);

                Result2 = String.valueOf(i1 + i2);
                Result = String.valueOf((i1 + i2) - 2);
                Result3 = String.valueOf((i1 + i2) + 1);
                Result4 = String.valueOf((i1 + i2) + 2);

                TextCard1.setText(Result2);
                TextCard2.setText(Result3);
                TextCard3.setText(Result);
                TextCard4.setText(Result4);

            }
        }
        if (Count == 10) {
            if (i1 > i2) {
                String re = i1 + "+" + i2 + "=";
                textViewMain.setText(re);

                Result2 = String.valueOf(i1 + i2);
                Result = String.valueOf((i1 + i2) - 2);
                Result3 = String.valueOf((i1 + i2) + 1);
                Result4 = String.valueOf((i1 + i2) + 2);

                TextCard2.setText(Result2);
                TextCard1.setText(Result3);
                TextCard3.setText(Result);
                TextCard4.setText(Result4);

            } else {
                String re = i2 + "+" + i1 + "=";
                textViewMain.setText(re);

                Result2 = String.valueOf(i1 + i2);
                Result = String.valueOf((i1 + i2) - 2);
                Result3 = String.valueOf((i1 + i2) + 1);
                Result4 = String.valueOf((i1 + i2) + 2);

                TextCard2.setText(Result2);
                TextCard1.setText(Result3);
                TextCard3.setText(Result);
                TextCard4.setText(Result4);

            }
        }
        if (Count == 11) {
            if (i1 > i2) {

                String re = i1 + "+" + i2 + "=";
                textViewMain.setText(re);

                Result2 = String.valueOf(i1 + i2);
                Result = String.valueOf((i1 + i2) - 2);
                Result3 = String.valueOf((i1 + i2) + 1);
                Result4 = String.valueOf((i1 + i2) + 2);

                TextCard1.setText(Result2);
                TextCard2.setText(Result3);
                TextCard3.setText(Result);
                TextCard4.setText(Result4);

            } else {
                String re = i2 + "+" + i1 + "=";
                textViewMain.setText(re);
                Result2 = String.valueOf(i1 + i2);
                Result = String.valueOf((i1 + i2) - 2);
                Result3 = String.valueOf((i1 + i2) + 3);
                Result4 = String.valueOf((i1 + i2) + 2);

                TextCard3.setText(Result2);
                TextCard2.setText(Result3);
                TextCard1.setText(Result);
                TextCard4.setText(Result4);

            }
        }
        if (Count == 12) {
            if (i11 > i22) {
                String re = i11 + "-" + i22 + "=";
                textViewMain.setText(re);
                Result2 = String.valueOf(i11 - i22);
                Result = String.valueOf((i11 - i22) - 2);
                Result3 = String.valueOf((i11 - i22) + 1);
                Result4 = String.valueOf((i11 - i22) + 4);


                TextCard1.setText(Result2);
                TextCard2.setText(Result3);
                TextCard3.setText(Result);
                TextCard4.setText(Result4);

            } else {
                String re = i22 + "-" + i11 + "=";
                textViewMain.setText(re);

                Result2 = String.valueOf(i22 - i11);
                Result = String.valueOf((i22 - i11) - 2);
                Result3 = String.valueOf((i22 - i11) + 1);
                Result4 = String.valueOf((i22 - i11) + 2);

                TextCard1.setText(Result2);
                TextCard2.setText(Result3);
                TextCard3.setText(Result);
                TextCard4.setText(Result4);
            }
        }
        if (Count == 13) {
            if (i1 > i2) {
                String re = i1 + "+" + i2 + "=";
                textViewMain.setText(re);
                Result2 = String.valueOf(i1 + i2);
                Result = String.valueOf((i1 + i2) - 2);
                Result3 = String.valueOf((i1 + i2) + 3);
                Result4 = String.valueOf((i1 + i2) + 2);

                TextCard4.setText(Result2);
                TextCard2.setText(Result3);
                TextCard3.setText(Result);
                TextCard1.setText(Result4);

            } else {
                String re = i2 + "+" + i1 + "=";
                textViewMain.setText(re);
                Result2 = String.valueOf(i1 + i2);
                Result = String.valueOf((i1 + i2) - 2);
                Result3 = String.valueOf((i1 + i2) + 1);
                Result4 = String.valueOf((i1 + i2) + 2);
                TextCard4.setText(Result2);
                TextCard2.setText(Result3);
                TextCard3.setText(Result);
                TextCard1.setText(Result4);

            }
        }


    }

    public void onBackPressed() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage("آیا میخواهید از بخش تمرین خارج شوید؟")
//                .setCancelable(false).setPositiveButton("بله", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int id) {
//                Intent in = new Intent(Practice.this, Term1.class);
//                System.exit(0);
//                finish();
//                startActivity(in);
//
//            }
//        })
//                .setNegativeButton("خیر", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//                    }
//                });
//        AlertDialog alert = builder.create();
//        alert.show();
//
//
        final AlertDialog.Builder builder = new AlertDialog.Builder(Practice2.this);
        final View view = LayoutInflater.from(Practice2.this).inflate(R.layout.dilog2, null);
//ست کردن لایه سفرشی به الرت دیالوگ
        Button buttonYes = view.findViewById(R.id.Text_YesButton);
        Button buttonNo = view.findViewById(R.id.Text_NoButton);

        builder.setCancelable(false);
        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Practice2.this, Term1.class);
                startActivity(in);
                System.exit(0);
                finish();
            }
        });
        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Practice2.this, Practice.class);
                startActivity(in);
                System.exit(0);
                finish();
            }
        });
        builder.setView(view);
        builder.show();


    }

    private void Initialize() {
        progressBar = (ProgressBar) findViewById(R.id.ProgressBar);
        back = (ImageView) findViewById(R.id.back);
        textViewMain = (TextView) findViewById(R.id.textViewMain);
        MainPage_Practice_toolbar_question = (TextView) findViewById(R.id.MainPage_Practice_toolbar_question);
        //        CardView
        Card1 = (CardView) findViewById(R.id.Card1);
        Card2 = (CardView) findViewById(R.id.Card2);
        Card3 = (CardView) findViewById(R.id.Card3);
        Card4 = (CardView) findViewById(R.id.Card4);

//        TextView
        TextCard1 = (TextView) findViewById(R.id.Text_Card1);
        TextCard2 = (TextView) findViewById(R.id.Text_Card2);
        TextCard3 = (TextView) findViewById(R.id.Text_Card3);
        TextCard4 = (TextView) findViewById(R.id.Text_Card4);
        textViewMain2 = (TextView) findViewById(R.id.textViewMain2);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {

            case R.id.Card1: {
                Card1();
                break;
            }

            case R.id.Card2: {
                Card2();
                break;

            }
            case R.id.Card3: {
                Card3();
                break;
            }
            case R.id.Card4: {
                Card4();
                break;
            }

        }
    }
}
