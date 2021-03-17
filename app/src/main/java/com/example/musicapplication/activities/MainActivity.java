package com.example.musicapplication.activities;

import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapplication.R;
import com.example.musicapplication.adapters.MusicGridAdapter;
import com.example.musicapplication.constants.Constant;
import com.example.musicapplication.views.GridItemSpaceDecoration;

public class MainActivity extends BaseActivity {

    /**
     * 每行网格数量
     */
    private static final Integer LINE_GRID_COUNT = 3;
    private RecyclerView gridView;
    private MusicGridAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        initNavBar(false, Constant.MAIN_TITLE, true);
        gridAdapter = new MusicGridAdapter(this, LINE_GRID_COUNT * 2);
        gridView = fd(R.id.rv_grid);
        gridView.setLayoutManager(new GridLayoutManager(this, LINE_GRID_COUNT));
        gridView.setAdapter(gridAdapter);
        //分割线
        gridView.addItemDecoration(new GridItemSpaceDecoration(getResources().getDimensionPixelSize(R.dimen.album_margin_size), gridView));
    }
}