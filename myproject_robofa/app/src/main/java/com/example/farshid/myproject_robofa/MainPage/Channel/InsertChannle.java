package com.example.farshid.myproject_robofa.MainPage.Channel;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.dd.CircularProgressButton;
import com.example.farshid.myproject_robofa.MainPage.MySingleton;
import com.example.farshid.myproject_robofa.R;
import com.example.farshid.myproject_robofa.Rigster.RegisterStudent;
import com.weiwangcn.betterspinner.library.BetterSpinner;

import java.util.HashMap;
import java.util.Map;

public class InsertChannle extends AppCompatActivity {
    Button circularProgressButton;
    EditText EDNote;
    BetterSpinner KindUserChannle;
    int Count=0;
    String Server_Ur2 = "http://farshidhabibi.ir/farshid/kivan/Channle.php";
    boolean Trust=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_channle);
        Initialize();
        String[] Field2 = new String[]{"اطلاعیه", "روانشناسی کودک"
                , "روانشناسی بزرگسال"
        };
        ArrayAdapter<String> adapter_Document_Student = new ArrayAdapter<String>(InsertChannle.this,
                android.R.layout.simple_dropdown_item_1line, Field2);
        KindUserChannle.setAdapter(adapter_Document_Student);
        circularProgressButton.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {

                                      if (Trust()) {
                                          if (Count == 0) {
                                              Count = 1;
                                              StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Ur2, new Response.Listener<String>() {
                                                  @Override
                                                  public void onResponse(String response) {
                                                      EDNote.setText("");
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
                                                      params.put("Note", EDNote.getText().toString().trim());
                                                      params.put("KindChannle", KindUserChannle.getText().toString().trim());
                                                      return params;
                                                  }
                                              };
                                              MySingleton.getInstance(InsertChannle.this).addtoRequestQueue(stringrequest);
                                          }
                                          Count = 0;
                                      }else {
                                          Toast.makeText(InsertChannle.this, "فیلد ها رو کامل کنید", Toast.LENGTH_SHORT).show();
                                      }
                                  }
                              }

        );
    } private boolean Trust() {
        Trust = true;
        if (EDNote.getText().toString().trim().isEmpty() || KindUserChannle.getText().toString().equals("نوع کانال") ) {
            Trust = false;
        }
        return Trust;

    }
    private void Initialize() {
        EDNote= (EditText) findViewById(R.id.NoteChannle);
        circularProgressButton= (Button) findViewById(R.id.InsertNote);
        KindUserChannle= (BetterSpinner) findViewById(R.id.KindChannle);

    }
}
