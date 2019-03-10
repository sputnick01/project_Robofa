package com.example.farshid.myproject_robofa.MainPage.Register;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.farshid.myproject_robofa.R;

public class Register_Student extends AppCompatActivity {
    TextView TRS1,TRS2,TRS3,TRS4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__student);
        TRS1= (TextView) findViewById(R.id.TRS1);
        TRS2= (TextView) findViewById(R.id.TRS2);
        TRS3= (TextView) findViewById(R.id.TRS3);
        TRS4= (TextView) findViewById(R.id.TRS4);
        Typeface tf = Typeface.createFromAsset(getAssets(), "font/irsans.ttf");
        TRS1.setTypeface(tf);
        TRS2.setTypeface(tf);
        TRS3.setTypeface(tf);
        TRS4.setTypeface(tf);

        TRS3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:0914 708 9973"));
                if (ActivityCompat.checkSelfPermission(Register_Student.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                Register_Student.this.startActivity(intent);
            }
        });
    }
}
