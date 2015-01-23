package parkingTicketSimulator;

public class PoliceOfficer {
private String name;
private String badgeNumber;

public PoliceOfficer(String name, String badgeNumber){
	this.name = name;
	this.badgeNumber = badgeNumber;
}

public PoliceOfficer(PoliceOfficer other){
	this.name = other.name;
	this.badgeNumber = other.badgeNumber;
}

public ParkingTicket checkMinutes(ParkedCar car, ParkingMeter meter){
	if (car.getNumMinutes() > meter.getParkingMinutes()){
		return new ParkingTicket(this, car, meter);
	}
	return null;
}

public String toString(){
	return "Officer Name: " + name + "\n" + "Badge Number: " + badgeNumber + "\n";
}
}
