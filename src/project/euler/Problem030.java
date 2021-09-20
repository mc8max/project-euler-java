package project.euler;

import project.euler.util.Timer;

public class Problem030 
{
	static final int POWER = 5;
	
	static long[] POWERS = new long[10];
	static
	{
		for (int i= 1; i < 10; i++)
		{
			POWERS[i] = (long) Math.pow(i, POWER);
		}
	}
	
	public static void main(String [] args)
	{
		Timer.start();
		long sum = 0;
		for (int i = 10; i <= 354294; i++)
		{
			if (powerOf(i) == i)
			{
				sum += i;
			}
		}
		System.out.println(sum);
		Timer.elapse();
	}
	
	static long powerOf(int number)
	{
		long sum = 0;
		while (number > 0)
		{
			sum += POWERS[number % 10];
			number /= 10;
		}
		return sum;
	}
}
