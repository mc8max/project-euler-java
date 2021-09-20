package project.euler;

import project.euler.util.Timer;

public class Problem031 
{
	static int[] VALUES = {200, 100, 50, 20, 10, 5, 2, 1};
	
	public static void main(String [] args)
	{
		Timer.start();
		System.out.println(numberOfWays(200, 0));
		Timer.elapse();
	}
	
	static int numberOfWays(int remaining, int index)
	{
		if (remaining == 0)
		{
			return 1;
		}
		else if (remaining > 0 && index >= VALUES.length)
		{
			return 0;
		}
		
		int d = remaining / VALUES[index];
		int sum = 0;
		for (int i = 0; i <= d; i++)
		{
			sum += numberOfWays(remaining - i * VALUES[index], index + 1);
		}
		
		return sum;
	}
}
