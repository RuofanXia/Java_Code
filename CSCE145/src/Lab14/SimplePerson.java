package Lab14;

public class SimplePerson {
	private String Name;
	public SimplePerson(){
		this.Name = "No name yet";
	}
	public SimplePerson(String Name){
		this.Name = Name;
	}
	
	//Mutators
	public void setName(String aName)
	{
		if (!(aName instanceof String))
		{
			System.out.println("Invalid");
			return;
		}
		this.Name = aName;
	}
	
	//Accessors
	public String getName()
	{
		return this.Name;
	}
	
	//other methods
	public void writeOutput()
	{
		System.out.println("Name: " + this.Name);
	}
	
	public boolean hasSameName(SimplePerson sp)
	{
		return this.Name.equals(sp.Name);
	}
	
	public boolean equals(Object object)
	{
		SimplePerson otherPerson = (SimplePerson) object;
		return this.hasSameName(otherPerson);
	}
}
