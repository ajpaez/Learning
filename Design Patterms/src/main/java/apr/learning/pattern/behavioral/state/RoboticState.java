package apr.learning.pattern.behavioral.state;

/**
 * Interfaz que contiene el comportamiento del robot
 * @author Antonio
 *
 */
public interface RoboticState {
	
	public void walk();
	public void cook();
	public void off();

}
