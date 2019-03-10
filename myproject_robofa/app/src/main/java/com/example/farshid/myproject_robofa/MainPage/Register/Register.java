package com.example.farshid.myproject_robofa.MainPage.Register;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.farshid.myproject_robofa.R;

/**
 * Created by farshid on 10/22/2018.
 */

public class Register extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_register, container, false);
        return view;
    }
}
