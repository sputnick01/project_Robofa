package com.example.farshid.myproject_robofa.UpdateApp;


import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.farshid.myproject_robofa.R;

import java.io.File;

public class UpdateApp_MainPage extends AppCompatActivity implements View.OnClickListener {
    private static Button downloadZip, EXIT, openDownloadedFolder;
    private static TextView Text;
    private static ImageView Update_imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateapp_mainpage);
//     مقدار دهی view ها
        initViews();
//        مقدار دهی لیسینر ها
        setListeners();
// مقدار دهی فونت
        SETFONT();
    }
// مقدار دهی فونت
    private void SETFONT() {
        Typeface tf = Typeface.createFromAsset(getAssets(), "font/irsans.ttf");
        EXIT.setTypeface(tf);
        Text.setTypeface(tf);
        downloadZip.setTypeface(tf);
        openDownloadedFolder.setTypeface(tf);
    }

    //     مقدار دهی view ها
    private void initViews() {
        downloadZip = (Button) findViewById(R.id.downloadZip);
        EXIT = (Button) findViewById(R.id.EXITApp);
        openDownloadedFolder = (Button) findViewById(R.id.openDownloadedFolder);
        Text = (TextView) findViewById(R.id.TEXT);
        Update_imageView = findViewById(R.id.Update_imageView);


    }
    //        مقدار دهی لیسینر ها
    private void setListeners() {
        downloadZip.setOnClickListener(this);
        openDownloadedFolder.setOnClickListener(this);
        EXIT.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        //Before starting any download check internet connection availability
        switch (view.getId()) {
            case R.id.downloadZip:
                if (isConnectingToInternet())
                    new DownloadTask(UpdateApp_MainPage.this, downloadZip, Text, EXIT,Update_imageView,openDownloadedFolder, Utils.downloadZipUrl);
                else
                    Toast.makeText(UpdateApp_MainPage.this, "اینترنت در دسترس قرار ندارد.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.openDownloadedFolder:
                break;
            case R.id.EXITApp: {
                System.exit(0);
                finish();
                break;

            }


        }

    }

    //Open downloaded folder
//    private void openDownloadedFolder() {
//        //First check if SD Card is present or not
//        if (new CheckForSDCard().isSDCardPresent()) {
//
//            //Get Download Directory File
//            File apkStorage = new File(
//                    Environment.getExternalStorageDirectory() + "/"
//                            + Utils.downloadDirectory);
//
//            //If file is not present then display Toast
//            if (!apkStorage.exists())
//                Toast.makeText(UpdateApp_MainPage.this, "Right now there is no directory. Please download some file first.", Toast.LENGTH_SHORT).show();
//
//            else {
//
//                //If directory is present Open Folder
//
//                /** Note: Directory will open only if there is a app to open directory like File Manager, etc.  **/
//
//                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//                Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath()
//                        + "/" + Utils.downloadDirectory);
//                intent.setDataAndType(uri, "file/*");
//                startActivity(Intent.createChooser(intent, "Open Download Folder"));
//            }
//
//        } else
//            Toast.makeText(UpdateApp_MainPage.this, "Oops!! There is no SD Card.", Toast.LENGTH_SHORT).show();
//
//    }

    //Check if internet is present or not
    private boolean isConnectingToInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager
                .getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }


}