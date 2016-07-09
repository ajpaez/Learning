package apr.learning.pattern.behavioral.command;

import apr.learning.pattern.behavioral.command.jobs.Email;
import apr.learning.pattern.behavioral.command.jobs.FileIO;
import apr.learning.pattern.behavioral.command.jobs.Logging;
import apr.learning.pattern.behavioral.command.jobs.Sms;
import apr.learning.pattern.behavioral.command.jobs.impl.EmailJob;
import apr.learning.pattern.behavioral.command.jobs.impl.FileIOJob;
import apr.learning.pattern.behavioral.command.jobs.impl.LoggingJob;
import apr.learning.pattern.behavioral.command.jobs.impl.SmsJob;

public class TestCommandPattern {
	public static void main(String[] args)
    {
        init();
    }
 
    private static void init()
    {
        ThreadPool pool = new ThreadPool(10);
        
        Email email = null;
        EmailJob  emailJob = new EmailJob();
        
        Sms sms = null;
        SmsJob smsJob = new SmsJob();
        
        FileIO fileIO = null;
        FileIOJob fileIOJob = new FileIOJob();
        
        Logging logging = null;;
        LoggingJob logJob = new LoggingJob();
        
        for (int i = 0; i < 5; i++) {
        	email = new Email();
        	emailJob.setEmail(email);
        	
        	sms = new Sms();
        	smsJob.setSms(sms);
        	
        	fileIO = new FileIO();
        	fileIOJob.setFileIO(fileIO);
        	
        	logging = new Logging();
        	logJob.setLogging(logging);
        	
            pool.addJob(emailJob);
            pool.addJob(smsJob);
            pool.addJob(fileIOJob);
            pool.addJob(logJob);
        }
        pool.shutdownPool();
    }

}
