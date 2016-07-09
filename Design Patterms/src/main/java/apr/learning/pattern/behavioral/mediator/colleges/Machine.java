package apr.learning.pattern.behavioral.mediator.colleges;

import apr.learning.pattern.behavioral.mediator.MachineMediator;

//2º
public class Machine implements Colleague {

	private MachineMediator mediator;
	
	@Override
	public void setMediator(MachineMediator mediator){
		this.mediator = mediator;
	}
	
	public void start(){
		mediator.open();
	}
	
	public void wash(){
		mediator.wash();
	}
}
