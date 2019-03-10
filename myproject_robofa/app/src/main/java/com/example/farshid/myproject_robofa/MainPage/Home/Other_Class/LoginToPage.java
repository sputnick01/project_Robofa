package com.example.farshid.myproject_robofa.MainPage.Home.Other_Class;

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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.dd.CircularProgressButton;
import com.example.farshid.myproject_robofa.DataBase.DatabaseHelper;
import com.example.farshid.myproject_robofa.MainPage.Home.Other_Class.Morsal.PageStudent;
import com.example.farshid.myproject_robofa.MainPage.MySingleton;
import com.example.farshid.myproject_robofa.R;
import com.example.farshid.myproject_robofa.Spalish.Spalish;
import com.example.farshid.myproject_robofa.Teacher.Login.LoginTeacher;
import com.example.farshid.myproject_robofa.Teacher.PageTeacher.PageTeacher;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginToPage extends AppCompatActivity implements View.OnClickListener {
    TextView LoginToPage_Toolbar;
    EditText EditUserName, EditTextPassword;
    Button LoginToPage_ButtonSubmit;
    boolean Trust=false;
    String Base = "", UserName = "", Password = "",MyBase="",TypeClass="";
    String Server_Url = "http://farshidhabibi.ir/farshid/kivan/LoginStudent.php";

    JSONObject obj3;
    JSONArray jsonarray3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_to_page);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Base = extras.getString("Base");
        }
        Initialize();
        ForDemo();
        SetFont();
        Loginpage();
        LoginToPage_ButtonSubmit.setOnClickListener(this);
    }



    private void Loginpage() {

        if (Base.toString().equals("اول")) {
            // commit changes
            MyBase="اول ابتدایی";
            SharedPreferences pref3 = getApplicationContext().getSharedPreferences("Login", 0); // 0 - for private mode
            if (pref3.getBoolean("Login1", false)) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("User1", 0); // 0 - for private mode
                UserName = pref.getString("UserName", UserName);
                Password = pref.getString("Password", Password);
                Intent in = new Intent(LoginToPage.this, PageStudent.class);
                in.putExtra("UserName", UserName);
                in.putExtra("Password", Password);
                in.putExtra("Base", Base);
                in.putExtra("Type1","A");
                startActivity(in);
            }
        } else if (Base.toString().equals("دوم")) {
            MyBase="دوم ابتدایی";
            // commit changes
            SharedPreferences pref3 = getApplicationContext().getSharedPreferences("Login", 0); // 0 - for private mode
            if (pref3.getBoolean("Login2", false)) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("User2", 0); // 0 - for private mode
                UserName = pref.getString("UserName", UserName);
                Password = pref.getString("Password", Password);
                Intent in = new Intent(LoginToPage.this, PageStudent.class);
                in.putExtra("UserName", UserName);
                in.putExtra("Password", Password);
                in.putExtra("Base", Base);
                in.putExtra("Type1","B");
                startActivity(in);
            }
        } else if (Base.toString().equals("سوم")) {
            // commit changes
            MyBase="سوم ابتدایی";
            SharedPreferences pref3 = getApplicationContext().getSharedPreferences("Login", 0); // 0 - for private mode
            if (pref3.getBoolean("Login3", false)) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("User3", 0); // 0 - for private mode
                UserName = pref.getString("UserName", UserName);
                Password = pref.getString("Password", Password);
                Intent in = new Intent(LoginToPage.this, PageStudent.class);
                in.putExtra("UserName", UserName);
                in.putExtra("Password", Password);
                in.putExtra("Base", Base);
                in.putExtra("Type1","C");
                startActivity(in);
            }
        } else if (Base.toString().equals("چهارم")) {
            // commit changes
            MyBase="چهارم ابتدایی";
            SharedPreferences pref3 = getApplicationContext().getSharedPreferences("Login", 0); // 0 - for private mode
            if (pref3.getBoolean("Login4", false)) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("User4", 0); // 0 - for private mode
                UserName = pref.getString("UserName", UserName);
                Password = pref.getString("Password", Password);
                Intent in = new Intent(LoginToPage.this, PageStudent.class);
                in.putExtra("UserName", UserName);
                in.putExtra("Password", Password);
                in.putExtra("Base", Base);
                in.putExtra("Type1","D");
                startActivity(in);
            }
        } else if (Base.toString().equals("پنجم")) {
            // commit changes
            MyBase="پنجم ابتدایی";
            SharedPreferences pref3 = getApplicationContext().getSharedPreferences("Login", 0); // 0 - for private mode
            if (pref3.getBoolean("Login5", false)) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("User5", 0); // 0 - for private mode
                UserName = pref.getString("UserName", UserName);
                Password = pref.getString("Password", Password);
                Intent in = new Intent(LoginToPage.this, PageStudent.class);
                in.putExtra("UserName", UserName);
                in.putExtra("Password", Password);
                in.putExtra("Base", Base);
                startActivity(in);
            }
        } else if (Base.toString().equals("ششم")) {
            // commit changes
            MyBase="ششم ابتدایی";
            SharedPreferences pref3 = getApplicationContext().getSharedPreferences("Login", 0); // 0 - for private mode
            if (pref3.getBoolean("Login6", false)) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("User6", 0); // 0 - for private mode
                UserName = pref.getString("UserName", UserName);
                Password = pref.getString("Password", Password);
                Intent in = new Intent(LoginToPage.this, PageStudent.class);
                in.putExtra("UserName", UserName);
                in.putExtra("Password", Password);
                in.putExtra("Base", Base);
                startActivity(in);
            }
        }

    }

    //    ست کردن فونت
    private void SetFont() {
        Typeface tf = Typeface.createFromAsset(getAssets(), "font/irsans.ttf");
        LoginToPage_Toolbar.setTypeface(tf);
        EditUserName.setTypeface(tf);
        EditTextPassword.setTypeface(tf);
        LoginToPage_ButtonSubmit.setTypeface(tf);
    }

    //    مقدار دهی مقادیر
    private void Initialize() {

//        TextView
        LoginToPage_Toolbar = (TextView) findViewById(R.id.LoginToPage_Toolbar);

//        EditText
        EditUserName = (EditText) findViewById(R.id.LoginToPage_PhoneNumber);
        EditTextPassword = (EditText) findViewById(R.id.LoginToPage_NationalCode);

//        Button
        LoginToPage_ButtonSubmit = (Button) findViewById(R.id.LoginToPage_ButtonSubmit);


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
    @Override
    public void onClick(View v) {
        if (hasInternetConnection()) {
            if(EditUserName.getText().toString().trim().equals("yolamuz")
                    &&EditTextPassword.getText().toString().trim().equals("123456"))
            {
                Intent in = new Intent(LoginToPage.this, PageStudent.class);
                in.putExtra("UserName", EditUserName.getText().toString().trim());
                in.putExtra("Password", EditTextPassword.getText().toString().trim());
                in.putExtra("Base", Base);
                in.putExtra("Type1", "A");
                startActivity(in);
            }
            if (Trust()) {
                StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        if (response.toString().trim().equals("LoginA")) {
                            SaveTOFile();
                            SharedPreferences pref = getApplicationContext().getSharedPreferences("UserBase", 0); // 0 - for private mode
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("UserName1", EditUserName.getText().toString().trim()); // Storing string
                            editor.putString("Password1", EditTextPassword.getText().toString().trim()); // Storing string
                            editor.commit(); // commit changes
                            Intent in = new Intent(LoginToPage.this, PageStudent.class);
                            in.putExtra("UserName", EditUserName.getText().toString().trim());
                            in.putExtra("Password", EditTextPassword.getText().toString().trim());
                            in.putExtra("Base", Base);
                            in.putExtra("Type1", "A");
                            startActivity(in);
                        } else if (response.toString().trim().equals("LoginB")) {
                            SaveTOFile();
                            Intent in = new Intent(LoginToPage.this, PageStudent.class);
                            in.putExtra("UserName", EditUserName.getText().toString().trim());
                            in.putExtra("Password", EditTextPassword.getText().toString().trim());
                            in.putExtra("Base", Base);
                            in.putExtra("Type1", "B");
                            startActivity(in);
                        } else if (response.toString().trim().equals("LoginC")) {
                            SaveTOFile();
                            Intent in = new Intent(LoginToPage.this, PageStudent.class);
                            in.putExtra("UserName", EditUserName.getText().toString().trim());
                            in.putExtra("Password", EditTextPassword.getText().toString().trim());
                            in.putExtra("Base", Base);
                            in.putExtra("Type1", "C");
                            startActivity(in);
                        } else if (response.toString().trim().equals("LoginD")) {
                            SaveTOFile();
                            Intent in = new Intent(LoginToPage.this, PageStudent.class);
                            in.putExtra("UserName", EditUserName.getText().toString().trim());
                            in.putExtra("Password", EditTextPassword.getText().toString().trim());
                            in.putExtra("Base", Base);
                            in.putExtra("Type1", "D");
                            startActivity(in);
                        } else if (response.toString().trim().equals("noLogin")) {
                            Toast.makeText(LoginToPage.this, "این بخش برای شما در دسترس نیست!", Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                Toast.makeText(LoginToPage.this, "اینترنت خود را بررسی کنید!", Toast.LENGTH_SHORT).show();
                    }
                }
                ) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("EDPhoneNumber", EditUserName.getText().toString().trim());
                        params.put("EDMaliKey", EditTextPassword.getText().toString().trim());
                        params.put("Base", Base);
                        return params;
                    }
                };
                MySingleton.getInstance(LoginToPage.this).addtoRequestQueue(stringrequest);
            }
        } else {
                Toast.makeText(this, "مشکلی در برقراری اینترنت وجود دارد!", Toast.LENGTH_SHORT).show();
            }


    }
//   ذخیره اطلاعات در فایل

    private boolean Trust() {
        Trust=true;
        if (EditUserName.getText().toString().isEmpty()|| EditTextPassword.getText().toString().isEmpty()){
            Trust=false;
        }
        return  Trust;

    }
    private void ForDemo() {
        SharedPreferences pref2 = getApplicationContext().getSharedPreferences("Demo", 0); // 0 - for private mode
        EditUserName.setText(pref2.getString("User", "")); // getting String
        EditTextPassword.setText(pref2.getString("Pass", "")); // getting String
    }
    private void SaveTOFile() {
        if (Base.toString().equals("اول")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("User1", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("UserName", EditUserName.getText().toString().trim()); // Storing string
            editor.putString("Password", EditTextPassword.getText().toString().trim()); // Storing string
            editor.commit(); // commit changes
        } else if (Base.toString().equals("دوم")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("User2", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("UserName", EditUserName.getText().toString().trim()); // Storing string
            editor.putString("Password", EditTextPassword.getText().toString().trim()); // Storing string
            editor.commit(); // commit changes
        } else if (Base.toString().equals("سوم")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("User3", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("UserName", EditUserName.getText().toString().trim()); // Storing string
            editor.putString("Password", EditTextPassword.getText().toString().trim()); // Storing string
            editor.commit(); // commit changes

        } else if (Base.toString().equals("چهارم")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("User4", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("UserName", EditUserName.getText().toString().trim()); // Storing string
            editor.putString("Password", EditTextPassword.getText().toString().trim()); // Storing string
            editor.commit(); // commit changes

        } else if (Base.toString().equals("پنجم")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("User5", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("UserName", EditUserName.getText().toString().trim()); // Storing string
            editor.putString("Password", EditTextPassword.getText().toString().trim()); // Storing string
            editor.commit(); // commit changes
        } else if (Base.toString().equals("ششم")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("User6", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("UserName", EditUserName.getText().toString().trim()); // Storing string
            editor.putString("Password", EditTextPassword.getText().toString().trim()); // Storing string
            editor.commit(); // commit changes
        }
    }
}
