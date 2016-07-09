package apr.learning.pattern.creational.prototype;

/**
 * Para implementar el patron se hará uso de la interfaz Cloneable.
 * La interfaz que aqui se describe será la implementada por las clases que quieran crear un objeto prototipo
 * @author Antonio
 *
 */
public interface Prototype extends Cloneable {
	
	public AccessControl clone() throws CloneNotSupportedException;

}
