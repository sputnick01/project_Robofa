package com.example.farshid.myproject_robofa.TabStudent;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.Note.Adapter_Note;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.Note.Mode_Note;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.Note.Noti.Adapter_Noti;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.Note.Noti.Modle_Noti;
import com.example.farshid.myproject_robofa.MainPage.MySingleton;
import com.example.farshid.myproject_robofa.R;
import com.github.ybq.android.spinkit.style.FoldingCube;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by farshid on 11/8/2018.
 */

public class TabQouestion extends Fragment {
    View view;
    String Server_Ur2 = "http://farshidhabibi.ir/farshid/kivan/select_note.php";
    String Server_Ur22 = "http://farshidhabibi.ir/farshid/kivan/SelectNot_School.php";
    String Term = "";
    JSONObject obj;
    JSONArray jsonarray;
    RecyclerView recycler;
    ArrayList<Modle_Noti> modellist;
    Adapter_Noti homeAdd;
    ProgressDialog progressDialog;
    CoordinatorLayout coordinatorLayout;
    ProgressBar progressBar;
    private int time_interval = 2000;
    private long oldCurrentTimeMillis;
    int Count = 0;
    Toolbar toolbar;
    String Class = "";
    String TermMe = "", ClassMe = "", TypeTerm = "",Base="",TypeClass="",Kind="";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.tabqouestion,container,false);
        Initialize();
        SharedPreferences pref3 = getActivity().getApplicationContext().getSharedPreferences("Note", 0); // 0 - for private mode
        TermMe = pref3.getString("Term", "");
        ClassMe = pref3.getString("Class", "");
        SharedPreferences pref31 = getActivity().getApplicationContext().getSharedPreferences("Base", 0); // 0 - for private mode
        Base = pref31.getString("Base", "");
        TypeClass = pref31.getString("Type1", "");
        SharedPreferences pref311 = getActivity().getApplicationContext().getSharedPreferences("SchoolNote", 0); // 0 - for private mode
        Kind = pref311.getString("Kind", "");
        Saze();
        Robatic();
        Riaze();
        Chortka();
        Zaban();
        ForRecyclerView();
        return view;

    }
    private void Zaban() {
        if (ClassMe.toString().equals("زبان")) {
            SharedPreferences pref2 = getActivity().getApplicationContext().getSharedPreferences("TypeTermZa", 0); // 0 - for private mode
            if (TermMe.toString().equals("1")) {
                TypeTerm = pref2.getString("TypeTerm1", "");
            }
            if (TermMe.toString().equals("2")) {
                TypeTerm = pref2.getString("TypeTerm2", "");
            }
            if (TermMe.toString().equals("3")) {
                TypeTerm = pref2.getString("TypeTerm3", "");
            }
            if (TermMe.toString().equals("4")) {
                TypeTerm = pref2.getString("TypeTerm4", "");
            }
            if (TermMe.toString().equals("5")) {
                TypeTerm = pref2.getString("TypeTerm5", "");
            }
            if (TermMe.toString().equals("6")) {
                TypeTerm = pref2.getString("TypeTerm6", "");
            }
            if (TermMe.toString().equals("7")) {
                TypeTerm = pref2.getString("TypeTerm7", "");
            }
            if (TermMe.toString().equals("8")) {
                TypeTerm = pref2.getString("TypeTerm8", "");
            }
            if (TermMe.toString().equals("9")) {
                TypeTerm = pref2.getString("TypeTerm9", "");
            }
            if (TermMe.toString().equals("10")) {
                TypeTerm = pref2.getString("TypeTerm10", "");
            }
            if (TermMe.toString().equals("11")) {
                TypeTerm = pref2.getString("TypeTerm9", "");
            }
            if (TermMe.toString().equals("12")) {
                TypeTerm = pref2.getString("TypeTerm10", "");
            }
        }

    }

    private void Chortka() {
        if (ClassMe.toString().equals("چرتکه ومحاسبات ذهنی")) {
            SharedPreferences pref2 = getActivity().getApplicationContext().getSharedPreferences("TypeTermCh", 0); // 0 - for private mode
            if (TermMe.toString().equals("1")) {
                TypeTerm = pref2.getString("TypeTermC1", "");
            }
            if (TermMe.toString().equals("2")) {
                TypeTerm = pref2.getString("TypeTerm2", "");
            }
            if (TermMe.toString().equals("3")) {
                TypeTerm = pref2.getString("TypeTerm3", "");
            }
            if (TermMe.toString().equals("4")) {
                TypeTerm = pref2.getString("TypeTerm4", "");
            }
            if (TermMe.toString().equals("5")) {
                TypeTerm = pref2.getString("TypeTerm5", "");
            }
            if (TermMe.toString().equals("6")) {
                TypeTerm = pref2.getString("TypeTerm6", "");
            }
            if (TermMe.toString().equals("7")) {
                TypeTerm = pref2.getString("TypeTerm7", "");
            }
            if (TermMe.toString().equals("8")) {
                TypeTerm = pref2.getString("TypeTerm8", "");
            }
            if (TermMe.toString().equals("9")) {
                TypeTerm = pref2.getString("TypeTerm9", "");
            }
            if (TermMe.toString().equals("10")) {
                TypeTerm = pref2.getString("TypeTerm10", "");
            }
            if (TermMe.toString().equals("11")) {
                TypeTerm = pref2.getString("TypeTerm9", "");
            }
            if (TermMe.toString().equals("12")) {
                TypeTerm = pref2.getString("TypeTerm10", "");
            }

        }
    }

    private void Riaze() {
        if (ClassMe.toString().equals("ریاضی سه سوت")) {
            SharedPreferences pref2 = getActivity().getApplicationContext().getSharedPreferences("TypeTermRi", 0); // 0 - for private mode
            if (TermMe.toString().equals("1")) {
                TypeTerm = pref2.getString("TypeTerm1", "");
            }
            if (TermMe.toString().equals("2")) {
                TypeTerm = pref2.getString("TypeTerm2", "");
            }
            if (TermMe.toString().equals("3")) {
                TypeTerm = pref2.getString("TypeTerm3", "");
            }
            if (TermMe.toString().equals("4")) {
                TypeTerm = pref2.getString("TypeTerm4", "");
            }
            if (TermMe.toString().equals("5")) {
                TypeTerm = pref2.getString("TypeTerm5", "");
            }
            if (TermMe.toString().equals("6")) {
                TypeTerm = pref2.getString("TypeTerm6", "");
            }
            if (TermMe.toString().equals("7")) {
                TypeTerm = pref2.getString("TypeTerm7", "");
            }
            if (TermMe.toString().equals("8")) {
                TypeTerm = pref2.getString("TypeTerm8", "");
            }
            if (TermMe.toString().equals("9")) {
                TypeTerm = pref2.getString("TypeTerm9", "");
            }
            if (TermMe.toString().equals("10")) {
                TypeTerm = pref2.getString("TypeTerm10", "");
            }
            if (TermMe.toString().equals("11")) {
                TypeTerm = pref2.getString("TypeTerm9", "");
            }
            if (TermMe.toString().equals("12")) {
                TypeTerm = pref2.getString("TypeTerm10", "");
            }
        }
    }

    private void Robatic() {
        if (ClassMe.toString().equals("رباتیک")) {
            SharedPreferences pref2 = getActivity().getApplicationContext().getSharedPreferences("TypeTermRo", 0); // 0 - for private mode
            if (TermMe.toString().equals("1")) {
                TypeTerm = pref2.getString("TypeTerm1", "");
            }
            if (TermMe.toString().equals("2")) {
                TypeTerm = pref2.getString("TypeTerm2", "");
            }
            if (TermMe.toString().equals("3")) {
                TypeTerm = pref2.getString("TypeTerm3", "");
            }
            if (TermMe.toString().equals("4")) {
                TypeTerm = pref2.getString("TypeTerm4", "");
            }
            if (TermMe.toString().equals("5")) {
                TypeTerm = pref2.getString("TypeTerm5", "");
            }
            if (TermMe.toString().equals("6")) {
                TypeTerm = pref2.getString("TypeTerm6", "");
            }
            if (TermMe.toString().equals("7")) {
                TypeTerm = pref2.getString("TypeTerm7", "");
            }
            if (TermMe.toString().equals("8")) {
                TypeTerm = pref2.getString("TypeTerm8", "");
            }
            if (TermMe.toString().equals("9")) {
                TypeTerm = pref2.getString("TypeTerm9", "");
            }
            if (TermMe.toString().equals("10")) {
                TypeTerm = pref2.getString("TypeTerm10", "");
            }

        }
    }

    private void Saze() {
        if (ClassMe.toString().equals("سازهای ماکارونی")) {
            SharedPreferences pref2 = getActivity().getApplicationContext().getSharedPreferences("TypeTermSa", 0); // 0 - for private mode
            if (TermMe.toString().equals("1")) {
                TypeTerm = pref2.getString("TypeTerm1", "");
            }
            if (TermMe.toString().equals("2")) {
                TypeTerm = pref2.getString("TypeTerm2", "");
            }
            if (TermMe.toString().equals("3")) {
                TypeTerm = pref2.getString("TypeTerm3", "");
            }
            if (TermMe.toString().equals("4")) {
                TypeTerm = pref2.getString("TypeTerm4", "");
            }

        }
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




    private void Initialize() {
//        progressBar = (ProgressBar) view.findViewById(R.id.Noti_spin_kit);
        recycler = (RecyclerView) view.findViewById(R.id.Noti_RecyclerView);
//        FoldingCube cubeGrid = new FoldingCube();
//        progressBar.setIndeterminateDrawable(cubeGrid);
    }


    private void ForRecyclerView() {
        if (Kind.equals("School")){
            modellist = new ArrayList<>();
            StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Ur22, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    int count = 0;
                    try {
                        obj = new JSONObject(response);
                        jsonarray = obj.getJSONArray("resp");
                        while (count < jsonarray.length()) {
                            JSONObject jsonObject = jsonarray.getJSONObject(count);
                            String Note = jsonObject.getString("Note");
                            String Date = jsonObject.getString("Date");
                            String Seen = jsonObject.getString("Seen");
                            String Time = jsonObject.getString("Time");
                            modellist.add(new Modle_Noti(Note,Date,Time,Seen));
                            final LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
                            RecyclerView.LayoutManager rcLayoutManager = layoutmanager;
                            recycler.setLayoutManager(rcLayoutManager);
                            homeAdd = new Adapter_Noti(getActivity(), modellist);
                            recycler.setAdapter(homeAdd);
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
                    params.put("Type",TypeClass);
                    params.put("Kind","اطلاعیه");
                    return params;
                }
            };
            MySingleton.getInstance(getActivity()).addtoRequestQueue(stringrequest);

        }else {
            modellist = new ArrayList<>();
            StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Ur2, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    int count = 0;
                    try {
                        obj = new JSONObject(response);
                        jsonarray = obj.getJSONArray("resp");
                        while (count < jsonarray.length()) {
                            JSONObject jsonObject = jsonarray.getJSONObject(count);
                            String Note = jsonObject.getString("Note");
                            String Date = jsonObject.getString("Date");
                            String Seen = jsonObject.getString("Seen");
                            String Time = jsonObject.getString("Time");
                            modellist.add(new Modle_Noti(Note,Date,Time,Seen));
                            final LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
                            RecyclerView.LayoutManager rcLayoutManager = layoutmanager;
                            recycler.setLayoutManager(rcLayoutManager);
                            homeAdd = new Adapter_Noti(getActivity(), modellist);
                            recycler.setAdapter(homeAdd);
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
                    params.put("Term", TermMe);
                    params.put("Class", ClassMe);
                    params.put("TypeTerm", TypeTerm);
                    params.put("Kind", "اطلاعیه");
                    return params;
                }
            };
            MySingleton.getInstance(getActivity()).addtoRequestQueue(stringrequest);
        }
    }

}
