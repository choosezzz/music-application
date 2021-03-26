package com.example.musicapplication.helpers;

import android.util.Log;

import com.blankj.utilcode.util.EncryptUtils;
import com.example.musicapplication.constants.RealmConstant;
import com.example.musicapplication.models.UserModel;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;

/**
 * @author choosezzz
 * @date 3/24/21 9:38 PM
 */
public class RealmHelper {

    private Realm realm;

    private RealmHelper() {
        this.realm = Realm.getDefaultInstance();
    }

    public static RealmHelper getRealmHelper() {
        return new RealmHelper();
    }
    public void saveUser(UserModel userModel) {
        realm.beginTransaction();
        realm.insert(userModel);
        realm.commitTransaction();

    }

    public UserModel getUserByPhone(String phone) {
        RealmQuery<UserModel> query = realm.where(UserModel.class);
        UserModel user = query.equalTo(RealmConstant.USER_PHONE, phone).findFirst();
        return user;
    }
    public UserModel getUser(String phone, String password) {
        RealmQuery<UserModel> query = realm.where(UserModel.class);
        UserModel user = query.equalTo(RealmConstant.USER_PHONE, phone).equalTo(RealmConstant.USER_PASSWORD, EncryptUtils.encryptMD5ToString(password)).findFirst();
        return user;
    }

    public void updateUserPassword(String phone, String password) {
        UserModel user = getUserByPhone(phone);
        realm.beginTransaction();
        user.setPassword(EncryptUtils.encryptMD5ToString(password));
        realm.commitTransaction();
    }

    public void deleteUserByPhone(String phone) {
        UserModel user = getUserByPhone(phone);
        realm.beginTransaction();
        user.deleteFromRealm();
        realm.commitTransaction();
    }
    public void close() {
        if (realm != null && !realm.isClosed()) {
            realm.close();
        }
    }
}
