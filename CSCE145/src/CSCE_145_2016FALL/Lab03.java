package CSCE_145_2016FALL;

import java.util.Scanner;

public class Lab03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a whole number from 1 to 99.\nThe machine will determine a combination of coins.");
		Scanner keyboard = new Scanner(System.in);
		int cents = keyboard.nextInt();
		
		int quarter = cents / 25;
		int remaining = cents % 25;
		
		int dime = remaining / 10;
		remaining = remaining % 10;
		
		int nickle = remaining / 5;
		remaining = remaining % 5;
		
		int penney = remaining;
		
		System.out.println( cents + " cents in coins: \n"
				+ quarter +" quarters\n"
				+ dime +" dimes\n"
				+ nickle + " nickles\n"
				+ penney + " pennies");
	}

}
