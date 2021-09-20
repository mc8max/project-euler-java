package project.euler;

public class Problem010 
{
	public static void main(String [] args)
	{
		 boolean[] isPrime = new boolean[2000000];
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
		 
		 long sum = 0;
		 for (int i = 0; i < isPrime.length; i++)
		 {
			 if (isPrime[i])
			 {
				 sum += i;
			 }
		 }
		 System.out.println(sum);
	}
}
