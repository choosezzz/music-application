package com.example.musicapplication.activities;

import android.os.Bundle;

import com.example.musicapplication.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        initNavBar(true, "我的音乐", true);
    }
}