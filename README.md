# Android-Fundamentals
Android Fundamentals (20h)
   
##Fragments Fundamentos

Un fragmento es una clase reusable que implementa una porción de una actividad. Los fragmentos deben estar dentro de una actividad, es decir, no pueden correr independientemente de ellas.

![Fragments](https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson6/images/fragments1.png)

Algunos conceptos básicos respecto a los fragmentos

 - Un fragmento, al igual que una actividad, tiene un xml en el cual se especifica su layout.
 - Los fragmentos encapsulan vista y lógica, lo cual hace mucho mas fácil su reuso dentro de otras actividades.
 - Los fragmentos son soportados en todas las versiones de Android gracias al uso del support library.
 

###En qué situaciones se debe usar un fragmento?

Hay diversas circunstancias en las que se puede usar un fragmento. Las mas usuales son

 * **Reuso de vista y lógica** - Fragmentos permiten reutilizar partes de una pantalla (incluyendo vista y lógica). 
 * **Soporte para tablets** - Normalmente, la versión para tablet de una aplicación tiene una UI distinta que la version para smartphone. Los fragmentos hacen posible a las actividades reutilizar elementos comunes y a la vez presentar diferencias.
 * **Orientación de la pantalla** - Usualmente, el diseño de la pantalla en orientación vertical es distinto al de la orientación horizontal. Los fragmentos posibilitan a las dos orientaciones reutilizar elementos comunes.

### Ciclo de vida
Similar a la actividad, un fragmento tiene varios métodos los cuales se pueden sobreescribir.

- `onAttach()` Es llamado cuando un fragmento es conectado al activity.
- `onCreate()` Es llamado en la creación inicial del fragmento.
- `onCreateView()` Es llamado cuando el fragmento debe inflar la vista.
- `onViewCreated()` Es llamado luego del `onCreateView()` y asegura que la raiz del fragmento es no nula. 
- `onActivityCreated()` Es llamado una vez que la actividad que *hostea* ha completado su método`onCreate()`.
- `onStart()` Es llamado cuando el fragmento esta listo para mostrarse en pantalla.
- `onResume()` - Se usa para asignar recursos "costosos"tales como updates a sensores o locaciones.
- `onPause()` - Se usa para liberar recursos "costosos".
- `onDestroyView()` Es llamado cuando la vista del fragmento esta siendo destruida pero el fragmento aún existe.
- `onDestroy()` Es llamado cuando el fragmento ya no está en uso.
- `onDetach()` Es llamado cuando el fragmento ya no está conectado a la actividad.

En la siguiente imagen podemos apreciar el orden de ejecucion:

<a href="https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson6/images/fragment_lifecycle2.png"><img src="https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson6/images/fragment_lifecycle2.png" alt="lifecycle" width="500" /></a>


Aquí podemos ver un ejemplo de como implementar los métodos que son parte del ciclo de vida del fragmento:

```java
public class MyFragment extends Fragment {
    MyAdapter adapter;
    FragmentActivity listener;
        
    // Este evento se ejecuta primero, antes de la creacion del 
    // fragmento o vista alguna. 
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity){
            this.listener = (FragmentActivity) context;
        }
    }
       
    // Este evento se dispara en segundo lugar, antes de que la vista 
    // del fragmento sea creada, en el momento en que la instancia
    // del fragmento es creada (o recreada)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<MyObject> arrayList = new ArrayList<MyObject>();
        adapter = new MyAdapter(getActivity(), arrayList);
    }

    // Este método es llamado cuando el fragmento debe crear su 
    // propia vista ya sea de manera dinámica o via xml.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment, parent, false);
    }
    
    // Este evento es llamado luego del onCreateView().
    // onViewCreated() solo es llamado si la vista creada en el
    // onCreateView() no es nula. Todo el setup de la lista debe
    // ser trabajado aca.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ListView listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    // Este método es llamado cuando el fragmento ya no está más conectado con la actividad.
    @Override
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }
        
    // Este método es llamado una vez que el onCreate() de la actividad ha sido completado.
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
```


## Cómo crear un fragmento?

### Definamos el fragmento
Al igual que un activity, un fragmento tiene un archivo XML donde se especifica el layout y una clase Java que representa al controlador del [Fragment](http://developer.android.com/reference/android/app/Fragment.html).


```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" >

    <TextView
        android:id="@+id/textview"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="TextView" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button" />

</LinearLayout>
```

La clase Java:

```java
import android.support.v4.app.Fragment;

public class FooFragment extends Fragment {
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_foo, parent, false);
    }
	
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        TextView textView = (TextView) view.findViewById(R.id.textview);
    }
}
```

### Embedding a Fragment in an Activity

Existen dos maneras de agregar un fragmento a un activity: haciéndolo dinámicamente, a través de Java, y estáticamente usando XML. 
Para esto la actividad debe extender de `FragmentActivity` o `AppCompatActivity`. Clases que agregan soporte al manejo de fragmentos.:

```java
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // ...
}
```

#### Manera estática

Para agregar el fragmento de manera estática basta con tan solo agregar el fragmento en el layout de la actividad de la siguiente manera:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical" >

    <fragment
        android:name="com.example.android.FooFragment"
        android:id="@+id/fooFragment"
        android:layout_width="match_parent" 
        android:layout_height="match_parent" />

</LinearLayout>
```

Hay que tener en cuenta que un fragmento agregado estáticamente no puede ser remplazado. Solo pueden ser reemplazados los fragmentos que fueron agregados dinámicamente

#### Manera dinámica

La segunda manera es agregando el fragmento de forma dinámica haciendo uso del `FragmentManager`. La clase `FragmentManager` y `FragmentTransaction` permiten agregar, remover y reemplazar fragmentos a la actividad en tiempo de ejecución.

En este caso es necesario agregar un contenedor (normalmente es un `FrameLayout`) a la actividad en donde el fragment será agregado:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical" >

  <FrameLayout
       android:id="@+id/container"
       android:layout_width="match_parent"
       android:layout_height="match_parent">
  </FrameLayout>

</LinearLayout>
```

Luego haremos uso del `FragmentManager` y de `FragmentTransaction` que nos permitirán agregar el fragmento:

```java
// Comenzar la transacción
FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
// Reemplaza el contenido del container por el del fragment
ft.replace(R.id.container, new FooFragment());
// or ft.add(R.id.container, new FooFragment());
// Completar los cambios
ft.commit();
```


### Obteniendo la instancia de un fragmento creado

Hay situaciones en las que necesitamos obtener la instancia de un fragmento dentro de una actividad. Hay algunos métodos que nos ayudan a hacerlo:

 1. `findFragmentById`: Cuando usemos este método tendremos que utilizar el id del container como parámetro:
```java
DemoFragment fragmentDemo = (DemoFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentDemo);
```
 2. `findFragmentByTag`: Solo podemos usar este método si es que el fragmento fue agregado usando un tag:
```java
getSupportFragmentManager().beginTransaction().replace(R.id.flContainer, new DemoFragment(), "TAG").
```
obtendremos su instancia de la siguiente manera:
```java
DemoFragment fragmentDemo = (DemoFragment)getSupportFragmentManager().findFragmentByTag("TAG");
```
 
### Comunicación con los fragmentos

Los fragmentos se comunican con su actividad padre permitiéndole a esta manejar las entradas y salidas de data desde ese fragmento hacia algún otro fragmento u otra actividad. Lo importante es recordar que **los fragmentos no deben comunicarse directamente con otros fragmentos** y **deberían solo comunicarse con su actividad padre**. Los fragmentos deben ser componentes modulares, reusables y autónomos.

Hay tres maneras en las que un fragmento y una actividad pueden comunicarse:

1. **Bundle** - La actividad puede construir un fragment y *setear* argumentos.
2. **Methods** - La actividad puede llamar a métodos de una instancia de un fragment.
3. **Listener** - El fragmento puede disparar eventos en una actividad haciendo uso de una interface.



## References

 * <http://developer.android.com/guide/components/fragments.html>
 * <http://developer.android.com/reference/android/app/Fragment.html>
 * <http://xperiment-andro.blogspot.com/2013/02/nested-fragments.html>
 * <http://www.vogella.com/articles/AndroidFragments/article.html>
 * <http://developer.android.com/training/basics/fragments/creating.html>