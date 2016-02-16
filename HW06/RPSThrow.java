/* Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on the homework assignment alone, 
 * using only course materials." 
 */
import java.util.*;

/**
 * RPSThrow
 * @author Rahmaan Lodhia
 * This class will create an RPSThrow
 * object, and it contains all the methods 
 * to manipulate a RPSThrow and all the variables
 * that describe the throw itself.
 */
public class RPSThrow implements Comparable
{
	/**
	 * Random static variable rand:
	 * This variable is specific for use in this class.
	 * This variable was created as a static variable versus
	 * other choices was because it needs to be available to only
	 * this class and all objects of the class.
	 * Making this an instance variable will create different Random 
	 * variables for each object of this class, and local variables are only
	 * available temporarily for the method it is contained in.
	 */
	private static Random rand = new Random();
	private enum Throw {Rock, Paper, Scissor}; //Enumerated variable to hold different throws
	private Throw userThrow; //Variable to contain user's throw
	
	
	/**
	 * RPSThrow constructor
	 * @param inputThrow  Number denoting a throw (int)
	 * Takes an int denoting a throw
	 * and sets the object's throw 
	 * variable to that specified throw.
	 */
	public RPSThrow(int inputThrow)
	{
		switch(inputThrow)
		{
			case 1: 
				userThrow = Throw.Rock;
				break;
			case 2:
				userThrow = Throw.Paper;
				break;
			case 3:
				userThrow = Throw.Scissor;
				break;
			default:
		}
	}
	
	
	/**
	 * compareTo
	 * Takes in an throw object and
	 * compares the throw variables
	 * to the current object' throw variable.
	 * Returns a 0 if they are the same, a 1 
	 * if the current object is greater, and a 
	 * -1 if the current object is less.
	 */
	public int compareTo(Object opponentThrow)
	{
		if(this.userThrow == ((RPSThrow) opponentThrow).userThrow)
			return 0;
		else if(((this.userThrow)==Throw.Rock) && ((((RPSThrow) opponentThrow).userThrow)==Throw.Scissor))
			return 1;
		else if(((this.userThrow)==Throw.Paper) && ((((RPSThrow) opponentThrow).userThrow)==Throw.Rock))
			return 1;
		else if(((this.userThrow)==Throw.Scissor) && ((((RPSThrow) opponentThrow).userThrow)==Throw.Paper))
			return 1;
		else
			return -1;
	}
	
	
	/**
	 * toString
	 * Returns a string representation 
	 * of an RPSThrow object's throw
	 * variable.
	 * @param inputThrow RPSThrow object
	 * @return String representation of throw
	 */
	public String toString(RPSThrow inputThrow)
	{
		return inputThrow.userThrow.name();
	}
	
	
	/**
	 * getRandomThrow
	 * Returns a random RPSThrow object.
	 * This method is static so that it may be used without creating
	 * a RPSThrow object.  It can be called without an object.  It also needs to 
	 * be static because it references the Random variable which is also static.
	 * An instance method requires that an object be created to use it, so we choose
	 * to make this static to avoid this inconvenience.
	 * @return Random RPSThrow object
	 */
	public static RPSThrow getRandomThrow()
	{
		int throwNumber = rand.nextInt(3) + 1;
		RPSThrow computerThrow = new RPSThrow(throwNumber);
		return computerThrow;
	}
}
