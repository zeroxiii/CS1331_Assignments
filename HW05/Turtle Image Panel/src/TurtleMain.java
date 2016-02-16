/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import javax.swing.*;

/**
 * TurtleMain
 * This class sets up the turtle GUI
 * and makes it ready to take in user input.
 */
public class TurtleMain 
{
	/**
	 * main
	 * Creates Turtle object, TurtlePanel object, TurtleRemotePanel object,
	 * and the frames to be used in the GUI.  Specifies what each frames hold
	 * and its operation.
	 * @param args
	 */
	public static void main (String[] args)
	{
		//Creates Turtle, TurtlePanel, and TurtleRemotePanel Objects
		Turtle turtle = new Turtle(150,150,0);
		TurtlePanel tPanel = new TurtlePanel(turtle);
		TurtleRemotePanel rPanel = new TurtleRemotePanel(turtle, tPanel);
		
		//Creates frame to hold TurtlePanel object
		JFrame tFrame = new JFrame("TurtleFrame");
		tFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tFrame.getContentPane().add(tPanel);
		tFrame.pack();
		tFrame.setVisible(true);

		//Creates frame to hold TurtleRemotePanel object
		JFrame rFrame = new JFrame("TurtleRemote");
		rFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rFrame.getContentPane().add(rPanel);
		rFrame.pack();
		rFrame.setVisible(true);
	}
}
