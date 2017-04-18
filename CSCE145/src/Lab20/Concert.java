package Lab20;

public class Concert {
	private String Name;
	private int Capacity;
	private int ticketsOfsbp;
	private int ticketsOfsav;
	private double priceOfsbp;
	private double priceOfsav;
	
	public Concert()
	{
		this.Name = "";
		this.Capacity = 0;
		this.ticketsOfsav = 0;
		this.ticketsOfsbp = 0;
		this.priceOfsav = 0;
		this.priceOfsbp = 0;
	}
	
	public Concert(String Name, int capacity, double priceOfsbp, double priceOfsav)
	{
		this.Name = Name;
		this.Capacity = capacity;
		this.priceOfsbp = priceOfsbp;
		this.priceOfsav = priceOfsav;
	}
	
	public Concert(String Name, int capacity, int ticketsOfsbp, int ticketsOfsav, double priceOfsbp, double priceOfsav)
	{
		this.Name = Name;
		this.Capacity = capacity;
		this.ticketsOfsbp = ticketsOfsbp;
		this.ticketsOfsav = ticketsOfsav;
		this.priceOfsbp = priceOfsbp;
		this.priceOfsav = priceOfsav;
	}
	
	public void setName(String aName)
	{
		this.Name = aName;
	}
	
	public String getName()
	{
		return this.Name;
	}
	
	public void setCapacity(int aCapacity)
	{
		this.Capacity = aCapacity;
	}
	
	public int getCapacity()
	{
		return this.Capacity;
	}
	
	public int getNumberOfTicketsSoldByPhone()
	{
		return this.ticketsOfsbp;
	}
	
	public void setNumberOfTicketsSoldByPhone(int aNumber)
	{
		this.ticketsOfsbp = aNumber;
	}
	
	public int getNumberOfTicketsSoldAtVenue()
	{
		return this.ticketsOfsav;
	}
	
	public void setNumberOfTicketsSoldAtVenue(int aNumber)
	{
		this.ticketsOfsav = aNumber;
	}
	
	public double getPriceByPhone()
	{
		return this.priceOfsbp;
	}
	
	public void setPriceByPhone(double aPrice)
	{
		this.priceOfsbp = aPrice;
	}
	
	public double getPriceAtVenue()
	{
		return this.priceOfsav;
	}
	
	public void setPriceAtVenue(double aPrice)
	{
		this.priceOfsav = aPrice;
	}
	
	public int TotalNumberOfTicketsSold()
	{
		return this.ticketsOfsav + this.ticketsOfsbp;
	}
	
	public int TicketsRemaining()
	{
		return this.Capacity - TotalNumberOfTicketsSold();
	}
	
	public void BuyTicketsAtVenue(int num)
	{
		if (TicketsRemaining() >= num)
		{
			this.ticketsOfsav += num;
		}
		else
		{
			System.out.println("Concert is Sold out!");
		}
		
	}
	
	public void BuyTicketsByPhone(int num)
	{
		if (TicketsRemaining() >= num)
		{
			this.ticketsOfsbp += num;
		}
		else
		{
			System.out.println("Concert is Sold out!");
		}
	}
	
	public double TotalSales()
	{
		return ticketsOfsav*priceOfsav+ticketsOfsbp*priceOfsbp;
	}
}
