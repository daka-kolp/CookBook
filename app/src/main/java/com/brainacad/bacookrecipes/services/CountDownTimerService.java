package com.brainacad.bacookrecipes.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.IBinder;

import com.brainacad.bacookrecipes.R;

public class CountDownTimerService extends Service {

    private long timeLeftInMillis;
    private boolean running;
    private CountDownTimer timer;

    private long millisecondsInMinute = 60_000;
    private long millisecondsInSecond = 1_000;


    public static final String COUNTDOWN_UPDATE_BROADCAST = "COUNTDOWN_UPDATE_BROADCAST";
    public static final String COUNTDOWN_TIME_BR = "COUNTDOWN_TIME_BR ";
    public static final String COUNTDOWN_IS_RUN_BR = "COUNTDOWN_IS_RUN_BR ";

    public static final String TIMER_MODE_INTENT = "TIMER_MODE_INTENT";
    public static final String TIME_INTENT = "TIME_INTENT";
    public static final int SET = 101;
    public static final int START = 102;
    public static final int STOP = 103;
    public static final int RESET = 104;

    private static final int NOTIFICATION_ID = 313;


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        Bundle bundle = intent.getExtras();
        int mode = bundle.getInt(TIMER_MODE_INTENT, RESET);
        switch (mode){
            case SET:
                setTime(bundle);
                break;
            case START:
                startTimer();
                break;
            case STOP:
                pauseTimer();
                break;
            case RESET:
                resetTime();
                break;
        }

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }

    private void setTime(Bundle bundle) {
        timeLeftInMillis = bundle.getLong(TIME_INTENT);
        updateViewTime(timeLeftInMillis);
        if (running) {
            pauseTimer();
        }
    }

    private void startTimer() {
        timer = new CountDownTimer(timeLeftInMillis, millisecondsInSecond) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                running = true;
                updateViewTime(timeLeftInMillis);
            }

            @Override
            public void onFinish() {

                Notification notification = new Notification.Builder(getApplicationContext())
                        .setSmallIcon(R.drawable.ic_show_steps)
                        .setContentTitle(getString(R.string.app_name))
                        .setContentText("Ready")
                        .setPriority(Notification.PRIORITY_HIGH)
                        .build();
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(NOTIFICATION_ID, notification);
                running = false;
                updateViewTime(0);
            }
        }.start();
    }

    private void pauseTimer() {
        running = false;
        timer.cancel();
        updateViewTime(timeLeftInMillis);
    }

    private void resetTime() {
        running = false;
        timeLeftInMillis = 0;
        timer.cancel();
        updateViewTime(timeLeftInMillis);
    }

    private void updateViewTime(long millisUntilFinished) {
        long min = millisUntilFinished / millisecondsInMinute;
        long sec = millisUntilFinished % millisecondsInMinute / millisecondsInSecond;
        String timeStr = String.format("%02d:%02d", min, sec);
        Intent i = new Intent(COUNTDOWN_UPDATE_BROADCAST);
        i.putExtra(COUNTDOWN_TIME_BR, timeStr);
        i.putExtra(COUNTDOWN_IS_RUN_BR, running);
        sendBroadcast(i);
    }
}
