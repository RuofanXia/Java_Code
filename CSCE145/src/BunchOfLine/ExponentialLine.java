package BunchOfLine;

public class ExponentialLine implements Line{
	double exp = 0;
	
	public ExponentialLine()
	{
		this.exp = 0;
	}
	
	public ExponentialLine(double exp)
	{
		this.exp = exp;
	}
	
	public double getExp()
	{
		return this.exp;
	}
	
	public void setExp(double aExp)
	{
		this.exp = aExp;
	}
	
	public double getYPoint(double x)
	{
		return Math.pow(x, Math.E);
	}
}
