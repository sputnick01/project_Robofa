package com.example.farshid.myproject_robofa.Teacher.ShowAllForTeacher;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.farshid.myproject_robofa.MainPage.MySingleton;
import com.example.farshid.myproject_robofa.R;
import com.example.farshid.myproject_robofa.Teacher.PageTeacher.PageTeacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by farshid on 11/23/2018.
 */

public class Recycler_ShowAllForTeacher extends RecyclerView.Adapter<Recycler_ShowAllForTeacher.ViewHolder> {
    static List<Modle_ShowAllForTeacher> dbList;
    static Context context;
    int count = 1;
    String Server_Ur22 = "http://farshidhabibi.ir/farshid/kivan/Delete.php";
    String Server_Ur23 = "http://farshidhabibi.ir/farshid/kivan/DeleeteForTeacher.php";
    public Recycler_ShowAllForTeacher(Context context, List<Modle_ShowAllForTeacher> dbList) {
        this.dbList = new ArrayList<Modle_ShowAllForTeacher>();
        this.context = context;
        this.dbList = dbList;

    }

    @Override
    public Recycler_ShowAllForTeacher.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recycler_showallforteacher, null);
        // create ViewHolder

        Recycler_ShowAllForTeacher.ViewHolder viewHolder = new Recycler_ShowAllForTeacher.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String Id = dbList.get(position).getId();

        holder.name.setText(dbList.get(position).getNote());
        holder.TextDate.setText(dbList.get(position).getDate());
        holder.TextTime.setText(dbList.get(position).getTime());
        holder.CountSeen.setText(dbList.get(position).getCountSeen());
        holder.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref3 = context.getApplicationContext().getSharedPreferences("User", 0); // 0 - for private mode
                String KindUser = pref3.getString("KindUser", "");
                if (KindUser.equals("معلم")){
                    StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Ur23, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(context, "با موفقیت حذف شد!!", Toast.LENGTH_SHORT).show();
                            Intent in = new Intent(context, PageTeacher.class);
                            context.startActivity(in);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
//                onload();

                        }
                    }
                    ) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("ID", Id);
                            return params;
                        }
                    };
                    MySingleton.getInstance(context).addtoRequestQueue(stringrequest);
                }else {
                StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Ur22, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(context, "با موفقیت حذف شد!!", Toast.LENGTH_SHORT).show();
                        Intent in = new Intent(context, PageTeacher.class);
                        context.startActivity(in);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                onload();

                    }
                }
                ) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("ID", Id);
                        return params;
                    }
                };
                MySingleton.getInstance(context).addtoRequestQueue(stringrequest);}
            }
        });

    }

    @Override
    public int getItemCount() {
        return dbList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView name, TextDate, TextTime, CountSeen;
        ImageView Delete;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            TextDate = itemView.findViewById(R.id.TextNote_dateShowAll);
            TextTime = itemView.findViewById(R.id.TextNote_TimeShowAll);
            CountSeen = itemView.findViewById(R.id.TextNote_CountSeenShowAll);
            Delete = itemView.findViewById(R.id.Delete);

            name = (TextView) itemLayoutView
                    .findViewById(R.id.TextNote_ShowAll);
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
