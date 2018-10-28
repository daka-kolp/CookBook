package com.brainacad.bacookrecipes.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.brainacad.bacookrecipes.R;

public class TimerActivity extends Activity {

    private EditText editTimeSet;
    private Button buttonTimeSet;
    private TextView viewTime;
    private Button startPauseTimeButton;
    private Button resetTimeButton;

    private boolean running;

    private CountDownTimer timer;

    private long timeLeftInMillis;

    public static final String LOG_TIME = "log time";
    private static final int NOTIFICATION_ID = 313;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        editTimeSet = findViewById(R.id.timer_edit_time);
        buttonTimeSet = findViewById(R.id.timer_set_button);
        buttonTimeSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime();
            }
        });

        viewTime = findViewById(R.id.timer_view);
        startPauseTimeButton = findViewById(R.id.timer_start_pause_time);
        startPauseTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPauseTime();
            }
        });

        resetTimeButton = findViewById(R.id.timer_reset_time);
        resetTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTime();
            }
        });
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.action_cooktimer);
        }

    }

    private long millisecondsInMinute = 60_000;
    private long millisecondsInSecond = 1_000;

    private void setTime() {
        if (editTimeSet.getText().toString().equals(""))
            return;
        long time = Long.valueOf(editTimeSet.getText().toString()) * millisecondsInMinute;
        timeLeftInMillis = time;
        updateViewTime(time);
        if (running) {
            pauseTimer();
        }
        closeKeyboard();
    }

    private void startPauseTime() {
        if (running) {
            pauseTimer();
        } else {
            startTimer();
        }
    }

    private void startTimer() {

        timer = new CountDownTimer(timeLeftInMillis, millisecondsInSecond) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
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
                startPauseTimeButton.setText(R.string.start);
            }
        }.start();

        running = true;
        startPauseTimeButton.setText(R.string.pause);

    }

    private void pauseTimer() {
        running = false;
        timer.cancel();
        startPauseTimeButton.setText(R.string.start);
    }

    private void resetTime() {
        running = false;
        timer.cancel();
        timeLeftInMillis = 0;
        updateViewTime(timeLeftInMillis);
    }

    private void updateViewTime(long millisUntilFinished) {
        long min = millisUntilFinished / millisecondsInMinute;
        long sec = millisUntilFinished % millisecondsInMinute / millisecondsInSecond;
        String timeStr = String.format("%02d:%02d", min, sec);
        viewTime.setText(timeStr);
    }

    private void closeKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = this.getCurrentFocus();
        if (view == null) {
            view = new View(this);
        }
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
