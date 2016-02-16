/*Name: Rahmaan Lodhia
 *Prism: rlodhia3
 *Collaboration Statement: "I worked on the homework
 * assignment alone, using only course materials."  
 */

import javax.swing.JApplet;
import java.awt.Color;
import java.awt.Graphics;

/**
* This is HW2, a Movie Poster Applet.
* This applet draws a Movie Poster.
*/

public class MoviePosterApplet extends JApplet 
{
	public void paint(Graphics g) //Method to Specify Shapes to Draw
	{
		g.setColor(new Color(150,70,50));
		g.fillArc(7, 8, 50, 70, 0, 270);  //Draws 3/4 of an Oval
		g.setColor(Color.yellow);
		g.fillRect(10, 10, 50, 15); //Draws Filled Rectangle 
		g.setColor(Color.red);
		g.fillOval(5, 5, 20, 10); //Draws Filled Oval
		g.setColor(Color.blue);
		g.fillRect(20,10,20,20); //Draws Filled Rectangle
		g.setColor(Color.black);
		g.drawRect(0,0,200,100);  //Draws Poster Outline
		g.drawString("Shapes: The Movie",50,60); //Movie Title
	} //end paint
	
} //end Applet


