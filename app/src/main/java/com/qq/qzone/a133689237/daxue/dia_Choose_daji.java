package com.qq.qzone.a133689237.daxue;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class dia_Choose_daji extends DialogFragment implements View.OnTouchListener {

    private Button mButton;
    public ListView mListView;
    private String[] strs = new String[] { "大一", "大二", "大三", "大四" };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_choose_daji, container);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        mListView = (ListView) view.findViewById(R.id.dialog_list_view);
        mButton = (Button) view.findViewById(R.id.dialog_daji_button);

        mListView.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.dialog_listview_item,strs) );
        mListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        mButton.setOnTouchListener(this);
        return view;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        mButton.setBackgroundColor(Color.parseColor("#303f9f"));
        sendResult(Activity.RESULT_OK);
        dismiss();
        return true;
    }

    private void sendResult(int resultCode) {
        if (getTargetFragment() == null)       return;
        Intent intent = new Intent();
        int daji = mListView.getCheckedItemPosition() + 1;
        if(ListView.INVALID_POSITION != daji){
            intent.putExtra("DAJI", daji);
        }
        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }

}
