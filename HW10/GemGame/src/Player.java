/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import java.awt.*;

/**
 * Player
 * @author rlodhia
 * Player class that inherits from
 * Creature.  This Creature is controlled
 * by the user, and it collects Gems.  This
 * Creature also has a limited number of lives.
 */
public class Player extends Creature
{
	//Instance Variables
	private int score;
	private int initialRow, initialCol;
	private Color color;
	private int lives;
	
	/**
	 * Player Constructor
	 * @param game  Game variable (Game)
	 * @param row   Row value (int)
	 * @param col   Column value (int)
	 * @param color Color value (Color)
	 * Creates a Player object with the specified 
	 * variables, and initializes its score and lives
	 */
	public Player(Game game, int row, int col, Color color)
	{
		super(game,row,col);
		this.initialRow = row;
		this.initialCol = col;
		this.score = 0;
		this.color = color;
		this.lives = 5;
	}
	
	/**
	 * getInitialRow
	 * @return  initialRow
	 * Returns the starting row of
	 * the player
	 */
	public int getInitialRow()
	{
		return initialRow;
	}
	
	/**
	 * getInitialCol
	 * @return  initialCol
	 * Returns the initial column of
	 * the player
	 */
	public int getInitialCol()
	{
		return initialCol;
	}
	
	/**
	 * getScore
	 * @return  score
	 * Returns the players current
	 * score
	 */
	public int getScore()
	{
		return score;
	}
	
	/**
	 * getLives
	 * @return  lives
	 * Returns the players current 
	 * lives
	 */
	public int getLives()
	{
		return lives;
	}
	
	/**
	 * updateScore
	 * @param newScore  New score value (int)
	 * Changes the score value to the specified 
	 * value
	 */
	public void updateScore(int newScore)
	{
		this.score = newScore;
	}
	
	/**
	 * draw
	 * Draws the player at its location with
	 * its specified color
	 */
	public void draw(Graphics g)
	{
		g.setColor(color);
		g.fillRect(this.getCol()*20, this.getRow()*20, 20, 20);
	}
	
	//Inherited update method
	public void update(){};
	
	/**
	 * update
	 * @param nrow  New row value (int)
	 * @param ncol  New column value (int) 
	 * Changes the location of the player (int)
	 * to the new values
	 */
	public void update(int nrow, int ncol)
	{
		this.row = nrow;
		this.col = ncol;
	}
	
	/**
	 * die
	 * Player loses a life and returns to
	 * his initial position
	 */
	public void die()
	{
		this.lives--;
		this.update(this.initialRow, this.initialCol);
	}
	
	/**
	 * move
	 * @param drow  Delta row (int)
	 * @param dcol  Delta column (int)
	 * Moves the Player to a specified location if possible.  Checks if
	 * an item is there and collects it.  Checks if an enemy is at that
	 * tile, and the enemy will attack it.  Checks if the tile is special and
	 * acts accordingly
	 */
	public void move(int drow, int dcol)
	{
		if(game.getLevel().canMoveToSquare(this.getRow() + drow, this.getCol() + dcol))
		{
			this.update(this.getRow() + drow, this.getCol() + dcol);
			if(game.getLevel().getTile(this.getRow(), this.getCol()).getClass().getName().equals("Floor"))
			{
				Item collectedItem = game.getLevel().collectItem(this.getRow(), this.getCol());
				
				if(collectedItem.getValue() != 0 && !collectedItem.isCollected())
				{
					collectedItem.itemCollected();
					this.updateScore(this.getScore() + collectedItem.getValue());
				}
				
				for(Monster monster : game.getMonsterList())
				{
					if(monster.runsInto(this))
						monster.attackPlayer(this);
				}
			}
			else if(game.getLevel().getTile(this.getRow(), this.getCol()).getClass().getName().equals("TeleportPanel"))
			{
				game.getLevel().getTile(this.getRow(), this.getCol()).playerEnters(this);
				this.move(0, 0);
			}
			else if(game.getLevel().getTile(this.getRow(), this.getCol()).getClass().getName().equals("Trap"))
			{
				game.getLevel().getTile(this.getRow(), this.getCol()).playerEnters(this);
			}
		}
	}
}
