package Lab10;

import java.util.*;
public class Graph {
	private class Vertex
	{
		String name;
		ArrayList<Edge> neighbors;
		public Vertex(String aName)
		{
			this.name = aName;
			this.neighbors = new ArrayList<Edge>();
		}
	}
	private class Edge
	{
		Vertex nextVert;
		double weight;
		public Edge(Vertex aV1, double aWeight)
		{
			nextVert = aV1;
			weight = aWeight;
		}
	}
	
	private Vertex origin;
	private ArrayList<Vertex> verticies;
	private ArrayList<Vertex> markedVerts;
	private ArrayList<Vertex> visitedVerts;
	private double maxLength; 
	public Graph(double aLength)
	{
		origin = null;
		verticies = new ArrayList<Vertex>();
		markedVerts = new ArrayList<Vertex>();
		visitedVerts = new ArrayList<Vertex>();
		maxLength = aLength;
	}
	
	public boolean vertexIsContained(Vertex v)
	{
		for(int i=0; i<verticies.size(); i++)
		{
			if (verticies.get(i).name.equalsIgnoreCase(v.name))
			{
				return true;
			}
		}
		return false;
	}
	
	public void addVertex(String name)
	{
		Vertex v = new Vertex(name);
		if (!vertexIsContained(v))
		{
			verticies.add(v);
		}
		if (origin == null)
		{
			origin = v;
		}
	}
	
	public void addEdge(String str1, String str2, int weight)
	{
		Vertex v1 = getVertex(str1);
		Vertex v2 = getVertex(str2);
		if (v1 == null || v2 == null)
		{
			System.out.println("Both vertices are not in the graph, can't add edge");
			return;
		}
		Edge e = new Edge(v2, weight);
		v1.neighbors.add(e);
	}
	
	public Vertex getVertex(String name)
	{
		Vertex v = null;
		for(int i=0; i<verticies.size(); i++)
		{
			if (verticies.get(i).name.equalsIgnoreCase(name))
			{
				v = verticies.get(i);
			}
		}
		return v;
	}
	
	/*DFS*/
	
	public void printDFS()
	{
		markedVerts.clear();
		printDFS(origin);
	}
	
	public void printDFS(Vertex v)
	{
		if (markedVerts.contains(v))
			return;
		System.out.println(v.name);
		markedVerts.add(v);
		for (Edge e:v.neighbors)
		{
			printDFS(e.nextVert);
		}
	}
	
	/*BFS*/
	
	public void printBFS()
	{
		markedVerts.clear();
		visitedVerts.clear();
		System.out.println(origin.name);
		printBFS(origin);
	}
	
	public void printBFS(Vertex v)
	{
		if(markedVerts.contains(v))
			return;
		markedVerts.add(v);
		for (Edge e:v.neighbors)
		{
			if (markedVerts.contains(e.nextVert) || visitedVerts.contains(e.nextVert))
			{
				continue;
			}
			System.out.println(e.nextVert.name);
			visitedVerts.add(e.nextVert);
		}
		for (Edge e:v.neighbors)
		{
			printBFS(e.nextVert);
		}
	}
	
	public void printLazyDFS()
	{
		markedVerts.clear();
		printLazyDFS(origin);
	}
	
	public void printLazyDFS(Vertex v)
	{
		if (markedVerts.contains(v))
			return;
		System.out.println(v.name);
		markedVerts.add(v);
		for (Edge e:v.neighbors)
		{
			if (e.weight < maxLength)
			{
				printLazyDFS(e.nextVert);
			}
		}
	}
}