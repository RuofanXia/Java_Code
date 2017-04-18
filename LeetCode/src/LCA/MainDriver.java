package LCA;

public class MainDriver {
	
	private static Pair findLCA(TreeNode root) {
	    if (root == null) {
	        return new Pair(null, 0);
	    }
	    int depth = 0;
	    Pair left = findLCA(root.left);
	    Pair right = findLCA(root.right);
	    depth = Math.max(left.depth, right.depth) + 1;
	    if (left.depth == right.depth) {
	        return new Pair(root, depth);
	    }
	    else if (left.depth > right.depth) {
	        return new Pair(left.node, depth);
	    }
	    else {
	        return new Pair(right.node, depth);
	    }
	}
	
	public static void main(String[] args)
	{
		TreeNode Four = new TreeNode(4);
		TreeNode Seven = new TreeNode(7);
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		
		Four.left = Seven;
		Seven.left = null;
		Seven.right = null;
		
		Four.right = one;
		one.left = two;
		one.right = three;
		two.left = null;
		two.right = null;
		three.left = five;
		three.right = six;
		five.left = null;
		five.right = null;
		six.left = null;
		six.right = null;
		
		Pair result = findLCA(Four);
		System.out.println(result.node.val);
	}
}
