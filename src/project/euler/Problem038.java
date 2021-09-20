package project.euler;

public class Problem038 
{
	public static void main(String [] args)
	{
		long max = 0;
		for (int number = 9000; number <= 9999; number++)
		{
			int next = number * 2;
			long total = append(number, next);
			if (isPanDigital(total) && total > max)
			{
				max = total;
			}
		}
		System.out.println(max);
	}
	
	static boolean isPanDigital(long number)
	{
		long count = 0;
		long digitFlags = 0;
		while (number > 0)
		{
			long digit = number % 10;
			long temp = digitFlags | (1 << digit);
			if (temp == digitFlags)
			{
				return false;
			}
			digitFlags = temp;
			number /= 10;
			count++;
		}
		return count == 9 && ((digitFlags & 1) == 0);
	}
	
	static long append(long a, long b)
	{
		long mask = (long) Math.pow(10, countDigits((int) b));
		return a * mask + b;
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
