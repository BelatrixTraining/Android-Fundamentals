package com.bx.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NotificationsExampleActivity extends AppCompatActivity
        implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        findViewById(R.id.simpleNotificationButton).setOnClickListener(this);
        findViewById(R.id.buttonsNotificationButton).setOnClickListener(this);
        findViewById(R.id.flagsNotificationButton).setOnClickListener(this);
        findViewById(R.id.pendingIntentNotification).setOnClickListener(this);
        findViewById(R.id.notificationWithService).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
