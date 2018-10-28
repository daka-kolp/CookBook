package com.brainacad.bacookrecipes.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.brainacad.bacookrecipes.R;
import com.brainacad.bacookrecipes.services.CountDownTimerService;

public class TimerActivity extends Activity {

    private EditText editTimeSet;
    private Button buttonTimeSet;
    private TextView viewTime;
    private Button startPauseTimeButton;
    private Button resetTimeButton;


    private long timeLeftInMillis;

    public static final String LOG_TIME = "log time";

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

    private void setTime() {
        if (editTimeSet.getText().toString().equals(""))
            return;
        timeLeftInMillis = Long.valueOf(editTimeSet.getText().toString()) * millisecondsInMinute;

        Intent intent = new Intent(this, CountDownTimerService.class);
        intent.putExtra(CountDownTimerService.TIMER_MODE_INTENT, CountDownTimerService.SET);
        intent.putExtra(CountDownTimerService.TIME_INTENT, timeLeftInMillis);
        startService(intent);

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
        Intent intent = new Intent(this, CountDownTimerService.class);
        intent.putExtra(CountDownTimerService.TIMER_MODE_INTENT, CountDownTimerService.START);
        startService(intent);
        if (running)
            startPauseTimeButton.setText(R.string.pause);
        else
            startPauseTimeButton.setText(R.string.start);

    }

    private void pauseTimer() {
        Intent intent = new Intent(this, CountDownTimerService.class);
        intent.putExtra(CountDownTimerService.TIMER_MODE_INTENT, CountDownTimerService.STOP);
        startService(intent);
        startPauseTimeButton.setText(R.string.start);
    }

    private void resetTime() {
        Intent intent = new Intent(this, CountDownTimerService.class);
        intent.putExtra(CountDownTimerService.TIMER_MODE_INTENT, CountDownTimerService.RESET);
        startService(intent);
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

    private String timeStr;
    private boolean running;
    BroadcastReceiver uiUpdate = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            timeStr = intent.getExtras().getString(CountDownTimerService.COUNTDOWN_TIME_BR);
            running = intent.getExtras().getBoolean(CountDownTimerService.COUNTDOWN_IS_RUN_BR);
            viewTime.setText(timeStr);
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(uiUpdate, new IntentFilter(CountDownTimerService.COUNTDOWN_UPDATE_BROADCAST));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(uiUpdate);
    }
}
