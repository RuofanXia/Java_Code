package Lab21;

public class Truck extends Vehicle{
	private double loadCap;
	private double towCap;
	public Truck()
	{
		super();
		this.loadCap = 0;
		this.towCap = 0;
	}
	
	public Truck(String manuName, int cylinders, String ownerName, double loadCap, double towCap)
	{
		super(manuName, cylinders, ownerName);
		this.loadCap = loadCap;
		this.towCap = towCap;
	}
	
	public double getLoadCap()
	{
		return this.loadCap;
	}
	
	public double getTowCap()
	{
		return this.towCap;
	}
	
	public void setLoadCap(double newLoadCap)
	{
		this.loadCap = newLoadCap;
	}
	
	public void setTowCap(double newTowCap)
	{
		this.towCap = newTowCap;
	}
	
	public boolean equals(Truck anotherTruck)
	{
		
		return super.equals(anotherTruck) && this.loadCap == anotherTruck.loadCap && this.towCap == anotherTruck.towCap;
	}
	
	public String toString()
	{
		return super.toString() +
				"\nTowing Capacity: " + this.towCap +
				"\nLoad Capacity: " + this.loadCap;
	}
	
}
