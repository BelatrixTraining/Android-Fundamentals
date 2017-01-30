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

<a href="https://i.imgur.com/0EVReuq.png"><img src="https://i.imgur.com/0EVReuq.png" alt="lifecycle" width="500" /></a>