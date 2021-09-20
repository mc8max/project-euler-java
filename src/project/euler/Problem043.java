package project.euler;

import java.util.LinkedList;
import java.util.List;

import project.euler.util.Timer;

public class Problem043 
{
	public static void main(String [] args)
	{
		Timer.start();
		List<Integer> list2 = searchSubStrings(2);
		List<Integer> list3 = searchSubStrings(3);
		List<Integer> list5 = searchSubStrings(5);
		List<Integer> list7 = searchSubStrings(7);
		List<Integer> list11 = searchSubStrings(11);
		List<Integer> list13 = searchSubStrings(13);
		List<Integer> list17 = searchSubStrings(17);
		Timer.elapse();
	}
	
	static List<Integer> searchSubStrings(int divisor)
	{
		List<Integer> list = new LinkedList<>();
		int starting = 10;
		while (starting % divisor != 0)
		{
			starting++;
		}
		
		while (starting <= 999)
		{
			if (hasDifferentDigits(starting, 3))
			{
				list.add(starting);
			}
			starting += divisor;
		}
		return list;
	}
	
	static boolean hasDifferentDigits(int number, final int length)
	{
		int digitCount = 0;
		int digitFlags = 0;
		while (number > 0)
		{
			int temp = 1 << (number % 10);
			if ((digitFlags | temp) == digitFlags)
			{
				return false;
			}
			digitFlags = temp;
			digitCount++;
			number /= 10;
		}
		return digitCount == length;
	}
}