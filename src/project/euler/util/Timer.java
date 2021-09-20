package project.euler.util;

public class Timer 
{
	static long start;
	
	public static void start()
	{
		start = System.nanoTime();
	}
	
	public static void elapse()
	{
		long elapse = System.nanoTime() - start;
		double elapsedTimeInSecond = (double) elapse / 1_000_000_000;
        System.out.println(elapsedTimeInSecond + " seconds");
	}
}
