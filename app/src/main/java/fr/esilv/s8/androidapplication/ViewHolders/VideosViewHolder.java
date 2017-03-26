package fr.esilv.s8.androidapplication.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.esilv.s8.androidapplication.Interfaces.OnVideoSelectedListener;
import fr.esilv.s8.androidapplication.Models.Item;
import fr.esilv.s8.androidapplication.R;

/**
 * Created by Ramez Aissaoui on 20/03/2017.
 */

public class VideosViewHolder extends RecyclerView.ViewHolder{


    private TextView title;
    private TextView author;
    private ImageView thumbnail;
    private OnVideoSelectedListener onVideoSelectedListener;

    public VideosViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        author = (TextView) itemView.findViewById(R.id.author);
        thumbnail= (ImageView) itemView.findViewById(R.id.imageView);
    }

    public void bind(final Item video) {
        author.setText(video.getSnippet().getTitle());
        Picasso.with(itemView.getContext()).load(video.getSnippet().getThumbnails().getHigh().getUrl()).into(thumbnail);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onVideoSelectedListener == null) {
                    return;
                }
                onVideoSelectedListener.onVideoSelected(video);
            }
        });
    }



    public void setOnVideoSelectedListener(OnVideoSelectedListener onVideoSelectedListener) {
        this.onVideoSelectedListener = onVideoSelectedListener;
    }
}
