package project.euler;

import java.util.Set;
import java.util.TreeSet;

import project.euler.util.Timer;

public class Problem035 
{
	static Set<Integer> primes;
	
	public static void main(String [] args)
	{
		Timer.start();
		initialize();
		int count = 0;
		for (int prime : primes)
		{
			if (check(prime))
			{
				count++;
			}
		}
		System.out.println(count);
		Timer.elapse();
	}
	
	static void initialize()
	{
		primes = new TreeSet<>(Primes.generateList(1000000));
	}
	
	static boolean check(int prime)
	{
		if (prime < 10)
		{
			return true;
		}
		
		int digits = countDigits(prime);
		int mask = (int) Math.pow(10, digits - 1);
		for (int i = 1; i < digits; i++)
		{
			int digit = prime % 10;
			prime = prime / 10 + digit * mask;
			if (!primes.contains(prime))
			{
				return false;
			}
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
