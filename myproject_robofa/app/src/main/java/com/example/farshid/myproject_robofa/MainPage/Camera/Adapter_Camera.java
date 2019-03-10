package com.example.farshid.myproject_robofa.MainPage.Camera;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.farshid.myproject_robofa.MainPage.Camera.Allimage.Tab_AllImage;
import com.example.farshid.myproject_robofa.MainPage.Channel.Adult.Adult;

/**
 * Created by farshid on 12/11/2018.
 */

public class Adapter_Camera extends FragmentStatePagerAdapter {
    public Adapter_Camera(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 1:
                return new Tab_MyImage();
            case 0:
                return new Tab_AllImage();
        }
        return new Adult();


    }

    @Override
    public int getCount() {
        return 2;
    }
}
