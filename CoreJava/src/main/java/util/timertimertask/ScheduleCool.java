package util.timertimertask;

import java.util.Timer;

public class ScheduleCool {

    public static void main(String[] args) {
	Timer timer = new Timer();
	timer.schedule(new MyTaskCool(), 0, 5 * 1000);
	
	try {
	    Thread.sleep(30 * 1000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	//detiene el resto de tareas programadas, pero espera que finalice la actual
	timer.cancel();	
    }

}
