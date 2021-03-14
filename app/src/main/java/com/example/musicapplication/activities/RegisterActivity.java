package com.example.musicapplication.activities;

import android.os.Bundle;
import android.view.View;

import com.example.musicapplication.R;
import com.example.musicapplication.utils.UserUtil;
import com.example.musicapplication.views.InputView;

/**
 * 注册页面
 */
public class RegisterActivity extends BaseActivity {

    private InputView phoneView;
    private InputView pwdView;
    private InputView pwdViewAgain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    /**
     * 初始化登录页面View
     */
    private void initView() {
        initNavBar(false, "注册", false);
        phoneView = fd(R.id.input_phone);
        pwdView = fd(R.id.input_password);
        pwdViewAgain = fd(R.id.input_password_again);
    }

    /**
     * 跳转注册页面
     */
    public void toLogin(View view) {
        toActivity(LoginActivity.class, true);
    }

    /**
     * 注册
     *
     * @param view
     */
    public void register(View view) {

        if (!UserUtil.validateRegister(phoneView.getInputText(),
                pwdView.getInputText(),
                pwdViewAgain.getInputText())) {
            return;
        }
        toActivity(MainActivity.class, true);
    }
}