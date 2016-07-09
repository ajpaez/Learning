package apr.learning.pattern.behavioral.memento;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que almacena dado un nombre de punto de restauracion  un Memento.
 * 
 */
public class CareTaker {


	private final Map<String, Memento>savepointStorage = new HashMap<String, Memento>();

	public void saveMemento(Memento memento,String savepointName){
		System.out.println("Saving state..."+savepointName);
		savepointStorage.put(savepointName, memento);
	}

	public Memento getMemento(String savepointName){
		System.out.println("Undo at ..."+savepointName);
		return savepointStorage.get(savepointName);
	}

	public void clearSavepoints(){
		System.out.println("Clearing all save points...");
		savepointStorage.clear();
	}


}
