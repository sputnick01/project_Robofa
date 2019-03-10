package com.example.farshid.myproject_robofa.Teacher.PageTeacher;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.farshid.myproject_robofa.R;

public class PageTeacher extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Adapter_MainPageTeacher adapter;
    String UserName = "", Password = "",KindUser="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_teacher);
        TextView title_pageTeacher= (TextView) findViewById(R.id.title_pageTeacher);
        Typeface tf = Typeface.createFromAsset(getAssets(), "font/irsans.ttf");
        title_pageTeacher.setTypeface(tf);
        Adapter_MainPageTeacher viewPagerAdapter = new Adapter_MainPageTeacher(PageTeacher.this.getSupportFragmentManager());
        viewPagerAdapter.getItem(1);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            UserName = extras.getString("UserName");
            Password = extras.getString("Password");
            KindUser = extras.getString("KindUser");
            SharedPreferences pref = getApplicationContext().getSharedPreferences("User", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("UserName", UserName); // Storing string
            editor.putString("Password", Password); // Storing string
            editor.putString("KindUser", KindUser);
            editor.commit(); // commit changes
        }

        tabLayout = (TabLayout) findViewById(R.id.MainPageTeacher_TabLayout);
        viewPager = (ViewPager) findViewById(R.id.MainPageTeacher_ViewPager);
        adapter = new Adapter_MainPageTeacher(PageTeacher.this.getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        final TabLayout.Tab tab0 = tabLayout.newTab();
        final TabLayout.Tab tab1 = tabLayout.newTab();
        final TabLayout.Tab tab2 = tabLayout.newTab();
        final TabLayout.Tab tab3 = tabLayout.newTab();
//        tab0.setText("یادداشت ها");
//        tab3.setText("دانش آموزان");
//        tab2.setText("پیام ها");
//        tab1.setText("اطلاعیه");
        tab0.setIcon(R.drawable.note);
        tab3.setIcon(R.drawable.icon_student);
        tab2.setIcon(R.drawable.icon_massege);
        tab1.setIcon(R.drawable.icon_noti);
        tabLayout.addTab(tab0, 0);
        tabLayout.addTab(tab1, 1);
        tabLayout.addTab(tab2, 2);
        tabLayout.addTab(tab3, 3);
        tabLayout.setTabTextColors(ContextCompat.getColorStateList(PageTeacher.this, R.color.TextColor2));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(PageTeacher.this, R.color.Yellow));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0: {
//                        tab0.setText("یادداشت ها");
//                        tab1.setText("سوالات");
                        tab0.setIcon(R.drawable.note);
                        tab3.setIcon(R.drawable.icon_student);
                        tab2.setIcon(R.drawable.icon_massege);
                        tab1.setIcon(R.drawable.icon_noti);
                        Adapter_MainPageTeacher viewPagerAdapter = new Adapter_MainPageTeacher(PageTeacher.this.getSupportFragmentManager());
                        viewPagerAdapter.getItem(0);
                        break;
                    }
                    case 1: {
//                        tab0.setText("یادداشت ها");
//                        tab1.setText("سوالات");
                        tab0.setIcon(R.drawable.note);
                        tab3.setIcon(R.drawable.icon_student);
                        tab2.setIcon(R.drawable.icon_massege);
                        tab1.setIcon(R.drawable.icon_noti);
                        Adapter_MainPageTeacher viewPagerAdapter = new Adapter_MainPageTeacher(PageTeacher.this.getSupportFragmentManager());
                        viewPagerAdapter.getItem(1);
                        break;
                    }
                    case 2: {
//                        tab0.setText("یادداشت ها");
//                        tab1.setText("سوالات");
                        tab0.setIcon(R.drawable.note);
                        tab3.setIcon(R.drawable.icon_student);
                        tab2.setIcon(R.drawable.icon_massege);
                        tab1.setIcon(R.drawable.icon_noti);
                        Adapter_MainPageTeacher viewPagerAdapter = new Adapter_MainPageTeacher(PageTeacher.this.getSupportFragmentManager());
                        viewPagerAdapter.getItem(2);
                        break;
                    }
                    case 3: {
//                        tab0.setText("یادداشت ها");
//                        tab1.setText("سوالات");

                        tab0.setIcon(R.drawable.note);
                        tab3.setIcon(R.drawable.icon_student);
                        tab2.setIcon(R.drawable.icon_massege);
                        tab1.setIcon(R.drawable.icon_noti);
                        Adapter_MainPageTeacher viewPagerAdapter = new Adapter_MainPageTeacher(PageTeacher.this.getSupportFragmentManager());
                        viewPagerAdapter.getItem(3);
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
