package project.euler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem008 
{
	public static void main(String [] args)
	{
		FileReader fr = new FileReader(new File("problem008.txt"));

		Queue<Integer> queue = new LinkedList<>();
		long currentAmount = 1;
		long max = 1;
		while(fr.hasNext())
		{
			int size = queue.size();
			if (size >= 13)
			{
				max = Math.max(max, currentAmount);
				currentAmount /= queue.remove();
			}
			
			int digit = fr.next();
			if (digit == 0)
			{
				queue.clear();
				currentAmount = 1;
			}
			else
			{
				currentAmount *= digit;
				queue.add(digit);
			}
		}
		System.out.println(max);
	}
	
	public static class FileReader
	{
		Scanner sc;
		String currentLine;
		int currentIndex;
		
		public FileReader(File file)
		{
			try 
			{
				sc = new Scanner(file);
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
		
		public boolean hasNext()
		{
			if (currentLine == null)
			{
				return true;
			}
			else if (currentIndex < currentLine.length())
			{
				return true;
			}
			return sc.hasNextLine();
		}
		
		public int next()
		{
			if (!hasNext())
			{
				return -1;
			}
			
			if (currentLine == null)
			{
				currentLine = sc.nextLine();
				currentIndex = 0;
			}
			else if (currentIndex >= currentLine.length())
			{
				currentLine = sc.nextLine();
				currentIndex = 0;
			}
			
			char ch = currentLine.charAt(currentIndex);
			currentIndex++;
			return (int) (ch - '0');
		}
	}
}
