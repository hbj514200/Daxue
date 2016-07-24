package com.qq.qzone.a133689237.daxue;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_wlcome extends Fragment {

    public static Fragment_wlcome newInstance() {
        return new Fragment_wlcome();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        return view;
    }

}
