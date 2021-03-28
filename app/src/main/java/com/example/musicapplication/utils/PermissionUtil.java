package com.example.musicapplication.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author choosezzz
 * @date 3/27/21 9:04 PM
 */
public class PermissionUtil {

    /**
     * 文件读权限
     */
    public static String READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    /**
     * 文件写权限
     */
    public static String WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;

    /**
     * 动态申请权限
     * Android6.0以上
     *
     * @param activity
     * @param permission
     */
    public static void getPermissions(Activity activity, String... permission) {

        List<String> permissions = new ArrayList<>();
        //此处做动态权限申请
        //判断系统是否大于等于Android 6.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (int i = 0; i < permission.length; i++) {
                int request = ContextCompat.checkSelfPermission(activity, permission[i]);
                //判断是否未获取权限
                if (request != PackageManager.PERMISSION_GRANTED)
                    permissions.add(permission[i]);
            }
            //缺少权限，进行权限申请
            if (permissions.size() > 0) {
                //当前上下文;一个权限数组;一个唯一的请求码(0~65535的16位数)
                ActivityCompat.requestPermissions(activity, permissions.toArray(new String[permissions.size()]), 0XFF);
            }
        }
    }

}
