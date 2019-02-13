package com.example.rxandroidexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder> {


    private List<CryptoModel.Market> marketList;

    public RecyclerViewAdapter() {
       marketList = new ArrayList<>();
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.bitcoin_display,viewGroup,false);

        Log.d("TAG","Inside Oncreate view holder");

        return new myViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull myViewHolder myViewHolder, int i) {

        CryptoModel.Market market = marketList.get(i);

        myViewHolder.coinName.setText(market.coinName);
        myViewHolder.marketName.setText(market.market);
        myViewHolder.coinPrice.setText("$" + String.format("%.2f", Double.parseDouble(market.price)));

        Log.d("TAG","Inside Onbind view holder"+i);

    }


    @Override
    public int getItemCount() {
        //System.out.println(marketList.size());
        return marketList.size();
    }

    public void setData(List<CryptoModel.Market> data) {
        this.marketList.addAll(data);

        //System.out.println(marketList.size());
        notifyDataSetChanged();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView coinName;
        TextView marketName;
        TextView coinPrice;

        CardView cardView;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            coinName = itemView.findViewById(R.id.txtCoin);
            marketName = itemView.findViewById(R.id.txtMarket);
            coinPrice = itemView.findViewById(R.id.txtPrice);
            cardView = itemView.findViewById(R.id.cardView);



        }
    }
}

