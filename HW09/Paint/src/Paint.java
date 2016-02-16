/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import javax.swing.JFrame;

/**
 * Paint class
 * Driver for the Paint program
 * 
 * Example of dynamic binding: Canvas.java Line 37
 * This line creates an ArrayList that can hold any basic class derived
 * from Shape, which means it has dynamic binding since it is only later
 * in the program the compiler knows which exact shape is used in this list
 * 
 * Example of Polymorphism:  Rectangle.java Line 27
 * This shows an example of overloading, a type of polymorphism.  The
 * rectangle constructor has an extra input variable that does not show
 * up in the abstract class shape.
 * 
 * Example of Polymorphism:  Circle.java Line 39
 * This shows how multiple object can inherit a method from a super
 * class and not change it.  This is inclusion polymorphism where subclasses use
 * methods from a super class
 * 
 * @author rlodhia
 *
 */
public class Paint 
{
	/**
	 * main
	 * Creates frame to hold the paint panel
	 * and displays the program
	 * @param args
	 */
	public static void main(String[]  args)
	{
		JFrame frame = new JFrame("Paint");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PaintPanel paintPanel = new PaintPanel();
		frame.getContentPane().add(paintPanel);
		
		frame.pack();
		frame.setVisible(true);
	}
}
