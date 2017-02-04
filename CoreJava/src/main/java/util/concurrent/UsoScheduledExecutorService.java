package util.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import util.timertimertask.MyTaskCool;

/**
 * 
 * Dado que el API ScheduleExecutorService acepta tanto Runnable como Callable
 * para tareas a realizar, es posible que múltiples Runnable y/o Callables se
 * envíen para ser ejecutados por nuestro ScheduledExecutorService en el mismo
 * tiempo de ejecución; La cola de trabajo tiene un orden FIFO
 * (first-in-first-out) para su ejecución. Esto apunta inmediatamente a un hecho
 * práctico que no se pueden comprometer garantías en tiempo real para la
 * ejecución de las tareas. Las tareas que se envían al ScheduleExecutorService
 * están en cola. Si la tarea aún no ha sido programada para su ejecución por el
 * sistema, cancelarla cancela su ejecución futura, pero la tarea no se elimina
 * de la cola inmediatamente hasta que se consume el initial delay establecido.
 * Si la duración del delay es significativamente alta, entonces esto implicará
 * un atasco de la cola especialmente si es superior al límite! Para evitar
 * estas situaciones, podemos eliminar las tareas tan pronto como se cancelen
 * mediante setRemoveOnCancelPolicy(true)
 *
 */
public class UsoScheduledExecutorService {

	private static final long PERIOD_MILI_SECOND = 3000L;

	public static void main(String[] args) {
		ScheduledExecutorService execService = Executors.newScheduledThreadPool(2);
		execService.scheduleAtFixedRate(new MyTaskCool(), 0, PERIOD_MILI_SECOND, TimeUnit.MILLISECONDS);

	}

}
