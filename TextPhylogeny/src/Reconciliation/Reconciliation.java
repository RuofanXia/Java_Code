package Reconciliation;

import java.util.Arrays;
import java.util.Comparator;

public class Reconciliation {
	class Edge
	{
		int account, child, parent;
		Edge(int account, int child, int parent)
		{
			this.account = account;
			this.child = child;
			this.parent = parent;
		}
	}
	public int[] buildTree(int[][] tree_set)
	{
		int n = tree_set[0].length;
		//define parent and child matrix
		int[][] pc_matrix = new int[n][n];
		
		for (int i=0; i<tree_set.length; i++)
		{
			for (int j=0; j<tree_set[0].length; j++)
			{
				pc_matrix[j][tree_set[i][j]]++;
			}
		}
		
		int[] tree = new int[n];
		int[] root = new int[n];
		for (int i=0; i<tree.length; i++)
		{
			tree[i] = i;
			root[i] = i;
		}
		
		int index = 0;
		Edge[] edges = new Edge[n*n];
		for (int i=0; i<pc_matrix.length; i++)
		{
			for (int j=0; j<pc_matrix.length; j++)
			{
				Edge edge = new Edge(pc_matrix[i][j], i, j);
				edges[index++] = edge;
			}
		}
		
		Arrays.sort(edges, new Comparator<Edge>(){
			public int compare(Edge e1, Edge e2)
			{
				return e2.account - e1.account;
			}
		});
		
		int r = -1;
		int edge_num = 0;
		index = 0;
		while(true)
		{
			Edge edge = edges[index];
			if (r == -1 && edge.child == edge.parent)
			{
				r = edge.child;
			}
			
			if (edge.child != r && root[edge.child] != root[edge.parent])
			{
				if (root[edge.child] == edge.child)
				{
					tree[edge.child] = edge.parent;
					root[edge.child] = root[edge.parent];
					edge_num++;
				}
				if (edge_num == n-1)
					break;
			}
			index++;
		}
		
		return tree;
	}
}
