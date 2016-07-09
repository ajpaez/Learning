package apr.learning.pattern.behavioral.iterator;

public class TestIteratorPattern {

	public static void main(String[] args) {
		ShapeStorage storage = new ShapeStorage();
 		storage.addShape("Polygon");
		storage.addShape("Hexagon");
		storage.addShape("Circle");
		storage.addShape("Rectangle");
		storage.addShape("Square");
		
		ShapeIterator iterator = new ShapeIterator(storage.getShapes());
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println("Apply removing while iterating...");
		iterator = new ShapeIterator(storage.getShapes());
		while(iterator.hasNext()){
			System.out.println(iterator.next());
			iterator.remove();
		}
	}

}
