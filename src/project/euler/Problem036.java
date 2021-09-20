package project.euler;

import project.euler.util.Timer;

public class Problem036 
{
	public static void main(String [] args)
	{
		Timer.start();
		long sum = 0;
		for (int i = 1; i < 1000000; i++)
		{
			if (i == reverseInDecimal(i) && i == reverseInBinary(i))
			{
				sum += i;
			}
		}
		System.out.println(sum);
		Timer.elapse();
	}
	
	static int reverseInDecimal(int number)
	{
		int reverse = 0;
		while(number > 0)
		{
			reverse = reverse * 10 + number % 10;
			number /= 10;
		}
		return reverse;
	}
	
	static int reverseInBinary(int number)
	{
		int reverse = 0;
		while (number > 0)
		{
			reverse = reverse << 1;
			reverse |= number & 1;
			number = number >> 1;
		}
		return reverse;
	}
}
