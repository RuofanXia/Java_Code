import java.util.Scanner;


public class Lab02 {
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		int amount = keyboard.nextInt();
		System.out.println("Enter a whole number from 1 to 99.");
		System.out.println("The machine will determine a combination of coins.");
		int original_amount = amount;
		
		int quarter_value = amount - amount % 25;
		int quarter = quarter_value/25;
		
		amount = amount - quarter_value;
		
		int dime_value = amount - amount % 10;
		int dime = dime_value / 10;
		
		amount = amount - dime_value;
		
		int nickle_value = amount - amount % 5;
		int nickle = nickle_value / 5;
		
		amount = amount - nickle_value;
		
		int penny_value = amount;
		
		System.out.println( original_amount + " cents in coins:");
		System.out.println( quarter + "quarters");
		System.out.println( dime + "dime");
		System.out.println( nickle + "nickles");
		System.out.println( penny_value + "pennies");
	}
}
