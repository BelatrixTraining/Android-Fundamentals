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

1. Notificación simple.

2. Notificación con botones.

3. Notificación con flags (sonido, vibración y luz)

4. Agregando Pending Intent a la notificación.

## Referencias

- https://developer.android.com/guide/topics/ui/notifiers/notifications.html
- https://material.io/guidelines/patterns/notifications.html#notifications-anatomy-of-a-notification
- https://developer.android.com/reference/android/support/v4/app/NotificationCompat.Builder.html
- https://developer.android.com/training/notify-user/build-notification.html
- http://www.vogella.com/tutorials/AndroidNotifications/article.html
- http://www.androidauthority.com/how-to-create-android-notifications-707254/
