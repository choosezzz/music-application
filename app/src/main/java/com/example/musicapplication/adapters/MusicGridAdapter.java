package com.example.musicapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.musicapplication.R;
import com.example.musicapplication.activities.AlbumListActivity;
import com.example.musicapplication.constants.Constant;
import com.example.musicapplication.models.AlbumModel;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author choosezzz
 * @date 3/16/21 11:14 PM
 */
@Getter
@AllArgsConstructor
public class MusicGridAdapter extends RecyclerView.Adapter<MusicGridAdapter.MyViewHolder> {

    private Context context;
    private List<AlbumModel> albumModelList;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_grid_music, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        AlbumModel albumModel = albumModelList.get(position);
        Glide.with(context).load(albumModel.getPoster()).into(holder.imageView);
        holder.tvAlbumName.setText(albumModel.getName());
        holder.tvPlayNum.setText(albumModel.getPlayNum());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, AlbumListActivity.class);
            intent.putExtra(Constant.ALBUM_ID, albumModel.getAlbumId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return albumModelList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvPlayNum;
        TextView tvAlbumName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.grid_icon);
            tvPlayNum = itemView.findViewById(R.id.tv_play_num);
            tvAlbumName = itemView.findViewById(R.id.tv_album_name);
        }
    }

}
