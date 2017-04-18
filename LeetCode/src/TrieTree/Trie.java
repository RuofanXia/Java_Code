package TrieTree;

import java.util.*;

public class Trie {
	private TrieNode root;
	
	public Trie()
	{
		root = new TrieNode();
	}
	
	//Insert a word into trie tree;
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
			
			if (i == word.length()-1)
				t.isLeaf = true;
		}
	}
	
	//search Word returns if the word is in the trie
	public boolean searchWord(String word)
	{
		TrieNode t = searchNode(word);
		
		if (t != null && t.isLeaf) return true;
		else return false;
	}
	
	//search Prefix return if there is any word in the trie
	// that starts with the given prefix.
	public boolean searchPrefix(String prefix)
	{
		TrieNode t = searchNode(prefix);
		if (t != null) return true;
		else return false;
	}
	
	public TrieNode searchNode(String str)
	{
		Map<Character, TrieNode> children = root.children;
		TrieNode t = null;
		
		for (int i=0; i<str.length(); i++)
		{
			char c = str.charAt(i);
			if (children.containsKey(c))
			{
				t = children.get(c);
				children = t.children;
			}
			else
			{
				return null;
			}
		}
		
		return t;
	}
}
