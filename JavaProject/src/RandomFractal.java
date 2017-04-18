/*
 * Written by JJ Shepherd
 * Used to draw a random fractal line by subdividing it, changing its y direction, and then subdividing it further until a pixel limit is reached
 */
import java.applet.*; //Needed to create the window
import java.awt.*; //Needed for drawing
import java.util.*;
public class RandomFractal extends Applet{//When it extends applet it creates a window and calls certain methods

	private Image display; //Used as the flat image
	private Graphics drawingArea; //Used to draw item in the image

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
		randomFractal(0,height/2,width,height/2,drawingArea);
	}
	/*
	 * This updates every frame and draws the image in the applet.  This is also called by
	 * the applet as it is an overridden method. 
	 */
	public void paint(Graphics g)
	{
		g.drawImage(display,0,0,null);
	}
	/*
	 * This creates the random fractal by taking a large line, splitting it in half, and changing the y value of its midpoints.
	 * This happens recursively until a pixel limit is reached.
	 */
	public static void randomFractal(int leftX, int leftY, int rightX, int rightY, Graphics drawingArea)
	{
		final int STOP = 4; //Pixel Limit
		final int MAX = 12; //Used for a Y movement max
		int midX;
		int midY;
		int delta;
		Random r = new Random();
		//If the distance of the right x point to the left x point is less than the pixel limit then draw the line
		if((rightX - leftX) <= STOP)
		{
			drawingArea.drawLine(leftX, leftY, rightX, rightY);
		}
		else //Split the line and call the fractal again using the left and right side
		{
			//Finds the mid point
			midX = (leftX + rightX)/2;
			midY = (leftY + rightY)/2;
			//Changes the y position
			delta = r.nextInt(MAX);
			//Moves the y position
			midY += delta;
			//Left side
			randomFractal(leftX,leftY,midX,midY,drawingArea);
			//Right side
			randomFractal(midX, midY, rightX,rightY,drawingArea);
		}
		System.out.println(leftX+" "+leftY+" "+rightX+" "+rightY+" ");
	}

}