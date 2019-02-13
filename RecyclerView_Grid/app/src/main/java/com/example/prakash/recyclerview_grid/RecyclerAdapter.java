package com.example.prakash.recyclerview_grid;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageViewHolder> {
    @NonNull

    public int[] images;
    public String[] text;

    public RecyclerAdapter(@NonNull int[] images, String[] text) {
        this.images = images;
        this.text = text;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_layout,viewGroup,false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder viewHolder, int i) {

    int image_id = images[i];
    String text_id = text[i];
    viewHolder.album.setImageResource(image_id);
    viewHolder.albumtitle.setText(text_id);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {


        ImageView album;
        TextView albumtitle;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            album = itemView.findViewById(R.id.album);
            albumtitle = itemView.findViewById(R.id.albumtitle);
        }
    }
}
