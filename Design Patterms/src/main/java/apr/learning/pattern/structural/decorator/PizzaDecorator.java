package apr.learning.pattern.structural.decorator;

/**
 * Clase abstracta que represneta 
 * el decorator para los tipos de pizzas, ademas implementa
 * la misma interfaz que los tipo de pizzas 
 * @author Antonio
 *
 */
public abstract class PizzaDecorator implements Pizza {
	
	@Override
	public String getDesc() {
		return "Toppings";
	}

}
