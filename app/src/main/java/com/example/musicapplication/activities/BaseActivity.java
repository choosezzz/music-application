package com.example.musicapplication.activities;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.IdRes;

import com.example.musicapplication.R;

/**
 * @author choosezzz
 * @date 3/13/21 2:57 PM
 * 全局Activity的父类
 */
public class BaseActivity extends Activity {

    private ImageView backView;
    private ImageView userView;
    private TextView titleView;

    protected <T extends View> T fd(@IdRes int id) {
        return findViewById(id);
    }

    /**
     * 跳转指定activity
     *
     * @param activity
     * @param close    是否关闭当前
     */
    protected void toActivity(Class<?> activity, boolean close) {

        Intent intent = new Intent(this, activity);
        startActivity(intent);
        if (close) {
            finish();
        }
    }

    /**
     * 初始化nav bar
     *
     * @param showBack
     * @param title
     * @param showUser
     */
    protected void initNavBar(boolean showBack, String title, boolean showUser) {
        titleView = fd(R.id.nav_title);
        backView = fd(R.id.nac_back);
        userView = fd(R.id.nav_user_center);
        titleView.setText(title);
        backView.setVisibility(showBack ? View.VISIBLE : View.INVISIBLE);
        userView.setVisibility(showUser ? View.VISIBLE : View.INVISIBLE);
        backView.setOnClickListener(v -> onBackPressed());
    }
}
