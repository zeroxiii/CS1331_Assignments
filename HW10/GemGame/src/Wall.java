/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import java.awt.*;

/**
 * Wall
 * @author rlodhia
 * Wall class that inherits from
 * Tile.  It is a unpassable tile
 */
public class Wall extends Tile
{
	/**
	 * Wall Constructor
	 * @param row  Row value (int)
	 * @param col  Column value (int)
	 * Constructs a Wall object
	 */
	public Wall(int row, int col)
	{
		super(row, col);
	}

	/**
	 * draw
	 * Draws a black wall on the 
	 * game field
	 */
	public void draw(Graphics g)
	{
		g.setColor(Color.black);
		g.fillRect(this.getCol()*20, this.getRow()*20, 20, 20);
	}
	
	/**
	 * isPassable
	 * Returns false as walls are
	 * not passsable
	 */
	public boolean isPassable()
	{
		return false;
	}
	
	//Inherited method
	public void playerEnters(Player p){};
	
	//Inherited method
	public void creatureEnters(Creature c){};
}
