package apr.learning.pattern.behavioral.strategy;

public class TestStrategyPattern {

	public static void main(String[] args) {
		TextFormatter formatter = new CapTextFormatter();
		TextEditor editor = new TextEditor(formatter);
		editor.publishText("Testing text in caps formatter");
		
		formatter = new LowerTextFormatter();
		editor = new TextEditor(formatter);
		editor.publishText("Testing text in lower formatter");

	}

}
