/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import java.awt.*;
import java.util.Random;

/**
 * Creature
 * @author rlodhia
 * Abstract class that holds
 * information for all
 * game creatures
 */
public abstract class Creature 
{
	//Instance Variables
	protected Game game;
	protected int row, col;
	protected static Random rand = new Random();
	protected boolean alive;

	/**
	 * Creature constructor
	 * @param game Game variable (Game)
	 * @param row  Row value (int)
	 * @param col  Column value (int)
	 * Creates a Creature object
	 */
	public Creature(Game game, int row, int col)
	{
		this.game = game;
		this.row = row;
		this.col = col;
		this.alive = true;
	}
	
	/**
	 * draw
	 * @param g  Graphics object
	 * Abstract draw method
	 */
	public abstract void draw(Graphics g);
	
	/**
	 * update
	 * Abstract update method
	 */
	public abstract void update();
	
	/**
	 * getRow
	 * @return  row
	 * Returns row value of object
	 */
	public int getRow()
	{
		return row;
	}
	
	/**
	 * getCol
	 * @return  col
	 * Returns column value of object
	 */
	public int getCol()
	{
		return col;
	}
	
	/**
	 * die
	 * Changes alive status to dead
	 */
	public void die()
	{
		this.alive = false;
	}
	
	/**
	 * getAliveStatus
	 * @return alive
	 * Returns whether or not creature
	 * is alive
	 */
	public boolean getAliveStatus()
	{
		return alive;
	}
	
	/**
	 * runsInto
	 * @param c  Creature variable
	 * @return boolean value
	 * Returns whether or not a creature has run into this 
	 * creature
	 */
	public boolean runsInto(Creature c)
	{
		if((c.getRow() == this.getRow()) && (c.getCol() == this.getCol()))
			return true;
		else
			return false;
	}
	
	/**
	 * generateRandomLocation
	 * Generates a random location that this creature can move to 
	 * and sets the creature to this position
	 */
	public void generateRandomLocation()
	{
		this.row = rand.nextInt(game.getLevel().getRows());
		this.col = rand.nextInt(game.getLevel().getCols());
		
		while(!(game.getLevel().canMoveToSquare(this.getRow(), this.getCol())) && !(this.getRow() == 0 && this.getCol() == 0))
		{
			this.row = rand.nextInt(game.getLevel().getRows());
			this.col = rand.nextInt(game.getLevel().getCols());
		}
	}
}
