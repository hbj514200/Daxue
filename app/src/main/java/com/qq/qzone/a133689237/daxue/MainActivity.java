package com.qq.qzone.a133689237.daxue;


import android.app.Fragment;

public class MainActivity extends SingleFragmentActivity {

    @Override
    public Fragment CreateFragment_welcome() {
        return Fragment_wlcome.newInstance();
    }

    @Override
    public Fragment CreateFragment_main() {
        return Fragment_main.newInstance();
    }

}
