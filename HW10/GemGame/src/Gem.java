/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import java.awt.*;

/**
 * Gem extends Item
 * @author rlodhia
 * Gem class that inherits from Item
 * and has a point value and color
 */
public class Gem extends Item
{
	/**
	 * Gem constructor
	 * Set its point value
	 * to one
	 */
	public Gem()
	{
		super(1);
	}
	
	/**
	 * draw
	 * Overwritten method that draws
	 * a green circle on the field
	 */
	public void draw(Graphics g, int row, int col)
	{
		g.setColor(Color.green);
		super.draw(g, row, col);
	}
}
