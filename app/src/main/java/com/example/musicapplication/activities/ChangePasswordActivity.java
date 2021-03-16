package com.example.musicapplication.activities;

import android.os.Bundle;
import android.view.View;

import com.example.musicapplication.R;
import com.example.musicapplication.constants.Constant;

/**
 * 修改密码
 */
public class ChangePasswordActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        initView();
    }

    private void initView() {
        initNavBar(true, Constant.CHANGE_PASSWORD, true);
    }

    public void changeNewPassword(View view) {

    }
}