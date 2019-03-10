package com.example.farshid.myproject_robofa.Rigster;

import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.weiwangcn.betterspinner.library.BetterSpinner;

import java.util.HashMap;
import java.util.Map;

public class Rigster_Teacher extends AppCompatActivity {
    Button circularProgressButton;
    EditText EDPhoneNumber, EDMaliKey, EDName, EDlastName, EDTerm, EDField, EDClass, MainPage_Rigster_EditText_Breth, TermTeacher1, TermTeacher2;
    BetterSpinner MainPage_RigsterTeacher_EditText_KindClass, DocumentTeacher, Document, Field, FieldTeacher;
    int count = 0;
    String Kind = "";
    boolean Trust = false;
    String ClassMe = "";
    int position = 1;

    String Server_Url = "http://farshidhabibi.ir/farshid/kivan/Rigster_Teacher.php";
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rigster__teacher);
        Initialize();
        SetAdapter();
        circularProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Trust()){
                if (count == 0) {
                    count = 1;
//
                    StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                        }

                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            count = 0;
                        }
                    }
                    ) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("EDPhoneNumber", EDPhoneNumber.getText().toString().trim());
                            params.put("EDMaliKey", EDMaliKey.getText().toString().trim());
                            params.put("EDName", EDName.getText().toString().trim());
                            params.put("EDlastName", EDlastName.getText().toString().trim());
                            params.put("EDTerm", EDTerm.getText().toString().trim());
                            params.put("EDKindClass", MainPage_RigsterTeacher_EditText_KindClass.getText().toString().trim());
                            params.put("EDFieldTeacher", FieldTeacher.getText().toString().trim());
                            params.put("EDDocumentTeacher", DocumentTeacher.getText().toString().trim());
                            return params;
                        }
                    };
                    MySingleton.getInstance(Rigster_Teacher.this).addtoRequestQueue(stringrequest);
                    count = 0;
                }
                } else {
                    Toast.makeText(Rigster_Teacher.this, "فیلد های لازم را پر کنید!", Toast.LENGTH_SHORT).show();
                }

            }

//            count=0;
        });

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    position = 1;
                    EDPhoneNumber.setVisibility(View.GONE);
                    EDMaliKey.setVisibility(View.GONE);
                    EDName.setVisibility(View.GONE);
                    EDlastName.setVisibility(View.GONE);
                    EDTerm.setVisibility(View.GONE);
                    DocumentTeacher.setVisibility(View.GONE);
                    FieldTeacher.setVisibility(View.GONE);
                    MainPage_RigsterTeacher_EditText_KindClass.setVisibility(View.GONE);

                } else if (position == 1) {
                    position = 0;
                    EDPhoneNumber.setVisibility(View.VISIBLE);
                    EDMaliKey.setVisibility(View.VISIBLE);
                    EDName.setVisibility(View.VISIBLE);
                    EDlastName.setVisibility(View.VISIBLE);
                    EDTerm.setVisibility(View.VISIBLE);
                    DocumentTeacher.setVisibility(View.VISIBLE);
                    FieldTeacher.setVisibility(View.VISIBLE);
                    MainPage_RigsterTeacher_EditText_KindClass.setVisibility(View.VISIBLE);


                }
            }
        });

    }

    private boolean Trust() {


        Trust = true;
        if (EDPhoneNumber.getText().toString().isEmpty() || EDMaliKey.getText().toString().isEmpty() || EDName.getText().toString().isEmpty() || EDlastName.getText().toString().isEmpty()
                || EDTerm.getText().toString().isEmpty() || FieldTeacher.getText().toString().equals("رشته مربی گری") || DocumentTeacher.getText().toString().equals("مدرک تحصیلی")
                || MainPage_RigsterTeacher_EditText_KindClass.getText().toString().equals("نوع کلاس")) {
            Trust = false;
        }

        return Trust;
    }

    private void Initialize() {
        circularProgressButton = (Button) findViewById(R.id.MainPage_RigsterTeacher_ButtonSubmit);
        EDPhoneNumber = (EditText) findViewById(R.id.MainPage_RigsterTeacher_EditText_PhoneNumber);
        EDMaliKey = (EditText) findViewById(R.id.MainPage_RigsterTeacher_EditText_MaliKey);
        EDName = (EditText) findViewById(R.id.MainPage_RigsterTeacher_EditText_Name);
        EDlastName = (EditText) findViewById(R.id.MainPage_RigsterTeacher_EditText_LastName);
        EDTerm = (EditText) findViewById(R.id.MainPage_RigsterTeacher_EditText_Term);
        FieldTeacher = (BetterSpinner) findViewById(R.id.MainPage_Rigster_EditText_FeildTeacher);
        relativeLayout = (RelativeLayout) findViewById(R.id.RelativeLayout222);
        DocumentTeacher = (BetterSpinner) findViewById(R.id.MainPage_Rigster_EditText_LastDocument);
        MainPage_RigsterTeacher_EditText_KindClass = (BetterSpinner) findViewById(R.id.MainPage_RigsterTeacher_EditText_KindClass);
    }

    private void SetAdapter() {

        String[] Document_Teacher = new String[]{"سیکل", "دیپلم"
                , "کارشناسی", " کارشناسی ارشد", "دکترا"
        };
        String[] Item_KindClass = new String[]{"A", "B"
                , "C", "D"
        };
        String[] Field2 = new String[]{"رباتیک", "چرتکه ومحاسبات ذهنی"
                , "سازهای ماکارونی", "زبان", "کلاس های دیگر", "ریاضی سه سوت "
        };
        ArrayAdapter<String> adapter_Document_Teacher = new ArrayAdapter<String>(Rigster_Teacher.this,
                android.R.layout.simple_dropdown_item_1line, Document_Teacher);
        DocumentTeacher.setAdapter(adapter_Document_Teacher);

        ArrayAdapter<String> adapter_Field2 = new ArrayAdapter<String>(Rigster_Teacher.this,
                android.R.layout.simple_dropdown_item_1line, Field2);
        FieldTeacher.setAdapter(adapter_Field2);


        ArrayAdapter<String> adapter_Field22 = new ArrayAdapter<String>(Rigster_Teacher.this,
                android.R.layout.simple_dropdown_item_1line, Item_KindClass);
        MainPage_RigsterTeacher_EditText_KindClass.setAdapter(adapter_Field22);


    }
}
