package com.example.prakash.recyclerview_grid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {


    public RecyclerView myRecyclerView;
    public RecyclerView.LayoutManager myLayoutManager;

    public String[] text = {"Captain Amaerica","The Flash","Thor","Wonder Women","Ironman","Batman"};

    public int[] images = {R.drawable.captain,R.drawable.flash,R.drawable.thor,R.drawable.wonder,R.drawable.ironman,R.drawable.batman};

    public RecyclerView.Adapter myAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        myLayoutManager = new GridLayoutManager(this,2);

        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(myLayoutManager);

        myAdapter = new RecyclerAdapter(images,text);
        myRecyclerView.setAdapter(myAdapter);




    }
}
