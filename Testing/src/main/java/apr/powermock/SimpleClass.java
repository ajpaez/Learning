package apr.powermock;

import java.util.Calendar;

public class SimpleClass {
	
	public String getMeCurrentDateAsString() {
		return Calendar.getInstance().getTime().toString();
		
	}

}
