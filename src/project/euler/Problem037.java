package project.euler;

import java.util.Set;
import java.util.TreeSet;

import project.euler.util.Timer;

public class Problem037 
{
	static Set<Integer> primes;
	
	public static void main(String [] args)
	{
		Timer.start();
		initialize();
		long sum = 0;
		int count = 0;
		for (int prime : primes)
		{
			if (isRightTruncatable(prime) && isLeftTruncatable(prime))
			{
//				System.out.println(prime);
				sum += prime;
				count++;
			}
		}
		System.out.println(sum);
		System.out.println(count);
		Timer.elapse();
	}
	
	static void initialize()
	{
		primes = new TreeSet<>(Primes.generateList(74000000));
	}
	
	static boolean isRightTruncatable(int prime)
	{
		if (prime < 10)
		{
			return false;
		}
		while (prime > 0)
		{
			prime /= 10;
			if (prime != 0 && !primes.contains(prime)) 
			{
				return false;
			}
		}
		return true;
	}
	
	static boolean isLeftTruncatable(int prime)
	{
		if (prime < 10)
		{
			return false;
		}
		int mask = (int) Math.pow(10, countDigits(prime) - 1);
		while (mask >= 10)
		{
			prime = prime % mask;
			if (!primes.contains(prime))
			{
				return false;
			}
			mask /= 10;
		}
		return true;
	}
	
	static int countDigits(int number)
	{
		int count = 0;
		while (number > 0)
		{
			count++;
			number /= 10;
		}
		return count;
	}
}
