package com.example.farshid.myproject_robofa.Teacher.SearchStudent;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.example.farshid.myproject_robofa.MainPage.MySingleton;
import com.example.farshid.myproject_robofa.R;
import com.example.farshid.myproject_robofa.Teacher.SearchStudent.AdapterSearchStudent;
import com.example.farshid.myproject_robofa.Teacher.SearchStudent.ListStudent;
import com.example.farshid.myproject_robofa.Teacher.SearchStudent.ModleSearchStudent;
import com.weiwangcn.betterspinner.library.BetterSpinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by farshid on 11/7/2018.
 */

public class TabAnsverToQuestion extends Fragment implements View.OnClickListener {
    View view;
    BetterSpinner ET, EC, TC, SpinnerBase, SpinnerLessen;
    Button ok;
    String UserName = "", Password = "", KindUser = "";
    boolean Trust = false;
    String Server_Ur3 = "http://farshidhabibi.ir/farshid/kivan/TrustForTeacher.php";
    String Server_Ur2 = "http://farshidhabibi.ir/farshid/kivan/SelectMyStudent.php";
    RecyclerView recyclerView;
    ArrayList<ModleSearchStudent> modellist;
    int count = 0;
    String[] ListLesson;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_ansvertoquestion, container, false);
        Give_Data_From_File();
        Initialize();
        LoadPage();
        InitializeSpinner();
        SetFont();
        ok.setOnClickListener(this);
        SpinnerBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InitializeSpinner();
            }
        });
        return view;
    }
    public boolean hasInternetConnection() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
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
    //    ست کردن فونت
    private void SetFont() {

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "font/irsans.ttf");
        ET.setTypeface(tf);
        EC.setTypeface(tf);
        TC.setTypeface(tf);
        SpinnerBase.setTypeface(tf);
        ok.setTypeface(tf);
        SpinnerLessen.setTypeface(tf);
    }

    //    مقدار دهی سپینر ها
    private void InitializeSpinner() {
        ListLesson = new String[]{
                "قرآن", "فارسی", "علوم تجربی", "ریاضی", "هنر",
                "هدیه های آسمانی", "املا", "مطالعات اجتماعی", "انشا فارسی", "انظباط"
        };
        if (SpinnerBase.getText().toString().equals("اول")) {
            ListLesson = new String[]{
                    "قرآن", "فارسی", "علوم تجربی", "ریاضی", "هنر", "انظباط"
            };
        } else if (SpinnerBase.getText().toString().equals("دوم")) {
            ListLesson = new String[]{
                    "قرآن", "فارسی", "علوم تجربی", "ریاضی", "هنر",
                    "هدیه های آسمانی", "املا", "انظباط"
            };
        } else if (SpinnerBase.getText().toString().equals("سوم")) {
            ListLesson = new String[]{
                    "قرآن", "فارسی", "علوم تجربی", "ریاضی", "هنر",
                    "هدیه های آسمانی", "املا", "مطالعات اجتماعی", "انظباط"
            };
        } else if (SpinnerBase.getText().toString().equals("چهارم")) {
            ListLesson = new String[]{
                    "قرآن", "فارسی", "علوم تجربی", "ریاضی", "هنر",
                    "هدیه های آسمانی", "املا", "مطالعات اجتماعی", "انشا فارسی"
            };
        } else if (SpinnerBase.getText().toString().equals("پنجم")) {
            ListLesson = new String[]{
                    "قرآن", "فارسی", "علوم تجربی", "ریاضی", "هنر",
                    "هدیه های آسمانی", "املا", "مطالعات اجتماعی", "انشا فارسی"
            };
        } else if (SpinnerBase.getText().toString().equals("ششم")) {
            ListLesson = new String[]{
                    "قرآن", "فارسی", "علوم تجربی", "ریاضی", "هنر",
                    "هدیه های آسمانی", "املا", "مطالعات اجتماعی", "انشا فارسی"
            };
        }
        String[] MyBase = new String[]{"اول", "دوم"
                , "سوم", "چهارم", "پنجم", "ششم"
        };
        ArrayAdapter<String> Base1 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, ListLesson);
        SpinnerLessen.setAdapter(Base1);


        ArrayAdapter<String> Base = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, MyBase);
        SpinnerBase.setAdapter(Base);
        String[] Type = new String[]{"A", "B"
                , "C", "D"
        };
        ArrayAdapter<String> adapter_Document_Type = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, Type);
        TC.setAdapter(adapter_Document_Type);
        String[] Document_Student = new String[]{"1", "2"
                , "3", "4", "5", "6", "7", "8 ", "9", "10 "
                , "11", "12"
        };
        String[] Field2 = new String[]{"رباتیک", "چرتکه ومحاسبات ذهنی"
                , "سازهای ماکارونی", "زبان", "کلاس های دیگر", "ریاضی سه سوت "
        };
        ArrayAdapter<String> adapter_Document_Student = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, Document_Student);
        ET.setAdapter(adapter_Document_Student);
        ArrayAdapter<String> adapter_Document_Teacher = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, Field2);
        EC.setAdapter(adapter_Document_Teacher);
    }

    //    مقدار دهی مقادیر
    private void Initialize() {
        recyclerView = view.findViewById(R.id.RecyclerView_SearchStudent);
        ET = (BetterSpinner) view.findViewById(R.id.Search_Term);
        EC = (BetterSpinner) view.findViewById(R.id.Search_Class);
        TC = (BetterSpinner) view.findViewById(R.id.Search_TypeClass);
        ok = (Button) view.findViewById(R.id.Search_ok);
        SpinnerBase = view.findViewById(R.id.Search_Student_Base);
        SpinnerLessen = view.findViewById(R.id.Search_Student_Lessen);
    }

    //    گرفتن اطلاعات از فایل
    private void Give_Data_From_File() {
        SharedPreferences pref3 = getActivity().getApplicationContext().getSharedPreferences("User", 0); // 0 - for private mode
        UserName = pref3.getString("UserName", "");
        Password = pref3.getString("Password", "");
        KindUser = pref3.getString("KindUser", "");
    }

    //   بخش مشخص کردن ایکون های صفحه
    private void LoadPage() {
        if (KindUser.toString().trim().equals("معلم")) {
            ET.setVisibility(View.GONE);
            EC.setVisibility(View.GONE);
            SpinnerLessen.setVisibility(View.GONE);
        } else if (KindUser.toString().trim().equals("استاد موسسه")) {
            SpinnerBase.setVisibility(View.GONE);
            SpinnerLessen.setVisibility(View.GONE);
        }
    }

    //    گرفتن اطلاعات از سرور
    private void ForRecyclerView() {
        if (KindUser.toString().equals("معلم")) {

            SendInfoServer1();
        } else if (KindUser.toString().equals("استاد موسسه")) {
            SendInfoServer2();
        }

    }

    //    گرفتن اطلاعات سرور برای موسسه
    private void SendInfoServer2() {
        modellist = new ArrayList<>();
        StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Ur2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                progressBar.setVisibility(View.GONE);
                if (response.toString().equals("Login")) {
                    Intent in = new Intent(getActivity(), ListStudent.class);
                    in.putExtra("Class", EC.getText().toString().trim());
                    in.putExtra("Term", ET.getText().toString().trim());
                    in.putExtra("TypeTerm", TC.getText().toString().trim());
                    startActivity(in);

                } else if (response.toString().equals("NoLogin")) {
                    Toast.makeText(getActivity(), "برای شما دانش آموزی ثب نشده!", Toast.LENGTH_SHORT).show();
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
                params.put("Field", EC.getText().toString().trim());
                params.put("Term", ET.getText().toString().trim());
                params.put("TypeTerm", TC.getText().toString().trim());
                params.put("UserName", UserName);
                params.put("Password", Password);
                params.put("KindUser", KindUser);
                return params;
            }
        };
        MySingleton.getInstance(getActivity()).addtoRequestQueue(stringrequest);

    }

    //    گرفتن اطلاعات سرور برای مدرسه
    private void SendInfoServer1() {

        modellist = new ArrayList<>();
        StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Ur3, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                progressBar.setVisibility(View.GONE);
                if (response.toString().equals("Login")) {
                    Intent in = new Intent(getActivity(), ListStudent.class);
                    in.putExtra("Base", SpinnerBase.getText().toString().trim());
                    in.putExtra("Lessen", SpinnerLessen.getText().toString().trim());
                    in.putExtra("TypeTerm", TC.getText().toString().trim());
                    startActivity(in);

                } else if (response.toString().equals("NoLogin")) {
                    Toast.makeText(getActivity(), "برای شما دانش آموزی ثب نشده!", Toast.LENGTH_SHORT).show();
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
                params.put("Base", SpinnerBase.getText().toString().trim());
                params.put("Lessen", SpinnerLessen.getText().toString().trim());
                params.put("TypeTerm", TC.getText().toString().trim());
                params.put("UserName", UserName);
                params.put("Password", Password);
                return params;
            }
        };
        MySingleton.getInstance(getActivity()).addtoRequestQueue(stringrequest);

    }

    //    برای بررسی پر کردن همه ی فیلد ها
    private boolean Trust() {
        Trust = true;
        if (KindUser.toString().trim().equals("استاد موسسه")) {
            if (ET.getText().toString().equals("ترم") || TC.getText().toString().equals("نوع کلاس") || EC.getText().toString().equals("رشته")) {
                Trust = false;
            }
        } else if (KindUser.toString().trim().equals("معلم")) {
            if (TC.getText().toString().equals("نوع کلاس") || SpinnerBase.getText().toString().equals("پایه")) {
                Trust = false;
            }
        }
        return Trust;

    }

    @Override
    public void onClick(View v) {
        if (hasInternetConnection()) {
            if (Trust()) {
                if (count == 0) {
                    count = 1;
                    ForRecyclerView();
                    count = 0;
                }
            } else {
                Toast.makeText(getActivity(), "فیلد ها را کامل کنید!", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(getActivity(), "مشکلی در برقراری ارتباط وجود دارد!", Toast.LENGTH_SHORT).show();
        }

    }
}
