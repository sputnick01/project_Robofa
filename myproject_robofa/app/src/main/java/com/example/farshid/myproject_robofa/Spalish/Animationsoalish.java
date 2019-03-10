package com.example.farshid.myproject_robofa.Spalish;

import android.content.Context;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.farshid.myproject_robofa.Button_Navigation;

/**
 * Created by farshid on 11/16/2018.
 */

public class Animationsoalish extends Animation{
    private Context context;
    private ProgressBar progressBar;
    TextView textView;
    private float from;
    private float to;

    public Animationsoalish(Context context,ProgressBar progressBar,TextView textView,float from ,float to ){
        this.context=context;
        this.progressBar=progressBar;
        this.textView=textView;
        this.from=from;
        this.to=to;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value=from + (to-from)*interpolatedTime;
        progressBar.setProgress((int)value);
        textView.setText((int)value+" %");

        if (value ==to){
            context.startActivity(new Intent(context, Button_Navigation.class));
        }
    }
}
