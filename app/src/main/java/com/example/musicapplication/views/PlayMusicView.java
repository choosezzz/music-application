package com.example.musicapplication.views;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.musicapplication.R;

/**
 * @author choosezzz
 * @date 3/21/21 2:38 PM
 */
public class PlayMusicView extends FrameLayout {

    private Context context;
    private View playView;
    private ImageView playIcon;

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
        addView(playView);
    }

    public void setPlayIcon(String src) {
        Glide.with(context).load(src)
                .into(playIcon);
    }
}
