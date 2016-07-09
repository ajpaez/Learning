package apr.learning.pattern.behavioral.command.jobs.impl;

import apr.learning.pattern.behavioral.command.Job;
import apr.learning.pattern.behavioral.command.jobs.Sms;

public class SmsJob implements Job{

	private Sms sms;
	
	public void setSms(Sms sms) {
		this.sms = sms;
	}


	@Override
	public void run() {
		System.out.println("Job ID: "+Thread.currentThread().getId()+" executing sms jobs.");
		if(sms!=null){
			sms.sendSms();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
	}

}
