package com.example.farshid.myproject_robofa.MainPage.Camera;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.farshid.myproject_robofa.MainPage.MySingleton;
import com.example.farshid.myproject_robofa.R;
import com.example.farshid.myproject_robofa.Rigster.BStudentSchool;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by farshid on 12/11/2018.
 */

public class Tab_MyImage extends Fragment implements View.OnClickListener {
    View view;
    ImageView imageView;
    EditText editText,editTextSender;
    Button button;
    boolean Trust = false;
    Integer REQUEST_CAMERA = 1;
    Integer SELECT_FILE = 0;
    int Count = 0;
    String encodedImage = "";
    String Server_Url = "http://farshidhabibi.ir/farshid/kivan/Table_AddImageForAdmin.php";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_myimage, container, false);
        Initialize();
        SetFont();
        imageView.setOnClickListener(this);
        button.setOnClickListener(this);

        return view;

    }

    //    ست کردن فونت
    private void SetFont() {
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "font/irsans.ttf");
        editText.setTypeface(tf);
        button.setTypeface(tf);
        editTextSender.setTypeface(tf);
    }

    //          مقدار دهی مقادیر
    private void Initialize() {
//        ImageView
        imageView = view.findViewById(R.id.Camera_ImageView_AddImage);
//        EditText
        editText = view.findViewById(R.id.Camera_EditText_InsertTopic);
        editTextSender=view.findViewById(R.id.Camera_EditText_InsertSender);
//        Button
        button = view.findViewById(R.id.Camera_Button_AddImage);


    }

    //    انتخاب عکس از گالری یا دوربین
    private void SelectImage() {
//        if (checkPermission()){
            Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
            photoPickerIntent.setType("image/*");
            startActivityForResult(photoPickerIntent.createChooser(photoPickerIntent, "Select File"), SELECT_FILE);
//
//        }else{
//            requestPermission();
//        }

    }
//    private boolean checkPermission() {
//        int result = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE );
//        if (result == PackageManager.PERMISSION_GRANTED) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//    private void requestPermission() {
//
//        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), android.Manifest.permission.READ_EXTERNAL_STORAGE)) {
//            Toast.makeText(getActivity(), "Write External Storage permission allows us to access images. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
//        } else {
//            ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
//        if(requestCode == PERMISSION_REQUEST_CODE){
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//
//                Toast.makeText(getActivity(), "Accepted", Toast.LENGTH_SHORT).show();
//
//                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
//                photoPickerIntent.setType("image/*");
//                startActivityForResult(photoPickerIntent.createChooser(photoPickerIntent, "Select File"), SELECT_FILE);
//
//
//
//
//
//            }
//        }
//
//    }


    //    برای انتخاب عکس از گالری یا دوربین
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CAMERA) {
                Bundle bundle = imageReturnedIntent.getExtras();
                Bitmap bmp = (Bitmap) bundle.get("data");
                imageView.setImageBitmap(bmp);
                byte[] data = getBitmapToByte(bmp, 100);
                encodedImage = Base64.encodeToString(data, Base64.DEFAULT);
                Toast.makeText(getActivity(), "دوربین", Toast.LENGTH_SHORT).show();
            } else if (requestCode == SELECT_FILE) {
                Uri selectedImage = imageReturnedIntent.getData();
                imageView.setImageURI(selectedImage);
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), selectedImage);
                    byte[] data = getBitmapToByte(bitmap, 100);
                    encodedImage = Base64.encodeToString(data, Base64.DEFAULT);
                    Toast.makeText(getActivity(), "گالری", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    private byte[] getBitmapToByte(Bitmap bmp, int quality) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, quality, stream);
        return stream.toByteArray();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.Camera_ImageView_AddImage: {
                SelectImage();
                break;
            }
            case R.id.Camera_Button_AddImage: {
                if (Trust()) {
                    if (Count == 0) {
                        Count = 1;
                        StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Url, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if (response.toString().trim().equals("Login")) {
                                    Toast.makeText(getActivity(), "ثبت شد !", Toast.LENGTH_SHORT).show();
                                    editText.setText("");
                                    editTextSender.setText("");
                                } else {
                                    Toast.makeText(getActivity(), "اینترنت خود را بررسی کنید!", Toast.LENGTH_SHORT).show();
                                }
                                Count = 0;

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                            }
                        }
                        ) {
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String, String> params = new HashMap<String, String>();
                                params.put("Topic", editText.getText().toString().trim());
                                params.put("Image", encodedImage);
                                params.put("SendBy", editTextSender.getText().toString().trim());
                                return params;
                            }
                        };
                        MySingleton.getInstance(getActivity()).addtoRequestQueue(stringrequest);

                    }
                } else {
                    Toast.makeText(getActivity(), "فیلد های لازم را پر کنید!", Toast.LENGTH_SHORT).show();
                }
            }
        }


    }

    private boolean Trust() {
        Trust = true;
        if (editText.getText().toString().isEmpty()) {
            Trust = false;
        }
        return Trust;
    }
}
