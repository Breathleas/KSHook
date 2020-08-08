package com.example.socketdemo.util;

import android.app.Activity;
import android.widget.TextView;

public class GlobleParam {
    private static volatile GlobleParam mInstance = null;


    private String firstStr;
    private Activity activity;
    private TextView textView;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public String getFirstStr() {
        return firstStr;
    }
    public void setFirstStr(String firstStr) {
        this.firstStr = firstStr;
    }


    private GlobleParam(){}
    public static GlobleParam getInstance(){
        if (mInstance == null){
            synchronized (GlobleParam.class){
                if (mInstance == null){
                    mInstance = new GlobleParam();
                }
            }
        }
        return mInstance;
    }
}
