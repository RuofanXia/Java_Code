import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab22_2016 {
	public static final String delimiter = " ";
	public static final String READ_TXT = "lyrics.txt";
	public static final String OUT_TXT = "out.txt";
	public static void main(String[] args)
	{
		try
		{
			System.out.println("Enter a word to replace DANGER with");
			Scanner keyboard = new Scanner(System.in);
			String userinput = keyboard.nextLine();
			Scanner fileRead = new Scanner(new File(READ_TXT)).useDelimiter(delimiter);
			String result = "";
			while(fileRead.hasNext())
			{
				String word = fileRead.next();
				String originalword = word;
				word = word.toLowerCase();
				if (word.contains("danger"))
				{
					result += userinput + " ";
				}
				else
				{
					result += originalword + " ";
				}
			}
			keyboard.close();
			fileRead.close();
			System.out.println(result);
			readToFile(OUT_TXT, result);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void readToFile(String fileName, String result)
	{
		try{
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName));
			fileWriter.write(result);
			fileWriter.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
