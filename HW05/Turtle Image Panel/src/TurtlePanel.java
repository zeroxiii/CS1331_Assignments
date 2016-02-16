/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import javax.swing.*;
import java.awt.*;

/**
 * TurtlePanel
 * @author rlodhia
 * Class creates a panel to place a turtle object
 * and contains function to paint the turtle onto
 * the panel
 */
public class TurtlePanel extends JPanel
{
	//Instance Variables
	private Turtle turtle;
	
	/**
	 * TurtlePanel
	 * Constructs TurtlePanel Object
	 * @param turtleObj Turtle object to be drawn on to the panel
	 */
	public TurtlePanel(Turtle turtleObj)
	{
		turtle = turtleObj;
		setPreferredSize (new Dimension(300,300));
	}
	
	/**
	 * paintComponent
	 * Paints the turtle, its direction, and its location
	 * onto the panel
	 */
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		turtle.draw(page);
		page.drawString("Dir: " + -turtle.getDirection(), 0, 12);
		page.drawString("X: " + turtle.getXlocation(), 0, 24);
		page.drawString("Y: " + turtle.getYlocation(), 0, 36);
	}
}
