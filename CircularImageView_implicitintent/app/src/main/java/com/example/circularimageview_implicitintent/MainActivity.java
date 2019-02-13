package com.example.circularimageview_implicitintent;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;


    List<User> users;
    User user1,user2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appbar_layout);
        toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        users = new ArrayList<>();
        user1 = new User();
        user2 = new User();


        user1.setName("Prakash");
        user1.setParents("Batman \nBatwomen");
        user1.setDateofbirth("15 October,1997");
        user1.setDateofdeath("Immortal");
        user1.setCity("Guntur");
        user1.setDesignation("software");

        user2.setName("Prakash Sangu");
        user2.setParents("Batman \nBatwomen");
        user2.setDateofbirth("15 October,1997");
        user2.setDateofdeath("Immortal");
        user2.setCity("Guntur");
        user2.setDesignation("software");


        users.add(user1);
        users.add(user2);


        mRecyclerView=findViewById(R.id.recycler_view1);
       // mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new MyAdapter(users);
        mRecyclerView.setAdapter(mAdapter);








    }

}