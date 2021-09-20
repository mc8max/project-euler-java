package project.euler;

public class Problem033 
{
	public static void main(String [] args)
	{
		int totalA = 1;
		int totalB = 1;
		for (int a = 11; a <= 99; a++)
		{
			for (int b = a + 1; b <= 99; b++)
			{
				if (check(a, b))
				{
					totalA *= a;
					totalB *= b;
					System.out.println(a + " - " + b);
				}
			}
		}
		
		System.out.println(totalA + " - " + totalB);
	}
	
	static boolean check(int a, int b)
	{
		if (a % 10 == 0 || b % 10 == 0 || a == b)
		{
			return false;
		}
		
		int a1 = a % 10;
		int a2 = (a / 10) % 10;
		int b1 = b % 10;
		int b2 = (b / 10) % 10;
		
		if (a1 == b1)
		{
			if (checkEqual(a, b, a2, b2)) 
			{
//				return a2 + "/" + b2;
				return true;
			}
		}
		if (a1 == b2)
		{
			if (checkEqual(a, b, a2, b1)) 
			{
//				return a2 + "/" + b1;
				return true;
			}
		}
		if (a2 == b1)
		{
			if (checkEqual(a, b, a1, b2)) 
			{
//				return a1 + "/" + b2;
				return true;
			}
		}
		if (a2 == b2)
		{
			if (checkEqual(a, b, a1, b1)) 
			{
//				return a1 + "/" + b1;
				return true;
			}
		}
		return false;
	}
	
	static boolean checkEqual(int a, int b, int digitA, int digitB)
	{
		return (a * digitB) == (b * digitA);
	}
}
