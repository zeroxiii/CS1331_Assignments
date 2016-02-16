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

/**
 * Snake Class
 * @author rlodhia
 * This class contains all the information of the snake.
 * It includes where its located, and methods to control
 * its movement and actions.
 */
public class Snake
{
	//Instance Variables
	private enum Direction {up,down,left,right}
	private Direction snakeDirection;
	private int xCoord, yCoord;
	private int height, width, gridSize;
	private ArrayList<Point> snakeSegments;
	
	/**
	 * Snake Constructor
	 * Initializes all the needed variables
	 * for a snake object
	 * @param length  Length of the snake
	 * @param x  Starting x coordinate of the snake
	 * @param y  Starting y coordinate of the snake
	 * @param width  Width of the game board
	 * @param height Height of the game board
	 * @param grid  Size of each individual grid block of the game
	 */
	public Snake(int length, int x, int y, int width, int height, int grid)
	{
		this.height = height;
		this.width = width;
		this.gridSize = grid;
		
		xCoord = x;
		yCoord = y;
		
		snakeDirection = Direction.right;
		snakeSegments = new ArrayList<Point>();
		snakeSegments.add(new Point(x,y));
		
		int i;
		for(i = 1; i < length; i++)
		{
			snakeSegments.add(new Point(xCoord-gridSize*i,yCoord));
		}
	}
	
	/**
	 * draw
	 * Draws the snake at its current location
	 * @param page  Graphics object used for drawing
	 */
	public void draw (Graphics page)
	{
		for(Point segment : snakeSegments)
		{
			page.setColor(Color.red);
			page.fillRect(segment.x, segment.y, gridSize, gridSize);
			page.setColor(Color.black);
			page.drawOval(segment.x, segment.y, gridSize, gridSize);
		}
	}
	
	/**
	 * eats
	 * Lengthens the snake after it eats
	 * an apple
	 */
	public void eats()
	{
		int lastIndex = snakeSegments.size()-1;
		snakeSegments.add(new Point(snakeSegments.get(lastIndex).x,snakeSegments.get(lastIndex).y));
	}
	
	/**
	 * move
	 * Moves the snake in the direction its 
	 * facing
	 */
	public void move()
	{
		int lastIndex = snakeSegments.size()-1;
		snakeSegments.remove(lastIndex);
		
		int tempX = snakeSegments.get(0).x;
		int tempY = snakeSegments.get(0).y;
		
		switch(snakeDirection)
		{
			case up:
				snakeSegments.add(0, new Point(tempX,tempY-gridSize));
				break;
			case down:
				snakeSegments.add(0, new Point(tempX,tempY+gridSize));
				break;
			case right:
				snakeSegments.add(0, new Point(tempX+gridSize,tempY));
				break;
			case left:
				snakeSegments.add(0, new Point(tempX-gridSize,tempY));
				break;
		}
	}
	
	/**
	 * checkCollision
	 * Checks if the snake has collided with
	 * itself or the wall.
	 * @return true if snake has collied, false otherwise
	 */
	public boolean checkCollision()
	{
		Point snakeHead = snakeSegments.get(0);
		
		//Wall Collision
		if((snakeHead.x < 0) || (snakeHead.x+gridSize > width) || (snakeHead.y < 0) || (snakeHead.y+gridSize > height))
			return true;
		
		//Snake Collision
		int i;
		for(i = 1; i < snakeSegments.size()-1; i++)
		{
			if((snakeHead.x == snakeSegments.get(i).x) && (snakeHead.y == snakeSegments.get(i).y))
				return true;
		}
		
		return false;
	}
	
	/**
	 * setDirection
	 * Sets the direction of the snake
	 * based on the input
	 * @param input Int representing a direction
	 */
	public void setDirection(int input)
	{
		Direction inputDir = Direction.left;
		
		//Determines which direction the snake need to switch
		switch(input)
		{
			case 0:
				inputDir = Direction.up;
				break;
			case 1:
				inputDir = Direction.down;
				break;
			case 2:
				inputDir = Direction.left;
				break;
			case 3:
				inputDir = Direction.right;
				break;
		}
		
		//Determines how the snake will change direction
		switch(snakeDirection)
		{
			case up:
				if(input != 1)
					snakeDirection = inputDir;
				break;
			case down:
				if(input != 0)
					snakeDirection = inputDir;
				break;
			case right:
				if(input != 2)
					snakeDirection = inputDir;
				break;
			case left:
				if(input != 3)
					snakeDirection = inputDir;
				break;
		}
	}
	
	/**
	 * getLocation
	 * @return Point object containing the current location
	 * of the snake head
	 */
	public Point getLocation()
	{
		return snakeSegments.get(0);
	}
}
