
import java.util.*;

public class TrieTree {
	TrieNode root;
	
	public TrieTree()
	{
		this.root = new TrieNode();
	}
	
	public void insert(String word)
	{
		Map<Character, TrieNode> children = root.children;
		
		for (int i=0; i<word.length(); i++)
		{
			char c = word.charAt(i);
			TrieNode t;
			if (children.containsKey(c))
			{
				
				t = children.get(c);
			}
			else
			{
				t = new TrieNode(c);
				children.put(c, t);
			}
			children = t.children;
			
			if( i == word.length()-1)
			{
				t.isLeaf = true;
			}
		}
	}
	
	public boolean searchWord(String word)
	{
		TrieNode t = search(word);
		if (t != null && t.isLeaf) return true;
		
		return false;
	}
	
	public boolean searchPrefix(String prefix)
	{
		if (search(prefix) != null)
			return true;
		return false;
	}
	
	public TrieNode search(String word)
	{
		Map<Character, TrieNode> children = root.children;
		
		TrieNode t = null;
		
		for (int i=0; i<word.length(); i++)
		{
			char c = word.charAt(i);
			if (children.containsKey(c))
			{
				t = children.get(c);
				children = t.children;
			}
			else
				return null;
		}
		
		return t;
	}
}
