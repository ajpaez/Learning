package apr.learning.pattern.behavioral.strategy;

public class ArialTextFormatter implements TextFormatter {

	@Override
	public void format(String text) {
		System.out.println("[ArialTextFormatter]: "+text);
	}

}
