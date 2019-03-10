package com.example.farshid.myproject_robofa.MainPage.Camera;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.farshid.myproject_robofa.MainPage.Channel.Channel_ViewPagerTablayout;
import com.example.farshid.myproject_robofa.R;

/**
 * Created by farshid on 10/21/2018.
 */

public class Camera extends Fragment{
    View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Adapter_Camera adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_camera, container, false);
        tabLayout = (TabLayout) view.findViewById(R.id.CameraTabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.Camera_ViewPager);
        adapter = new Adapter_Camera(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        final TabLayout.Tab tab0 = tabLayout.newTab();
        final TabLayout.Tab tab1 = tabLayout.newTab();
        final TabLayout.Tab tab2 = tabLayout.newTab();
        tab0.setText("پست ها");
        tab1.setText("درج پست");
//        tab2.setText("اطلاعیه");
//        tab0.setIcon(R.drawable.note);
//        tab1.setIcon(R.drawable.question);
        tabLayout.addTab(tab0, 0);
        tabLayout.addTab(tab1, 1);
//        tabLayout.addTab(tab2, 2);
        tabLayout.setTabTextColors(ContextCompat.getColorStateList(getActivity(), R.color.White));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(getActivity(), R.color.Yellow));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0: {
                        tab0.setText("پست ها");
                        tab1.setText("درج پست");
                        Adapter_Camera viewPagerAdapter = new Adapter_Camera(getActivity().getSupportFragmentManager());
                        viewPagerAdapter.getItem(0);
                        break;
                    }
                    case 1: {
                        tab0.setText("پست ها");
                        tab1.setText("درج پست");
                        Adapter_Camera viewPagerAdapter = new Adapter_Camera(getActivity().getSupportFragmentManager());
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
        return view;
    }
}
