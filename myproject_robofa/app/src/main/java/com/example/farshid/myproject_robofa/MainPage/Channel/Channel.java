package com.example.farshid.myproject_robofa.MainPage.Channel;

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

import com.example.farshid.myproject_robofa.R;


public class Channel extends Fragment {
    View view;
    Button channelAdult, channelChild, channelNoti;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int time_interval = 2000;
    private long oldCurrentTimeMillis;
    private Channel_ViewPagerTablayout adapter;
    ActionBarDrawerToggle drawerToggle;
    NavigationView Profile_navView;
    CoordinatorLayout coordinatorLayout;
    String UserName = "", Password = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_channel, container, false);
        tabLayout = (TabLayout) view.findViewById(R.id.MainPageTeacher_TabLayout2);
        viewPager = (ViewPager) view.findViewById(R.id.MainPageTeacher_ViewPager2);
        adapter = new Channel_ViewPagerTablayout(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        final TabLayout.Tab tab0 = tabLayout.newTab();
        final TabLayout.Tab tab1 = tabLayout.newTab();
        final TabLayout.Tab tab2 = tabLayout.newTab();
        tab0.setIcon(R.drawable.icon_child);
        tab1.setIcon(R.drawable.icons_brain);
        tab2.setIcon(R.drawable.icon_noti);
//        tab0.setIcon(R.drawable.note);
//        tab1.setIcon(R.drawable.question);
        tabLayout.addTab(tab0, 0);
        tabLayout.addTab(tab1, 1);
        tabLayout.addTab(tab2, 2);
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
                        tab0.setIcon(R.drawable.icon_child);
                        tab1.setIcon(R.drawable.icons_brain);
                        tab2.setIcon(R.drawable.icon_noti);
                        Channel_ViewPagerTablayout viewPagerAdapter = new Channel_ViewPagerTablayout(getActivity().getSupportFragmentManager());
                        viewPagerAdapter.getItem(0);
                        break;
                    }
                    case 1: {
                        tab0.setIcon(R.drawable.icon_child);
                        tab1.setIcon(R.drawable.icons_brain);
                        tab2.setIcon(R.drawable.icon_noti);
                        Channel_ViewPagerTablayout viewPagerAdapter = new Channel_ViewPagerTablayout(getActivity().getSupportFragmentManager());
                        viewPagerAdapter.getItem(1);
                        break;
                    }
                    case 2: {
                        tab0.setIcon(R.drawable.icon_child);
                        tab1.setIcon(R.drawable.icons_brain);
                        tab2.setIcon(R.drawable.icon_noti);
                        Channel_ViewPagerTablayout viewPagerAdapter = new Channel_ViewPagerTablayout(getActivity().getSupportFragmentManager());
                        viewPagerAdapter.getItem(2);
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
