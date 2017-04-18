package BunchOfLine;

public class SlopedLine implements Line{
	
	double slope = 0;
	
	public SlopedLine()
	{
		this.slope = 0;
	}
	public SlopedLine(double slope)
	{
		this.slope = slope;
	}
	
	public double getSlope()
	{
		return this.slope;
	}
	
	public void setSlope(double aSlope)
	{
		this.slope = aSlope;
	}
	
	public double getYPoint(double x)
	{
		return this.slope * x;
	}
}
