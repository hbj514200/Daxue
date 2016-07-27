package com.qq.qzone.a133689237.daxue;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    public abstract Fragment CreateFragment_welcome();
    public abstract Fragment CreateFragment_main();
    public FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_fragment_single);
        fm = getFragmentManager();

        new Thread(new Runnable() {
            @Override
            public void run() {
                fm.beginTransaction().add(R.id.fragment_container, CreateFragment_welcome())
                        .commit();

                try { Thread.sleep(4500); } catch (Exception e) { }
                fm.beginTransaction().replace(R.id.fragment_container, CreateFragment_main())
                        .commit();

            }
        }).start();

    }

}
