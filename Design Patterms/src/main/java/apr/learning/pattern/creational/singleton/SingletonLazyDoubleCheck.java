package apr.learning.pattern.creational.singleton;

public class SingletonLazyDoubleCheck {

	private volatile static SingletonLazyDoubleCheck sc = null;
	private SingletonLazyDoubleCheck(){}
	public static SingletonLazyDoubleCheck getInstance(){
		if(sc==null){
			synchronized(SingletonLazyDoubleCheck.class){
				if(sc==null){
					sc = new SingletonLazyDoubleCheck();
				}	
			}
		}
		return sc;
	}
}

