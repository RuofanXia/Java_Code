package Amz;

public class RotateMatrix {
	
	public static int[][] solution(int[][] matrix, int flag)
	{
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return matrix;
		int row = matrix.length, col = matrix[0].length;
		int[][] res = new int[col][row];
		
		for (int i=0; i<row; i++)
		{
			for (int j=0; j<col; j++)
			{
				res[j][i] = matrix[i][j];
			}
		}
		
		if (flag == 1)
		{
			for (int i=0; i<col; i++)
			{
				for (int j=0; j<row/2; j++)
				{
					//swap
					int temp = res[i][j];
					res[i][j] = res[i][row-j-1];
					res[i][row-j-1] = temp;
				}
			}
		}
		else
		{
			for (int i=0; i<row; i++)
			{
				for (int j=0; j<col/2; j++)
				{
					//swap
					int temp = res[j][i];
					res[j][i] = res[col-j-1][i];
					res[col-j-1][i] = temp;
				}
			}
		}
		
		return res;
		
	}
	
	public static void printMatrix(int[][] matrix)
	{
	int m = matrix.length, n = matrix[0].length;
	for(int i = 0; i < m; i++)
	{
	for(int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
	System.out.println("");
	}
	}
	public static void main(String[] args)
	{
	int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
	int[][] output1 = solution(input, 0);
	int[][] output2 = solution(input, 1);
	System.out.println("input");
	printMatrix(input);
	System.out.println("output1");
	printMatrix(output1);
	System.out.println("output2");
	printMatrix(output2);
	}

}
