package Amz;

public class OA {
	public static void pattern(int row)
	{
		for (int i=0; i<row; i++)
		{
			char c = 'a';
			for (int j=0; j<=i; j++)
			{
				System.out.print(c++);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		pattern(4);
	}
}
