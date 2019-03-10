package com.example.farshid.myproject_robofa.MainPage.Channel.Adult;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.farshid.myproject_robofa.MainPage.Channel.MYChildren.Adapter;
import com.example.farshid.myproject_robofa.MainPage.Channel.MYChildren.Modle;
import com.example.farshid.myproject_robofa.MainPage.MySingleton;
import com.example.farshid.myproject_robofa.R;
import com.github.ybq.android.spinkit.style.FoldingCube;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Channel_Adult extends AppCompatActivity {
    String Server_Ur2 = "http://farshidhabibi.ir/farshid/kivan/ReceiveChannel.php";
    JSONObject obj;
    JSONArray jsonarray;
    RecyclerView recycler;
    ArrayList<Modle_Adult> modellist;
    Adapter_Adult homeAdd;
    ProgressDialog progressDialog;
    CoordinatorLayout coordinatorLayout;
    ProgressBar progressBar;
    private int time_interval = 2000;
    private long oldCurrentTimeMillis;
    int Count = 0;
    Toolbar toolbar;
    String Class = "";
    String TermMe = "", ClassMe = "", TypeTerm = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel__adult);
        Initialize();
        LoadPage();
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

    private void onload() {
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.CoordinateNotechannelAdult);
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
        progressBar = (ProgressBar) findViewById(R.id.spin_kit_channelAdult);
        recycler = (RecyclerView) findViewById(R.id.RecyclerView_channelAdult);
        FoldingCube cubeGrid = new FoldingCube();
        progressBar.setIndeterminateDrawable(cubeGrid);
    }
    private void ForRecyclerView() {
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
                        String Note = jsonObject.getString("Note").trim();
                        modellist.add(new Modle_Adult(Note));
                        final LinearLayoutManager layoutmanager = new LinearLayoutManager(Channel_Adult.this);
                        RecyclerView.LayoutManager rcLayoutManager = layoutmanager;
                        recycler.setLayoutManager(rcLayoutManager);
                        homeAdd = new Adapter_Adult(Channel_Adult.this, modellist);
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
//
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("TypeChannel","روانشناسی بزرگسال");
                return params;
            }
        };
        MySingleton.getInstance(Channel_Adult.this).addtoRequestQueue(stringrequest);

    }
}
