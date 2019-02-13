package com.example.mytimerexample;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    long MillisecondTime = 0L;
    long StartTime = 0L;


    TextView timertxt;
    int Seconds, Minutes, MilliSeconds ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timertxt = findViewById(R.id.timertext);
        Button startBtn = findViewById(R.id.startBtn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StartTime = SystemClock.uptimeMillis();
                run();

            }
        });
    }
    public void run(){

        MillisecondTime = SystemClock.uptimeMillis() - StartTime;
        Seconds = (int) (MilliSeconds / 1000);

        Minutes = Seconds / 60;

        Seconds = Seconds % 60;

        MilliSeconds = (int) (MillisecondTime % 1000);

        timertxt.setText("" + Minutes + ":"
                + String.format("%02d", Seconds) + ":"
                + String.format("%03d", MilliSeconds));

    }
}
