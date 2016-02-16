/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * PaintPanel
 * Contains the canvas and menu for
 * use for the Paint program
 * @author rlodhia
 *
 */
public class PaintPanel extends JPanel
{
	//Instance variables
	private JButton rectangle, circle, text, line, color, quit;
	private JLabel selectedColor;
	private JCheckBox filled;
	private JPanel currentColor, menu;
	private Color colorSelected;
	private boolean fill;
	private int shapeSelected;
	private String input;
	private Canvas canvas;
	
	/**
	 * PaintPanel constructor
	 * Sets up all the instance variables, buttons, canvas, and
	 * button listeners
	 */
	public PaintPanel()
	{
		colorSelected = Color.black;
		fill = false;
		shapeSelected = 5;
		input = "";
		
		rectangle = new JButton("Rectangle");
		circle = new JButton("Circle");
		line = new JButton("Line");
		text = new JButton("Text");
		
		this.setLayout(new BorderLayout());
		
		ButtonListener listener = new ButtonListener();
		
		rectangle.addActionListener(listener);
		circle.addActionListener(listener);
		line.addActionListener(listener);
		text.addActionListener(listener);
		
		filled = new JCheckBox("Filled");
		filled.addItemListener(new StyleListener());
		
		color = new JButton("Color");
		color.addActionListener(listener);
		
		quit = new JButton("Quit");
		quit.addActionListener(listener);
		
		currentColor = new JPanel();
		currentColor.setBackground(colorSelected);
		currentColor.setPreferredSize(new Dimension(100,100));
		
		menu = new JPanel();
		menu.setPreferredSize(new Dimension(100,1000));
		selectedColor = new JLabel("Current Color:");
		
		canvas = new Canvas();
		
		add(menu,BorderLayout.WEST);
		menu.add(line);
		menu.add(circle);
		menu.add(rectangle);
		menu.add(text);
		menu.add(filled);
		menu.add(color);
		menu.add(selectedColor);
		menu.add(currentColor);
		menu.add(quit);
		add(canvas, BorderLayout.CENTER);		
	}
	
	/**
	 * ButtonListener
	 * Contains the information on how to react to each
	 * button and changes the program accordingly
	 * @author rlodhia
	 *
	 */
	private class ButtonListener implements ActionListener
	{
		/**
		 * actionPerformed
		 * Determines which button is pressed 
		 * and acts accordingly
		 */
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource() == rectangle)
				canvas.updateShapeSelection(1);
			else if(event.getSource() == circle)
				canvas.updateShapeSelection(2);
			else if(event.getSource() == line)
				canvas.updateShapeSelection(3);
			else if(event.getSource() == text)
			{
				input = JOptionPane.showInputDialog("Enter text:");
				canvas.updateShapeSelection(4);
				canvas.updateText(input);
			}
			else if(event.getSource() == color)
			{
				colorSelected = JColorChooser.showDialog(currentColor, "Pick a Color", colorSelected);
				canvas.updateColor(colorSelected);
				currentColor.setBackground(colorSelected);
			}
			else if(event.getSource() == quit)
			{
				System.exit(0);
			}
		}
	}
	
	/**
	 * StyleListener
	 * Tells how to react to the check box
	 * @author rlodhia
	 *
	 */
	private class StyleListener implements ItemListener
	{
		/**
		 * itemStateChanged
		 * Determines how the program will react
		 * if the check box is selected
		 */
		public void itemStateChanged(ItemEvent event)
		{
			if(filled.isSelected())
			{
				fill = true;
				canvas.updateFill(fill);
			}
			else
			{
				fill = false;
				canvas.updateFill(fill);
			}
		}
	}
	
}
