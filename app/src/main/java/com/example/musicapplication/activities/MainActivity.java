package com.example.musicapplication.activities;

import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapplication.R;
import com.example.musicapplication.adapters.MusicGridAdapter;
import com.example.musicapplication.constants.Constant;

public class MainActivity extends BaseActivity {

    private static final Integer GRID_COUNT = 3;
    private RecyclerView gridView;
    private MusicGridAdapter musicGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        initNavBar(false, Constant.MAIN_TITLE, true);
        musicGridAdapter = new MusicGridAdapter(this, GRID_COUNT * 4);
        gridView = fd(R.id.rv_grid);
        gridView.setLayoutManager(new GridLayoutManager(this, GRID_COUNT));
        gridView.setAdapter(musicGridAdapter);
    }
}