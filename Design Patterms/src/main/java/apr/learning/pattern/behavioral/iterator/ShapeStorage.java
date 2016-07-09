package apr.learning.pattern.behavioral.iterator;

/**
 * clase que almacena los objetos shape, por simplicidad se inicializa
 * el array a 5
 * 
 * @author Antonio
 *
 */
public class ShapeStorage {
	
	private Shape []shapes = new Shape[5];
	private int index;
	
	public void addShape(String name){
		int i = index++;
		shapes[i] = new Shape(i,name);
	}
	
	public Shape[] getShapes(){
		return shapes;
	}
}
