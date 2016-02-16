/* Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on the homework assignment alone, 
 * using only course materials." 
 */

import java.awt.*;
import javax.swing.*;

/**
 * RPSComputerPanel
 * @author Rahmaan Lodhia
 * Sets up an object that creates
 * and controls the computer panel.
 * Contains methods to change the display
 * for the panel.
 */
public class RPSComputerPanel extends JPanel
{
	private JLabel computerThrowLabel, computerThrowTitle; //Labels for the computer panel
	
	/**
	 * RPSComputerPanel constructor
	 * Creates the computer panel, sets up its 
	 * orientation, and formats its display.
	 */
	public RPSComputerPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		computerThrowTitle = new JLabel("Computer's Throw");
		computerThrowTitle.setAlignmentX(CENTER_ALIGNMENT);
		
		computerThrowLabel = new JLabel("(None)");
		computerThrowLabel.setAlignmentX(CENTER_ALIGNMENT);
		computerThrowLabel.setFont(new Font("Arial", Font.BOLD, 18)); 
		
		add(Box.createVerticalGlue());
		add(computerThrowTitle);
		add(computerThrowLabel);
		add(Box.createVerticalGlue());
	}
	
	
	/**
	 * setComputerThrow
	 * Sets the computer panel throw to display the specified throw
	 * @param computerThrow  RPSThrow object to display on the panel
	 */
	public void setComputerThrow(RPSThrow computerThrow)
	{
		computerThrowLabel.setText(computerThrow.toString(computerThrow));
	}
}
