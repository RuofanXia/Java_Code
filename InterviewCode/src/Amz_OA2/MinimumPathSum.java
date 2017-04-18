package Amz_OA2;

public class MinimumPathSum {
	
	public static int solution(TreeNode root)
	{
		if (root == null) return 0;
		
		return root.val + Math.min(solution(root.leftChild), solution(root.rightChild));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int solution2(TreeNode root)
	{
		if (root == null) return 0;
		
		if (root.leftChild != null && root.rightChild == null) return root.val + solution2(root.leftChild);
		
		if (root.leftChild == null && root.rightChild != null) return root.val + solution2(root.rightChild);
		
		return root.val + Math.min(root.leftChild.val, root.rightChild.val);
	}

}