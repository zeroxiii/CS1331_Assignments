/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import java.awt.Color;
import java.awt.Graphics;

/**
 * KamikazeMonster
 * @author rlodhia
 * KamikazeMonster class that inherits
 * from the Monster Class.  This monster
 * moves quickly through the field, and it can jump
 * past some walls.  It also dies when it kills
 * a player.
 */
public class KamikazeMonster extends Monster
{
	//Instance variables
	private int drow, dcol;
	private int counter;
	
	/**
	 * KamikazeMonster constructor
	 * @param game  Game variable (game)
	 * Creates a KamikazeMonster at a 
	 * random location with random movement
	 */
	public KamikazeMonster(Game game)
	{
		super(game);
		
		this.drow = (rand.nextInt(2) - 1)*(rand.nextInt(2) + 2);
		this.dcol = (rand.nextInt(2) - 1)*(rand.nextInt(2) + 2);
		while(this.drow == 0 && this.dcol == 0)
		{
			this.drow = (rand.nextInt(2) - 1)*(rand.nextInt(2) + 2);
			this.dcol = (rand.nextInt(2) - 1)*(rand.nextInt(2) + 2);
		}
		
		
		this.counter = 0;
	}
	
	/**
	 * KamikazeMonster constructor
	 * @param game  Game variable (game)
	 * @param row   Row value (int)
	 * @param col   Column value (int)
	 * @param drow  Delta row (int)
	 * @param dcol  Delta col (int)
	 * Creates a KamikazeMonster object
	 * with the specified variables
	 */
	public KamikazeMonster(Game game, int row, int col, int drow, int dcol)
	{
		super(game, row, col);
		this.drow = drow;
		this.dcol = dcol;
		this.counter = 0;
	}
	
	/**
	 * draw
	 * Draws the monster only if it is 
	 * alive
	 */
	public void draw(Graphics g)
	{
		if(this.getAliveStatus())
		{
			g.setColor(Color.yellow);
			g.fillRect(this.getCol()*20, this.getRow()*20, 20, 20);
		}
	}
	
	/**
	 * attackPlayer
	 * Attacks a player only if it is
	 * alive, and then dies afterword
	 */
	public void attackPlayer(Player p)
	{
		if(this.getAliveStatus())
		{
			p.die();
			this.die();
		}
	}
	
	/**
	 * update
	 * Moves the creature when the counter
	 * reaches its limit, checks if it hits
	 * a wall or a player, and it acts accordingly.
	 */
	public void update()
	{
		counter++;
		if(counter == 2)
		{
			if(game.getLevel().canMoveToSquare(this.getRow()+this.drow, this.getCol()+this.dcol))
			{
				if(game.getLevel().getTile(this.getRow(), this.getCol()).getClass().getName().equals("Floor"))
				{
					this.row = this.getRow() + this.drow;
					this.col = this.getCol() + this.dcol;
				}
				else if(game.getLevel().getTile(this.getRow(),this.getCol()).getClass().getName().equals("TeleportPanel"))
				{
					game.getLevel().getTile(this.getRow(), this.getCol()).creatureEnters(this);
				}
				else if(game.getLevel().getTile(this.getRow(),this.getCol()).getClass().getName().equals("Trap"))
				{
					game.getLevel().getTile(this.getRow(), this.getCol()).creatureEnters(this);
				}

			}
			else
			{
				this.drow = this.drow * -1;
				this.dcol = this.dcol * -1;
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
