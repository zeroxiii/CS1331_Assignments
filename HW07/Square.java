/* Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on the homework assignment
 *  alone, using only course materials." 
 */

/**
 * Square Class
 * 
 * Handles a square for 
 * the grid of the game
 * with access methods and
 * occupation variables.
 */
public class Square 
{
	//Boolean variable for whether or not a square is occupied
	private boolean occupied;

	/**
	 * Square Constructor
	 * Creates object and sets default value for
	 * occupied variable
	 */
	public Square()
	{
		this.occupied = false;
	}
	
	/**
	 * getOccupied
	 * Returns a numerical value for
	 * the occupied variable for the
	 * square
	 * @return 1 if occupied, 0 if not
	 */
	public int getOccupied()
	{
		if(this.occupied)
			return 1;
		else
			return 0;
	}
	
	/**
	 * getStatus
	 * Returns boolean value of
	 * the square's occupation status
	 * @return occpied (boolean)
	 */
	public boolean getStatus()
	{
		return this.occupied;
	}
	
	/**
	 * squareEmptied
	 * Changes the square's 
	 * occupation to empty
	 */
	public void squareEmptied()
	{
		this.occupied = false;
	}
	
	/**
	 * squareOccupied
	 * Changes the square's 
	 * occupation to filled.
	 */
	public void squareOccupied()
	{
		this.occupied = true;
	}
}
