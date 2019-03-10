package com.example.farshid.myproject_robofa.MainPage.Channel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.farshid.myproject_robofa.MainPage.Channel.Adult.Adult;
import com.example.farshid.myproject_robofa.MainPage.Channel.MYChildren.Children;
import com.example.farshid.myproject_robofa.MainPage.Channel.Notification.Notifications;

/**
 * Created by farshid on 11/15/2018.
 */

public class Channel_ViewPagerTablayout extends FragmentStatePagerAdapter {
    public Channel_ViewPagerTablayout(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 2:
                return new Notifications();
            case 1:
                return new Adult();
            case 0:
                return new Children();
        }
        return new Adult();


    }

    @Override
    public int getCount() {
        return 3;
    }
}
