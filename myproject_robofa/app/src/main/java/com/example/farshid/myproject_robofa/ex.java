package com.example.farshid.myproject_robofa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.farshid.myproject_robofa.DataBase.DatabaseHelper;
import com.example.farshid.myproject_robofa.MainPage.Channel.Adult.Adapter_Adult;
import com.example.farshid.myproject_robofa.MainPage.Channel.Adult.Modle_Adult;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.Note.Adapter_Note;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.Note.Mode_Note;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.Note.Note;
import com.example.farshid.myproject_robofa.MainPage.MySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ex extends AppCompatActivity {
    String Server_Ur2 = "http://farshidhabibi.ir/farshid/kivan/ReceiveChannel.php";
    EditText ET, EC, EN;
    TextView textView;

    JSONObject obj;
    JSONArray jsonarray;
    RecyclerView recycler;
    ArrayList<Modle_Adult> modellist;
    Adapter_Adult homeAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex);
        ET = (EditText) findViewById(R.id.Term);
        EC = (EditText) findViewById(R.id.Class);
        EN = (EditText) findViewById(R.id.Note);
        textView= (TextView) findViewById(R.id.textok2);

        Button ok = (Button) findViewById(R.id.ok);
        Button ok2 = (Button) findViewById(R.id.ok2);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                                DatabaseHelper databaseHelper = new DatabaseHelper(ex.this);
//                                databaseHelper.insertData(Note);
//                                modellist.add(new Modle_Adult(Note));
//                                final LinearLayoutManager layoutmanager = new LinearLayoutManager(ex.this);
//                                RecyclerView.LayoutManager rcLayoutManager = layoutmanager;
//                                recycler.setLayoutManager(rcLayoutManager);
//                                homeAdd = new Adapter_Adult(ex.this, modellist);
//                                recycler.setAdapter(homeAdd);
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
                        params.put("TypeChannel", "روانشناسی بزرگسال");
                        return params;
                    }
                };
                MySingleton.getInstance(ex.this).addtoRequestQueue(stringrequest);

            }
        });
        ok2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper databaseHelper = new DatabaseHelper(ex.this);
                databaseHelper.getAllData();
//                textView.setText(databaseHelper.getAllData());
            }
        });


    }
}
