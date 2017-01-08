package apr.learning.pattern.creational.builder.nestedbuilder;

import java.util.ArrayList;
import java.util.List;

public class WheelListBuilder {

	public static WheelListBuilder newBuilder() {
		return new WheelListBuilder();
	}

	private WheelListBuilder() {
	}

	private List<Wheel> wheelList;

	public WheelListBuilder withNewList() {
		this.wheelList = new ArrayList<>();
		return this;
	}

	public WheelListBuilder withList(List wheelList) {
		this.wheelList = wheelList;
		return this;
	}

	public WheelListBuilder addWheel(Wheel wheel) {
		this.wheelList.add(wheel);
		return this;
	}

	public List<Wheel> build() {
		// test if there are 4 instances....
		return this.wheelList;
	}

	public Wheel.Builder addWheel() {
		Wheel.Builder builder = Wheel.newBuilder();
		builder.withWheelListBuilder(this);
		return builder;
	}

}
