import java.util.LinkedList;
import java.util.Queue;


public class BinaryTree {
	Node root;
	
	class Node{
		Node leftChild;
		Node rightChild;
		int data;
		Node(int data){
			this.data =data; 
			this.leftChild = null;
			this.rightChild = null;
		}
	}
	
	BinaryTree(){
		this.root = null;
	}
	
	void insert(int key) {
		root = insertRec(root, key);
    }
	     
    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int key) {
 
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (key < root.data)
            root.leftChild = insertRec(root.leftChild, key);
        else if (key > root.data)
            root.rightChild = insertRec(root.rightChild, key);
 
        /* return the (unchanged) node pointer */
        return root;
    }

	
	public void printInOrder(Node root){
		if (root == null)
		{
			return;
		}
		
		printInOrder(root.leftChild);
		System.out.println(root.data);
		printInOrder(root.rightChild);
		
	}
	
	public int getDepth(int data)
	{
		int depth=0;
		return recursiveGetDepth(data, depth, root);
	}
	
	public int recursiveGetDepth(int data, int depth, Node root)
	{
		if (root == null)
		{
			return -1;
		}
		else if (data == root.data)
		{
			return depth;
		}
		else if (data > root.data)
		{
			depth++;
			return recursiveGetDepth(data, depth, root.rightChild);
		}
		else if (data < root.data)
		{
			depth++;
			return recursiveGetDepth(data, depth, root.leftChild);
		}
		return -1;
	}
	
	
	void printBreadthOrder() 
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) 
        {

            Node tempNode = queue.poll();
            System.out.println(tempNode.data);
 
            /*Enqueue left child */
            if (tempNode.leftChild != null) {
                queue.add(tempNode.leftChild);
            }
 
            /*Enqueue right child */
            if (tempNode.rightChild != null) {
                queue.add(tempNode.rightChild);
            }
        }
    }
	
	public static void main(String[] args)
	{
//		int[] a = new int[10];
//		for (int i=0; i<a.length; i++)
//		{
//			a[i] = i+1;
//		}
		int[] a = {4,8,10,2,1,7,3,5,9,6};
		BinaryTree bt = new BinaryTree();
		for (int i=0; i<a.length; i++)
		{
			bt.insert(a[i]);
		}
		bt.printInOrder(bt.root);
		System.out.println(bt.getDepth(6));
		System.out.println(bt.getDepth(14));
		bt.printBreadthOrder();
	}
}
