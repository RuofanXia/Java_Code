package QuoraChallenge;

import java.util.*;
/**
 * 
 * @author RuoFan
 * For this question, first parse the flatten tree, into tree data structure. Here I used hashmap to 
 * store parent child pairwise correlation. And for each tree node, it has one trie tree, because trie tree 
 * has very efficient performance on prefix problems. Finally, for the query, first find the tree node that 
 * equals to the query topic, then traverse all nodes in this sub-tree, for each node, add trie tree count number.
 */
public class Ontology {
	static class TrieNode{
		public int cnt;
		public Map<Character, TrieNode> children;
		public TrieNode()
		{
			this.cnt = 0;
			this.children = new HashMap<Character, TrieNode>();
		}
	}
	
	static class Trie{
		public TrieNode root;
		
		public Trie(){
			root = new TrieNode();
		}
		
		public void insert(String text)
		{
			Map<Character, TrieNode> children = root.children;
			for (int i=0; i<text.length(); i++)
			{
				char c = text.charAt(i);
				TrieNode trie;
				if (children.containsKey(c))
				{
					trie = children.get(c);
					trie.cnt += 1;
				}
				else
				{
					trie = new TrieNode();
					trie.cnt = 1;
					children.put(c, trie);
				}
				children = trie.children;
			}
		}
		
		public int query(String prefix)
		{
			Map<Character, TrieNode> children = root.children;
			TrieNode tnode = null;
			//only all the prefix characters can be matched in the trie tree
			boolean visitedall = true;
			for (int i=0; i<prefix.length(); i++)
			{
				char c = prefix.charAt(i);
				if (children.containsKey(c))
				{
					tnode = children.get(c);
					children = tnode.children;
				}
				else
				{
					visitedall = false;
					break;
				}
			}
			
			if (tnode != null && visitedall) return tnode.cnt;
			else return 0;
		}
	}
	
	static class TreeNode{
		public Trie trie;
		public List<String> children;
		public TreeNode()
		{
			this.trie = new Trie();
			this.children = new ArrayList<String>();
		}
	}
	
	static class Tree{
		//hashmap: key is node name, and value is the tree node.
		Map<String, TreeNode> treemap;
		
		public Tree()
		{
			this.treemap = new HashMap<String, TreeNode>();
		}
		
		public void add(String parent, List<String> children)
		{
			TreeNode node;
			if (treemap.containsKey(parent))
			{
				node = treemap.get(parent);
			}
			else
			{
				node = new TreeNode();
			}
			
			for (int i=0; i<children.size(); i++)
			{
				node.children.add(children.get(i));
			}
			
			treemap.put(parent, node);
		}
		
		public void insertQuestion(String name, String question)
		{
			if (treemap.containsKey(name))
			{
				treemap.get(name).trie.insert(question);
			}
			else
			{
				System.out.println("Topic is not existed");
			}
		}
		
		public int query(String name, String prefix)
		{
			int res = 0;
			
			if (treemap.containsKey(name))
			{
				res = treemap.get(name).trie.query(prefix);
			}
			else
			{
				System.out.println("Topic is not existed");
			}
			return res;
		}
	}
	

	Tree tree;
	
	public Ontology()
	{
		tree = new Tree();
	}
	
	public Tree parseTree(String treeInfo)
	{
		Queue<String> queue = new LinkedList<String>();
		
		String[] strs = treeInfo.split(" ");
		
		for (int i=0; i<strs.length; i++)
		{
			queue.offer(strs[i]);
		}
		
		String root = queue.poll();
		if (queue.poll().equals("("))
			parseTreeHelper(root, queue);
		
		return tree;
	}
	
	public void parseTreeHelper(String parent, Queue<String> treeInfo)
	{
		String current = treeInfo.poll();
		
		List<String> children = new ArrayList<String>();
		
		String prev = "";
		
		while(true)
		{
			if (current.equals("("))
			{
				parseTreeHelper(prev, treeInfo);
				current = treeInfo.poll();
			}
			else if (current.equals(")"))
			{
				if (children.size()>0)
				{
					tree.add(parent, children);
				}
				break;
			}
			else
			{
				children.add(current);
				tree.add(current, new ArrayList<String>());
				prev = current;
				current = treeInfo.poll();
			}
		}
	}
	
	public void saveQuestions(String questions)
	{
		String[] strs = questions.split(":");
		String topic = strs[0];
		String[] quest_arr = strs[1].split(" ");
		String quest = "";
		
		for (int i=0; i<quest_arr.length; i++)
		{
			quest += quest_arr[i];
		}
		tree.insertQuestion(topic, quest);
	}
	
	public int query(String prefix)
	{
		int res = 0;
		String[] strs = prefix.split(" ");
		String topic = strs[0];
		String question = "";
		for (int i=1; i<strs.length; i++)
		{
			question += strs[i];
		}
		//BFS search
		Queue<String> queue = new LinkedList<String>();
		queue.offer(topic);
		while(!queue.isEmpty())
		{
			String name = queue.poll();
			res += tree.query(name, question);
			List<String> children =tree.treemap.get(name).children;
			for (int i=0; i<children.size(); i++)
			{
				queue.offer(children.get(i));
			}
		}
		
		return res;
	}
	
	public static void main(String[] args)
	{
		/*
		Ontology on = new Ontology();
		on.parseTree("Animals ( Reptiles Birds ( Eagles ( Pigeons Crows ) ) )");		
		on.saveQuestions("Reptiles: Why are many reptiles green?");
		on.saveQuestions("Birds: How do birds fly?");
		on.saveQuestions("Eagles: How endangered are eagles?");
		on.saveQuestions("Pigeons: Where in the world are pigeons most densely populated?");
		on.saveQuestions("Eagles: Where do most eagles live?");
		System.out.println("Save Done!");
		System.out.println(on.query("Eagles How en"));
		System.out.println(on.query("Birds Where"));
		System.out.println(on.query("Reptiles Why do"));
		System.out.println(on.query("Animals Wh"));
		*/
		Scanner scan = new Scanner(System.in);
		Ontology ont = new Ontology();
		int node_num = Integer.parseInt(scan.nextLine());
		String tree_info = scan.nextLine();
		ont.parseTree(tree_info);
		int question_num = Integer.parseInt(scan.nextLine());
		for (int i=0; i<question_num; i++)
		{
			ont.saveQuestions(scan.nextLine());
		}
		int query_num = Integer.parseInt(scan.nextLine());
		for (int i=0; i<query_num; i++)
		{
			System.out.println(ont.query(scan.nextLine()));
		}
	}
}
