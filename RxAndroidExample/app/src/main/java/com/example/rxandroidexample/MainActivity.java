package com.example.rxandroidexample;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Toast;

import java.util.List;

import io.reactivex.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    public RecyclerViewAdapter myAdapter;
    Disposable d;

    Retrofit retrofit;

    Boolean isScrolled = false;

    int currentItems,totalItems,scrolledItems;

    int count=4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

       RecyclerView.LayoutManager myLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(myLayoutManager);

        myAdapter = new RecyclerViewAdapter();

        recyclerView.setAdapter(myAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)
                    isScrolled = true;
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                currentItems = myLayoutManager.getChildCount();
                totalItems = myLayoutManager.getItemCount();
                scrolledItems = ((LinearLayoutManager) myLayoutManager).findFirstVisibleItemPosition();


                if(isScrolled && (currentItems+scrolledItems == totalItems)){

                    isScrolled = false;


                    if(count!=0){
                        count--;


                        callEndpoints();
                    }

                }
            }
        });





        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder().baseUrl(CryptoInterface.BASE_URL).client(client).
               addCallAdapterFactory(RxJava2CallAdapterFactory.create()). // This method is needed To use RxJava Observable along with Retrofit
                addConverterFactory(GsonConverterFactory.create()).build();


        callEndpoints();


    }

    private void callEndpoints() {

        CryptoInterface cryptoInterface = retrofit.create(CryptoInterface.class);

        Observable<List<CryptoModel.Market>> myObservable = cryptoInterface.getCoinData("btc").
                map(result -> Observable.fromIterable(result.ticker.markets)) // mapping the result to contain list of markets
                .flatMap(x -> x).filter(y -> { // Allow only those whose coinName is btc
                    y.coinName = "btc";
                    return true;
                }).toList().toObservable();


        /*Observable<List<CryptoModel.Market>> ethObservable = cryptoInterface.getCoinData("eth")
                .map(result -> Observable.fromIterable(result.ticker.markets))
                .flatMap(x -> x).filter(y -> {
                    y.coinName = "eth";
                    return true;
                }).toList().toObservable();*/





        d = myObservable
                //.merge(myObservable, ethObservable)//doOnNext(c -> System.out.println("processing item on thread " + Thread.currentThread().getName()))
                .subscribeOn(Schedulers.computation()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(this::handleResults, this::handleError);


    }
    private void handleResults(List<CryptoModel.Market> markets) {

        if (markets != null && markets.size() != 0) {

           // System.out.println(" received on thread " + Thread.currentThread().getName());


          /* for(CryptoModel.Market temp:markets){
                Log.d("TAG","data is"+temp.getMarket());
            }*/
          myAdapter.setData(markets);




        } else {
            Toast.makeText(this, "NO RESULTS FOUND",
                    Toast.LENGTH_LONG).show();
        }
    }

    private void handleError(Throwable t) {

        Toast.makeText(this, "ERROR IN FETCHING API RESPONSE. Try again",
                Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        d.dispose();
    }
}
