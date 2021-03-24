package com.example.musicapplication.activities;

import android.os.Bundle;
import android.view.View;

import com.example.musicapplication.R;
import com.example.musicapplication.constants.Constant;
import com.example.musicapplication.utils.UserUtil;
import com.example.musicapplication.views.InputView;

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
            toActivity(MainActivity.class, true);
        }
    }
}