package com.example.musicapplication.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.musicapplication.R;
import com.example.musicapplication.activities.LoginActivity;
import com.example.musicapplication.helpers.RealmHelper;
import com.example.musicapplication.models.UserModel;

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

    public static boolean validateRegister(String phone, String password, String confirmPassword) {

        if (!RegexUtils.isMobileExact(phone)) {
            ToastUtils.showShort("请输入正确的手机号");
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            ToastUtils.showShort("请输入密码");
            return false;
        }

        if (!password.equals(confirmPassword)) {
            ToastUtils.showShort("两次输入密码不一致");
            return false;
        }
        return true;
    }

    /**
     * 退出登录，清空activity栈
     * @param context
     */
    public static void logout(Context context) {

        Intent intent = new Intent(context, LoginActivity.class);
        //仅保留登录activity
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.open_enter, R.anim.open_exit);
    }

    public static boolean changePassword(String oldPwd, String newPwd, String confirmPwd) {
        if (TextUtils.isEmpty(oldPwd)) {
            ToastUtils.showShort("请输入旧密码");
            return false;
        }

        if (TextUtils.isEmpty(newPwd)) {
            ToastUtils.showShort("请输入新密码");
            return false;
        }

        if (TextUtils.isEmpty(newPwd)) {
            ToastUtils.showShort("请输入确认密码");
            return false;
        }

        if (!newPwd.equals(confirmPwd)) {
            ToastUtils.showShort("两次输入密码不一致");
            return false;
        }
        return true;
    }

    /**
     * 注册接口
     * @param phone
     * @param password
     * @return
     */
    public static boolean register(String phone, String password, String confirmPassword) {

        if (validateRegister(phone, password, confirmPassword)) {
            UserModel userModel = new UserModel();
            userModel.setPassword(password);
            userModel.setPhone(phone);
            saveUser(userModel);
            return true;
        }
        return false;
    }

    private static void saveUser(UserModel userModel) {
        RealmHelper realmHelper = new RealmHelper();
        realmHelper.saveUser(userModel);
        realmHelper.close();
    }
}
