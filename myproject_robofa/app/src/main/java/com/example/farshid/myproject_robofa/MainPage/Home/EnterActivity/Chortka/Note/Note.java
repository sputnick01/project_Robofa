package com.example.farshid.myproject_robofa.MainPage.Home.EnterActivity.Chortka.Note;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.farshid.myproject_robofa.R;
import com.example.farshid.myproject_robofa.TabStudent.AdapterStudent;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Note extends AppCompatActivity {
    String Server_Ur2 = "http://farshidhabibi.ir/farshid/kivan/select_note.php";
    String Term = "";
    JSONObject obj;
    JSONArray jsonarray;
    RecyclerView recycler;
    ArrayList<Mode_Note> modellist;
    Adapter_Note homeAdd;
    ProgressDialog progressDialog;
//    CoordinatorLayout coordinatorLayout;
    ProgressBar progressBar;

    int Count = 0;
    Toolbar toolbar;
    String Class = "",Kind="",Base="",TypeClass="";
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int time_interval = 2000;
    private AdapterStudent adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        toolbar = (Toolbar) findViewById(R.id.ToolBarNote);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.my_menu);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Term = extras.getString("Term");
            Class=extras.getString("Class");
            Kind=extras.getString("Kind");
            Base=extras.getString("Base");
            TypeClass=extras.getString("Type");
            SharedPreferences pref = getApplicationContext().getSharedPreferences("Note", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("Term", Term); // Storing string
            editor.putString("Class", Class); // Storing string
            editor.commit(); // commit changes
            SharedPreferences pref2 = getApplicationContext().getSharedPreferences("SchoolNote", 0); // 0 - for private mode
            SharedPreferences.Editor editor2 = pref2.edit();
            editor2.putString("Base", Base); // Storing string
            editor2.putString("TypeClass", TypeClass); // Storing string
            editor2.putString("Kind", Kind); // Storing string
            editor2.commit(); // commit changes
        }
        AdapterStudent viewPagerAdapter = new AdapterStudent(Note.this.getSupportFragmentManager());
        viewPagerAdapter.getItem(1);
        tabLayout = (TabLayout) findViewById(R.id.MainPageStudent_TabLayout);
        viewPager = (ViewPager) findViewById(R.id.MainPageStudent_ViewPager);
        adapter = new AdapterStudent(Note.this.getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        final TabLayout.Tab tab0 = tabLayout.newTab();
        final TabLayout.Tab tab1 = tabLayout.newTab();
        final TabLayout.Tab tab2 = tabLayout.newTab();
        tab0.setIcon(R.drawable.note);
        tab1.setIcon(R.drawable.icon_noti);
        tabLayout.addTab(tab0, 0);
        tabLayout.addTab(tab1, 1);
        tabLayout.setTabTextColors(ContextCompat.getColorStateList(Note.this, R.color.Yellow));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(Note.this, R.color.backgroundHaderColor));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0: {
                        tab0.setIcon(R.drawable.note);
                        tab1.setIcon(R.drawable.icon_noti);
                        AdapterStudent viewPagerAdapter = new AdapterStudent(Note.this.getSupportFragmentManager());
                        viewPagerAdapter.getItem(0);
                        break;
                    }
                    case 1: {
                        tab0.setIcon(R.drawable.note);
                        tab1.setIcon(R.drawable.icon_noti);
                        AdapterStudent viewPagerAdapter = new AdapterStudent(Note.this.getSupportFragmentManager());
                        viewPagerAdapter.getItem(1);
                        break;
                    }


                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }




}
