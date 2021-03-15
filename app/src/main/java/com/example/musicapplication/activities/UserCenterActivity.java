package com.example.musicapplication.activities;

import android.os.Bundle;
import android.view.View;

import com.example.musicapplication.R;
import com.example.musicapplication.utils.UserUtil;

public class UserCenterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_center);
    }

    private void initView() {
        initNavBar(true, "个人中心", false);
    }

    /**
     * 修改密码
     * @param view
     */
    public void changePassword(View view) {

    }

    /**
     * 退出登录
     * @param view
     */
    public void logout(View view) {
        UserUtil.logout(this);
        toActivity(LoginActivity.class, true);
    }
}