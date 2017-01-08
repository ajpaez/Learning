package apr.learning.pattern.creational.builder.nestedbuilder;

public class Wheel {
	private int size;
	private int type;
	private int colour;

	private Wheel(Builder builder) {
		setSize(builder.size);
		setType(builder.type);
		setColour(builder.colour);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getColour() {
		return colour;
	}

	public void setColour(int colour) {
		this.colour = colour;
	}

	public static final class Builder {
		private int size;
		private int type;
		private int colour;
		private WheelListBuilder wheelListBuilder;

		private Builder() {
		}

		public Builder withSize(int size) {
			this.size = size;
			return this;
		}

		public Builder withType(int type) {
			this.type = type;
			return this;
		}

		public Builder withColour(int colour) {
			this.colour = colour;
			return this;
		}

		public Builder withWheelListBuilder(WheelListBuilder wheelListBuilder) {
			this.wheelListBuilder = wheelListBuilder;
			return this;
		}

		public WheelListBuilder addWheelToList() {
			this.wheelListBuilder.addWheel(this.build());
			return this.wheelListBuilder;
		}

		public Wheel build() {
			return new Wheel(this);
		}

	}

	public static Builder newBuilder() {
		return new Builder();
	}

	public static Builder newBuilder(Wheel copy) {
		Builder builder = new Builder();
		builder.size = copy.size;
		builder.type = copy.type;
		builder.colour = copy.colour;
		return builder;
	}

	@Override
	public String toString() {
		return "Wheel [size=" + size + ", type=" + type + ", colour=" + colour + "]";
	}

}
