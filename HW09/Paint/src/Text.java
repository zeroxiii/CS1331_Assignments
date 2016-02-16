/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import java.awt.*;

/**
 * Text class
 * Inherits from Shape super class
 * to create text shapes
 * @author rlodhia
 *
 */
public class Text extends Shape
{
	//Instance variable to hold text
	private String text;
	
	/**
	 * Text Constructor
	 * @param start  Start coordinates of text (Point)
	 * @param color  Color of text (Color)
	 * @param input  Input string to display (String)
	 */
	public Text(Point start, Color color, String input)
	{
		super(start, color);
		this.text = input;
	}
	
	/**
	 * Not used for this class specifically, but
	 * uses superclass to update end points
	 */
	public void updateEnd(Point newEnd)
	{
		super.updateEnd(newEnd);
	}
	
	/**
	 * draw
	 * Draws string with specified variables
	 */
	public void draw(Graphics g)
	{
		g.setColor(color);
		g.drawString(text, startCoord.x, startCoord.y);
	}
}
