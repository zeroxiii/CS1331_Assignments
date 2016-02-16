/* Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on the homework assignment
 *  alone, using only course materials." 
 */

/**
 * CellModel
 * Creates the grid of squares, and 
 * manages the structure and steps
 * of the next generation of squares.
 */
public class CellModel 
{
	//Instance variables
	private Square[][] grid;
	private Square[][] dummyGrid;
	private int height, width;

	/**
	 * CellModel Constructor
	 * Creates and sets up the grid
	 * of squares
	 * @param rows  Number of rows in the grid
	 * @param cols  Number of cols in the grid
	 */
	public CellModel(int rows, int cols)
	{
		grid = new Square[rows][cols];
		dummyGrid = new Square[rows][cols];
		height = rows;
		width = cols;
		
		int i,j;
		for(i = 0; i < height; i++)
		{
			for(j = 0; j < width; j++)
			{
				grid[i][j] = new Square();
			}
		}
		
		//Creates a dummy grid to completely check for
		//all squares in calculation of the next generation.
		for(i = 0; i < height; i++)
		{
			for(j = 0; j < width; j++)
			{
				dummyGrid[i][j] = new Square();
			}
		}
	}
	
	/**
	 * checkNeighbors
	 * Checks the adjacent squares around
	 * the specified square and returns
	 * the number as an int.
	 * @param row Row of specified square
	 * @param col Column of specified square
	 * @return Number of adjacent spaces
	 */
	public int checkNeighbors(int row, int col)
	{
		int numNeighbors = 0;
		
		//Checks all possible situations for square
		//and finds the neighbors
		if((row == 0) && (col == 0))
		{
			numNeighbors += (grid[row+1][col]).getOccupied();
			numNeighbors += (grid[row][col+1]).getOccupied();
			numNeighbors += (grid[row+1][col+1]).getOccupied();
		}
		else if((row == 0) && (col == width-1))
		{
			numNeighbors += (grid[row+1][col]).getOccupied();
			numNeighbors += (grid[row][col-1]).getOccupied();
			numNeighbors += (grid[row+1][col-1]).getOccupied();
		}
		else if((row == height-1) && (col == 0))
		{
			numNeighbors += (grid[row-1][col]).getOccupied();
			numNeighbors += (grid[row-1][col+1]).getOccupied();
			numNeighbors += (grid[row][col+1]).getOccupied();
		}
		else if((row == height-1) && (col == width-1))
		{
			numNeighbors += (grid[row-1][col]).getOccupied();
			numNeighbors += (grid[row-1][col-1]).getOccupied();
			numNeighbors += (grid[row][col-1]).getOccupied();
		}
		else if(col == 0)
		{
			numNeighbors += (grid[row+1][col]).getOccupied();
			numNeighbors += (grid[row][col+1]).getOccupied();
			numNeighbors += (grid[row+1][col+1]).getOccupied();
			numNeighbors += (grid[row-1][col]).getOccupied();
			numNeighbors += (grid[row-1][col+1]).getOccupied();
		}
		else if(row == 0)
		{
			numNeighbors += (grid[row+1][col]).getOccupied();
			numNeighbors += (grid[row][col+1]).getOccupied();
			numNeighbors += (grid[row+1][col+1]).getOccupied();
			numNeighbors += (grid[row][col-1]).getOccupied();
			numNeighbors += (grid[row+1][col-1]).getOccupied();
		}
		else if(col == width-1)
		{
			numNeighbors += (grid[row+1][col]).getOccupied();
			numNeighbors += (grid[row][col-1]).getOccupied();
			numNeighbors += (grid[row+1][col-1]).getOccupied();
			numNeighbors += (grid[row-1][col]).getOccupied();
			numNeighbors += (grid[row-1][col-1]).getOccupied();
		}
		else if(row == height-1)
		{
			numNeighbors += (grid[row-1][col]).getOccupied();
			numNeighbors += (grid[row-1][col+1]).getOccupied();
			numNeighbors += (grid[row][col+1]).getOccupied();
			numNeighbors += (grid[row-1][col-1]).getOccupied();
			numNeighbors += (grid[row][col-1]).getOccupied();
		}
		else if((row > 0) && (row < height) && (col > 0) && (col < width))
		{
			numNeighbors += (grid[row-1][col]).getOccupied();
			numNeighbors += (grid[row-1][col-1]).getOccupied();
			numNeighbors += (grid[row-1][col+1]).getOccupied();
			numNeighbors += (grid[row+1][col]).getOccupied();
			numNeighbors += (grid[row][col+1]).getOccupied();
			numNeighbors += (grid[row+1][col+1]).getOccupied();
			numNeighbors += (grid[row][col-1]).getOccupied();
			numNeighbors += (grid[row+1][col-1]).getOccupied();
		}
		
		return numNeighbors;
	}
	
	/**
	 * step
	 * Edits the grid for the next
	 * generation of squares.
	 */
	public void step()
	{
		int i,j;
		
		//Makes dummy grid equivalent to grid
		for(i = 0; i < height; i++)
		{
			for(j = 0; j < width; j++)
			{
				if((grid[i][j]).getStatus())
					(dummyGrid[i][j]).squareOccupied();
				else 
					(dummyGrid[i][j]).squareEmptied();			
			}
		}
		
		//Checks grid and edits dummy grid
		for(i = 0; i < height; i++)
		{
			for(j = 0; j < width; j++)
			{
				if((checkNeighbors(i,j) == 3) && !(grid[i][j]).getStatus())
				{
					(dummyGrid[i][j]).squareOccupied();
				}
				else if(checkNeighbors(i,j) > 3)
				{
					(dummyGrid[i][j]).squareEmptied();
				}
				else if(checkNeighbors(i,j) < 2)
				{
					(dummyGrid[i][j]).squareEmptied();
				}
			}
		}
		
		//Changes grid based on the edited dummy grid
		for(i = 0; i < height; i++)
		{
			for(j = 0; j < width; j++)
			{
				if((dummyGrid[i][j]).getStatus())
					(grid[i][j]).squareOccupied();
				else 
					(grid[i][j]).squareEmptied();
			}
		}
	}
	
	/**
	 * clear
	 * Clears the grid of occupied
	 * squares
	 */
	public void clear()
	{
		int i,j;
		for(i = 0; i < height; i++)
		{
			for(j = 0; j < width; j++)
			{
				(grid[i][j]).squareEmptied();
			}
		}
	}
	
	/**
	 * getCellStatus
	 * Checks the specified square for 
	 * its occupation
	 * @param row Row of specified square
	 * @param col Column of specified square
	 * @return Cell occupation status
	 */
	public boolean getCellStatus(int row, int col)
	{
		return (grid[row][col]).getStatus();
	}
	
	/**
	 * changeStatus
	 * Changes the specified squares to
	 * the specified state
	 * @param state  State of square
	 * @param row  Row of square
	 * @param col  Column of square
	 */
	public void changeStatus(boolean state, int row, int col)
	{
		if(state)
			(grid[row][col]).squareOccupied();
		else
			(grid[row][col]).squareEmptied();

	}
}
