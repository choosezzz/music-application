package com.example.musicapplication.activities;

import android.os.Bundle;
import android.view.View;

import com.example.musicapplication.R;
import com.example.musicapplication.constants.Constant;
import com.example.musicapplication.views.InputView;

public class LoginActivity extends BaseActivity {

    private InputView phoneView;
    private InputView pwdView;
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
        initNavBar(false, Constant.LOGIN, false);
        phoneView = fd(R.id.input_phone);
        pwdView = fd(R.id.input_password);
    }

    /**
     * 跳转注册页面
     */
    public void toRegister(View view) {
        toActivity(RegisterActivity.class, false);
    }

    /**
     * 登录
     * @param view
     */
    public void login(View view) {

//        if (!UserUtil.validateLogin(phoneView.getInputText(), pwdView.getInputText())) {
//            return;
//        }
        toActivity(MainActivity.class, true);
    }
}