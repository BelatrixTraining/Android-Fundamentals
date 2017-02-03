# Android-Fundamentals
## Notificaciones

Es un mensaje que se puede mostrar en la barra superior o de estado. Para poder ver las notificaciones hay que hacer un drag de la barra de estado y estarán ahí.

En la siguiente imagen, podemos apreciar los íconos de la barra de estado que estan relacionado a notificaciones:

<img src="https://developer.android.com/images/ui/notifications/notification_area.png"/>

Mientras que en la siguiente, podemos verla desprendida:

<img src="https://developer.android.com/images/ui/notifications/notification_drawer.png"/>

Las notificaciones en android siempre han sido muy estándar:

<img src="http://s3.amazonaws.com/digitaltrends-uploads-prod/2012/09/Android_Notifications.png"/>

A partir de android L, material design agrego unas cuantas cosas más que mencionaremos mas adelante.

## Esquema básico de una notificación

Nosotros utilizaremos NotificationCompat, ya que es el mas extendido. Hay otro que es Notification pero que funciona a partir del API level 11.

    NotificationCompat.Builder mBuilder =
        new NotificationCompat.Builder(this)
        .setSmallIcon(R.drawable.notification_icon)
        .setContentTitle("My notification")
        .setContentText("Hello World!");

Hasta este momento hemos creado el builder de la notificación, ahora solo falta crearlo y mostrarlo.

    // ID para la notificación
    int mNotificationId = 7007;
    // Obtiene el servicio de la notificación
    NotificationManager mNotificationManager =
            (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    // Genera la notificación con un ID
    mNotificationManager.notify(mNotificationId, mBuilder.build());



## Ejemplos

Activity:

```
package com.bx.android;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;

import com.bx.android.services.NotificationService;

public class NotificationsExampleActivity extends AppCompatActivity
        implements View.OnClickListener {

    private static final int NOTIFICATION_ID = 7777;

    public enum NotificationType {
        DEFAULT,
        WITH_BUTTONS,
        WITH_FLAGS,
        WITH_PENDING_INTENT
    }

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
        int id = v.getId();
        switch (id) {
            case R.id.simpleNotificationButton:
                createNotification(NotificationType.DEFAULT);
                break;
            case R.id.buttonsNotificationButton:
                createNotification(NotificationType.WITH_BUTTONS);
                break;
            case R.id.flagsNotificationButton:
                createNotification(NotificationType.WITH_FLAGS);
                break;
            case R.id.pendingIntentNotification:
                createNotification(NotificationType.WITH_PENDING_INTENT);
                break;
            case R.id.notificationWithService:
                Intent intent = new Intent(
                        NotificationsExampleActivity.this,
                        NotificationService.class
                );
                startService(intent);
                break;
        }
    }

    private void createNotification(NotificationType type) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("This is the title");
        builder.setContentText("This is the content text");
        builder.setSmallIcon(R.mipmap.ic_belatrix);
        // builder.setContentInfo("This is a content info");
        // builder.setLargeIcon(bitmap);
        // builder.setTicker("This is a ticket text text 123345 123123123 123123123");
        // builder.setColor(0xFFFF0000);
        // builder.setWhen(System.currentTimeMillis());
        // builder.setShowWhen(true);
        // OTHER VALUES
        // builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        // builder.setAutoCancel(true);
        // builder.setStyle(new NotificationCompat.BigTextStyle().bigText(getString(R.string.big_text)));

        /*
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();

        String[] events = new String[6];
        events[0] = new String("This is first line....");
        events[1] = new String("This is second line...");
        events[2] = new String("This is third line...");
        events[3] = new String("This is 4th line...");
        events[4] = new String("This is 5th line...");
        events[5] = new String("This is 6th line...");

        // Sets a title for the Inbox style big view
        inboxStyle.setBigContentTitle("Big Title Details:");

        // Moves events into the big view
        for (int i = 0; i < events.length; i++) {
            inboxStyle.addLine(events[i]);
        }

        builder.setStyle(inboxStyle);
        */

        switch (type) {
            case WITH_BUTTONS:
                builder.addAction(R.mipmap.ic_launcher, getString(android.R.string.ok), null);
                break;
            case WITH_FLAGS:
                builder.setDefaults(NotificationCompat.DEFAULT_LIGHTS);
                builder.setDefaults(NotificationCompat.DEFAULT_VIBRATE);
                builder.setDefaults(NotificationCompat.DEFAULT_SOUND);
                builder.setLights(0xff493C7C, 1000, 1000);
                // builder.setVibrate(new long[]{1,2,1,2,1});
                // builder.setSound(uri...);
                break;
            case WITH_PENDING_INTENT:
                Intent intent = new Intent(NotificationsExampleActivity.this, LoginActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(
                        NotificationsExampleActivity.this,
                        0,
                        intent,
                        0
                );
                builder.addAction(R.mipmap.ic_launcher, getString(R.string.click_me), pendingIntent);
                break;
            case DEFAULT:
                // NOTHING TO DO HERE
        }
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, builder.build());

        // Notification notification = builder.build();
        // notification.flags |= Notification.FLAG_AUTO_CANCEL;
        // notification.flags |= Notification.FLAG_SHOW_LIGHTS;
        // notification.ledARGB = 0xFFff0000;
        // notification.ledOnMS = 100;
        // notification.ledOffMS = 100;


        // OTHERS
        // notificationManager.cancel(NOTIFICATION_ID);
        // notificationManager.cancelAll();
    }
}
```

Service:

```
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

```

## Referencias

- https://developer.android.com/guide/topics/ui/notifiers/notifications.html
- https://material.io/guidelines/patterns/notifications.html#notifications-anatomy-of-a-notification
- https://developer.android.com/reference/android/support/v4/app/NotificationCompat.Builder.html
- https://developer.android.com/training/notify-user/build-notification.html
- http://www.vogella.com/tutorials/AndroidNotifications/article.html
- http://www.androidauthority.com/how-to-create-android-notifications-707254/
