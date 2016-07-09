package apr.learning.pattern.structural.flyweight;

public class TestFlyweight {

	public static void main(String[] args) {

		Code code = new Code();
		code.setCode("C Code...");
		Platform platform = PlatformFactory.getPlatformInstance('C');
		platform.execute(code);
		System.out.println("-------------------------------------");
		code = new Code();
		code.setCode("C Code2...");
		platform = PlatformFactory.getPlatformInstance('C');
		platform.execute(code);
		System.out.println("-------------------------------------");
		code = new Code();
		code.setCode("JAVA Code...");
		platform = PlatformFactory.getPlatformInstance('J');
		platform.execute(code);
		System.out.println("-------------------------------------");
		code = new Code();
		code.setCode("JAVA Code2...");
		platform = PlatformFactory.getPlatformInstance('J');
		platform.execute(code);
		System.out.println("-------------------------------------");
		code = new Code();
		code.setCode("RUBY Code...");
		platform = PlatformFactory.getPlatformInstance('R');
		platform.execute(code);
		System.out.println("-------------------------------------");
		code = new Code();
		code.setCode("RUBY Code2...");
		platform = PlatformFactory.getPlatformInstance('R');
		platform.execute(code);
		System.out.println("-------------------------------------");
		code = new Code();
		code.setCode("JAVA Code...");
		platform = PlatformFactory.getPlatformInstance('J');
		platform.execute(code);
	}

}
