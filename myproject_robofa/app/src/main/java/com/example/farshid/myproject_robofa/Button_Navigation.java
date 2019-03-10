package com.example.farshid.myproject_robofa;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.bottomnavigation.LabelVisibilityMode;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.farshid.myproject_robofa.AboutMe.about_me;
import com.example.farshid.myproject_robofa.MainPage.Camera.Camera;
import com.example.farshid.myproject_robofa.MainPage.Centeral.Centeral;
import com.example.farshid.myproject_robofa.MainPage.Channel.Channel;
import com.example.farshid.myproject_robofa.MainPage.Home.Home;
import com.example.farshid.myproject_robofa.MainPage.Home.Other_Class.Group;
import com.example.farshid.myproject_robofa.MainPage.MySingleton;
import com.example.farshid.myproject_robofa.Rigster.Enter_Teacher;
import com.example.farshid.myproject_robofa.Teacher.Login.LoginTeacher;
import com.example.farshid.myproject_robofa.UpdateApp.UpdateApp_MainPage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class Button_Navigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    ActionBarDrawerToggle drawerToggle;
    NavigationView Profile_navView;
    CoordinatorLayout coordinatorLayout;
    Fragment fragment;
    BottomNavigationView bottomNavigationView;
    ImageView ButtonNavigation_iconupdate;
    Animation animTranslate6, animTranslate66,animTranslate666,animTranslate6666;
    String Server_Ur22 = "http://farshidhabibi.ir/farshid/kivan/UpdateApp.php";
    JSONObject obj31;
    JSONArray jsonarray31;
    int Version2=0,Version=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button__navigation);
        ToolBar();
        intializeView();
        CheckPermission();
        SetAnimation();
        CheckUpdate();
        fragment = new Home();
        loadFragment(fragment);
//        Profile_navView= (NavigationView) findViewById(R.id.MainPageNav_navigation_view);
//        Profile_navView.setNavigationItemSelectedListener(this);
        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);
        bottomNavigationView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);

//        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);
//        bottomNavigationView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        ButtonNavigation_iconupdate.setOnClickListener(this);

    }

    //    چک کردن آپدیت
    private void CheckUpdate() {

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
                        String User=jsonObject.getString("User");
                        String Pass=jsonObject.getString("Pass");
                        SharedPreferences pref2 = getApplicationContext().getSharedPreferences("Demo", 0); // 0 - for private mode
                        SharedPreferences.Editor editor2 = pref2.edit();
                        editor2.putString("key_PhoneNumber",User); // Storing string
                        editor2.putString("key_Password",Pass); // Storing string
                        editor2.commit(); // commit changes
                        if (Version2==Version){
                            Animation hyperspaceJump = AnimationUtils.loadAnimation(Button_Navigation.this, R.anim.blink);
                            ButtonNavigation_iconupdate.startAnimation(hyperspaceJump);
                        }else {
//                            ButtonNavigation_iconupdate.setEnabled(false);
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

                return params;
            }
        };
        MySingleton.getInstance(Button_Navigation.this).addtoRequestQueue(stringrequest);


    }
    //Set Animation
    private void SetAnimation() {


        animTranslate6 = AnimationUtils.loadAnimation(Button_Navigation.this, R.anim.add6);
        ButtonNavigation_iconupdate.setAnimation(animTranslate6);
        animTranslate66 = AnimationUtils.loadAnimation(Button_Navigation.this, R.anim.add66);
        ButtonNavigation_iconupdate.setAnimation(animTranslate66);

//
    }
    //Initialize View
    private void intializeView() {
        ButtonNavigation_iconupdate = findViewById(R.id.ButtonNavigation_iconupdate);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.Buttomnav);

    }

    //    Back
    public void onBackPressed() {


    }

    //    Check Permisssion
    private void CheckPermission() {


        if (Build.VERSION.SDK_INT >= 23) {


            if (ContextCompat.checkSelfPermission(Button_Navigation.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(Button_Navigation.this
                        , new String[]{Manifest.permission.READ_EXTERNAL_STORAGE
                                ,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_NETWORK_STATE, Manifest.permission.INTERNET}
                        , 1);

            }
//            else if (ContextCompat.checkSelfPermission(Button_Navigation.this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
//
//                ActivityCompat.requestPermissions(Button_Navigation.this
//                        , new String[]{Manifest.permission.READ_EXTERNAL_STORAGE
//                                , Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
//                                , Manifest.permission.CALL_PHONE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_NETWORK_STATE, Manifest.permission.INTERNET}
//                        , 1);

//            }
            else {

                Toast.makeText(Button_Navigation.this, "شما قبلا این دسترسی هارا تایید کرده اید !", Toast.LENGTH_LONG).show();
            }


        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case 1: {

                if (grantResults.length >= 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(Button_Navigation.this, "دسترسی ها توسط شما تایید شد ، متشکریم !", Toast.LENGTH_LONG).show();
//                    Loadpage();
                }

            }
        }

    }


    //    For Menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }


    //    My Menu Item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Nav_MenuRigster: {
                Intent in = new Intent(Button_Navigation.this, Enter_Teacher.class);
                startActivity(in);
                break;
            }

            case R.id.Nav_MenuHome: {
                Intent in = new Intent(Button_Navigation.this, Button_Navigation.class);
                startActivity(in);
                System.exit(0);
                break;
            }
            case R.id.Nav_MenEnterTeacher: {
                Intent in = new Intent(Button_Navigation.this, LoginTeacher.class);
                startActivity(in);
                break;
            }
            case R.id.Nav_Menuaboutus: {
                Intent in = new Intent(Button_Navigation.this,about_me.class);
                startActivity(in);
                break;
            }
            case R.id.Nav_MenuUpdate: {

                break;
            }
            case R.id.Nav_MenuShare: {
                shareApplication();
                break;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }

    //    برای اشتراک گإاری برنامه
    private void shareApplication() {
        ApplicationInfo app = getApplicationContext().getApplicationInfo();
        String filePath = app.sourceDir;

        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.setType("*/*");

        File originalApk = new File(filePath);

        try {
            File tempFile = new File(getExternalCacheDir() + "/ExtractedApk");
            //If directory doesn't exists create new
            if (!tempFile.isDirectory())
                if (!tempFile.mkdirs())
                    return;
            tempFile = new File(tempFile.getPath() + "/" + getString(app.labelRes).replace(" ", "").toLowerCase() + ".apk");
            if (!tempFile.exists()) {
                if (!tempFile.createNewFile()) {
                    return;
                }
            }
            InputStream in = new FileInputStream(originalApk);
            OutputStream out = new FileOutputStream(tempFile);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
            System.out.println("File copied.");
            // باز کردن پنجره اشتراک گذاری
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(tempFile));
            startActivity(Intent.createChooser(intent, "اشتراک گذاری با"));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    //    برای لود کردن صفحه
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    fragment).commit();
            return true;
        }
        return false;
    }
    //تنظیمات ToolBar
    private void ToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.MainPageNav_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("");
        toolbar.setSubtitle("");
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setHomeButtonEnabled(true);
//        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.MainNav_drawerlayout);
//        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
//        drawerToggle.syncState();
    }

    //    Button Navigation Bar
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        fragment = null;
        switch (item.getItemId()) {
            case R.id.ButtomNav_MenuHome: {
                fragment = new Home();
                break;
            }

            case R.id.Nav_MenuShare: {
                shareApplication();
                break;
            }

            case R.id.ButtomNav_MenuCamera: {
                fragment = new Camera();
                break;
            }

            case R.id.ButtomNav_MenuChannle: {
                fragment = new Channel();
                break;
            }


            case R.id.Nav_MenuCenterlze: {
                fragment = new Centeral();
                break;
            }
            case R.id.ButtomNav_MenuGroup: {
                fragment = new Group();

                break;
            }
            case R.id.Nav_MenuExit: {
//                AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                builder.setMessage("آیا میخواهید از برنامه خارج شوید؟")
//                        .setCancelable(false)
//                        .setPositiveButton("بله", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                Button_Navigation.this.finish();
//                                System.exit(0);
//                            }
//                        })
//                        .setNegativeButton("خیر", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                dialog.cancel();
//                            }
//                        });
//                AlertDialog alert = builder.create();
//                alert.show();
                break;
            }
        }
        return loadFragment(fragment);
    }
    //    Lestener
    @Override
    public void onClick(View v) {
        Animation hyperspaceJump = AnimationUtils.loadAnimation(Button_Navigation.this, R.anim.rotate2);
        ButtonNavigation_iconupdate.startAnimation(hyperspaceJump);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (Version2==Version){

                    Intent in = new Intent(Button_Navigation.this, UpdateApp_MainPage.class);
                    startActivity(in);
                    Animation hyperspaceJump1 = AnimationUtils.loadAnimation(Button_Navigation.this, R.anim.add55);
                    ButtonNavigation_iconupdate.startAnimation(hyperspaceJump1);
                }else {
                    Toast.makeText(Button_Navigation.this, "آپدیت برنامه موجود نمی باشد!", Toast.LENGTH_LONG).show();
                    Animation hyperspaceJump1 = AnimationUtils.loadAnimation(Button_Navigation.this, R.anim.add55);
                    ButtonNavigation_iconupdate.startAnimation(hyperspaceJump1);

                }
            }
        }, 3000);


    }
}
