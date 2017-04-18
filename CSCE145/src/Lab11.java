import java.util.Scanner;


public class Lab11 {

	public static void main(String[] args)
	{
		System.out.println("Welcome to name sorter program");
		Scanner keyboard = new Scanner(System.in);
		String[] nameList = new String[10];
		for (int i=0; i<nameList.length; i++)
		{
			System.out.println("Enter person " + (i+1));
			nameList[i] = keyboard.nextLine();
		}
		
		/******key part******/
		boolean flag = true;
		while(flag)
		{
			flag = false;
			for (int i=0; i<nameList.length-1; i++)
			{
				int first_index = nameList[i].indexOf(" ");
				int secon_index = nameList[i+1].indexOf(" ");
				if (nameList[i].charAt(first_index+1) > nameList[i+1].charAt(secon_index+1))
				{
					String temp = nameList[i];
					nameList[i] = nameList[i+1];
					nameList[i+1] = temp;
					flag = true;
				}
			}
		}
		
		/**********/
		
		System.out.println("Sorted Names Are!");
		for (int i=0; i<nameList.length; i++)
		{
			System.out.println(nameList[i]);
		}
		System.out.println("Good bye!");
	}

}
