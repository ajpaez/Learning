package apr.learning.pattern.structural.flyweight;

/**
 * 
 * @author Antonio
 * interfaz que usaran las distintas plataformas para ejecutar su codigo
 */
public interface Platform {

	public void execute(Code code);
}
