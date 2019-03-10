package com.example.farshid.myproject_robofa.Rigster;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class RegisterStudent extends AppCompatActivity {
    Button circularProgressButton;
    EditText EDPhoneNumber, EDMaliKey, EDName, EDlastName, EDTerm, EDClass, MainPage_Rigster_EditText_Breth, TermTeacher1, TermTeacher2;
    BetterSpinner KindUser, DocumentTeacher, Document, Field, FieldTeacher, KindClass;
    int count = 0;
    String Kind = "";
    boolean Trust = false;
    String ClassMe = "";
    String Server_Url = "http://farshidhabibi.ir/farshid/kivan/Rigster_Student.php";
    RelativeLayout relativeLayout;
    int position = 0;
    Integer REQUEST_CAMERA = 1;
    Integer SELECT_FILE = 0;
    String encodedImage = "";
    CircularImageView MainPage_Profile_CircularImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);
        Initialize();
        SetAdapter();
        MainPage_Profile_CircularImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectImage();
            }
        });
        Field.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] Field2 = new String[]{"رباتیک", "چرتکه ومحاسبات ذهنی"
                        , "سازهای ماکارونی", "زبان", "کلاس های دیگر", "ریاضی سه سوت "
                };
                if (position == 1) {
                    ClassMe = "Chortka";
                } else if (position == 0) {
                    ClassMe = "Robatic";
                } else if (position == 2) {
                    ClassMe = "Saze";
                } else if (position == 3) {
                    ClassMe = "Zaban";
                } else if (position == 5) {
                    ClassMe = "Riaze";
                }

            }
        });
        circularProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Listener_ProgressButton();

            }

//            count=0;
        });
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 1) {
                    position = 0;
                    EDPhoneNumber.setVisibility(View.GONE);
                    EDMaliKey.setVisibility(View.GONE);
                    EDName.setVisibility(View.GONE);
                    EDlastName.setVisibility(View.GONE);
                    EDTerm.setVisibility(View.GONE);
                    EDClass.setVisibility(View.GONE);
                    KindClass.setVisibility(View.GONE);
                    Document.setVisibility(View.GONE);
                    Field.setVisibility(View.GONE);
                    MainPage_Rigster_EditText_Breth.setVisibility(View.GONE);

                } else if (position == 0) {
                    position = 1;
                    EDPhoneNumber.setVisibility(View.VISIBLE);
                    EDMaliKey.setVisibility(View.VISIBLE);
                    EDName.setVisibility(View.VISIBLE);
                    EDlastName.setVisibility(View.VISIBLE);
                    EDTerm.setVisibility(View.VISIBLE);
                    EDClass.setVisibility(View.VISIBLE);
                    KindClass.setVisibility(View.VISIBLE);
                    Document.setVisibility(View.VISIBLE);
                    Field.setVisibility(View.VISIBLE);
                    MainPage_Rigster_EditText_Breth.setVisibility(View.VISIBLE);

                }
            }
        });

    }
//        دکمع ثبت اطلاعات
    private void Listener_ProgressButton() {
        if (Trust()) {
            if (count == 0) {
                count = 1;
                StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.toString().equals("Login")) {
                        }


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
                        params.put("PhoneNumber", EDPhoneNumber.getText().toString().trim());
                        params.put("MaliKey", EDMaliKey.getText().toString().trim());
                        params.put("Name", EDName.getText().toString().trim());
                        params.put("lastName", EDlastName.getText().toString().trim());
                        params.put("Term", EDTerm.getText().toString().trim());
                        params.put("KindClass", KindClass.getText().toString().trim());
                        params.put("Field", Field.getText().toString().trim());
                        params.put("EDClass", EDClass.getText().toString().trim());
                        params.put("Brith", MainPage_Rigster_EditText_Breth.getText().toString().trim());
                        params.put("Document", Document.getText().toString().trim());
                        params.put("Image", encodedImage);
                        return params;
                    }
                };
                MySingleton.getInstance(RegisterStudent.this).addtoRequestQueue(stringrequest);
            }
        } else {
            Toast.makeText(RegisterStudent.this, "فیلد های لازم را پر کنید!", Toast.LENGTH_SHORT).show();
        }
    }

    private void TextSaze() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTSa", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        if (EDTerm.getText().toString().trim().equals("1") && Field.getText().toString().trim().equals("سازهای ماکارونی")) {
            editor.putBoolean("key_AccTSa1", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("2") && Field.getText().toString().trim().equals("سازهای ماکارونی")) {
            editor.putBoolean("key_AccTSa2", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("3") && Field.getText().toString().trim().equals("سازهای ماکارونی")) {
            editor.putBoolean("key_AccTSa3", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("4") && Field.getText().toString().trim().equals("سازهای ماکارونی")) {
            editor.putBoolean("key_AccTSa4", true); // Storing string
            editor.commit(); // commit
        }

    }

    private void TestZaban() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTZ", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        if (EDTerm.getText().toString().trim().equals("1") && Field.getText().toString().trim().equals("زبان")) {
            editor.putBoolean("key_AccTZ1", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("2") && Field.getText().toString().trim().equals("زبان")) {
            editor.putBoolean("key_AccTZ2", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("3") && Field.getText().toString().trim().equals("زبان")) {
            editor.putBoolean("key_AccTZ3", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("4") && Field.getText().toString().trim().equals("زبان")) {
            editor.putBoolean("key_AccTZ4", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("5") && Field.getText().toString().trim().equals("زبان")) {
            editor.putBoolean("key_AccTZ5", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("6") && Field.getText().toString().trim().equals("زبان")) {
            editor.putBoolean("key_AccTZ6", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("7") && Field.getText().toString().trim().equals("زبان")) {
            editor.putBoolean("key_AccTZ7", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("8") && Field.getText().toString().trim().equals("زبان")) {
            editor.putBoolean("key_AccTZ8", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("9") && Field.getText().toString().trim().equals("زبان")) {
            editor.putBoolean("key_AccTZ9", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("10") && Field.getText().toString().trim().equals("زبان")) {
            editor.putBoolean("key_AccTZ10", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("11") && Field.getText().toString().trim().equals("زبان")) {
            editor.putBoolean("key_AccTZ11", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("12") && Field.getText().toString().trim().equals("زبان")) {
            editor.putBoolean("key_AccTZ12", true); // Storing string
            editor.commit(); // commit
        }
    }

    private void TestRobatic() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTRo", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        if (EDTerm.getText().toString().trim().equals("1") && Field.getText().toString().trim().equals("رباتیک")) {
            editor.putBoolean("key_AccTRo1", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("2") && Field.getText().toString().trim().equals("رباتیک")) {
            editor.putBoolean("key_AccTRo2", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("3") && Field.getText().toString().trim().equals("رباتیک")) {
            editor.putBoolean("key_AccTRo3", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("4") && Field.getText().toString().trim().equals("رباتیک")) {
            editor.putBoolean("key_AccTRo4", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("5") && Field.getText().toString().trim().equals("رباتیک")) {
            editor.putBoolean("key_AccTRo5", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("6") && Field.getText().toString().trim().equals("رباتیک")) {
            editor.putBoolean("key_AccTRo6", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("7") && Field.getText().toString().trim().equals("رباتیک")) {
            editor.putBoolean("key_AccTRo7", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("8") && Field.getText().toString().trim().equals("رباتیک")) {
            editor.putBoolean("key_AccTRo8", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("9") && Field.getText().toString().trim().equals("رباتیک")) {
            editor.putBoolean("key_AccTRo9", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("10") && Field.getText().toString().trim().equals("رباتیک")) {
            editor.putBoolean("key_AccTRo10", true); // Storing string
            editor.commit(); // commit
        }

    }

    private void TestRiaze() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTRi", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        if (EDTerm.getText().toString().trim().equals("1") && Field.getText().toString().trim().equals("ریاضی سه سوت")) {
            editor.putBoolean("key_AccTRi1", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("2") && Field.getText().toString().trim().equals("ریاضی سه سوت")) {
            editor.putBoolean("key_AccTRi2", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("3") && Field.getText().toString().trim().equals("ریاضی سه سوت")) {
            editor.putBoolean("key_AccTRi3", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("4") && Field.getText().toString().trim().equals("ریاضی سه سوت")) {
            editor.putBoolean("key_AccTRi4", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("5") && Field.getText().toString().trim().equals("ریاضی سه سوت")) {
            editor.putBoolean("key_AccTRi5", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("6") && Field.getText().toString().trim().equals("ریاضی سه سوت")) {
            editor.putBoolean("key_AccTRi6", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("7") && Field.getText().toString().trim().equals("ریاضی سه سوت")) {
            editor.putBoolean("key_AccTRi7", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("8") && Field.getText().toString().trim().equals("ریاضی سه سوت")) {
            editor.putBoolean("key_AccTRi8", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("9") && Field.getText().toString().trim().equals("ریاضی سه سوت")) {
            editor.putBoolean("key_AccTRi9", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("10") && Field.getText().toString().trim().equals("ریاضی سه سوت")) {
            editor.putBoolean("key_AccTRi10", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("11") && Field.getText().toString().trim().equals("ریاضی سه سوت")) {
            editor.putBoolean("key_AccTRi11", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("12") && Field.getText().toString().trim().equals("ریاضی سه سوت")) {
            editor.putBoolean("key_AccTRi12", true); // Storing string
            editor.commit(); // commit
        }
    }

    private boolean Trust() {
        Trust = true;
        if (EDPhoneNumber.getText().toString().isEmpty() || EDMaliKey.getText().toString().isEmpty() || EDName.getText().toString().isEmpty() ||
                EDlastName.getText().toString().isEmpty() || EDTerm.getText().toString().isEmpty() || EDClass.getText().toString().isEmpty() ||
                MainPage_Rigster_EditText_Breth.getText().toString().isEmpty()
                || Field.getText().toString().trim().equals("رشته ثبت نام") ||
                Document.getText().toString().trim().equals("مدرک تحصیلی")) {
            Trust = false;

        }
        return Trust;
    }


    public void TestChortka() {
        String Term = EDTerm.getText().toString().trim();
        String EDClass2 = Field.getText().toString().trim();
        if (EDTerm.getText().toString().trim().equals("1") && Field.getText().toString().trim().equals("چرتکه و محاسبات ذهنی")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTCH", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_AccTCH1", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("2") && Field.getText().toString().trim().equals("چرتکه و محاسبات ذهنی")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTCH", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_AccTCH2", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("3") && Field.getText().toString().trim().equals("چرتکه و محاسبات ذهنی")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTCH", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_AccTCH3", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("4") && Field.getText().toString().trim().equals("چرتکه و محاسبات ذهنی")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTCH", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_AccTCH4", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("5") && Field.getText().toString().trim().equals("چرتکه و محاسبات ذهنی")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTCH", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_AccTCH5", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("6") && Field.getText().toString().trim().equals("چرتکه و محاسبات ذهنی")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTCH", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_AccTCH6", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("7") && Field.getText().toString().trim().equals("چرتکه و محاسبات ذهنی")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTCH", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_AccTCH7", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("8") && Field.getText().toString().trim().equals("چرتکه و محاسبات ذهنی")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTCH", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_AccTCH8", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("9") && Field.getText().toString().trim().equals("چرتکه و محاسبات ذهنی")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTCH", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_AccTCH9", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("10") && Field.getText().toString().trim().equals("چرتکه و محاسبات ذهنی")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTCH", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_AccTCH10", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("11") && Field.getText().toString().trim().equals("چرتکه و محاسبات ذهنی")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTCH", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_AccTCH11", true); // Storing string
            editor.commit(); // commit
        }
        if (EDTerm.getText().toString().trim().equals("12") && Field.getText().toString().trim().equals("چرتکه و محاسبات ذهنی")) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("AccTCH", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_AccTCH12", true); // Storing string
            editor.commit(); // commit
        }
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
        circularProgressButton = (Button) findViewById(R.id.MainPage_Rigster_ButtonSubmit);
        EDPhoneNumber = (EditText) findViewById(R.id.MainPage_Rigster_EditText_PhoneNumber);
        EDMaliKey = (EditText) findViewById(R.id.MainPage_Rigster_EditText_MaliKey);
        EDName = (EditText) findViewById(R.id.MainPage_Rigster_EditText_Name);
        EDlastName = (EditText) findViewById(R.id.MainPage_Rigster_EditText_LastName);
        EDTerm = (EditText) findViewById(R.id.MainPage_Rigster_EditText_Term);
        relativeLayout = (RelativeLayout) findViewById(R.id.RelativeLayout2);
        EDClass = (EditText) findViewById(R.id.MainPage_Rigster_EditText_School);
        KindClass = (BetterSpinner) findViewById(R.id.MainPage_Rigster_EditText_KindClass);
        Document = (BetterSpinner) findViewById(R.id.MainPage_Rigster_EditText_LastDocument);
        Field = (BetterSpinner) findViewById(R.id.MainPage_Rigster_EditText_Feild);
        MainPage_Profile_CircularImageView = (CircularImageView) findViewById(R.id.MainPage_Profile_CircularImageView);
        MainPage_Rigster_EditText_Breth = (EditText) findViewById(R.id.MainPage_Rigster_EditText_Breth);

    }

    private void SetAdapter() {
        String[] Document_Student = new String[]{"اول ابتدایی", "دوم ابتدایی"
                , "سوم ابتدایی", "چهارم ابتدایی", "پنجم ابتدایی", "ششم راهنمایی", "هفتم راهنمایی", "هشتم راهنمایی ", "نهم راهنمایی", "اول دبیرستان"
                , "دوم دبیرستان", "سوم دبیرستان", "دیپلم"
        };
        String[] Item_KindClass = new String[]{"A", "B"
                , "C", "D"
        };
        String[] Field2 = new String[]{"رباتیک", "چرتکه ومحاسبات ذهنی"
                , "سازهای ماکارونی", "زبان", "کلاس های دیگر", "ریاضی سه سوت "
        };
        ArrayAdapter<String> adapter_Document_Student = new ArrayAdapter<String>(RegisterStudent.this,
                android.R.layout.simple_dropdown_item_1line, Document_Student);
        Document.setAdapter(adapter_Document_Student);


        ArrayAdapter<String> adapter_Document_Teacher = new ArrayAdapter<String>(RegisterStudent.this,
                android.R.layout.simple_dropdown_item_1line, Item_KindClass);
        KindClass.setAdapter(adapter_Document_Teacher);


        ArrayAdapter<String> adapter_Field = new ArrayAdapter<String>(RegisterStudent.this,
                android.R.layout.simple_dropdown_item_1line, Field2);
        Field.setAdapter(adapter_Field);


    }
}
