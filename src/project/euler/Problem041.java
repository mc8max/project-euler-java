package project.euler;

import java.util.List;

import project.euler.util.Timer;

public class Problem041 
{
	public static void main(String [] args)
	{
		Timer.start();
		List<Integer> primes = Primes.generateList(100000000);
		int max = 0;
		for (int prime : primes)
		{
			if (isPanDigital(prime, countDigits(prime)))
			{
				if (max < prime)
				{
					max = prime;
				}
			}
		}
		System.out.println(max);
		Timer.elapse();
	}
	
	static boolean isPanDigital(long number, int length)
	{
		long count = 0;
		long digitFlags = 0;
		while (number > 0)
		{
			long digit = number % 10;
			long temp = digitFlags | (1 << digit);
			if (temp == digitFlags)
			{
				return false;
			}
			digitFlags = temp;
			number /= 10;
			count++;
		}
		int checkValue = (int) Math.pow(2, length + 1) - 1 - 1; 
		return checkValue == digitFlags;
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
