package project.euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import project.euler.util.Timer;

public class Problem023 
{
	public static void main(String [] args)
	{
		Timer.start();
		final int limit = 28124;
		Primes.initialize((int) Math.sqrt(limit));
		List<Integer> abundants = new ArrayList<>();
		for (int i = 12; i < limit; i++)
		{
			if (Primes.isAbundant(i))
			{
				abundants.add(i);
			}
		}
		
		Set<Integer> sumAbundants = new HashSet<>();
		for (int i = 0; i < abundants.size(); i++)
		{
			for (int j = 0; j < abundants.size(); j++)
			{
				int sum = abundants.get(i) + abundants.get(j);
				if (sum < limit)
				{
					sumAbundants.add(sum);
				}
			}
		}
		
		int sum = 0;
		for (int i = 1; i < limit; i++)
		{
			if (!sumAbundants.contains(i))
			{
				sum += i;
			}
		}
		System.out.println(sum);
		Timer.elapse();
	}
}
