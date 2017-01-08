package apr.learning.pattern.creational.builder.nestedbuilder;

import java.util.List;

public class Car {
	private Engine engine;
	private List<Wheel> wheelList;

	public Car(Builder builder) {
		setEngine(builder.engine);
		setWheelList(builder.wheelList);
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public List<Wheel> getWheelList() {
		return wheelList;
	}

	public void setWheelList(List<Wheel> wheelList) {
		this.wheelList = wheelList;
	}

	public static final class Builder {
		private Engine engine;
		private List<Wheel> wheelList;

		private Builder() {
		}

		public Builder withEngine(Engine engine) {
			this.engine = engine;
			return this;
		}

		public Builder withWheelList(List<Wheel> wheelList) {
			this.wheelList = wheelList;
			return this;
		}

		public Car build() {
			return new Car(this);
		}
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	@Override
	public String toString() {
		return "Car [engine=" + engine + ", wheelList=" + wheelList + "]";
	}

}