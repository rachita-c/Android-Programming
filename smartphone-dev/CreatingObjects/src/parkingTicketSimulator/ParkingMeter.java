package parkingTicketSimulator;

public class ParkingMeter {
	private int parkingMinutes;

	public ParkingMeter(int minutes){
		parkingMinutes = (minutes > 0) ? minutes: 0;
	}
	
	public ParkingMeter(ParkingMeter other){
		this.parkingMinutes = other.parkingMinutes;
	}
	
	public int getParkingMinutes(){
		return parkingMinutes;
	}
	
	public String toString(){
		return "Minutes Purchased: " + parkingMinutes + "\n";
	}
	
}
