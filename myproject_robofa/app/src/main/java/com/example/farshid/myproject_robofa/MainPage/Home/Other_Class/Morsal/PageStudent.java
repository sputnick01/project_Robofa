package com.example.farshid.myproject_robofa.MainPage.Home.Other_Class.Morsal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.Note.Note;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.Practice;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.Term1;
import com.example.farshid.myproject_robofa.R;
import com.example.farshid.myproject_robofa.Teacher.SearchStudent.ShowInformationStudent;

public class PageStudent extends AppCompatActivity implements View.OnClickListener {
    TextView TextTitle1, TextTitle2;
    Button BtnNote, BtnRting;
    String Base = "", UserName = "", Password = "", Type = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_student);
        Initialize();
        SetFont();
        InitializeTitle();
        InitializeTitle2();
        BtnNote.setOnClickListener(this);
        BtnRting.setOnClickListener(this);
    }

    private void InitializeTitle2() {
        SharedPreferences pref3 = getApplicationContext().getSharedPreferences("Base", 0); // 0 - for private mode
        Base = pref3.getString("Base", "");
        UserName = pref3.getString("UserName1","");
        Password = pref3.getString("Password1","");
        Type = pref3.getString("Type", "");
        if (Base.toString().equals("اول")) {
            TextTitle1.setText("اول ابتدایی");
            SharedPreferences pref1 = getApplicationContext().getSharedPreferences("Login", 0); // 0 - for private mode
            SharedPreferences.Editor editor1 = pref1.edit();
            editor1.putBoolean("Login1", true); // Storing string
            editor1.commit(); // commit changes
        } else if (Base.toString().equals("دوم")) {
            TextTitle1.setText("دوم ابتدایی");
            SharedPreferences pref1 = getApplicationContext().getSharedPreferences("Login", 0); // 0 - for private mode
            SharedPreferences.Editor editor1 = pref1.edit();
            editor1.putBoolean("Login2", true); // Storing string
            editor1.commit(); // commit changes
        } else if (Base.toString().equals("سوم")) {
            TextTitle1.setText("سوم ابتدایی");
            SharedPreferences pref1 = getApplicationContext().getSharedPreferences("Login", 0); // 0 - for private mode
            SharedPreferences.Editor editor1 = pref1.edit();
            editor1.putBoolean("Login3", true); // Storing string
            editor1.commit(); // commit changes
        } else if (Base.toString().equals("چهارم")) {
            TextTitle1.setText("چهارم ابتدایی");
            SharedPreferences pref1 = getApplicationContext().getSharedPreferences("Login", 0); // 0 - for private mode
            SharedPreferences.Editor editor1 = pref1.edit();
            editor1.putBoolean("Login4", true); // Storing string
            editor1.commit(); // commit changes
        } else if (Base.toString().equals("پنجم")) {
            TextTitle1.setText("پنجم ابتدایی");
            SharedPreferences pref1 = getApplicationContext().getSharedPreferences("Login", 0); // 0 - for private mode
            SharedPreferences.Editor editor1 = pref1.edit();
            editor1.putBoolean("Login5", true); // Storing string
            editor1.commit(); // commit changes
        } else if (Base.toString().equals("ششم")) {
            TextTitle1.setText("ششم ابتدایی");
            SharedPreferences pref1 = getApplicationContext().getSharedPreferences("Login", 0); // 0 - for private mode
            SharedPreferences.Editor editor1 = pref1.edit();
            editor1.putBoolean("Login6", true); // Storing string
            editor1.commit(); // commit changes
        }
    }

    //    ست کردن Title
    private void InitializeTitle() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            UserName = extras.getString("UserName");
            Password = extras.getString("Password");
            Base = extras.getString("Base");
            Type = extras.getString("Type1");
            SharedPreferences pref = getApplicationContext().getSharedPreferences("Base", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("UserName1", UserName); // Storing string
            editor.putString("Password1", Password); // Storing string
            editor.putString("Base", Base); // Storing string
            editor.putString("Type1", Type); // Storing string
            editor.putString("Kind", "School"); // Storing string
            editor.commit(); // commit changes

        }
    }


    //    ست کردن فونت
    private void SetFont() {
        Typeface tf = Typeface.createFromAsset(getAssets(), "font/irsans.ttf");
        TextTitle1.setTypeface(tf);
        TextTitle2.setTypeface(tf);
        BtnNote.setTypeface(tf);
        BtnRting.setTypeface(tf);

    }
    //    خروج از برنامه
    public void onBackPressed() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(PageStudent.this);
        final View view = LayoutInflater.from(PageStudent.this).inflate(R.layout.dilog2, null);
//ست کردن لایه سفرشی به الرت دیالوگ
        Button buttonYes = view.findViewById(R.id.Text_YesButton);
        Button buttonNo = view.findViewById(R.id.Text_NoButton);

        builder.setCancelable(false);
        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(PageStudent.this, Classs.class);
                startActivity(in);
                System.exit(0);
                finish();
            }
        });
        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(PageStudent.this, PageStudent.class);
                startActivity(in);
                System.exit(0);
                finish();
            }
        });
        builder.setView(view);
        builder.show();


    }
    //    مقداردهی مقادیر
    private void Initialize() {
//        TextView
        TextTitle1 = (TextView) findViewById(R.id.PageStudent_TextTitle1);
        TextTitle2 = (TextView) findViewById(R.id.PageStudent_TextTitle2);
//    Button
        BtnNote = (Button) findViewById(R.id.PageStuden_ButtonNoti);
        BtnRting = (Button) findViewById(R.id.PageStuden_ButtonRating);
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.PageStuden_ButtonNoti: {
                SharedPreferences pref31 = getApplicationContext().getSharedPreferences("Base", 0); // 0 - for private mode
                UserName = pref31.getString("UserName", "");
                Password = pref31.getString("Password", "");
                Base = pref31.getString("Base", "");
                Type = pref31.getString("Type1", "");
                Intent in = new Intent(PageStudent.this, Note.class);
                in.putExtra("Base", Base);
                in.putExtra("Type", Type);
                in.putExtra("Kind", "School");
                startActivity(in);
                break;
            }
            case R.id.PageStuden_ButtonRating: {
                Intent in = new Intent(PageStudent.this, ShowInformationStudent.class);
                in.putExtra("UserName", UserName);
                in.putExtra("Password",Password);
                in.putExtra("Kind", "School");
                in.putExtra("Id", "");
                startActivity(in);
                break;
            }
        }

    }
}
