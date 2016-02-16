/*Name: Rahmaan Lodhia
 *Prism: rlodhia3
 *Collaboration Statement: "I worked on the homework
 * assignment alone, using only course materials."  
 */

/**
 * DiceApplet.java
 * 
 * Applet to draw dice
 * on the screen.
 */

import javax.swing.JApplet;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class DiceApplet extends JApplet
{
	/**
	 * Main method to specify which dice 
	 * are to be drawn
	 */
	public void paint(Graphics g) //Method to Specify Shapes to Draw
	{
		Random random = new Random();
		
		//Randomly Generate Numbers
		int dieOne = random.nextInt(6) + 1;
		int dieTwo = random.nextInt(6) + 1;
		int dieThree = random.nextInt(6) + 1;
		
		//Randomly Generate Sizes
		int dieOneSize = random.nextInt(100) + 1;
		int dieTwoSize = random.nextInt(100) + 1;
		int dieThreeSize = random.nextInt(100) + 1;
		
		//Clear Screen
		g.setColor(Color.white);
		g.fillRect(0,0,500,500);
		
		drawDice(g,dieOne,random.nextInt(500-dieOneSize),random.nextInt(500-dieOneSize),dieOneSize,randomColor());
		drawDice(g,dieTwo,random.nextInt(500-dieTwoSize),random.nextInt(500-dieTwoSize),dieTwoSize,randomColor());
		drawDice(g,dieThree,random.nextInt(500-dieThreeSize),random.nextInt(500-dieThreeSize),dieThreeSize,randomColor());
	}
	
	
	/**
	 * Returns a random color
	 * 
	 * @return Random Color
	 */
	static Color randomColor()
	{
		Random random = new Random();
		return new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
	}
	
	
	/**
	 * Method to draw a die on a screen
	 * 
	 * @param g  Graphics class to draw on screen
	 * @param dieNumber  Die Number to specify which die to be drawn
	 * @param x  x-coordinate of die
	 * @param y  y-coordinate of die
	 * @param length  Length of a side of a die
	 * @param c  Color of die's circles
	 */
	public void drawDice(Graphics g, int dieNumber, int x, int y, int length, Color c)
	{
		g.setColor(Color.white);
		g.fillRect(x, y, length, length);
		g.setColor(Color.black);
		g.drawRect(x, y, length, length);
		g.setColor(c);
		
		int dieCircleSide = length/5;
		
		if(dieNumber == 1)
		{
			g.fillOval(x + length/2 - dieCircleSide/2, y + length/2 - dieCircleSide/2, dieCircleSide, dieCircleSide);
		}
		else if(dieNumber == 2)
		{
			g.fillOval(x + dieCircleSide/2 , y + length/2 + dieCircleSide, dieCircleSide, dieCircleSide);
			g.fillOval(x + length/2 + dieCircleSide, y + dieCircleSide/2, dieCircleSide, dieCircleSide);
		}
		else if(dieNumber == 3)
		{
			g.fillOval(x + dieCircleSide/2 , y + length/2 + dieCircleSide, dieCircleSide, dieCircleSide);
			g.fillOval(x + length/2 - dieCircleSide/2, y + length/2 - dieCircleSide/2, dieCircleSide, dieCircleSide);
			g.fillOval(x + length/2 + dieCircleSide, y + dieCircleSide/2, dieCircleSide, dieCircleSide);
		}
		else if(dieNumber == 4)
		{
			g.fillOval(x + dieCircleSide/2 , y + length/2 + dieCircleSide, dieCircleSide, dieCircleSide);
			g.fillOval(x + dieCircleSide/2, y + dieCircleSide/2, dieCircleSide, dieCircleSide);
			g.fillOval(x + length/2 + dieCircleSide, y + dieCircleSide/2, dieCircleSide, dieCircleSide);
			g.fillOval(x + length/2 + dieCircleSide, y + length/2 + dieCircleSide, dieCircleSide, dieCircleSide);
		}
		else if(dieNumber == 5)
		{
			g.fillOval(x + dieCircleSide/2 , y + length/2 + dieCircleSide, dieCircleSide, dieCircleSide);
			g.fillOval(x + dieCircleSide/2, y + dieCircleSide/2, dieCircleSide, dieCircleSide);
			g.fillOval(x + length/2 + dieCircleSide, y + dieCircleSide/2, dieCircleSide, dieCircleSide);
			g.fillOval(x + length/2 + dieCircleSide, y + length/2 + dieCircleSide, dieCircleSide, dieCircleSide);
			g.fillOval(x + length/2 - dieCircleSide/2, y + length/2 - dieCircleSide/2, dieCircleSide, dieCircleSide);
		}
		else if(dieNumber == 6)
		{
			g.fillOval(x + dieCircleSide/2 , y + length/2 + dieCircleSide, dieCircleSide, dieCircleSide);
			g.fillOval(x + dieCircleSide/2, y + dieCircleSide/2, dieCircleSide, dieCircleSide);
			g.fillOval(x + length/2 + dieCircleSide, y + dieCircleSide/2, dieCircleSide, dieCircleSide);
			g.fillOval(x + length/2 + dieCircleSide, y + length/2 + dieCircleSide, dieCircleSide, dieCircleSide);
			g.fillOval(x + dieCircleSide/2, y + length/2 - dieCircleSide/2, dieCircleSide, dieCircleSide);
			g.fillOval(x + length/2 + dieCircleSide, y + length/2 - dieCircleSide/2, dieCircleSide, dieCircleSide);
		}
	}
}
