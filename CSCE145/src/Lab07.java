import java.util.Scanner;


public class Lab07 {
	public static void main(String[] args)
	{
		System.out.println("Welcome to Triangle Maker 9000!  Enter the size of the triangle.");
		Scanner keyboard = new Scanner(System.in);
		
		int num = keyboard.nextInt();
		
		//for the first half triangle
		for (int i=0; i<num; i++)
		{
			for (int j=0; j<i+1; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		//for the second half triangle
		for (int i=0; i<num; i++)
		{
			for (int j=0; j<num-i-1; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
