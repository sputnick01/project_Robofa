package com.example.farshid.myproject_robofa.Karshinas;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.farshid.myproject_robofa.MainPage.Channel.Adult.Adapter_Adult;
import com.example.farshid.myproject_robofa.MainPage.Channel.Adult.Modle_Adult;
import com.example.farshid.myproject_robofa.R;

import java.util.ArrayList;

/**
 * Created by farshid on 11/15/2018.
 */

public class Adapter_Kar extends RecyclerView.Adapter<Adapter_Kar.ViewHolder> {
    private Context mContext;
    private ArrayList<ModleKa> AModel;


    public Adapter_Kar(Context context, ArrayList<ModleKa> List) {
        mContext = context;
        AModel = List;
    }
    @Override
    public Adapter_Kar.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.recycler_allnote, parent, false);
        Adapter_Kar.ViewHolder viewHolder = new Adapter_Kar.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ModleKa model = AModel.get(position);
//        Typeface tf = Typeface.createFromAsset(mContext.getAssets(), "font/irsans.ttf");
//        holder.TextNote.setTypeface(tf);
        holder.TextNote.setText(model.getNote());
    }


    @Override
    public int getItemCount() {
        return AModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView TextNote;

        public ViewHolder(View itemView) {
            super(itemView);

            TextNote = itemView.findViewById(R.id.TextNote_ChannleAllnote);

        }
    }
}
