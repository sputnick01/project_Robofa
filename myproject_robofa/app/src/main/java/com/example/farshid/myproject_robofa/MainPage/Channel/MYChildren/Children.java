package com.example.farshid.myproject_robofa.MainPage.Channel.MYChildren;

import android.app.ProgressDialog;
import android.content.Context;
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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.farshid.myproject_robofa.DataBase.Child.ChildModle;
import com.example.farshid.myproject_robofa.DataBase.Child.RecyclerViewChild;
import com.example.farshid.myproject_robofa.DataBase.DataBaseModle;
import com.example.farshid.myproject_robofa.DataBase.DatabaseHelper;
import com.example.farshid.myproject_robofa.DataBase.RecyclerAdapter;
import com.example.farshid.myproject_robofa.MainPage.MySingleton;
import com.example.farshid.myproject_robofa.R;
import com.github.ybq.android.spinkit.style.FoldingCube;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by farshid on 11/15/2018.
 */

public class Children extends Fragment {
    View view;
    String Server_Ur2 = "http://farshidhabibi.ir/farshid/kivan/ReceiveChannel.php";
    JSONObject obj;
    JSONArray jsonarray;
    RecyclerView recycler;
    ArrayList<Modle> modellist;
    Adapter homeAdd;
    ProgressDialog progressDialog;
    CoordinatorLayout coordinatorLayout;
    ProgressBar progressBar;
    private int time_interval = 2000;
    private long oldCurrentTimeMillis;
    int Count = 0;
    Toolbar toolbar;
    String Class = "";
    String TermMe = "", ClassMe = "", TypeTerm = "";



    DatabaseHelper helpher;
    List<ChildModle> dbList;
    RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.children, container, false);
        Initialize();
        ForRecyclerView();
        return view;
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
        coordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.CoordinateNoteChannle);
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
        progressBar = (ProgressBar) view.findViewById(R.id.spin_kit_channle);
//        recycler = (RecyclerView) view.findViewById(R.id.RecyclerView_Child);
        FoldingCube cubeGrid = new FoldingCube();
        progressBar.setIndeterminateDrawable(cubeGrid);
    }
    private void ForRecyclerView() {

        helpher = new DatabaseHelper(getActivity());
        dbList= new ArrayList<ChildModle>();
        dbList = helpher.getDataFromDBChild();
        mRecyclerView = (RecyclerView)view.findViewById(R.id.RecyclerView_Child);
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        mAdapter = new RecyclerViewChild(getActivity(),dbList);
        mRecyclerView.setAdapter(mAdapter);
//        StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Ur2, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                int count = 0;
//                try {
//                    obj = new JSONObject(response);
//                    jsonarray = obj.getJSONArray("resp");
//                    while (count < jsonarray.length()) {
//                        JSONObject jsonObject = jsonarray.getJSONObject(count);
//                        String Note = jsonObject.getString("Note");
////                        String MYType = jsonObject.getString("TypeChannel");
////                        DatabaseHelper databaseHelper=new DatabaseHelper(getActivity());
////                        databaseHelper.insertData(Note,MYType);
//                        modellist.add(new ModleSearchStudent(Note));
//                        final LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
//                        RecyclerView.LayoutManager rcLayoutManager = layoutmanager;
//                        recycler.setLayoutManager(rcLayoutManager);
//                        homeAdd = new Adapter(getActivity(), modellist);
//                        recycler.setAdapter(homeAdd);
//                        count++;
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
////
//            }
//        }
//        ) {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("TypeChannel","روانشناسی کودک");
//                return params;
//            }
//        };
//        MySingleton.getInstance(getActivity()).addtoRequestQueue(stringrequest);

    }
}
