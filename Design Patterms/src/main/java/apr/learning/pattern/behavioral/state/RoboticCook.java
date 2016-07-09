package apr.learning.pattern.behavioral.state;

/**
 * Clase que reprensenta un estado para el robot
 * @author Antonio
 *
 */
public class RoboticCook implements RoboticState{

	private final Robot robot;
	
	public RoboticCook(Robot robot){
		this.robot = robot;
	}
	 
	@Override
	public void walk() {
		System.out.println("RoboticCook -> Walking...");
		robot.setRoboticState(robot.getRoboticOn());
	}

	@Override
	public void cook() {
		System.out.println("RoboticCook -> Cooking...");
	}

	@Override
	public void off() {
		System.out.println("RoboticCook -> Cannot switched off while cooking...");
	}
}
