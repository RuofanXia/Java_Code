package Lab14;

public class Employee extends SimplePerson{
	double salary;
	String hire_data;
	int id;
	
	public Employee()
	{
		super();
		this.salary = 0;
		this.hire_data = "Not hired";
		this.id = 0;
	}
	
	public Employee(String initialName, double newEmployeesalary, String newEmployeeHireDate, int newEmployeeId)
	{
		super(initialName);
		this.salary = newEmployeesalary;
		this.hire_data = newEmployeeHireDate;
		this.id = newEmployeeId;
	}
	
	//Accessors
	public double getSalary()
	{
		return this.salary; 
	}
	
	public String getHireDate()
	{
		return this.hire_data;
	}
	
	public int getIDNumber()
	{
		return this.id;
	}
	
	//Mutators
	public void setSalary(double aSalary)
	{
		if (aSalary < 0 )
		{
			System.out.println("invalid");
			return;
		}
		this.salary = aSalary;
	}
	
	public void setHireDate(String aHireDate)
	{
		this.hire_data = aHireDate;
	}
	
	public void setIdNumber(int aIdnumber)
	{
		this.id = aIdnumber;
	}
	
	//other methods
	public boolean equals(Object Object)
	{
		Employee otherEmployee = (Employee) Object;
		return this.hasSameName(otherEmployee) &&
				(this.salary == otherEmployee.salary ) &&
				this.hire_data.equalsIgnoreCase(otherEmployee.hire_data) &&
				this.id == otherEmployee.id;
	}
	
	public void writeOutput()
	{
		System.out.println("Name : " + getName());
		System.out.println("Makes " + this.salary);
		System.out.println("Was hired " + this.hire_data);
		System.out.println("ID number is " + this.id);
	}
}
