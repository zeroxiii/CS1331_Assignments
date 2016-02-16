/* 
 * Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on this assignment alone, using only course materials.
 */

import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

/**
 * Level
 * @author rlodhia
 * Level class that contains all of the
 * game tiles and keeps track of the Items
 * in the game
 */
public class Level 
{
	//Instance variables
	private int rows, cols;
	private Game game;
	private int itemCount;
	private Tile[][] tileArray;
	public static Random rand = new Random();
	
	/**
	 * Level constructor
	 * @param game  Game variable (Game)
	 * @param rows  Total rows in game (int)
	 * @param cols  Total columsn in game (int)
	 * @throws IOException  Exception for IO
	 * Creates the Level.  Sets game environment 
	 * and generates Tile map from a file or
	 * from random generation
	 */
	public Level(Game game, int rows, int cols) throws IOException
	{
		this.game = game;
		this.rows = rows;
		this.cols = cols;
		this.itemCount = 0;
		this.tileArray = new Tile[rows][cols];

		//File chooser
		JFileChooser chooser = new JFileChooser();
		
		//Filters only the .game files
		chooser.setFileFilter(new FileFilter() 
		{
			public boolean accept(File f) 
			{
			    return f.getName().toLowerCase().endsWith(".txt")
			    	|| f.isDirectory();
			}
		
			public String getDescription() {
			    return "Text Files";
			}
		});
		
		int status = chooser.showOpenDialog(null);
		
		//Checks if file is accepted, canceled, or empty, and 
		//acts accordingly
		if((status == JFileChooser.CANCEL_OPTION))
		{
			this.generateRandomLevel();
		}
		else if((status == JFileChooser.APPROVE_OPTION))
		{
			File file = chooser.getSelectedFile();
			Scanner scan = new Scanner(file);
			
			if(scan.hasNext())
			{
				String line;
				int i,j;
				i = 0;				
				while(scan.hasNext() && i < this.getRows())
				{
					line = scan.nextLine();
					for(j =0; j < this.getCols(); j++)
					{
						if(line.charAt(j) == 'x')
						{
							tileArray[i][j] = new Wall(i,j);
						}
						else if(line.charAt(j) == 'o')
						{
							tileArray[i][j] = new Floor(i,j,new NoItem());
						}
						else if(line.charAt(j) == 'g')
						{
							tileArray[i][j] = new Floor(i,j,new Gem());
							itemCount++;
						}
						else if(line.charAt(j) == 'p')
						{
							tileArray[i][j] = new TeleportPanel(i,j);
						}
						else if(line.charAt(j) == 't')
						{
							tileArray[i][j] = new Trap(i,j);
						}
					}
					i++;
				}
			}
			else
			{
				this.generateRandomLevel();
			}
		}
	}
	
	/**
	 * generateRandomLevel
	 * Private helper method that generates
	 * a random level through percentages
	 */
	private void generateRandomLevel()
	{
		int i,j;
		int randomNum;
				
		for(i = 0; i < this.getRows(); i++)
		{
			for(j = 0; j < this.getCols(); j++)
			{
				if(i == 0 && j == 0)
				{
					tileArray[i][i] = new Floor(0,0,new NoItem());
				}
				else if(i == this.getRows() - 1 && j == this.getCols() -1)
				{
					tileArray[i][j] = new Floor(0,0,new NoItem());
				}
				else
				{
					randomNum = rand.nextInt(99) + 1;
					if((randomNum > 0) && (randomNum <= 15))
					{
						tileArray[i][j] = new Wall(i,j);
					}
					else if((randomNum > 15) && (randomNum <= 100))
					{
						randomNum = rand.nextInt(99) + 1;
						if((randomNum > 0) && (randomNum <= 10))
						{
							tileArray[i][j] = new Floor(i,j,new Gem());
							itemCount++;
						}
						else if((randomNum > 10) && (randomNum <=12))
						{
							tileArray[i][j] = new TeleportPanel(i,j);
						}
						else if((randomNum > 12) && (randomNum <= 13))
						{
							tileArray[i][j] = new Trap(i,j);
						}
						else
						{
							tileArray[i][j] = new Floor(i,j,new NoItem());
						}
					}
				}
			}
		}
	}
	
	/**
	 * draw
	 * @param g  Graphics object
	 * Draws all of the game components
	 * (Tiles, Monsters, and Players)
	 */
	public void draw(Graphics g)
	{
		
		
		int i, j;
		for(i = 0; i < this.getRows(); i++)
		{
			for(j = 0; j < this.getCols(); j++)
			{
				tileArray[i][j].draw(g);
			}
		}
		
		for(Monster monster : game.getMonsterList())
			monster.draw(g);
		
		game.getPlayerOne().draw(g);
		game.getPlayerTwo().draw(g);
	}
	
	/**
	 * canMoveToSquare
	 * @param row  Row value (int)
	 * @param col  Column value (int)
	 * @return  (boolean)
	 * Returns whether or not an object
	 * can move into this square
	 */
	public boolean canMoveToSquare(int row, int col)
	{
		if((row < this.getRows() && row >= 0) && (col < this.getCols() && col >= 0))
		{
			if(tileArray[row][col].isPassable())
				return true;
			else
				return false;
		}
		else 
			return false;
	}
	
	/**
	 * collectItem
	 * @param row  Row value (int)
	 * @param col  Column value (int)
	 * @return  collectItem
	 * Returns the Item in the square if it exists,
	 * otherwise returns a NoItem.  Updates the 
	 * item count if necessary.
	 */
	public Item collectItem(int row, int col)
	{
		Item collectItem = new NoItem();
		
		if((row < this.getRows() && row >= 0) && (col < this.getCols() && col >= 0))
		{
			if(tileArray[row][col].getClass().getName().equals("Floor"))
			{
				collectItem = ((Floor)tileArray[row][col]).collectItem();
				
				if((collectItem.getValue() == 1) && !collectItem.isCollected())
				{
					itemCount--;
					return collectItem;
				}
				
			}
		}
		
		return collectItem;
	}
	
	/**
	 * getRows
	 * @return  rows
	 * Returns the total rows of
	 * the game
	 */
	public int getRows()
	{
		return rows;
	}
	
	/**
	 * getCols
	 * @return  cols
	 * Returns the total columns
	 * of the game
	 */
	public int getCols()
	{
		return cols;
	}
	
	/**
	 * getItemCount
	 * @return  itemCount
	 * Returns the current item count
	 * of the game
	 */
	public int getItemCount()
	{
		return itemCount;
	}
	
	/**
	 * getTile
	 * @param row  Row value (int)
	 * @param col  Column value (int)
	 * @return  Tile
	 * Returns the Tile at 
	 * the specified location
	 */
	public Tile getTile(int row, int col)
	{
		return tileArray[row][col];
	}
}
