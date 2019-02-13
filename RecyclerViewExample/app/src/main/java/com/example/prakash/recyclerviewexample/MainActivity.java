package com.example.prakash.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public RecyclerView myRecyclerView;
    public RecyclerView.LayoutManager myLayoutManager;
    public RecyclerView.Adapter myAdapter;

    public List<String> mylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        myRecyclerView.setHasFixedSize(true); // improve the performance because with content size the recyclerview is not going to change

        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);

        mylist = Arrays.asList(getResources().getStringArray(R.array.superheroes));

        myAdapter = new RecyclerAdapter(mylist);
        myRecyclerView.setAdapter(myAdapter);






    }
}
