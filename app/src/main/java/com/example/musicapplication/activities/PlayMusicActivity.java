package com.example.musicapplication.activities;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.musicapplication.R;
import com.example.musicapplication.views.PlayMusicView;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class PlayMusicActivity extends BaseActivity {

    /**
     * 播放页背景图
     */
    private ImageView bgImage;
    private PlayMusicView playMusicView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        initView();
    }

    private void initView() {
        //隐藏status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        bgImage = fd(R.id.play_bg);
        Glide.with(this).load("https://t7.baidu.com/it/u=3203007717,1062852813&fm=193&f=GIF")
                //高斯模糊
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(20, 10)))
                .into(bgImage);
        playMusicView = fd(R.id.play_music_view);
        playMusicView.setPlayIcon("https://t7.baidu.com/it/u=3203007717,1062852813&fm=193&f=GIF");
    }

    public void onBackClick(View view) {
        onBackPressed();
    }
}