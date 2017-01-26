import java.util.Random;

public class test
{

	public static void main(String[] args0)
	{
		int[][] test = new int [4][2];
		for(int i = 0; i < 4; i++)
		{
			for (int j = 0; j<2; j++)
			{
				test[i][j] = i+j;
			}
		}
	System.out.println("test:[0][1] = " + test[0][1]);
	System.out.println("test:[1][1] = " + test[1][1]);
	
	Random random = new Random();
		
	int rand = random.nextInt(4);
	System.out.println(rand);
	}


}
	/*int check=-1; 
		/*if (hole == true)
			{
				check = random.nextInt(row+1);
			}
		for (int i = 0; i<row+1;i++)
		{
			if (i == check)
			{
				continue;
			}	
			else
			{
				CS[i][column].putEast();
				if((column +1) <= aWidth)
				{
				CS[i][(column+1)].putWest();
				}
			}
		*/