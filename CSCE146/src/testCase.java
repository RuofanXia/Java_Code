//Wendy M Godlewski
//February 2, 2016
//Sierpinski Triangle

import java.awt.*;  //needed for drawing
import java.applet.*;  //needed to create the window
import java.util.*;

public class testCase extends Applet {  //when it extends applet it creates a window and calls certains methods
private Image Display;  //used as the flag image
private Graphics drawingArea;  //used to draw item in the image

//This is called by the parent Applet, as its an overridden method.  It initializes all of the instance variables.
//Variation of a constructor, but called by another hidden piece of code
public void init() {
	//get height and width from the Applet
	int height = getSize().height;
	int width = getSize().width;
	
	//creates an image using the height and width in the Applet
	Display = createImage(width, height);
	
	//sets up the drawing area for the image above to be drawn on
	drawingArea = Display.getGraphics();
	
	//this draws the random fractal
	drawTriangle(0, 0, height, drawingArea);
	
}
//Updates every frame and draws the image in the applet.  Also called by the applet as it is an overridden method.
public void paint(Graphics g) {
	g.drawImage(Display,  0,  0,  null);
}
//no idea what this does.  method never called
public void drawSquare(Graphics g) {
	g.fillRect(10, 10, 10, 10);
}
//Creates the carpet by first diving the square into 3 squares.  Fills in the center upright triangle.  Finally recursively called
//and "unfills" the other triangles
public void drawTriangle(int x, int y, int side, Graphics g) {
	
	//divides each side by 3
	int sub = side / 2;
	int[] xcoord = {x + side/2, x, x + side};
	int[] ycoord = {y, y + side, y + side};
	//draws the middle square.  It is drawn from the top left position to a specified width and height.
	g.setColor(Color.black);
	g.fillPolygon(xcoord,  ycoord,  3);
	int[] smallXcoord = {x + side/4, x + side*3/4, x + side/2};
	int[] smallYcoord = {y + side/2, y + side/2, y + side};
	g.setColor(Color.white);
	g.fillPolygon(smallXcoord, smallYcoord, 3);
	
	int x1 = x + side/4;
	int y1 = y;
	int x2 = x;
	int y2 = y + side/2;
	int x3 = x + side/2;
	int y3 = y + side/2;
	if(sub > 4) {
		drawTriangle(x1, y1, sub, g);
		drawTriangle(x2, y2, sub, g);
		drawTriangle(x3, y3, sub, g);
	}
	
}
}

