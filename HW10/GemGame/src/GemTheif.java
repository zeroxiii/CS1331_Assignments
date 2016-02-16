/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import java.awt.*;

/**
 * GemTheif
 * @author rlodhia
 * GemTheif class that inherits from
 * Monster.  This monster moves randomly 
 * and steals gems from the players and
 * the game
 */
public class GemTheif extends Monster
{
	//Instance variable
	private int counter;
	
	/**
	 * GemTheif constructor
	 * @param game  game variable (Game)
	 * Constructs a GemTheif object, initializes its position, and
	 * gives it a random location
	 */
	public GemTheif(Game game)
	{
		super(game, rand.nextInt(game.getLevel().getRows()), rand.nextInt(game.getLevel().getCols()));
		this.generateRandomLocation();
		counter = 0;
	}
	
	/**
	 * GemTheif constructor
	 * @param game  game variable (Game)
	 * @param row   Row variable (int)
	 * @param col   Column variable (int)
	 * Constructs GemTheif object with a 
	 * specified location
	 */
	public GemTheif(Game game, int row, int col)
	{
		super(game, row, col);
		counter = 0;
	}
	
	/**
	 * draw
	 * Draws the GemTheif on the field
	 * only if it is alive
	 */
	public void draw(Graphics g)
	{
		if(this.getAliveStatus())
		{
			g.setColor(Color.magenta);
			g.fillOval(this.getCol()*20, this.getRow()*20, 20, 20);
		}
	}
	
	/**
	 * attackPlayer
	 * Attack player by stealing a gem
	 * and reducing their score
	 */
	public void attackPlayer(Player p)
	{
		if(this.getAliveStatus())
			p.updateScore(p.getScore()-1);
	}
	
	/**
	 * update
	 * Updates the location of the GemTheif,
	 * checks if it is on a floor with an item,
	 * and collects the item.  It it runs into a player,
	 * it will steal from them.  The GemTheif will only move 
	 * if the counter has reached the limit.
	 */
	public void update()
	{
		counter++;
		if(counter == 10)
		{
			this.generateRandomLocation();
			
			if(game.getLevel().getTile(this.getRow(), this.getCol()).getClass().getName().equals("Floor"))
			{
				if(this.getAliveStatus())
				{
					Item collectedItem = game.getLevel().collectItem(this.getRow(), this.getCol());
					
					if(collectedItem.getValue() != 0 && !collectedItem.isCollected())
					{
						collectedItem.itemCollected();
					}
				}
			}
			else if(game.getLevel().getTile(this.getRow(),this.getCol()).getClass().getName().equals("TeleportPanel"))
			{
				game.getLevel().getTile(this.getRow(), this.getCol()).creatureEnters(this);
			}
			else if(game.getLevel().getTile(this.getRow(),this.getCol()).getClass().getName().equals("Trap"))
			{
				game.getLevel().getTile(this.getRow(), this.getCol()).creatureEnters(this);
			}

			if(game.getPlayerOne().runsInto(this))
			{
				this.attackPlayer(game.getPlayerOne());
			}
			
			if(game.getPlayerTwo().runsInto(this))
			{
				this.attackPlayer(game.getPlayerTwo());
			}
			
			counter = 0;
		}
	}
}
