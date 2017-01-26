import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CharacterFrequency<T>
{
	public static void main(String[] args)throws IOException
	{
		FileReader fr = new FileReader("letter1.txt");
		Scanner fs = new Scanner(fr);
		BufferedReader br = new BufferedReader(fr);
		FrequencyBag<Character> fb = new FrequencyBag<Character>();
	
		while (fs.hasNextLine())
		{
			String line = br.readLine();
			if (line == null) 
			{
				break;
			}
			line = line.toLowerCase();
			for (int i = 1; i < line.length(); i++)
			{
				char c = line.charAt(i);
				
				if (c != ' ' && c != ',' && c!='.') 
				{
					fb.add(c);
				}
			}
		}
		char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		int NumNodes=fb.getNumNodes();
		for (int j = 0; j< NumNodes; j++)
		{
			System.out.println(alpha[j] + ": " + fb.getFrequencyOf(alpha[j]));
		}
	
	}
}