import java.util.ArrayList;
import java.util.List;


public class Decompose {
	public static void main(String[] args){
		int n = 70;
		List<Integer> ints = new ArrayList<Integer>();
		for (int i=2; i<=Math.sqrt(n); i++)
		{
			if (prime(i))
				ints.add(i);
		}
		
		int k = 0;
		while(k<ints.size())
		{
			while (n%ints.get(k) == 0)
			{
				System.out.print(ints.get(k) + "*");
				n = n/ints.get(k);
			}
			k++;
		}
	}
	
	public static boolean prime(int val)
	{
		boolean flag = true;
		for (int i=2; i<=Math.sqrt(val); i++)
		{
			
			if (val % i == 0){
				flag = false;
				break;
			}
		}
		return flag;
	}
}
