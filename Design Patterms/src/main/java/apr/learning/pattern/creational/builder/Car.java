package apr.learning.pattern.creational.builder;

/**
 * La clase coche representa un Product
 * @author Antonio
 *
 */
public class Car {
	
	private String bodyStyle;
	private String power;
	private String engine;
	private String breaks;
	private String seats;
	private String windows;
	private String fuelType;
	private String carType;
	
	public Car (String carType){
		this.carType = carType;
	}
	
	public String getBodyStyle() {
		return bodyStyle;
	}
	public void setBodyStyle(String bodyStyle) {
		this.bodyStyle = bodyStyle;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getBreaks() {
		return breaks;
	}
	public void setBreaks(String breaks) {
		this.breaks = breaks;
	}
	public String getSeats() {
		return seats;
	}
	public void setSeats(String seats) {
		this.seats = seats;
	}
	public String getWindows() {
		return windows;
	}
	public void setWindows(String windows) {
		this.windows = windows;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("--------------"+carType+"--------------------- \n");
		sb.append(" Body: ");
		sb.append(bodyStyle);
		sb.append("\n Power: ");
		sb.append(power);
		sb.append("\n Engine: ");
		sb.append(engine);
		sb.append("\n Breaks: ");
		sb.append(breaks);
		sb.append("\n Seats: ");
		sb.append(seats);
		sb.append("\n Windows: ");
		sb.append(windows);
		sb.append("\n Fuel Type: ");
		sb.append(fuelType);
		
		return sb.toString();
	}
}
