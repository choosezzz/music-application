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
 * 修改密码
 */
public class ChangePasswordActivity extends BaseActivity {

    private InputView oldPwd;
    private InputView newPwd;
    private InputView confirmPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        initView();
    }

    private void initView() {
        initNavBar(true, Constant.CHANGE_PASSWORD, true);
        oldPwd = fd(R.id.input_old_pwd);
        newPwd = fd(R.id.input_new_password);
        confirmPwd = fd(R.id.confirm_new_password);
    }

    public void changeNewPassword(View view) {
        boolean success = UserUtil.changePassword(this, oldPwd.getInputText(),
                newPwd.getInputText(),
                confirmPwd.getInputText());

        if (success) {
            ToastUtils.showLong("密码修改成功，请重新登录");
            UserUtil.logout(this);
        }
    }
}