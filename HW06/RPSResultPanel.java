/* Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on the homework assignment alone, 
 * using only course materials." 
 */

import java.awt.*;
import javax.swing.*;

/**
 * RPSResultPanel
 * @author Rahmaan Lodhia
 * Creates an object that displays and updates
 * the results of the RPS game.
 */
public class RPSResultPanel extends JPanel
{
	private JLabel resultLabel; //Label that holds the game results
	
	/**
	 * RPSResultPanel Constructor
	 * Creates the panel, sets up its orientation, 
	 * and its intial text.
	 */
	public RPSResultPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		resultLabel = new JLabel("Result");
		resultLabel.setAlignmentX(CENTER_ALIGNMENT);
		resultLabel.setFont(new Font("Arial", Font.BOLD, 18)); 
		
		add(Box.createVerticalGlue());
		add(resultLabel);
		add(Box.createVerticalGlue());
	}
	
	
	/**
	 * setResult
	 * Changes the text of the label to 
	 * display the result specified.
	 * This method respects encapsulation as it 
	 * makes only the object able to edit the result
	 * label, allowing the label to be private for the
	 * class.  Using a getter or leaving the result a public
	 * variable violates encapsulation as it allows other source 
	 * to edit the objects variables.
	 * @param result  String containing game outcome.
	 */
	public void setResult(String result)
	{
		resultLabel.setText(result);
	}
}
