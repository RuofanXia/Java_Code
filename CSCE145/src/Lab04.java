import java.util.Scanner;


public class Lab04 {
	public static void main(String[] args){
		System.out.println("Enter a date in the format month/day");
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine();
		int index = input.indexOf("/");
		String month_str = input.substring(0, index);
		String date_str = input.substring(index+1);
		int month = Integer.parseInt(month_str);
		int date = Integer.parseInt(date_str);

		
		if ((month == 1 || month == 3 || month == 5 || month == 7
				|| month == 8 || month == 10 || month == 12) && (date<=31 && date>=1) || (month == 4 || month == 6 || month == 9 || month ==11)
				&&(date<=30&&date>=1) || ((month == 2) && (date>=1&&date<=29)))
		{
			
			System.out.println(month+ "/"+date+" is a valid date!");
		}
		else
		{
			System.out.println(month+ "/"+date+" is NOT a valid date!");
		}
	}
}
