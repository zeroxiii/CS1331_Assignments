/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import java.awt.*;

/**
 * Trap
 * @author rlodhia
 * Trap class that inherits from
 * Tile.  It is a tile that kills creatures
 */
public class Trap extends Tile
{
	//Instance Variable
	private boolean revealed;
	
	/**
	 * Trap constructor
	 * @param row  Row value (int)
	 * @param col  Column value (int)
	 * Constructs a Trap object and
	 * initializes its variables
	 */
	public Trap(int row, int col)
	{
		super(row, col);
		this.revealed = false;
	}
	
	
	/**
	 * draw
	 * Draws a trap like a floor if it has not been revealed
	 * yet, or draws it gray if it has been revealed
	 */
	public void draw(Graphics g)
	{
		if(!revealed)
		{
			g.setColor(Color.white);
			g.fillRect(this.getCol()*20, this.getRow()*20, 20, 20);
		}
		else
		{
			g.setColor(Color.gray);
			g.fillRect(this.getCol()*20, this.getRow()*20, 20, 20);
		}
	}
	
	/**
	 * isPassable
	 * Returns true as Traps are passable
	 */
	public boolean isPassable()
	{
		return true;
	}
	
	/**
	 * playerEnters
	 * Reveals trap and kills player
	 */
	public void playerEnters(Player p)
	{
		this.revealed = true;
		p.die();
	}
	
	/**
	 * creatureEnters
	 * Reveals trap and kills creature
	 */
	public void creatureEnters(Creature c)
	{
		this.revealed = true;
		c.die();
	}
}
