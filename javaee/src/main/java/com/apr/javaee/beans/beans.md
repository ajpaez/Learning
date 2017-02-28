#¿Qué es un Bean de Sesión?
Un bean de sesión encapsula la lógica de negocio que puede invocarse mediante programación por un cliente en vistas de cliente local, remoto o de servicio web.
Para acceder a una aplicación desplegada en el servidor, el cliente invoca los métodos del bean de sesión. El bean de sesión realiza el trabajo para su cliente,
protegiéndolo de la complejidad mediante la ejecución de tareas de negocio dentro del servidor.
Un bean de sesión no es persistente. (Es decir, sus datos no se guardan en una base de datos).
Los beans de sesión son de tres tipos: stateful, stateless y singleton.

#Singleton
Singleton se notifica cuando la aplicación se inicia y se detiene Puede ser invocado por varios threads a la vez.

#Stateful
Cada bean de sesión con estado debe anotarse con la anotacion @Stateful. El estado de un objeto consiste en los valores de sus variables de instancia. 
En un bean de sesión con estado, las variables de instancia representan el estado de una sesión cliente-bean única. Debido a que el cliente interactúa con su bean, 
a menudo este estado se llama estado de conversación. Cada bean de sesión con estado tiene dos interfaces expuestas para sus cliente, una local y otra remota. 
Los bean de sesión con estado no son compartidos, solo puede tener un cliente, de la misma manera que una sesión interactiva solo puede tener un usuario. 
Cuando el cliente termina, su bean de sesión con estado termina y ya no está asociado con el cliente.
Cuando la anotación @Remote o @Local no están presentes en la clase que define el bean, todas las interfaces de este se consideran locales, a menos que se anote explícitamente lo contrario.

#Stateless
Los beans de sesión sin estado son beans de sesión cuyas instancias no tienen estado. 
Esto significa que todas las instancias de bean son equivalentes cuando no están involucradas en algún método dentro de un servicio invocado por el cliente. 
El término 'stateless' significa que una instancia no tiene estado para un cliente específico. 
Cuando un cliente invoca los métodos de un bean sin estado, las variables de instancia del bean pueden contener un  estado específico para ese cliente, pero sólo durante la duración de la invocación. 
Los beans sin estado son compartidos. El problema que este conlleva es que un grupo de instancias son idénticas y no se garantiza que se obtenga la misma instancia en cada llamada.

##Anotaciones
* @Startup:  hace que el bean sea instanciado por el contenedor cuando la aplicación se inicie (modo eagerly). En caso de no indicar dicha anotación, el contenedor 
instanciara el bean de forma lazily cuando sea accecido por primera vez. 

* @AccessTimeout(value = X, unit = TimeUnit.SECONDS): permite configurar cuanto tiempo un hilo debe de esperar para adquirir el bloqueo de lectura o escritura de una clase o un método, cuando este se
encuentre bloqueado por un primer hilo.

La semántica del atributo value es la siguiente:

   + Un value > 0 indica un valor de tiempo de espera en las unidades especificadas por el atributo unit
   
   + Un value de 0 significa que el acceso concurrente no está permitido.
   + Un value de -1 indica que la petición del cliente bloqueará indefinidamente hasta que progrese hacia delante la ejecución actual.
   
   +  Asynchronous: esta anotación crea de forma sencilla hilos asíncronos de procesamiento. Cada llamada a estos métodos devuelve un objeto Future (Un Java Future es un objeto que se construye para albergar un valor en un futuro)
    que comienza vacío y posteriormente su valor es seteado por el contenedor cuando se realiza realmente la llamada al método relacionado.  
Para preguntar por el valor del resultado del método, lo podemos hacer con el resultado Future obtenido: Future<?>.get(). Esto esperará a que se complete la
ejecución (si aun no se ha completado) y obtiene su resultado. También podemos conocer si está este valor disponible con su método isDone().

##Tipos de concurrencia

+ Bean-Managed Concurrency
@ConcurrencyManagement(BEAN): el contenedor envía todas las invocaciones al bean y deja que este se encargue del como y el cuando sincronizar el acceso

+  Container-Managed Concurrency
@ConcurrencyManagement(CONTAINER): por defecto, de esta forma es el contenedor quien controla si se debe permitir el acceso multihilo al bean (@Lock(READ)), o si el acceso debe de ser de un solo hilo (@Lock(WRITE))


##Tipos de bloqueos
A menos que se indique otro valor, el valor predeterminado es @Lock(WRITE)

Estos bloqueos usan la API java.util.concurrent.ReadWriteLock

- @Lock(READ): Esta anotación permite un acceso concurrente a los métodos (suponiendo que no se bloqueen los accesos de escritura). 

- @Lock(WRITE): bloquea de forma exclusiva el bean mientras la llamada que ha realizado este activa y el resto de hilos deben de esperar


##Orden de instanciación
Si un singleton se refiere a otro en el método anotado con @PostConstruct o @PreDestroy, se debe de indicar el orden en el que dichos 
singleton se van a instanciar. Este orden se indica con la anotacion @DependsOn