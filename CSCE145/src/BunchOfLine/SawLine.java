package BunchOfLine;

public class SawLine implements Line{
	
	double modValue = 0;
	
	public SawLine()
	{
		this.modValue = 0;
	}
	
	public SawLine(double modValue)
	{
		this.modValue = modValue;
	}
	
	public double getModValue()
	{
		return this.modValue;
	}
	
	public void setModValue(double aSetModValue)
	{
		this.modValue = aSetModValue;
	}
	
	public double getYPoint(double x)
	{
		return x % this.modValue;
	}
}
