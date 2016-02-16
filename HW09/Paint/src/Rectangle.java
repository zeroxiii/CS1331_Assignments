/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import java.awt.*;

/**
 * Rectangle class
 * Inherits most variables and methods
 * from Shape class
 * @author rlodhia
 *
 */
public class Rectangle extends Shape
{
	//Instance variable
	private boolean rectFill;
	
	/**
	 * Rectangle constructor
	 * @param start  Start Coordinates (Point)
	 * @param color  Color of Shape (Color)
	 * @param fill	 Tells if the rectangle needs to be filled or not (boolean)
	 */ 
	public Rectangle(Point start, Color color, boolean fill)
	{
		super(start,color);
		rectFill = fill;
	}
	
	/**
	 * updateEnd
	 * Uses super class to update end point
	 */
	public void updateEnd(Point newEnd)
	{
		super.updateEnd(newEnd);
	}
	
	/**
	 * draw
	 * Draws the rectangle with the specified data
	 */
	public void draw(Graphics g)
	{
		g.setColor(color);
		if(rectFill)
			g.fillRect(startCoord.x, startCoord.y, Math.abs(endCoord.x-startCoord.x), Math.abs(endCoord.y-startCoord.y));
		else
			g.drawRect(startCoord.x, startCoord.y, Math.abs(endCoord.x-startCoord.x), Math.abs(endCoord.y-startCoord.y));
	}
}
