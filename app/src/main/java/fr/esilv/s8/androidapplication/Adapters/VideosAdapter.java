package fr.esilv.s8.androidapplication.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.esilv.s8.androidapplication.Interfaces.OnVideoSelectedListener;
import fr.esilv.s8.androidapplication.Models.Item;
import fr.esilv.s8.androidapplication.R;
import fr.esilv.s8.androidapplication.ViewHolders.VideosViewHolder;

/**
 * Created by Ramez Aissaoui on 20/03/2017.
 */

public class VideosAdapter extends RecyclerView.Adapter<VideosViewHolder> {

    private final List<Item> videos;
    private OnVideoSelectedListener onVideoSelectedListener;

    public VideosAdapter(List<Item> videos) {
        this.videos =videos;
    }

    @Override
    public VideosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_videos, parent, false);
        return new VideosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VideosViewHolder holder, int position) {
        holder.setOnVideoSelectedListener(onVideoSelectedListener);
        holder.bind(videos.get(position));
    }

    @Override
    public int getItemCount() {
        return videos != null ? videos.size() : 0;
    }

    public void setOnVideoSelectedListener(OnVideoSelectedListener onVideoSelectedListener) {
        this.onVideoSelectedListener = onVideoSelectedListener;
    }

}
