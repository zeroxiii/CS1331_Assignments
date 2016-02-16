/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import java.awt.*;

/**
 * Monster
 * @author rlodhia
 * Monster class that inherits
 * from Creature. Contains basic
 * information for all Monsters
 */
public abstract class Monster extends Creature
{
	/**
	 * Monster Constructor
	 * @param game  Game variable (Game)
	 * Constructs a Monster at a random location
	 */
	public Monster(Game game)
	{
		super(game, rand.nextInt(game.getLevel().getRows()), rand.nextInt(game.getLevel().getCols()));
		this.generateRandomLocation();
	}
	
	/**
	 * Monster Constructor
	 * @param game  Game variable (Game)
	 * @param row   Row value (int)
	 * @param col   Column value (int)
	 * Constructs a Monster at the specified
	 * location
	 */
	public Monster(Game game, int row, int col)
	{
		super(game, row, col);
	}
	
	/**
	 * attackPlayer
	 * @param p  Player variable
	 * Abstract method for how Monsters attack
	 * Players
	 */
	public abstract void attackPlayer(Player p);
	
	/**
	 * draw
	 * Abstract method for how Monsters are
	 * drawn
	 */
	public abstract void draw(Graphics g);
	
	/**
	 * update
	 * Abstract method for how Monsters are
	 * updated
	 */
	public abstract void update();
}
