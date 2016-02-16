/* Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration Statement: "I worked on the homework
 * assignment alone, using only course materials." 
 */

/**
 * TipCalculator.java
 * 
 * This program is a tip calculator
 * It takes in user inputs to display 
 * useful information such as,
 * totals, tips, and split checks.
 * 
 */


import java.util.Scanner;


public class TipCalculator 
{
	/**
	 * Sets up environment and calculates various information
	 */
	public static void main(String[] args)
	{
		//Creates Scanner for use in program
	     Scanner sc = new Scanner(System.in);
	     
	     //Displays information to user
	     System.out.println("Tip Calculator\n");
	     System.out.println("Enter the prices of your items. Enter -1 to enter tip percentage.\n");
	     
	     double subTotal = enterPrices(sc); //Takes prices
	     double tip = enterTip(sc); //Takes tip
	     double total = printAndCalculateTotals(subTotal, tip); //Displays and calculates total
	     
	     splitCheck(total,sc); //Asks for split check
	     
	}
	
	
	/**
	 * Takes in user input for prices of items
	 * Calculates the total and terminates when
	 * user wishes to enter tip.
	 * 
	 * @param  sc  Scanner class used to take in user input
	 * 
	 * @return total  Returns the price total
	 */
	static double enterPrices(Scanner sc) 
	{
		//Variables for use in moethod
		boolean finished = false;
		double price = 0;
		int count = 1; 
		double total = 0;
		
		//Takes in inputs and incurs running total
		while(!finished)
		{
			System.out.print("Item " + count + ": $");
			price = sc.nextDouble();
			
			if (price == -1)
			{
				finished = true;
			}
			else
			{
				total += price; 
			}
			
			count++;
		}
		return total;
	}
	
	
	/**
	 * Asks for tip percentage
	 * 
	 * @param sc  Scanner class used to take in input
	 * @return tip  Returns tip value
	 */
	static double enterTip(Scanner sc)
	{
		//Takes in tip percentage
		System.out.println();
		System.out.print("Enter the tip percentage: ");
		
		double tip = sc.nextDouble();
		return tip;
	}
	
	
	/**
	 * Calculate and print totals
	 * 
	 * @param subTotal  Total incurred so far
	 * @param tip  Tip percentage as inputed by user
	 * @return total  Complete total after tip
	 */
	static double printAndCalculateTotals(double subTotal, double tip)
	{
		//Calculates, Displays, and Returns totals
		double tipAmount = (subTotal * (tip/100));
		double total = tipAmount + subTotal;
		
		System.out.println();
		System.out.println("Subtotal: $" + subTotal);
		System.out.println("Tip: $" + tipAmount);
		System.out.println("Total: $" + total);
		
		return total;
	}
	
	
	/**
	 * Asks for split check
	 * and displays price per
	 * person
	 * 
	 * @param total  Total of tip and prices
	 * @param sc  Scanner classed used for user input
	 */
	static void splitCheck(double total, Scanner sc)
	{
		//Asks for split check
		System.out.println();
		System.out.print("Split the check? (y/n): ");
		String answer = sc.next();
		
		//Makes calculation if answer is yes
		if (answer.equals("y"))
		{
			System.out.print("Number of people: ");
			double people = sc.nextDouble();
			System.out.println();
			System.out.println("Per person: $" + total/people);
		}
	}
}
