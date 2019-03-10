package com.example.farshid.myproject_robofa.MainPage.Home;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.farshid.myproject_robofa.DataBase.Child.ChildModle;
import com.example.farshid.myproject_robofa.MainPage.Channel.Adult.Modle_Adult;
import com.example.farshid.myproject_robofa.MainPage.Channel.Notification.Modle_Notification;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Enter_toActivity;
import com.example.farshid.myproject_robofa.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by farshid on 10/21/2018.
 */

public class Home extends Fragment implements View.OnClickListener {
    View view;
    Animation animTranslate, animTranslate2, animTranslate4, animTranslate44, animTranslate5, animTranslate55, animTranslate6, animTranslate66, animTranslate3, animTranslate33;

    CardView BtnChortka, BtnMohasebat, BtnZaban, BtnClassDegar, BtnMakaroone, MainPage_TabHome_Riaze;
    ImageView Image1,Image2,Image3,Image4,Image5,Image6;
    JSONObject obj;
    JSONArray jsonarray;
    ArrayList<Modle_Adult> modellist;
    String Server_Ur2 = "http://farshidhabibi.ir/farshid/kivan/ReceiveChannel.php";


    JSONObject obj2;
    JSONArray jsonarray2;
    ArrayList<ChildModle> modellist2;


    JSONObject obj3;
    JSONArray jsonarray3;
    ArrayList<Modle_Notification> modellist3;
    TextView T1,T2,T3,T4,T5,T6;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_home, container, false);
        Initialize();
        SetFont();

        SetAnimation();
        BtnChortka.setOnClickListener(this);
        BtnMohasebat.setOnClickListener(this);
        BtnZaban.setOnClickListener(this);
        BtnMakaroone.setOnClickListener(this);
        BtnClassDegar.setOnClickListener(this);
        MainPage_TabHome_Riaze.setOnClickListener(this);
//        Adult();
//        Child();
//        Notification();


        return view;
    }



    private void SetFont() {
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "font/irsans.ttf");
        T1.setTypeface(tf);
        T2.setTypeface(tf);
        T3.setTypeface(tf);
        T4.setTypeface(tf);
        T5.setTypeface(tf);
        T6.setTypeface(tf);

    }

    private void Initialize() {
        BtnChortka = view.findViewById(R.id.MainPage_TabHome_Chortka);
        BtnMohasebat = view.findViewById(R.id.MainPage_TabHome_Robatic);
        BtnZaban = view.findViewById(R.id.MainPage_TabHome_EdocationLanguage);
        BtnMakaroone = view.findViewById(R.id.MainPage_TabHome_Saze);
        MainPage_TabHome_Riaze = view.findViewById(R.id.MainPage_TabHome_Riaze);
        BtnClassDegar = view.findViewById(R.id.MainPage_TabHome_Class);


        T1 = view.findViewById(R.id.T1);
        T2 = view.findViewById(R.id.T2);
        T3 = view.findViewById(R.id.T3);
        T4 = view.findViewById(R.id.T4);
        T5 = view.findViewById(R.id.T5);
        T6 = view.findViewById(R.id.T6);


        Image1 = view.findViewById(R.id.tab_home_image1);
        Image2 = view.findViewById(R.id.tab_home_image2);
        Image3 = view.findViewById(R.id.tab_home_image3);
        Image4 = view.findViewById(R.id.tab_home_image4);
        Image5 = view.findViewById(R.id.tab_home_image5);
        Image6 = view.findViewById(R.id.tab_home_image6);




    }

    //ست کردن انمیشن برای ...
    private void SetAnimation() {
        animTranslate = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate);
        animTranslate2 = AnimationUtils.loadAnimation(getActivity(), R.anim.exadd);
        animTranslate = AnimationUtils.loadAnimation(getActivity(), R.anim.add);
        animTranslate2 = AnimationUtils.loadAnimation(getActivity(), R.anim.add2);
        animTranslate3 = AnimationUtils.loadAnimation(getActivity(), R.anim.add3);
        animTranslate33 = AnimationUtils.loadAnimation(getActivity(), R.anim.add33);
        animTranslate4 = AnimationUtils.loadAnimation(getActivity(), R.anim.add4);
        animTranslate44 = AnimationUtils.loadAnimation(getActivity(), R.anim.add44);
        animTranslate5 = AnimationUtils.loadAnimation(getActivity(), R.anim.add5);
        animTranslate55 = AnimationUtils.loadAnimation(getActivity(), R.anim.add55);
        animTranslate6 = AnimationUtils.loadAnimation(getActivity(), R.anim.add6);
        animTranslate66 = AnimationUtils.loadAnimation(getActivity(), R.anim.add66);
//        Image1.setAnimation(animTranslate);
//        Image2.setAnimation(animTranslate);
//        Image3.setAnimation(animTranslate);
//        Image4.setAnimation(animTranslate);
//        Image5.setAnimation(animTranslate);
//        Image6.setAnimation(animTranslate);
        Animation hyperspaceJump = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate);
        Image1.startAnimation(hyperspaceJump);
        Image2.startAnimation(hyperspaceJump);
        Image3.startAnimation(hyperspaceJump);
        Image4.startAnimation(hyperspaceJump);
        Image5.startAnimation(hyperspaceJump);
        Image6.startAnimation(hyperspaceJump);




//        BtnChortka.setAnimation(animTranslate2);
//        BtnMohasebat.setAnimation(animTranslate33);
//        MainPage_TabHome_Riaze.setAnimation(animTranslate44);
//        BtnZaban.setAnimation(animTranslate55);
//        BtnMakaroone.setAnimation(animTranslate66);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.MainPage_TabHome_Chortka: {
                Intent in = new Intent(getActivity(), Enter_toActivity.class);
                in.putExtra("Class", "چرتکه ومحاسبات ذهنی");
                startActivity(in);
                break;
            }
            case R.id.MainPage_TabHome_Robatic: {
                Intent in = new Intent(getActivity(), Enter_toActivity.class);
                in.putExtra("Class", "رباتیک");
                startActivity(in);
                break;
            }
            case R.id.MainPage_TabHome_EdocationLanguage: {
                Intent in = new Intent(getActivity(), Enter_toActivity.class);
                in.putExtra("Class", "زبان");
                startActivity(in);
                break;
            }
            case R.id.MainPage_TabHome_Saze: {
                Intent in = new Intent(getActivity(), Enter_toActivity.class);
                in.putExtra("Class", "سازهای ماکارونی");
                startActivity(in);
                break;
            }
            case R.id.MainPage_TabHome_Riaze: {
                Intent in = new Intent(getActivity(), Enter_toActivity.class);
                in.putExtra("Class", "ریاضی سه سوت");
                startActivity(in);
                break;
            }
            case R.id.MainPage_TabHome_Class: {
                Intent in = new Intent(getActivity(),Enter_toActivity.class);
                in.putExtra("Class", "هوافضا");
                startActivity(in);
                break;
            }

        }


    }
}
