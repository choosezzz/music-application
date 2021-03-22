package com.example.musicapplication.helpers;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.IOException;

import lombok.Getter;
import lombok.Setter;

/**
 * @author choosezzz
 * @date 3/21/21 5:47 PM
 */
public class MediaPlayHelper {

    private static volatile MediaPlayHelper instance;

    private Context context;
    private MediaPlayer mediaPlayer;
    @Getter
    private String path;
    @Setter
    private OnMediaPlayerListener mediaPlayerListener;

    public static MediaPlayHelper getInstance(Context context) {

        if (instance == null) {
            synchronized (MediaPlayHelper.class) {
                if (instance == null) {
                    instance = new MediaPlayHelper(context);
                }
            }
        }
        return instance;
    }
    private MediaPlayHelper(Context context) {
        this.context = context;
        mediaPlayer = new MediaPlayer();
    }

    /**
     * 设置数据源
     * @param path
     */
    public void setPath(String path) {

        //正在播放音乐
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.reset();
        }
        this.path = path;
        try {
            //设置媒体源
            mediaPlayer.setDataSource(context, Uri.parse(path));
            //异步加载音乐
            mediaPlayer.prepareAsync();

            mediaPlayer.setOnPreparedListener(mediaPlayer -> {
                mediaPlayerListener.onPrepared(mediaPlayer);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 播放
     */
    public void start() {
        if (mediaPlayer.isPlaying()) {
            return;
        }
        mediaPlayer.start();
    }

    /**
     * 暂停
     */
    public void pause() {
        mediaPlayer.pause();
    }
    public interface OnMediaPlayerListener {
        void onPrepared(MediaPlayer mp);
    }
}
