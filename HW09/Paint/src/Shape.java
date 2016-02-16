/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import java.awt.*;

/**
 * Shape abstract class
 * Contains all the basic variables and methods needed for any shape
 * @author rlodhia
 *
 */
public abstract class Shape 
{
	//Protected Instance Variables
	protected Point startCoord;
	protected Point endCoord;
	protected Color color;
	
	/**
	 * Shape constructor
	 * @param start  Start coordinates (Point)
	 * @param color  Color of shape (Color)
	 */
	public Shape(Point start, Color color)
	{
		this.startCoord = start;
		this.endCoord = start;
		this.color = color;
	}
	
	/**
	 * draw
	 * Abstract method used by all shapes
	 * @param g Graphics variable
	 */
	public abstract void draw(Graphics g);
	
	
	/**
	 * updateEnd
	 * Updates the endCoord variable
	 * @param newEnd  End coordinates (Point)
	 */
	public void updateEnd(Point newEnd)
	{
		this.endCoord = newEnd;
	}
}
