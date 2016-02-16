/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import java.awt.*;

/**
 * Circle
 * Circle class that inherits from super class
 * Shape
 * @author rlodhia
 *
 */
public class Circle extends Shape
{
	//Instance variable
	private boolean circleFill;
	
	/**
	 * Circle constructor
	 * @param start  Start Coordinate of shape (Point)
	 * @param color  Color of shape (Color)
	 * @param fill   Designates if shape needs to be filled (boolean)
	 */
	public Circle(Point start, Color color, boolean fill)
	{
		super(start,color);
		circleFill = fill;
	}
	
	/**
	 * updateEnd
	 * Uses super class to update end points.
	 */
	public void updateEnd(Point newEnd)
	{
		super.updateEnd(newEnd);
	}
	
	/**
	 * draw
	 * Draws the circle with the current data
	 */
	public void draw(Graphics g)
	{
		g.setColor(color);
		if(circleFill)
			g.fillOval(startCoord.x, startCoord.y, Math.abs(endCoord.x-startCoord.x), Math.abs(endCoord.y-startCoord.y));
		else
			g.drawOval(startCoord.x, startCoord.y, Math.abs(endCoord.x-startCoord.x), Math.abs(endCoord.y-startCoord.y));
	}
}
