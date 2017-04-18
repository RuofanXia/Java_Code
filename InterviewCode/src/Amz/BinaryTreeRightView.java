package Amz;

import java.util.*;

public class BinaryTreeRightView {
	public List<Integer> solution(TreeNode root)
	{
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) return result;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while(!queue.isEmpty())
		{
			int size = queue.size();
			for (int i=0; i<size; i++)
			{
				TreeNode node = queue.poll();
				if (i == size-1) result.add(node.val);
				if (node.leftChild != null)
				{
					queue.offer(node.leftChild);
				}
				if (node.rightChild != null)
				{
					queue.offer(node.rightChild);
				}
			}
		}
		
		return result;
	}
}
