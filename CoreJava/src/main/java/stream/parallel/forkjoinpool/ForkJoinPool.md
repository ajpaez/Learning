

ForkJoin Pool

ForkJoin Pool fue introducido con Java 7 y en Java 8 para permitir los streams paralelos, entre otros. 
ForkJoin está basado en computación paralela, donde un problema es dividido en varios sub-problemas bastantes simples de resolver simultaneamente en hilos sepasador, cuyos resultados despues serán reagrupados.
Es es similar a la interfaz Executor pero con una diferencia, ForkjoinPools actúan de manera recursiva, a diferencia de los threads de Executor. ForkJoinPool divide la tarea en tareas más pequeñas, y esas tareas más pequeñas se dividen de nuevo en subtareas hasta que cada subtarea es atómica. Esto permite que funcione recursivamente.

![enter image description here](https://dzone.com/storage/temp/2808176-image1.jpeg)

Existen dos concetos basicos en esta clase:

* Fork: Divida la tarea más grande en tareas más pequeñas.
* Join: Obtener resultados de subtareas inmediatas.

El algoritmos que se ha utilizado en las implementaciones de ForkJoin es el [Work-Stealing Algorithm](https://en.wikipedia.org/wiki/Work_stealing) con el fin de garantizar que la CPU no este ociosa.

El principio de este algoritmo es que ningun thread se quede sin trabajo que realizar, de este modo, los tredas que se queden ociosos tomaran tareas de los otros threads que aun estan ocupados. En otras palabras, los threads cuyo estado sea bloqueado realizaran la tarea de los threads que aun no hayan sido ejecutados y los ejecuta.

Por ejemplo, supongamos que tenemos un sistema con cutrao procesadores, P0 hasta P3 y una tarea T es dividida en 12 subtareas, desde T0 hasta T11. Cada procesador tendra tres subtareas. Pero supongamos que el procesador P3 está demasiado ocupado con una subtarea y el procesador P1 esta inactivo, ya sea por haber finalizado todas sus tareas o por estar a la espera de algún recurso. Entonces el procesador P1 pedirá al procesador P3 si necesita ayuda y tomará parte de las tareas de P3. La sigueinte imagen muestra esto mismo:

![enter image description here](http://www.futurechips.org/wp-content/uploads/2011/05/Screenshot20110530at1.38.49AM.png)