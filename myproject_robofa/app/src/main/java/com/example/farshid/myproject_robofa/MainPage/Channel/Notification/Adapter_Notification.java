package com.example.farshid.myproject_robofa.MainPage.Channel.Notification;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

import com.example.farshid.myproject_robofa.MainPage.Channel.MYChildren.Adapter;
import com.example.farshid.myproject_robofa.MainPage.Channel.MYChildren.Modle;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.Note.Adapter_Note;
import com.example.farshid.myproject_robofa.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by farshid on 11/15/2018.
 */

public class Adapter_Notification extends RecyclerView.Adapter<Adapter_Notification.ViewHolder> {
    private Context mContext;
    private ArrayList<Modle_Notification> AModel;
int lastPosition=-1;

    public Adapter_Notification(Context context, ArrayList<Modle_Notification> List) {
        mContext = context;
        AModel = List;
    }
    @Override
    public Adapter_Notification.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.recycler_notification, parent, false);
        Adapter_Notification.ViewHolder viewHolder = new Adapter_Notification.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Modle_Notification model = AModel.get(position);
//        setAnimation(holder.itemView, position);
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.rec3);
            holder.itemView.startAnimation(animation);
            lastPosition = position;
        }
//        Typeface tf = Typeface.createFromAsset(mContext.getAssets(), "font/irsans.ttf");
//        holder.TextNote.setTypeface(tf);
        holder.TextNote.setText(model.getNote());
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
        TextView TextNote;

        public ViewHolder(View itemView) {
            super(itemView);

//            TextNote = itemView.findViewById(R.id.TextNote_Channlenotification);

        }
    }

}
