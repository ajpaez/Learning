package stream.parallel.forkjoinpool;

import java.util.concurrent.ForkJoinPool;

public class FibonacciComutationClient {

	public static void main(String args[]) {
		// to calculate 20th element of Fibonacci-Series
		int number = 6;

		// poolSize indica el numero de procesadores del sistema
		int poolSize = Runtime.getRuntime().availableProcessors();
		// obtenemos nuestro objeto pool de ForkJoin
		ForkJoinPool pool = new ForkJoinPool(poolSize);

		long beforeTime = System.currentTimeMillis();

		System.out.println("Parallelism  => " + pool.getParallelism());

		Integer result = pool.invoke(new FibonacciComputation(number));

		System.out.println("Total Time in MilliSecond Taken ->  " + (System.currentTimeMillis() - beforeTime));

		System.out.println(number + "the element of Fibonacci Number = " + result);
	}

}
