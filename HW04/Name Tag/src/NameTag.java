/* Name: Rahmaan Lodhia
 * Prism: rlodhia3 
 * Collaboration: "I worked on the homework assignment alone, using only course materials."
 */

import java.awt.*;
import javax.swing.*;

/**
 * NameTag
 * 
 * Class used to create and display name tag.
 *
 */
public class NameTag 
{
	//Initialize private variables
	private JFrame tag;
	private JPanel panel;
	private JLabel label1, label2, label3;
	
	/**
	 * Constructor for NameTag
	 * @param name  Takes in a name object
	 * 
	 * Creates and initializes frames for generation of name tag.
	 */
	public NameTag(Name name)
	{
		//Creates Frame
		tag = new JFrame();
		tag.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Creates and sets texts for labels
		label1 = new JLabel("Hello!");
		label1.setFont(new Font("Arial", Font.ITALIC, 15)); 
		
		label2 = new JLabel(" my name is ");
		label2.setFont(new Font("Arial", Font.BOLD, 15)); 

		Name.NameFormat format = Name.NameFormat.firstMiddleLast;
		label3 = new JLabel(name.getFullName(format));
		label3.setFont(new Font("Times New Roman", Font.BOLD, 25)); 
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		//Sets up the panel for use in later function
		panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.red,5));
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
	}
	
	/**
	 * showNameTag()
	 * 
	 * Displays name tag 
	 */
	public void showNameTag()
	{
		tag.getContentPane().add(panel);
		tag.pack();
		tag.setVisible(true);
	}
}
