import java.util.Scanner;


public class SimplifyPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.next();
		
		String[] splitted = input.split("/");
		
		for(int i=0; i<splitted.length; i++)
		{
			System.out.println(splitted[i]);
		}
		
	}
	
}
