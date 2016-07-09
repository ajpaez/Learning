package apr.learning.pattern.behavioral.mediator;


/**
 * interfaz que actúa como un mediador genérico. La interfaz contiene operaciones que requieren objeto de otro.
 * @author Antonio
 *
 */
public interface MachineMediator {
	
	public void start();
	public void wash();
	public void open();
	public void closed();
	public void on();
	public void off();
	public boolean checkTemperature(int temp);

}
