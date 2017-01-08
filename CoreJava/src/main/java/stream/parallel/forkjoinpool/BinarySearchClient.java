package stream.parallel.forkjoinpool;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class BinarySearchClient {
	static int MAX = 100;
	int[] arr = new int[MAX];

	public BinarySearchClient() {
		init();
	}

	private void init() {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
	}

	public void createForJoinPool(int search) {
		ForkJoinPool forkJoinPool = new ForkJoinPool(50);
		SearcherForkJoin searcher = new SearcherForkJoin(this.arr, search);
		Boolean status = forkJoinPool.invoke(searcher);
		System.out.println(" Element :: " + search + " has been found in array? :: " + status);
	}

	public static void main(String[] args) {
		BinarySearchClient search = new BinarySearchClient();
		search.createForJoinPool(new Random().nextInt(MAX) + new Random().nextInt(MAX / 2));
		System.out.println("**********************");
	}

}
