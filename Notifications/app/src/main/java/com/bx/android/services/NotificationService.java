/**
 *
 */
package com.bx.android.services;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

import com.bx.android.R;

/**
 * @author Carlos Piñan
 * @date 2/3/17
 */
public class NotificationService extends IntentService {

    private static final int NOTIFICATION_ID = 707;
    private static final long DUMMY_DELAY = 100L;

    public NotificationService() {
        super(NotificationService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
        builder.setContentTitle("Downloading something...");
        builder.setSmallIcon(R.mipmap.ic_belatrix);

        for (int i = 0; i <= 100; i++) {
            builder.setContentText("Loading " + i + "%");
            notificationManager.notify(NOTIFICATION_ID, builder.build());
            try {
                Thread.sleep(DUMMY_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        builder.setContentText("Complete!!!!");
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
        stopSelf();
    }
}
