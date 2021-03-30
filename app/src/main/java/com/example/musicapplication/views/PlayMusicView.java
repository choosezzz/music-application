package com.example.musicapplication.views;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.musicapplication.R;
import com.example.musicapplication.models.MusicModel;
import com.example.musicapplication.services.MusicService;

/**
 * @author choosezzz
 * @date 3/21/21 2:38 PM
 */
public class PlayMusicView extends FrameLayout {

    /**
     * 上下文
     */
    private Context context;
    /**
     * 当前PlayMusicView
     */
    private View playView;
    /**
     * 碟片
     */
    private FrameLayout flPlayMusic;
    /**
     * 唱针
     */
    private ImageView ivPlayNeedle;
    /**
     * 播放唱片的icon
     */
    private ImageView playIcon;
    /**
     * 播放按钮
     */
    private ImageView ivPlay;
    /**
     * 唱片动画效果
     */
    private Animation playTurntableAnim;
    /**
     * 唱针
     */
    private Animation playNeedleAnim;
    private Animation stopNeedleAnim;

    private boolean isPlaying;

    private Intent musicServiceIntent;
    private boolean isBindService;
    private MusicService.MusicBinder musicBinder;
    private MusicModel musicModel;

    private ServiceConnection conn;

    public PlayMusicView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public PlayMusicView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PlayMusicView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        playView = LayoutInflater.from(this.context).inflate(R.layout.play_music, this, false);
        playIcon = playView.findViewById(R.id.circle_icon);
        ivPlay = playView.findViewById(R.id.iv_play);
        flPlayMusic = playView.findViewById(R.id.fl_play_music);
        ivPlayNeedle = playView.findViewById(R.id.iv_play_needle);
        flPlayMusic.setOnClickListener(v -> {
            trigger();
        });
        /**
         * 动画效果
         * 1. 唱片转动
         * 2. 唱针拨向唱片
         * 3. 唱针拨离唱片
         */
        playTurntableAnim = AnimationUtils.loadAnimation(context, R.anim.play_turntable_anim);
        playNeedleAnim = AnimationUtils.loadAnimation(context, R.anim.play_needle_anim);
        stopNeedleAnim = AnimationUtils.loadAnimation(context, R.anim.stop_needle_anim);
        addView(playView);

        conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {

                musicBinder = (MusicService.MusicBinder) service;
                musicBinder.setMusic(musicModel);
                musicBinder.playMusic();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };

    }

    public void setPlayIcon() {
        Glide.with(context).load(musicModel.getPoster())
                .into(playIcon);
    }

    public void setMusic(MusicModel music) {
        this.musicModel = music;
        setPlayIcon();
    }

    /**
     * 播放音乐
     */
    public void playMusic() {
        isPlaying = true;
        flPlayMusic.startAnimation(playTurntableAnim);
        ivPlayNeedle.startAnimation(playNeedleAnim);
        ivPlay.setVisibility(View.GONE);

        startMusicService();
    }

    /**
     * 停止播放
     */
    public void stopMusic() {
        isPlaying = false;
        flPlayMusic.clearAnimation();
        ivPlayNeedle.startAnimation(stopNeedleAnim);
        ivPlay.setVisibility(View.VISIBLE);
        musicBinder.pauseMusic();
    }

    /**
     * 切换播放状态
     */
    private void trigger() {

        if (isPlaying) {
            stopMusic();
        } else {
            playMusic();
        }
    }

    public void startMusicService() {

        //启动service
        if (musicServiceIntent == null) {
            musicServiceIntent = new Intent(context, MusicService.class);
            context.startService(musicServiceIntent);
        }
        //绑定service
        if (!isBindService) {
            isBindService = true;
            context.bindService(musicServiceIntent, conn, Context.BIND_AUTO_CREATE);
        }
    }

    public void unbindService() {
        if (isBindService) {
            isBindService = false;
            context.unbindService(conn);
        }
    }
}
