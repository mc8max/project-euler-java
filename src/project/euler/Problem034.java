package project.euler;

import project.euler.util.Timer;

public class Problem034 
{
	public static void main(String [] args)
	{
		Timer.start();
		long[] factorials = new long[10];
		factorials[0] = factorials[1] = 1;
		long prod = 1;
		for (int i = 2; i < 10; i++)
		{
			prod *= i;
			factorials[i] = prod;
		}
		
		long sum = 0;
		for (int i = 11; i <= 999999; i++)
		{
			if (check(factorials, i))
			{
//				System.out.println(i);
				sum += i;
			}
		}
		System.out.println(sum);
		Timer.elapse();
	}
	
	static boolean check(long[] factorials, final int number)
	{
		int d = number;
		long sum = 0;
		while (d > 0)
		{
			if (sum > number)
			{
				return false;
			}
			sum += factorials[d % 10];
			d /= 10;
		}
		return sum == number;
	}
}
