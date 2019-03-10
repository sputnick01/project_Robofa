package com.example.farshid.myproject_robofa.Teacher.InsertNote;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.weiwangcn.betterspinner.library.BetterSpinner;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by farshid on 11/7/2018.
 */

public class Tab_InserNote extends Fragment implements View.OnClickListener {
    View view;
    String Server_Ur2;
    BetterSpinner ET, EC, TC, SpinnerBase, SpinnerLessen;
    EditText EN;
    Button ok;
    String UserName = "", Password = "", KindUser = "";
    boolean Trust = false;
    int Count = 0;
    String[] ListLesson;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_insertnote, container, false);
//       گرفتن برخی اطلاعات از فایل
        Give_Information_From_File();
//مقدار دهی
        Initialize();
        LoadPage();
        SetFont();
//     مقدار دهی Spinner ها
        InitializeSpinner();
        SpinnerBase.setOnClickListener(this);
        ok.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      if (hasInternetConnection()) {
                                          if (Trust()) {
                                              if (Count == 0) {
                                                  Count = 1;
//                                             بررسس نوع دسترسی
                                                  if (KindUser.toString().equals("معلم")) {
                                                      Server_Ur2 = "http://farshidhabibi.ir/farshid/kivan/insertnoteforschool.php";
                                                      SendInfoServer1();
                                                  } else if (KindUser.toString().equals("استاد موسسه")) {
                                                      Server_Ur2 = "http://farshidhabibi.ir/farshid/kivan/insert1.php";
                                                      SendInfoServer2();
                                                  }

                                              }
                                              Count = 0;
                                          } else {
                                              Toast.makeText(getActivity(), "فیلد ها رو کامل کنید", Toast.LENGTH_SHORT).show();
                                          }
                                      }else {
                                          Toast.makeText(getActivity(), "مشکلی در برقراری ارتباط وجود دارد!", Toast.LENGTH_SHORT).show();
                                      }
                                  }
                              }

        );
        return view;
    }

    public boolean hasInternetConnection() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiNetwork != null && wifiNetwork.isConnected()) {
            return true;
        }
        NetworkInfo mobileNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (mobileNetwork != null && mobileNetwork.isConnected()) {
            return true;
        }
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnected()) {
            return true;
        }
        return false;
    }
    //    فرستادن اطلاعات برای بخش مدرسه
    private void SendInfoServer1() {
        StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Ur2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                                        }
                if (response.equals("e")) {
                    Toast.makeText(getActivity(), "دسترسی غیره مجاز میباشد!", Toast.LENGTH_SHORT).show();
                } else if (response.equals("ok")) {
                    Toast.makeText(getActivity(), "پیام شما با موفقیت ثبت شد!", Toast.LENGTH_SHORT).show();
                    EN.setText("");
                }

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
                params.put("Lessen", SpinnerLessen.getText().toString().trim());
                params.put("UserName", UserName);
                params.put("Password", Password);
                params.put("kind", "یادداشت");
                params.put("TypeTerm", TC.getText().toString().trim());
                params.put("Note", EN.getText().toString().trim());
                params.put("Base", SpinnerBase.getText().toString().trim());
                return params;
            }
        };
        MySingleton.getInstance(getActivity()).addtoRequestQueue(stringrequest);
    }
//    فرستادن اطلاعات برای بخش موسسه

    private void SendInfoServer2() {
        StringRequest stringrequest = new StringRequest(Request.Method.POST, Server_Ur2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                                        }
                if (response.equals("e")) {
                    Toast.makeText(getActivity(), "دسترسی غیره مجاز میباشد!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "پیام شما با موفقیت ثبت شد!", Toast.LENGTH_SHORT).show();
                    EN.setText("");
                }

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
                params.put("Class", EC.getText().toString().trim());
                params.put("UserName", UserName);
                params.put("Password", Password);
                params.put("kind", "یادداشت");
                params.put("TypeTerm", TC.getText().toString().trim());
                params.put("Note", EN.getText().toString().trim());
                params.put("Term", ET.getText().toString().trim());
                return params;
            }
        };
        MySingleton.getInstance(getActivity()).addtoRequestQueue(stringrequest);

    }

    //     انتخاب ایکون های مورد نیاز برای صفحه
    private void LoadPage() {
        if (KindUser.toString().trim().equals("معلم")) {
            ET.setVisibility(View.GONE);
            EC.setVisibility(View.GONE);
        } else if (KindUser.toString().trim().equals("استاد موسسه")) {
            SpinnerBase.setVisibility(View.GONE);
            SpinnerLessen.setVisibility(View.GONE);
        }
    }

    //        مقدار دهی سپینر ها
    private void InitializeSpinner() {
        ListLesson = new String[]{
                "قرآن", "فارسی", "علوم تجربی", "ریاضی", "هنر",
                "هدیه های آسمانی", "املا", "مطالعات اجتماعی", "انشا فارسی", "انظباط"
        };
        if (SpinnerBase.getText().toString().equals("اول ابتدایی")) {
            ListLesson = new String[]{
                    "قرآن", "فارسی", "علوم تجربی", "ریاضی", "هنر", "انظباط"
            };
        } else if (SpinnerBase.getText().toString().equals("دوم ابتدایی")) {
            ListLesson = new String[]{
                    "قرآن", "فارسی", "علوم تجربی", "ریاضی", "هنر",
                    "هدیه های آسمانی", "املا", "انظباط"
            };
        } else if (SpinnerBase.getText().toString().equals("سوم ابتدایی")) {
            ListLesson = new String[]{
                    "قرآن", "فارسی", "علوم تجربی", "ریاضی", "هنر",
                    "هدیه های آسمانی", "املا", "مطالعات اجتماعی", "انظباط"
            };
        } else if (SpinnerBase.getText().toString().equals("چهارم ابتدایی")) {
            ListLesson = new String[]{
                    "قرآن", "فارسی", "علوم تجربی", "ریاضی", "هنر",
                    "هدیه های آسمانی", "املا", "مطالعات اجتماعی", "انشا فارسی"
            };
        } else if (SpinnerBase.getText().toString().equals("پنجم ابتدایی")) {
            ListLesson = new String[]{
                    "قرآن", "فارسی", "علوم تجربی", "ریاضی", "هنر",
                    "هدیه های آسمانی", "املا", "مطالعات اجتماعی", "انشا فارسی"
            };
        } else if (SpinnerBase.getText().toString().equals("ششم ابتدایی")) {
            ListLesson = new String[]{
                    "قرآن", "فارسی", "علوم تجربی", "ریاضی", "هنر",
                    "هدیه های آسمانی", "املا", "مطالعات اجتماعی", "انشا فارسی"
            };
        }
        String[] MyBase = new String[]{"اول", "دوم"
                , "سوم", "چهارم", "پنجم", "ششم"
        };
        String[] Type = new String[]{"A", "B"
                , "C", "D"
        };

        ArrayAdapter<String> adapter_Document_Type = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, Type);
        TC.setAdapter(adapter_Document_Type);

        String[] Document_Student = new String[]{"1", "2"
                , "3", "4", "5", "6", "7", "8 ", "9", "10 "
                , "11", "12"
        };

        String[] Field2 = new String[]{"رباتیک", "چرتکه ومحاسبات ذهنی"
                , "سازهای ماکارونی", "زبان", "کلاس های دیگر", "ریاضی سه سوت "
        };

        ArrayAdapter<String> Base1 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, ListLesson);
        SpinnerLessen.setAdapter(Base1);


        ArrayAdapter<String> Base = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, MyBase);
        SpinnerBase.setAdapter(Base);

        ArrayAdapter<String> adapter_Document_Student = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, Document_Student);
        ET.setAdapter(adapter_Document_Student);


        ArrayAdapter<String> adapter_Document_Teacher = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, Field2);
        EC.setAdapter(adapter_Document_Teacher);


    }

    //          گرفتن برخی اطلاعات از فایل
    private void Give_Information_From_File() {
        SharedPreferences pref3 = getActivity().getApplicationContext().getSharedPreferences("User", 0); // 0 - for private mode
        UserName = pref3.getString("UserName", "");
        Password = pref3.getString("Password", "");
        KindUser = pref3.getString("KindUser", "");

    }

    //    ست کردن فونت
    private void SetFont() {
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "font/irsans.ttf");
        ET.setTypeface(tf);
        EC.setTypeface(tf);
        TC.setTypeface(tf);
        SpinnerBase.setTypeface(tf);
        EN.setTypeface(tf);
        ok.setTypeface(tf);
        SpinnerLessen.setTypeface(tf);
    }

    //    مقداردهی مقادیر
    private void Initialize() {


//        Spinner
        ET = (BetterSpinner) view.findViewById(R.id.Term);
        EC = (BetterSpinner) view.findViewById(R.id.Class);
        TC = (BetterSpinner) view.findViewById(R.id.TypeClass);
        SpinnerBase = (BetterSpinner) view.findViewById(R.id.School_Base);
        SpinnerLessen = (BetterSpinner) view.findViewById(R.id.School_Lessen);
//        EditText
        EN = (EditText) view.findViewById(R.id.Note);

//        Button

        ok = (Button) view.findViewById(R.id.ok);


    }

    //       برسی اینکه همه مقادیر وارد شده باشند
    private boolean Trust() {


        Trust = true;
        if (KindUser.toString().trim().equals("استاد موسسه")) {
            if (EN.getText().toString().trim().isEmpty() || ET.getText().toString().equals("ترم") || TC.getText().toString().equals("نوع کلاس") || EC.getText().toString().equals("رشته")) {
                Trust = false;
            }
        } else if (KindUser.toString().trim().equals("معلم")) {
            if (EN.getText().toString().trim().isEmpty() || SpinnerLessen.getText().toString().equals("درس") || TC.getText().toString().equals("نوع کلاس") || SpinnerBase.getText().toString().equals("پایه")) {
                Trust = false;
            }
        }
        return Trust;

    }

    @Override
    public void onClick(View v) {
        InitializeSpinner();
    }
}
