import java.util.Random;
// No other import statement is allowed

public class Maze
{
	private int Width = 0;
	private int Height = 0;
	Block [][] CS = new Block[0][0];
	Random rand = new Random();
	/**
	 * Constructor
	 * @param aWidth the number of chambers in each row
	 * @param aHeight the number of chamber in each column
	 */
	public Maze(int aWidth, int aHeight)
	{
		Width = aWidth;
		Height = aHeight;
		
		CS = new Block[Width][Height]; 
		for(int i = 0; i < Width; i++)
		{
			for(int j = 0; j < Height; j++)
			{
				CS[i][j] = new Block();
				if (i == 0)
				{
					CS[i][j].putWest();
				}
				if (i == Width-1)
				{
					CS[i][j].putEast();
				}
				if (j == 0)
				{
					CS[i][j].putNorth();
				}
				if (j == Height-1)
				{
					CS[i][j].putSouth();
				}
			}
		}
		generate(Width-1, Height-1, 0, 0);
	}

	

	public void generate(int MaxHieght, int MaxWidth, int MinHeight, int MinWidth)
	{	
		
		if (MaxHieght-MinHeight < 1 || MaxWidth-MinWidth < 1) 
		{
			return;
		}
		
		int row = RandomNum(MaxHieght, MinHeight+1);
		int column = RandomNum(MaxWidth, MinWidth+1);
		
		int noDelete = RandomNum(4, 1); 
		
		makeNorthWall(MaxHieght, MaxWidth, MinHeight, MinWidth, row, column);
		makeWestWall(MaxHieght, MaxWidth, MinHeight, MinWidth, row, column);
		makeEastWall(MaxHieght, MaxWidth, MinHeight, MinWidth, row, column);
		makeSouthWall(MaxHieght, MaxWidth, MinHeight, MinWidth, row, column);
		
		if (noDelete == 1)
		{
			putGapEast(MaxHieght, row, column);
			putGapWest(row-1, MinHeight, column);
			putGapSouth(MaxWidth, column, row);
		}
		else if (noDelete == 2)
		{
			putGapNorth(column-1, MinWidth, row);
			putGapWest(row-1, MinHeight, column);
			putGapSouth(MaxWidth, column, row);
		}
		else if (noDelete == 3)
		{
			putGapNorth(column-1, MinWidth, row);
			putGapEast(MaxHieght, row, column);
			putGapSouth(MaxWidth, column, row);
		}
		else if (noDelete == 4)
		{
			putGapNorth(column-1, MinWidth, row);
			putGapEast(MaxHieght, row, column);
			putGapWest(row-1, MinHeight, column);
		}
		generate(row-1, column-1, MinHeight, MinWidth);
		generate(MaxHieght, column-1, row, MinWidth);
		generate(row-1, MaxWidth, MinHeight, column);
		generate(MaxHieght, MaxWidth, row, column);
	}
	
	public int RandomNum(int max, int min)
	{
		int num = rand.nextInt((max - min) +1) + min;
		return num;
	}
	
	public void makeNorthWall(int MaxHieght, int MaxWidth, int MinHeight, int MinWidth, int row, int column)
	{
		for( int i = column-1; i >= MinWidth; i-- )
		{
			CS[row][i].putWest();
			CS[row-1][i].putEast();
		}
	}
	
	public void makeWestWall(int MaxHieght, int MaxWidth, int MinHeight, int MinWidth, int row, int column)
	{
		for( int i = row-1; i >= MinHeight; i-- )
		{
			CS[i][column].putNorth();
			CS[i][column-1].putSouth();
		}
	}
	
	public void makeEastWall(int MaxHieght, int MaxWidth, int MinHeight, int MinWidth, int row, int column)
	{
		for( int i = row; i <= MaxHieght; i++ )
		{
			CS[i][column].putNorth();
			CS[i][column-1].putSouth();
		}
	}
	
	public void makeSouthWall(int MaxHieght, int MaxWidth, int MinHeight, int MinWidth, int row, int column)
	{
		for( int i = column; i <= MaxWidth; i++ )
		{
			CS[row][i].putWest();
			CS[row-1][i].putEast();
		}
	}
	
	public void putGapNorth(int max, int min, int place)
	{
		int point = RandomNum(max, min);
		CS[place-1][point].removeEast();
		CS[place][point].removeWest();
	}
	
	public void putGapEast(int max, int min, int place)
	{
		int point = RandomNum(max, min);
		CS[point][place].removeNorth();
		CS[point][place-1].removeSouth();
		
	}
	
	public void putGapWest(int max, int min, int place)
	{
		int point = RandomNum(max, min);
		CS[point][place].removeNorth();
		CS[point][place-1].removeSouth();
		
	}
	public void putGapSouth(int max, int min, int place)
	{
		int point = RandomNum(max, min);
		CS[place-1][point].removeEast();
		CS[place][point].removeWest();
	}
	/**
	 * getWidth
	 * @return the Width of this CS
	 */
	public int getWidth()
	{
		return Width;
	}
	/**
	 * getHeight
	 * @return the Height of this CS
	 */
	public int getHeight()
	{
		return Height;
	}
	/**
	 * isNorthWall
	 * @param row the row identifier of a chamber
	 * @param column the column identifier of a chamber
	 * @return true if the chamber at row row and column column
	 * contain a north wall. Otherwise, return false
	 */
	public boolean isNorthWall(int row, int column)
	{
		return CS[column][row].getNorth();
	}
	/**
	 * isEastWall
	 * @param row the row identifier of a chamber
	 * @param column the column identifier of a chamber
	 * @return true if the chamber at row row and column column
	 * contain an east wall. Otherwise, return false
	 */
	public boolean isEastWall(int row, int column)
	{
		return CS[column][row].getEast();
	}
	/**
	 * isSouthWall
	 * @param row the row identifier of a chamber
	 * @param column the column identifier of a chamber
	 * @return true if the chamber at row row and column column
	 * contain a south wall. Otherwise, return false
	 */
	public boolean isSouthWall(int row, int column)
	{
		return CS[column][row].getSouth();
	}
	/**
	 * isWestWall
	 * @param row the row identifier of a chamber
	 * @param column the column identifier of a chamber
	 * @return true if the chamber at row row and column column
	 * contain a west wall. Otherwise, return false
	 */
	public boolean isWestWall(int row, int column)
	{
		return CS[column][row].getWest();
	}
}