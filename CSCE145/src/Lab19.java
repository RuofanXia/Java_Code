import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Lab19 {
	static final String IN_FILE_NAME = "script.txt";
	static final String FORCE = "force";
	static final String WOOKIEE = "wookiee";
	static final String JABBA = "jabba";
	static final String DEATH_STAR = "death";
	
	public static void main(String[] args){
		try
		{
			Scanner fileScanner = new Scanner(new File(IN_FILE_NAME));
			/*
			String line = "";
			
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				line = line.concat(fileLine+" ");
				
			}
			fileScanner.close();
			String[] filesplits = line.split("\\s+");
			*/
			int force_count = 0;
			int wookiee_count = 0;
			int jabba_count = 0;
			int death_count = 0;
			while (fileScanner.hasNext())
			{
				String word = fileScanner.next();
				word = word.toLowerCase();
				
				if (word.contains(FORCE))
				{
					force_count++;
				}
				else if (word.contains(WOOKIEE))
				{	
					wookiee_count++;
				}
				else if(word.contains(JABBA))
				{
					jabba_count++;
				}
				else if(word.contains(DEATH_STAR) && fileScanner.next().toLowerCase().contains("star"))
				{
						death_count++;
				}
			}
			
			
			System.out.println("The number of times the word \"Force\" appears in Star Wars is " + force_count);
			System.out.println("The number of times the word \"Wookiee\" appears in Star Wars is " + wookiee_count);
			System.out.println("The number of times the word \"Jabba\" appears in Star Wars is " + jabba_count);
			System.out.println("The number of times the word \"Death Star\" appears in Star Wars is " + death_count);
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		/*
		String a = "WWW.";
		String b = "www";
		System.out.println(a.contains(b));
		a = a.toLowerCase();
		System.out.println(a.contains(b));
		*/
	}
	
}
