package com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.YourRating;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.dd.CircularProgressButton;
import com.example.farshid.myproject_robofa.MainPage.MySingleton;
import com.example.farshid.myproject_robofa.R;
import com.example.farshid.myproject_robofa.Teacher.SearchStudent.ShowInformationStudent;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.weiwangcn.betterspinner.library.BetterSpinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class YourRating extends AppCompatActivity {
    String Id;
    int Week1 = 1, Week2 = 2, Week3 = 3, Week4 = 4, Week5 = 5, Week6 = 6, Week7 = 7, Week8 = 8, Week9 = 9, Week10 = 10, Week11 = 11, Week12 = 12, Week13 = 13, Week14 = 14, Week15 = 15, Week16 = 16, Week17 = 17, Week18 = 18, Week19 = 19, Week20 = 20;
    int Weekk1 = 0, Weekk2 = 0, Weekk3 = 0, Weekk4 = 0, Weekk5 = 0, Weekk6 = 0, Weekk7 = 0, Weekk8 = 0, Weekk9 = 0, Weekk10 = 0, Weekk11 = 0, Weekk12 = 0, Weekk13 = 0, Weekk14 = 0, Weekk15 = 0, Weekk16 = 0, Weekk17 = 0, Weekk18 = 0, Weekk19 = 0, Weekk20 = 0;

    TextView Name, LastName, Term, Field, TypeTerm, TotalRating, PhoneNumber, NationalCode;
    CircularImageView Image;


    TextView T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15;
    TextView T211, T22, T33, T44, T55, T66, T77, T88, T99, T1010, T1111, T1212, T1313, T1414, T1515;
    BetterSpinner SpinnerWeek, SpinnerScore;

    CircularProgressButton circularProgressButton;
    EditText EditWeekRating, EditTotalRating;
    int TotalCount=0;


    String Server_Ur22 = "http://farshidhabibi.ir/farshid/kivan/YourRating.php";
    JSONObject obj;
    JSONArray jsonarray;
    JSONObject objBuy;
    boolean Trust = false;
    JSONArray jsonarrayBuy;
    int Count = 0;
    String Nation = "", Phone = "";
    String BunTerm = "", BunField = "", BunUserName = "", BunPassword = "";
    TextView tv ,Text1,Text2,Text3,Text4,Text5,Text6,Text7,Text8,Text9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_rating);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            BunTerm = extras.getString("Term");
        }
        SharedPreferences pref3 = getApplicationContext().getSharedPreferences("UserPass", 0); // 0 - for private mode
        BunUserName = pref3.getString("Username", "");
        BunPassword = pref3.getString("Password", "");
        BunField = pref3.getString("Class", "");

        Initialize();
        tv= (TextView)findViewById(R.id.texView5);
//-- the below line is returning null

        Animation animation;
        animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.textview);
        tv.startAnimation(animation);
        SetFont();
        GiveInfo();
    }

    private boolean Trust() {
        Trust = true;
        if (SpinnerWeek.getText().toString().equals("هفته") || SpinnerScore.getText().toString().equals("نمره")) {
            Trust = false;
        }
        return Trust;

    }

    private void SetFont() {
        Typeface tf = Typeface.createFromAsset(getAssets(), "font/irsans.ttf");
        Name.setTypeface(tf);
        LastName.setTypeface(tf);
        Term.setTypeface(tf);
        Field.setTypeface(tf);
        TypeTerm.setTypeface(tf);
        TotalRating.setTypeface(tf);
        PhoneNumber.setTypeface(tf);
        NationalCode.setTypeface(tf);


        T1.setTypeface(tf);
        T2.setTypeface(tf);
        T3.setTypeface(tf);
        T4.setTypeface(tf);

        T5.setTypeface(tf);
        T6.setTypeface(tf);
        T7.setTypeface(tf);
        T8.setTypeface(tf);

        T9.setTypeface(tf);
        T10.setTypeface(tf);
        T11.setTypeface(tf);
        T12.setTypeface(tf);

        T13.setTypeface(tf);
        T14.setTypeface(tf);
        T15.setTypeface(tf);
        T11.setTypeface(tf);

        T22.setTypeface(tf);
        T33.setTypeface(tf);
        T44.setTypeface(tf);
        T55.setTypeface(tf);

        T66.setTypeface(tf);
        T77.setTypeface(tf);
        T88.setTypeface(tf);
        T99.setTypeface(tf);

        T1010.setTypeface(tf);
        T1111.setTypeface(tf);
        T1212.setTypeface(tf);
        T1313.setTypeface(tf);

        T1414.setTypeface(tf);
        T1515.setTypeface(tf);




        Text1.setTypeface(tf);
        Text2.setTypeface(tf);
        Text3.setTypeface(tf);
        Text4.setTypeface(tf);

        Text5.setTypeface(tf);
        Text6.setTypeface(tf);
        Text7.setTypeface(tf);
        Text8.setTypeface(tf);

        Text9.setTypeface(tf);


    }

    private void Initialize() {
        Name = (TextView) findViewById(R.id.StudentPage__TetName2);
        LastName = (TextView) findViewById(R.id.StudentPage_TetLastName2);
        Term = (TextView) findViewById(R.id.StudentPage_Base2);
        Field = (TextView) findViewById(R.id.StudentPage_Feild2);
        TypeTerm = (TextView) findViewById(R.id.StudentPage_Class2);
        TotalRating = (TextView) findViewById(R.id.StudentPage_TotalTermRating2);
        Image = (CircularImageView) findViewById(R.id.StudentPage_CircularImageView);
        PhoneNumber = (TextView) findViewById(R.id.StudentPage_PhoneNumber2);
        NationalCode = (TextView) findViewById(R.id.StudentPage_NationalCode2);
        T1 = (TextView) findViewById(R.id.TextWeek11);
        T2 = (TextView) findViewById(R.id.TextWeek22);
        T3 = (TextView) findViewById(R.id.TextWeek33);
        T4 = (TextView) findViewById(R.id.TextWeek44);
        T5 = (TextView) findViewById(R.id.TextWeek55);
        T6 = (TextView) findViewById(R.id.TextWeek66);
        T7 = (TextView) findViewById(R.id.TextWeek77);
        T8 = (TextView) findViewById(R.id.TextWeek88);
        T9 = (TextView) findViewById(R.id.TextWeek99);
        T10 = (TextView) findViewById(R.id.TextWeek1010);
        T11 = (TextView) findViewById(R.id.TextWeek1111);
        T12 = (TextView) findViewById(R.id.TextWeek1212);
        T13 = (TextView) findViewById(R.id.TextWeek1313);
        T14 = (TextView) findViewById(R.id.TextWeek1414);
        T15 = (TextView) findViewById(R.id.TextWeek1515);


        T211 = (TextView) findViewById(R.id.TextWeek1);
        T22 = (TextView) findViewById(R.id.TextWeek2);
        T33 = (TextView) findViewById(R.id.TextWeek3);
        T44 = (TextView) findViewById(R.id.TextWeek4);
        T55 = (TextView) findViewById(R.id.TextWeek5);
        T66 = (TextView) findViewById(R.id.TextWeek6);
        T77 = (TextView) findViewById(R.id.TextWeek7);
        T88 = (TextView) findViewById(R.id.TextWeek8);
        T99 = (TextView) findViewById(R.id.TextWeek9);
        T1010 = (TextView) findViewById(R.id.TextWeek10);
        T1111 = (TextView) findViewById(R.id.TextWeek111);
        T1212 = (TextView) findViewById(R.id.TextWeek12);
        T1313 = (TextView) findViewById(R.id.TextWeek13);
        T1414 = (TextView) findViewById(R.id.TextWeek14);
        T1515 = (TextView) findViewById(R.id.TextWeek15);

        Text1 = (TextView) findViewById(R.id.Tex1);
        Text2 = (TextView) findViewById(R.id.Tex2);
        Text3 = (TextView) findViewById(R.id.Tex3);
        Text4 = (TextView) findViewById(R.id.Tex4);
        Text5 = (TextView) findViewById(R.id.Tex5);
        Text6 = (TextView) findViewById(R.id.Tex6);
        Text7 = (TextView) findViewById(R.id.Tex7);
        Text8 = (TextView) findViewById(R.id.Tex8);
        Text9 = (TextView) findViewById(R.id.texView5);


    }

    private void GiveInfo() {
        StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Ur22, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                progressBar.setVisibility(View.GONE);
                int count = 0;
                try {
                    obj = new JSONObject(response);
                    jsonarray = obj.getJSONArray("resp");
                    while (count < jsonarray.length()) {
                        JSONObject jsonObject = jsonarray.getJSONObject(count);
                        Phone = jsonObject.getString("PhoneNumber");
                        Nation = jsonObject.getString("National_Code");
                        Name.setText(jsonObject.getString("Name"));
                        LastName.setText(jsonObject.getString("LastName"));
                        PhoneNumber.setText(jsonObject.getString("PhoneNumber"));
                        NationalCode.setText(jsonObject.getString("National_Code"));
                        Term.setText(jsonObject.getString("Term"));
                        TypeTerm.setText(jsonObject.getString("TypeTerm"));
                        Field.setText(jsonObject.getString("Field"));

                        TotalRating.setText(jsonObject.getString("TotalRating"));
                        String Image1 = jsonObject.getString("Image");
                        Glide.with(YourRating.this)
                                .load(jsonObject.getString("Image"))
                                .into(Image);



                        Weekk1 = Integer.parseInt(jsonObject.getString("Weekk1")) + 0;
                        Weekk2 = Integer.parseInt(jsonObject.getString("Weekk2")) + 0;
                        Weekk3 = Integer.parseInt(jsonObject.getString("Weekk3")) + 0;
                        Weekk4 = Integer.parseInt(jsonObject.getString("Weekk4")) + 0;
                        Weekk5 = Integer.parseInt(jsonObject.getString("Weekk5")) + 0;
                        Weekk6 = Integer.parseInt(jsonObject.getString("Weekk6")) + 0;
                        Weekk7 = Integer.parseInt(jsonObject.getString("Weekk7")) + 0;
                        Weekk8 = Integer.parseInt(jsonObject.getString("Weekk8")) + 0;
                        Weekk9 = Integer.parseInt(jsonObject.getString("Weekk9")) + 0;
                        Weekk10 = Integer.parseInt(jsonObject.getString("Weekk10")) + 0;
                        Weekk11 = Integer.parseInt(jsonObject.getString("Weekk11")) + 0;
                        Weekk12 = Integer.parseInt(jsonObject.getString("Weekk12")) + 0;
                        Weekk13 = Integer.parseInt(jsonObject.getString("Weekk13")) + 0;
                        Weekk14 = Integer.parseInt(jsonObject.getString("Weekk14")) + 0;
                        Weekk15 = Integer.parseInt(jsonObject.getString("Weekk15")) + 0;
                        IFZero();
                        GraphView graph = (GraphView) findViewById(R.id.StudentPage_graph);
                        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                                new DataPoint(Week1, Weekk1),
                                new DataPoint(Week2, Weekk2),
                                new DataPoint(Week3, Weekk3),
                                new DataPoint(Week4, Weekk4),
                                new DataPoint(Week5, Weekk5),
                                new DataPoint(Week6, Weekk6),
                                new DataPoint(Week7, Weekk7),
                                new DataPoint(Week8, Weekk8),
                                new DataPoint(Week9, Weekk9),
                                new DataPoint(Week10, Weekk10),
                                new DataPoint(Week11, Weekk11),
                                new DataPoint(Week12, Weekk12),
                                new DataPoint(Week13, Weekk13),
                                new DataPoint(Week14, Weekk14),
                                new DataPoint(Week15, Weekk15),

                        });
                        series.setColor(Color.RED);
                        series.setDrawDataPoints(true);
                        series.setDataPointsRadius(15);
                        series.setThickness(10);
                        graph.addSeries(series);
                        graph.setTitleColor(Color.RED);
                        graph.getViewport().setYAxisBoundsManual(true);
                        graph.getViewport().setMinY(0);
                        graph.getViewport().setMaxY(20);
                        graph.getViewport().setXAxisBoundsManual(true);
                        graph.getViewport().setMinX(0);
                        graph.getViewport().setMaxX(TotalCount);
                        graph.getViewport().setScrollable(true);
                        // This works
                        graph.setTitleColor(getResources().getColor(android.R.color.holo_red_dark));
                        if (!jsonObject.getString("R1").isEmpty()) {
                            T1.setText("نفر "+jsonObject.getString("R1")+" ام");
                        } else {
                            T1.setText("---");
                        }
                        if (!jsonObject.getString("R2").isEmpty()) {
                            T2.setText("نفر "+jsonObject.getString("R2")+" ام");
                        } else {
                            T2.setText("---");
                        }
                        if (!jsonObject.getString("R3").isEmpty()) {
                            T3.setText("نفر "+jsonObject.getString("R3")+" ام");
                        } else {
                            T3.setText("---");
                        }
                        if (!jsonObject.getString("R4").isEmpty()) {
                            T4.setText("نفر "+jsonObject.getString("R4")+" ام");
                        } else {
                            T4.setText("---");
                        }
                        if (!jsonObject.getString("R5").isEmpty()) {
                            T5.setText("نفر "+jsonObject.getString("R5")+" ام");
                        } else {
                            T5.setText("---");
                        }
                        if (!jsonObject.getString("R6").isEmpty()) {
                            T6.setText("نفر "+jsonObject.getString("R6")+" ام");
                        } else {
                            T6.setText("---");
                        }
                        if (!jsonObject.getString("R7").isEmpty()) {
                            T7.setText("نفر "+jsonObject.getString("R7")+" ام");
                        } else {
                            T7.setText("---");
                        }
                        if (!jsonObject.getString("R8").isEmpty()) {
                            T8.setText("نفر "+jsonObject.getString("R8")+" ام");
                        } else {
                            T8.setText("---");
                        }
                        if (!jsonObject.getString("R9").isEmpty()) {
                            T9.setText("نفر "+jsonObject.getString("R9")+" ام");
                        } else {
                            T9.setText("---");
                        }
                        if (!jsonObject.getString("R10").isEmpty()) {
                            T10.setText("نفر "+jsonObject.getString("R10")+" ام");
                        } else {
                            T10.setText("---");
                        }
                        if (!jsonObject.getString("R11").isEmpty()) {
                            T11.setText("نفر "+jsonObject.getString("R11")+" ام");
                        } else {
                            T11.setText("---");
                        }
                        if (!jsonObject.getString("R12").isEmpty()) {
                            T12.setText("نفر "+jsonObject.getString("R12")+" ام");
                        } else {
                            T12.setText("---");
                        }

                        if (!jsonObject.getString("R13").isEmpty()) {
                            T13.setText("نفر "+jsonObject.getString("R13")+" ام");
                        } else {
                            T13.setText("---");
                        }

                        if (!jsonObject.getString("R14").isEmpty()) {
                            T14.setText("نفر "+jsonObject.getString("R14")+" ام");
                        } else {
                            T14.setText("---");
                        }

                        if (!jsonObject.getString("R15").isEmpty()) {
                            T15.setText("نفر "+jsonObject.getString("R15")+" ام");
                        } else {
                            T15.setText("---");
                        }


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
                params.put("UserName", BunUserName);
                params.put("Password", BunPassword);
                params.put("Class", BunField);
                params.put("Term",BunTerm);
                return params;
            }
        };
        MySingleton.getInstance(YourRating.this).addtoRequestQueue(stringrequest);

    }

    private void IFZero() {
        if (Weekk1 == 0) {
            Week1 = 0;
        }
        if (Weekk2 == 0) {
            Week2 = 0;
        }
        if (Weekk3 == 0) {
            Week3 = 0;
        }
        if (Weekk4 == 0) {
            Week4 = 0;
        }
        if (Weekk5 == 0) {
            Week5 = 0;
        }
        if (Weekk6 == 0) {
            Week6 = 0;
        }
        if (Weekk7 == 0) {
            Week7 = 0;
        }
        if (Weekk8 == 0) {
            Week8 = 0;
        }
        if (Weekk9 == 0) {
            Week9 = 0;
        }
        if (Weekk10 == 0) {
            Week10 = 0;
        }
        if (Weekk11 == 0) {
            Week11 = 0;
        }
        if (Weekk12 == 0) {
            Week12 = 0;
        }
        if (Weekk13 == 0) {
            Week13 = 0;
        }
        if (Weekk14 == 0) {
            Week14 = 0;
        }
        if (Weekk15 == 0) {
            Week15 = 0;
        }
        if (Weekk16 == 0) {
            Week16 = 0;
        }
        if (Weekk17 == 0) {
            Week17 = 0;
        }
        if (Weekk18 == 0) {
            Week18 = 0;
        }
        if (Weekk19 == 0) {
            Week19 = 0;
        }
        if (Weekk20 == 0) {
            Week20 = 0;
        }
        if (Weekk1 != 0) {
            TotalCount = 1;
        }
        if (Weekk2 != 0) {
            TotalCount = 2;

        }
        if (Weekk3 != 0) {
            TotalCount = 3;

        }
        if (Weekk4 != 0) {
            TotalCount = 4;

        }
        if (Weekk5 != 0) {
            TotalCount = 5;

        }
        if (Weekk6 != 0) {
            TotalCount = 6;

        }
        if (Weekk7 != 0) {
            TotalCount = 7;
        }
        if (Weekk8 != 0) {
            TotalCount = 8;

        }
        if (Weekk9 != 0) {
            TotalCount = 9;

        }
        if (Weekk10 != 0) {
            TotalCount = 10;

        }
        if (Weekk11 != 0) {
            TotalCount = 11;

        }
        if (Weekk12 != 0) {
            TotalCount = 12;

        }
        if (Weekk13 != 0) {
            TotalCount = 13;

        }
        if (Weekk14 != 0) {
            TotalCount = 14;

        }
        if (Weekk15 != 0) {
            TotalCount = 15;

        }


    }
}

