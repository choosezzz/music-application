package com.example.musicapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapplication.R;

import lombok.AllArgsConstructor;

/**
 * @author choosezzz
 * @date 3/17/21 10:55 PM
 */
@AllArgsConstructor
public class MusicListAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private int line;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_music, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return line;
    }
}
