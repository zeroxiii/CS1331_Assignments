/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JPanel;

/**
 * Canvas class
 * Holds all the shape, mouse listeners, and how the program
 * draws the shape.
 * @author rlodhia
 *
 */
public class Canvas extends JPanel
{
	//Instance variables
	private Color selectedColor;
	private ArrayList<Shape> shapeList;
	private String inputText;
	private int numShapes;
	private boolean fillSelected;
	private enum shapeName {rectangle, circle, line, text, none};
	private shapeName shapeSelected;
	
	/**
	 * Canvas constructor
	 * Creates the canvas by making a place to hold all the shapes
	 * and initializing all instance variables
	 */
	public Canvas()
	{
		shapeList = new ArrayList<Shape>();
		DrawListener listener = new DrawListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
		
		selectedColor = Color.black;
		shapeSelected = shapeName.none;
		fillSelected = false;
		numShapes = 0;
		inputText = "";

		setBackground(Color.white);
		setPreferredSize(new Dimension(1000,1000));
	}
	
	/**
	 * Draws the shapes from the array list
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
				
		for (Shape drawShape : shapeList)
		{
			if ((drawShape.startCoord != null) && (drawShape.endCoord != null))
				drawShape.draw(g);
		}
	}
	
	/**
	 * updateText
	 * Update text variable for use in text objects
	 * @param input  String containing input text (String)
	 */
	public void updateText(String input)
	{
		inputText = input;
	}
	
	/**
	 * updateFill
	 * Updates whether or not shapes need to be
	 * filled or not
	 * @param fill Determines whether or not a fill is necessary (boolean)
	 */
	public void updateFill(boolean fill)
	{
		fillSelected = fill;
	}
	
	/**
	 * updateColor
	 * Updates the color of the shapes
	 * @param col  Contains the new color for use (Color)
	 */
	public void updateColor(Color col)
	{
		selectedColor = col;
	}
	
	/**
	 * updateShapeSelection
	 * Updates which shape is currently being drawn
	 * @param shapeNum  Number indicating which shape is used (int)
	 */
	public void updateShapeSelection(int shapeNum)
	{
		switch(shapeNum)
		{
			case 1:
			{
				shapeSelected = shapeName.rectangle;
				break;
			}
			case 2:
			{
				shapeSelected = shapeName.circle;
				break;
			}
			case 3:
			{
				shapeSelected = shapeName.line;
				break;
			}
			case 4:
			{
				shapeSelected = shapeName.text;
				break;
			}
		}
	}
	
	/**
	 * DrawListener
	 * Holds all the data for how the canvas reacts to
	 * mouse movements.
	 * @author rlodhia
	 *
	 */
	private class DrawListener implements MouseListener, MouseMotionListener
	{
		/**
		 * mousePressed
		 * Figures out which shape is selected, and find the start point of
		 * the shape and adds it to the shape list
		 */
		public void mousePressed(MouseEvent event)
		{
			switch(shapeSelected)
			{
				case rectangle:
				{
					shapeList.add(new Rectangle(event.getPoint(), selectedColor, fillSelected));
					numShapes++;
					repaint();
					break;
				}
				case circle:
				{
					shapeList.add(new Circle(event.getPoint(), selectedColor, fillSelected));
					numShapes++;
					repaint();
					break;
				}
				case line:
				{
					shapeList.add(new Line(event.getPoint(), selectedColor));
					numShapes++;
					repaint();
					break;
				}
				case text:
				{
					shapeList.add(new Text(event.getPoint(), selectedColor, inputText));
					numShapes++;
					repaint();
					break;
				}
			}
		}
		
		/**
		 * mouseDragged
		 * Edits the last shapes end coordinates and updates the canvas
		 */
		public void mouseDragged(MouseEvent event)
		{
					(shapeList.get(shapeList.size()-1)).updateEnd(event.getPoint());
					repaint();
		}
		
		//Implemented methods
		public void mouseClicked(MouseEvent event) {};
		public void mouseReleased(MouseEvent event) {};
		public void mouseEntered(MouseEvent event) {};
		public void mouseExited(MouseEvent event) {};
		public void mouseMoved(MouseEvent event) {};
	}
}
