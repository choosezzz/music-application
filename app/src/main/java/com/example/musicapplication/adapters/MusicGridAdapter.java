package com.example.musicapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapplication.R;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author choosezzz
 * @date 3/16/21 11:14 PM
 */
@Getter
@AllArgsConstructor
public class MusicGridAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private int itemCount;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_grid_music, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return itemCount;
    }
}
