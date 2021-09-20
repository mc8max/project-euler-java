package project.euler;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Problem022 
{
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("problem022.txt"));
		String text = sc.nextLine().trim();
		String [] names = text.split(",");
		Arrays.sort(names);
		BigInteger sum = new BigInteger("0");
		for (int i = 0; i < names.length; i++)
		{
			String name = names[i];
			int nameValue = 0;
			for (char ch : name.toCharArray())
			{
				if (ch == '"')
				{
					continue;
				}
				nameValue += ch - 'A' + 1;
			}
			nameValue *= (i + 1);
			if (i == 937)
			{
				System.out.println(name);
				System.out.println(nameValue);
			}
			sum = sum.add(BigInteger.valueOf(nameValue));
		}
		System.out.println(sum);
	}
}
