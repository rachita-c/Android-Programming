package parkingTicketSimulator;

public class ParkedCar {
private String make;
private String model;
private String color;
private String licenseNumber;
private int numMinutes;

public ParkedCar(String make, String model, String color, String licenseNumber, int minutes){
	this.make = make;
	this.model = model;
	this.color = color;
	this.licenseNumber = licenseNumber;
	this.numMinutes = (minutes > 0)?minutes: 0;
}

public ParkedCar(ParkedCar other){
	this.make = other.make;
	this.model = other.model;
	this.color = other.color;
	this.licenseNumber = other.licenseNumber;
	this.numMinutes = other.numMinutes;
}

private String getMake(){
	return make;
}

private String getModel(){
	return model;
}

private String getColor(){
	return color;
}

private String getLicenseNumber(){
	return licenseNumber;
}

int getNumMinutes(){
	return numMinutes;
}

public String toString(){
	return "Make: " + make + "\n" + 
			"Model:" + model + "\n" +
			"Color:" + color +"\n" +
			"License Number:" + licenseNumber + "\n" +
			"Minutes Parked:" + numMinutes + "\n";
}

}
