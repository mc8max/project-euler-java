package project.euler;

import java.util.HashSet;
import java.util.Set;

import project.euler.util.Timer;

public class Problem029 
{
	public static void main(String [] args)
	{
		Timer.start();
		int limit = 100;
		Set<Double> powerNumbers = new HashSet<>();
		for (int a = 2; a <= limit; a++)
		{
			for (int b = 2; b <= limit; b++)
			{
				powerNumbers.add(Math.pow(a, b));
			}
		}
		System.out.println(powerNumbers.size());
		Timer.elapse();
	}
}
