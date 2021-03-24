package com.example.musicapplication;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

import io.realm.Realm;

/**
 * @author choosezzz
 * @date 3/13/21 2:53 PM
 *
 * 在AndroidManifest.xml中注册
 * android:name=".MyApplication"
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        Realm.init(this);
    }
}
