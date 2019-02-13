package com.example.prakash.recyclerviewexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewholder> {
    @NonNull

    public List<String> list;

    public RecyclerAdapter(@NonNull List<String> list) {
        this.list = list;
    }

    @Override

    /* The first step that android frameworks looks is to create an instance of viewholder. OncreateViewHolder is responsible
    to create an obbject of viewholder.*/

    public MyViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        TextView textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.textview_layout,viewGroup,false);
        MyViewholder myViewholder = new MyViewholder(textView);
        return myViewholder;

    }

    /*OnbindViewHolder binds the view to the instance of viewholder*/
    @Override
    public void onBindViewHolder(MyViewholder viewHolder, int i) {
    viewHolder.superheroes.setText(list.get(i));
    

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewholder extends RecyclerView.ViewHolder{

        TextView superheroes;

        public MyViewholder(@NonNull TextView itemView) {
            super(itemView);
            superheroes = itemView;
        }
    }
}
