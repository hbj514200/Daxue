package com.qq.qzone.a133689237.daxue;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    public abstract Fragment CreateFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_fragment_single);

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.fragment_container, CreateFragment())
                .commit();
    }

}
