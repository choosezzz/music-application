package com.example.musicapplication.helpers;

import com.example.musicapplication.models.UserModel;

import io.realm.Realm;

/**
 * @author choosezzz
 * @date 3/24/21 9:38 PM
 */
public class RealmHelper {

    private Realm realm;

    public RealmHelper() {
        this.realm = Realm.getDefaultInstance();
    }

    public void saveUser(UserModel userModel) {
        realm.beginTransaction();
        realm.insert(userModel);
        realm.commitTransaction();

    }
    public void close() {
        if (realm != null && !realm.isClosed()) {
            realm.close();
        }
    }
}
