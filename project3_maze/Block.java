public class Block 
{
	private boolean north;
	private boolean east;
	private boolean south;
	private boolean west;
	
	public Block ()
	{
		north = false;
		east = false;
		south = false;
		west = false;
	}
	/**
		put, get, remove North wall
	**/ 
	public boolean getNorth()
	{
		return north;
	}
	public void putNorth() 
	{
		north = true;
	}
	public void removeNorth()
	{
		north = false;
	}
	/**
		put, get, remove East wall
	**/ 
	public boolean getEast()
	{
		return east;
	}
	public void putEast() 
	{
		east = true;
	}
	public void removeEast()
	{
		east = false;
	}
	/**
		put, get, remove South wall
	**/ 
	public boolean getSouth()
	{
		return south;
	}
	
	public void putSouth() 
	{
		south = true;
	}
	public void removeSouth()
	{
		south = false;
	}
	/**
		put, get, remove West wall
	**/
	public boolean getWest()
	{
		return west;
	}
	public void putWest() 
	{
		west = true;
	}
	public void removeWest()
	{
		west = false;
	}


}