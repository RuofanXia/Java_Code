import java.util.*;

public class TrieNode {
	char c;
	boolean isLeaf;
	Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	
	public TrieNode(){}
	
	public TrieNode(char c)
	{
		this.c = c;
	}
}
