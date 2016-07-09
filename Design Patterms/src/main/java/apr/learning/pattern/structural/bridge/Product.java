package apr.learning.pattern.structural.bridge;

/**
 * Implementador que tiene los metodos concretos que serán los usados en las implementaciones concretas
 * para realiza la funcionalidade de cada una de ellas.
 * @author Antonio
 *
 */
public interface Product {
	
	public String productName();
	public void produce();
}
