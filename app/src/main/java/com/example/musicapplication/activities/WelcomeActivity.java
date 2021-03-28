package com.example.musicapplication.activities;

import android.content.Context;
import android.os.Bundle;

import com.blankj.utilcode.util.RegexUtils;
import com.example.musicapplication.R;
import com.example.musicapplication.utils.UserUtil;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        init();
    }
    private void init() {

        Context context = this;
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                String userCache = UserUtil.getUserCache(context);
                if (RegexUtils.isMobileExact(userCache)) {
                    toMain();
                }else {
                    toLogin();
                }
            }
        }, 500);
    }

    /**
     * 跳转到主界面
     */
    private void toMain() {
        toActivity(MainActivity.class, true);
    }

    /**
     * 跳转login
     */
    private void toLogin() {
        toActivity(LoginActivity.class, true);
    }
}