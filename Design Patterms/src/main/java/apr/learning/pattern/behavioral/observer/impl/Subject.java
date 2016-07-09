package apr.learning.pattern.behavioral.observer.impl;

public interface Subject {
	
	public void subscribeObserver(Observer observer);
	public void unSubscribeObserver(Observer observer);
	public void notifyObservers();
	public String subjectDetails();
}
