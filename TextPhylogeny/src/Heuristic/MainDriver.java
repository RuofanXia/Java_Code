package Heuristic;

public class MainDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] dissimilarity = {{0,31,57,37,45,49},
					            {31,0,33,23,29,32},
					            {51,41,0,42,37,38},
					            {16,36,28,0,15,27},
					            {35,18,54,30,0,54},
					            {12,40,22,60,19,0}};
		Heuristic heuristic = new Heuristic();
		int[] tree = heuristic.buildTree(dissimilarity, 5);
		
		for (int i=0; i<tree.length; i++)
		{
			System.out.println(tree[i]);
		}
	}

}
