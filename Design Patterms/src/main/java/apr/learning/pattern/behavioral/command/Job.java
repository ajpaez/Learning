package apr.learning.pattern.behavioral.command;

/**
 * Interfaz Command, contiene un metodo run, el cual será ejecutado por un hilo.
 * Nuestro metodo para la ejecucion de comandos es el metodo run,
 * que se utiliza con el fin de realiza un trabajo.
 * Deberia existir diferentes tipos de jobs que puedan ser ejecutados. 
 * @author Antonio
 *
 */
public interface Job {

	public void run();
}
