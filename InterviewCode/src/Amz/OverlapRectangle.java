package Amz;

public class OverlapRectangle {
	
	//A & C bottom left, B & D top right
	public static boolean solution(Node A, Node B, Node C, Node D)
	{
		int bl_x1 = Math.min(A.x, B.x);
		int bl_y1 = Math.min(A.y, B.y);
		int tr_x1 = Math.max(A.x, B.x);
		int tr_y1 = Math.max(A.y, B.y);
		
		int bl_x2 = Math.min(C.x, D.x);
		int bl_y2 = Math.min(C.y, D.y);
		int tr_x2 = Math.max(C.x, D.x);
		int tr_y2 = Math.max(C.y, D.y);
		
		if (tr_y1 < bl_y2 || tr_y2 < bl_y1 || tr_x1 < bl_x2 || tr_x2 < bl_x1) return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node A = new Node(0, 0);
		Node B = new Node(2, 2);
		Node C = new Node(1, 0);
		Node D = new Node(4, 4);
		
		System.out.println(solution(A,B,C,D));
	}

}
