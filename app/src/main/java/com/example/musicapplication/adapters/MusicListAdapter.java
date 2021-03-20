package com.example.musicapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.musicapplication.R;

/**
 * @author choosezzz
 * @date 3/17/21 10:55 PM
 */
public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.ViewHolder> {

    private Context context;
    private int line;
    private RecyclerView recyclerView;

    /**
     * 设置过RecyclerView的高度标识
     */
    private boolean isCalculateHeight = false;
    /**
     * 自定义的页面布局
     */
    private View itemView;

    public MusicListAdapter(Context context, int line, RecyclerView recyclerView) {
        this.context = context;
        this.line = line;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(context).inflate(R.layout.item_list_music, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setRecyclerViewHeight();
        Glide.with(context).load("https://t7.baidu.com/it/u=2621658848,3952322712&fm=193&f=GIF")
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return line;
    }

    /**
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
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.music_list_icon);
        }
    }
}
