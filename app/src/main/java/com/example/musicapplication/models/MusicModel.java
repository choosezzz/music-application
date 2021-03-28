package com.example.musicapplication.models;

import io.realm.RealmObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author choosezzz
 * @date 3/28/21 1:31 PM
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MusicModel extends RealmObject {

    /**
     * id
     */
    private Long musicId;
    /**
     * 歌名
     */
    private String name;
    /**
     * 封面
     */
    private String poster;
    /**
     * 音乐路径
     */
    private String path;
    /**
     * 歌手
     */
    private String artist;
    /**
     * 时长
     */
    private Long duration;
    /**
     * 评论
     */
    private String commentThreadId;
}
