package apr.learning.pattern.behavioral.mediator.colleges;

import apr.learning.pattern.behavioral.mediator.MachineMediator;


// 1º
public class Button implements Colleague {
	
	private MachineMediator mediator;
	
	@Override
    public void setMediator(MachineMediator mediator){
		this.mediator = mediator;
	}
	
	public void press(){
		System.out.println("Button pressed.");
		mediator.start();
	}

}
