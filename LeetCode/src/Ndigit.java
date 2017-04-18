
import java.util.*;
public class Ndigit {
	
public String[] findRelativeRanks(int[] nums) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        
        for (int i : nums)
        {
            pq.offer(i);
        }
        
        int index = 0;
        
        String[] res= new String[nums.length];
        
        while(!pq.isEmpty())
        {
            pq.poll();
            if (index == 0)
            {
                res[index++] = "Gold Medal";  
            }
            else if (index == 1)
            {
                res[index++] = "Silver Medal";
            }
            else if (index == 2)
            {
                res[index++] = "Bronze Medal";
            }
            else
            {
                res[index++] = Integer.toString(index);
            }
        }
        
        return res;
    }

	public static int[] findDiagonalOrder(int[][] matrix) {
	    if (matrix == null) return new int[0];
	    int row = matrix.length;
	    int col = matrix[0].length;
	    
	    int[] res = new int[row*col];
	    
	    if (matrix.length == 0) return res;
	    
	    int i = 0, j = 0;
	    
	    int index = 0;
	    
	    boolean direction = true;
	    
	    res[index++] = matrix[0][0];
	    
	    while(index<res.length)
	    {
	        if (direction && i-1>=0 && j+1<col)
	        {
	            res[index++] = matrix[--i][++j];
	        }
	        else if (direction && i-1 <0 && j+1<col)
	        {
	            res[index++] = matrix[i][++j];
	            direction = !direction;
	        }
	        else if (direction && i-1>=0 && j+1 >= col)
	        {
	            res[index++] = matrix[--i][j];
	            direction = !direction;
	        }
	        else if (!direction && i+1<row && j-1>=0)
	        {
	            res[index++] = matrix[++i][--j];
	        }
	        else if (!direction && i+1>=row && j-1>=0)
	        {
	            res[index++] = matrix[i][--j];
	            direction = !direction;
	        }
	        else if (!direction && i+1<row && j-1<0)
	        {
	            res[index++] = matrix[++i][j];
	            direction = !direction;
	        }
	    }
	    return res;
	}
	
	public static int findNthDigit(int n) {
		int len = 1;
		long count = 9;
		int start = 1;

		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}

		start += (n - 1) / len;
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % len));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findNthDigit(12));
		int[][] data = {{1,2,3},{4,5,6},{7,8,9}};
		int[] res = findDiagonalOrder(data);
	}

}
