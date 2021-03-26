package com.example.musicapplication;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.example.musicapplication.helpers.RealmHelper;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * @author choosezzz
 * @date 3/13/21 2:53 PM
 *
 * 在AndroidManifest.xml中注册
 * android:name=".MyApplication"
 */
public class MyApplication extends Application {

    private static byte[] key = "111111111111111111111111111111111111111111111111111111111111111".getBytes();
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        Realm.init(this);
    }
}
