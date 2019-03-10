package com.example.farshid.myproject_robofa.DataBase.Noti;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.farshid.myproject_robofa.DataBase.Child.ChildModle;
import com.example.farshid.myproject_robofa.DataBase.Child.RecyclerViewChild;
import com.example.farshid.myproject_robofa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by farshid on 11/16/2018.
 */

public class RecyclerNotification extends RecyclerView.Adapter<RecyclerNotification.ViewHolder>  {
    static List<NotificationModle> dbList;
    static Context context;
    int lastPosition=-1;
    public RecyclerNotification(Context context, List<NotificationModle> dbList){
        this.dbList = new ArrayList<NotificationModle>();
        this.context = context;
        this.dbList = dbList;

    }

    @Override
    public RecyclerNotification.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recycler_notification, null);

        // create ViewHolder

        RecyclerNotification.ViewHolder viewHolder = new RecyclerNotification.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

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

        public TextView name,Date,Time,Seen;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            name = (TextView) itemLayoutView
                    .findViewById(R.id.TextNote_ChannleNotification);
            Date = (TextView) itemLayoutView
                    .findViewById(R.id.TextNote_dateNotification);
            Time = (TextView) itemLayoutView
                    .findViewById(R.id.TextNote_TimeNotification);
            Seen = (TextView) itemLayoutView
                    .findViewById(R.id.TextNote_CountSeenNotification);
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
