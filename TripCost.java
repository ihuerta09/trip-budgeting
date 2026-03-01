
public class TripCost {
	// Variable initialization
	private final double distance;
	private final double gasCost;
	private final double mileage;
	private final double numberDays; 
	private final double hotel;
	private final double food; 
	private final double attractions; 
	//
	public TripCost(double distance, double gasCost, double mileage, double numberDays, double hotel, double food, double attractions) {
		
		this.distance = distance;
		this.gasCost = gasCost; 
		this.mileage = mileage; 
		this.numberDays = numberDays;
		this.hotel = hotel; 
		this.food = food;
		this.attractions = attractions; 
	}

	public double totalTripCost() {
		double totalGas = distance / mileage * gasCost;
		double totalTripCost = totalGas + (hotel+food)* numberDays + attractions; 
		
		return totalTripCost;
	}
}
