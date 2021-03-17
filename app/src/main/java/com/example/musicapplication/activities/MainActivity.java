package com.example.musicapplication.activities;

import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapplication.R;
import com.example.musicapplication.adapters.MusicGridAdapter;
import com.example.musicapplication.adapters.MusicListAdapter;
import com.example.musicapplication.constants.Constant;
import com.example.musicapplication.views.GridItemSpaceDecoration;

public class MainActivity extends BaseActivity {

    /**
     * 每行网格数量
     */
    private static final Integer LINE_GRID_COUNT = 3;
    private RecyclerView gridView;
    private RecyclerView listView;
    private MusicGridAdapter gridAdapter;
    private MusicListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        initNavBar(false, Constant.MAIN_TITLE, true);

        //推荐歌单网格
        gridAdapter = new MusicGridAdapter(this, LINE_GRID_COUNT * 2);
        gridView = fd(R.id.rv_grid);
        //禁止RecyclerView滑动
        gridView.setNestedScrollingEnabled(false);
        gridView.setLayoutManager(new GridLayoutManager(this, LINE_GRID_COUNT));
        gridView.setAdapter(gridAdapter);
        //分割线
        gridView.addItemDecoration(new GridItemSpaceDecoration(getResources().getDimensionPixelSize(R.dimen.album_margin_size), gridView));

        //最热音乐列表
        listAdapter = new MusicListAdapter(this, 8);
        listView = fd(R.id.rv_list);
        //禁止RecyclerView滑动
        listView.setNestedScrollingEnabled(false);
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setAdapter(listAdapter);

    }
}