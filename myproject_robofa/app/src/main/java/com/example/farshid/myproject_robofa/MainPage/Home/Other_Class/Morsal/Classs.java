package com.example.farshid.myproject_robofa.MainPage.Home.Other_Class.Morsal;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.farshid.myproject_robofa.Button_Navigation;
import com.example.farshid.myproject_robofa.MainPage.Home.Other_Class.LoginToPage;
import com.example.farshid.myproject_robofa.R;

public class Classs extends AppCompatActivity implements View.OnClickListener {
    TextView T1,T2,T3,T4,T5,T6,T7;
    CardView Card1, Card2, Card3, Card4, Card5,Card6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classs);
        Initial();
        Font();
        Card1.setOnClickListener(this);
        Card2.setOnClickListener(this);
        Card3.setOnClickListener(this);
        Card4.setOnClickListener(this);
        Card5.setOnClickListener(this);
        Card6.setOnClickListener(this);
    }

    //    خروج از برنامه
    public void onBackPressed() {
        Intent in = new Intent(Classs.this, Button_Navigation.class);
        startActivity(in);
        System.exit(0);
        finish();
    }

    private void Font() {
        Typeface tf = Typeface.createFromAsset(getAssets(), "font/irsans.ttf");
        T1.setTypeface(tf);
        T2.setTypeface(tf);
        T3.setTypeface(tf);
        T4.setTypeface(tf);
        T5.setTypeface(tf);
        T6.setTypeface(tf);
    }

    private void Initial() {
        T1= (TextView) findViewById(R.id.TT1);
        T2= (TextView) findViewById(R.id.TT2);
        T3= (TextView) findViewById(R.id.TT3);
        T4= (TextView) findViewById(R.id.TT4);
        T5= (TextView) findViewById(R.id.TT5);
        T6= (TextView) findViewById(R.id.TT6);

        Card1= (CardView) findViewById(R.id.Class1);
        Card2= (CardView) findViewById(R.id.Class2);
        Card3= (CardView) findViewById(R.id.Class3);
        Card4= (CardView) findViewById(R.id.Class4);
        Card5= (CardView) findViewById(R.id.Class5);
        Card6= (CardView) findViewById(R.id.Class6);

    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.Class1:
            {
                Intent in =new Intent(Classs.this, LoginToPage.class);
                in.putExtra("Base","اول");
                startActivity(in);
                break;
            }
            case R.id.Class2:
            {
                Intent in =new Intent(Classs.this, LoginToPage.class);
                in.putExtra("Base","دوم");
                startActivity(in);
                break;
            }
            case R.id.Class3:
            {
                Intent in =new Intent(Classs.this, LoginToPage.class);
                in.putExtra("Base","سوم");
                startActivity(in);
                break;
            }
            case R.id.Class4:
            {
                Intent in =new Intent(Classs.this, LoginToPage.class);
                in.putExtra("Base","چهارم");
                startActivity(in);
                break;
            }
            case R.id.Class5:
            {
                Intent in =new Intent(Classs.this, LoginToPage.class);
                in.putExtra("Base","پنجم");
                startActivity(in);
                break;
            }
            case R.id.Class6:
            {
                Intent in =new Intent(Classs.this, LoginToPage.class);
                in.putExtra("Base","ششم");
                startActivity(in);
                break;
            }



        }
    }
}
