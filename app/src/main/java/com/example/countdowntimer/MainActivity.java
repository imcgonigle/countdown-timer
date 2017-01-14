package com.example.countdowntimer;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    TextView timerValue;
    CountDownTimer countdowntimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button)findViewById(R.id.startButton);
        timerValue = (TextView)findViewById(R.id.timerValue);
        final int timeInSeconds = 5;

        startButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                int timerLength = timeInSeconds * 1000;
                timerValue.setTextColor(Color.WHITE);

                countdowntimer = new CountDownTimer(timerLength, 10){
                    public void onTick(long millisUntilFinished) {
                        int milliseconds = (int) (millisUntilFinished);
                        int seconds = milliseconds / 1000;
                        int minutes = seconds / 60;
                        seconds = seconds % 60;
                        milliseconds = milliseconds % 1000;

                        timerValue.setText("" + minutes +":"
                                + String.format("%02d", seconds) + ":"
                                + String.format("%03d", milliseconds));
                    }

                    public void onFinish() {
                        timerValue.setTextColor(Color.RED);
                        timerValue.setText("Timer finished");
                    }
                };
                countdowntimer.start();
            }
        });
    }
}
