import java.util.Scanner;


public class Lab08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the above average temperature tester program.");
		Scanner keyboard = new Scanner(System.in);
		int[] temp = new int[10];
		for (int i=0; i<10; i++)
		{
			int d = i+1;
			System.out.println("Please enter the temperature for day " + d);
			temp[i] = keyboard.nextInt();
		}
		//calculate the average
		int total = 0;
		double average = 0;
		for (int i=0; i<10; i++)
		{
			total += temp[i]; 
		}
		average = total/10;
		System.out.println("The average temperature was "+ average);
		
		System.out.println("The days that were above average were");
		for (int i=0; i<10; i++)
		{
			int d = i+1;
			if (temp[i] > average)
			{
				System.out.println("Day "+ d + " with " + temp[i]);
			}
		}
	}

}
