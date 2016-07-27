package com.qq.qzone.a133689237.daxue;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class Fragment_wlcome extends Fragment {

    public static Fragment newInstance() {
        return new Fragment_wlcome();
    }
    private ImageView mImageView;
    private TextView mTexttView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        zhuangtailanColor(getActivity(), "#10142d");

        mImageView = (ImageView) view.findViewById(R.id.welcome_zhuan_image);
        mTexttView = (TextView) view.findViewById(R.id.welcome_text);
        startAnimation();

        return view;
    }

    private void startAnimation() {

        ObjectAnimator ImoveAnimator = ObjectAnimator.ofFloat(mImageView, "rotation", 0, 720)
                .setDuration(3000);
        ObjectAnimator ImalpAnimator = ObjectAnimator.ofFloat(mImageView, "alpha", 0.1f, 1f)
                .setDuration(3000);

        ObjectAnimator TeoveAnimator = ObjectAnimator
                .ofFloat(mTexttView, "translationY", mTexttView.getBottom()+50, mTexttView.getBottom())
                .setDuration(3000);
        ObjectAnimator TealpAnimator = ObjectAnimator.ofFloat(mTexttView, "alpha", 0.1f, 1f)
                .setDuration(3000);

        ImoveAnimator.start();
        ImalpAnimator.start();
        TeoveAnimator.start();
        TealpAnimator.start();
    }

    public static void zhuangtailanColor(Activity activity, String color){
        if (Build.VERSION.SDK_INT < 21) return;
        Window window = activity.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor(color));

        ViewGroup mContentView = (ViewGroup) activity.findViewById(Window.ID_ANDROID_CONTENT);
        View mChildView = mContentView.getChildAt(0);
        if (mChildView != null) {
                ViewCompat.setFitsSystemWindows(mChildView, true);
            }

    }

}
