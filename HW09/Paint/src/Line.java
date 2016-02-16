/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import java.awt.*;

/**
 * Line class
 * Inherits from shape to draw and hold data for 
 * a line
 * @author rlodhia
 *
 */
public class Line extends Shape
{
	/**
	 * Line constructor
	 * @param start  Start coordinates (Point)
	 * @param color  Color of Line (Color
	 */
	public Line(Point start, Color color)
	{
		super(start,color);
	}
	
	/**
	 * updateEnd
	 * Uses superclass to update end point
	 */
	public void updateEnd(Point newEnd)
	{
		super.updateEnd(newEnd);
	}
	
	/**
	 * draw
	 * Draws line with current data
	 */
	public void draw(Graphics g)
	{
		g.setColor(color);
		g.drawLine(startCoord.x, startCoord.y, endCoord.x, endCoord.y);
	}
}
