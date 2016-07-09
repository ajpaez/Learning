package apr.learning.pattern.behavioral.iterator;

import java.util.Iterator;

/**
 * Iterator para la clase ShapeStorage, implementa la interfaz Iterator y
 * define todos los metodos de dicha interfaz
 * @author Antonio
 *
 */
public class ShapeIterator implements Iterator<Shape>{

	private Shape [] shapes;
	int pos;
	
	public ShapeIterator(Shape []shapes){
		this.shapes = shapes;
	}
	@Override
	public boolean hasNext() {
		if(pos >= shapes.length || shapes[pos] == null)
			return false;
		return true;
	}

	@Override
	public Shape next() {
		return shapes[pos++];
	}

	@Override
	public void remove() {
		if(pos <=0 )
			throw new IllegalStateException("Illegal position");
		if(shapes[pos-1] !=null){
			for (int i= pos-1; i<(shapes.length-1);i++){
				shapes[i] = shapes[i+1];
			}
			shapes[shapes.length-1] = null;
		}
	}
}
