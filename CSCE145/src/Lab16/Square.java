package Lab16;

public class Square {
	private int length;
	public Square(){
		this.length = 1;
	}
	
	public Square(int side){
		this.length = side;
	}
	
	//accessor
	public int getLength()
	{
		return this.length;
	}
	
	//mutator
	public void setLength(int aLength) throws DimensionException
	{
		if (aLength <= 0 )
		{
			throw new DimensionException();
		}
		this.length = aLength;
	}
	
	public void draw(){
		for (int i=0; i<length; i++)
		{
			for (int j=0; j<length; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public int getArea(){
		return length*length;
	}
	
	public int getPerimeter(){
		return length*4;
	}
}
