package com.example.musicapplication.activities;

import android.os.Bundle;
import android.view.View;

import com.example.musicapplication.R;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    /**
     * 初始化登录页面View
     */
    private void initView() {
        initNavBar(false, "登录", false);
    }

    /**
     * 跳转注册页面
     */
    public void toRegister(View view) {
        toActivity(RegisterActivity.class, false);
    }
}