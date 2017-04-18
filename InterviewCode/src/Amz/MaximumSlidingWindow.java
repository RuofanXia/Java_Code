package Amz;

import java.util.*;

public class MaximumSlidingWindow {

	public static int[] solution(int[] data, int k)
	{
		int[] result = new int[data.length - k + 1];
		
		Deque<Integer> deque = new LinkedList<Integer>();
		
		for (int i=0; i<data.length; i++)
		{
			if (!deque.isEmpty() && deque.peekFirst() == i-k)
			{
				deque.pollFirst();
			}
			while(!deque.isEmpty() && data[deque.peekLast()] < data[i])
			{
				deque.pollLast();
			}
			deque.offer(i);
			
			if(i-k+1 >= 0)
			{
				result[i-k+1] = data[deque.peekFirst()];
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {3,4,1,2,3,4,6,7,9,10};
		int[] res = solution(data, 3);
		for (int i=0; i<res.length; i++)
		{
			System.out.println(res[i]);
		}
	}

}
