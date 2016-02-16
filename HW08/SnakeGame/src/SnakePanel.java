/* 
 * Name:  Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "In order to help learn course concepts, 
 * I worked on this homework with Jon Perez and Talia Knapp, 
 * discussed homework topics and issues with Jon Perez and Talia
 * Knapp.
 */

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;

/**
 * SnakePanel
 * Creates the panel that contains the snake,
 * and controls the game environment with timers and
 * key inputs.
 * @author rlodhia
 */
public class SnakePanel extends JPanel
{
	//Instance Variables
	private Snake snake;
	private ArrayList<Point> appleList;
	private static Random rand = new Random();
	private Timer timer;
	private int timerTicks;
	private final int DELAY = 150;
	private final int LENGTH = 5, START_X = 200, START_Y = 200;
	private final int WIDTH = 750, HEIGHT = 750, GRID_SIZE = 25;
	private boolean playing = true;
	
	/**
	 * SnakePanel Constructor
	 * Uses the constant values to create the snake object, and then
	 * initializes all the listeners and timers for the game 
	 * environment.
	 */
	public SnakePanel()
	{	
		snake = new Snake(LENGTH, START_X, START_Y, WIDTH, HEIGHT, GRID_SIZE);
		
		appleList = new ArrayList<Point>();
		
		timer = new Timer(DELAY, new TimerListener());
		
		addKeyListener(new DirectionListener());
		
		timerTicks = 0;
		
		setBackground(Color.black);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		timer.start();
	}
	
	/**
	 * paintComponent
	 * Draws the game environment, including the 
	 * snake and apples
	 */
	public void paintComponent (Graphics page)
	{
		super.paintComponent(page);
		
		//Checks to see if the game is still
		//allowed to play
		if(playing)
		{
			for(Point apple : appleList)
			{
				page.setColor(Color.green);
				page.fillOval(apple.x, apple.y, GRID_SIZE, GRID_SIZE);
			}	
			snake.draw(page);
		}
		else
		{
			page.setColor(Color.black);
			page.fillRect(0, 0, WIDTH, HEIGHT);
			page.setColor(Color.white);
			page.drawString("You Lose", 350, 350);
		}
	}
	
	/**
	 * addApple
	 * Randomly adds an apple within the
	 * specified game size
	 */
	public void addApple()
	{
		int xGridBlocks = WIDTH/GRID_SIZE;
		int yGridBlocks = HEIGHT/GRID_SIZE;
		
		int xApple = rand.nextInt(xGridBlocks) * GRID_SIZE;
		int yApple = rand.nextInt(yGridBlocks) * GRID_SIZE;
		
		appleList.add(new Point(xApple,yApple));
	}
	
	/**
	 * DirectionListener
	 * Class in charge of taking in 
	 * arrow key inputs and determining
	 * how the game reacts
	 * @author rlodhia
	 *
	 */
	private class DirectionListener implements KeyListener
	{
		/**
		 * keyPressed
		 * Checks which arrow key is pressed
		 * and moves the snake in that direction
		 * if possible. Also checks if the a snake lands 
		 * on top of an apple.
		 */
		public void keyPressed(KeyEvent event)
		{
			switch (event.getKeyCode())
			{
				case KeyEvent.VK_UP:
					snake.setDirection(0);
					snake.move();
					break;
				case KeyEvent.VK_DOWN:
					snake.setDirection(1);
					snake.move();
					break;
				case KeyEvent.VK_LEFT:
					snake.setDirection(2);
					snake.move();
					break;
				case KeyEvent.VK_RIGHT:
					snake.setDirection(3);
					snake.move();
					break;
			}
			
			//Checks to see if the snake now went on top
			//of an apple
			int i;
			Point snakeHead = snake.getLocation();
			for(i = 0; i < appleList.size(); i++)
			{
				if(snakeHead.equals(appleList.get(i)))
				{
					snake.eats();
					appleList.remove(i);
				}
			}
			
			repaint();
		}
		
		//Implemented methods
		public void keyTyped(KeyEvent event) {}
		public void keyReleased(KeyEvent event) {}
	}
	
	/**
	 * TimerListener
	 * Class in charge of determing how the 
	 * game reacts depending on the timer of the
	 * game
	 * @author rlodhia
	 *
	 */
	private class TimerListener implements ActionListener
	{
		/**
		 * actionPerformed
		 * Depending on the timer, the snake will move
		 * and the game will check if it collided or 
		 * ate an apple.  Also, this method will add
		 * apples whenever the timerTick reaches a 
		 * certain value
		 */
		public void actionPerformed(ActionEvent event)
		{
			int i;
			Point apple;
			
			snake.move();
			
			//Checks collision with wall and apples
			if(snake.checkCollision())
			{
				playing = false;
				repaint();
			}
			else
			{
				Point snakeHead = snake.getLocation();
				for(i = 0; i < appleList.size(); i++)
				{
					if(snakeHead.equals(appleList.get(i)))
					{
						snake.eats();
						appleList.remove(i);
					}
				}
			}
			
			//Keeps track of timer ticks
			timerTicks++;
			if(timerTicks == 20)
			{
				timerTicks = 0;
				addApple();
			}
			
			repaint();
		}
	}
}
