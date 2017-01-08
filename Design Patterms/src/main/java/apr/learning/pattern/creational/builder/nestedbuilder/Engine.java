package apr.learning.pattern.creational.builder.nestedbuilder;

public class Engine {
	private int power;
	private int type;

	public Engine(Builder builder) {
		setPower(builder.power);
		setType(builder.type);
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public static final class Builder {
		private int power;
		private int type;

		private Builder() {
		}

		public Builder withPower(int power) {
			this.power = power;
			return this;
		}

		public Builder withType(int type) {
			this.type = type;
			return this;
		}

		public Engine build() {
			return new Engine(this);
		}
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	@Override
	public String toString() {
		return "Engine [power=" + power + ", type=" + type + "]";
	}

}
