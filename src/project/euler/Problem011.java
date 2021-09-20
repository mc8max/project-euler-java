package project.euler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem011 
{
	public static void main(String [] args)
	{
		int[][] ar = read(new File("problem011.txt"));
		int max = 0;
		for (int i = 0; i <= 16; i++)
		{
			for (int j = 0; j <= 16; j++)
			{
				max = Math.max(max(ar, i, j), max);
			}
		}
		System.out.println(max);
	}
	
	static int max(int[][] ar, int r, int c)
	{
		int max = 0;
		// prod by row
		for (int i = 0; i < 4; i++)
		{
			int amount = 1;
			for (int j = 0; j < 4; j++)
			{
				amount *= ar[r + i][c + j];
			}
			max = Math.max(max, amount);
		}
		// prod by col
		for (int i = 0; i < 4; i++)
		{
			int amount = 1;
			for (int j = 0; j < 4; j++)
			{
				amount *= ar[r + j][c + i];
			}
			max = Math.max(max, amount);
		}
		// prod by diagonal line 1
		int amount = 1;
		for (int i = 0; i < 4; i++)
		{
			amount *= ar[r + i][c + i];
		}
		max = Math.max(max, amount);
		
		// prod by diagonal line 2
		amount = 1;
		for (int i = 0; i < 4; i++)
		{
			amount *= ar[r + 3 - i][c + i];
		}
		max = Math.max(max, amount);
		return max;
	}
	
	static int[][] read(File file)
	{
		int[][] ar = new int[20][20];
		try 
		{
			Scanner sc = new Scanner(file);
			int i = 0;
			while(sc.hasNextInt())
			{
				ar[i / 20][i % 20] = sc.nextInt();
				i++;
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		return ar;
	}
}
