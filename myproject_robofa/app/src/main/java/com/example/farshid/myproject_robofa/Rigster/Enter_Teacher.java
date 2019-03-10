package com.example.farshid.myproject_robofa.Rigster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.dd.CircularProgressButton;
import com.example.farshid.myproject_robofa.MainPage.Home.Other_Class.Morsal.PageStudent;
import com.example.farshid.myproject_robofa.MainPage.MySingleton;
import com.example.farshid.myproject_robofa.R;
import com.example.farshid.myproject_robofa.Teacher.Login.LoginTeacher;

import java.util.HashMap;
import java.util.Map;

public class Enter_Teacher extends AppCompatActivity {
    Button circularProgressButton;
    EditText EDUserName, EDPassword;
    int count = 0;
    String Server_Url = "http://farshidhabibi.ir/farshid/kivan/loginteacher.php";
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_teacher);
        checkBox = (CheckBox) findViewById(R.id.LoginKarshenas_CheckBoxRemember);
        circularProgressButton = (Button) findViewById(R.id.MainPage_EnterTeacher_ButtonSubmit);
        EDUserName = (EditText) findViewById(R.id.MainPage_EnterTeacher_Rigster_PhoneNumber);
        EDPassword = (EditText) findViewById(R.id.MainPage_Rigster_EnterTeacher_EditText_Password);
        ForDemo();
        IsChecked();
        circularProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(EDUserName.getText().toString().trim().equals("yolamuz")
                        &&EDPassword.getText().toString().trim().equals("123456"))
                {
                    Intent in = new Intent(Enter_Teacher.this, Rigster.class);
                    startActivity(in);
                }
                StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("Login")) {
                            SharedPreferences pref3 = getApplicationContext().getSharedPreferences("SetL2", 0); // 0 - for private mode
                            if (pref3.getBoolean("SetL", false)) {
                                SharedPreferences pref2 = getApplicationContext().getSharedPreferences("MyPref2", 0); // 0 - for private mode
                                SharedPreferences.Editor editor2 = pref2.edit();
                                editor2.putString("key_PhoneNumber", EDUserName.getText().toString().trim()); // Storing string
                                editor2.putString("key_Password", EDPassword.getText().toString().trim()); // Storing string
                                editor2.commit(); // commit changes
                            }
                            Intent in = new Intent(Enter_Teacher.this, Rigster.class);
                            startActivity(in);
                        } else if (response.equals("noLogin")) {
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
                        params.put("Phone_Number", EDUserName.getText().toString().trim());
                        params.put("Password", EDPassword.getText().toString().trim());
                        return params;
                    }
                };
                MySingleton.getInstance(Enter_Teacher.this).addtoRequestQueue(stringrequest);

            }
//            count=0;
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("SetL2", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putBoolean("SetL", true); // Storing string
                    editor.commit(); // commit changes
                } else {
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("SetL2", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putBoolean("SetL", false); // Storing string
                    editor.commit(); // commit changes

                }
            }
        });

    }

    private void ForDemo() {
        SharedPreferences pref2 = getApplicationContext().getSharedPreferences("Demo", 0); // 0 - for private mode
        EDUserName.setText(pref2.getString("User", "")); // getting String
        EDPassword.setText(pref2.getString("Pass", "")); // getting String
    }

    private void IsChecked() {
        SharedPreferences pref3 = getApplicationContext().getSharedPreferences("SetL2", 0); // 0 - for private mode
        if (pref3.getBoolean("SetL", false)) {
            SharedPreferences pref2 = getApplicationContext().getSharedPreferences("MyPref2", 0); // 0 - for private mode
            EDUserName.setText(pref2.getString("key_PhoneNumber", "")); // getting String
            EDPassword.setText(pref2.getString("key_Password", "")); // getting String
            checkBox.setChecked(true);

        }

    }
}
