package apr.learning.pattern.behavioral.observer.impl;

public class SMSUsers implements Observer{

	private final Subject subject;
	private String desc;
	private String userInfo;
	
	public SMSUsers(Subject subject,String userInfo){
		if(subject==null){
			throw new IllegalArgumentException("No Publisher found.");
		}
		this.subject = subject;
		this.userInfo = userInfo;
	}
	
	@Override
	public void update(String desc) {
		this.desc = desc;
		display();
	}
	
	
	private void display(){
		System.out.println("["+userInfo+"]: "+desc);
	}
	
	@Override
	public void subscribe() {
		System.out.println("Subscribing "+userInfo+" to "+subject.subjectDetails()+" ...");
		this.subject.subscribeObserver(this);
		System.out.println("Subscribed successfully.");
	}

	@Override
	public void unSubscribe() {
		System.out.println("Unsubscribing "+userInfo+" to "+subject.subjectDetails()+" ...");
		this.subject.unSubscribeObserver(this);
		System.out.println("Unsubscribed successfully.");
	}

}
