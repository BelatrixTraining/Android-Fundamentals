# Android-Fundamentals

## Fundamentos - Componentes (2h)
    
###Android OS

 - Android es un sistema operativo multi usuario basado en linux el cual
   cada aplicacion es un usuario distinto.
 - Por defecto, el SO asigna a cada aplicacion un id distinto y da
   permisos a todos los archivos en una aplicacion, asi que solo el user
   Id asignado a esa aplicacion puede acceder a ellos.
 - Cada proceso corre en su propia maquina virtual por lo tanto el
   codigo de una aplicacion corre independientemente del codigo de las
   demas.

###Aplicaciones Android
  Las aplicaciones Android están escritas en lenguaje Java (existen otras opciones como [Ceylon](https://ceylon-lang.org/ "ceylon") y [Kotlin](https://kotlinlang.org/ "Kotlin")). En este curso nos centraremos en el uso de Java.
  Con la ayuda del Android SDK Tools o un IDE como Android Studio podremos compilar un proyecto y generar el tan conocido .apk (Android Application Package). Este APK sera el archivo que todos los dispositivos con Android usaran para instalar la aplicacion.

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

####Qué es un Service?
Es un componente que permite a la aplicacion seguir corriendo en background (no estar visible). Un servicio no provee una interfaz de usuario y suele usarse para tareas prolongadas. Existen dos tipos de Services: **Started** y **Bound** Services.
Su mayor diferencia es que el primero le indica al sistema que lo deje seguir corriendo hasta terminar su trabajo mientras que el segundo se mantendra vivo mientras que haya uno o mas componentes suscritos a el. 
Un service es implementado como una subclase de Service.

####Qué es un Broadcast Receiver?
Es un componente que permite al sistema entregar eventos fuera del flujo tradicional de interaccion con el usuario tales como estado de la bateria, estado de la conexión o si es que la pantalla ha sido apagada. Una aplicacion también puede iniciar un broadcast para de esta manera anunciar a otras aplicaciones algún evento en específico. Un broadcast receiver es capaz de crear una notificacion en la barra de estado para indicar al usuario un evento. 
Un broadcast receiver es implementado como una subclase de BroadcastReceiver.

####Qué es un Content Provider?
A través de un content provider otras aplicaciones pueden leer y modificar (si es que el CP lo permite) data de tu aplicación. Un ejemplo muy usado es el content provider usado para leer los contactos del usuario desde alguna aplicacion (con los debidos permisos) e incluso modificar o agregar data a ellos. 
Content providers también son muy usados para manejar la data **privada** de tu aplicación.
Para implementar un content provider es necesario hacerlo como una subclase de ContentProvider.

##El Manifest
El manifest es un archivo donde se especifican todos los componentes de la aplicación. Adicionalemente, en el manifest también los permisos que la aplicacion requerirá, requerimientos de hardware y software y algunos datos más.

##Recursos de la aplicación
Una aplicación Android además de código requerie diversos recursos tales como imágenes, archivos de audio o de algo relacionado a la parte visual de la aplicación. Se suele definir animaciones, menus, estilos, colores e incluso los layouts de las actividades haciendo uso de archivos xml que terminan siendo recursos propios de la aplicación.
Por cada recurso que se agregue al proyecto, el sdk build tools le asignará un id único el cual será utilizado para referenciar este recurso desde el código. 

![R class example](https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson1/images/RClassExample.png)

##Estructura del proyecto

![Estructura de un proyecto](https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson1/images/estructuraProyecto.png)

Para ver que otro tipos de recursos se pueden manejar en una aplicación revisar el siguiente [link](https://developer.android.com/guide/topics/resources/providing-resources.html).

##Cómo... ??

###Manejar distintas orientaciones 
Los layouts se almacenan dentro del directorio **layout** dentro de res.

 1. Crear una carpeta dentro del directorio **res** llamada layout-land.
![Land directory](https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson1/images/manageLandscapeDirectory.png)
 2. Crear un archivo xml (layout) llamado de **igual manera** que nuestro archivo base.
![landscapeFile](https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson1/images/landscape%20file.png)
 3. Setear el layout a la actividad

	    setContent(R.layout.activity_main)

 4. Listo! el sistema se encargará de elegir el archivo adecuado de acuerdo a la situación.

###Manejar varios idiomas
Es similar al manejo de orientaciones. En este caso todos los strings que utilicemos en nuestra aplicación deben estar definidos en el archivo **strings.xml** el cual se encuentra en el directorio **values** dentro de res. Si deseamos crear una traducción para nuestra aplicación debemos hacer lo siguiente

 1. Crear una carpeta values-(agregar terminación de idioma). Por ejemplo: values-es para español.
 2. Dentro de este directorio crear un archivo xml llamado **strings.xml**
 3. Agregar dentro de este archivo **strings.xml** las definiciones de las palabras que deseemos traducir usando el mismo identificador que en nuestro archivo por default (que es el que se encuentra dentro de **values**)
 4. Listo! el sistema identificará el idioma elegido por el usuario en el device y hara automáticamente el cambio. Si el usuario tiene un idioma que no hemos contemplado el sistema usara las definiciones por default.

Otra forma de hacer esto es haciendo uso del Traslation Editor de Android Studio.

###Manejar distintos tamaños

Se trabaja muy similar al tema de las orientaciones. Usando **qualifiers** para permitir al sistema usar el recurso correcto de acuerdo al estado actual de la pantalla. Para poder visualizar una tabla completa y ejemplos de uso de estos qualifieres hacer click en el siguiente [link](https://developer.android.com/guide/practices/screens_support.html#qualifiers).
     
