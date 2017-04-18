import java.util.*;

public class EqualTest {
	static class Node{
		int val;
		public Node(int x)
		{
			this.val = x;
		}
		
		public boolean equals(Object node)
		{
			Node other = (Node) node;
			if (this.val == other.val) return true;
			else return false;
		}
		
		@Override
		public int hashCode() {
		    return 3;
		}
	}
	
	public static void main(String[] args)
	{
		Map<Node, Integer> map = new HashMap<Node, Integer>();
		Node n = new Node(1);
		map.put(n, 2);
		Node node = new Node(1);
		System.out.println(map.containsKey(node));
	}
}
