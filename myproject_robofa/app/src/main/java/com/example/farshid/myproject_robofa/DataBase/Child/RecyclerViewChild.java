package com.example.farshid.myproject_robofa.DataBase.Child;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.farshid.myproject_robofa.DataBase.DataBaseModle;
import com.example.farshid.myproject_robofa.DataBase.RecyclerAdapter;
import com.example.farshid.myproject_robofa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by farshid on 11/16/2018.
 */

public class RecyclerViewChild extends RecyclerView.Adapter<RecyclerViewChild.ViewHolder> {

    static List<ChildModle> dbList;
    static Context context;
    int lastPosition=-1;
    public RecyclerViewChild(Context context, List<ChildModle> dbList){
        this.dbList = new ArrayList<ChildModle>();
        this.context = context;
        this.dbList = dbList;

    }

    @Override
    public RecyclerViewChild.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.mychild, null);

        // create ViewHolder

        RecyclerViewChild.ViewHolder viewHolder = new RecyclerViewChild.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        مقدار دهی فونت ها
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "font/irsans.ttf");
        Typeface tf2 = Typeface.createFromAsset(context.getAssets(), "font/ir.ttf");
        holder.name.setTypeface(tf);
        holder.TextDate.setTypeface(tf2);
        holder.TextTime.setTypeface(tf2);
        holder.CountSeen.setTypeface(tf2);
//        مقدار دهی مقادیر
        holder.name.setText(dbList.get(position).getNote());
        holder.TextDate.setText(dbList.get(position).getDate());
        holder.TextTime.setText(dbList.get(position).getTime());
        holder.CountSeen.setText(dbList.get(position).getCountSeen());
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

        public TextView name,TextDate,TextTime,CountSeen;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            TextDate = itemView.findViewById(R.id.TextNote_date);
            TextTime = itemView.findViewById(R.id.TextNote_Time);
            CountSeen = itemView.findViewById(R.id.TextNote_CountSeen);

            name = (TextView) itemLayoutView
                    .findViewById(R.id.TextNote_Channlechild);
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
