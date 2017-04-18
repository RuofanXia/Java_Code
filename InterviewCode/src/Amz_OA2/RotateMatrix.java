package Amz_OA2;

public class RotateMatrix {
	
	public static int[][] solution(int[][] data, int flag)
	{
		int m = data.length, n = data[0].length;
		int[][] transpose = new int[n][m];
		
		for (int i=0; i<m; i++)
		{
			for (int j=0; j<n; j++)
			{
				transpose[j][i] = data[i][j];
			}
		}
		
		if (flag == 1)
		{
			for (int i=0; i<n; i++)
			{
				for (int j=0; j<m/2; j++)
				{
					int temp = transpose[i][j];
					transpose[i][j] = transpose[i][m-j-1];
					transpose[i][m-j-1] =temp;
				}
			}
		}
		else
		{
			for (int i=0; i<m; i++)
			{
				for (int j=0; j<n/2; j++)
				{
					int temp = transpose[j][i];
					transpose[j][i] = transpose[n-j-1][i];
					transpose[n-j-1][i] = temp;
				}
			}
		}
		
		return transpose;
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
