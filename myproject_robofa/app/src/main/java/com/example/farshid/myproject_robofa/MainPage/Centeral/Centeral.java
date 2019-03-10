package com.example.farshid.myproject_robofa.MainPage.Centeral;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.farshid.myproject_robofa.Location.MapsActivity;
import com.example.farshid.myproject_robofa.R;

/**
 * Created by farshid on 10/27/2018.
 */

public class Centeral extends Fragment implements View.OnClickListener {
    View view;
    TextView Text1, Text2, Text3, Text4, Text5, Text6, Text7, Text8,
            Text9, Text10, Text11, Text12, Text13, Text14, Text15, Text16, Text17, Text18, Text19, Text20, Text71, Text711, Text7111, Text71111, Text711111;
    ImageView Location1, Location2, Location3, Location4, Location5;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_centeral, container, false);
        Initialiaze();
        SetFont();
        Location1.setOnClickListener(this);
        Location2.setOnClickListener(this);
        Location3.setOnClickListener(this);
        Location4.setOnClickListener(this);
        Location5.setOnClickListener(this);
        Text3.setOnClickListener(this);
        Text7.setOnClickListener(this);
        Text11.setOnClickListener(this);
        Text15.setOnClickListener(this);
        Text19.setOnClickListener(this);
        Text71.setOnClickListener(this);
        Text711.setOnClickListener(this);
        Text7111.setOnClickListener(this);
        Text71111.setOnClickListener(this);
        Text711111.setOnClickListener(this);
        return view;
    }

    private void SetFont() {
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "font/irsans.ttf");
        Text1.setTypeface(tf);
        Text2.setTypeface(tf);
        Text3.setTypeface(tf);
        Text4.setTypeface(tf);
        Text5.setTypeface(tf);
        Text6.setTypeface(tf);
        Text7.setTypeface(tf);
        Text8.setTypeface(tf);
        Text9.setTypeface(tf);
        Text10.setTypeface(tf);
        Text11.setTypeface(tf);
        Text12.setTypeface(tf);
        Text13.setTypeface(tf);
        Text14.setTypeface(tf);
        Text15.setTypeface(tf);
        Text16.setTypeface(tf);

    }

    private void Initialiaze() {
        Text1 = view.findViewById(R.id.Text1);
        Text2 = view.findViewById(R.id.Text2);
        Text3 = view.findViewById(R.id.Text3);
        Text4 = view.findViewById(R.id.Text4);
        Text5 = view.findViewById(R.id.Text5);
        Text6 = view.findViewById(R.id.Text6);
        Text7 = view.findViewById(R.id.Text7);
        Text8 = view.findViewById(R.id.Text8);
        Text9 = view.findViewById(R.id.Text9);
        Text10 = view.findViewById(R.id.Text10);
        Text11 = view.findViewById(R.id.Text11);
        Text12 = view.findViewById(R.id.Text12);
        Text13 = view.findViewById(R.id.Text13);
        Text14 = view.findViewById(R.id.Text14);
        Text15 = view.findViewById(R.id.Text15);
        Text16 = view.findViewById(R.id.Text16);

        Text17 = view.findViewById(R.id.Text17);
        Text18 = view.findViewById(R.id.Text18);
        Text19 = view.findViewById(R.id.Text19);
        Text20 = view.findViewById(R.id.Text20);

        Location1 = view.findViewById(R.id.MyLocation1);
        Location2 = view.findViewById(R.id.MyLocation2);
        Location3 = view.findViewById(R.id.MyLocation3);
        Location4 = view.findViewById(R.id.MyLocation4);
        Location5 = view.findViewById(R.id.MyLocation5);
        Text71 = view.findViewById(R.id.Text71);
        Text711 = view.findViewById(R.id.Text711);
        Text7111 = view.findViewById(R.id.Text7111);
        Text71111 = view.findViewById(R.id.Text71111);
        Text711111 = view.findViewById(R.id.Text711111);
        Text3.setText("۰۹۱۴۷۰۸۹۹۷۳");
        Text7.setText("۰۹۱۴۷۰۸۹۹۷۳");
        Text11.setText("۰۹۱۴۷۰۸۹۹۷۳");
        Text15.setText("۰۹۱۴۷۰۸۹۹۷۳");
        Text19.setText("۰۹۱۴۷۰۸۹۹۷۳");


        Animation animation = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.textview);
        Text3.startAnimation(animation);
        Text7.startAnimation(animation);
        Text11.startAnimation(animation);
        Text15.startAnimation(animation);
        Text19.startAnimation(animation);


//        Text71.startAnimation(animation);
//        Text711.startAnimation(animation);
//        Text7111.startAnimation(animation);
//        Text71111.startAnimation(animation);
//        Text711111.startAnimation(animation);
    }



    public static boolean isAppAvailable(Context context, String appName) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(appName, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.MyLocation1: {
                Intent in = new Intent(getActivity(), MapsActivity.class);
                in.putExtra("Kind", "1");
                startActivity(in);
                break;
            }
            case R.id.MyLocation2: {
                Intent in = new Intent(getActivity(), MapsActivity.class);
                in.putExtra("Kind", "2");
                startActivity(in);
                break;
            }
            case R.id.MyLocation3: {
                Intent in = new Intent(getActivity(), MapsActivity.class);
                in.putExtra("Kind", "3");
                startActivity(in);
                break;
            }
            case R.id.MyLocation4: {
                Intent in = new Intent(getActivity(), MapsActivity.class);
                in.putExtra("Kind", "4");
                startActivity(in);
                break;
            }
            case R.id.MyLocation5: {
                Intent in = new Intent(getActivity(), MapsActivity.class);
                in.putExtra("Kind", "5");
                startActivity(in);
                break;
            }
            case R.id.Text3: {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:0914 708 9973"));

                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                getActivity().startActivity(intent);

                break;
            }
            case R.id.Text7: {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:0914 708 9973"));

                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                getActivity().startActivity(intent);

                break;
            }
            case R.id.Text11: {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:0914 708 9973"));

                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                getActivity().startActivity(intent);


                break;
            }
            case R.id.Text15: {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:0914 708 9973"));

                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                getActivity().startActivity(intent);

                break;
            }
            case R.id.Text19: {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:0914 708 9973"));

                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                getActivity().startActivity(intent);

                break;
            }
            case R.id.Text71: {
                Intent telegram = new Intent(Intent.ACTION_VIEW , Uri.parse("https://telegram.me/robomeshkin"));

                startActivity(telegram);

                break;
            }
            case R.id.Text711: {
                Intent telegram = new Intent(Intent.ACTION_VIEW , Uri.parse("https://telegram.me/robomeshkin"));
                startActivity(telegram);

                break;
            }
            case R.id.Text7111: {
                Intent telegram = new Intent(Intent.ACTION_VIEW , Uri.parse("https://telegram.me/robomeshkin"));
                startActivity(telegram);

//                intentMessageTelegram("سلام");
                break;
            }
            case R.id.Text71111: {
                Intent telegram = new Intent(Intent.ACTION_VIEW , Uri.parse("https://telegram.me/robomeshkin"));
                startActivity(telegram);

//                intentMessageTelegram("سلام");
                break;
            }
            case R.id.Text711111: {
                Intent telegram = new Intent(Intent.ACTION_VIEW , Uri.parse("https://telegram.me/robomeshkin"));
                startActivity(telegram);

                break;
            }

        }
    }
}
