import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Lab21 {
	public static void main(String[] args)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File("blah.txt"));
			String longString = "";
			while(fileScanner.hasNext())
			{
				longString = longString.concat(fileScanner.next());
			}
			
			fileScanner.close();
			
			//System.out.println(longString);
			int count = 0;
			//int m =-1;
			for (int i=0; i<longString.length(); i++)
			{
				if (Character.toLowerCase(longString.charAt(i)) == 'a')
				{
					//System.out.println("a " + i);
					for (int j=i+1; j<longString.length(); j++)
					{
						if (Character.toLowerCase(longString.charAt(j)) == 'e')
						{
							//System.out.println("e " + j);
							for (int k=j+1; k<longString.length(); k++)
							{
								if (Character.toLowerCase(longString.charAt(k)) == 'i')
								{
									//System.out.println("i " + k);
									for (int l=k+1; l<longString.length(); l++)
									{
										if (Character.toLowerCase(longString.charAt(l)) == 'o')
										{
											//System.out.println("o " + l);
											for ( int m=l+1; m<longString.length(); m++)
											{
												if (Character.toLowerCase(longString.charAt(m)) == 'u')
												{
													//System.out.println(i + ","+ j + ","+k +","+l+ ","+m);
													i =m;
													count ++;
													break;
												}
											}
											break;
										}
									}
									break;
								}
							}
							break;
						}
					}
				}
			}
			System.out.println("The file blah.txt has \"AEIOU\" in order "+ count +" times");
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
