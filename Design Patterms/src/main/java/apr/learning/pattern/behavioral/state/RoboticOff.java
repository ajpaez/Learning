package apr.learning.pattern.behavioral.state;

/**
 * Clase que reprensenta un estado para el robot
 * @author Antonio
 *
 */
public class RoboticOff implements RoboticState{

	private final Robot robot;
	
	public RoboticOff(Robot robot){
		this.robot = robot;
	}
	 
	@Override
	public void walk() {
		System.out.println("RoboticOff -> Walking...");
		robot.setRoboticState(robot.getRoboticOn());
	}

	@Override
	public void cook() {
		System.out.println("RoboticOff -> Cannot cook at Off state.");
	}

	@Override
	public void off() {
		System.out.println("RoboticOff -> Already switched off...");
	}
}
