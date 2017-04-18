package Reconciliation;

public class MainDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reconciliation rc =new Reconciliation();
		int[][] tree_set = {{0,0,0,0,2,3},
							{3,1,1,1,1,4},
							{0,0,0,1,1,2},
							{3,3,1,3,0,1},
							{0,0,5,1,1,0},
							{0,3,0,0,2,0}};
		int[] tree = rc.buildTree(tree_set);
		for(int i: tree)
		{
			System.out.println(i);
		}
	}

}
