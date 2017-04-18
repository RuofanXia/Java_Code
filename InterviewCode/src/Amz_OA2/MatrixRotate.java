package Amz_OA2;

public class MatrixRotate {
	
	/*
	 *  example:
	 *  1 2 3
	 *  4 5 6
	 * 
	 */
	
	public static int[][] solution(int[][] matrix, int flag)
	{
		int row = matrix.length;
		int col = matrix[0].length;
		
		int[][] ret = new int[col][row];
		
		for (int i=0; i<row; i++)
		{
			for (int j=0; j<col; j++)
			{
				ret[j][i] = matrix[i][j];
			}
		}
		
		//rotate in clockwise
		if (flag == 1)
		{
			for (int i=0; i<col; i++)
			{
				for (int j=0; j<row/2; j++)
				{
					int temp = ret[i][j];
					ret[i][j] = ret[i][row-j-1];
					ret[i][row-j-1] = temp;
				}
			}
		}
		else
		{
			for (int i=0; i<row; i++)
			{
				for (int j=0; j<col/2; j++)
				{
					int temp = ret[j][i];
					ret[j][i] = ret[col-j-1][i];
					ret[col-j-1][i] = temp;
				}
			}
		}
		return ret;
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
