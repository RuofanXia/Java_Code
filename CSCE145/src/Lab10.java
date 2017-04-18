import java.util.Scanner;


public class Lab10 {
	public static void main(String[] args){
		System.out.println("Welcome to the insertion sorter");
		System.out.println("Please enter the number of values you would like to sort");
		Scanner keyboard = new Scanner(System.in);
		int size = keyboard.nextInt();
		int[] unsorted = new int[size];
		int[] sorted = new int[size];
		for (int i=0; i<unsorted.length; i++)
		{
			System.out.println("Please enter the number at " + i);
			unsorted[i] = keyboard.nextInt();
		}
		
		//print out
		System.out.println("The unsorted array is");
		for (int i=0; i< sorted.length; i++)
		{
			System.out.print(unsorted[i]+ " ");
		}
		int temp;
		for (int j=1; j<unsorted.length; j++)
		{
			temp = unsorted[j];
			int i;
			for(i = j - 1; (i >= 0) && (unsorted[ i ] > temp); i--)
			{
				unsorted[i+1] = unsorted[i];
			}
			unsorted[i+1] = temp;
		}
		
		System.out.println();
		//print out
		System.out.println("The sorted array is");
		for (int i=0; i< sorted.length; i++)
		{
			System.out.print(unsorted[i]+ " ");
		}
	}
}
