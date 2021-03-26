package com.example.musicapplication.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.example.musicapplication.R;
import com.example.musicapplication.constants.Constant;
import com.example.musicapplication.utils.UserUtil;
import com.example.musicapplication.views.InputView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 注册页面
 */
public class RegisterActivity extends BaseActivity {

    private InputView phoneView;
    private InputView pwdView;
    private InputView confirmPwdView;
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
        initNavBar(true, Constant.REGISTER, false);
        phoneView = fd(R.id.input_phone);
        pwdView = fd(R.id.input_password);
        confirmPwdView = fd(R.id.confirm_input_password);
    }

    /**
     * 注册
     *
     * @param view
     */
    public void register(View view) {

        boolean register = UserUtil.register(phoneView.getInputText(),
                pwdView.getInputText(),
                confirmPwdView.getInputText());
        if (register) {
            Context context = this;
            ToastUtils.showLong("注册成功，请登录");
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    UserUtil.logout(context);
                }
            }, 800);
        }
    }
}