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

####Ejemplo de activity

####Qué es un Service?
Es un componente que permite a la aplicacion seguir corriendo en background (no estar visible). Un servicio no provee una interfaz de usuario y suele usarse para tareas prolongadas. Existen dos tipos de Services: **Started** y **Bound** Services.
Su mayor diferencia es que el primero le indica al sistema que lo deje seguir corriendo hasta terminar su trabajo mientras que el segundo se mantendra vivo mientras que haya uno o mas componentes suscritos a el. 
Un service es implementado como una subclase de Service.

####Ejemplo de service

####Qué es un Broadcast Receiver?
Es un componente que permite al sistema entregar eventos fuera del flujo tradicional de interaccion con el usuario tales como estado de la bateria, estado de la conexión o si es que la pantalla ha sido apagada. Una aplicacion también puede iniciar un broadcast para de esta manera anunciar a otras aplicaciones algún evento en específico. Un broadcast receiver es capaz de crear una notificacion en la barra de estado para indicar al usuario un evento. 
Un broadcast receiver es implementado como una subclase de BroadcastReceiver.

####Ejemplo de Broadcast Receiver

####Qué es un Content Provider?
A través de un content provider otras aplicaciones pueden leer y modificar (si es que el CP lo permite) data de tu aplicación. Un ejemplo muy usado es el content provider usado para leer los contactos del usuario desde alguna aplicacion (con los debidos permisos) e incluso modificar o agregar data a ellos. 
Content providers también son muy usados para manejar la data **privada** de tu aplicación.
Para implementar un content provider es necesario hacerlo como una subclase de ContentProvider.

####Ejemplo de Content Provider
