package MyCode;

import java.util.ArrayList;
import java.util.Iterator;

public class Graph {
	
	private int V;
	
	private ArrayList<Integer> [] adjlist;
	
	public Graph(int Vertices)
	{
		V = Vertices;
		adjlist = new ArrayList [V];
		for(int i=0; i<V; i++)
		{
			adjlist[i] = new ArrayList<Integer>();
		}
	}
	
	public void addEdge(int v1, int v2)
	{
		adjlist[v1].add(v2);
	}
	
	public void DFSUtil(int v, boolean[] visited)
	{
		visited[v] = true;
		System.out.println(v + " ");
		
		Iterator<Integer> i = adjlist[v].listIterator();
		while(i.hasNext())
		{
			int n = i.next();
			if(!visited[n])
			{
				DFSUtil(n, visited);
			}
		}
	}
	
	public void DFS(int v)
	{
		boolean[] visited = new boolean[V];
		
		DFSUtil(v, visited);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(4);
		
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        g.DFS(1);
	}

}
