package com.example.musicapplication.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import com.example.musicapplication.helpers.MediaPlayHelper;
import com.example.musicapplication.models.MusicModel;

/**
 * @author choosezzz
 *
 * 使用service连接PlayMusicView和MediaPlayHelper
 *
 */
public class MusicService extends Service {

    private MediaPlayHelper mediaPlayHelper;

    private MusicModel musicModel;
    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MusicBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayHelper = MediaPlayHelper.getInstance(this);
    }

    /**
     * 音乐绑定
     */
    public class MusicBinder extends Binder {

        public void setMusic(MusicModel music) {
            musicModel = music;
        }

        public void playMusic() {
            if (mediaPlayHelper.getPath() != null && mediaPlayHelper.getPath().equals(musicModel.getPath())) {
                mediaPlayHelper.start();
                return;
            }
            mediaPlayHelper.setPath(musicModel.getPath());
            mediaPlayHelper.setMediaPlayerListener(new MediaPlayHelper.OnMediaPlayerListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaPlayHelper.start();
                }

                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopSelf();
                }
            });
        }

        public void pauseMusic() {
            mediaPlayHelper.pause();
        }
    }
}