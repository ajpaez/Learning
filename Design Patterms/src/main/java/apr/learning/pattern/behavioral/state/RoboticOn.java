package apr.learning.pattern.behavioral.state;


/**
 * Clase que reprensenta un estado para el robot
 * @author Antonio
 *
 */
public class RoboticOn implements RoboticState{

	private final Robot robot;
	
	public RoboticOn(Robot robot){
		this.robot = robot;
	}
	 
	@Override
	public void walk() {
		System.out.println("RoboticOn -> Walking...");
	}

	@Override
	public void cook() {
		System.out.println("RoboticOn -> Cooking...");
		robot.setRoboticState(robot.getRoboticCook());
	}

	@Override
	public void off() {
		robot.setState(robot.getRoboticOff());
		System.out.println("RoboticOn -> Robot is switched off");
		
	}

}
