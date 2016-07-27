package com.qq.qzone.a133689237.daxue;

import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Fragment_main extends Fragment implements View.OnClickListener {

    Toolbar mToolbar;
    public TextView shuText;
    public FrameLayout big_watch_di;
    public LinearLayout big_watch;
    public Button choose_Button;

    public static Fragment newInstance(){
        return new Fragment_main();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        Fragment_wlcome.zhuangtailanColor(getActivity(), "#10142d");
        shuText= (TextView) view.findViewById(R.id.shu_textView);
        big_watch_di = (FrameLayout) view.findViewById(R.id.big_watch_di);
        big_watch = (LinearLayout) view.findViewById(R.id.big_watch);
        choose_Button = (Button) view.findViewById(R.id.chose_daji_button);

        mToolbar = (Toolbar) view.findViewById(R.id.my_toolbar);
        ( (AppCompatActivity) getActivity() ).setSupportActionBar(mToolbar);
        mToolbar.setTitleTextColor(Color.parseColor("#FAFAFA"));
        mToolbar.setTitle("");

        choose_Button.setOnClickListener(this);

        startAnimator();

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.tool_bar_menu, menu);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onClick(View v) {
        switch ( v.getId() ){
            case R.id.chose_daji_button :
                dia_Choose_daji dialog = new dia_Choose_daji();
                FragmentManager fm = getActivity().getFragmentManager();
                dialog.show(fm, "CHOOSE_DAJI");
                break;
        }
    }

    private void startAnimator(){

        ObjectAnimator TeovAnimator = ObjectAnimator
                .ofFloat(shuText, "translationY", shuText.getBottom()+50, shuText.getBottom())
                .setDuration(900);
        ObjectAnimator ShualpAnimator = ObjectAnimator.ofFloat(shuText, "alpha", 0.3f, 1f)
                .setDuration(900);

        ObjectAnimator dialpAnimator = ObjectAnimator.ofFloat(big_watch_di, "alpha", 0.2f, 1f)
                .setDuration(1000);
        ObjectAnimator watchsuoXAnimator = ObjectAnimator.ofFloat(big_watch, "scaleX", 0.1f, 1f)
                .setDuration(900);
        ObjectAnimator watchsuoYAnimator = ObjectAnimator.ofFloat(big_watch, "scaleY", 0.1f, 1f)
                .setDuration(900);

        ObjectAnimator ButtonsuoXAnimator = ObjectAnimator.ofFloat(choose_Button, "scaleX", 0.1f, 1f)
                .setDuration(400);
        ObjectAnimator ButtonsuoYAnimator = ObjectAnimator.ofFloat(choose_Button, "scaleY", 0.1f, 1f)
                .setDuration(400);

        ButtonsuoXAnimator.start();
        ButtonsuoYAnimator.start();
        dialpAnimator.start();
        watchsuoXAnimator.start();
        watchsuoYAnimator.start();
        ShualpAnimator.start();
        TeovAnimator.start();
    }

}

