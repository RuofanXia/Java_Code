package MyCode;

import java.util.*;

public class priorityQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for (int i=0; i<15; i++)
		{
			pq.offer(i);
		}
		System.out.println(pq.size());
	}

}
