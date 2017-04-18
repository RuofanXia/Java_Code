/*
 * Written by JJ Shepherd
 * Used to draw an example of Sierpenski Carpet
 */
import java.applet.*;//Needed to create the window
import java.awt.*;//Needed for drawing
import java.util.*;
public class SierpenskiCarpet extends Applet{//When it extends applet it creates a window and calls certain methods
	private Image display;//Used as the flat image
	private Graphics drawingArea;//Used to draw item in the image
	/*
	 *This is called by the parent Applet, as its an overridden method, and it initializes all of the instance variables.
	 * Think of this as a variation of a constructor, but called by another, hidden piece of code
	 */
	public void init()
	{
		//get the height and width from the Applet
		int height = getSize().height;
		int width = getSize().width;
		//Creates an image using the height and width in the applet
		display = createImage(width,height);
		//Sets up the drawing area for the image above to be drawn on
		drawingArea = display.getGraphics();
		//This draws the random fractal
		drawGasket(0,0,height,drawingArea);
		
	}
	/*
	 * This updates every frame and draws the image in the applet.  This is also called by
	 * the applet as it is an overridden method. 
	 */
	public void paint(Graphics g)
	{
		g.drawImage(display,0,0,null);
	}
//	public void drawSquare(Graphics g)
//	{
//		g.fillRect(10, 10, 10, 10);
//	}
	/*
	 * This creates the carpet by first dividing the square into 9 squares.  Then fills in the center square.
	 * Finally is recursively called on the 8 other squares until a pixel limit is reached.
	 */
	public static void drawGasket(int x, int y, int side, Graphics g)
	{
		//Divides each side by 3.  Since it's a square we only need to calculate this once
		int sub = side / 3;
		
		//Draws the middle square.  The square is drawn from the top left position to a specified width and height.
		g.fillRect(x+sub, y+sub, sub, sub);
		
		//If it hasn't reached the pixel limit the call the function recursively on the 8 remaining squares.
		if(sub >= 3)
		{
			//Top 3 squares
			drawGasket(x,y,sub,g); //Left
			drawGasket(x+sub,y,sub,g); //Middle
			drawGasket(x+2*sub,y,sub,g); //Right
			
			//Middle 2 squares
			drawGasket(x, y+sub,sub,g); //Left
			drawGasket(x+2*sub,y+sub,sub,g); //Right
			
			//Bottom 3 Squares
			drawGasket(x,y+2*sub,sub,g); //Left
			drawGasket(x+sub,y+2*sub,sub,g); //Middle
			drawGasket(x+2*sub,y+2*sub,sub,g); //Right	
		}
	}
}