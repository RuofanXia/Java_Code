package Lab15;

public class Diamond extends ShapeBasics implements DiamondInterface{
	private int width;
	public Diamond(){
		super();
		this.width = 0;
	}
	public Diamond(int width, int offset)
	{
		super(offset);
		this.width = width;
	}
	
	//Accessors
	public int getWidth(){
		return this.width;
	}
	
	//Mutators
	public void setWidth(int newWith){
		if (newWith < 0)
		{
			System.out.println("Invalid with");
			return;
		}
		this.width = newWith;
	}
	
	public void drawHere(){
		drawTopV();
		drawButtonV();
	}
	
	private void drawTopV(){
		
		/*
		int l=this.width;
		if (width%2 == 0)
			l++;
		
		for (int i=0; i<=l/2; i++)
		{
			for (int j=0; j<l/2-i; j++)
			{
				skipSpaces(getOffset());
			}
			
			for (int j=0; j<=i*2; j++)
			{
				if (j == 0 || j == i*2)
					System.out.print("*");
				else
					skipSpaces(getOffset());
			}
			
			System.out.println();
		}
		*/
		
		//startOfLine == number of spaces to the 
        //first '*' on a line. Initially set to the  
        //number of spaces before the topmost '*'.
		int startOfLine = getOffset( ) + width / 2;
        skipSpaces(startOfLine);
        System.out.println('*');//top '*'
        int lineCount = width / 2 ; //Height above base
		
        //insideWidth == number of spaces between the
        //two '*'s on a line.
        int insideWidth = 1;
        for (int count = 0; count < lineCount; count++)
        {
            //Down one line, so the first '*' is one more
            //space to the left.
            startOfLine--;
            skipSpaces(startOfLine);
            System.out.print('*');
            skipSpaces(insideWidth);
            System.out.println('*');
			
            //Down one line, so the inside is 2 spaces wider.
            insideWidth = insideWidth + 2;
        }
	}
	
	private void drawButtonV(){
		/*
		int l = this.width;
		if (width%2 == 0)
			l++;
		
		for (int i=l/2-1; i>=0; i--)
		{
			for(int j=0; j<l/2-i; j++)
				skipSpaces(getOffset());
			for(int j=0; j<=i*2; j++)
			{
				if (j == 0 || j == i*2 )
					System.out.print("*");
				else
					skipSpaces(getOffset());
			}
			System.out.println();
		}
		*/
		
		//startOfLine == number of spaces to the 
        //first '*' on a line. Initially set to the  
        //number of spaces before the topmost '*'.
		int startOfLine = getOffset( );
        int lineCount = width / 2 - 1; //Height above base
		
        //insideWidth == number of spaces between the
        //two '*'s on a line.
        int insideWidth = lineCount*2-1;
        for (int count = 0; count < lineCount; count++)
        {
            //Down one line, so the first '*' is one more
            //space to the left.
            startOfLine++;
            skipSpaces(startOfLine);
            System.out.print('*');
            skipSpaces(insideWidth);
            System.out.println('*');
			
            //Down one line, so the inside is 2 spaces wider.
            insideWidth = insideWidth - 2;
        }
        
        startOfLine = getOffset( ) + width / 2;
        skipSpaces(startOfLine);
        System.out.println('*');
	}
	
	//Writes the indicated number of spaces.
    private static void skipSpaces(int number)
    {
        for (int count = 0; count < number; count++)
            System.out.print(' ');
    }
}
