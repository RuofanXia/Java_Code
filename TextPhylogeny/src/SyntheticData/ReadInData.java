package SyntheticData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadInData {
	public static String readFile(File file){
		StringBuilder lines = new StringBuilder();
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			
			
			String line = null;
			while ((line = br.readLine()) != null) {
				//System.out.println(line);
				lines.append(line);
			}
		 
			br.close();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		return lines.toString();
	}
}
