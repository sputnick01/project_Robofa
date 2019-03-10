package com.example.farshid.myproject_robofa.TabStudent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by farshid on 11/8/2018.
 */

public class AdapterStudent extends FragmentStatePagerAdapter {
    public AdapterStudent(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                return new tabNoteStudent();
            case 1:
                return new TabQouestion();

        }
        return new tabNoteStudent();
    }

    @Override
    public int getCount() {
        return 2 ;
    }
}
