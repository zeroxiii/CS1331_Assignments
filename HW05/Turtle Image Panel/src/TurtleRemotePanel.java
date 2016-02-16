/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * TurtleRemotPanel
 * @author rlodhia
 * Class creates a panel to control a
 * TurtlePanel and contains information 
 * on how each button affects the actions 
 * of the TurtlePanel
 */
public class TurtleRemotePanel extends JPanel
{
	//Instance Variables
	private Turtle turtle;
	private JButton forward, backward, turnRight, turnLeft;
	private JLabel inputLabel1, inputLabel2;
	private TurtlePanel panel;
	private JTextField distance, degrees;
	
	/**
	 * TurtleRemotePanel
	 * Constructs TurtleRemotePanel object
	 * @param turtleObj Turtle object that the panel will reference for data
	 * @param panelObj  TurtlePanel object that the panel will change
	 */
	public TurtleRemotePanel(Turtle turtleObj, TurtlePanel panelObj)
	{
		//Creates Panel Fields
		turtle = turtleObj;
		panel = panelObj;
		inputLabel1 = new JLabel("Distance: ");
		inputLabel2 = new JLabel("Degrees: ");
		distance = new JTextField(5);
		degrees = new JTextField(5);
		forward = new JButton ("Forwad");
		forward.addActionListener(new ButtonListener());
		backward = new JButton("Backward");
		backward.addActionListener(new ButtonListener());
		turnRight = new JButton("Turn Right");
		turnRight.addActionListener(new ButtonListener());
		turnLeft = new JButton("Turn Left");
		turnLeft.addActionListener(new ButtonListener());
		
		//Adds fields in specified order
		add(inputLabel1);
		add(distance);
		add(forward);
		add(backward);
		add(inputLabel2);
		add(degrees);
		add(turnLeft);
		add(turnRight);
		
		//Sets dimensions of panel
		setPreferredSize(new Dimension(150,200));
	}
	
	/**
	 * ButtonListener
	 * Class that controls what happens when a 
	 * button on the panel is pushed
	 */
	private class ButtonListener implements ActionListener
	{
		/**
		 * actionPerformed
		 * Determines which button is pressed and performs an action
		 * recpective to the button pushed
		 */
		public void actionPerformed(ActionEvent event)
		{
			//Input variables
			int inputDistance;
			double inputDegrees;
			String text = distance.getText();
			String text2 = degrees.getText();
			
			//Checks which button has been pressed and moves or turns turtle object
			//accordingly
			if (backward.equals(event.getSource()))
			{
				inputDistance = Integer.parseInt(text);
				turtle.move(inputDistance*-1);
			}
			else if (forward.equals(event.getSource()))
			{
				inputDistance = Integer.parseInt(text);
				turtle.move(inputDistance);
			}
			else if (turnLeft.equals(event.getSource()))
			{
				inputDegrees = Double.parseDouble(text2);
				turtle.turn(-1*inputDegrees);
			}
			else if (turnRight.equals(event.getSource()))
			{
				inputDegrees = Double.parseDouble(text2);
				turtle.turn(inputDegrees);
			}
			
			panel.repaint(); //Repaints the panel after changes occur
		}
	}
}
