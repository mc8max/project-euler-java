package project.euler;

public class Problem006 
{

	public static void main(String [] args)
	{
		System.out.println(squareDiff(100));
	}
	
	static int squareDiff(int count)
	{
		int sum = 0;
		for (int i = 1; i < count; i++)
		{
			for (int j = i + 1; j <= count; j++)
			{
				sum += i * j * 2;
			}
		}
		return sum;
	}
}
