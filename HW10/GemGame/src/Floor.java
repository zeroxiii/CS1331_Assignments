/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import java.awt.*;

/**
 * Floor
 * @author rlodhia
 * Floor class that inherits 
 * from Tile.  It is a basic tile
 * that can contain an Item
 */
public class Floor extends Tile
{
	//Instance Variable
	private Item item;
	
	/**
	 * Floor Constructor
	 * @param row  Row value (int)
	 * @param col  Column value (int)
	 * @param item Item variable (Item)
	 * Constructs a floor object and initializes
	 * its variables
	 */
	public Floor(int row, int col, Item item)
	{
		super(row, col);
		this.item = item;
	}
	
	/**
	 * collectItem
	 * @return  item
	 * Returns the item on the
	 * floor panel
	 */
	public Item collectItem()
	{
		return item;
	}
	
	/**
	 * draw
	 * Draws the item on the floor if it is not 
	 * collected.  Otherwise, it draws an empty
	 * tile.
	 */
	public void draw(Graphics g)
	{
		if(item.getValue() == 1 && !item.isCollected())
			item.draw(g, this.getRow(), this.getCol());
		else
		{
			g.setColor(Color.white);
			g.fillRect(this.getCol()*20, this.getRow()*20, 20, 20);
		}
	}
	
	/**
	 * isPassable
	 * Returns true as Floors are
	 * passable
	 */
	public boolean isPassable()
	{
		return true;
	}
	
	//Inherited method
	public void playerEnters(Player p){};
	
	//Inherited method
	public void creatureEnters(Creature c){};
}
