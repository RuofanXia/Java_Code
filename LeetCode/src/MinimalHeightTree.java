import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class MinimalHeightTree {
	private List<Integer> findMinHeightTree(int n, int[][] edges)
	{
		List<Integer> result = new ArrayList<Integer>();
		if(n == 1) 
		{
			result.add(0);
			return result;
		}
		
		int[] indegree = new int[n];
		HashMap<Integer, ArrayList<Integer>> hashmap = new HashMap<Integer, ArrayList<Integer>>();
		
		for(int i=0; i<edges.length; i++)
		{
			indegree[edges[i][0]]++;
			indegree[edges[i][1]]++;
			if(!hashmap.containsKey(edges[i][0]))
			{
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(edges[i][1]);
				hashmap.put(edges[i][0], list);
			}
			else
			{
				ArrayList<Integer> list = hashmap.get(edges[i][0]);
				list.add(edges[i][1]);
			}
			
			if(!hashmap.containsKey(edges[i][1]))
			{
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(edges[i][0]);
				hashmap.put(edges[i][1], list);
			}
			else
			{
				ArrayList<Integer> list = hashmap.get(edges[i][1]);
				list.add(edges[i][0]);
			}
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0; i<n; i++)
		{
			if(indegree[i] == 1) queue.offer(i);
		}
		
		while(queue.size() > 2)
		{
			int size = queue.size();
			for(int i=0; i<size; i++)
			{
				int leaf = queue.poll();
				ArrayList<Integer> list = hashmap.get(leaf);
				for(int e : list)
				{
					indegree[e]--;
					if(indegree[e] == 1) queue.offer(e);
				}
			}
		}
		
		while(!queue.isEmpty())
		{
			result.add(queue.poll());
		}
		
		return result;
	}
}
