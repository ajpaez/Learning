package apr.learning.pattern.behavioral.memento;


/**
 * Clase Originator cuyo estado sera guardado en un Memento.
 * El objeto CareTaker se usa para vigilar, guardar y recuperar los objetos
 * Memento que representan los estados del objeto Originator.
 * En el constructor se guarda el estado inicial del objeto usando 
 * createSavepoint. Este metodo crea un objeto Memento y es enviado al caretaker.
 * La variable lastUndoSavepoint almacena el nombre del punto de recuperaciona anterior, 
 * y es usada como clave para almacenar el Memento
 * @author Antonio
 *
 */
public class Originator {

	private double x;
	private double y;

	private String lastUndoSavepoint;
	CareTaker careTaker;

	public Originator(double x, double y,CareTaker careTaker){
		this.x = x;
		this.y = y;

		this.careTaker = careTaker;

		createSavepoint("INITIAL");
	}

	public double getX(){
		return x;
	}

	public double getY(){
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void createSavepoint(String savepointName){
		careTaker.saveMemento(new Memento(this.x, this.y), savepointName);
		lastUndoSavepoint = savepointName;
	}

	public void undo(){
		setOriginatorState(lastUndoSavepoint);
	}

	public void undo(String savepointName){
		setOriginatorState(savepointName);
	}

	public void undoAll(){
		setOriginatorState("INITIAL");
		careTaker.clearSavepoints();
	}

	private void setOriginatorState(String savepointName){
		Memento mem = careTaker.getMemento(savepointName);
		this.x = mem.getX();
		this.y = mem.getY();
	}

	@Override
	public String toString(){
		return "X: "+x+", Y: "+y;
	}

}
