package com.example.farshid.myproject_robofa.MainPage.Camera.Allimage;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.farshid.myproject_robofa.MainPage.MySingleton;
import com.example.farshid.myproject_robofa.R;
import com.example.farshid.myproject_robofa.Rigster.AdapterShowAllImage;
import com.example.farshid.myproject_robofa.Rigster.ModleShowAllImage;
import com.example.farshid.myproject_robofa.Rigster.ShowAllImage.ShowAllImage;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.github.ybq.android.spinkit.style.ThreeBounce;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by farshid on 12/11/2018.
 */

public class Tab_AllImage extends Fragment {
    View view;
    JSONObject obj;
    JSONArray jsonarray;
    String Server_Ur3 = "http://farshidhabibi.ir/farshid/kivan/ShowAllImageForAdmin.php";
    RecyclerView recyclerView;
    ArrayList<ModeAllImage> modellist;
    AdapterAllimage homeAdd;
    int Count2 = 1;
    RelativeLayout rea;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_allimage, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.tabAllimage_Recycler);
        rea = view.findViewById(R.id.RealiAllarm);
        ProgressBar progressBar = (ProgressBar)view.findViewById(R.id.AllImage_spin_kit);
        ThreeBounce doubleBounce = new ThreeBounce();
        progressBar.setIndeterminateDrawable(doubleBounce);
        Receve();
        if (Count2 == 0) {
            rea.setVisibility(View.VISIBLE);
        }else {
            rea.setVisibility(View.GONE);
        }
        return view;

    }

    private void Receve() {
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
                        Count2 = 0;
                        JSONObject jsonObject = jsonarray.getJSONObject(count);
                        String Topic = jsonObject.getString("Topic");
                        String Image = jsonObject.getString("Image");
                        String Image2 = jsonObject.getString("Image2");
                        String Date = jsonObject.getString("Date");
                        String Time = jsonObject.getString("Time");
                        String Seen = jsonObject.getString("Seen");
                        String Id = jsonObject.getString("Id");
                        String SendBy = jsonObject.getString("SendBy");
                        modellist.add(new ModeAllImage(Topic, Image, Id, Seen, Date, Time, Image2,SendBy));
                        final LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
                        RecyclerView.LayoutManager rcLayoutManager = layoutmanager;
                        recyclerView.setLayoutManager(rcLayoutManager);
                        homeAdd = new AdapterAllimage(getActivity(), modellist);
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
                params.put("Kind", "TabAll");
                return params;
            }
        };
        MySingleton.getInstance(getActivity()).addtoRequestQueue(stringrequest);


    }
}
