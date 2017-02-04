package util.concurrent;

import util.timertimertask.MyTaskCool;

/**
 * ThreadPool es un potente mecanismo para estructurar aplicaciones
 * mulitproceso. Las aplicaicones construuidas con agrupaciones de subprocesos
 * puden tener los mismos riesgos de concurrencia que cualquier otra aplicacion
 * de varios subprocesos, como deadlock, fallos de recursos, sincronizacion o
 * errores de concurrencia, perdida de hilos y sobrecarga de solicitudes.
 * Algunos puntos a tener en cuenta son: - No añadir a la cola tareas con wait
 * sincronizados con otras tareas, ya que pueden causar deadlock - Si la tarea
 * requiere un wait por un recurso como un I/O, especificar un tiempo maximo
 * para el wait y transcurrido este fallar o reencolar la tarea. Esto garantiza
 * que se logrará cierto progreso al liberar el hilo para que otra tarea pueda
 * completarse con éxito. - Adecuar el tamaño del thread pool de forma eficaz.
 *
 */

public class UsoThreadPool {

	public static void main(String[] args) {
		ThreadPool pool = new ThreadPool(7);

		for (int i = 0; i < 5; i++) {
			MyTaskCool task = new MyTaskCool();
			pool.execute(task);
		}
	}

}
