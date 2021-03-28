package com.example.musicapplication.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author choosezzz
 * @date 3/28/21 1:23 PM
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class MusicSourceModel extends RealmObject {

    /**
     * 推荐歌单
     */
    private RealmList<AlbumModel> album;

    /**
     * 热歌列表
     */
    private RealmList<MusicModel> hot;

}
