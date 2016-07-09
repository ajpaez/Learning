package apr.learning.pattern.structural.flyweight;

public class CPlatform implements Platform {
	
	public CPlatform(){
		System.out.println("CPlatform object created");
	}

	@Override
	public void execute(Code code) {
		System.out.println("Compiling and executing " + code.getCode());
	}

}
