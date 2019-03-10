package com.example.farshid.myproject_robofa.Teacher.SearchStudent;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.farshid.myproject_robofa.R;

import java.util.ArrayList;

/**
 * Created by farshid on 11/21/2018.
 */

public class AdapterSearchStudent extends RecyclerView.Adapter<AdapterSearchStudent.ViewHolder> {
    private Context mContext;
    private ArrayList<ModleSearchStudent> AModel;

 int lastPosition=-1;
    public AdapterSearchStudent(Context context, ArrayList<ModleSearchStudent> List) {
        mContext = context;
        AModel = List;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.recycler_searchstudent, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ModleSearchStudent model = AModel.get(position);
        final String Id = model.getId();
//        ست کردن فونت
        Typeface tf = Typeface.createFromAsset(mContext.getAssets(), "font/irsans.ttf");
        holder.textName.setTypeface(tf);
        holder.TextPhone.setTypeface(tf);
        holder.TextCode.setTypeface(tf);
        holder.textName1.setTypeface(tf);
        holder.TextPhone1.setTypeface(tf);
        holder.TextCode1.setTypeface(tf);
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.rec3);
            holder.itemView.startAnimation(animation);
            lastPosition = position;
        }
        holder.textName.setText(model.getName());
        holder.TextPhone.setText(model.getPhoneNumber());
        holder.TextCode.setText(model.getNationalCode());
        holder.Item_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent in = new Intent(mContext, ShowMoreInformation.class);
//                in.putExtra("KeyId", Id);
//                in.putExtra("HomeRent", Type);
//                mContext.startActivity(in);
            }
        });
        Glide.with(mContext)
                .load(model.getImage()).error(R.drawable.avatar)
                .into(holder.Item_Image);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref3 = mContext.getApplicationContext().getSharedPreferences("ListSyudent", 0); // 0 - for private mode
                String  Kind = pref3.getString("Kind", "");
                Intent in = new Intent(mContext, ShowInformationStudent.class);
                in.putExtra("Id",Id);
                in.putExtra("Kind",Kind);
                mContext.startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return AModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView Item_Image;
        CardView cardView;
        TextView textName, TextPhone, TextCode,textName1, TextPhone1, TextCode1;
        Button btnSellOrRent;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.CardViewRe);
            Item_Image = itemView.findViewById(R.id.RecyclerSearch_ImageStudent);
            textName = itemView.findViewById(R.id.RecyclerSearch_TaxtNamePerson2);
            TextPhone = itemView.findViewById(R.id.RecyclerSearch_PhoneNumber2);
            TextCode = itemView.findViewById(R.id.RecyclerSearch_NationalCode2);
            textName1 = itemView.findViewById(R.id.RecyclerSearch_TaxtNamePerson1);
            TextPhone1 = itemView.findViewById(R.id.RecyclerSearch_PhoneNumber1);
            TextCode1 = itemView.findViewById(R.id.RecyclerSearch_NationalCode1);
        }
    }
}
