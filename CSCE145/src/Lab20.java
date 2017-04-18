import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Lab20 {
	public static final String delim = " ";
	public static final String READ_TXT = "lyrics.txt";
	public static final String OUT_TXT = "newSong.txt";
	public static void main(String[] args)
	{
		try
		{
			System.out.println("Enter a word to replace DANGER with");
			Scanner keyboard = new Scanner(System.in);
			String useinput = keyboard.nextLine();
			Scanner fileScanner = new Scanner(new File(READ_TXT)).useDelimiter(delim);
			
			String result = "";
			while(fileScanner.hasNext())
			{
				String word = fileScanner.next();
				String orig_word = word;
				word = word.toLowerCase();
				if (word.contains("danger"))
				{
					result = result.concat(useinput + " ");
				}
				else
				{
					result = result.concat(orig_word + " ");
				}
			}
			fileScanner.close();
			keyboard.close();
			System.out.println(result);
			recordToFile(OUT_TXT, result);
			System.out.println("Finished writing to "+ OUT_TXT);
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void recordToFile(String fileName, String txt)
	{
		try
		{
			PrintWriter fileWrite = new PrintWriter(new FileOutputStream(fileName));
			fileWrite.println(txt);
			fileWrite.close();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
