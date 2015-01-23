package parkingTicketSimulator;

public class ParkingTicket {
	private static int count = 0;
	private PoliceOfficer officer;
	private ParkedCar car;
	private ParkingMeter meter;
	private int fine;
	private int totalTicketCost;
	
	public ParkingTicket(PoliceOfficer officer, ParkedCar car, ParkingMeter meter){
		count++;
		this.officer = officer;
		this.car = car;
		this.meter = meter;
		int hoursExceeded = (int)Math.ceil((car.getNumMinutes() - meter.getParkingMinutes())/60.0);
		totalTicketCost = 25 + 10*(hoursExceeded - 1);
	}
	
	public String toString(){
		return "Parking ticket #" + count + "\n" 
				+ car
				+ meter 
				+ "Fine:" + totalTicketCost + "\n"
				+ officer 
				+ "Total ticket cost: " + totalTicketCost + "\n";
	}
	
}
