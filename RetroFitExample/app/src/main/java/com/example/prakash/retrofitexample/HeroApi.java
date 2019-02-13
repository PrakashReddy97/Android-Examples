package com.example.prakash.retrofitexample;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HeroApi {

    @GET("marvel")
    Call<List<Heromodel>> getHeroes();

}
