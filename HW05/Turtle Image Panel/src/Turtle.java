/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import java.awt.*;
import javax.swing.*;
import java.awt.geom.AffineTransform;

/**
 * Turtle
 * @author rlodhia
 * Turtle class contains constructor and methods
 * to maintain and access Turtle object.
 */
public class Turtle 
{
	//Instance variable
	private int xCoordinate, yCoordinate;
	private double turtleDirection;
	private ImageIcon turtle;
	
	/**
	 * Turtle
	 * Object Constructor
	 * @param x  x-coordinate (int)
	 * @param y  y-coordinate (int)
	 * @param direction direction of turtle in degrees (double)
	 */
	public Turtle (int x, int y, double direction)
	{
		xCoordinate = x;
		yCoordinate = y;
		turtleDirection = direction;
		turtle = new ImageIcon("turtle.gif");
	}
	
	/**
	 * turn
	 * Turns the turtle by a specified amount
	 * of degrees
	 * @param degrees  degrees to turn (double)
	 */
	public void turn(double degrees)
	{
		turtleDirection += degrees;
	}
	
	/**
	 * move
	 * Moves the turtle by a specified distance
	 * @param distance  distance to move the turtle (int)
	 */
	public void move(int distance)
	{
		xCoordinate += distance * Math.cos(Math.toRadians(turtleDirection));
		yCoordinate += distance * Math.sin(Math.toRadians(turtleDirection));
	}
	
	/**
	 * getXlocation
	 * Returns X location of Turtle
	 * @return xCoordinate of Turtle Object
	 */
	public int getXlocation()
	{
		return xCoordinate;
	}
	
	/**
	 * getYlocation
	 * Returns y location of Turtle
	 * @return yCoordinate of Turtle Object
	 */
	public int getYlocation()
	{
		return yCoordinate;
	}
	
	/**
	 * getDirection
	 * Returns direction of Turtle
	 * @return direction of Turtle Object
	 */
	public double getDirection()
	{
		return turtleDirection;
	}
	
	/**
	 * draw
	 * Draws the turtle at its current location and direction
	 * @param g Graphics object on which to draw
	 */
	public void draw(Graphics g)
	{
		drawImage(g, turtle, xCoordinate, yCoordinate, Math.toRadians(turtleDirection));
	}
	
	/** 
	 * This method will draw an image centered on the specified X,Y location,   
	 * rotated by the specified angle (in radians) 
	 *  
	 * @param g The graphics object on which to draw 
	 * @param icon The icon to draw 
	 * @param x The X location to draw the image.  
	 *          The center of the image is used as the anchor. 
	 * @param y The Y location to draw the image.  
	 *          The center of the image is used as the anchor. 
	 * @param rotation The amount to rotate the image. Positive is a clockwise 
	 *                 rotation. This should be in radians. 
	 */ 
	public void drawImage(Graphics g, ImageIcon icon, int x, int y, double rotation) 
	{ 
		Graphics2D g2 = (Graphics2D)g; 
		AffineTransform af = new AffineTransform(); 
		af.translate(x - icon.getIconWidth() / 2, y - icon.getIconHeight() / 2); 
		af.rotate(rotation, icon.getIconWidth() / 2, icon.getIconHeight() / 2); 
		g2.drawImage(icon.getImage(), af, null); 
	} 
}
