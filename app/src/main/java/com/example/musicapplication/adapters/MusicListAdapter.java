package com.example.musicapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.musicapplication.R;
import com.example.musicapplication.activities.PlayMusicActivity;
import com.example.musicapplication.constants.Constant;
import com.example.musicapplication.models.MusicModel;

import java.util.List;

/**
 * @author choosezzz
 * @date 3/17/21 10:55 PM
 */
public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.ViewHolder> {

    private Context context;
    private RecyclerView recyclerView;
    private List<MusicModel> musicModelList;

    /**
     * 设置过RecyclerView的高度标识
     */
    private boolean isCalculateHeight = false;
    /**
     * 自定义的页面布局
     */
    private View itemView;

    public MusicListAdapter(Context context, RecyclerView recyclerView, List<MusicModel> musicModelList) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.musicModelList = musicModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(context).inflate(R.layout.item_list_music, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        MusicModel musicModel = musicModelList.get(position);
        setRecyclerViewHeight();
        Glide.with(context).load(musicModel.getPoster())
                .into(holder.ivSongIcon);
        holder.tvArtist.setText(musicModel.getArtist());
        holder.tvSongName.setText(musicModel.getName());
        //音乐列表点击事件
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, PlayMusicActivity.class);
            intent.putExtra(Constant.MUSIC_ID, musicModel.getMusicId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return musicModelList.size();
    }

    /**
     *
     * 只有RecyclerView和ScrollView重叠使用时需要计算
     * 设置RecyclerView的高度
     * 1、获取ItemView的高度
     * 2、获取ItemView的行数
     */
    private void setRecyclerViewHeight() {

        if (isCalculateHeight || recyclerView == null) {
            return;
        }
        isCalculateHeight = true;
        //获取itemView参数
        RecyclerView.LayoutParams itemViewParams = (RecyclerView.LayoutParams) itemView.getLayoutParams();
        //RecyclerView参数
        LinearLayout.LayoutParams rvParams = (LinearLayout.LayoutParams) recyclerView.getLayoutParams();
        rvParams.height = getItemCount() * itemViewParams.height;
        recyclerView.setLayoutParams(rvParams);

    }
    
    class ViewHolder extends RecyclerView.ViewHolder{

        //列表页缩略图
        ImageView ivSongIcon;
        ImageView ivPlayBtn;
        TextView tvArtist;
        TextView tvSongName;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivSongIcon = itemView.findViewById(R.id.music_list_icon);
            ivPlayBtn = itemView.findViewById(R.id.iv_play_btn);
            tvArtist = itemView.findViewById(R.id.tv_artiest);
            tvSongName = itemView.findViewById(R.id.tv_song_name);
        }
    }
}
