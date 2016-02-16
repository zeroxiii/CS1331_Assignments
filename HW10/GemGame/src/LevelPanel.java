/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * LevelPanel
 * @author rlodhia
 * LevelPanel class that holds and draws
 * all of the components of the game in a
 * panel
 */
public class LevelPanel extends JPanel
{
	//Instance Variable
	private Game game;
	
	/**
	 * LevelPanel constructor
	 * @param game  Game variable (Game)
	 * Creates a Level Panel and initializes
	 * its background, components, and listeners
	 */
	public LevelPanel(Game game)
	{
		this.game = game;
		this.setBackground(Color.white);
		this.addKeyListener(new MovementListener());
		this.setFocusable(true);
	}
	
	/**
	 * paintComponent
	 * Draws the level of the game
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		game.getLevel().draw(g);
	}
	
	/**
	 * MovementListener
	 * @author rlodhia
	 * KeyListener class that holds all the information
	 * for how the program changes with key inputs
	 */
	private class MovementListener implements KeyListener
	{
		/**
		 * keyPressed
		 * Checks if the game is paused or not, and then
		 * allows key inputs to move a player in a specified location.
		 * Then it repaints the game
		 */
		public void keyPressed(KeyEvent event)
		{
			if(!(game.getPauseState()))
			{
				switch(event.getKeyCode())
				{
					case KeyEvent.VK_UP:
						game.getPlayerOne().move(-1, 0);
						break;
					case KeyEvent.VK_DOWN:
						game.getPlayerOne().move(1, 0);
						break;
					case KeyEvent.VK_LEFT:
						game.getPlayerOne().move(0, -1);
						break;
					case KeyEvent.VK_RIGHT:
						game.getPlayerOne().move(0, 1);
						break;
					case KeyEvent.VK_W:
						game.getPlayerTwo().move(-1, 0);
						break;
					case KeyEvent.VK_S:
						game.getPlayerTwo().move(1, 0);
						break;
					case KeyEvent.VK_A:
						game.getPlayerTwo().move(0, -1);
						break;
					case KeyEvent.VK_D:
						game.getPlayerTwo().move(0, 1);
						break;
					case KeyEvent.VK_P:
						game.changePauseState();
						break;
				}
				repaint();
			}
			else
			{
				switch(event.getKeyCode())
				{
					case KeyEvent.VK_P:
						game.changePauseState();
						break;
				}
				repaint();
			}
		}
		
		//Implemented methods
		public void keyTyped(KeyEvent event){}
		public void keyReleased(KeyEvent event){}
	}
	
}
