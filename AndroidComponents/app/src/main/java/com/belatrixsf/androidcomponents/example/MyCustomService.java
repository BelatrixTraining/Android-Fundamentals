/**
 *
 */
package com.belatrixsf.androidcomponents.example;

import android.app.IntentService;
import android.content.Intent;

/**
 * @author Carlos Piñan
 * @date 1/16/17
 */
public class MyCustomService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public MyCustomService() {
        super("MyCustomService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
