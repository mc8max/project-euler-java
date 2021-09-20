package project.euler;

import project.euler.util.Timer;

public class Problem039 
{
	public static void main(String [] args)
	{
		Timer.start();
		int max = 0;
		int selectedP = 0;
		for (int p = 4; p <= 1000; p+=2)
		{
			int count = count(p);
			if (max < count)
			{
				max = count;
				selectedP = p;
			}
		}
		System.out.println(selectedP);
		Timer.elapse();
	}
	
	static int count(int p)
	{
		int count = 0;
		for (int a = 1; a < p / 3; a++)
		{
			for (int b = a + 1; b < (p - a) / 2; b++)
			{
				int sum = (a + b) * 2;
				if (sum <= p)
				{
					continue;
				}
				
				int prod = 2 * a * b;
				if (prod % p != 0)
				{
					continue;
				}
				
				if ((p + prod / p) == sum)
				{
					count++;
				}
			}
		}
		return count;
	}
}
