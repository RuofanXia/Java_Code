
public class TestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLLDirectly rll = new ReverseLLDirectly();
		int[] data = {1, 2, 3, 4};
		for (int i=0; i<data.length; i++)
		{
			rll.addNode(data[i]);
		}
		rll.printll();
		System.out.println("-----------");
		rll.reverse();
		rll.printll();
		System.out.println(perfectSquare(10));
		System.out.println('a'-'A');
	}
	
	public static boolean perfectSquare(int n)
    {
        int sqrt_val = (int) Math.sqrt(n);
        if (sqrt_val*sqrt_val == n) return true;
        return false;
    }

}
