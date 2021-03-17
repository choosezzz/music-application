package com.example.musicapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapplication.R;

/**
 * @author choosezzz
 * @date 3/17/21 10:55 PM
 */
public class MusicListAdapter extends RecyclerView.Adapter<MyViewHolder> {

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
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(context).inflate(R.layout.item_list_music, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        setRecyclerViewHeight();
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
}
