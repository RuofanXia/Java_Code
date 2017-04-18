import java.util.Scanner;


public class Lab09 {
	public static void main(String []args)
	{
		System.out.println("Welcome to the matrix adder program");
		Scanner keyboard = new Scanner(System.in);
		int[] first_matrix_dimension = new int[2];
		int[] second_matrix_dimension = new int[2];
		System.out.println("Please enter the length of the first matrix");
		first_matrix_dimension[0] = keyboard.nextInt();
		System.out.println("Please enter the height of the first matrix");
		first_matrix_dimension[1] = keyboard.nextInt();
		System.out.println("Please enter the length of the second matrix");
		second_matrix_dimension[0] = keyboard.nextInt();
		System.out.println("Please enter the height of the second matrix");
		second_matrix_dimension[1] = keyboard.nextInt();
		
		if ((first_matrix_dimension[0] != second_matrix_dimension[0])||(first_matrix_dimension[1] != second_matrix_dimension[1]))
		{
			System.out.println("Cannot add these!  Dimension mismatch");
			System.exit(0);
		}
		
		int[][] first_matrix = new int[first_matrix_dimension[1]][first_matrix_dimension[0]];
		int[][] second_matrix = new int[second_matrix_dimension[1]][second_matrix_dimension[0]];
		
		
		for(int i=0; i<first_matrix.length; i++)
		{
			for (int j=0; j<first_matrix[i].length; j++)
			{
				System.out.println("Please enter a value for matrix 1 space " + (i+1) +" , " + (j+1));
				first_matrix[i][j] = keyboard.nextInt();
				
			}
		}
		
			
		for(int i=0; i<second_matrix.length; i++)
		{
			for (int j=0; j<second_matrix[i].length; j++)
			{
				System.out.println("Please enter a value for matrix 2 space " + (i+1) +" , " + (j+1));
				second_matrix[i][j] = keyboard.nextInt();
				
			}
		}
		
		int[][] result = new int[first_matrix_dimension[1]][first_matrix_dimension[0]];
		for(int i=0; i<result.length; i++)
		{
			for (int j=0; j<result[i].length; j++)
			{
				System.out.println("Please enter a value for matrix 1 space " + (i+1) +" , " + (j+1));
				result[i][j] = first_matrix[i][j] + second_matrix[i][j];
				
			}
		}
		
		//print out result
		for(int i=0; i<first_matrix.length; i++)
		{
			for (int j=0; j<first_matrix[i].length; j++)
			{
				System.out.print(first_matrix[i][j] + " ");
				
			}
			System.out.println();
		}
			
		System.out.println("+");
		
		for(int i=0; i<second_matrix.length; i++)
		{
			for (int j=0; j<second_matrix[i].length; j++)
			{
				System.out.print(second_matrix[i][j] + " ");
				
			}
			System.out.println();
		}
		
		System.out.println("=");
		
		for(int i=0; i<result.length; i++)
		{
			for (int j=0; j<result[i].length; j++)
			{
				System.out.print(result[i][j] + " ");
				
			}
			System.out.println();
		}
		System.out.println("DONE!");
	}
}
