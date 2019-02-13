package com.example.timerexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView timerTxt;
    private Button startBtn;
    private Button pauseBtn;

    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerTxt = findViewById(R.id.timerText);
        startBtn = findViewById(R.id.startBtn);
        //pauseBtn = findViewById(R.id.pauseBtn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(v.getContext(),MyService.class);
                startService(intent);
                registerReceiver(myReceiver,new IntentFilter(MyService.BROADCAST_ACTION));

                Log.d("TAG","inside start btn");




            }
        });
        /*pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });*/
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG","Onstop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG","On destroy called");
    }

    private BroadcastReceiver myReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("TAG","inside my receiver");
            setUI(intent);
        }
    };

    private void setUI(Intent intent) {

        int time = intent.getIntExtra("TIME",0);
        Log.d("TAG","Inside set UI");
        int mins = time / 60;
        int secs = time % 60;
        timerTxt.setText(""+mins+":"+String.format("%02d", secs));

    }
}
