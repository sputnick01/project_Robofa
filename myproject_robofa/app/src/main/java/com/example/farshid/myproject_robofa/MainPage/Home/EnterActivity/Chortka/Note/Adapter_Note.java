package com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.Note;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.farshid.myproject_robofa.R;

import java.util.ArrayList;

/**
 * Created by farshid on 10/30/2018.
 */


public class Adapter_Note extends RecyclerView.Adapter<Adapter_Note.ViewHolder> {
    private Context mContext;
    private ArrayList<Mode_Note> AModel;


    public Adapter_Note(Context context, ArrayList<Mode_Note> List) {
        mContext = context;
        AModel = List;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.recycler_note, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Mode_Note model = AModel.get(position);
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

            TextNote = itemView.findViewById(R.id.Note_TextNote);
            Seen = itemView.findViewById(R.id.Note_CountSeenNo);
            Date = itemView.findViewById(R.id.Note_dateNo);
            Time = itemView.findViewById(R.id.Note_TimeNo);

        }
    }

}