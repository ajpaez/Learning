package apr.learning.pattern.structural.decorator;

/**
 * Clase concreta de decorator 
 * @author Antonio
 *
 */
public class Ham extends PizzaDecorator{

	private final Pizza pizza;
	
	public Ham(Pizza pizza){
		this.pizza = pizza;
	}

	@Override
	public String getDesc() {
		return pizza.getDesc()+", Ham (18.12)";
	}


	@Override
	public double getPrice() {
		return pizza.getPrice()+18.12;
	}

}