/* Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on the homework assignment alone, 
 * using only course materials." 
 */

import java.awt.*;
import javax.swing.*;

/**
 * RPSTitlePanel
 * @author Rahmaan Lodhia
 * Sets up an object that displays the 
 * title of a RPS game.
 */
public class RPSTitlePanel extends JPanel
{
	private JLabel titleLabel; //Label to hold the title
	
	/**
	 * RPSTitlePanel Constructor
	 * Creates the panel that holds the title,
	 * sets up the orientation, and formats
	 * the title font.
	 */
	public RPSTitlePanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		titleLabel = new JLabel("Rock, Paper, Scissors");
		titleLabel.setAlignmentX(CENTER_ALIGNMENT);
		titleLabel.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 22)); 
		
		add(Box.createHorizontalGlue());
		add(titleLabel);
		add(Box.createHorizontalGlue());

	}
}
