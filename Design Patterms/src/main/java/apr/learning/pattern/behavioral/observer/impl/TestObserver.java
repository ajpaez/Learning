package apr.learning.pattern.behavioral.observer.impl;

import java.util.ArrayList;

public class TestObserver {

	public static void main(String[] args) {
		Subject subject = new CommentaryObject(new ArrayList<Observer>(), "Soccer Match [2014AUG24]");
		Observer observer = new SMSUsers(subject, "Adam Warner [New York]");
		observer.subscribe();
		
		System.out.println();
		
		Observer observer2 = new SMSUsers(subject, "Tim Ronney [London]");
		observer2.subscribe();
		
		Commentary cObject = ((Commentary)subject);
		cObject.setDesc("Welcome to live Soccer match");
		cObject.setDesc("Current score 0-0");
		
		System.out.println();
		
		observer2.unSubscribe();
		
		System.out.println();
		
		cObject.setDesc("It's a goal!!");
		cObject.setDesc("Current score 1-0");
		
		System.out.println();
		
		Observer observer3 = new SMSUsers(subject, "Marrie [Paris]");
		observer3.subscribe();
		
		System.out.println();
		
		cObject.setDesc("It's another goal!!");
		cObject.setDesc("Half-time score 2-0");
		
	}

}
