package project.euler;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Problem013 
{
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("problem013.txt"));
		BigInteger total = BigInteger.ZERO;
		while(sc.hasNextLine())
		{
			String line = sc.nextLine();
			BigInteger lineNumber = new BigInteger(line);
			total = total.add(lineNumber);
		}
		System.out.println(total.toString().substring(0, 10));
	}
}
