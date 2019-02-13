package com.example.rxandroidexample;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CryptoInterface {

    String BASE_URL = "https://api.cryptonator.com/api/full/";

    @GET("{coin}-usd")
    Observable <CryptoModel> getCoinData(@Path("coin") String coin);
}
