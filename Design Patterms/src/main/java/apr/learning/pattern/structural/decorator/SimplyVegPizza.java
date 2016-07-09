package apr.learning.pattern.structural.decorator;
/**
 * Clase concreta para Pizza
 * @author Antonio
 *
 */
public class SimplyVegPizza implements Pizza{

	@Override
	public String getDesc() {
		return "SimplyVegPizza (230)";
	}
	
	@Override
	public double getPrice() {
		return 230;
	}


}
