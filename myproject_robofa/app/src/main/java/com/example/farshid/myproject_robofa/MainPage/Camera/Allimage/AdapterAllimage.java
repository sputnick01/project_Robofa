package com.example.farshid.myproject_robofa.MainPage.Camera.Allimage;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
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
import com.bumptech.glide.request.target.Target;
import com.example.farshid.myproject_robofa.MainPage.MySingleton;
import com.example.farshid.myproject_robofa.R;
import com.example.farshid.myproject_robofa.Rigster.AdapterShowAllImage;
import com.example.farshid.myproject_robofa.Rigster.ModleShowAllImage;
import com.example.farshid.myproject_robofa.Rigster.ShowAllImage.ShowAllImage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static android.content.Context.CLIPBOARD_SERVICE;
import static com.example.farshid.myproject_robofa.R.id.imageView;

/**
 * Created by farshid on 12/17/2018.
 */

public class AdapterAllimage extends RecyclerView.Adapter<AdapterAllimage.ViewHolder> {
    private Context mContext;
    private ArrayList<ModeAllImage> AModel;
    int lastPosition = 1;
    Bitmap bitmap;
    ModeAllImage model;
    public AdapterAllimage(Context context, ArrayList<ModeAllImage> List) {
        mContext = context;
        AModel = List;
    }

    @Override
    public AdapterAllimage.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.recycler_allimage, parent, false);
        AdapterAllimage.ViewHolder viewHolder = new AdapterAllimage.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        model = AModel.get(position);
        final String URL = AModel.get(position).getImage();
        Typeface tf = Typeface.createFromAsset(mContext.getAssets(), "font/ff.ttf");
        holder.TextTopic.setTypeface(tf);
        holder.Date.setTypeface(tf);
        holder.Time.setTypeface(tf);
        holder.AllImage_TextSendBy.setTypeface(tf);
        holder.AllImage_TextSendBy2.setTypeface(tf);
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.rec3);
            holder.itemView.startAnimation(animation);
            lastPosition = position;
        }
        holder.AllImage_TextSendBy.setText(model.getSendBy());
        holder.TextTopic.setText(model.getTopic());
        holder.Date.setText(model.getDate());
        holder.Time.setText(model.getTime());
        Glide.with(mContext)
                .load(model.getImage()).placeholder(R.drawable.image_defoult).thumbnail(.5f).crossFade()
                .into(holder.Image);
//        setAnimation(holder.itemView, position);
        holder.Image.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
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

                return false;
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
                        Log.i("ExternalStorage", "Scanned " + path + ":");
                        Log.i("ExternalStorage", "-> uri=" + uri);
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

    public Bitmap StringToBitMap(String image) {
        try {
            byte[] encodeByte = Base64.decode(image, Base64.DEFAULT);
            InputStream inputStream = new ByteArrayInputStream(encodeByte);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView TextTopic,Date,Time,AllImage_TextSendBy,AllImage_TextSendBy2;
        ImageView Image,icon_copy;
        public ViewHolder(View itemView) {
            super(itemView);
            TextTopic = itemView.findViewById(R.id.TabShowAllImage_TextNote);
            Image = itemView.findViewById(R.id.TabShowAllImage_ImageView);
            Date = itemView.findViewById(R.id.TabShowAllImage_TextDate);
            Time = itemView.findViewById(R.id.TabShowAllImage_TextTime);
            AllImage_TextSendBy = itemView.findViewById(R.id.AllImage_TextSendBy);
            AllImage_TextSendBy2 = itemView.findViewById(R.id.AllImage_TextSendBy2);
            icon_copy = itemView.findViewById(R.id.icon_Copy2);

        }
    }
}
