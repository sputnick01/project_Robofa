package com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.Note.Noti;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.farshid.myproject_robofa.MainPage.Channel.MYChildren.Modle;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.Note.Adapter_Note;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.Note.Mode_Note;
import com.example.farshid.myproject_robofa.R;

import java.util.ArrayList;

/**
 * Created by farshid on 11/23/2018.
 */

public class Adapter_Noti  extends RecyclerView.Adapter<Adapter_Noti.ViewHolder> {
    private Context mContext;
    private ArrayList<Modle_Noti> AModel;


    public Adapter_Noti(Context context, ArrayList<Modle_Noti> List) {
        mContext = context;
        AModel = List;
    }
    @Override
    public Adapter_Noti.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.recycler_noti, parent, false);
        Adapter_Noti.ViewHolder viewHolder = new Adapter_Noti.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Modle_Noti model = AModel.get(position);
//        Typeface tf = Typeface.createFromAsset(mContext.getAssets(), "font/irsans.ttf");
//        holder.TextNote.setTypeface(tf);
        holder.TextNote.setText(model.getNote());
        holder.Seen.setText(model.getSeen());
        holder.Date.setText(model.getDate());
        holder.Time.setText(model.getTime());
    }

    @Override
    public int getItemCount() {
        return AModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView TextNote, Seen, Date, Time;


        public ViewHolder(View itemView) {
            super(itemView);

            TextNote = itemView.findViewById(R.id.Noti_TextNote);
            Seen = itemView.findViewById(R.id.Noti_CountSeenNo);
            Date = itemView.findViewById(R.id.Noti_dateNo);
            Time = itemView.findViewById(R.id.Noti_TimeNo);

        }
    }
}
