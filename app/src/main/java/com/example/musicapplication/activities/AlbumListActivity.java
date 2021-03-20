package com.example.musicapplication.activities;

import android.os.Bundle;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapplication.R;
import com.example.musicapplication.adapters.MusicListAdapter;
import com.example.musicapplication.constants.Constant;

public class AlbumListActivity extends BaseActivity {

    private RecyclerView albumListView;
    private MusicListAdapter musicListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_list);
        initView();
    }

    private void initView() {
        initNavBar(true, Constant.ALBUM_LIST, false);
        albumListView = fd(R.id.rv_list);
        albumListView.setLayoutManager(new LinearLayoutManager(this));
        albumListView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        musicListAdapter = new MusicListAdapter(this, 8, null);
        albumListView.setAdapter(musicListAdapter);
    }
}