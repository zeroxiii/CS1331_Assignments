/* Name: Rahmaan Lodhia
 * Prism: rlodhia3 
 * Collaboration: "I worked on the homework assignment alone, using only course materials."
 */

import java.util.Scanner;

/**
 * NameTagGenerator
 * 
 * Class used to receive input from user.
 * Creates and displays a name tag after information is entered.
 *
 */
public class NameTagGenerator 
{
	/**
	 * main
	 * Takes user input and displays name tag.
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Initialize variables
		String first, middle, last; 
		Scanner input = new Scanner(System.in);
		
		//Take in user input
		System.out.print("Enter First Name: ");
		first = input.next();
		System.out.print("Enter Middle Name: ");
		middle = input.next();
		System.out.print("Enter Last Name: ");
		last = input.next();
		
		//Create and display name tag
		Name name = new Name(first, middle, last);
		name.normalize();
		NameTag tag = new NameTag(name);
		tag.showNameTag();
	}
}
