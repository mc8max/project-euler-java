package project.euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem026 
{
	public static void main(String [] args)
	{
		int max = 0;
		int result = 0;
		for (int d = 2; d < 1000; d++)
		{
			int cycle = cycle(d);
			if (cycle > max)
			{
				max = cycle;
				result = d;
			}
		}
		System.out.println(result);
	}
	
	static int cycle(int number)
	{
		List<Integer> remainders = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		int remainder = 0;
		int divisor = 1;
		do 
		{
			divisor = next(number, divisor);
			remainder = divisor % number;
			if (set.contains(remainder))
			{
				for (int i = 0; i < remainders.size(); i++)
				{
					if (remainders.get(i) == remainder)
					{
						return remainders.size() - i;
					}
				}
			}
			set.add(remainder);
			remainders.add(remainder);
			divisor = remainder;
		}
		while(remainder > 0);
		return 0;
	}
	
	static int next(int number, int divisor)
	{
		while (divisor < number)
		{
			divisor *= 10;
		}
		return divisor;
	}
}
