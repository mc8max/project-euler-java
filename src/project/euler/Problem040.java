package project.euler;

import project.euler.util.Timer;

public class Problem040 
{
	public static void main(String [] args)
	{
		Timer.start();
		int currentRank = 10;
		int currentDigits = 0;
		
		int nextNumber = 1;
		int numberDigits = 1;
		int numberRank = 10;
		
		long result = 1;
		
		while (currentRank <= 1000000)
		{
			if (currentDigits + numberDigits >= currentRank)
			{
				int index = currentDigits + numberDigits - currentRank;
				int copy = nextNumber;
				while (index > 0)
				{
					copy /= 10;
					index--;
				}
				
				System.out.print(currentRank + " - ");
				System.out.println(copy % 10);
				result *= copy % 10;
				currentRank *= 10;
				
			}
			
			currentDigits += numberDigits;
			
			nextNumber++;
			if (nextNumber == numberRank)
			{
				numberDigits++;
				numberRank *= 10;
			}
		}
		
		System.out.println(result);
		Timer.elapse();
	}
	
	static int countDigits(int number)
	{
		int count = 0;
		while (number > 0)
		{
			count++;
			number /= 10;
		}
		return count;
	}
}
