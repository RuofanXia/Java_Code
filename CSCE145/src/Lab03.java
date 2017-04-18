import java.util.Scanner;


public class Lab03 {
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		/*
		int number = keyboard.nextInt();
		int remaining = 0;
		int thousand_digit = number/1000;
		remaining = number%1000;
		int hundred_digit = remaining / 100;
		remaining = remaining%100;
		int tens_digit = remaining /10;
		remaining = remaining%10;
		int unit_digit = remaining;
		
		System.out.println(number);
		System.out.println(hundred_digit+"  "+tens_digit);
		System.out.println(tens_digit+"  "+hundred_digit);
		System.out.println(Integer.toString(unit_digit)  +tens_digit+ hundred_digit + thousand_digit);
		*/
		String number = keyboard.nextLine();
		char thousand_digit = number.charAt(0);
		char hundred_digit = number.charAt(1);
		char tens_digit = number.charAt(2);
		char unit_digit = number.charAt(3);
		
		System.out.println(number);
		System.out.println(hundred_digit+"  "+tens_digit);
		System.out.println(tens_digit+"  "+hundred_digit);
		System.out.println(""+unit_digit  +tens_digit+ hundred_digit + thousand_digit);
		
	}
}
