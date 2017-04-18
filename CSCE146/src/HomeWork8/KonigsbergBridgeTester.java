package HomeWork8;

public class KonigsbergBridgeTester {
	public static void main(String[] args)
	{
		KonigsbergBridge ksb = new KonigsbergBridge(5,8);
		ksb.addEdge(1, 1, 1);
		ksb.addEdge(1, 2, 1);
		ksb.addEdge(1, 4, 1);
		ksb.addEdge(2, 1, 1);
		ksb.addEdge(2, 2, 1);
		ksb.addEdge(2, 3, 1);
		ksb.addEdge(2, 5, 1);
		ksb.addEdge(2, 6, 1);
		ksb.addEdge(3, 5, 1);
		ksb.addEdge(3, 6, 1);
		ksb.addEdge(3, 7, 1);
		ksb.addEdge(4, 3, 1);
		ksb.addEdge(4, 4, 1);
		ksb.addEdge(4, 7, 1);
		
		System.out.println(ksb.findWay());
	}
}
