package project.euler;

import java.util.ArrayList;
import java.util.List;

public class Primes 
{
	static List<Integer> primes; 
	
	public static void initialize(int count)
	{
		primes = generateList(count);
	}
	
	public static boolean isAbundant(int number)
	{
		return number < getSumOfProperDivisor(number);
	}
	
	public static boolean isPerfect(int number)
	{
		return number == getSumOfProperDivisor(number);
	}
	
	public static boolean isDeficient(int number)
	{
		return number > getSumOfProperDivisor(number);
	}
	
	public static int getSumOfProperDivisor(int number)
	{
		int[] factors = getFactors(number);
		int sum = 1;
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
			sum *= power;
		}
		return sum - number;
	}
	
    public static int[] getFactors(int number)
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
	
	public static List<Integer> generateList(int count)
	{
		boolean[] isPrime = generateFlags(count);
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
	
	public static boolean[] generateFlags(int count)
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
