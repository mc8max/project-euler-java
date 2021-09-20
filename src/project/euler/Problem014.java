package project.euler;

import java.util.HashMap;
import java.util.Map;

public class Problem014 
{
	static Map<Long, Integer> chains = null; 
	
	public static void main(String [] args)
	{
		chains = new HashMap<>();
		int max = 0;
		long startingNumber = 0;
		for (long i = 500000; i < 1000000; i++)
		{
			int size = chainSize2(i);
			if (size > max)
			{
				max = size;
				startingNumber = i;
			}
		}
		System.out.println(max);
		System.out.println(startingNumber);
	}
	
	static int chainSize(long n)
	{
		int size = 1;
		while (n > 1)
		{
			n = n % 2 == 0 ? n / 2 : (3*n + 1);
			size++;
		}
		return size;
	}
	
	static int chainSize2(long n)
	{
		if (n == 1)
		{
			return 1;
		}
		if (chains.containsKey(n))
		{
			return chains.get(n);
		}
		int size = 0;
		if (n % 2 == 0)
		{
			size = chainSize2(n / 2) + 1;
		}
		else
		{
			size = chainSize2((n * 3 + 1) / 2) + 2;
		}
		chains.put(n, size);
		return size;
	}
	
}
