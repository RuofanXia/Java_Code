package Amz;

import java.util.*;

public class Search2D {
	
	public boolean Search2d(int[][] matrix, int target)
	{
		//first find the row index
		int top = 0, bottom = matrix.length-1;
		int row_index = -1;
		while(top<=bottom)
		{
			int middle = top + (bottom-top)/2;
			int[] current_row = matrix[middle];
			if (target>=current_row[0] && target<=current_row[current_row.length-1])
			{
				row_index = middle;
				break;
			}
			else if (target<current_row[0])
			{
				bottom = middle-1;
			}
			else 
			{
				top = middle + 1;
			}
		}
		
		if (row_index == - 1) return false;
		
		//find the column position
		int left = 0, right = matrix[0].length-1;
		int col_index = -1;
		while(left <= right)
		{
			int middle = left + (right-left)/2;
			if (matrix[row_index][middle] == target) return true;
			else if (matrix[row_index][middle] > target)
			{
				right = middle - 1;
			}
			else
			{
				left = middle + 1;
			}
		}
		
		if (col_index == -1) return false;
		return true;
	}
}
