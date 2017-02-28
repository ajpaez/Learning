#CDI

##Inject
Para activar la injeccion de dependecias bastará con añadir el fichero beans.xml dentro del directorio META-INF dentro de un modulo o un el jar.
Cuando el contenedor construye un bean con una referencia a @Inject, primero busca el objecto o crea uno nuevo para ser inyectado.

##RequestScoped
Un objeto que se define como @RequestScoped se crea una vez para cada solicitud y 
es compartido por todo los beans que lo inyecta a lo largo de una solicitud.

##RequestScoped
Un objeto creado con la definición de @ApplicationScope es creado una vez para toda la duración de la aplicación.

##Interceptor
Un interceptor consta de dos partes: la interfaz de notación que lo define y la clase que implementa dicha interfaz. Un interceptor puede usarse a nivel de clase o a nivel de método.
Se puede usar mas de un interceptor en la misma clase/metodo. Debido a esto anterior, podemos indicar la prioridad de cada uno de ellos.
La interfaz que define el interceptor es únicamente usada para la creación de la anotación que posteriormente se usará en las clases que se desea usar dicho interceptor.
La clase que define la lógica del interceptor puede tener cuatro comportamientos distintos, cada uno de ellos a nivel de interceptor:
 	- Interceptores a nivel del constructor: @AroundConstruct
 	- Interceptores a nivel de método: @AroundInvoke
 	- Interceptores asociados a timeout de métodos: @AroundTimeout (solo se usan en EJB con servicios de timer)
 	- Interceptores a nivel de ciclo de vida: @PostConstruct y @PreDestroy
 	
Ademas, si usamos un interceptor a nivel de clase y no queremos que se intercepte alguno de sus métodos, simplemente lo excluiremos con esta anotación: @ExcludeClassInterceptors

##Producer
Producer proporciona un mecanismo de inicialización flexible de beans. Los producers son capaces de proporcionar implementaciones de interfaz especificas de acuerdo con las necesidades del consumidor
por lo que son na forma valida para apoyar el polimorfismo en una aplicación CDI.
//TODO: hablar del dispouser