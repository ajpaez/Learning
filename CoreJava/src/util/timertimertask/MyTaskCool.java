package util.timertimertask;

import java.awt.Toolkit;
import java.util.TimerTask;

public class MyTaskCool extends TimerTask {

    Toolkit toolkit = Toolkit.getDefaultToolkit();

    @Override
    public void run() {

	int r = (int) (Math.random() * 10);
	if (r % 2 == 0) {
	    toolkit.beep();
	}

    }

}
