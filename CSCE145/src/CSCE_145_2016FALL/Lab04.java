package CSCE_145_2016FALL;

import java.util.Scanner;

public class Lab04 {
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		int val = keyboard.nextInt();
		int cnt = Integer.toString(val).length();
		int[] digits = new int[cnt];
		int index = cnt;
		while (index > 0)
		{
			digits [--index] = val % 10;
			val /= 10;
		}
		
		int[][] table = new int[cnt][cnt];
		
		for (int i=0; i<cnt; i++)
		{
			for (int j=0; j<cnt; j++)
			{
				if (i == 0)
				{
					table[i][j] = digits[j];
				}
				else if (i == cnt - 1)
				{
					table[i][j] = digits[cnt-j-1];
				}
				else
				{
					if (j == 0)
					{
						table[i][j] = digits[i];
					}
					else if(j == cnt - 1)
					{
						table[i][j] = digits[j-i];
					}
					else
					{
						table[i][j] = 'a';
					}
				}
			}
		}
		
		for (int i=0; i<cnt; i++)
		{
			for (int j=0; j<cnt; j++)
			{
				if (table[i][j] != 'a')
					System.out.print(table[i][j]);
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		
		/*
		String val = keyboard.nextLine();
		char[] digits = new char[4];
		digits[0] = val.charAt(0);
		digits[1] = val.charAt(1);
		digits[2] = val.charAt(2);
		digits[3] = val.charAt(3);
		
		System.out.println("" + digits[0] + digits[1] + digits[2] + digits[3]);
		System.out.println("" + digits[1] + " " +  " " + digits[2]);
		System.out.println("" + digits[2] + " " +  " " + digits[1]);
		System.out.println("" + digits[3] + digits[2] + digits[1] + digits[0]);
		*/
		
	}
}
