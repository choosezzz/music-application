package com.example.musicapplication.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author choosezzz
 * @date 3/28/21 1:25 PM
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AlbumModel extends RealmObject {

    /**
     * 专辑id
     */
    private Long albumId;
    /**
     * 专辑名称
     */
    private String name;
    /**
     * 封面图
     */
    private String poster;
    /**
     * 播放量
     */
    private String playNum;

    /**
     * 歌单列表
     */
    private RealmList<MusicModel> list;
}
