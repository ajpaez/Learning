package apr.learning.pattern.creational.builder.nestedbuilder;

import java.util.ArrayList;
import java.util.List;

public class TestNestedBuilder {

	public static void main(String[] args) {

		Engine engine = Engine.newBuilder().withPower(100).withType(5).build();

		Wheel wheel1 = Wheel.newBuilder().withType(2).withColour(3).withSize(4).build();
		Wheel wheel2 = Wheel.newBuilder().withType(2).withColour(3).withSize(4).build();
		Wheel wheel3 = Wheel.newBuilder().withType(2).withColour(3).withSize(4).build();
		Wheel wheel4 = Wheel.newBuilder().withType(2).withColour(3).withSize(4).build();

		List<Wheel> wheels = new ArrayList<>();
		wheels.add(wheel1);
		wheels.add(wheel2);
		wheels.add(wheel3);
		wheels.add(wheel4);

		List<Wheel> wheelList = WheelListBuilder.newBuilder().withNewList().addWheel(wheel1).addWheel(wheel2)
				.addWheel(wheel3).addWheel(wheel4).build();

		List<Wheel> wheelsListBuilder = WheelListBuilder.newBuilder().withNewList().addWheel().withType(1).withSize(2)
				.withColour(2).addWheelToList().addWheel().withType(1).withSize(2).withColour(2).addWheelToList()
				.addWheel().withType(1).withSize(2).withColour(2).addWheelToList().addWheel().withType(1).withSize(2)
				.withColour(2).addWheelToList().build();

		Car car = Car.newBuilder().withEngine(engine).withWheelList(wheelList).build();

		System.out.println("car = " + car);
	}

}
