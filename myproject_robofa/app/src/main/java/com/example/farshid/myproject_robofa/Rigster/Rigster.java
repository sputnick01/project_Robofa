package com.example.farshid.myproject_robofa.Rigster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.dd.CircularProgressButton;
import com.example.farshid.myproject_robofa.MainPage.Channel.InsertChannle;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.Term1;
import com.example.farshid.myproject_robofa.MainPage.MySingleton;
import com.example.farshid.myproject_robofa.R;
import com.example.farshid.myproject_robofa.Rigster.ShowAllImage.ShowAllImage;
import com.weiwangcn.betterspinner.library.BetterSpinner;

import java.util.HashMap;
import java.util.Map;

public class Rigster extends AppCompatActivity {
    Button bS, BT,BC,BSS,BTS,Rigster_ShowAllImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rigster);
        bS = (Button) findViewById(R.id.Student);
        BT = (Button) findViewById(R.id.Teacher);
        BC = (Button) findViewById(R.id.Channle);
        BSS = (Button) findViewById(R.id.RigsterStudentSchool);
        BTS = (Button) findViewById(R.id.RigsterTeacherSchool);
        Rigster_ShowAllImage= (Button) findViewById(R.id.Rigster_ShowAllImage);
        bS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Rigster.this, RegisterStudent.class);
                startActivity(in);
            }
        });
              BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Rigster.this, Rigster_Teacher.class);
                startActivity(in);
            }
        });
        BC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Rigster.this, InsertChannle.class);
                startActivity(in);
            }
        });
        BSS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Rigster.this, BStudentSchool.class);
                startActivity(in);
            }
        });
        BTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Rigster.this, BTeacherSchool.class);
                startActivity(in);
            }
        });
        Rigster_ShowAllImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Rigster.this, ShowAllImage.class);
                startActivity(in);
            }
        });
    }
}
