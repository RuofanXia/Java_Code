
import java.util.Scanner;

/*
 * Created on Sep 29, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author @$@D
   Asadgugu@gmail.com
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Diamondtest {

	public static void main(String[] args) 
	{
		Scanner S=new Scanner(System.in);
		int c,r,x;

		System.out.print("Enter Size of Hollow Diamond: ");
		x=S.nextInt() ;

		if(x%2==0)
			x++;


			for (r=0;r<=(x/2);r++) //upper triangle
			{

				for (c=0;c<x/2-r;c++)
					System.out.print(" ");

				for (c=0;c<=(2*r);c++)
				{
					if((c==0)||(c==(2*r)))
						System.out.print("*");
					else
						System.out.print(" ");
				}


				System.out.println();

			}

			for (r=x/2-1;r>=0;r--) //lower triangle
			{
				for (c=0;c<x/2-r;c++)
					System.out.print(" ");

				for (c=0;c<=(2*r);c++)
				{
					if((c==0)||(c==(2*r)))
						System.out.print("*");
					else
						System.out.print(" ");
					}

//				for (c=1;c<=x-r;c++)
//				System.out.print(" ");

				System.out.println();
			}

			System.out.print("C h  i   l    l     O      u       t");


	}
}