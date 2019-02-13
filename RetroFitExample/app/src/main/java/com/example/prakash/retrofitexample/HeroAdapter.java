package com.example.prakash.retrofitexample;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.MyViewHolder> {

    @NonNull

    private List<Heromodel> list;
    private Context context;

    public HeroAdapter(@NonNull List<Heromodel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.display_heroes_layout,viewGroup,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        final Heromodel hero = list.get(i);
        final int position = myViewHolder.getAdapterPosition();



        //Log.d("URL",hero.getImageUrl());
       /* myViewHolder.editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Namechange_activity.class);
                intent.putExtra("model",hero);
                v.getContext().startActivity(intent);


            }
        });
        myViewHolder.deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = MainActivity.myDatabase.myDao().deleteUserbyname(hero.getName());
                Log.d("TAG","Deleted "+id);
                //notifyItemChanged(position);
                //notifyItemRemoved(position);



            }
        });*/

        Glide.with(context).load(hero.getImageurl()).into(myViewHolder.imageView);
        myViewHolder.textView.setText(hero.getName());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        ImageView imageView;
        TextView textView;
        Button editbtn;
        Button deletebtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = (ImageView)itemView.findViewById(R.id.heropic);
            textView = (TextView)itemView.findViewById(R.id.herotext);
            editbtn = (Button)itemView.findViewById(R.id.changename);
            deletebtn = (Button)itemView.findViewById(R.id.deletename);

        }

    }
}
