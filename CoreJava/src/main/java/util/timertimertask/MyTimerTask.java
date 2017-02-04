package util.timertimertask;

import java.util.Date;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {

	static int tarea = 0;

	@Override
	public void run() {
		System.out.println("Timer task: " + tarea + " started at: " + new Date());
		completeTask();
		System.out.println("Timer task: " + tarea + " finished at: " + new Date());
		tarea++;
	}

	private void completeTask() {
		try {
			// assuming it takes 10 secs to complete the task
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
