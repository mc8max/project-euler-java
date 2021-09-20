package project.euler;

public class Problem014_2 
{
	static int max = 0;
	
	public static void main(String [] args)
	{
		for(int i = 300000; i > 0; i--)
		{
			System.out.println(i);
			seq(i);
		}
		System.out.println(max);
	}
	
	static void seq(int n)
	{
		while (n > 1)
		{
			max = Math.max(max, n);
//			System.out.println(n);
			if (n % 2 == 0)
			{
				n /= 2;
			}
			else
			{
				n = 3 * n + 1;
			}
		}
//		System.out.println(1);
	}
}
