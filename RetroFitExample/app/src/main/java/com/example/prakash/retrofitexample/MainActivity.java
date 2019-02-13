package com.example.prakash.retrofitexample;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<Heromodel> heroList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter myAdapter;
    //public static MyDatabase myDatabase;

    int cacheSize = 10 * 1024 * 1024;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        retrieveData();



        //myDatabase = Room.databaseBuilder(getApplicationContext(),MyDatabase.class,"userdb").allowMainThreadQueries().build();
    }

    public void retrieveData(){

        File httpCacheDirectory = new File(getApplicationContext().getCacheDir(),"responses");

        // Creating a cache for size 10 MB.

        Cache cache = new Cache(httpCacheDirectory,cacheSize);

        // Adding the network interceptor to client

        OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(REWRITE_RESPONSE_INTERCEPTOR)
                .cache(cache)
                .build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL).client(client).
                addConverterFactory(GsonConverterFactory.create()).build();

        HeroApi apiInterface = retrofit.create(HeroApi.class);

        Call<List<Heromodel>> call = apiInterface.getHeroes();
        call.enqueue(new Callback<List<Heromodel>>() {
            @Override
            public void onResponse(Call<List<Heromodel>> call, retrofit2.Response<List<Heromodel>> response) {

                heroList = response.body();
                //myDatabase.myDao().addusers(heroList);
                myAdapter=new HeroAdapter(heroList,getApplicationContext());
                recyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onFailure(Call<List<Heromodel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"There is some error",Toast.LENGTH_SHORT);
            }
        });

    }




    // Creating a Interceptor that requests and and handle responses.

    private final Interceptor REWRITE_RESPONSE_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response originalResponse = chain.proceed(chain.request());

            if(isNetworkAvailable()){
                int maxAge = 60; // read from cache for 1 minute
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, max-age=" + maxAge) // After getting response from server we can access response stored in cache for 1 min
                        .build();
            }
            else {
                int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale) // If no internet access cache which is available from 28 days.
                        .build();
            }
        }
    };
    public boolean isNetworkAvailable(){

        // Method for checking Internet Connectivity.

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        Log.d("TAG",".."+networkInfo);

        if(networkInfo!=null && networkInfo.isConnected())
            return true;

        else
            return false;


    }

    @Override
    protected void onResume() {
        super.onResume();


        /*heroList = MainActivity.myDatabase.myDao().getUsers();
        if (heroList.isEmpty()) {
            fetchdatafromserver();
        } else {
            myAdapter = new HeroAdapter(heroList, getApplicationContext());
            recyclerView.setAdapter(myAdapter);
        }*/
    }
    /*



    public void fetchdatafromserver(){

        Log.d("TAG","Fetching data from server");



        Cache cache = new Cache(getCacheDir(),cacheSize);

        OkHttpClient client = new OkHttpClient.Builder().cache(cache).addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                Log.d("TAG","GET"+request);

                if (!isNetworkAvailable()){
                    Log.d("TAG","Network not available");
                    int maxStale = 60*60*24*28; // 28 days
                    request = request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale).build();

                }
                else{
                    int maxAge = 60*60;
                    request = request.newBuilder().header("Cache-Control", "public, max-age=" + maxAge).build();
                }
                Log.d("TAG","Response code is"+chain.proceed(request));
                return chain.proceed(request);
            }
        }).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants
                .BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create()).build();

        HeroApi apiInterface = retrofit.create(HeroApi.class);

        Call<List<Heromodel>> call = apiInterface.getHeroes();
        call.enqueue(new Callback<List<Heromodel>>() {
            @Override
            public void onResponse(Call<List<Heromodel>> call, Response<List<Heromodel>> response) {
                heroList = response.body();
                //myDatabase.myDao().addusers(heroList);
                myAdapter=new HeroAdapter(heroList,getApplicationContext());
                recyclerView.setAdapter(myAdapter);

            }

            @Override
            public void onFailure(Call<List<Heromodel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"There is some error",Toast.LENGTH_SHORT);
            }
        });

    }*/
}
