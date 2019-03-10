package com.example.farshid.myproject_robofa.MainPage.Home.Other_Class;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.farshid.myproject_robofa.MainPage.Home.Other_Class.Morsal.Classs;
import com.example.farshid.myproject_robofa.R;


/**
 * Created by farshid on 10/21/2018.
 */

public class Group extends Fragment {
    View view;
    TextView T1,T2,T3,T4,T5,T6,T7;
    CardView Card;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_group, container, false);
        T1= (TextView) view.findViewById(R.id.q1);
        T2= (TextView) view.findViewById(R.id.q2);
        T3= (TextView) view.findViewById(R.id.q3);
        T4= (TextView) view.findViewById(R.id.q4);
        T5= (TextView) view.findViewById(R.id.q5);
        T6= (TextView) view.findViewById(R.id.q6);
        Card= (CardView) view.findViewById(R.id.OtherClass_Main_Morsal);
        Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(getActivity(), Classs.class);
                startActivity(in);
            }
        });
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "font/irsans.ttf");
        T1.setTypeface(tf);
        T2.setTypeface(tf);
        T3.setTypeface(tf);
        T4.setTypeface(tf);
        T5.setTypeface(tf);
        T6.setTypeface(tf);


        return view;
    }
}
