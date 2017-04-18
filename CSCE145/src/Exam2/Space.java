package Exam2;

public class Space {
	private boolean hasBeenUncovered;
	private boolean isSecretSquare;
	
	public Space()
	{
		this.hasBeenUncovered = false;
		this.isSecretSquare = false;
	}
	
	public Space(boolean a, boolean b)
	{
		this.hasBeenUncovered = a;
		this.isSecretSquare = b;
	}
	
	public void setHasBeenUncovered(boolean a)
	{
		this.hasBeenUncovered = a;
	}
	
	public void setIsSecretSquare(boolean a)
	{
		this.isSecretSquare = a;
	}
	
	public boolean getHasBeenUncovered()
	{
		return this.hasBeenUncovered;
	}
	
	public boolean getIsSecretSquare()
	{
		return this.isSecretSquare;
	}
	
	public String toString()
	{
		if (this.hasBeenUncovered) return "#";
		return "_";
	}
}
