/* Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on the homework assignment alone, 
 * using only course materials." 
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * RPSPlayerPanel
 * @author Rahmaan Lodhia
 * Creates the player panel that contains the user
 * input buttons.  Contains all the methods to
 * control the buttons and their reactions.
 * Links with the other panels to edit their results.
 */
public class RPSPlayerPanel extends JPanel
{
	private JLabel throwTitle, userThrow; //Labels describe the player panel
	private JButton rockButton, paperButton, scissorButton; //Buttons for each throw
	private RPSComputerPanel computer; //RPSComputerPanel variable to hold data for the computer panel
	private RPSResultPanel result; //RPSResultPanel variable to hold data for the result panel
	
	/**
	 * RPSPlayerPanel
	 * Creates the player panel, sets up its orientation, 
	 * takes in other panel data, and sets up the buttons 
	 * for user input.
	 * @param computerPanel  Computer panel data that is to be updated later
	 * @param resultPanel  Result panel data that is to be updated later
	 */
	public RPSPlayerPanel(RPSComputerPanel computerPanel, RPSResultPanel resultPanel)
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		computer = computerPanel;
		result = resultPanel;
		
		throwTitle = new JLabel("Your Throw");
		throwTitle.setAlignmentX(LEFT_ALIGNMENT);	
		
		userThrow = new JLabel("(None)");
		userThrow.setAlignmentX(LEFT_ALIGNMENT);
		
		rockButton = new JButton("Rock");
		rockButton.addActionListener(new ButtonListener());
		rockButton.setAlignmentX(LEFT_ALIGNMENT);
		
		paperButton = new JButton("Paper");
		paperButton.addActionListener(new ButtonListener());
		paperButton.setAlignmentX(LEFT_ALIGNMENT);
		
		scissorButton = new JButton("Scissors");
		scissorButton.addActionListener(new ButtonListener());
		scissorButton.setAlignmentX(LEFT_ALIGNMENT);
		
		add(Box.createVerticalGlue());
		add(throwTitle);
		add(userThrow);
		add(rockButton);
		add(paperButton);
		add(scissorButton);
		add(Box.createVerticalGlue());
	}
	
	/**
	 * ButtonListner
	 * @author Rahmaan Lodhia
	 * Class that controls the actions for each 
	 * buttons of the Player panel.
	 */
	private class ButtonListener implements ActionListener
	{
		/**
		 * actionPerformed
		 * Determines which button is pushed and
		 * changes the results screen accordingly.
		 */
		public void actionPerformed (ActionEvent event)
		{
			RPSThrow inputThrow, compThrow;
			
			//Checks which button is pressed, compares the throw to 
			//the computer throw and calls the update method.
			if (rockButton.equals(event.getSource()))
			{
				inputThrow = new RPSThrow(1);
				compThrow = RPSThrow.getRandomThrow();
				updateResult(inputThrow,compThrow);
				userThrow.setText("Rock");
				computer.setComputerThrow(compThrow);
			}
			else if (paperButton.equals(event.getSource()))
			{
				inputThrow = new RPSThrow(2);
				compThrow = RPSThrow.getRandomThrow();
				updateResult(inputThrow,compThrow);
				userThrow.setText("Paper");
				computer.setComputerThrow(compThrow);
			}
			else if(scissorButton.equals(event.getSource()))
			{
				inputThrow = new RPSThrow(3);
				compThrow = RPSThrow.getRandomThrow();
				updateResult(inputThrow,compThrow);
				userThrow.setText("Scissors");
				computer.setComputerThrow(compThrow);
			}			
			
		}
		
		
		/**
		 * updateResult
		 * Takes in both throws, determines the winner, and
		 * sets the result in the result panel.
		 * @param user  User RPSThrow
		 * @param comp  Computer RPSThrow
		 */
		public void updateResult(RPSThrow user, RPSThrow comp)
		{
			if (user.compareTo(comp) == 0)
				result.setResult("Draw");
			else if (user.compareTo(comp) == 1)
				result.setResult("You Win");
			else
				result.setResult("You Lose");
		}
	}
}
