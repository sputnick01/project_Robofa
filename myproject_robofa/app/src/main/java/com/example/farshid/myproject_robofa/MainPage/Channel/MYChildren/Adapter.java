package com.example.farshid.myproject_robofa.MainPage.Channel.MYChildren;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

import com.example.farshid.myproject_robofa.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by farshid on 11/15/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Modle> AModel;
    int lastPosition = -1;


    public Adapter(Context context, ArrayList<Modle> List) {
        mContext = context;
        AModel = List;
    }
    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.mychild, parent, false);
        Adapter.ViewHolder viewHolder = new Adapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.rec1);
            holder.itemView.startAnimation(animation);
            lastPosition = position;
        }
        Modle model = AModel.get(position);
        Typeface tf = Typeface.createFromAsset(mContext.getAssets(), "font/irsans.ttf");
        holder.TextNote.setTypeface(tf);
        holder.TextDate.setTypeface(tf);
        holder.TextTime.setTypeface(tf);

        holder.TextNote.setText(model.getNote());
        holder.TextDate.setText(model.getDate());
        holder.TextTime.setText(model.getTime());
    }
    @Override
    public int getItemCount() {
        return AModel.size();
    }

    protected void setAnimation(View viewToAnimate, int position) {
        if (position > lastPosition) {
            ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            anim.setDuration(new Random().nextInt(501));
            viewToAnimate.startAnimation(anim);
            lastPosition = position;
        }
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView TextNote ,TextDate,TextTime;

        public ViewHolder(View itemView) {
            super(itemView);

            TextNote = itemView.findViewById(R.id.TextNote_Channlechild);
            TextDate = itemView.findViewById(R.id.TextNote_date);
            TextTime = itemView.findViewById(R.id.TextNote_Time);

        }
    }

}
