package Amz;

public class minPathSum {

	public static int solution(TreeNode root)
	{
		if (root == null) return 0;
		
		return Math.min(solution(root.leftChild) + root.val, solution(root.rightChild) + root.val);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
