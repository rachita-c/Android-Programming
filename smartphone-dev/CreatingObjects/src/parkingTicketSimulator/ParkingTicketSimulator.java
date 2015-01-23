package parkingTicketSimulator;

public class ParkingTicketSimulator {
	
	//Test Case 1: Time passed less than parking meter minutes allowed
	public static void main(String [] args){
		ParkedCar car = new ParkedCar("BMW", "AAA", "Blue", "CMUSV", 45);
		ParkingMeter meter = new ParkingMeter(50);
		PoliceOfficer officer = new PoliceOfficer("Jimmy", "AAAKJL");
		ParkingTicket ticket = officer.checkMinutes(car, meter);
		if (ticket == null){
			System.out.println("No ticket" + "\n");
		}
		else {
			System.out.println("Ticket given");
			System.out.println(ticket);
		}
		
		//Test Case 2: Time passed more than parking meter minutes allowed
		ParkedCar car2 = new ParkedCar("Civic", "vvv", "Green", "Berkeley", 360);
		ParkingMeter meter2 = new ParkingMeter(30);
		PoliceOfficer officer2 = new PoliceOfficer("Jimmy", "AAAKJL");
		ParkingTicket ticket2 = officer2.checkMinutes(car2, meter2);
		if (ticket2 == null){
			System.out.println("No ticket" + "\n");
		}
		else {
			System.out.println("Ticket given");
			System.out.println(ticket2);
		}
		
		//Test Case 3: Parking meter invalid time, car invalid time
		ParkedCar car3 = new ParkedCar("Ferrari", "H43", "Purple", "Stanford", -1);
		ParkingMeter meter3 = new ParkingMeter(-1);
		PoliceOfficer officer3 = new PoliceOfficer("Jimmy", "AAAKJL");
		ParkingTicket ticket3 = officer3.checkMinutes(car3, meter3);
		if (ticket3 == null){
			System.out.println("No ticket" + "\n");
		}
		else {
			System.out.println("Ticket given");
			System.out.println(ticket3);
		}
	}
	
}
