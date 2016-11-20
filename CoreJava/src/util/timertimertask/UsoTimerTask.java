package util.timertimertask;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * java.util.Timer es una clase de utility que puede ser usada para programar la
 * ejecucion de un hilo cada cierto tiempo.
 * 
 * java.util.TimerTask es una clase abstracta que implementa la interfaz
 * Runnable y de la que necesitamos extender para crear nuestro propio TimerTask
 * que pueda ser programado (en el tiempo).
 * 
 * la clase Timer es Thread safe y multiples hilos pueden compartir un objeto
 * Timer sin necesidad de una sincronizacion externa. Timer usa la clase
 * java.util.TaskQueue para añadir tareas cada un intervela regular de tiempo y
 * en cualquier momento solo puede existir un hilo ejecutando el TimerTask, por
 * ejemplo, si creas un Timer para ser lanzado cada 10 segundos pero un hilo
 * tarda en ejecutarlo 20 segundos, el objeto Timer será añadido a las tareas en
 * la cola y tan pronto como el hilo termine, este notificará a la cola y otro
 * hilo comenzará la ejecucion.
 * 
 * 
 * La clase java Timer usa los metodos de sincronizacion wait y notify para
 * programar las tareas. Si el timer se ejecuta como un daemond thread, terminará
 * tan pronto como todos los subprocesos del usuario terminen de ejecutarse
 * 
 * 
 * En este ejemplo se va a lanzar una tarea cada 10 segundos
 * 
 * @author ajpaez
 *
 */
public class UsoTimerTask {

    public static void main(String args[]) {

	TimerTask timerTask = new MyTimerTask();

	// running timer task as daemon thread
	Timer timer = new Timer(true);

	// ejecuta la tarea timerTask con un retardo de 0 ms y posteriormente
	// con un periodo de 10*1000 ms
	// asi, se ejecutará repetidamente cada initialDelay + X * (10*1000),
	// donde X representa la ejecucion enesima

	// ejecutamos una tarea cada 10s, podemos ver como espera el timer a
	// finialar una para ejecutar la siguiente
	System.out.println("TimerTask started at: " + new Date());
	timer.scheduleAtFixedRate(timerTask, 0, 5 * 1000);	

	// esperamos 30 segundos
	// cancel after sometime
	try {
	    Thread.sleep(30 * 1000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	//detiene el resto de tareas programadas, pero espera que finalice la actual
	timer.cancel();	
	System.out.println("TimerTask cancelled at: " + new Date());

	
	//este sleep es para dejar terminar la tarea pendiente, en caso de no existir 
	//el Timer lanzado como daemon thread se detendrá y con el todas las tareas
	try {
	    Thread.sleep(10 * 1000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	System.out.println("End");
    }

}
