package project.euler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import project.euler.util.Timer;

public class Problem042 
{
	public static void main(String [] args)
	{
		Timer.start();
		Set<Long> triangles = new TreeSet<>();
		{
			long sum = 0;
			int i = 1;
			while (sum < 1000)
			{
				sum += i;
				triangles.add(sum);
				i++;
			}
		}
		try 
		{
			Scanner sc = new Scanner(new File("problem042.txt"));
			String text = sc.nextLine().trim();
			String [] names = text.split(",");
			for (int i = 0; i < names.length; i++)
			{
				names[i] = names[i].substring(1, names[i].length());
			}
			long max = 0;
			int count = 0;
			for (String name : names)
			{
				max = Math.max(max, computeValue(name));
				if (triangles.contains(computeValue(name)))
				{
					count++;
				}
			}
			System.out.println(max);
			System.out.println(count);
			sc.close();
			Timer.elapse();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	static long computeValue(String name)
	{
		long sum = 0;
		for (char ch : name.toCharArray())
		{
			sum += ch - 'A' + 1;
		}
		return sum;
	}
}
