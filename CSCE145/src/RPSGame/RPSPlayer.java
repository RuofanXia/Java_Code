package RPSGame;

public class RPSPlayer implements RPSPlayerInterface{
	private String gesture;
	private int points;
	public RPSPlayer()
	{
		this.gesture = "none";
		this.points = 0;
	}
	
	public void setGesture(String aGesture)
	{
		if (aGesture.equals("rock") || aGesture.equals("paper") || aGesture.equals("scissors"))
		{
			this.gesture = aGesture;
		}
		else
		{
			this.gesture = "none";
		}
	}
	
	public String getGesture()
	{
		return this.gesture;
	}
	
	public void setPoints(int aPoints)
	{
		if (aPoints >= 0)	this.points = aPoints;
	}
	
	public int getPoints()
	{
		return this.points;
	}


	public void chooseGesture()
	{
		this.gesture = "none";
	}
}
