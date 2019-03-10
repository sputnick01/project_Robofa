package com.example.farshid.myproject_robofa.Spalish;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.farshid.myproject_robofa.Button_Navigation;
import com.example.farshid.myproject_robofa.DataBase.Child.ChildModle;
import com.example.farshid.myproject_robofa.DataBase.DatabaseHelper;
import com.example.farshid.myproject_robofa.MainPage.Channel.Adult.Modle_Adult;
import com.example.farshid.myproject_robofa.MainPage.Channel.Notification.Modle_Notification;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.persian;
import com.example.farshid.myproject_robofa.MainPage.Home.Other_Class.LoginToPage;
import com.example.farshid.myproject_robofa.MainPage.MySingleton;
import com.example.farshid.myproject_robofa.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Spalish extends AppCompatActivity {
    ProgressBar pro;
    TextView text;

    CoordinatorLayout coordinatorLayout;
    CardView BtnChortka, BtnMohasebat, BtnZaban, BtnClassDegar, BtnMakaroone, MainPage_TabHome_Riaze;
    JSONObject obj;
    JSONArray jsonarray;
    ArrayList<Modle_Adult> modellist;
    String Server_Ur2 = "http://farshidhabibi.ir/farshid/kivan/ReceiveChannel.php";
    String Server_Ur22 = "http://farshidhabibi.ir/farshid/kivan/UpdateApp.php";
    int Version, Version2;
    int Co = 1;
    JSONObject obj2;
    JSONArray jsonarray2;
    ArrayList<ChildModle> modellist2;
    int Id = 1, Id2 = 1, Id3 = 1;
    int IDNoti = 1000;
    JSONObject obj3;
    JSONArray jsonarray3;
    ArrayList<Modle_Notification> modellist3;
    String message1 = "", message2 = "", message3 = "", message4 = "";
    int t1 = 0, t2 = 0, t3 = 0, t4 = 0;
    JSONObject obj31;
    JSONArray jsonarray31;
    int noti = 0, noti2 = 0, noti3 = 0;
    String Server_Url2 = "http://farshidhabibi.ir/farshid/kivan/Demo.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalish);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        pro = (ProgressBar) findViewById(R.id.Progress);
        text = (TextView) findViewById(R.id.textpro);

        Check();
    }

    private void Demo() {
        StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Url2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int count = 0;
                try {
                    obj3 = new JSONObject(response);
                    jsonarray3 = obj3.getJSONArray("resp");
                    while (count < jsonarray3.length()) {
                        JSONObject jsonObject = jsonarray3.getJSONObject(count);
                        String User = jsonObject.getString("User");
                        String Pass = jsonObject.getString("Pass");
                        SharedPreferences pref = getApplicationContext().getSharedPreferences("Demo", 0); // 0 - for private mode
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("User", User.toString()); // Storing string
                        editor.putString("Pass", Pass.toString()); // Storing string
                        editor.commit(); // commit
                        count++;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(LoginToPage.this, "اینترنت خود را بررسی کنید!", Toast.LENGTH_SHORT).show();

            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
        };
        MySingleton.getInstance(Spalish.this).addtoRequestQueue(stringrequest);

    }

    private void Check() {
        if (hasInternetConnection()) {
            Demo();
            Loadpage();
        } else {

            onload();
        }
    }


    private void Loadpage() {
        pro.setMax(100);
        pro.setScaleY(3f);
        DatabaseHelper data = new DatabaseHelper(this);
        data.deleteDataChild();
        data.deleteDataAdult();
        data.deleteDataNoti();
        Adult(Spalish.this);
        Child(Spalish.this);
        Notification(Spalish.this);

//        CheckPermission();
        proAnim();

//
//            if (Version2==2){
//
////                CheckPermission();
//            }else {
//                new iOSDialogBuilder(Spalish.this)
//                        .setTitle(getString(R.string.example_title2))
//                        .setSubtitle(getString(R.string.example_subtitle2))
//                        .setBoldPositiveLabel(true)
//                        .setCancelable(false)
//                        .setPositiveListener(getString(R.string.ok2), new iOSDialogClickListener() {
//                            @Override
//                            public void onClick(iOSDialog dialog) {
//                                dialog.dismiss();
//                                Intent in = new Intent(Spalish.this, UpdateApp_MainPage.class);
//                                startActivity(in);
//                                System.exit(0);
//
//                            }
//                        })
//                        .setNegativeListener(getString(R.string.dismiss2
//                        ), new iOSDialogClickListener() {
//                            @Override
//                            public void onClick(iOSDialog dialog) {
//                                dialog.dismiss();
//                                System.exit(0);
//                            }
//                        })
//                        .build().show();
//            }


    }

    private void CheeckUpdate() {
        StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Ur22, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int count = 0;
                try {
                    obj31 = new JSONObject(response);
                    jsonarray31 = obj31.getJSONArray("resp");
                    while (count < jsonarray31.length()) {
                        JSONObject jsonObject = jsonarray31.getJSONObject(count);
                        Version2 = Integer.parseInt(jsonObject.getString("Version"));
                        Loadpage();
                        count++;
                        Co = 2;
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
        MySingleton.getInstance(Spalish.this).addtoRequestQueue(stringrequest);


    }

    private void Notification(final Context c1) {
        modellist3 = new ArrayList<>();
        StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Ur2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int count = 0;
                try {
                    obj3 = new JSONObject(response);
                    jsonarray3 = obj3.getJSONArray("resp");
                    SharedPreferences pref3 = getApplicationContext().getSharedPreferences("Notification", 0); // 0 - for private mode
                    noti = pref3.getInt("Notification1", 0);
                    while (count < jsonarray3.length()) {

                        JSONObject jsonObject = jsonarray3.getJSONObject(count);
                        String Note = jsonObject.getString("Note");
                        String Date = jsonObject.getString("Date");
                        String Time = jsonObject.getString("Time");
                        String Seen = jsonObject.getString("Seen");
                        if (count == 0) {
                            message1 = Note;

                        }
                        SharedPreferences pref = getApplicationContext().getSharedPreferences("Notification", 0); // 0 - for private mode
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putInt("Notification1", Id++); // Storing string
                        editor.commit(); // commit changes


                        DatabaseHelper databaseHelper = new DatabaseHelper(Spalish.this);
                        databaseHelper.insertDataNoti(Note, Date, Time, Seen);
//
                        count++;
                    }
                    Id--;
                    if (Id > noti) {
                        int Id21 = Id - noti;
                        SEtNotification_Noti(Id21);

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
                params.put("TypeChannel", "اطلاعیه");
                return params;
            }
        };
        MySingleton.getInstance(Spalish.this).addtoRequestQueue(stringrequest);

    }

    //           اطلاعیه ها تابع مقدار دهی نوتیفیکیشن
    private void SEtNotification_Noti(int iid) {
        String y6 = String.valueOf(persian.PerisanNumber(String.valueOf(iid)));
        Intent intent = new Intent(Spalish.this, Button_Navigation.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(Spalish.this);
        stackBuilder.addParentStack(Button_Navigation.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder noti = new NotificationCompat.Builder(Spalish.this).setSmallIcon(R.drawable.icon_noti).setContentTitle(y6 + "اطلاعیه جدید")
//                .setLargeIcon(BitmapFactory.decodeResource(Spalish.this.getResources(),
//                        R.drawable.yol1)).
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
//                                    .setPriority(NotificationCompat.PRIORITY_HIGH).
                .setColor(getResources().getColor(R.color.colorAccent));
        noti.setContentIntent(pendingIntent);

        NotificationCompat.BigTextStyle bi = new NotificationCompat.BigTextStyle().bigText(message1);
        noti.setStyle(bi);

        NotificationManager no = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        no.notify(1001, noti.build());

    }

    //               بزرگسالان ها تابع مقدار دهی نوتیفیکیشن
    private void SEtNotification_Adult(int iid) {
        String y6 = String.valueOf(persian.PerisanNumber(String.valueOf(iid)));
        Intent intent = new Intent(Spalish.this, Button_Navigation.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(Spalish.this);
        stackBuilder.addParentStack(Button_Navigation.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder noti = new NotificationCompat.Builder(Spalish.this).setSmallIcon(R.drawable.icons_brain).setContentTitle(y6 + "اطلاعیه جدید")
//                .setLargeIcon(BitmapFactory.decodeResource(Spalish.this.getResources(),
//                        R.drawable.yol1)).
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
//                                    .setPriority(NotificationCompat.PRIORITY_HIGH).
                .setColor(getResources().getColor(R.color.colorAccent));
        noti.setContentIntent(pendingIntent);

        NotificationCompat.BigTextStyle bi = new NotificationCompat.BigTextStyle().bigText(message2);
        noti.setStyle(bi);

        NotificationManager no = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        no.notify(1002, noti.build());

    }

    //               بزرگسالان ها تابع مقدار دهی نوتیفیکیشن
    private void SEtNotification_Child(int iid) {
        String y6 = String.valueOf(persian.PerisanNumber(String.valueOf(iid)));
        Intent intent = new Intent(Spalish.this, Button_Navigation.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(Spalish.this);
        stackBuilder.addParentStack(Button_Navigation.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder noti = new NotificationCompat.Builder(Spalish.this).setSmallIcon(R.drawable.icon_child).setContentTitle(y6 + "اطلاعیه جدید")
//                .setLargeIcon(BitmapFactory.decodeResource(Spalish.this.getResources(),
//                        R.drawable.yol1)).
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
//                                    .setPriority(NotificationCompat.PRIORITY_HIGH).
                .setColor(getResources().getColor(R.color.colorAccent));
        noti.setContentIntent(pendingIntent);

        NotificationCompat.BigTextStyle bi = new NotificationCompat.BigTextStyle().bigText(message3);
        noti.setStyle(bi);

        NotificationManager no = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        no.notify(1003, noti.build());

    }

    //    مقدار دهی متن های کانال کودکان
    private void Child(final Context c1) {
        modellist2 = new ArrayList<>();
        StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Ur2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int count = 0;
                try {
                    obj2 = new JSONObject(response);
                    jsonarray2 = obj2.getJSONArray("resp");
                    SharedPreferences pref3 = getApplicationContext().getSharedPreferences("Child", 0); // 0 - for private mode
                    noti3 = pref3.getInt("Child", 0);
                    while (count < jsonarray2.length()) {
                        JSONObject jsonObject = jsonarray2.getJSONObject(count);
                        String Note = jsonObject.getString("Note");
                        String Date = jsonObject.getString("Date");
                        String Time = jsonObject.getString("Time");
                        String Seen = jsonObject.getString("Seen");
                        DatabaseHelper databaseHelper = new DatabaseHelper(Spalish.this);
                        databaseHelper.insertDataChild(Note, Date, Time, Seen);
                        if (count == 0) {
                            message3 = Note;

                        }
                        SharedPreferences pref = getApplicationContext().getSharedPreferences("Child", 0); // 0 - for private mode
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putInt("Child", Id3++); // Storing string
                        editor.commit(); // commit changes
                        count++;
                    }
                    Id3--;
                    if (Id3 > noti3) {
                        int Id23 = Id3 - noti3;
//                        SEtNotification_Child(Id23);
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
                params.put("TypeChannel", "روانشناسی کودک");
                return params;
            }
        };
        MySingleton.getInstance(Spalish.this).addtoRequestQueue(stringrequest);
    }

    //    مقدار دهی متن های کانال بزرگسالان
    private void Adult(final Context c1) {
        modellist = new ArrayList<>();
        StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Ur2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int count = 0;
                try {
                    obj = new JSONObject(response);
                    jsonarray = obj.getJSONArray("resp");
                    SharedPreferences pref3 = getApplicationContext().getSharedPreferences("Adult", 0); // 0 - for private mode
                    noti2 = pref3.getInt("Adult", 0);
                    while (count < jsonarray.length()) {


                        JSONObject jsonObject = jsonarray.getJSONObject(count);
                        String Note = jsonObject.getString("Note");
                        String Date = jsonObject.getString("Date");
                        String Time = jsonObject.getString("Time");
                        String Seen = jsonObject.getString("Seen");
                        if (count == 0) {
                            message2 = Note;

                        }
                        SharedPreferences pref = getApplicationContext().getSharedPreferences("Adult", 0); // 0 - for private mode
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putInt("Adult", Id2++); // Storing string
                        editor.commit(); // commit changes
                        DatabaseHelper databaseHelper = new DatabaseHelper(Spalish.this);
                        databaseHelper.insertData(Note, Date, Time, Seen);
                        count++;
                    }
                    Id2--;
                    if (Id2 > noti2) {
                        int Id22 = Id2 - noti2;
//                        SEtNotification_Adult(Id22);
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
        MySingleton.getInstance(Spalish.this).addtoRequestQueue(stringrequest);
    }

    //مقدار دهی انمیشن
    private void proAnim() {
        Animationsoalish anim = new Animationsoalish(this, pro, text, 0f, 100f);
        anim.setDuration(10000);
        pro.setAnimation(anim);
    }

    //چک کردن اینترنت
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

    //  در صورد نبود اینترنت باز شدن اسنک بار
    private void onload() {
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.CoorSpalish);
        Snackbar snackbar = Snackbar.make(coordinatorLayout, "اینترنت در دسترس نیست!",
                Snackbar.LENGTH_INDEFINITE).setActionTextColor(Color.RED).setAction("بررسی", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Check();
            }
        });
        View view = snackbar.getView();
        TextView textView = view.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();

    }


}
