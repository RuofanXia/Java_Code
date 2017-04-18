import java.util.Random;
import java.util.Scanner;


public class Lab1 {
	public static void main(String[] args)
	{
		System.out.println("Enter the size of the matrix");
		Scanner keyboard = new Scanner(System.in);
		
		int sz = keyboard.nextInt();
		
		Random rn = new Random();
		int[][] matrix = new int[sz][sz];
		for(int i=0; i<sz; i++)
		{
			for(int j=0; j<sz; j++)
			{
				matrix[i][j] = rn.nextInt(10);
			}
		}
		
		//print out 
		System.out.println("The matrix is");
		for(int i=0; i<sz; i++)
		{
			for(int j=0; j<sz; j++)
			{
				System.out.print(matrix[i][j]+ " ");
			}
			System.out.println();
		}
		int[][] doubleMatrix = new int[sz*2][sz*2];
		
		for(int i=0; i<2*sz; i++)
		{
			for(int j=0; j<2*sz; j++)
			{
				doubleMatrix[i][j] = matrix[i/2][j/2];
			}
		}
		
		//print out 
		System.out.println("The doubled matrix is");
		for(int i=0; i<2*sz; i++)
		{
			for(int j=0; j<2*sz; j++)
			{
				System.out.print(doubleMatrix[i][j]+ " ");
			}
			System.out.println();
		}
	}
}
