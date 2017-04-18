import java.util.*;
public class IntBSTreeTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Int BST Tester!");
		System.out.println("Creating tree");
		IntBSTree testTree = new IntBSTree();
		System.out.println("Populating Tree with values");
		int[] valArr = {4,8,10,2,1,7,3,5,9,6};
		for(int i : valArr)
		{
			testTree.insert(i);
		}
		System.out.println("Testing insertion by in-order traversal");
		testTree.printInorder();
		System.out.println("Testing breadth order traversal");
		testTree.printBreadthOrder();
		System.out.println("Getting depth of 6");
		System.out.println(testTree.getDepth(6));
		System.out.println("Getting depth of 14");
		System.out.println(testTree.getDepth(14));
		
	}

}