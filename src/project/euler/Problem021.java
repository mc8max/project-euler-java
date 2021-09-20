package project.euler;

import java.util.ArrayList;
import java.util.List;

public class Problem021 
{
	static List<Integer> primes;
	
	public static void main(String [] args)
	{
		primes = generatePrimes(100);
		int[] sumDivisors = getSumProperDivisor(10000);
		long sum = 0;
		for (int i = 0; i < sumDivisors.length; i++)
		{
			int j = sumDivisors[i];
			if (j < 10000 && j != i && sumDivisors[j] == i)
			{
				System.out.println(i + " - " + j);
				sum += i + j;
			}
		}
		System.out.println(sum / 2);
//		System.out.println(sumDivisors[220]);
//		System.out.println(sumDivisors[284]);
	}
	
	static int[] getSumProperDivisor(int count)
	{
		int[] ar = new int[count];
		for (int i = 2; i < count; i++)
		{
			int[] factors = getFactors(i);
			ar[i] = 1;
			for (int j = 0; j < factors.length; j++)
			{
				if (factors[j] == 0)
				{
					continue;
				}
				int power = 0;
				int prime = primes.get(j);
				for (int z = 0; z <= factors[j]; z++)
				{
					power += (int) Math.pow(prime, z);
				}
				ar[i] *= power;
			}
			ar[i] -= i;
		}
		return ar;
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
