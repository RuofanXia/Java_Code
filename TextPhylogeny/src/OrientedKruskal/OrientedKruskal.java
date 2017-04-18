package OrientedKruskal;

import java.util.Arrays;
import java.util.Comparator;

public class OrientedKruskal {
	class Edge
	{
		int val;
		int row, column;
		Edge(int val, int row, int column)
		{
			this.val = val;
			this.row = row;
			this.column = column;
		}
	}
	public int[] buildTree(int[][] dissimilarity)
	{
		int n = dissimilarity.length;
		int[] parent = new int[n];
		int[] root = new int[n];
		for (int i=0; i<parent.length; i++)
		{
			parent[i] = i;
			root[i] = i;
		}
		
		Edge[] edges = new Edge[n*n];
		int index = 0;
		for (int i=0; i<dissimilarity.length; i++)
		{
			for (int j=0; j<dissimilarity.length; j++)
			{
				Edge edge = new Edge(dissimilarity[i][j], i, j);
				edges[index++] = edge;
			}
		}
		
		//sort all edges
		Arrays.sort(edges, new Comparator<Edge>(){
			public int compare(Edge e1, Edge e2)
			{
				return e1.val - e2.val;
			}
		});
		
		index = 0;
		int edge_num = 0;
		while(true)
		{
			//get the current minimal edge
			Edge edge = edges[index];
			int row = edge.row;
			int column = edge.column;
			if(root[row] != root[column])
			{
				if (root[column] == column)
				{
					root[column] = root[row];
					parent[column] = row;
					edge_num++;
				}
				if (edge_num == n-1)
				{
					break;
				}
			}
			index++;
		}
		return parent;
	}
}
