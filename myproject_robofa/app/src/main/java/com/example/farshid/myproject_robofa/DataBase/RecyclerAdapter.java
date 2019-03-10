package com.example.farshid.myproject_robofa.DataBase;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.farshid.myproject_robofa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by farshid on 11/16/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    static List<DataBaseModle> dbList;
    static Context context;
    int lastPosition = -1;

    public RecyclerAdapter(Context context, List<DataBaseModle> dbList) {
        this.dbList = new ArrayList<DataBaseModle>();
        this.context = context;
        this.dbList = dbList;

    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recycle_note_channle, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {

        //        مقدار دهی فونت ها
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "font/irsans.ttf");
        Typeface tf2 = Typeface.createFromAsset(context.getAssets(), "font/ir.ttf");

        holder.name.setTypeface(tf);
        holder.Date.setTypeface(tf2);
        holder.Time.setTypeface(tf2);
        holder.Seen.setTypeface(tf2);
//        مقدار دهی مقادیر
        holder.name.setText(dbList.get(position).getNote());
        holder.Date.setText(dbList.get(position).getDate());
        holder.Time.setText(dbList.get(position).getTime());
        holder.Seen.setText(dbList.get(position).getCountSeen());
//انمیشن
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.rec3);
            holder.itemView.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return dbList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView name, Date, Time, Seen;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            name = (TextView) itemLayoutView
                    .findViewById(R.id.TextNote_ChannleNo);
            Date = (TextView) itemLayoutView
                    .findViewById(R.id.TextNote_dateNo);
            Time = (TextView) itemLayoutView
                    .findViewById(R.id.TextNote_TimeNo);
            Seen = (TextView) itemLayoutView
                    .findViewById(R.id.TextNote_CountSeenNo);
            itemLayoutView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
//            Intent intent = new Intent(context,DetailsActivity.class);
//
//            Bundle extras = new Bundle();
//            extras.putInt("position",getAdapterPosition());
//            intent.putExtras(extras);
//
//            /*
//            int i=getAdapterPosition();
//            intent.putExtra("position", getAdapterPosition());*/
//            context.startActivity(intent);
        }
    }
}
