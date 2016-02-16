/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import java.awt.*;

/**
 * Item
 * @author rlodhia
 * Abstract class that holds basic
 * information for an item
 * on the game field
 */
public abstract class Item 
{
	//Instance variables
	protected int value;
	protected boolean collected;
	
	/**
	 * Item Constructor
	 * @param value  Point value for Item (int)
	 * Constructs item and initializes variables
	 */
	public Item(int value)
	{
		this.value = value;
		this.collected = false;
	}
	
	/**
	 * draw
	 * @param g  Graphics object
	 * @param row  Row value (int)
	 * @param col  Column value (int)
	 * Draws item
	 */
	public void draw(Graphics g, int row, int col)
	{
		g.fillOval(col*20, row*20, 20, 20);
	}
	
	/**
	 * getValue
	 * @return Point value (int)
	 * Returns point value of item
	 */
	public int getValue()
	{
		return value;
	}
	
	/**
	 * itemCollected
	 * Changes the collected state
	 * to true
	 */
	public void itemCollected()
	{
		collected = true;
	}
	
	/**
	 * isCollected
	 * @return collected (boolean)
	 * Returns whether or not
	 * object has been collected
	 */
	public boolean isCollected()
	{
		return collected;
	}
}
