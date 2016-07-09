package apr.learning.pattern.behavioral.memento;

/**
 * Clase usada para almacenar el estado del Originator y que sera dada al
 * caretaker. 
 * @author Antonio
 *
 */
public class Memento {

	private double x;
	private double y;

	public Memento(double x, double y){
		this.x = x;
		this.y = y;
	}

	public double getX(){
		return x;
	}

	public double getY(){
		return y;
	}
}
