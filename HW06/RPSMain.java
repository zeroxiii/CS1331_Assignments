/* Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on the homework assignment alone, 
 * using only course materials." 
 */

import javax.swing.*;
import java.awt.*;

/**
 * RPSMain
 * @author Rahmaan Lodhia
 * Main method to create all of the panel objects,
 * combine them into one frame, and display the frame for
 * user input.
 */
public class RPSMain
{
	/**
	 * main
	 * Creates the panel objects, creates the JFrame to hold
	 * the panel, and makes it visible
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Creates all of the panel objects
		RPSResultPanel resultPanel = new RPSResultPanel();
		RPSComputerPanel computerPanel = new RPSComputerPanel();
		RPSTitlePanel titlePanel = new RPSTitlePanel();
		RPSPlayerPanel playerPanel = new RPSPlayerPanel(computerPanel,resultPanel);
		
		//Creates frame
		JFrame rpsFrame = new JFrame("RPS");
		rpsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rpsFrame.setLayout(new BorderLayout());
		rpsFrame.setPreferredSize(new Dimension(400,240));
		
		//Adds all panels to the frame
		rpsFrame.getContentPane().add(titlePanel, BorderLayout.PAGE_START);
		rpsFrame.getContentPane().add(playerPanel, BorderLayout.LINE_START);
		rpsFrame.getContentPane().add(resultPanel, BorderLayout.CENTER);
		rpsFrame.getContentPane().add(computerPanel, BorderLayout.LINE_END);
		
		//Display the frame
		rpsFrame.pack();
		rpsFrame.setVisible(true);
	}
}
