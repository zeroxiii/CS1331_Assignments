/* Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on the homework assignment
 *  alone, using only course materials." 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * GamePanel
 * Creates the panel that edits and
 * displays the game grid and GUI
 */
public class GamePanel extends JPanel
{
	//Instance Variables
	private int turnNumber, width, height, startX, startY, squareSize, row, col;
	private JButton step, clear;
	private JLabel turnLabel;
	private CellModel cellModel;
	private boolean stepPressed;
	
	/**
	 * GamePanel Constructor
	 * Initializes the GUI and its
	 * contents
	 * @param row  Specifies the rows of the game grid
	 * @param col  Specifies the columsn of the game grid
	 */
	public GamePanel(int row, int col)
	{
		turnNumber = 0;
		startX = 50;
		startY = 50;
		squareSize = 20;
		height = squareSize * row;
		width = squareSize * col;
		stepPressed = false;
		
		cellModel = new CellModel(row, col);
		
		this.row = row;
		this.col = col;
		
		step = new JButton("Step");
		step.addActionListener(new ButtonListener());
		
		clear = new JButton("Clear");
		clear.addActionListener(new ButtonListener());
		
		turnLabel = new JLabel("Turn#: " + turnNumber);
		
		addMouseListener(new SquareListener());
		
		add(step);
		add(clear);
		add(turnLabel);
		
		setPreferredSize(new Dimension(500,500));
		setBackground(Color.cyan);
	}
	
	/**
	 * paintComponent
	 * Paints the grid of the game
	 */
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		
		page.setColor(Color.white);
		page.fillRect(startX, startY, width, height);
		page.setColor(Color.black);
		page.drawRect(startX, startY, width, height);
		
		int i,j;
		for(i = 0; i < row; i++)
		{
			for(j = 0; j < col; j++)
			{
				//Checks if cell is occupied or not
				if(cellModel.getCellStatus(i, j))
				{
					page.setColor(Color.green);
					page.fillRect(startX + i*squareSize, startY + j*squareSize, squareSize, squareSize);
					page.setColor(Color.black);
				}
				page.drawRect(startX + i*squareSize, startY + j*squareSize, squareSize, squareSize);
			}
		}
	}
	
	/**
	 * ButtonListener
	 * Class that contains information
	 * for how to react when the buttons
	 * are pressed.
	 */
	private class ButtonListener implements ActionListener
	{
		/**
		 * actionPerformed
		 * Determines which action is performed
		 * and steps to next generation or clears 
		 * board
		 */
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource() == step)
			{
				turnNumber += 1;
				stepPressed = true;
				cellModel.step();
				turnLabel.setText("Turn#: " + turnNumber);
				repaint();
			}
			else if(event.getSource() == clear)
			{
				cellModel.clear();
				stepPressed = false;
				turnNumber = 0;
				turnLabel.setText("Turn# :" + turnNumber);
				repaint();
			}
		}
	}
	
	/**
	 * SquareListener
	 * Class that contains the information on
	 * how to react to mouse events.
	 */
	private class SquareListener implements MouseListener
	{
		/**
		 * Checks if the mouse clicked a square and changes it to 
		 * occupied if the game is not in the middle of a 
		 * generation.
		 */
		public void mouseClicked(MouseEvent event) 
		{
			if(!stepPressed)
			{
				Point point = event.getPoint();
				int x = point.x;
				int y = point.y;
				int i, j;
				for(i = 0; i < row; i++)
				{
					for(j = 0; j < col; j++)
					{
						if((x > startX + i*squareSize) && (x < startX + (i+1)*squareSize) &&
								(y > startY + j*squareSize) && (y < startY + (j+1)*squareSize))
						{
							cellModel.changeStatus(true, i, j);
							repaint();
						}
					}
				}
			}
		}
		
		//Implemented methods
		public void mousePressed(MouseEvent event) {}
		public void mouseDragged(MouseEvent event) {}
		public void mouseReleased(MouseEvent event) {}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited (MouseEvent event) {}
	}
}
