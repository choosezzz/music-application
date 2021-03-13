package com.example.musicapplication.activities;

import android.os.Bundle;

import com.example.musicapplication.R;

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
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
//                toMain();
                toLogin();
            }
        }, 1000);
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