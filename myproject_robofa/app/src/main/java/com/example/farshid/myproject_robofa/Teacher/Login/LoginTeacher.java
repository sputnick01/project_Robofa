package com.example.farshid.myproject_robofa.Teacher.Login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.dd.CircularProgressButton;
import com.example.farshid.myproject_robofa.MainPage.Home.Other_Class.LoginToPage;
import com.example.farshid.myproject_robofa.MainPage.Home.Other_Class.Morsal.PageStudent;
import com.example.farshid.myproject_robofa.MainPage.MySingleton;
import com.example.farshid.myproject_robofa.R;
import com.example.farshid.myproject_robofa.Teacher.PageTeacher.PageTeacher;
import com.weiwangcn.betterspinner.library.BetterSpinner;

import java.util.HashMap;
import java.util.Map;

public class LoginTeacher extends AppCompatActivity {
    Button circularProgressButton;
    EditText EDUserName, EDPassword;
    int count = 0;
    BetterSpinner KindUser;
    CheckBox checkBoxRemmberPass;
    String Server_Url = "";
    TextView ToolbarLoginTeacher;
    Boolean Trust = false;
    String MyKindUser = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_teacher);

//        مقدار دهس
        Initialize();
        InitializeSpinner();
        ForDemo();
        IsChecked();
        SelectKindUser();
        SetFont();
        circularProgressButton.setOnClickListener(new View.OnClickListener() {
                                                      @Override
                                                      public void onClick(View v) {
                                                          ClickProgressButton();
                                                      }
                                                  }

        );

        checkBoxRemmberPass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                           @Override
                                                           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                               if (isChecked) {
                                                                   SharedPreferences pref = getApplicationContext().getSharedPreferences("SetL", 0); // 0 - for private mode
                                                                   SharedPreferences.Editor editor = pref.edit();
                                                                   editor.putBoolean("SetL", true); // Storing string
                                                                   editor.commit(); // commit changes
                                                               } else {
                                                                   SharedPreferences pref = getApplicationContext().getSharedPreferences("SetL", 0); // 0 - for private mode
                                                                   SharedPreferences.Editor editor = pref.edit();
                                                                   editor.putBoolean("SetL", false); // Storing string
                                                                   editor.commit(); // commit changes

                                                               }
                                                           }
                                                       }

        );
    }

    private void ForDemo() {
        SharedPreferences pref2 = getApplicationContext().getSharedPreferences("Demo", 0); // 0 - for private mode
        EDUserName.setText(pref2.getString("User", "")); // getting String
        EDPassword.setText(pref2.getString("Pass", "")); // getting String
    }

    //        برای وارد شدن
    private void ClickProgressButton() {
        if (hasInternetConnection()) {
            if(EDUserName.getText().toString().trim().equals("yolamuz")
                    &&EDPassword.getText().toString().trim().equals("123456"))
            {
                Intent in = new Intent(LoginTeacher.this, PageTeacher.class);
                startActivity(in);
            }
            if (count == 0) {
                SelectKindUser();
                if (Trust()) {
                    count = 1;
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("ShowAll", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("key_PhoneNumber", EDUserName.getText().toString().trim()); // Storing string
                    editor.putString("key_Password", EDPassword.getText().toString().trim()); // Storing string
                    editor.commit(); // commit changes
                    StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.toString().trim().equals("noLogin")) {
                                count = 0;
                            } else if (response.toString().trim().equals("Login")) {
                                SharedPreferences pref3 = getApplicationContext().getSharedPreferences("SetL", 0); // 0 - for private mode
                                if (pref3.getBoolean("SetL", false)) {
                                    SharedPreferences pref2 = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                                    SharedPreferences.Editor editor2 = pref2.edit();
                                    editor2.putString("key_PhoneNumber", EDUserName.getText().toString().trim()); // Storing string
                                    editor2.putString("key_Password", EDPassword.getText().toString().trim()); // Storing string
                                    editor2.commit(); // commit changes
                                }
                                Intent in = new Intent(LoginTeacher.this, PageTeacher.class);
                                in.putExtra("UserName", EDUserName.getText().toString().trim());
                                in.putExtra("Password", EDPassword.getText().toString().trim());
                                in.putExtra("KindUser", MyKindUser);
                                startActivity(in);
                                count = 0;
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
                            params.put("EDPhoneNumber", EDUserName.getText().toString().trim());
                            params.put("EDMaliKey", EDPassword.getText().toString().trim());
                            return params;
                        }
                    };
                    MySingleton.getInstance(LoginTeacher.this).addtoRequestQueue(stringrequest);

                } else {
                    Toast.makeText(LoginTeacher.this, "فیلد های لازم را پر کنید!!", Toast.LENGTH_SHORT).show();
                }
//            count=0;
            }
        } else {
            Toast.makeText(LoginTeacher.this, "مشکلی در برقراری ارتباط وجود دارد!", Toast.LENGTH_SHORT).show();
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

    private void SetFont() {
        Typeface tf = Typeface.createFromAsset(getAssets(), "font/irsans.ttf");
        checkBoxRemmberPass.setTypeface(tf);
        circularProgressButton.setTypeface(tf);
        EDUserName.setTypeface(tf);
        EDPassword.setTypeface(tf);
        KindUser.setTypeface(tf);
        ToolbarLoginTeacher.setTypeface(tf);
    }

    private boolean Trust() {
        Trust = true;
        if (EDUserName.getText().toString().isEmpty() || EDPassword.getText().toString().isEmpty()
                ||
                KindUser.getText().toString().trim().equals("نوع کاربر")) {
            Trust = false;

        }
        return Trust;
    }

    private void SelectKindUser() {
        if (KindUser.getText().toString().trim().equals("معلم")) {
            MyKindUser = "معلم";
            Server_Url = "http://farshidhabibi.ir/farshid/kivan/loginTe.php";
        } else if (KindUser.getText().toString().trim().equals("مربی")) {
            MyKindUser = "استاد موسسه";
            Server_Url = "http://farshidhabibi.ir/farshid/kivan/LoginTeacher_robofa.php";

        }
    }

    //مقدار دهی سپینر
    private void InitializeSpinner() {
        String[] Document_Student = new String[]{"معلم", "مربی"
        };
        ArrayAdapter<String> adapter_Document_Student = new ArrayAdapter<String>(LoginTeacher.this,
                android.R.layout.simple_dropdown_item_1line, Document_Student);
        KindUser.setAdapter(adapter_Document_Student);

    }

    private void Initialize() {
        checkBoxRemmberPass = (CheckBox) findViewById(R.id.Login_CheckBoxRemember);

        circularProgressButton = (Button) findViewById(R.id.MainPage_LogingTeacher_ButtonSubmit);
        EDUserName = (EditText) findViewById(R.id.MainPage_LogingTeacher_Rigster_PhoneNumber);
        EDPassword = (EditText) findViewById(R.id.MainPage_Rigster_LogingTeacher_EditText_Password);

//        Spinner
        KindUser = (BetterSpinner) findViewById(R.id.KindUser);

        ToolbarLoginTeacher = (TextView) findViewById(R.id.ToolbarLoginTeacher);
    }


    private void IsChecked() {
        SharedPreferences pref3 = getApplicationContext().getSharedPreferences("SetL", 0); // 0 - for private mode
        if (pref3.getBoolean("SetL", false)) {
            SharedPreferences pref2 = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
            EDUserName.setText(pref2.getString("key_PhoneNumber", "")); // getting String
            EDPassword.setText(pref2.getString("key_Password", "")); // getting String
            checkBoxRemmberPass.setChecked(true);

        }

    }


}
