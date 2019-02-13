package com.example.timerexample;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

public class MyService extends Service {

    public static final String BROADCAST_ACTION = "com.example.timerexample";
    Handler handler = new Handler();

    long startTime =0L;
    long time = 0L;
    Intent intent;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        startTime = SystemClock.uptimeMillis();

        Log.d("TAG","Inside service");
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, 1000);
        return START_STICKY;
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            sendMessage();
            handler.postDelayed(runnable,1000);

        }
    };
    private void sendMessage(){
        intent = new Intent(BROADCAST_ACTION);
        time = SystemClock.uptimeMillis()-startTime;

        //Log.d("CURRENT","The time is "+time);
        int timer = (int)time/1000;
        intent.putExtra("TIME",timer);
        sendBroadcast(intent);

    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /*
    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }*/
}
