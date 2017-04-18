
public class rabbits {
	public static void main(String[] args){
		System.out.println(rabbitAmount(6));
	}
	
	public static int rabbitAmount(int n){
		if (n == 1)
		{
			return 1;
		}
		else if (n == 2)
		{
			return 1;
		}
		else
		{
			return rabbitAmount(n-1) + rabbitAmount(n-2);
		}
	}
}
