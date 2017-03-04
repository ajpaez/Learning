Para JavaEE y servltes desplegados de forma standalone(independientes), las clases JAX-RS
deben desplegarse en el contenedor de servltes del servidor de aplicaiones como un Web ARchive (WAR).
Pensaremos en el contenedor de servlets como en el servidor web de su servidor de aplicaciones.
Un WAR es un archivo jar que, ademas de los ficheros con las clases Java, tambien contiene otras
libretiras Java con contenido dinamico (como JSPs) y contenido estatico (como HTML or imagenes)
que se desean publicar en nuestro website.

Tenemos que colocar nuestras clases Java dentro de este archivo para que nuestro
servidor de aplicaciones pueda desplegarlas. A continuación se muestra la 
estructura de un archivo WAR:

<any static content>
WEB-INF/
        web.xml
        classes/
        com/restfully/shop/domain/
                                  Customer.class
        com/restfully/shop/services/
                                    CustomerResource.class
                                    ShoppingApplication.class
                                    
El contenedor de servlets de nuestro servidor de aplicaciones publicara todo lo que este fuera del
dirctorio WEB-INF/ del archivo .war. Este es donde tu deberas colocar los ficheros estaticos
y las imagenes que quieras exponer. El directorio WEB-INF/ tiene dos subdirectorios:
+ classes/ donde se pueden encontrar las clases JAVA que se usen, debe de tener una estructura de
paquetes JAVA
+ lib/ donde encontraremos cualquier JAR de terceros que usemos en nuestra aplicacion.


Por ultimo tambien encontraremos dentro del directorio WEB-INF/ el fichero web.xml, 