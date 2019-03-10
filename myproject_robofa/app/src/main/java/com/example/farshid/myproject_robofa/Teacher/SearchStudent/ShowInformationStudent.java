package com.example.farshid.myproject_robofa.Teacher.SearchStudent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.dd.CircularProgressButton;
import com.example.farshid.myproject_robofa.Chart.chart;
import com.example.farshid.myproject_robofa.MainPage.MySingleton;
import com.example.farshid.myproject_robofa.R;
import com.example.farshid.myproject_robofa.Rigster.RegisterStudent;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.weiwangcn.betterspinner.library.BetterSpinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ShowInformationStudent extends AppCompatActivity implements View.OnClickListener {
    String Id;
    int Week1 = 1, Week2 = 2, Week3 = 3, Week4 = 4, Week5 = 5, Week6 = 6, Week7 = 7, Week8 = 8, Week9 = 9,
            Week10 = 10, Week11 = 11, Week12 = 12, Week13 = 13, Week14 = 14, Week15 = 15, Week16 = 16, Week17 = 17, Week18 = 18, Week19 = 19, Week20 = 20;
    int Weekk1 = 0, Weekk2 = 0, Weekk3 = 0, Weekk4 = 0, Weekk5 = 0, Weekk6 = 0,
            Weekk7 = 0, Weekk8 = 0, Weekk9 = 0, Weekk10 = 0, Weekk11 = 0, Weekk12 = 0, Weekk13 = 0, Weekk14 = 0,
            Weekk15 = 0, Weekk16 = 0, Weekk17 = 0, Weekk18 = 0, Weekk19 = 0, Weekk20 = 0;
    TextView Name, LastName, Term, Field, TypeTerm, TotalRating, PhoneNumber, NationalCode, Name1, LastName1, Term1, Field1,
            TypeTerm1, TotalRating1, PhoneNumber1, NationalCode1, Base1, Base2, School1, School2, Birth1, Birth2, TextTitle_Show;
    CircularImageView Image;
    BetterSpinner SpinnerWeek, SpinnerScore, ScoreLesson, insert_LessonScore;
    Button circularProgressButton, Search_SecoreLesson, SubmitImage;
    EditText EditWeekRating, EditTotalRating;
    String Server_Ur22 = "http://farshidhabibi.ir/farshid/kivan/SetScore.php";
    String Server_Ur23 = "http://farshidhabibi.ir/farshid/kivan/SetScoreSchool.php";
    String Server_Ur2 = "http://farshidhabibi.ir/farshid/kivan/SelectAllinfo.php";
    String Server_Ur1 = "http://farshidhabibi.ir/farshid/kivan/School_GiveScore.php";
    String Server_UrStudent = "http://farshidhabibi.ir/farshid/kivan/select_info_student.php";
    String Server_UrSelectImage = "http://farshidhabibi.ir/farshid/kivan/EditPhoto.php";
    CardView CardInsertScore;
    JSONObject obj;
    JSONArray jsonarray;
    JSONObject objBuy;
    String KindUserForAccess = "";
    int TotalCount = 0;
    boolean Trust = false;
    String Nation = "", Phone = "", KindUser = "", UserName = "", Password = "", Base = "", Kind = "", UserNameStudent = "", PasswordStudent = "";
    RelativeLayout RelTerm, RelField, RelBase;
    String[] ListLesson;
    LinearLayout LinnearLesson;
    RelativeLayout RelBirth, RelSchool;
    String encodedImage;
    Integer REQUEST_CAMERA = 1;
    Integer SELECT_FILE = 0;
    int Enter = 0;
    String MyKind = "";
    String Score = "",Score2="";

    GraphView graph ;
    int col1, col2, col3, col4, col5, col6, col7, col8;
    int ADD1, ADD2, ADD3, ADD4, ADD5, ADD6, ADD7, ADD8;
    Button TERM1, TERM2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_information_student);
        Initialize();
        GiveData_From_Bandle();
        GiveData_From_File();
        GiveInfo();
        LoadPage();
        InitializeSpinner();
        SetFont();
//        SetGraph();
        Search_SecoreLesson.setOnClickListener(this);
        SubmitImage.setOnClickListener(this);
        Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Kind.equals("Teacher") || Kind.equals("Master")) {
                    SelectImage();
                    SubmitImage.setVisibility(View.VISIBLE);
                }
            }
        });
        circularProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Trust()) {
                    if (KindUser.toString().equals("معلم")) {
                        InsertScoreForSchool();
                    } else if (KindUser.toString().equals("استاد موسسه")) {
                        InsertScore();
                    }
                }
            }
        });
        TERM1.setOnClickListener(this);
        TERM2.setOnClickListener(this);
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

    //    تقییر عکس پروفایل از جانب معلم
    private void SelectImage() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent.createChooser(photoPickerIntent, "Select File"), SELECT_FILE);

    }

    //    برای انتخاب عکس از گالری یا دوربین
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CAMERA) {
                Bundle bundle = imageReturnedIntent.getExtras();
                Bitmap bmp = (Bitmap) bundle.get("data");
                Image.setImageBitmap(bmp);
                byte[] data = getBitmapToByte(bmp, 70);
                encodedImage = Base64.encodeToString(data, Base64.DEFAULT);
            } else if (requestCode == SELECT_FILE) {
                Uri selectedImage = imageReturnedIntent.getData();
                Image.setImageURI(selectedImage);
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                    byte[] data = getBitmapToByte(bitmap, 70);
                    encodedImage = Base64.encodeToString(data, Base64.DEFAULT);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            Enter = 1;
        }


    }

    private byte[] getBitmapToByte(Bitmap bmp, int quality) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, quality, stream);
        return stream.toByteArray();
    }

    private void SetGraph() {
        Week1 = 1;
        Week2 = 2;
        Week3 = 3;
        Week4 = 4;
        Week5 = 5;
        Week6 = 6;
        Week7 = 7;
        Week8 = 8;
        Week9 = 9;
        Week10 = 10;
        Week11 = 11;
        Week12 = 12;
        Week13 = 13;
        Week14 = 14;
        Week15 = 15;
        Weekk1 = 0;
        Weekk2 = 0;
        Weekk3 = 0;
        Weekk4 = 0;
        Weekk5 = 0;
        Weekk6 = 0;
        Weekk7 = 0;
        Weekk8 = 0;
        Weekk9 = 0;
        Weekk10 = 0;
        Weekk11 = 0;
        Weekk12 = 0;
        Weekk13 = 0;
        Weekk14 = 0;
        Weekk15 = 0;
        Weekk16 = 0;
    }

    //    درج نمرات موسسه ها
    private void InsertScore() {
        SetScore();
        StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Ur22, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(ShowInformationStudent.this, "ثبت شد!", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                onload();
                Toast.makeText(ShowInformationStudent.this, "لطفا اینترنت خود را بررسی کنید!", Toast.LENGTH_SHORT).show();

            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Week",SpinnerWeek.getText().toString().trim());
                params.put("Score", Score2);
                params.put("WeekRating", EditWeekRating.getText().toString().trim());
                params.put("TotalRating", EditTotalRating.getText().toString().trim());
                params.put("NationalCode", Nation);
                params.put("PhoneNumber", Phone);
                return params;
            }
        };
        MySingleton.getInstance(ShowInformationStudent.this).addtoRequestQueue(stringrequest);
    }

    //    درج نمرات درس های مدرسه
    private void InsertScoreForSchool() {

        SetScore();
        StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Ur23, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(ShowInformationStudent.this, "ثبت شد!", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ShowInformationStudent.this, "لطفا اینترنت خود را بررسی کنید!", Toast.LENGTH_SHORT).show();
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Lesson", insert_LessonScore.getText().toString().trim());
                params.put("Score", Score2);
                params.put("NationalCode", Nation);
                params.put("Week", Score);
                params.put("PhoneNumber", Phone);
                return params;
            }
        };
        MySingleton.getInstance(ShowInformationStudent.this).addtoRequestQueue(stringrequest);
    }

    private void SetScore() {

        if (SpinnerScore.getText().toString().trim().equals("حذف نمره")) {
            Score2 = "0";

        }else {
            Score2 = SpinnerScore.getText().toString().trim();
        }
        switch (SpinnerWeek.getText().toString().trim()) {
            case "نیمه اول مهر": {
                Score = "1";
                break;
            }
            case "نیمه دوم مهر": {
                Score = "2";
                break;
            }
            case "نیمه اول آبان": {
                Score = "3";
                break;
            }
            case "نیمه دوم آبان": {
                Score = "4";
                break;
            }
            case "نیمه اول آذر": {
                Score = "5";
                break;
            }
            case "نیمه دوم آذر": {
                Score = "6";
                break;
            }
            case "نیمه اول دی": {
                Score = "7";
                break;
            }
            case "نیمه دوم دی": {
                Score = "8";
                break;
            }
            case "نیمه اول بهمن": {
                Score = "9";
                break;
            }

            case "نیمه دوم بهمن": {
                Score = "10";
                break;
            }
            case "نیمه اول اسفند": {
                Score = "11";
                break;
            }

            case "نیمه دوم اسفند": {
                Score = "12";
                break;
            }
            case "نیمه اول فروردین": {
                Score = "13";
                break;
            }

            case "نیمه دوم فروردین": {
                Score = "14";
                break;
            }

            case "نیمه اول اردیبهشت": {
                Score = "15";
                break;
            }
            case "نیمه دوم اردیبهشت": {
                Score = "16";
                break;
            }


        }

    }

    //    مقدار دهی Spinner ها
    private void InitializeSpinner() {
        ListLesson = new String[]{
                "قرآن", "فارسی", "علوم تجربی", "ریاضی", "هنر",
                "هدیه های آسمانی", "املا", "مطالعات اجتماعی", "انشا فارسی", "انظباط"
        };
        String[] Document_Student = new String[]{"حذف نمره", "20", "19"
                , "18", "17", "16", "15", "14", "13", "12", "11 "
                , "10", "9", "8", "7", "6", "5", "4", "3 ", "2", "1"
        };
        String[] Document_Student2 = new String[]{"نیمه اول مهر", "نیمه دوم مهر"
                , "نیمه اول آبان", "نیمه دوم آبان", "نیمه اول آذر", "نیمه دوم آذر", "نیمه اول دی", "نیمه دوم دی", "نیمه اول بهمن", "نیمه دوم بهمن"
                , "نیمه اول اسفند", "نیمه دوم اسفند", "نیمه اول فروردین", "نیمه دوم فروردین", "نیمه اول اردیبهشت", "نیمه دوم اردیبهشت"
        };
        String[] Document_Student22 = new String[]{"1", "2", "3"
                , "4", "5", "6", "7", "8", "9", "10", "11 "
                , "12", "13", "14", "15", "16", "17", "18", "19 ", "20"
        };
        if (KindUser.toString().equals("استاد موسسه")){
            ArrayAdapter<String> adapter_Document_Student = new ArrayAdapter<String>(ShowInformationStudent.this,
                    android.R.layout.simple_dropdown_item_1line, Document_Student22);
            SpinnerWeek.setAdapter(adapter_Document_Student);

        }else {
            ArrayAdapter<String> adapter_Document_Student = new ArrayAdapter<String>(ShowInformationStudent.this,
                    android.R.layout.simple_dropdown_item_1line, Document_Student2);
            SpinnerWeek.setAdapter(adapter_Document_Student);

        }

        ArrayAdapter<String> adapter_Document_Teacher = new ArrayAdapter<String>(ShowInformationStudent.this,
                android.R.layout.simple_dropdown_item_1line, Document_Student);
        SpinnerScore.setAdapter(adapter_Document_Teacher);

        String[] MyBase = new String[]{"اول", "دوم"
                , "سوم", "چهارم", "پنجم", "ششم"
        };
        ArrayAdapter<String> Base1 = new ArrayAdapter<String>(ShowInformationStudent.this,
                android.R.layout.simple_dropdown_item_1line, ListLesson);
        ScoreLesson.setAdapter(Base1);
        ArrayAdapter<String> Base2 = new ArrayAdapter<String>(ShowInformationStudent.this,
                android.R.layout.simple_dropdown_item_1line, ListLesson);
        insert_LessonScore.setAdapter(Base2);

    }

    //    گرفتن اطلاعات از فایل
    private void GiveData_From_File() {
        SharedPreferences pref3 = getApplicationContext().getSharedPreferences("User", 0); // 0 - for private mode
        KindUser = pref3.getString("KindUser", "");
        UserName = pref3.getString("UserName", "");
        Password = pref3.getString("Password", "");

    }

    //    گرفتن اطلاعات از صفحه ی دیگر
    private void GiveData_From_Bandle() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Id = extras.getString("Id");
            Kind = extras.getString("Kind");
            UserNameStudent = extras.getString("UserName");
            PasswordStudent = extras.getString("Password");
            KindUserForAccess = extras.getString("MyUser");
        }
        if (Kind.equals("Teacher")) {
//            CardInsertScore.setVisibility(View.GONE);
            SharedPreferences pref3 = getApplicationContext().getSharedPreferences("UserBase", 0); // 0 - for private mode
            UserNameStudent = pref3.getString("UserName1", "");
            PasswordStudent = pref3.getString("Password1", "");
            RelTerm.setVisibility(View.GONE);
            RelField.setVisibility(View.GONE);
            GiveInfoStudent();
        } else if (Kind.equals("Master")) {
            LinnearLesson.setVisibility(View.GONE);
            RelBirth.setVisibility(View.GONE);
            RelSchool.setVisibility(View.GONE);
            RelBase.setVisibility(View.GONE);
        } else if (Kind.equals("School")) {
            CardInsertScore.setVisibility(View.GONE);
            RelTerm.setVisibility(View.GONE);
            RelField.setVisibility(View.GONE);
            GiveInfoStudent();
        }
    }

    private void GiveScoreLesson() {

        SetGraph();
        StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Ur1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                progressBar.setVisibility(View.GONE);
                int count = 0;
                try {
                    obj = new JSONObject(response);
                    jsonarray = obj.getJSONArray("resp");
                    while (count < jsonarray.length()) {
                        JSONObject jsonObject = jsonarray.getJSONObject(count);
                        Weekk1 = Integer.parseInt(jsonObject.getString("Weekk1"));
                        Weekk2 = Integer.parseInt(jsonObject.getString("Weekk2"));
                        Weekk3 = Integer.parseInt(jsonObject.getString("Weekk3"));
                        Weekk4 = Integer.parseInt(jsonObject.getString("Weekk4"));
                        Weekk5 = Integer.parseInt(jsonObject.getString("Weekk5"));
                        Weekk6 = Integer.parseInt(jsonObject.getString("Weekk6"));
                        Weekk7 = Integer.parseInt(jsonObject.getString("Weekk7"));
                        Weekk8 = Integer.parseInt(jsonObject.getString("Weekk8"));
                        Weekk9 = Integer.parseInt(jsonObject.getString("Weekk9"));
                        Weekk10 = Integer.parseInt(jsonObject.getString("Weekk10"));
                        Weekk11 = Integer.parseInt(jsonObject.getString("Weekk11"));
                        Weekk12 = Integer.parseInt(jsonObject.getString("Weekk12"));
                        Weekk13 = Integer.parseInt(jsonObject.getString("Weekk13"));
                        Weekk14 = Integer.parseInt(jsonObject.getString("Weekk14"));
                        Weekk15 = Integer.parseInt(jsonObject.getString("Weekk15"));
                        Weekk16 = Integer.parseInt(jsonObject.getString("Weekk16"));

//                        IFZero();
                        TERM1.setVisibility(View.VISIBLE);
                        TERM2.setVisibility(View.VISIBLE);

//                        System.exit(0);
//                        finish();


//                        IFZero();
//
//                        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
//                                new DataPoint(Week1, Weekk1),
//                                new DataPoint(Week2, Weekk2),
//                                new DataPoint(Week3, Weekk3),
//                                new DataPoint(Week4, Weekk4),
//                                new DataPoint(Week5, Weekk5),
//                                new DataPoint(Week6, Weekk6),
//                                new DataPoint(Week7, Weekk7),
//                                new DataPoint(Week8, Weekk8),
//                                new DataPoint(Week9, Weekk9),
//                                new DataPoint(Week10, Weekk10),
//                                new DataPoint(Week11, Weekk11),
//                                new DataPoint(Week12, Weekk12),
//                                new DataPoint(Week13, Weekk13),
//                                new DataPoint(Week14, Weekk14),
//                                new DataPoint(Week15, Weekk15),
//                        });
//                        series.setColor(Color.RED);
//                        series.setDrawDataPoints(true);
//                        series.setDataPointsRadius(15);
//                        series.setThickness(12);
//                        graph.removeAllSeries();
//                        graph.getGraphContentLeft();
//                        graph.addSeries(series);
//                        graph.setTitleColor(Color.GREEN);
//                        graph.getViewport().setYAxisBoundsManual(true);
//                        graph.getViewport().setMinY(0);
//                        graph.getViewport().setMaxY(20);
//                        graph.getViewport().setXAxisBoundsManual(true);
//                        graph.getViewport().setMinX(0);
//                        graph.getViewport().setMaxX(TotalCount);
//                        graph.getViewport().setScrollable(true);
//                        // This works
//                        graph.setTitleColor(getResources().getColor(android.R.color.holo_red_dark));
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
                Toast.makeText(ShowInformationStudent.this, "دسترسی به اینترنت خود را برسی کنید ! ", Toast.LENGTH_SHORT).show();

            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("NationalCode", NationalCode.getText().toString());
                params.put("PhoneNumber", PhoneNumber.getText().toString());
                params.put("Lesson", ScoreLesson.getText().toString().trim());
                return params;
            }
        };
        MySingleton.getInstance(ShowInformationStudent.this).addtoRequestQueue(stringrequest);
    }

    //     برای دانش اموزانگرفتن اطلاعات برای
    private void GiveInfoStudent() {
        StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_UrStudent, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                progressBar.setVisibility(View.GONE);
                int count = 0;
                try {
                    obj = new JSONObject(response);
                    jsonarray = obj.getJSONArray("resp");
                    while (count < jsonarray.length()) {
                        JSONObject jsonObject = jsonarray.getJSONObject(count);
                        Nation = jsonObject.getString("NationalCode");
                        Phone = jsonObject.getString("PhoneNumber");
                        Base = jsonObject.getString("Document");
                        Name.setText(jsonObject.getString("Name"));
                        LastName.setText(jsonObject.getString("LastName"));
                        PhoneNumber.setText(jsonObject.getString("PhoneNumber"));
                        NationalCode.setText(jsonObject.getString("NationalCode"));
                        TypeTerm.setText(jsonObject.getString("KindClass"));
                        Birth2.setText(jsonObject.getString("Birth"));
                        Base2.setText(jsonObject.getString("Document"));
                        School2.setText(jsonObject.getString("School"));
                        String Image1 = jsonObject.getString("Image");
                        Glide.with(ShowInformationStudent.this)
                                .load(jsonObject.getString("Image"))
                                .into(Image);

                        // This works
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
                params.put("UserName", UserNameStudent);
                params.put("Password", PasswordStudent);

                return params;
            }
        };
        MySingleton.getInstance(ShowInformationStudent.this).addtoRequestQueue(stringrequest);
    }

    //    برای تست اینکه مقادیر را وارد کنیم
    private boolean Trust() {
        Trust = true;
        if (SpinnerWeek.getText().toString().equals("هفته") || SpinnerScore.getText().toString().equals("نمره")) {
            Trust = false;
        }
        return Trust;

    }

    //ست کردن فونت
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
        SpinnerWeek.setTypeface(tf);
        SpinnerScore.setTypeface(tf);
        Name1.setTypeface(tf);
        LastName1.setTypeface(tf);
        Term1.setTypeface(tf);
        Field1.setTypeface(tf);
        TypeTerm1.setTypeface(tf);
        PhoneNumber1.setTypeface(tf);
        NationalCode1.setTypeface(tf);
        Base2.setTypeface(tf);
        Base1.setTypeface(tf);
        School1.setTypeface(tf);
        School2.setTypeface(tf);
        Birth1.setTypeface(tf);
        Birth2.setTypeface(tf);
        ScoreLesson.setTypeface(tf);
        Search_SecoreLesson.setTypeface(tf);
        insert_LessonScore.setTypeface(tf);
        TextTitle_Show.setTypeface(tf);

        SubmitImage.setTypeface(tf);
    }

    //انتخاب ایکون های مورد  نیاز
    private void LoadPage() {
        if (KindUser.toString().equals("معلم")) {
            RelField.setVisibility(View.GONE);
            RelTerm.setVisibility(View.GONE);
            EditWeekRating.setVisibility(View.GONE);
            EditTotalRating.setVisibility(View.GONE);

        } else if (KindUser.toString().equals("استاد موسسه")) {
            RelBase.setVisibility(View.GONE);
            insert_LessonScore.setVisibility(View.GONE);

        }

    }

    //مقداردهی مقادر
    private void Initialize() {
        Name = (TextView) findViewById(R.id.RecyclerView_ShowInformation__TetName2);
        LastName = (TextView) findViewById(R.id.RecyclerView_ShowInformation_TetLastName2);
        Term = (TextView) findViewById(R.id.RecyclerView_ShowInformation_Base2);
        Field = (TextView) findViewById(R.id.RecyclerView_ShowInformation_Feild2);
        TypeTerm = (TextView) findViewById(R.id.RecyclerView_ShowInformation_Class2);
        TotalRating = (TextView) findViewById(R.id.RecyclerView_ShowInformation_TotalTermRating2);
        Image = (CircularImageView) findViewById(R.id.RecyclerView_ShowInformation_CircularImageView);
        PhoneNumber = (TextView) findViewById(R.id.RecyclerView_ShowInformation_PhoneNumber2);
        NationalCode = (TextView) findViewById(R.id.RecyclerView_ShowInformation_NationalCode2);


        Name1 = (TextView) findViewById(R.id.RecyclerView_ShowInformation_TextName1);
        LastName1 = (TextView) findViewById(R.id.RecyclerView_ShowInformation_TetLastName1);
        Term1 = (TextView) findViewById(R.id.RecyclerView_ShowInformation_Base1);
        Field1 = (TextView) findViewById(R.id.RecyclerView_ShowInformation_Feild1);
        TypeTerm1 = (TextView) findViewById(R.id.RecyclerView_ShowInformation_Class1);
        PhoneNumber1 = (TextView) findViewById(R.id.RecyclerView_ShowInformation_PhoneNumber1);
        NationalCode1 = (TextView) findViewById(R.id.RecyclerView_ShowInformation_NationalCode1);

        SpinnerWeek = (BetterSpinner) findViewById(R.id.Week);
        SpinnerScore = (BetterSpinner) findViewById(R.id.Score);
        circularProgressButton = (Button) findViewById(R.id.Scoreok);
        EditWeekRating = (EditText) findViewById(R.id.EditWeekRating);
        EditTotalRating = (EditText) findViewById(R.id.EditTotalRating);
        Base2 = (TextView) findViewById(R.id.RecyclerView_ShowInformation_SchoolBase2);
        Base1 = (TextView) findViewById(R.id.RecyclerView_ShowInformation_SchoolBase1);
        School1 = (TextView) findViewById(R.id.RecyclerView_ShowInformation_School1);
        School2 = (TextView) findViewById(R.id.RecyclerView_ShowInformation_School2);
        Birth1 = (TextView) findViewById(R.id.RecyclerView_ShowInformation_Birth1);
        Birth2 = (TextView) findViewById(R.id.RecyclerView_ShowInformation_Birth2);
        RelSchool = (RelativeLayout) findViewById(R.id.RelSchool);

        RelField = (RelativeLayout) findViewById(R.id.RelField);
        RelBase = (RelativeLayout) findViewById(R.id.RelBase);
        RelTerm = (RelativeLayout) findViewById(R.id.RelTerm);
        RelBirth = (RelativeLayout) findViewById(R.id.RelBirth);
        ScoreLesson = (BetterSpinner) findViewById(R.id.ScoreLesson);

        Search_SecoreLesson = (Button) findViewById(R.id.Search_SecoreLesson);
        insert_LessonScore = (BetterSpinner) findViewById(R.id.insert_LessonScore);

        TextTitle_Show = (TextView) findViewById(R.id.TextTitle_Show);
        CardInsertScore = (CardView) findViewById(R.id.CardInsertScore);
        LinnearLesson = (LinearLayout) findViewById(R.id.LinnearLesson);
        SubmitImage = (Button) findViewById(R.id.SubmitImage);
        TERM1 = findViewById(R.id.Score1);
        TERM2 = findViewById(R.id.Score2);
        TERM1.setVisibility(View.GONE);
        TERM2.setVisibility(View.GONE);
        graph= (GraphView) findViewById(R.id.RecyclerView_ShowInformation_graph);

    }

    //           انتخاب اینکه اطلاعات مربوط به کدام بخش را از سرور بگیریم
    private void GiveInfo() {
        if (KindUser.toString().equals("معلم")) {
            MyKind = "School";
            graph.setVisibility(View.GONE);
            SendInfoServer1();

        } else if (KindUser.toString().equals("استاد موسسه")) {
            MyKind = "NoSchool";
            SendInfoServer2();
        }


    }

    //    گرفتن اطلاعات از سرور برای بخش موسسه
    private void SendInfoServer2() {
//        SetGraph();
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
//                        Toast.makeText(ShowInformationStudent.this, ""+Ima, Toast.LENGTH_SHORT).show();
                        Glide.with(getApplicationContext())
                                .load(jsonObject.getString("Image").toString().trim()).error(R.drawable.avatar)
                                .into(Image);
//                        Bitmap b=StringToBitMap(Image1);
//                        Image.setImageBitmap(b);
                        Weekk1 = Integer.parseInt(jsonObject.getString("Weekk1"));
                        Weekk2 = Integer.parseInt(jsonObject.getString("Weekk2"));
                        Weekk3 = Integer.parseInt(jsonObject.getString("Weekk3"));
                        Weekk4 = Integer.parseInt(jsonObject.getString("Weekk4"));
                        Weekk5 = Integer.parseInt(jsonObject.getString("Weekk5"));
                        Weekk6 = Integer.parseInt(jsonObject.getString("Weekk6"));
                        Weekk7 = Integer.parseInt(jsonObject.getString("Weekk7"));
                        Weekk8 = Integer.parseInt(jsonObject.getString("Weekk8"));
                        Weekk9 = Integer.parseInt(jsonObject.getString("Weekk9"));
                        Weekk10 = Integer.parseInt(jsonObject.getString("Weekk10"));
                        Weekk11 = Integer.parseInt(jsonObject.getString("Weekk11"));
                        Weekk12 = Integer.parseInt(jsonObject.getString("Weekk12"));
                        Weekk13 = Integer.parseInt(jsonObject.getString("Weekk13"));
                        Weekk14 = Integer.parseInt(jsonObject.getString("Weekk14"));
                        Weekk15 = Integer.parseInt(jsonObject.getString("Weekk15"));
                        IFZero();
                        GraphView graph = (GraphView) findViewById(R.id.RecyclerView_ShowInformation_graph);
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
                                new DataPoint(Week15, Weekk15)
                        });
                        series.setColor(Color.RED);
                        series.setDrawDataPoints(true);
                        series.setDataPointsRadius(15);
                        series.setThickness(12);
                        graph.addSeries(series);
                        graph.setTitleColor(Color.GREEN);
                        graph.getViewport().setYAxisBoundsManual(true);
                        graph.getViewport().setMinY(0);
                        graph.getViewport().setMaxY(20);
                        graph.getViewport().setXAxisBoundsManual(true);
                        graph.getViewport().setMinX(0);
                        graph.getViewport().setMaxX(TotalCount);
                        graph.getViewport().setScrollable(true);
                        // This works
                        graph.setTitleColor(getResources().getColor(android.R.color.holo_red_dark));
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
                params.put("Id", Id);
                params.put("KindUser", "Master");
                return params;
            }
        };
        MySingleton.getInstance(ShowInformationStudent.this).addtoRequestQueue(stringrequest);
    }

    public Bitmap StringToBitMap(String image) {
        try {
            byte[] encodeByte = Base64.decode(image, Base64.DEFAULT);

            InputStream inputStream = new ByteArrayInputStream(encodeByte);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    //    گرفتن اطلاعات از سرور برای بخش مدرسه
    private void SendInfoServer1() {

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
                        Nation = jsonObject.getString("NationalCode");
                        Phone = jsonObject.getString("PhoneNumber");
                        Base = jsonObject.getString("Document");
                        Name.setText(jsonObject.getString("Name"));
                        LastName.setText(jsonObject.getString("LastName"));
                        PhoneNumber.setText(jsonObject.getString("PhoneNumber"));
                        NationalCode.setText(jsonObject.getString("NationalCode"));
                        TypeTerm.setText(jsonObject.getString("KindClass"));
                        Birth2.setText(jsonObject.getString("Birth"));
                        Base2.setText(jsonObject.getString("Document"));
                        School2.setText(jsonObject.getString("School"));
                        String Image1 = jsonObject.getString("Image");
                        Glide.with(getApplicationContext())
                                .load(jsonObject.getString("Image"))
                                .into(Image);

                        // This works
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
                params.put("Id", Id);
                params.put("KindUser", KindUser);
                return params;
            }
        };
        MySingleton.getInstance(ShowInformationStudent.this).addtoRequestQueue(stringrequest);
    }

    //برای مقدار دهس درست گرافمون استفاده می شود
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

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.SubmitImage: {
                StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_UrSelectImage, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if (response.toString().trim().equals("Registered")) {
                            Toast.makeText(ShowInformationStudent.this, "عکس ثبت شد", Toast.LENGTH_SHORT).show();
                            SubmitImage.setVisibility(View.GONE);
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }
                ) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("UserNameEdit", Phone);
                        params.put("PasswordEdit", Nation);
                        params.put("ImageEdit", encodedImage);
                        params.put("Kind", MyKind);
                        return params;
                    }
                };
                MySingleton.getInstance(getApplicationContext()).addtoRequestQueue(stringrequest);


                break;
            }
            case R.id.Search_SecoreLesson: {
                GiveScoreLesson();
                break;
            }
            case R.id.Score1: {

                Intent in = new Intent(ShowInformationStudent.this, chart.class);
                in.putExtra("Weekk1", Weekk1 + "");
                in.putExtra("Weekk2", Weekk2 + "");
                in.putExtra("Weekk3", Weekk3 + "");
                in.putExtra("Weekk4", Weekk4 + "");
                in.putExtra("Weekk5", Weekk5 + "");
                in.putExtra("Weekk6", Weekk6 + "");
                in.putExtra("Weekk7", Weekk7 + "");
                in.putExtra("Weekk8", Weekk8 + "");
                in.putExtra("TERM", 1 + "");
//                in.putExtra("Weekk9", Weekk9+"");
                startActivity(in);
                TERM1.setVisibility(View.GONE);
                TERM2.setVisibility(View.GONE);
                break;
            }
            case R.id.Score2: {
                Intent in = new Intent(ShowInformationStudent.this, chart.class);
                in.putExtra("Weekk1", Weekk9 + "");
                in.putExtra("Weekk2", Weekk10 + "");
                in.putExtra("Weekk3", Weekk11 + "");
                in.putExtra("Weekk4", Weekk12 + "");
                in.putExtra("Weekk5", Weekk13 + "");
                in.putExtra("Weekk6", Weekk14 + "");
                in.putExtra("Weekk7", Weekk15 + "");
                in.putExtra("Weekk8", Weekk16 + "");
                in.putExtra("TERM", 2 + "");
                startActivity(in);
                TERM1.setVisibility(View.GONE);
                TERM2.setVisibility(View.GONE);
                break;
            }
        }

    }

    private void SetZero() {

        GraphView graph = (GraphView) findViewById(R.id.RecyclerView_ShowInformation_graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0, 0),
                new DataPoint(0, 0),
                new DataPoint(0, 0),
                new DataPoint(0, 0),
                new DataPoint(0, 0),
                new DataPoint(0, 0),
                new DataPoint(0, 0),
                new DataPoint(0, 0),
                new DataPoint(0, 0),
                new DataPoint(0, 0),
                new DataPoint(0, 0),
                new DataPoint(0, 0),
                new DataPoint(0, 0),
                new DataPoint(0, 0),
                new DataPoint(0, 0),
                new DataPoint(0, 0),
                new DataPoint(0, 0),
                new DataPoint(0, 0),
                new DataPoint(0, 0),
                new DataPoint(0, 0),
                new DataPoint(0, 0)
        });

        graph.addSeries(series);
        graph.setTitleColor(Color.GREEN);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(20);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(20);
        graph.getViewport().setScrollable(true);
        // This works
        graph.setTitleColor(getResources().getColor(android.R.color.holo_red_dark));


    }

}
