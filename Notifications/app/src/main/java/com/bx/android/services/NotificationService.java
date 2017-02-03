/**
 *
 */
package com.bx.android.services;

import android.app.IntentService;
import android.content.Intent;

/**
 * @author Carlos Piñan
 * @date 2/3/17
 */
public class NotificationService extends IntentService {

    public NotificationService() {
        super(NotificationService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
