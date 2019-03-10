package com.example.farshid.myproject_robofa.Teacher.ShowAllForTeacher;

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
import com.example.farshid.myproject_robofa.MainPage.MySingleton;
import com.example.farshid.myproject_robofa.R;
import com.github.ybq.android.spinkit.style.FoldingCube;
import com.github.ybq.android.spinkit.style.ThreeBounce;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by farshid on 11/23/2018.
 */

public class Tab_ShowAllForTeacher extends Fragment {
    View view;
    CoordinatorLayout coordinatorLayout;
    ProgressBar progressBar;
    String Server_Ur22="http://farshidhabibi.ir/farshid/kivan/Receive_noteSchool.php",Server_Ur223="http://farshidhabibi.ir/farshid/kivan/Receive_AllFor.php";

    JSONObject obj2;
    JSONArray jsonarray2;
    ArrayList<Modle_ShowAllForTeacher> modellist2;

    RecyclerView recycler;
    Recycler_ShowAllForTeacher homeAdd;
    String UserName = "", Password = "", KindUser = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.showallforteacher, container, false);
        Initialize();

        Give_info_From_File();
        Insertdata();
        return view;
    }

    private void Give_info_From_File() {
//        SharedPreferences pref3 = getActivity().getApplicationContext().getSharedPreferences("ShowAll", 0); // 0 - for private mode
//        UserName = pref3.getString("key_PhoneNumber", "");
//        Password = pref3.getString("key_Password", "");
        SharedPreferences pref3 = getActivity().getApplicationContext().getSharedPreferences("User", 0); // 0 - for private mode
        UserName = pref3.getString("UserName", "");
        Password = pref3.getString("Password", "");
        KindUser = pref3.getString("KindUser", "");

    }

    private void LoadPage() {
        if (hasInternetConnection()) {
            progressBar.setVisibility(View.VISIBLE);
            new Thread(new Runnable() {
                public void run() {
                    try {
                        ForRecyclerView();
                        Thread.sleep(4000);
                        progressBar.setVisibility(View.GONE);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } else {
            onload();
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

    private void onload() {
        coordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.ShowAllForTeacher_CoordinateNoteChannle);
        Snackbar snackbar = Snackbar.make(coordinatorLayout, "اینترنت در دسترس نیست!",
                Snackbar.LENGTH_INDEFINITE).setActionTextColor(Color.RED).setAction("بررسی", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadPage();
            }
        });
        View view = snackbar.getView();
        TextView textView = view.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();

    }


    private void Initialize() {
        recycler = (RecyclerView) view.findViewById(R.id.RecyclerView_ShowAllForTeacher);
        ProgressBar progressBar = (ProgressBar)view.findViewById(R.id.showallforteacher_spin_kit);
        ThreeBounce doubleBounce = new ThreeBounce();
        progressBar.setIndeterminateDrawable(doubleBounce);
    }

    private void ForRecyclerView() {

    }

    private void Insertdata() {

            if (KindUser.toString().equals("معلم")) {
                SendInfoServer1();
            } else if (KindUser.toString().equals("استاد موسسه")) {
                SendInfoServer2();
            }



    }

    private void SendInfoServer2() {

        modellist2 = new ArrayList<>();
        StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Ur223, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int count = 0;
                try {
                    obj2 = new JSONObject(response);
                    jsonarray2 = obj2.getJSONArray("resp");
                    while (count < jsonarray2.length()) {
                        JSONObject jsonObject = jsonarray2.getJSONObject(count);
                        String Note = jsonObject.getString("Note");
                        String Date = jsonObject.getString("Date");
                        String Time = jsonObject.getString("Time");
                        String Seen = jsonObject.getString("Seen");
                        String Id = jsonObject.getString("Id");
//                        DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
//                        databaseHelper.insertDataShowAll(Note, Date, Time, Seen);
                        modellist2.add(new Modle_ShowAllForTeacher(Note, Date, Time, Seen, Id));
                        final LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
                        RecyclerView.LayoutManager rcLayoutManager = layoutmanager;
                        recycler.setLayoutManager(rcLayoutManager);
                        homeAdd = new Recycler_ShowAllForTeacher(getActivity(), modellist2);
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
                params.put("EDPhoneNumber", UserName);
                params.put("EDMaliKey", Password);
                return params;
            }
        };
        MySingleton.getInstance(getActivity()).addtoRequestQueue(stringrequest);

    }

    private void SendInfoServer1() {

        modellist2 = new ArrayList<>();
        StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Ur22, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int count = 0;
                try {
                    obj2 = new JSONObject(response);
                    jsonarray2 = obj2.getJSONArray("resp");
                    while (count < jsonarray2.length()) {
                        JSONObject jsonObject = jsonarray2.getJSONObject(count);
                        String Note = jsonObject.getString("Note");
                        String Date = jsonObject.getString("Date");
                        String Time = jsonObject.getString("Time");
                        String Seen = jsonObject.getString("Seen");
                        String Id = jsonObject.getString("Id");
//                        DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
//                        databaseHelper.insertDataShowAll(Note, Date, Time, Seen);
                        modellist2.add(new Modle_ShowAllForTeacher(Note, Date, Time, Seen, Id));
                        final LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
                        RecyclerView.LayoutManager rcLayoutManager = layoutmanager;
                        recycler.setLayoutManager(rcLayoutManager);
                        homeAdd = new Recycler_ShowAllForTeacher(getActivity(), modellist2);
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
                params.put("EDPhoneNumber", UserName);
                params.put("EDMaliKey", Password);
                return params;
            }
        };
        MySingleton.getInstance(getActivity()).addtoRequestQueue(stringrequest);
    }


}
