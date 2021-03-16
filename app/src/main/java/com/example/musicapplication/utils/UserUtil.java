package com.example.musicapplication.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.musicapplication.R;
import com.example.musicapplication.activities.LoginActivity;

/**
 * @author choosezzz
 * @date 3/14/21 12:00 PM
 */
public class UserUtil {

    public static boolean validateLogin(String phone, String password) {

        if (!RegexUtils.isMobileExact(phone)) {
            ToastUtils.showShort("请输入正确的手机号");
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            ToastUtils.showShort("请输入密码");
            return false;
        }
        return true;
    }

    public static boolean validateRegister(String phone, String password, String passwordAgain) {

        if (!RegexUtils.isMobileExact(phone)) {
            ToastUtils.showShort("请输入正确的手机号");
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            ToastUtils.showShort("请输入密码");
            return false;
        }

        if (!password.equals(passwordAgain)) {
            ToastUtils.showShort("两次输入密码不一致");
            return false;
        }
        return true;
    }

    public static void logout(Context context) {

        Intent intent = new Intent(context, LoginActivity.class);
        //仅保留登录activity
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.open_enter, R.anim.open_exit);
    }
}
