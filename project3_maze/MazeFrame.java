import java.util.ArrayList;
import javax.swing.JFrame;

public class MazeFrame
{
	public static void main(String[] args) throws InterruptedException
	{
		int width = 48;
		int height  = 40;
		JFrame frame = new JFrame();
		Maze maze = new Maze(width, height);
		ArrayList<Pair<Integer,Integer>> solution = new ArrayList<Pair<Integer,Integer>>();
		MazeComponent mc = new MazeComponent(maze, solution);
		frame.setSize(800,800);
		frame.setTitle("Maze");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(mc);
		frame.setVisible(true);
		
		solution.add(new Pair<Integer,Integer>(0,0));
		Thread.sleep(10);
		solveMaze(solution, mc, maze, 0, 0, 0, 0);
		mc.repaint();
	}
	
	/** Solve Maze: recursively solve the maze
	 * 
	 * @param solution   : The array list solution is needed so that every recursive call,
	 *                     a new (or more) next position can be added or removed.
	 * @param mc         : This is the MazeComponent. We need that only for the purpose of
	 *                     animation. We need to call mc.repaint() every time a new position
	 *                     is added or removed. For example,
	 *                       :
	 *                     solution.add(...);
	 *                     mc.repaint();
	 *                     Thread.sleep(sleepTime);
	 *                       :
	 *                     solution.remove(...);
	 *                     mc.repaint();
	 *                     Thread.sleep(sleepTime);
	 *                       :
	 * @param maze       : The maze data structure to be solved. 
	 * @return a boolean value to previous call to tell the previous call whether a solution is
	 *         found.
	 * @throws InterruptedException: We need this because of our Thread.sleep(10);
	 */
	public static boolean solveMaze(ArrayList<Pair<Integer,Integer>> solution, MazeComponent mc, Maze maze, int row, int column, int PreviousRow, int PreviousColumn) throws InterruptedException
	{
		if (row == maze.getHeight()-1 && column == maze.getWidth()-1)
		{
			return true;
		}
		
		else
		{
			if(!maze.isNorthWall(row,column) && row - 1 != PreviousRow)
			{
				solution.add(new Pair<Integer,Integer>(row-1, column));
				mc.repaint();
				Thread.sleep(10);
				boolean p = solveMaze(solution, mc, maze,row - 1, column, row, column);
				if(p)
				{
				return true;
				}
				else
				{
				solution.remove(solution.size()-1);
				mc.repaint();
				Thread.sleep(10);
				}
			}
		}
		if(!maze.isEastWall(row,column) && column + 1 != PreviousColumn) 
		{
			solution.add(new Pair<Integer,Integer>(row, column+1));
			mc.repaint();
			Thread.sleep(10);
			boolean p = solveMaze(solution, mc, maze,row, column + 1, row, column);
			if(p)
			{
				return true;
			}
			else
			{
				solution.remove(solution.size()-1);
				mc.repaint();
				Thread.sleep(10);
				//remove (row, column + 1) from solution
			}	
		}
		
		if(!maze.isSouthWall(row,column) && row + 1 != PreviousRow) 
		{
			solution.add(new Pair<Integer,Integer>(row+1, column));
			mc.repaint();
			Thread.sleep(10);
			boolean p = solveMaze(solution, mc, maze,row + 1, column, row, column);
			if(p)
			{
				return true;
			}
			else
			{		
				solution.remove(solution.size()-1);
				mc.repaint();
				Thread.sleep(10);
			}
		}	
		if(!maze.isWestWall(row,column) && column - 1 != PreviousColumn) 
		{
			solution.add(new Pair<Integer,Integer>(row, column-1));
			mc.repaint();
			Thread.sleep(10);
			boolean p = solveMaze(solution, mc, maze,row, column - 1, row, column);
			if(p)
			{
				return true;
			}
			else
			{
				solution.remove(solution.size()-1);
				mc.repaint();
				Thread.sleep(10);
			
			}
		}	
		return false;
	}
}

