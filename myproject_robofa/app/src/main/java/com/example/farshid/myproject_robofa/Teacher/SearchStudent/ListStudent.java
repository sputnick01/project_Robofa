package com.example.farshid.myproject_robofa.Teacher.SearchStudent;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.dd.CircularProgressButton;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Robatic.Class_Robatic;
import com.example.farshid.myproject_robofa.MainPage.MySingleton;
import com.example.farshid.myproject_robofa.R;
import com.weiwangcn.betterspinner.library.BetterSpinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListStudent extends AppCompatActivity {
    String UserName = "", Password = "", KindUser = "", Lessen = "", Base = "";
    JSONObject obj;
    JSONArray jsonarray;
    String Server_Ur3 = "http://farshidhabibi.ir/farshid/kivan/SelectAllStudentSchool.php";
    String Server_Ur2 = "http://farshidhabibi.ir/farshid/kivan/SelectStu.php";
    RecyclerView recyclerView;
    ArrayList<ModleSearchStudent> modellist;
    AdapterSearchStudent homeAdd;
    String Term, Class, TypeTerm;
    TextView Title_ListStudent;
    String Kind="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_student);
        Initialize();
        SetFont();
        Give_From_File();
        GiveFromBundle();
        ForRecyclerView();
    }


//    ست کردن فونت
    private void SetFont() {
        Typeface tf = Typeface.createFromAsset(getAssets(), "font/irsans.ttf");
        Title_ListStudent.setTypeface(tf);
    }

    //    گرفتن اطلاعات از فایل
    private void Give_From_File() {
        SharedPreferences pref3 = getApplicationContext().getSharedPreferences("User", 0); // 0 - for private mode
        UserName = pref3.getString("UserName", "");
        Password = pref3.getString("Password", "");
        KindUser = pref3.getString("KindUser", "");
    }

    //گرفتن اطلاعات از صفحه ی قبل
    private void GiveFromBundle() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (KindUser.toString().equals("معلم")) {
                Lessen = extras.getString("Lessen");
                TypeTerm = extras.getString("TypeTerm");
                Base = extras.getString("Base");
                Kind="Teacher";
            } else if (KindUser.toString().equals("استاد موسسه")) {
                Term = extras.getString("Term");
                TypeTerm = extras.getString("TypeTerm");
                Class = extras.getString("Class");
                Kind="Master";
            }
            SharedPreferences pref = getApplicationContext().getSharedPreferences("ListSyudent", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("Kind",Kind); // Storing string
            editor.commit(); // commit changes
        }
    }

    //    مقدار دهی
    private void Initialize() {
        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView_SearchStudent);
        Title_ListStudent= (TextView) findViewById(R.id.Title_ListStudent);
    }

    //    انتخاب گرفتن اطلاعات برای کدام قسمت
    private void ForRecyclerView() {
        if (KindUser.toString().equals("معلم")) {

            SendInfoServer1();
        } else if (KindUser.toString().equals("استاد موسسه")) {

            SendInfoServer2();
        }

    }

    //        گرفتن اطلاعات  موسسه از سرور
    private void SendInfoServer2() {
        modellist = new ArrayList<>();
        StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Ur2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                progressBar.setVisibility(View.GONE);
                int count = 0;
                try {
                    obj = new JSONObject(response);
                    jsonarray = obj.getJSONArray("resp");
                    while (count < jsonarray.length()) {
                        JSONObject jsonObject = jsonarray.getJSONObject(count);
                        String Name = jsonObject.getString("Name");
                        String LastName = jsonObject.getString("LastName");
                        String PhoneNumber = jsonObject.getString("PhoneNumber");
                        String NationalCode = jsonObject.getString("National_Code");
                        String Image1 = jsonObject.getString("Image");
                        String Id = jsonObject.getString("Id");
                        String na = Name + " " + LastName;
                        modellist.add(new ModleSearchStudent(Id, na, PhoneNumber, NationalCode, jsonObject.getString("Image")));
                        final LinearLayoutManager layoutmanager = new LinearLayoutManager(ListStudent.this);
                        RecyclerView.LayoutManager rcLayoutManager = layoutmanager;
                        recyclerView.setLayoutManager(rcLayoutManager);
                        homeAdd = new AdapterSearchStudent(ListStudent.this, modellist);
                        recyclerView.setAdapter(homeAdd);
                        count++;
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                onload();

            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Field", Class);
                params.put("Term", Term);
                params.put("TypeTerm", TypeTerm);
                return params;
            }
        };
        MySingleton.getInstance(ListStudent.this).addtoRequestQueue(stringrequest);

    }

    //        گرفتن اطلاعات  مدرسه از سرور
    private void SendInfoServer1() {
        modellist = new ArrayList<>();
        StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Ur3, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                progressBar.setVisibility(View.GONE);
                int count = 0;
                try {
                    obj = new JSONObject(response);
                    jsonarray = obj.getJSONArray("resp");
                    while (count < jsonarray.length()) {
                        JSONObject jsonObject = jsonarray.getJSONObject(count);
                        String Name = jsonObject.getString("Name");
                        String LastName = jsonObject.getString("LastName");
                        String PhoneNumber = jsonObject.getString("PhoneNumber");
                        String NationalCode = jsonObject.getString("NationalCode");
                        String Image1 = jsonObject.getString("Image");
                        String Id = jsonObject.getString("Id");
                        String na = Name + " " + LastName;
                        modellist.add(new ModleSearchStudent(Id, na, PhoneNumber, NationalCode, Image1));
                        final LinearLayoutManager layoutmanager = new LinearLayoutManager(ListStudent.this);
                        RecyclerView.LayoutManager rcLayoutManager = layoutmanager;
                        recyclerView.setLayoutManager(rcLayoutManager);
                        homeAdd = new AdapterSearchStudent(ListStudent.this, modellist);
                        recyclerView.setAdapter(homeAdd);
                        count++;
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                onload();

            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Base", Base);
                params.put("Lessen", Lessen);
                params.put("TypeTerm", TypeTerm);
                return params;
            }
        };
        MySingleton.getInstance(ListStudent.this).addtoRequestQueue(stringrequest);

    }
}
