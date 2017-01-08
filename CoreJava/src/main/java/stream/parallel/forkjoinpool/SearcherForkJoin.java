package stream.parallel.forkjoinpool;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class SearcherForkJoin extends RecursiveTask<Boolean> {
	int[] arr;
	int searchableElement;

	SearcherForkJoin(int[] arr, int search) {
		this.arr = arr;
		this.searchableElement = search;
	}

	@Override
	protected Boolean compute() {
		int mid = (0 + arr.length) / 2;
		System.out.println(Thread.currentThread().getName() + " says : After splliting the arry length is :: "
				+ arr.length + " Midpoint is " + mid);
		if (arr[mid] == searchableElement) {
			System.out.println("FOUND !!!!!!!!!");
			return true;
		} else if (mid == 1 || mid == arr.length) {
			System.out.println("NOT FOUND !!!!!!!!!");
			return false;
		} else if (searchableElement < arr[mid]) {
			System.out.println(Thread.currentThread().getName() + " says :: Doing Left-search");
			int[] left = Arrays.copyOfRange(arr, 0, mid);
			SearcherForkJoin forkTask = new SearcherForkJoin(left, searchableElement);
			forkTask.fork();
			return forkTask.join();
		} else if (searchableElement > arr[mid]) {
			System.out.println(Thread.currentThread().getName() + " says :: Doing Right-search");
			int[] right = Arrays.copyOfRange(arr, mid, arr.length);
			SearcherForkJoin forkTask = new SearcherForkJoin(right, searchableElement);
			forkTask.fork();
			return forkTask.join();
		}
		return false;
	}
}
