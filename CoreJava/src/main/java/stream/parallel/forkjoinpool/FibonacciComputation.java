package stream.parallel.forkjoinpool;

import java.util.concurrent.RecursiveTask;

/**
 * En este ejemplo la tarea para calcular nuestra secuencia de Fibonnaci hereda
 * de la clase java.util.concurrent.RecursiveTask que hereda a su vez de
 * ForkJoinTask, esta tarea implementa su lógica en el método compute()
 * 
 * la clase java.util.concurrent.RecursiveTask ejecuta sus tareas en el metodo
 * compute() y devuelve un valor, al contrario que la clase RecursiveAction,
 * tiene el método invokeAll() que ejecuta subtareas y espera su finalización
 * antes de continuar, mientras espera a las subtareas que terminen, el worker
 * thread toma otra tarea y la ejecuta.
 * 
 * 
 * 
 * @author AntonioPC
 *
 */
public class FibonacciComputation extends RecursiveTask<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3060855712938284891L;

	private final int number;

	public FibonacciComputation(int number) {
		this.number = number;
	}

	@Override
	public Integer compute() {
		if (number <= 1)
			return number;
		FibonacciComputation f1 = new FibonacciComputation(number - 1);
		f1.fork();
		System.out.println("Current Therad Name = " + Thread.currentThread().getName() + " : " + number);
		FibonacciComputation f2 = new FibonacciComputation(number - 2);
		return f2.compute() + f1.join();
	}
}
