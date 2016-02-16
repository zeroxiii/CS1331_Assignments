/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import java.awt.*;
import java.util.Random;

/**
 * Tile
 * @author rlodhia
 * Abstract class that holds 
 * information for basic tiles 
 * for the game field
 */
public abstract class Tile 
{
	//Instance Variables
	protected int row, col;
	protected static Random rand = new Random();
	
	/**
	 * Tile Constructor
	 * @param row  Row value of tile (int)
	 * @param col  Column value of tile (int)
	 * Creates a tile and sets its position
	 */
	Tile(int row, int col)
	{
		this.row = row;
		this.col = col;
	}
	
	/**
	 * draw
	 * @param g Graphics object
	 * Abstract draw method for subclasses
	 */
	public abstract void draw(Graphics g);
	
	/**
	 * isPassable
	 * @return boolean value
	 * Abstract method to determine if
	 * a tile is passable or not
	 */
	public abstract boolean isPassable();
	
	/**
	 * getRow
	 * @return row
	 * Returns row value
	 */
	public int getRow()
	{
		return row;
	}
	
	/**
	 * getCol	
	 * @return col
	 * Returns column value
	 */
	public int getCol()
	{
		return col;
	}
	
	/**
	 * playerEnters
	 * @param p  Player variable
	 * Abstract method that determines what
	 * happens when a player enters
	 */
	public abstract void playerEnters(Player p);
	
	/**
	 * creatureEnters
	 * @param c  Creature variables
	 * Abstract method that determines what 
	 * happens when a creature enters
	 */
	public abstract void creatureEnters(Creature c);
}
