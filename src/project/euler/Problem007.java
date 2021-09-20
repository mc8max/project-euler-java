package project.euler;

public class Problem007 
{
	public static void main(String [] args)
	{
		final int number = 10001;
		final int power = number * number;
		boolean [] isPrime = new boolean[power];
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i < isPrime.length; i++)
		{
			isPrime[i] = true;
		}
		int index = 1; 
		for (int i = 2; i < isPrime.length; i++)
		{
			if (isPrime[i] == false)
			{
				continue;
			}
			if (index == number)
			{
				System.out.println(i);
				return;
			}
			index++;
			for (int j = i + i; j < isPrime.length; j += i)
			{
				isPrime[j] = false;
			}
		}
	}
}
