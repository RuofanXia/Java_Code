package Lab10;

public class GraphTester {
	public static void main(String[] args)
	{
		Graph g = new Graph(25);
		System.out.println("Adding verticies");
		g.addVertex("v1");
		g.addVertex("v2");
		g.addVertex("v3");
		g.addVertex("v4");
		g.addVertex("v5");
		g.addVertex("v6");
		g.addVertex("v7");
		g.addVertex("v8");
		System.out.println("Adding edges");
		g.addEdge("v1", "v2", 10);
		g.addEdge("v1", "v4", 20);
		g.addEdge("v1", "v6", 50);
		
		g.addEdge("v2", "v4", 21);
		g.addEdge("v2", "v5", 25);
		
		g.addEdge("v3", "v8", 50);
		
		g.addEdge("v4", "v7", 7);
		g.addEdge("v4", "v8", 40);
		
		g.addEdge("v5", "v3", 23);
		
		g.addEdge("v6", "v4", 31);
		
		g.addEdge("v7", "v6", 10);
		
		System.out.println("Printing DFS");
		g.printDFS();
		System.out.println("Printing BFS");
		g.printBFS();
		System.out.println("Printing Lazy DFS");
		g.printLazyDFS();
	}
}