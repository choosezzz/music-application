package com.example.musicapplication.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.blankj.utilcode.util.EncryptUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.musicapplication.R;
import com.example.musicapplication.activities.LoginActivity;
import com.example.musicapplication.constants.Constant;
import com.example.musicapplication.constants.RealmConstant;
import com.example.musicapplication.helpers.RealmHelper;
import com.example.musicapplication.models.UserModel;

/**
 * @author choosezzz
 * @date 3/14/21 12:00 PM
 */
public class UserUtil {

    public static boolean validateLogin(Context context, String phone, String password) {

        if (!RegexUtils.isMobileExact(phone)) {
            ToastUtils.showShort("请输入正确的手机号");
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            ToastUtils.showShort("请输入密码");
            return false;
        }

        RealmHelper instance = RealmHelper.getRealmHelper();
        UserModel user = instance.getUser(phone, password);
        if (user == null) {
            ToastUtils.showShort("用户名或密码错误");
            return false;
        }
        saveUserPreferenceInfo(context, phone);
        return true;
    }

    /**
     * 退出登录，清空activity栈
     *
     * @param context
     */
    public static void logout(Context context) {

        Intent intent = new Intent(context, LoginActivity.class);
        //仅保留登录activity
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.open_enter, R.anim.open_exit);
        deleteUserPreferenceInfo(context);
    }

    public static boolean changePassword(Context context, String oldPwd, String newPwd, String confirmPwd) {
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

        String phone = getUserPreferenceInfo(context);
        deleteUserPreferenceInfo(context);
        RealmHelper realmHelper = RealmHelper.getRealmHelper();
        realmHelper.updateUserPassword(phone, newPwd);
        realmHelper.close();
        return true;
    }

    /**
     * 注册接口
     *
     * @param phone
     * @param password
     * @return
     */
    public static boolean register(String phone, String password, String confirmPassword) {

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

        RealmHelper realmHelper = RealmHelper.getRealmHelper();
        UserModel user = realmHelper.getUserByPhone(phone);
        if (user != null) {
            ToastUtils.showShort("该用户已注册");
            realmHelper.close();
            return false;
        }
        UserModel userModel = new UserModel();
        userModel.setPassword(EncryptUtils.encryptMD5ToString(password));
        userModel.setPhone(phone);
        realmHelper.saveUser(userModel);
        realmHelper.close();
        return true;
    }

    public static String getUserCache(Context context) {
        return getUserPreferenceInfo(context);
    }

    private static void saveUserPreferenceInfo(Context context, String phone) {
        SharedPreferences.Editor edit = context.getSharedPreferences(Constant.USER_PREFERENCE_TAG, context.MODE_PRIVATE).edit();
        edit.putString(Constant.LOGIN_PREFERENCE_KEY, phone);
        edit.commit();
    }

    private static String getUserPreferenceInfo(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.USER_PREFERENCE_TAG, context.MODE_PRIVATE);
        return sharedPreferences.getString(Constant.LOGIN_PREFERENCE_KEY, "-");
    }

    private static void deleteUserPreferenceInfo(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(Constant.USER_PREFERENCE_TAG, context.MODE_PRIVATE).edit();
        edit.remove(Constant.LOGIN_PREFERENCE_KEY);
        edit.commit();
    }
}
