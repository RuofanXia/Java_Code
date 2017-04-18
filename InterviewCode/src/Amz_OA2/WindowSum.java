package Amz_OA2;

import java.util.*;

public class WindowSum {
	
	public static List<Integer> Solution(List<Integer> data, int k)
	{
		List<Integer> result = new ArrayList<Integer>();
		if (k >= data.size())
		{
			int sum = 0;
			for (int i=0; i<data.size(); i++)
			{
				sum += data.get(i);
			}
			result.add(sum);
			return result;
		}
		
		int temp = 0;
		for (int i=0; i<k; i++)
		{
			temp += data.get(i);
		}
		
		result.add(temp);
		
		for(int i=k; i<data.size(); i++)
		{
			int prev = result.get(i-k);
			int curr = prev + data.get(i) - data.get(i-k);
			result.add(curr);
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		List<Integer> input = new ArrayList<>();
        input.addAll(Arrays.asList(2,3,4,2,5,7,8,9,6));
//      List<Integer> input1 = new ArrayList<>();
//      input1.addAll(Arrays.asList(1,2));
        List<Integer> output = Solution(input, 4);
        for(int i: output) System.out.print(i + " ");
	}
}
