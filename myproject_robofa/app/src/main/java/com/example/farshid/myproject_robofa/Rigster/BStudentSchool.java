package com.example.farshid.myproject_robofa.Rigster;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.dd.CircularProgressButton;
import com.example.farshid.myproject_robofa.MainPage.MySingleton;
import com.example.farshid.myproject_robofa.R;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.weiwangcn.betterspinner.library.BetterSpinner;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BStudentSchool extends AppCompatActivity {
    Button circularProgressButton;
    EditText EDPhoneNumber, EDMaliKey, EDName, EDlastName, EDTerm, EDClass, MainPage_Rigster_EditText_Breth, TermTeacher1, TermTeacher2;
    BetterSpinner KindUser, School, Document, Field, FieldTeacher, KindClass;
    int count = 0;
    String Kind = "";
    boolean Trust = false;
    String ClassMe = "";
    String Server_Url = "http://farshidhabibi.ir/farshid/kivan/Rigster_Student_School.php";
    RelativeLayout relativeLayout;
    int position = 0;
    Integer REQUEST_CAMERA = 1;
    Integer SELECT_FILE = 0;
    String encodedImage = "";
    CircularImageView MainPage_Profile_CircularImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bstudent_school);
        Initialize();
        SetAdapter();
        MainPage_Profile_CircularImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectImage();
            }
        });
        circularProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Trust()) {

                    StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.toString().trim().equals("Login")) {
                                Toast.makeText(BStudentSchool.this, "ثبت شد !", Toast.LENGTH_SHORT).show();
                                EDPhoneNumber.setText("");
                                EDMaliKey.setText("");
                                EDName.setText("");
                                EDlastName.setText("");
                                EDClass.setText("");
                                KindClass.setText("");
                            } else {
                                Toast.makeText(BStudentSchool.this, "دسترسی اینترنت خود را بررسی کنید!", Toast.LENGTH_SHORT).show();
                            }


                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
//                                                circularProgressButton.setProgress(-1);
//                                                Toast.makeText(RegisterStudent.this, "دسترسی ", Toast.LENGTH_SHORT).show();
//                                                count = 0;
                        }
                    }
                    ) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("PhoneNumber", EDPhoneNumber.getText().toString().trim());
                            params.put("MaliKey", EDMaliKey.getText().toString().trim());
                            params.put("Name", EDName.getText().toString().trim());
                            params.put("lastName", EDlastName.getText().toString().trim());
                            params.put("KindClass", KindClass.getText().toString().trim());
                            params.put("Brith", MainPage_Rigster_EditText_Breth.getText().toString().trim());
                            params.put("School", School.getText().toString().trim());
                            params.put("Document", Document.getText().toString().trim());
                            params.put("Image", encodedImage);
                            return params;
                        }
                    };
                    MySingleton.getInstance(BStudentSchool.this).addtoRequestQueue(stringrequest);

                } else {
                    Toast.makeText(BStudentSchool.this, "فیلد های لازم را پر کنید!", Toast.LENGTH_SHORT).show();
                }
            }

//            count=0;
        });
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 1) {
                    position = 0;
                    School.setVisibility(View.GONE);
                    EDPhoneNumber.setVisibility(View.GONE);
                    EDMaliKey.setVisibility(View.GONE);
                    EDName.setVisibility(View.GONE);
                    EDlastName.setVisibility(View.GONE);
                    EDClass.setVisibility(View.GONE);
                    KindClass.setVisibility(View.GONE);
                    Document.setVisibility(View.GONE);
                    MainPage_Rigster_EditText_Breth.setVisibility(View.GONE);

                } else if (position == 0) {
                    position = 1;
                    School.setVisibility(View.VISIBLE);
                    EDPhoneNumber.setVisibility(View.VISIBLE);
                    EDMaliKey.setVisibility(View.VISIBLE);
                    EDName.setVisibility(View.VISIBLE);
                    EDlastName.setVisibility(View.VISIBLE);
                    EDClass.setVisibility(View.VISIBLE);
                    KindClass.setVisibility(View.VISIBLE);
                    Document.setVisibility(View.VISIBLE);
                    MainPage_Rigster_EditText_Breth.setVisibility(View.VISIBLE);

                }
            }
        });

    }

    private boolean Trust() {
        Trust = true;
        if (EDPhoneNumber.getText().toString().isEmpty() || EDMaliKey.getText().toString().isEmpty() || EDName.getText().toString().isEmpty() ||
                EDlastName.getText().toString().isEmpty() || EDClass.getText().toString().isEmpty() ||
                MainPage_Rigster_EditText_Breth.getText().toString().isEmpty()
                ||
                Document.getText().toString().trim().equals("مدرک تحصیلی")) {
            Trust = false;

        }
        return Trust;
    }

    //    انتخاب عکس از گالری یا دوربین
    private void SelectImage() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent.createChooser(photoPickerIntent, "Select File"), SELECT_FILE);
    }

    //    برای انتخاب عکس از گالری یا دوربین
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        if (resultCode == Activity.RESULT_OK) {

            if (requestCode == REQUEST_CAMERA) {
                Bundle bundle = imageReturnedIntent.getExtras();
                Bitmap bmp = (Bitmap) bundle.get("data");
                MainPage_Profile_CircularImageView.setImageBitmap(bmp);
                byte[] data = getBitmapToByte(bmp, 100);
                encodedImage = Base64.encodeToString(data, Base64.DEFAULT);
                Toast.makeText(this, "دوربین", Toast.LENGTH_SHORT).show();
            } else if (requestCode == SELECT_FILE) {
                Uri selectedImage = imageReturnedIntent.getData();
                MainPage_Profile_CircularImageView.setImageURI(selectedImage);
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                    byte[] data = getBitmapToByte(bitmap, 100);
                    encodedImage = Base64.encodeToString(data, Base64.DEFAULT);
                    Toast.makeText(this, "گالری", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    private byte[] getBitmapToByte(Bitmap bmp, int quality) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, quality, stream);
        return stream.toByteArray();
    }

    private void Initialize() {
        circularProgressButton = (Button) findViewById(R.id.BStudentschool_ButtonSubmit);
        EDPhoneNumber = (EditText) findViewById(R.id.BStudentschool_EditText_PhoneNumber);
        EDMaliKey = (EditText) findViewById(R.id.BStudentschool_EditText_MaliKey);
        EDName = (EditText) findViewById(R.id.BStudentschool_EditText_Name);
        EDlastName = (EditText) findViewById(R.id.BStudentschool_EditText_LastName);
        relativeLayout = (RelativeLayout) findViewById(R.id.RelativeLayout211);
        EDClass = (EditText) findViewById(R.id.BStudentschool_EditText_KindClass);
        KindClass = (BetterSpinner) findViewById(R.id.BStudentschool_EditText_KindClass);
        Document = (BetterSpinner) findViewById(R.id.BStudentschool_Ducument);
        MainPage_Profile_CircularImageView = (CircularImageView) findViewById(R.id.BStudentschool_Profile_CircularImageView);
        MainPage_Rigster_EditText_Breth = (EditText) findViewById(R.id.BStudentschool_EditText_Breth);
        School = (BetterSpinner) findViewById(R.id.BStudentschool_School);
    }

    private void SetAdapter() {

        String[] Document_Student = new String[]{"اول", "دوم"
                , "سوم", "چهارم", "پنجم", "ششم"
        };
        String[] Schoo = new String[]{"مرسل"
        };

        String[] Item_KindClass = new String[]{"A", "B"
                , "C", "D"
        };
//
//        String[] Field2 = new String[]{"رباتیک", "چرتکه ومحاسبات ذهنی"
//                , "سازهای ماکارونی", "زبان", "کلاس های دیگر", "ریاضی سه سوت "
//        };
        ArrayAdapter<String> adapter_Document_Student = new ArrayAdapter<String>(BStudentSchool.this,
                android.R.layout.simple_dropdown_item_1line, Document_Student);
        Document.setAdapter(adapter_Document_Student);

        ArrayAdapter<String> Sch = new ArrayAdapter<String>(BStudentSchool.this,
                android.R.layout.simple_dropdown_item_1line, Schoo);
        School.setAdapter(Sch);

        ArrayAdapter<String> adapter_Document_Teacher = new ArrayAdapter<String>(BStudentSchool.this,
                android.R.layout.simple_dropdown_item_1line, Item_KindClass);
        KindClass.setAdapter(adapter_Document_Teacher);
//
//
//        ArrayAdapter<String> adapter_Field = new ArrayAdapter<String>(BStudentSchool.this,
//                android.R.layout.simple_dropdown_item_1line, Field2);
//        Field.setAdapter(adapter_Field);


    }
}
