package apr.learning.pattern.creational.builder;

/**
 * Interfaz Builder que contiene el conjunto de metodos comunes usados para construir un componente de tipo car.
 * El metodo getCar, es usado para devolver el objeto car final hacia el cliente despues de la construccion
 * @author Antonio
 *
 */
public interface CarBuilder {
	
	public void buildBodyStyle();
	public void buildPower();
	public void buildEngine();
	public void buildBreaks();
	public void buildSeats();
	public void buildWindows();
	public void buildFuelType();
	public Car getCar();
}
