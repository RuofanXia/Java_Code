package homework4;


//BY: RYAN CORBETT
//TACO VALUE SORTER

import java.util.Scanner;
public class test 
{

	public static void main(String[] args) 
	{
		//declaration of variables
		String[] TacoName = new String[10];
		double[] TacoPrice = new double[10];
		int MinPrice;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Welcome to the Taco price sorter! Enter 10 Taco names and prices and I'll sort them!");
		
		//Retrieves input from user.
		for(int i = 0; i < 10; i++)
		{
			System.out.println("Enter in the name for taco "+(i + 1));
			TacoName[i] = keyboard.nextLine();
			
			System.out.println("Enter in the taco's price: ");
			
			TacoPrice[i] = keyboard.nextDouble();
			keyboard.nextLine();
		}
		
		//Determines the smallest price and sorts them.
		for(int i = 0;i<10;i++)
		{
			MinPrice = i;
			for(int j=i;j<10;j++)
			{
				if(TacoPrice[j]<TacoPrice[MinPrice])
				{
					MinPrice = j;
				}
			}
			//Puts prices in correct place with the name.
			if(MinPrice != i)
			{
				String name = TacoName[i];
				double price = TacoPrice[i];
				TacoPrice[i] = TacoPrice[MinPrice];
				TacoName[i] = TacoName[MinPrice];
				TacoPrice[MinPrice] = price;
				TacoName[MinPrice] = name;
			}
		}
		//Prints results to screen.
		System.out.println("The sorted tacos are: ");
		for(int i=0;i<10;i++)
		{
			System.out.println("Taco Prices " + TacoName[i] + " " + TacoPrice[i] );
		}
	}
}

