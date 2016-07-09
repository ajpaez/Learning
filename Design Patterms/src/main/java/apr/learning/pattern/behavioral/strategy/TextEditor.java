package apr.learning.pattern.behavioral.strategy;

/**
 * clase que mantiene una referencia a la interfaz TextFormatter. La clse contiene el metodo
 * publishText mediante el ful devuelve el texto formateado.
 * @author Antonio
 *
 */
public class TextEditor {
	
	private final TextFormatter textFormatter;
	
	public TextEditor(TextFormatter textFormatter){
		this.textFormatter = textFormatter;
	}
	
	public void publishText(String text){
		textFormatter.format(text);
	}

}
