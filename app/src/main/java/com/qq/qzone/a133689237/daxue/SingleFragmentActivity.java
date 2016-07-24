package com.qq.qzone.a133689237.daxue;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    public abstract Fragment CreateFragment_welcome();
    public abstract Fragment CreateFragment_main();
    public FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.acitvity_fragment_single);
        fm = getFragmentManager();

        new Thread(new Runnable() {
            @Override
            public void run() {
                fm.beginTransaction().add(R.id.fragment_container, CreateFragment_welcome())
                        .commit();

                try { Thread.sleep(3000); } catch (Exception e) { }
                fm.beginTransaction().replace(R.id.fragment_container, CreateFragment_main())
                        .commit();
            }
        }).start();

    }

}
