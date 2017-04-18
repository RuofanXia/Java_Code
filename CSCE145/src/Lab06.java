import java.util.Random;
import java.util.Scanner;


public class Lab06 {
	public static void main(String[] args){
		System.out.println("Enter the number of times a 6 sided die should be rolled");
		Scanner keyboard = new Scanner(System.in);
		
		int num = keyboard.nextInt();
		Random rd = new Random();
		int count_one = 0;
		int count_two = 0;
		int count_three = 0;
		int count_four = 0;
		int count_five = 0;
		int count_six = 0;
		if (num < 0)
		{
			System.out.println("Input negative number is not allowed!");
		}
		while(num>0)
		{
			int random_num = rd.nextInt(6) + 1;
			System.out.println(random_num + " was rolled");
			if (random_num == 1)
			{
				count_one++;
			}
			else if (random_num == 2)
			{
				count_two++;
			}
			else if (random_num == 3)
			{
				count_three++;
			}
			else if (random_num == 4)
			{
				count_four++;
			}
			else if (random_num == 5)
			{
				count_five++;
			}
			else if (random_num == 6)
			{
				count_six++;
			}
			num--;
		}
		System.out.println("One: "+ count_one);
		System.out.println("two: "+ count_two);
		System.out.println("three: "+ count_three);
		System.out.println("four: "+ count_four);
		System.out.println("five: "+ count_five);
		System.out.println("Six: "+ count_six);
	}
}
