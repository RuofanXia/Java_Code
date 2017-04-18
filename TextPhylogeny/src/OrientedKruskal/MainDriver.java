package OrientedKruskal;

public class MainDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{0,31,57,37,45,49},
				          {31,0,33,23,29,32},
				          {51,41,0,42,37,38},
				          {16,36,28,0,15,27},
				          {35,18,54,30,0,54},
				          {12,40,22,60,19,0}};
		OrientedKruskal ok = new OrientedKruskal();
		int[] tree = ok.buildTree(matrix);
		for (int i : tree)
		{
			System.out.println(i);
		}
	}

}
