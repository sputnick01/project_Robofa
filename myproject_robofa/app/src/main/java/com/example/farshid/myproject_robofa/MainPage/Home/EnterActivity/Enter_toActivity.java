package com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.Chortka;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Robatic.Class_Robatic;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Saze.Class_Saze;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Zaban.Class_Zaban;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.riaze.Riaze;
import com.example.farshid.myproject_robofa.MainPage.MySingleton;
import com.example.farshid.myproject_robofa.MainPage.Register.Register_Student;
import com.example.farshid.myproject_robofa.R;
import com.example.farshid.myproject_robofa.Rigster.Enter_Teacher;
import com.example.farshid.myproject_robofa.Rigster.Rigster;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Enter_toActivity extends AppCompatActivity implements View.OnClickListener {

    Button MainPage_Home_ButtonSubmit, MainPage_Home_Button_forRegister;
    ImageView imageToolBar;
    TextView TextToolbar;
    String Class;
    String Server_Url = "http://farshidhabibi.ir/farshid/kivan/loginuser.php";
    String ClassMe = "", ClassMe2 = "";
    EditText EditPhone, EditKeyMali;
    int count = 0;
    boolean Trust = false;
    JSONObject obj;
    JSONArray jsonarray;
    JSONObject objBuy;
    JSONArray jsonarrayBuy;
    String Term = "";
    CheckBox circularProgressButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_to);
        Initilize();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Class = extras.getString("Class");
            ClassMe2 = Class;
            if (Class.toString().equals("چرتکه ومحاسبات ذهنی")) {
                imageToolBar.setImageResource(R.drawable.girl);
                TextToolbar.setText("چرتکه ومحاسبات ذهنی");
                ClassMe = "چرتکه ومحاسبات ذهنی";

            } else if (Class.toString().equals("ریاضی سه سوت")) {
                imageToolBar.setImageResource(R.drawable.icon_math3);
                TextToolbar.setText("ریاضی سه سوت");
                ClassMe = "ریاضی سه سوت";

            } else if (Class.toString().equals("رباتیک")) {
                imageToolBar.setImageResource(R.drawable.image_robatic2);
                TextToolbar.setText("رباتیک");
                ClassMe = "رباتیک";

            } else if (Class.toString().equals("زبان")) {
                imageToolBar.setImageResource(R.drawable.foreign_languages2);
                TextToolbar.setText("زبان");
                ClassMe = "زبان";
            } else if (Class.toString().equals("سازهای ماکارونی")) {
                imageToolBar.setImageResource(R.drawable.foreign_languages2);
                TextToolbar.setText("سازهای ماکارونی");
                ClassMe = "سازهای ماکارونی";

            }
        }
        ForDemo();
        IsChecked();
//        Login();
        circularProgressButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("SetLEnter", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putBoolean("SetL", true); // Storing string
                    editor.commit(); // commit changes
                } else {
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("SetLEnter", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putBoolean("SetL", false); // Storing string
                    editor.commit(); // commit changes

                }
            }
        });
        MainPage_Home_Button_forRegister.setOnClickListener(this);
        MainPage_Home_ButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Class.toString().equals("چرتکه ومحاسبات ذهنی") && EditPhone.getText().toString().trim().equals("yolamuz") && EditKeyMali.getText().toString().trim().equals("123456")) {
                    Intent in = new Intent(Enter_toActivity.this, Chortka.class);
                    startActivity(in);
                } else if (Class.toString().equals("رباتیک") &&EditPhone.getText().toString().trim().equals("yolamuz") && EditKeyMali.getText().toString().trim().equals("123456")) {
                    Intent in = new Intent(Enter_toActivity.this, Class_Robatic.class);
                    startActivity(in);

                } else if (Class.toString().equals("زبان") && EditPhone.getText().toString().trim().equals("yolamuz") && EditKeyMali.getText().toString().trim().equals("123456")) {
                    Intent in = new Intent(Enter_toActivity.this, Class_Zaban.class);
                    startActivity(in);
                } else if (Class.toString().equals("سازهای ماکارونی") && EditPhone.getText().toString().trim().equals("yolamuz") && EditKeyMali.getText().toString().trim().equals("123456")) {
                    Intent in = new Intent(Enter_toActivity.this, Class_Saze.class);
                    startActivity(in);
                } else if (Class.toString().equals("ریاضی سه سوت") &&EditPhone.getText().toString().trim().equals("yolamuz") && EditKeyMali.getText().toString().trim().equals("123456")) {
                    Intent in = new Intent(Enter_toActivity.this, Riaze.class);
                    startActivity(in);
                }
                else if (Class.toString().equals("هوافضا") &&EditPhone.getText().toString().trim().equals("yolamuz") && EditKeyMali.getText().toString().trim().equals("123456")) {
                    Intent in = new Intent(Enter_toActivity.this, Class_Robatic.class);
                    startActivity(in);

                }

                if (hasInternetConnection()) {

                    if (count == 0) {
                        if (Trust()) {
                            count = 1;
//                            For Remmber
                            For_Remmber();
                            SharedPreferences pref = getApplicationContext().getSharedPreferences("UserPass", 0); // 0 - for private mode
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("Username", EditPhone.getText().toString().trim());
                            editor.putString("Password", EditKeyMali.getText().toString().trim());// Storing string
                            editor.putString("Class", Class);// Storing string
                            editor.commit(); // commit changes
                            StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Url, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    int count2 = 0;

                                    try {
//                    progressBar.setVisibility(view.GONE);
                                        objBuy = new JSONObject(response);
                                        jsonarrayBuy = objBuy.getJSONArray("resp");
                                        while (count2 < jsonarrayBuy.length()) {
                                            String Cost = "";
                                            String Area = "";
                                            JSONObject jsonObject = jsonarrayBuy.getJSONObject(count2);
                                            Term = jsonObject.getString("Term");
                                            String TypeTerm = jsonObject.getString("TypeTerm");
                                            ForLogin();
                                            if (Class.toString().equals("سازهای ماکارونی")) {
                                                IfSaze();
                                                SharedPreferences pref = getApplicationContext().getSharedPreferences("LoginSa", 0); // 0 - for private mode
                                                SharedPreferences.Editor editor = pref.edit();
                                                editor.putBoolean("key_LoginSA", true); // Storing string
                                                editor.commit(); // commit
                                                if (Term.toString().equals("1")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermSa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm1", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("2")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermSa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm2", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("3")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermSa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm3", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("1")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermSa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm1", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("4")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermSa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm4", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("5")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermSa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm5", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("6")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermSa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm6", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("7")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermSa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm7", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("8")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermSa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm8", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("9")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermSa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm9", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("10")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermSa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm10", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("11")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermSa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm11", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("12")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermSa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm12", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                            }
                                            if (Class.toString().equals("رباتیک")) {
                                                SharedPreferences pref = getApplicationContext().getSharedPreferences("LoginRo", 0); // 0 - for private mode
                                                SharedPreferences.Editor editor = pref.edit();
                                                editor.putBoolean("key_LoginRo", true); // Storing string
                                                editor.commit(); // commit
                                                IFRobatic();
                                                if (Term.toString().equals("1")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRo", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm1", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("2")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRo", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm2", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("3")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRo", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm3", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("1")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRo", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm1", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("4")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRo", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm4", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("5")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRo", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm5", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("6")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRo", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm6", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("7")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRo", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm7", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("8")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRo", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm8", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("9")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRo", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm9", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("10")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRo", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm10", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("11")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRo", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm11", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("12")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRo", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm12", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                            }
                                            if (Class.toString().equals("ریاضی سه سوت")) {
                                                IfRiaze();
                                                SharedPreferences pref = getApplicationContext().getSharedPreferences("LoginRi", 0); // 0 - for private mode
                                                SharedPreferences.Editor editor = pref.edit();
                                                editor.putBoolean("key_LoginRi", true); // Storing string
                                                editor.commit(); // commit
                                                if (Term.toString().equals("1")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRi", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm1", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("2")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRi", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm2", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("3")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRi", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm3", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("1")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRi", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm1", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("4")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRi", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm4", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("5")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRi", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm5", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("6")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRi", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm6", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("7")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRi", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm7", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("8")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRi", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm8", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("9")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRi", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm9", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("10")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRi", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm10", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("11")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRi", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm11", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("12")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermRi", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm12", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                            }
                                            if (Class.toString().equals("چرتکه ومحاسبات ذهنی")) {
                                                IFChortka();
                                                SharedPreferences pref = getApplicationContext().getSharedPreferences("LoginCh", 0); // 0 - for private mode
                                                SharedPreferences.Editor editor = pref.edit();
                                                editor.putBoolean("key_Login", true); // Storing string
                                                editor.commit(); // commit
                                                if (Term.toString().equals("1")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermCh", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTermC1", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("2")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermCh", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm2", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("3")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermCh", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm3", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("1")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermCh", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm1", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("4")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermCh", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm4", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("5")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermCh", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm5", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("6")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermCh", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm6", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("7")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermCh", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm7", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("8")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermCh", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm8", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("9")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermCh", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm9", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("10")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermCh", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm10", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("11")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermCh", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm11", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("12")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermCh", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm12", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                            }
                                            if (Class.toString().equals("زبان")) {
                                                IfZaban();
                                                SharedPreferences pref = getApplicationContext().getSharedPreferences("LoginZa", 0); // 0 - for private mode
                                                SharedPreferences.Editor editor = pref.edit();
                                                editor.putBoolean("key_LoginZa", true); // Storing string
                                                editor.commit(); // commit
                                                if (Term.toString().equals("1")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermZa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm1", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("2")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermZa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm2", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("3")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermZa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm3", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("1")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermZa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm1", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("4")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermZa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm4", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("5")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermZa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm5", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("6")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermZa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm6", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("7")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermZa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm7", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("8")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermZa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm8", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("9")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermZa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm9", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("10")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermZa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm10", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("11")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermZa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm11", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                                if (Term.toString().equals("12")) {
                                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("TypeTermZa", 0); // 0 - for private mode
                                                    SharedPreferences.Editor editor2 = pref2.edit();
                                                    editor2.putString("TypeTerm12", jsonObject.getString("TypeTerm")); // Storing string
                                                    editor2.commit();
                                                }
                                            }
                                            count2++;
                                        }

                                        if (Class.toString().equals("چرتکه ومحاسبات ذهنی")) {
                                            Intent in = new Intent(Enter_toActivity.this, Chortka.class);
                                            startActivity(in);
                                        } else if (Class.toString().equals("رباتیک")) {
                                            Intent in = new Intent(Enter_toActivity.this, Class_Robatic.class);
                                            startActivity(in);

                                        } else if (Class.toString().equals("زبان")) {
                                            Intent in = new Intent(Enter_toActivity.this, Class_Zaban.class);
                                            startActivity(in);
                                        } else if (Class.toString().equals("سازهای ماکارونی")) {
                                            Intent in = new Intent(Enter_toActivity.this, Class_Saze.class);
                                            startActivity(in);
                                        } else if (Class.toString().equals("ریاضی سه سوت")) {
                                            Intent in = new Intent(Enter_toActivity.this, Riaze.class);
                                            startActivity(in);
                                        }
                                        count = 0;
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    count = 0;
                                }
                            }
                            ) {
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String, String> params = new HashMap<String, String>();
                                    params.put("EDPhoneNumber", EditPhone.getText().toString().trim());
                                    params.put("EDMaliKey", EditKeyMali.getText().toString().trim());
                                    params.put("EDClass", Class);
                                    return params;
                                }
                            };
                            MySingleton.getInstance(Enter_toActivity.this).addtoRequestQueue(stringrequest);
                        } else {
                            Toast.makeText(Enter_toActivity.this, "فیلد های لازم را پر کنید!", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    Toast.makeText(Enter_toActivity.this, "مشکلی در برقراری ارتباط وجود دارد!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void For_Remmber() {
        if (ClassMe.toString().equals("چرتکه ومحاسبات ذهنی")) {
            SharedPreferences pref3 = getApplicationContext().getSharedPreferences("SetLEnter", 0); // 0 - for private mode
            if (pref3.getBoolean("SetL", false)) {
                SharedPreferences pref2 = getApplicationContext().getSharedPreferences("MyPrefCh", 0); // 0 - for private mode
                SharedPreferences.Editor editor2 = pref2.edit();
                editor2.putString("key_PhoneNumber", EditPhone.getText().toString().trim()); // Storing string
                editor2.putString("key_Password", EditKeyMali.getText().toString().trim()); // Storing string
                editor2.commit(); // commit changes
            }


        }
        if (ClassMe.toString().equals("ریاضی سه سوت")) {
            SharedPreferences pref3 = getApplicationContext().getSharedPreferences("SetLEnter", 0); // 0 - for private mode
            if (pref3.getBoolean("SetL", false)) {
                SharedPreferences pref2 = getApplicationContext().getSharedPreferences("MyPrefRi", 0); // 0 - for private mode
                SharedPreferences.Editor editor2 = pref2.edit();
                editor2.putString("key_PhoneNumber", EditPhone.getText().toString().trim()); // Storing string
                editor2.putString("key_Password", EditKeyMali.getText().toString().trim()); // Storing string
                editor2.commit(); // commit changes
            }


        }
        if (ClassMe.toString().equals("رباتیک")) {
            SharedPreferences pref3 = getApplicationContext().getSharedPreferences("SetLEnter", 0); // 0 - for private mode
            if (pref3.getBoolean("SetL", false)) {
                SharedPreferences pref2 = getApplicationContext().getSharedPreferences("MyPrefRo", 0); // 0 - for private mode
                SharedPreferences.Editor editor2 = pref2.edit();
                editor2.putString("key_PhoneNumber", EditPhone.getText().toString().trim()); // Storing string
                editor2.putString("key_Password", EditKeyMali.getText().toString().trim()); // Storing string
                editor2.commit(); // commit changes
            }


        }
        if (ClassMe.toString().equals("زبان")) {
            SharedPreferences pref3 = getApplicationContext().getSharedPreferences("SetLEnter", 0); // 0 - for private mode
            if (pref3.getBoolean("SetL", false)) {
                SharedPreferences pref2 = getApplicationContext().getSharedPreferences("MyPrefZa", 0); // 0 - for private mode
                SharedPreferences.Editor editor2 = pref2.edit();
                editor2.putString("key_PhoneNumber", EditPhone.getText().toString().trim()); // Storing string
                editor2.putString("key_Password", EditKeyMali.getText().toString().trim()); // Storing string
                editor2.commit(); // commit changes
            }


        }
        if (ClassMe.toString().equals("سازهای ماکارونی")) {
            SharedPreferences pref3 = getApplicationContext().getSharedPreferences("SetLEnter", 0); // 0 - for private mode
            if (pref3.getBoolean("SetL", false)) {
                SharedPreferences pref2 = getApplicationContext().getSharedPreferences("MyPrefSa", 0); // 0 - for private mode
                SharedPreferences.Editor editor2 = pref2.edit();
                editor2.putString("key_PhoneNumber", EditPhone.getText().toString().trim()); // Storing string
                editor2.putString("key_Password", EditKeyMali.getText().toString().trim()); // Storing string
                editor2.commit(); // commit changes
            }


        }
    }

    private boolean Trust() {
        Trust = true;
        if (EditPhone.getText().toString().isEmpty() || EditKeyMali.getText().toString().isEmpty()) {
            Trust = false;
        }
        return Trust;
    }

    private void ForLogin() {

    }

    private void IsChecked() {
        SharedPreferences pref3 = getApplicationContext().getSharedPreferences("SetLEnter", 0); // 0 - for private mode
        if (pref3.getBoolean("SetL", false)) {
            if (ClassMe.toString().equals("چرتکه ومحاسبات ذهنی")) {

                SharedPreferences pref2 = getApplicationContext().getSharedPreferences("MyPrefCh", 0); // 0 - for private mode
                EditPhone.setText(pref2.getString("key_PhoneNumber", "")); // getting String
                EditKeyMali.setText(pref2.getString("key_Password", "")); // getting String
                circularProgressButton.setChecked(true);
            } else if (ClassMe.toString().equals("ریاضی سه سوت")) {
                SharedPreferences pref2 = getApplicationContext().getSharedPreferences("MyPrefRi", 0); // 0 - for private mode
                EditPhone.setText(pref2.getString("key_PhoneNumber", "")); // getting String
                EditKeyMali.setText(pref2.getString("key_Password", "")); // getting String
                circularProgressButton.setChecked(true);
            } else if (ClassMe.toString().equals("رباتیک")) {
                SharedPreferences pref2 = getApplicationContext().getSharedPreferences("MyPrefRo", 0); // 0 - for private mode
                EditPhone.setText(pref2.getString("key_PhoneNumber", "")); // getting String
                EditKeyMali.setText(pref2.getString("key_Password", "")); // getting String
                circularProgressButton.setChecked(true);

            } else if (ClassMe.toString().equals("زبان")) {
                SharedPreferences pref2 = getApplicationContext().getSharedPreferences("MyPrefZa", 0); // 0 - for private mode
                EditPhone.setText(pref2.getString("key_PhoneNumber", "")); // getting String
                EditKeyMali.setText(pref2.getString("key_Password", "")); // getting String
                circularProgressButton.setChecked(true);
            } else if (ClassMe.toString().equals("سازهای ماکارونی")) {
                SharedPreferences pref2 = getApplicationContext().getSharedPreferences("MyPrefSa", 0); // 0 - for private mode
                EditPhone.setText(pref2.getString("key_PhoneNumber", "")); // getting String
                EditKeyMali.setText(pref2.getString("key_Password", "")); // getting String
                circularProgressButton.setChecked(true);
            }


        }

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

    private void Login() {
        SharedPreferences pref3 = getApplicationContext().getSharedPreferences("LoginCh", 0); // 0 - for private mode
        SharedPreferences prefSa = getApplicationContext().getSharedPreferences("LoginSa", 0); // 0 - for private mode
        SharedPreferences prefRo = getApplicationContext().getSharedPreferences("LoginRo", 0); // 0 - for private mode
        SharedPreferences prefRi = getApplicationContext().getSharedPreferences("LoginRi", 0);
        SharedPreferences prefZa = getApplicationContext().getSharedPreferences("LoginZa", 0); // 0 - for private mode
        boolean login = pref3.getBoolean("key_Login", false);
        boolean loginSa = prefSa.getBoolean("key_LoginSA", false);
        boolean loginRo = prefRo.getBoolean("key_LoginRo", false);
        boolean loginRi = prefRi.getBoolean("key_LoginRi", false);
        boolean loginZa = prefZa.getBoolean("key_LoginZa", false);
        if (login && Class.toString().equals("چرتکه ومحاسبات ذهنی")) {
            Intent in = new Intent(Enter_toActivity.this, Chortka.class);
            startActivity(in);
            finish();
            System.exit(0);
        }
        if (loginRi && Class.toString().equals("ریاضی سه سوت")) {
            Intent in = new Intent(Enter_toActivity.this, Riaze.class);
            startActivity(in);
            finish();
            System.exit(0);
        }
        if (loginRo && Class.toString().equals("رباتیک")) {
            Intent in = new Intent(Enter_toActivity.this, Class_Robatic.class);
            startActivity(in);
            finish();
            System.exit(0);
        }
        if (loginZa && Class.toString().equals("زبان")) {
            Intent in = new Intent(Enter_toActivity.this, Class_Zaban.class);
            startActivity(in);
            finish();
            System.exit(0);
        }
        if (loginSa && Class.toString().equals("سازهای ماکارونی")) {
            Intent in = new Intent(Enter_toActivity.this, Class_Saze.class);
            startActivity(in);
            finish();
            System.exit(0);
        }

    }

    private void IfSaze() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTSa", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        if (Term.equals("1")) {
            editor.putBoolean("key_AccTSa1", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("2")) {
            editor.putBoolean("key_AccTSa2", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("3")) {
            editor.putBoolean("key_AccTSa3", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("4")) {
            editor.putBoolean("key_AccTSa4", true); // Storing string
            editor.commit(); // commit
        }

    }

    private void IfRiaze() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTRi", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        if (Term.equals("1")) {
            editor.putBoolean("key_AccTRi1", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("2")) {
            editor.putBoolean("key_AccTRi2", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("3")) {
            editor.putBoolean("key_AccTRi3", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("4")) {
            editor.putBoolean("key_AccTRi4", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("5")) {
            editor.putBoolean("key_AccTRi5", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("6")) {
            editor.putBoolean("key_AccTRi6", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("7")) {
            editor.putBoolean("key_AccTRi7", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("8")) {
            editor.putBoolean("key_AccTRi8", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("9")) {
            editor.putBoolean("key_AccTRi9", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("10")) {
            editor.putBoolean("key_AccTRi10", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("11")) {
            editor.putBoolean("key_AccTRi11", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("12")) {
            editor.putBoolean("key_AccTRi12", true); // Storing string
            editor.commit(); // commit
        }


    }

    private void IfZaban() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTZ", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        if (Term.equals("1")) {
            editor.putBoolean("key_AccTZ1", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("2")) {
            editor.putBoolean("key_AccTZ2", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("3")) {
            editor.putBoolean("key_AccTZ3", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("4")) {
            editor.putBoolean("key_AccTZ4", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("5")) {
            editor.putBoolean("key_AccTZ5", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("6")) {
            editor.putBoolean("key_AccTZ6", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("7")) {
            editor.putBoolean("key_AccTZ7", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("8")) {
            editor.putBoolean("key_AccTZ8", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("9")) {
            editor.putBoolean("key_AccTZ9", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("10")) {
            editor.putBoolean("key_AccTZ10", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("11")) {
            editor.putBoolean("key_AccTZ11", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("12")) {
            editor.putBoolean("key_AccTZ12", true); // Storing string
            editor.commit(); // commit
        }


    }

    private void IFRobatic() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTRo", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        if (Term.equals("1")) {
            editor.putBoolean("key_AccTRo1", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("2")) {
            editor.putBoolean("key_AccTRo2", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("3")) {
            editor.putBoolean("key_AccTRo3", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("4")) {
            editor.putBoolean("key_AccTRo4", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("5")) {
            editor.putBoolean("key_AccTRo5", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("6")) {
            editor.putBoolean("key_AccTRo6", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("7")) {
            editor.putBoolean("key_AccTRo7", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("8")) {
            editor.putBoolean("key_AccTRo8", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("9")) {
            editor.putBoolean("key_AccTRo9", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("10")) {
            editor.putBoolean("key_AccTRo10", true); // Storing string
            editor.commit(); // commit
        }

    }

    private void IFChortka() {
        if (Term.equals("1")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTCH", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_AccTCH1", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("2")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTCH", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_AccTCH2", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("3")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTCH", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_AccTCH3", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("4")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTCH", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_AccTCH4", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("5")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTCH", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_AccTCH5", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("6")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTCH", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_AccTCH6", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("7")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTCH", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_AccTCH7", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("8")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTCH", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_AccTCH8", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("9")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTCH", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_AccTCH9", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("10")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTCH", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_AccTCH10", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("11")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTCH", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_AccTCH11", true); // Storing string
            editor.commit(); // commit
        } else if (Term.equals("12")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTCH", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_AccTCH12", true); // Storing string
            editor.commit(); // commit
        }
    }

    private void Initilize() {
        EditPhone = (EditText) findViewById(R.id.MainPage_Home_PhoneNumber);
        EditKeyMali = (EditText) findViewById(R.id.MainPage_Home_EditText_Password);
        MainPage_Home_ButtonSubmit = (Button) findViewById(R.id.MainPage_Home_ButtonSubmit);
        imageToolBar = (ImageView) findViewById(R.id.MainPage_Home_IconToolbar);
        TextToolbar = (TextView) findViewById(R.id.MainPage_Home_toolbar_title);
        MainPage_Home_Button_forRegister = (Button) findViewById(R.id.MainPage_Home_Button_forRegister);
        circularProgressButton = (CheckBox) findViewById(R.id.EnterTo_CheckBoxRemember);


    }
    private void ForDemo() {
        SharedPreferences pref2 = getApplicationContext().getSharedPreferences("Demo", 0); // 0 - for private mode
        EditPhone.setText(pref2.getString("User", "")); // getting String
        EditKeyMali.setText(pref2.getString("Pass", "")); // getting String
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {

            case R.id.MainPage_Home_Button_forRegister: {
                Intent in = new Intent(Enter_toActivity.this, Register_Student.class);
                startActivity(in);
                break;
            }


        }
    }
}
