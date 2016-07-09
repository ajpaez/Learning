package apr.learning.pattern.structural.decorator;

/**
 * Clase concreta para Pizza
 * @author Antonio
 *
 */
public class SimplyNonVegPizza implements Pizza{
	
	@Override
	public String getDesc() {
		return "SimplyNonVegPizza (350)";
	}

	@Override
	public double getPrice() {
		return 350;
	}

}
