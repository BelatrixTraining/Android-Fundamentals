/**
 *
 */
package com.belatrixsf.androidcomponents.example;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.belatrixsf.androidcomponents.MyActivity;

/**
 * @author Carlos Piñan
 * @date 1/16/17
 */
public class MyCustomService extends IntentService {

    public static final String ACTION = "thisIsAnAction";
    public static final String EXTRA_PARAM1 = "extraParam1";

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public MyCustomService() {
        super("MyCustomService");
    }

    public static void startAction(Context context, String param1) {
        Intent intent = new Intent(context, MyCustomService.class);
        intent.setAction(ACTION);
        intent.putExtra(EXTRA_PARAM1, param1);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                Intent i = new Intent(MyActivity.KEY_RECEIVER);
                i.putExtra(EXTRA_PARAM1, param1);
                LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(i);
            }
        }
    }
}
