package com.example.farshid.myproject_robofa.MainPage.Channel;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.farshid.myproject_robofa.R;

public class MyChannel extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int time_interval = 2000;
    private long oldCurrentTimeMillis;
    private Channel_ViewPagerTablayout adapter;
    ActionBarDrawerToggle drawerToggle;
    NavigationView Profile_navView;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_channel);
//        Channel_ViewPagerTablayout viewPagerAdapter = new Channel_ViewPagerTablayout(MyChannel.this.getSupportFragmentManager());
//        viewPagerAdapter.getItem(1);
//        tabLayout = (TabLayout) findViewById(R.id.MainPageNav_TabLayout);
//        viewPager = (ViewPager) findViewById(R.id.MainPageNav_ViewPager);
//        adapter = new Channel_ViewPagerTablayout(MyChannel.this.getSupportFragmentManager());
//        viewPager.setAdapter(adapter);
//        final TabLayout.Tab tab0 = tabLayout.newTab();
//        final TabLayout.Tab tab1 = tabLayout.newTab();
//        final TabLayout.Tab tab2 = tabLayout.newTab();
//        tab0.setText("کودک");
//        tab1.setText("نوجوان");
//        tab2.setText("بزرگسال");
//        tabLayout.addTab(tab0, 0);
//        tabLayout.addTab(tab1, 1);
//        tabLayout.addTab(tab2, 2);
//        tabLayout.setTabTextColors(ContextCompat.getColorStateList(MyChannel.this, R.color.Yellow));
//        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(MyChannel.this, R.color.backgroundHaderColor));
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                switch (position) {
//                    case 0: {
//                        tab0.setText("کودک");
//                        tab1.setText("نوجوان");
//                        tab2.setText("بزرگسال");
//                        ViewPager_Tablayout viewPagerAdapter = new ViewPager_Tablayout(MyChannel.this.getSupportFragmentManager());
//                        viewPagerAdapter.getItem(0);
//                        break;
//                    }
//                    case 1: {
//                        tab0.setText("کودک");
//                        tab1.setText("نوجوان");
//                        tab2.setText("بزرگسال");
//                        ViewPager_Tablayout viewPagerAdapter = new ViewPager_Tablayout(MyChannel.this.getSupportFragmentManager());
//                        viewPagerAdapter.getItem(1);
//                        break;
//                    }
//                    case 2: {
//                        tab0.setText("کودک");
//                        tab1.setText("نوجوان");
//                        tab2.setText("بزرگسال");
//                        ViewPager_Tablayout viewPagerAdapter = new ViewPager_Tablayout(MyChannel.this.getSupportFragmentManager());
//                        viewPagerAdapter.getItem(2);
//                        break;
//                    }
//
//                }
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
    }
}
