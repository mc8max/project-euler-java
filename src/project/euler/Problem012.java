package project.euler;

import java.util.ArrayList;
import java.util.List;

public class Problem012 
{
	static List<Integer> primes = null;
	
	public static void main(String [] args)
	{
		primes = generatePrimes(500);
		int n = 1;
		while(true)
		{
			System.out.print(n);
			int [] factors1 = getFactors(n % 2 == 0 ? n / 2 : n);
			int [] factors2 = getFactors(n % 2 == 0 ? (n + 1) : (n + 1) / 2);
			int count = 1;
			for (int i = 0; i < primes.size(); i++)
			{
				int sum = factors1[i] + factors2[i];
				if (sum > 0)
				{
					count *= (sum + 1);
				}
			}
			System.out.println(" - " + count);
			if (count > 500)
			{
				System.out.println(n * (n + 1) / 2);
				return;
			}
			n++;
		}
	}
	
	static int[] getFactors(int number)
	{
		int[] factors = new int[primes.size()];
		for (int i = 0; i < factors.length; i++)
		{
			int prime = primes.get(i);
			while (number % prime == 0)
			{
				factors[i]++;
				number /= prime;
			}
			if (number <= 1)
			{
				break;
			}
		}
		return factors;
	}

	static List<Integer> generatePrimes(int count)
	{
		boolean[] isPrime = generatePrimeFlag(count * count);
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < isPrime.length; i++)
		{
			if (isPrime[i])
			{
				list.add(i);
			}
		}
		return list;
	}
	
	static boolean[] generatePrimeFlag(int count)
	{
		boolean[] isPrime = new boolean[count];
		 for (int i = 0; i < isPrime.length; i++)
		 {
			 isPrime[i] = true;
		 }
		 
		 isPrime[0] = false;
		 isPrime[1] = false;
		 
		 for (int i = 2; i < isPrime.length; i++)
		 {
			 if (isPrime[i] == false)
			 {
				 continue;
			 }
			 
			 for (int j = i + i; j < isPrime.length; j += i)
			 {
				 isPrime[j] = false;
			 }
		 }
		 return isPrime;
	}
}
