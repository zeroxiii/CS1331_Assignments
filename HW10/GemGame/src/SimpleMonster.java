/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import java.awt.*;

/**
 * SimpleMonster
 * @author rlodhia
 * SimpleMonster class that inherits
 * from Monster class.  This is a basic
 * Monster that moves and attacks players
 */
public class SimpleMonster extends Monster
{
	//Instance Variables
	private int drow, dcol;
	private int counter;
	
	/**
	 * SimpleMonster constructor
	 * @param game  Game variable (Game)
	 * Constructs a SimpleMonster at a 
	 * random location with random movement
	 */
	public SimpleMonster(Game game)
	{
		super(game);
		this.drow = rand.nextInt(2) - 1;
		this.dcol = rand.nextInt(2) - 1;
		this.counter = 0;
	}
	
	/**
	 * SimpleMonster constructor
	 * @param game  Game variable (Game)
	 * @param row   Row value (int)
	 * @param col   Column value (int)
	 * @param drow  Delta row (int) 
	 * @param dcol  Delta col (int)
	 * Constructs a SimpleMonster with a 
	 * specified location and movement
	 */
	public SimpleMonster(Game game, int row, int col, int drow, int dcol)
	{
		super(game, row, col);
		this.drow = drow;
		this.dcol = dcol;
		this.counter = 0;
	}
	
	/**
	 * draw
	 * Draws a SimpleMonster only if it
	 * is alive
	 */
	public void draw(Graphics g)
	{
		if(this.getAliveStatus())
		{
			g.setColor(Color.red);
			g.fillRect(this.getCol()*20, this.getRow()*20, 20, 20);
		}
	}
	
	/**
	 * attackPlayer
	 * Attacks a player only if it is alive
	 * and takes away his life
	 */
	public void attackPlayer(Player p)
	{
		if(this.getAliveStatus())
			p.die();
	}
	
	/**
	 * update
	 * Updates the SimpleMonster's location.  If the SimpleMonster moves
	 * into a wall, it changes direction.  If the SimpleMonster runs into
	 * a player, it will attack it.  If the SimpleMonster moves into a 
	 * special Tile, it will act accordingly.
	 */
	public void update()
	{
		counter++;
		if(counter == 3)
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
