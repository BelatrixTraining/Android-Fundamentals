<img src="https://www.edureka.co/blog/wp-content/uploads/2012/11/Components-of-Android1.jpg"/>

###Componentes de una aplicación
Existen 4 tipos de componentes:

 - Activity
 - Service
 - Content Provider
 - BroadCast Receiver

Cada uno de ellos tiene un proposito distinto y un ciclo de vida diferente que es el que define cuando se crean y cuando se destruyen.

####Qué es una activity?
Un activity es el punto de entrada de la interaccion con el usuario. Esta representa un sola pantalla aunque con el uso de **fragmentos** se puede tener mas de una pantalla por actividad.
Una activity es implementada como una subclase de Activity.

```
<activity android:name=".ExampleActivity" android:icon="@drawable/app_icon">
    <intent-filter>
        <action android:name="android.intent.action.SEND" />
        <category android:name="android.intent.category.DEFAULT" />
        <data android:mimeType="text/plain" />
    </intent-filter>
<activity>
```

<img src="https://developer.android.com/guide/components/images/activity_lifecycle.png"/>

####Ejemplo de activity

```
package com.belatrixsf.androidcomponents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ExampleAppCompatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.clickButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExampleAppCompatActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
    }
}
```

####Qué es un Service?
Es un componente que permite a la aplicacion seguir corriendo en background (no estar visible). Un servicio no provee una interfaz de usuario y suele usarse para tareas prolongadas. Existen dos tipos de Services: **Started** y **Bound** Services.
Su mayor diferencia es que el primero le indica al sistema que lo deje seguir corriendo hasta terminar su trabajo mientras que el segundo se mantendra vivo mientras que haya uno o mas componentes suscritos a el. 
Un service es implementado como una subclase de Service.

<img src="https://developer.android.com/images/service_lifecycle.png"/>

####Ejemplo de service

```
package com.belatrixsf.androidcomponents.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class IntentServiceExample extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.belatrixsf.androidcomponents.services.action.FOO";
    private static final String ACTION_BAZ = "com.belatrixsf.androidcomponents.services.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.belatrixsf.androidcomponents.services.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.belatrixsf.androidcomponents.services.extra.PARAM2";

    public IntentServiceExample() {
        super("IntentServiceExample");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, IntentServiceExample.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, IntentServiceExample.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionFoo(param1, param2);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
```

####Qué es un Broadcast Receiver?
Es un componente que permite al sistema entregar eventos fuera del flujo tradicional de interaccion con el usuario tales como estado de la bateria, estado de la conexión o si es que la pantalla ha sido apagada. Una aplicacion también puede iniciar un broadcast para de esta manera anunciar a otras aplicaciones algún evento en específico. Un broadcast receiver es capaz de crear una notificacion en la barra de estado para indicar al usuario un evento. 
Un broadcast receiver es implementado como una subclase de BroadcastReceiver.

####Ejemplo de Broadcast Receiver

```
package com.belatrixsf.androidcomponents.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ExampleReceiver extends BroadcastReceiver {
    public ExampleReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

```

####Qué es un Content Provider?
A través de un content provider otras aplicaciones pueden leer y modificar (si es que el CP lo permite) data de tu aplicación. Un ejemplo muy usado es el content provider usado para leer los contactos del usuario desde alguna aplicacion (con los debidos permisos) e incluso modificar o agregar data a ellos. 
Content providers también son muy usados para manejar la data **privada** de tu aplicación.
Para implementar un content provider es necesario hacerlo como una subclase de ContentProvider.

<img src="https://developer.android.com/guide/topics/providers/images/content-provider-overview.png" />

####Ejemplo de Content Provider

```
package com.belatrixsf.androidcomponents.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class ExampleProvider extends ContentProvider {
    public ExampleProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

```
####Ejercicios

1. Crear un flujo de actividades, por lo menos 5 actividades para navegar entre ellas.

2. Siguiendo los conceptos de la clase pasada, armar una galería, en una actividad tendras varias imagenes (no es necesario usar adaptadores ya que aun no se ha visto) y al darle click te mandara a una nueva actividad.

####Referencias

- https://developer.android.com/guide/components/activities/intro-activities.html
- https://developer.android.com/guide/components/activities/activity-lifecycle.html
- https://developer.android.com/guide/components/broadcasts.html 
- https://developer.android.com/guide/topics/providers/content-providers.html
- https://developer.android.com/guide/components/services.html
- https://github.com/cpinan/AndroidNanodegree/blob/master/SuperDuo/alexandria/app/src/main/java/it/jaschke/alexandria/data/AlexandriaContract.java
- http://android.inspired-ui.com/
