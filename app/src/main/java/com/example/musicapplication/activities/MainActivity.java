package com.example.musicapplication.activities;

import android.os.Bundle;

import com.example.musicapplication.R;
import com.example.musicapplication.constants.Constant;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        initNavBar(false, Constant.MAIN_TITLE, true);
    }
}