package apr.learning.pattern.behavioral.observer.impl;

public interface Observer {

	public void update(String desc);
	public void subscribe();
	public void unSubscribe();
}
