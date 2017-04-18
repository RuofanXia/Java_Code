package FacebookInterview;

import java.util.*;

public class MainDriver {
	/*Implement strStr()*/
	public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack == null || haystack.length() == 0 && needle.length() != 0) return -1;
        
        for (int i=0; i<=haystack.length()-needle.length(); i++)
        {
        	String sub = haystack.substring(i, i+needle.length());
        	if (sub.equals(needle)) return i;
        }
        return -1;
    }
	
	/*Minimum Depth of Binary Tree*/
	//recursive
	static int minDepth = Integer.MAX_VALUE;
	public static void MinimumDepthBT(TreeNode root, int depth)
	{
		if (root == null) return;
		
		depth++;
		
		if (root.left == null && root.right == null) 
		{
			minDepth = Math.min(minDepth, depth);
		}
		
		if (root.left != null)
		{
			MinimumDepthBT(root.left, depth);
		}
		
		if (root.right != null)
		{
			MinimumDepthBT(root.right, depth);
		}
		
	}
	//iterative
	public static int MinimumDepthBTBfs(TreeNode root)
	{
		if(root == null) return 0;
		
		int depth = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty())
		{
			depth++;
			int size = queue.size();
			for (int i=0; i<size; i++)
			{
				TreeNode node = queue.poll();
				
				if (node.left == null && node.right == null)
				{
					return depth;
				}
				if (node.left != null)
				{
					queue.offer(node.left);
				}
				if (node.right != null)
				{
					queue.offer(node.right);
				}
			}
		}
		return -1;
	}
	
	
}
