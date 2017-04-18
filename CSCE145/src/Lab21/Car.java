package Lab21;

public class Car extends Vehicle{
	private double mileage;
	private int passengers;
	
	public Car()
	{
		super();
		this.mileage = 0;
		this.passengers = 0;
	}
	
	public Car(String manuName, int cylinders, String ownerName, double mileage, int passengers)
	{
		super(manuName, cylinders, ownerName);
		this.mileage = mileage;
		this.passengers = passengers;
	}
	
	public double getMileage()
	{
		return this.mileage;
	}
	
	public int getPassengers()
	{
		return this.passengers;
	}
	
	public void setMileage(double aMileage)
	{
		this.mileage = aMileage;
	}
	
	public void setPassengers(int aPassengers)
	{
		this.passengers = aPassengers;
	}
	
	public boolean equals(Car car)
	{
		return super.equals(car) && this.mileage == car.getMileage() && this.passengers == car.getPassengers();
 	}
	
	public String toString()
	{
		return super.toString() +
				"\nGas Mileage: " + this.getMileage() +
				"\nNumber of Passengers: " + this.getPassengers();
	}
}
