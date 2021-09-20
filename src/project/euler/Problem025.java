package project.euler;

import java.math.BigInteger;

import project.euler.util.Timer;

public class Problem025 
{
	public static void main(String [] args)
	{
		Timer.start();
		BigInteger first = BigInteger.valueOf(1);
		BigInteger second = BigInteger.valueOf(1);
		int index = 3;
		while (true)
		{
			BigInteger third = first.add(second);
			if (third.toString().length() >= 1000)
			{
				break;
			}
			
			first = second;
			second = third;
			index++;
		}
		System.out.println(index);
		Timer.elapse();
	}
}
