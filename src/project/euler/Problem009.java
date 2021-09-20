package project.euler;

import java.util.ArrayList;

public class Problem009 
{
	public static void main(String [] args)
	{
		ArrayList<Integer> list = new ArrayList<>();
		for (int a = 1; a < 1000; a++)
		{
			int pow = a * a;
			int diff = 1000 - a;
			if (pow % diff == 0)
			{
				list.add(a);
			}
		}
		
		for (int i = 0; i < list.size() - 1; i++)
		{
			for (int j = i + 1; j < list.size(); j++)
			{
				int a = list.get(i);
				int b = list.get(j);
				int c = 1000 - a - b;
				if (isTriplet(a, b, c))
				{
					System.out.println(a * b * c);
					return;
				}
			}
		}
	}
	
	static boolean isTriplet(int a, int b, int c)
	{
		return (a * a + b * b) == c * c;
	}
}
