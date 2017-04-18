package BunchOfLine;

public class SineLine implements Line {
	
	double amplitude = 0;
	double frequency = 0;
	
	public SineLine()
	{
		this.amplitude = 0;
		this.frequency = 0;
	}
	
	public SineLine(double amplitude, double frequency)
	{
		this.amplitude = amplitude;
		this.frequency = frequency;
	}
	
	public double getAmplitude()
	{
		return this.amplitude;
	}
	
	public double getFrequency()
	{
		return this.frequency;
	}
	
	public void setAmplitude(double aAmplitude)
	{
		this.amplitude = aAmplitude;
	}
	
	public void setFrequency(double aFrequency)
	{
		this.frequency = aFrequency;
	}
	
	public double getYPoint(double x)
	{
		return this.amplitude * Math.sin(x*this.frequency);
	}
}
