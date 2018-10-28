package com.brainacad.bacookrecipes.services;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.IBinder;

public class CountDownTimerService extends Service {

    private long timeLeftInMillis;
    private CountDownTimer countDownTimer;

    private long millisecondsInMinute = 60_000;
    private long millisecondsInSecond = 1_000;

    public static final String GET_TIME = "GET_TIME";

    public static final String COUNTDOWN_UPDATE_BROADCAST = "COUNTDOWN_UPDATE_BROADCAST";
    public static final String COUNTDOWN_TIME_BR = "COUNTDOWN_TIME_BR ";

    public static final int START = 100;
    public static final int STOP = 200;
    public static final int RESET = 300;


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        Bundle bundle = intent.getExtras();
        timeLeftInMillis = bundle.getLong(GET_TIME);

        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {

            public void onTick(long millisUntilFinished) {
                Intent i = new Intent(COUNTDOWN_UPDATE_BROADCAST);
                i.putExtra(COUNTDOWN_TIME_BR, millisUntilFinished);
                sendBroadcast(i);
            }

            public void onFinish() {
                Intent i = new Intent(COUNTDOWN_UPDATE_BROADCAST);
                i.putExtra(COUNTDOWN_TIME_BR, 0);
                sendBroadcast(i);
                stopSelf();
            }
        };
        countDownTimer.start();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onDestroy() {
        countDownTimer.cancel();
        super.onDestroy();
    }
}
