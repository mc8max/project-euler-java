package project.euler;

public class Problem024 
{
	public static void main(String [] args)
	{
//		System.out.println(factorial(10));
//		System.out.println(factorial(9));
		
		boolean [] takens = new boolean[10];
		long order = 1_000_000;
		int digitCount = 10;
		while (digitCount > 0)
		{
			long factorial = factorial(digitCount - 1);
			long div = order / factorial;
			order %= factorial;
			if (order == 0)
			{
				div -= 1;
				order = factorial;
			}
			int count = 0;
			int digit = 0;
			for (int i = 0; i <= 9; i++)
			{
				if (takens[i])
				{
					continue;
				}
				count++;
				if (count > div)
				{
					digit = i;
					break;
				}
			}
			
			takens[digit] = true;
			System.out.print(digit);
			digitCount--;
		}
	}
	
	static long factorial(int n)
	{
		long factorial = 1;
		while (n > 1)
		{
			factorial *= n;
			n--;
		}
		return factorial;
	}
}
