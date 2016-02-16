/* 
 * Name:  Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "In order to help learn course concepts, 
 * I worked on this homework with Jon Perez and Talia Knapp, 
 * discussed homework topics and issues with Jon Perez and Talia
 * Knapp.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Driver class to initiate the
 * Snake game
 * @author rlodhia
 *
 */
public class SnakeMain 
{
	/**
	 * main
	 * Sets up the frame and begins the game
	 * @param args
	 */
	public static void main (String[] args)
	{
		JFrame frame = new JFrame("Snake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new SnakePanel());
		frame.pack();
		frame.setVisible(true);
	}
}
