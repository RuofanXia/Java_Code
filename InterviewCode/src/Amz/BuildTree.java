package Amz;

public class BuildTree {
	
	public static TreeNode buildTree(int[] data)
	{
		return helper(data, 0, data.length-1);
	}
	
	public static TreeNode helper(int[] data, int start, int end)
	{
		if (start > end) return null;
		
		int middle = start + (end - start) / 2;
		
		TreeNode root = new TreeNode(data[middle]);
		
		root.leftChild = helper(data, start, middle-1);
		root.rightChild = helper(data, middle+1, end);
		
		return root;
	}
	
	public static int mpsum1(TreeNode root)
	{
		if (root == null) return 0;
		
		return Math.min(mpsum1(root.leftChild) + root.val, mpsum1(root.rightChild) + root.val);
	}
	
	public static int mpsum2(TreeNode root)
	{
		if (root == null) return 0;
		
		if (root.leftChild != null && root.rightChild == null)	return mpsum2(root.leftChild) + root.val;
		
		if (root.rightChild != null && root.leftChild == null) return mpsum2(root.rightChild) + root.val;
		
		return Math.min(mpsum1(root.leftChild) + root.val, mpsum1(root.rightChild) + root.val);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {1,2,3,4,5,6,7,8};
		TreeNode root = buildTree(data);
		System.out.println(mpsum1(root));
		System.out.println(mpsum2(root));
	}

}
