package Heuristic;

public class Heuristic {
	public int[] buildTree(int[][] similarity, int root)
	{
		int n = similarity.length;
		int[] tree = new int[n];
		int[] dist = new int[n];
		int[] parent = new int[n];
		
		for (int i=0; i<n; i++)
		{
			tree[i] = -1;
			dist[i] = similarity[root][i];
			parent[i] = root;
		}
		
		tree[root] = root;
		int cost = 0;
		int edge_num = 0;
		while(edge_num<n-1)
		{
			int new_parent = -1;
			int min = Integer.MAX_VALUE;
			for (int i=0; i<n; i++)
			{
				if (dist[i] < min && tree[i] == -1)
				{
					new_parent = i;
					min = dist[i];
				}
			}
			
			tree[new_parent] = parent[new_parent];
			edge_num++;
			cost += min;
			
			for (int i=0; i<n; i++)
			{
				if (tree[i] == -1 && similarity[new_parent][i]<dist[i])
				{
					dist[i] = similarity[new_parent][i];
					parent[i] = new_parent;
				}
			}
		}
		
		int[] ret = new int[n+1];
		
		for (int i=0; i<n; i++)
		{
			ret[i] = tree[i];
		}
		ret[n] = cost;
		
		return ret;
	}
}
