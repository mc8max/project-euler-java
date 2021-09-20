package project.euler;

import java.util.HashSet;
import java.util.Set;

import project.euler.util.Timer;

public class Problem032 
{
	static Set<Long> existings;
	static boolean[] flags = new boolean[10];
	
	public static void main(String [] args)
	{
		Timer.start();
		existings = new HashSet<>();
		// Note: 100 x 999 = 99900 ~ 10 digits > limit of 9 digits.
		// Note: 10 * 9999 = 99990 ~ 10 digits > limit of 9 digits.
		// First search space
		for (int a = 1; a <= 99; a++)
		{
			for (int b = 1; b <= 987; b++)
			{
				check(a, b);
			}
		}
		// Second search space
		for (int a = 1; a <= 9; a++)
		{
			for (int b = 1; b <= 9876; b++)
			{
				check(a, b);
			}
		}
		long sum = 0;
		for (long prod : existings)
		{
			sum += prod;
		}
		System.out.println(sum);
		Timer.elapse();
	}
	
	static void check(long a, long b)
	{
		long prod = a * b;
		long total = append(prod, append(a, b));
		if (isPanDigital(total))
		{
			existings.add(prod);
		}
	}
	
	static boolean isPanDigital(long number)
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
		return count == 9 && ((digitFlags & 1) == 0);
	}
	
	static long append(long a, long b)
	{
		while (b > 0)
		{
			a = a * 10 + b % 10;
			b /= 10;
		}
		return a;
	}
}
