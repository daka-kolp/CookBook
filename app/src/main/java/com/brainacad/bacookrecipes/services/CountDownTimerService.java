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

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        Bundle bundle = intent.getExtras();
        timeLeftInMillis = bundle.getLong(GET_TIME);

        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {

            public void onTick(long millisUntilFinished) {
                String time = updateTime(millisUntilFinished);
                Intent i = new Intent(COUNTDOWN_UPDATE_BROADCAST);
                i.putExtra(COUNTDOWN_TIME_BR, time);
                sendBroadcast(i);
            }

            public void onFinish() {
                Intent i = new Intent(COUNTDOWN_UPDATE_BROADCAST);
                i.putExtra(COUNTDOWN_TIME_BR, "00:00");
                sendBroadcast(i);
                stopSelf();
            }
        };
        countDownTimer.start();
        return START_STICKY;
    }

    private String updateTime(long millisUntilFinished) {
        long min = millisUntilFinished / millisecondsInMinute;
        long sec = millisUntilFinished % millisecondsInMinute / millisecondsInSecond;
        return String.format("%02d:%02d", min, sec);
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
