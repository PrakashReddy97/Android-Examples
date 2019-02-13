package com.example.circularimageview_implicitintent;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<User> user;


    public MyAdapter(List<User> users) {
        this.user = users;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.profile_cardviewlayout,viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        User user1 = user.get(i);
        myViewHolder.name.setText(user1.getName());
        myViewHolder.dob.setText(user1.getDateofbirth());
        myViewHolder.parentsName.setText(user1.getParents());
        myViewHolder.cityName.setText(user1.getCity());
        myViewHolder.designation.setText(user1.getDesignation());
        myViewHolder.dod.setText(user1.getDateofdeath());

    }

    @Override
    public int getItemCount() {
        return user.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,designation,cityName,dob,dod,parentsName,spouseName;
        Button goBack;
        ImageView profileImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.profile_name);
            profileImage = itemView.findViewById(R.id.profile_image);
            designation = itemView.findViewById(R.id.designation);
            cityName = itemView.findViewById(R.id.city);
            dob = itemView.findViewById(R.id.dob);
            dod = itemView.findViewById(R.id.dod);
            parentsName = itemView.findViewById(R.id.parentsname);
            spouseName = itemView.findViewById(R.id.spousename);
            goBack = itemView.findViewById(R.id.profilebtn);



        }
    }

}
