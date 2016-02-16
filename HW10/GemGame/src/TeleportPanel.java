/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import java.awt.*;

/**
 * TeleportPanel
 * @author rlodhia
 * TeleportPanel class that inherits
 * from Tile.  It is a tile that
 * teleports creatures to random locations
 *
 */
public class TeleportPanel extends Tile
{
	/**
	 * TeleportPanel constructor
	 * @param row  Row value (int)
	 * @param col  Column value (int)
	 * Creates a TeleportPanel object
	 */
	public TeleportPanel(int row, int col)
	{
		super(row, col);
	}
	
	/**
	 * draw
	 * Draws an orange circle on the field
	 */
	public void draw(Graphics g)
	{
		g.setColor(Color.orange);
		g.drawOval(this.getCol()*20, this.getRow()*20, 20, 20);
	}
	
	/**
	 * isPassable
	 * Returns true as TeleportPanels are
	 * passable
	 */
	public boolean isPassable()
	{
		return true;
	}
	
	/**
	 * playerEnters
	 * Teleports player to random location
	 * when they enter
	 */
	public void playerEnters(Player p)
	{
		p.generateRandomLocation();
	}
	
	/**
	 * creatureEnters
	 * Teleports creature to random location
	 * when they enter
	 */
	public void creatureEnters(Creature c)
	{
		c.generateRandomLocation();
	}
}
