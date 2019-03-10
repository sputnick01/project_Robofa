package com.example.farshid.myproject_robofa.Teacher.PageTeacher;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.farshid.myproject_robofa.Teacher.InsertNote.Tab_InserNote;
import com.example.farshid.myproject_robofa.Teacher.Insert_noti.Tab_Noti;
import com.example.farshid.myproject_robofa.Teacher.SearchStudent.TabAnsverToQuestion;
import com.example.farshid.myproject_robofa.Teacher.ShowAllForTeacher.Tab_ShowAllForTeacher;

/**
 * Created by farshid on 11/7/2018.
 */

public class Adapter_MainPageTeacher extends FragmentStatePagerAdapter {
    public Adapter_MainPageTeacher(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 3:
                return new TabAnsverToQuestion();
            case 0:
                return new Tab_InserNote();
            case 2:
                return new Tab_ShowAllForTeacher();
            case 1:
                return new Tab_Noti();
        }
        return new Tab_InserNote();


    }

    @Override
    public int getCount() {
        return 4 ;
    }
}
