/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Game
 * @author rlodhia
 * Game class. Driver for program
 * and initializes all the components
 * of the game
 */
public class Game 
{
	//Instance Variables
	private Level level;
	private Player playerOne, playerTwo;
	private ArrayList<Monster> monsterList;
	private JLabel statusLabel, scoreLabel;
	private LevelPanel levelPanel;
	private Timer timer;
	private static Game game;
	private int timeLimit;
	private int counter;
	private boolean pauseState;
	
	//Final Game Variables
	private final int GAME_WIDTH = 20;
	private final int GAME_HEIGHT = 20;
	private final int DELAY = 100;
	
	/**
	 * main
	 * @param args
	 * @throws IOException
	 * Driver for the game.  Creates 
	 * game object, sets up JFrame,
	 * and packs and displays game
	 */
	public static void main(String[] args) throws IOException
	{
		JFrame frame = new JFrame("Gem Collector");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		game = new Game();
		
		frame.setLayout(new BorderLayout());
		
		frame.getContentPane().add(game.getStatusLabel(), BorderLayout.NORTH);
		frame.getContentPane().add(game.getScoreLabel(), BorderLayout.SOUTH);
		frame.getContentPane().add(game.getLevelPanel(), BorderLayout.CENTER);

		frame.setPreferredSize(new Dimension(400,460));
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * Game constructor
	 * @throws IOException
	 * Initializes all instance variables. 
	 * Creates game components and starts
	 * timer for game.
	 */
	public Game() throws IOException
	{
		int i;
		
		timeLimit = 150;
		counter = 0;
		pauseState = false;
		
		level = new Level(this, GAME_HEIGHT, GAME_WIDTH);
		
		levelPanel = new LevelPanel(this);
		
		playerOne = new Player(this, 0, 0, Color.blue);
		
		playerTwo = new Player(this, GAME_HEIGHT-1, GAME_WIDTH-1, Color.cyan);
		
		monsterList = new ArrayList<Monster>();
		
		for(i = 0; i < 6; i++)
			monsterList.add(new SimpleMonster(this));
		
		for(i = 0; i < 3; i++)
			monsterList.add(new KamikazeMonster(this));
		
		monsterList.add(new GemTheif(this));
		
		timer = new Timer(DELAY, new TimerListener());
		
		statusLabel = new JLabel("Player One Score: 0  Player Two Score: 0  Total Score: 0  Items Remaining: --  Time Remaning: " + timeLimit);
		scoreLabel = new JLabel("Player One Score: 0  Player Two Score: 0  Total Score: 0");
		
		timer.start();
	}
	
	/**
	 * getLevel
	 * @return  level
	 * Returns the Level object
	 * of the game
	 */
	public Level getLevel()
	{
		return level;
	}
	
	/**
	 * getPlayerOne
	 * @return  playerOne
	 * Returns the playerOne
	 * object
	 */
	public Player getPlayerOne()
	{
		return playerOne;
	}
	
	/**
	 * getPlayerTwo
	 * @return  playerTwo
	 * Returns the playerTwo
	 * object
	 */
	public Player getPlayerTwo()
	{
		return playerTwo;
	}
	
	/**
	 * getMonsterList
	 * @return  monsterList
	 * Returns the ArrayList containing 
	 * all of the monsters in the game
	 */
	public ArrayList<Monster> getMonsterList()
	{
		return monsterList;
	}
	
	/**
	 * getStatusLabel
	 * @return  statusLabel
	 * Returns the statusLabel
	 * object
	 */
	public JLabel getStatusLabel()
	{
		return statusLabel;
	}
	
	/**
	 * getScoreLabel
	 * @return  scoreLabel
	 * Returns the scoreLabel 
	 * object
	 */
	public JLabel getScoreLabel()
	{
		return scoreLabel;
	}
	
	/**
	 * getLevelPanel
	 * @return  levelPanel
	 * Returns the levelPanel
	 * object
	 */
	public LevelPanel getLevelPanel()
	{
		return levelPanel;
	}

	/**
	 * getPauseState
	 * @return  pauseState
	 * Returns the current pauseState
	 * of the game
	 */
	public boolean getPauseState()
	{
		return pauseState;
	}
	
	/**
	 * win
	 * Stops the timer, displays win message
	 * with score, and exits the program
	 */
	public void win()
	{
		timer.stop();
		
		JOptionPane.showMessageDialog(null, "All Items Have Been Collected.  Your Score is " + (playerOne.getScore() + playerTwo.getScore()));
		
		System.exit(0);
	}
	
	/**
	 * lose
	 * Stops the timer, displays lose message,
	 * and exits the program
	 */
	public void lose()
	{
		timer.stop();
		
		JOptionPane.showMessageDialog(null, "You Lose");
		
		System.exit(0);
	}

	/**
	 * changePauseState
	 * Changes the pauseState to the
	 * opposite value
	 */
	public void changePauseState()
	{
		if(!pauseState)
			pauseState = true;
		else
			pauseState = false;
	}
	
	/**
	 * TimerListener
	 * @author rlodhia
	 * ActionListener class that listens to the
	 * timer and acts accordingly
	 */
	private class TimerListener implements ActionListener
	{
		/**
		 * actionPerformed
		 * Occurs at timer ticks.  If the game is not
		 * in a pauseState, then the method will update 
		 * the game (Change the timeLimit, update the 
		 * scoreLabel and statusLabel, move creatures, 
		 * check win and lose conditions, and repaints
		 * game)
		 */
		public void actionPerformed(ActionEvent event)
		{
			if(!pauseState)
			{
				counter++;
				if(counter == 10)
				{
					counter = 0;
					timeLimit--;
				}
				
				statusLabel.setText("Items Left: " + level.getItemCount() + "  Time Left: " + timeLimit 
						+ "  Player1 Lives: " + playerOne.getLives() + "  Player2 Lives: " + playerTwo.getLives());
				
				scoreLabel.setText("Player1 Score: " + playerOne.getScore() + "  Player2 Score: " + playerTwo.getScore() + 
						"  Total Score: " + (playerOne.getScore() + playerTwo.getScore()));
				
				if(level.getItemCount() == 0)
					game.win();
				
				if((timeLimit == 0) || (playerOne.getLives() == 0) || (playerTwo.getLives() == 0))
				{
					game.lose();
				}
				
				for(Monster monster : monsterList)
					monster.update();
				
				levelPanel.repaint();
			}
		}
	}
}
