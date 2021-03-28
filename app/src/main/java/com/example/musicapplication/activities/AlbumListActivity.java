package com.example.musicapplication.activities;

import android.os.Bundle;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapplication.R;
import com.example.musicapplication.adapters.MusicListAdapter;
import com.example.musicapplication.constants.Constant;
import com.example.musicapplication.helpers.RealmHelper;
import com.example.musicapplication.models.AlbumModel;
import com.example.musicapplication.models.MusicModel;

import java.util.List;

public class AlbumListActivity extends BaseActivity {

    private RecyclerView albumListView;
    private MusicListAdapter musicListAdapter;
    private RealmHelper realmHelper;
    private Long albumId;
    private AlbumModel albumModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        albumId = getIntent().getLongExtra(Constant.ALBUM_ID, 0);
        setContentView(R.layout.activity_album_list);
        initData();
        initView();
    }

    private void initData() {
        realmHelper = RealmHelper.getRealmHelper();
        albumModel = realmHelper.getAlbumById(albumId);
    }
    private void initView() {
        initNavBar(true, Constant.ALBUM_LIST, false);
        albumListView = fd(R.id.rv_list);
        albumListView.setLayoutManager(new LinearLayoutManager(this));
        albumListView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        musicListAdapter = new MusicListAdapter(this, null, albumModel.getList());
        albumListView.setAdapter(musicListAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (realmHelper != null) {
            realmHelper.close();
        }
    }
}