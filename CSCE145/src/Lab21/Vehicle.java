package Lab21;

public class Vehicle {
	private String manuName;
	private int cylinders;
	private String ownersName;
	
	public Vehicle()
	{
		this.manuName = "";
		this.cylinders = 0;
		this.ownersName = "";
	}
	
	public Vehicle(String manuName, int cylinders, String ownerName)
	{
		this.manuName = manuName;
		if (cylinders > 0)
		{
			this.cylinders = cylinders;
		}
		else
		{
			System.out.println("Cylinders must be greater than 0!");
		}
		this.ownersName = ownerName;
	}
	
	public void setManuName(String str)
	{
		this.manuName = str;
	}
	
	public void setCylinder(int cylinder)
	{
		if (cylinder > 0)
		{
			this.cylinders = cylinder;
		}
		else
		{
			System.out.println("Cylinder must be greater than 0!");
		}
	}
	
	public void setOwnerName(String owner)
	{
		this.ownersName = owner;
	}
	
	public String getManuName()
	{
		return this.manuName;
	}
	
	public int getCylinders()
	{
		return this.cylinders;
	}
	
	public String getOwnerName()
	{
		return this.ownersName;
	}
	
	public boolean equals(Vehicle anotherVehicle)
	{
		return this.manuName.equals(anotherVehicle.getManuName()) && this.cylinders == anotherVehicle.getCylinders() 
				&& this.ownersName.equals(anotherVehicle.getOwnerName());
	}
	
	public String toString()
	{
		return "Manufacturer's Name: " +  this.manuName +
				"\nNumber Of Cylinders: " + this.cylinders +
				"\nOwner\'s Name: " + this.ownersName;
	}
}
