package com.example.musicapplication.helpers;

import android.content.Context;
import android.util.Log;

import com.blankj.utilcode.util.EncryptUtils;
import com.example.musicapplication.R;
import com.example.musicapplication.constants.Constant;
import com.example.musicapplication.constants.RealmConstant;
import com.example.musicapplication.models.AlbumModel;
import com.example.musicapplication.models.MusicModel;
import com.example.musicapplication.models.MusicSourceModel;
import com.example.musicapplication.models.UserModel;
import com.example.musicapplication.utils.DataUtil;

import java.io.FileNotFoundException;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmQuery;
import io.realm.RealmSchema;

/**
 * @author choosezzz
 * @date 3/24/21 9:38 PM
 */
public class RealmHelper {

    private Realm realm;

    private RealmHelper() {
        this.realm = Realm.getDefaultInstance();
    }

    public static void initRealm(Context context) {
        Realm.init(context);
        RealmConfiguration configuration = getConfiguration();
        Realm.setDefaultConfiguration(configuration);
        try {
            Realm.migrateRealm(configuration);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static RealmConfiguration getConfiguration() {

        return new RealmConfiguration.Builder()
                .schemaVersion(RealmConstant.SCHEMA_VERSION)
                //数据迁移
                .migration((realm, oldVersion, newVersion) -> {
                    RealmSchema schema = realm.getSchema();
                    if (oldVersion == RealmConstant.SCHEMA_DEFAULT_VERSION) {

                        schema.create("MusicModel")
                                .addField("musicId", Long.class)
                                .addField("name", String.class)
                                .addField("poster", String.class)
                                .addField("path", String.class)
                                .addField("artist", String.class)
                                .addField("duration", Long.class)
                                .addField("commentThreadId", String.class);
                        schema.create("AlbumModel")
                                .addField("albumId", Long.class)
                                .addField("name", String.class)
                                .addField("poster", String.class)
                                .addField("playNum", String.class)
                                .addRealmListField("list", schema.get("MusicModel"));
                        schema.create("MusicSourceModel")
                                .addRealmListField("album", schema.get("AlbumModel"))
                                .addRealmListField("hot", schema.get("MusicModel"));

                        oldVersion = newVersion;
                    }
                })
                .build();
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

    public void setMusicSource(String jsonFile) {
        realm.beginTransaction();
        realm.createObjectFromJson(MusicSourceModel.class, jsonFile);
        realm.commitTransaction();
    }

    public void removeMusicSource() {
        realm.beginTransaction();
        realm.delete(MusicSourceModel.class);
        realm.delete(AlbumModel.class);
        realm.delete(MusicModel.class);
        realm.commitTransaction();
    }

    public MusicSourceModel getMusicSource() {
        RealmQuery<MusicSourceModel> query = realm.where(MusicSourceModel.class);
        return query.findFirst();
    }

    public AlbumModel getAlbumById(Long albumId) {
        RealmQuery<AlbumModel> query = realm.where(AlbumModel.class).equalTo(Constant.ALBUM_ID, albumId);
        return query.findFirst();
    }
    public MusicModel getMusicById(Long musicId) {
        RealmQuery<MusicModel> query = realm.where(MusicModel.class).equalTo(Constant.MUSIC_ID, musicId);
        return query.findFirst();
    }
    public void close() {
        if (realm != null && !realm.isClosed()) {
            realm.close();
        }
    }
}
