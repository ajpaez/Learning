package apr.learning.pattern.behavioral.state;

/**
 * Clase que reprensenta un estado para el robot
 * @author Antonio
 *
 */
public class RoboticStandby implements RoboticState{

private final Robot robot;
	
	public RoboticStandby(Robot robot){
		this.robot = robot;
	}
	 
	@Override
	public void walk() {
		System.out.println("In standby state...");
		robot.setState(robot.getRoboticOn());
		System.out.println("Walking...");
	}

	@Override
	public void cook() {
		System.out.println("In standby state...");
		robot.setRoboticState(robot.getRoboticCook());
		System.out.println("Cooking...");
	}

	@Override
	public void off() {
		System.out.println("In standby state...");
		robot.setState(robot.getRoboticOff());
		System.out.println("Robot is switched off");
		
	}

}
