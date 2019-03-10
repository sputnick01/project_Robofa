package com.example.farshid.myproject_robofa.Rigster.ShowAllImage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.farshid.myproject_robofa.MainPage.MySingleton;
import com.example.farshid.myproject_robofa.R;
import com.example.farshid.myproject_robofa.Rigster.AdapterShowAllImage;
import com.example.farshid.myproject_robofa.Rigster.ModleShowAllImage;
import com.example.farshid.myproject_robofa.Teacher.SearchStudent.AdapterSearchStudent;
import com.example.farshid.myproject_robofa.Teacher.SearchStudent.ListStudent;
import com.example.farshid.myproject_robofa.Teacher.SearchStudent.ModleSearchStudent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShowAllImage extends AppCompatActivity {
    JSONObject obj;
    JSONArray jsonarray;
    String Server_Ur3 = "http://farshidhabibi.ir/farshid/kivan/ShowAllImageForAdmin.php";
    RecyclerView recyclerView;
    ArrayList<ModleShowAllImage> modellist;
    AdapterShowAllImage homeAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_image);
        recyclerView= (RecyclerView) findViewById(R.id.Recycler_ShowAllImge);
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
                        String Topic = jsonObject.getString("Topic");
                        String Image = jsonObject.getString("Image");
                        String Image2 = jsonObject.getString("Image2");
                        String Date = jsonObject.getString("Date");
                        String Time = jsonObject.getString("Time");
                        String Seen = jsonObject.getString("Seen");
                        String SendBy = jsonObject.getString("SendBy");
                        String Id = jsonObject.getString("Id");
                        modellist.add(new ModleShowAllImage(Topic, Image, Id, Seen, Date,Time,Image2,SendBy));
                        final LinearLayoutManager layoutmanager = new LinearLayoutManager(ShowAllImage.this);
                        RecyclerView.LayoutManager rcLayoutManager = layoutmanager;
                        recyclerView.setLayoutManager(rcLayoutManager);
                        homeAdd = new AdapterShowAllImage(ShowAllImage.this, modellist);
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
                return params;
            }
        };
        MySingleton.getInstance(ShowAllImage.this).addtoRequestQueue(stringrequest);
    }
}
