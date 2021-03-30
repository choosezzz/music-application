package com.example.musicapplication.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.musicapplication.R;
import com.example.musicapplication.constants.Constant;
import com.example.musicapplication.helpers.RealmHelper;
import com.example.musicapplication.models.MusicModel;
import com.example.musicapplication.views.PlayMusicView;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class PlayMusicActivity extends BaseActivity {

    /**
     * 播放页背景图
     */
    private ImageView bgImage;
    private PlayMusicView playMusicView;
    /**
     * 数据源
     */
    private Long musicId;
    private MusicModel musicModel;
    private RealmHelper realmHelper;

    private TextView tvArtist;
    private TextView tvSongName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        musicId = getIntent().getLongExtra(Constant.MUSIC_ID, 0);
        setContentView(R.layout.activity_play_music);

        initData();
        initView();
    }

    private void initData() {
        realmHelper = RealmHelper.getRealmHelper();
        musicModel = realmHelper.getMusicById(musicId);
    }
    private void initView() {
        bgImage = fd(R.id.play_bg);
        Glide.with(this).load(musicModel.getPoster())
                //高斯模糊
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(20, 10)))
                .into(bgImage);
        playMusicView = fd(R.id.play_music_view);
        tvArtist = fd(R.id.tv_artiest);
        tvSongName = fd(R.id.tv_song_name);

        tvSongName.setText(musicModel.getName());
        tvArtist.setText(musicModel.getArtist());
        playMusicView.setMusic(musicModel);
        playMusicView.playMusic();
    }

    public void onBackClick(View view) {
        onBackPressed();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (realmHelper != null) {
            realmHelper.close();
        }
        //解绑MusicService
        playMusicView.unbindService();
    }
}