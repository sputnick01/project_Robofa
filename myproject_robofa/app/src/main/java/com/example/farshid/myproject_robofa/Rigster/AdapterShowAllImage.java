package com.example.farshid.myproject_robofa.Rigster;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
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
import com.example.farshid.myproject_robofa.MainPage.Channel.MYChildren.Adapter;
import com.example.farshid.myproject_robofa.MainPage.Channel.MYChildren.Modle;
import com.example.farshid.myproject_robofa.MainPage.Channel.Notification.Modle_Notification;
import com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.Note.Adapter_Note;
import com.example.farshid.myproject_robofa.MainPage.MySingleton;
import com.example.farshid.myproject_robofa.R;
import com.example.farshid.myproject_robofa.Rigster.ShowAllImage.ShowAllImage;
import com.example.farshid.myproject_robofa.Teacher.PageTeacher.PageTeacher;
import com.example.farshid.myproject_robofa.Teacher.SearchStudent.ShowInformationStudent;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static android.R.attr.bitmap;

/**
 * Created by farshid on 11/15/2018.
 */

public class AdapterShowAllImage extends RecyclerView.Adapter<AdapterShowAllImage.ViewHolder> {
    private Context mContext;
    private ArrayList<ModleShowAllImage> AModel;
    String Server_Ur23 = "http://farshidhabibi.ir/farshid/kivan/DeleteAndAccept.php";
    int lastPosition = 1;
    Bitmap bitmap;
    ModleShowAllImage model;

    public AdapterShowAllImage(Context context, ArrayList<ModleShowAllImage> List) {
        mContext = context;
        AModel = List;
    }

    @Override
    public AdapterShowAllImage.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.recycler_showallimage, parent, false);
        AdapterShowAllImage.ViewHolder viewHolder = new AdapterShowAllImage.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        model = AModel.get(position);
        final String Id = AModel.get(position).getId();
        final String URL = AModel.get(position).getImage();
        Typeface tf = Typeface.createFromAsset(mContext.getAssets(), "font/ff.ttf");
        holder.TextTopic.setTypeface(tf);
        holder.TextTopic.setTypeface(tf);
        holder.ShowAllImage_TextSendBy2.setTypeface(tf);
        holder.ShowAllImage_TextSendBy.setTypeface(tf);
        holder.TextTopic.setText(model.getTopic());
        holder.ShowAllImage_TextSendBy.setText(model.getSendBy());
        Glide.with(mContext)
                .load(model.getImage())
                .into(holder.Image);
        setAnimation(holder.itemView, position);

//حذف عکسی که کاربر فرستاده است
        holder.BtnUnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Ur23, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(mContext, "با موفقیت حذف شد!!", Toast.LENGTH_SHORT).show();
                        Intent in = new Intent(mContext, ShowAllImage.class);
                        mContext.startActivity(in);
                        System.exit(0);
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
                        params.put("DeORAcc", "Delete");
                        return params;
                    }
                };
                MySingleton.getInstance(mContext).addtoRequestQueue(stringrequest);
            }
        });

//        قبول کردن عکسی که کاربر فرستاده هست

        holder.BtnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Ur23, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(mContext, "با موفقیت اضافه شد!!", Toast.LENGTH_SHORT).show();
                        Intent in = new Intent(mContext, ShowAllImage.class);
                        mContext.startActivity(in);
                        System.exit(0);
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
                        params.put("DeORAcc", "Accept");
                        return params;
                    }
                };
                MySingleton.getInstance(mContext).addtoRequestQueue(stringrequest);
            }
        });
//        ذخیره عکس
        holder.SaveImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(mContext)
                        .load(URL)
                        .asBitmap()
                        .into(new SimpleTarget<Bitmap>(400,400) {
                            @Override
                            public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
                                saveImageToExternalStorage(resource);
                                Toast.makeText(mContext, " تصویر ذخیره شد", Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });

    }
    private void saveImageToExternalStorage(Bitmap finalBitmap) {
        String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
        File myDir = new File(root + "/saved_images_1");
        myDir.mkdirs();
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = "Image-" + n + ".jpg";
        File file = new File(myDir, fname);
        if (file.exists())
            file.delete();
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        MediaScannerConnection.scanFile(mContext, new String[]{file.toString()}, null,
                new MediaScannerConnection.OnScanCompletedListener() {
                    public void onScanCompleted(String path, Uri uri) {
//                        Log.i("ExternalStorage", "Scanned " + path + ":");
//                        Log.i("ExternalStorage", "-> uri=" + uri);
                    }
                });

    }

    protected void setAnimation(View viewToAnimate, int position) {
        if (position > lastPosition) {
            ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            anim.setDuration(new Random().nextInt(501));
            viewToAnimate.startAnimation(anim);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return AModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView TextTopic,ShowAllImage_TextSendBy,ShowAllImage_TextSendBy2;
        ImageView Image;
        ImageView BtnAccept, BtnUnAccept, SaveImage;

        public ViewHolder(View itemView) {
            super(itemView);
            TextTopic = itemView.findViewById(R.id.ShowAllImage_TextNote);
            Image = itemView.findViewById(R.id.ShowAllImage_ImageView);
            BtnAccept = itemView.findViewById(R.id.ShowAllImage_ButtonAccept);
            BtnUnAccept = itemView.findViewById(R.id.ShowAllImage_ButtonUnAccept);
            SaveImage = itemView.findViewById(R.id.ShowAllImage_SaveImage);
            ShowAllImage_TextSendBy=itemView.findViewById(R.id.ShowAllImage_TextSendBy);
            ShowAllImage_TextSendBy2=itemView.findViewById(R.id.ShowAllImage_TextSendBy2);


        }
    }

}
