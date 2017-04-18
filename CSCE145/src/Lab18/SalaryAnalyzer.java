package Lab18;

import java.io.*;
import java.util.*;
public class SalaryAnalyzer {
	static final String IN_FILE_NAME = "StateOfSC-Salary-List-04012015.txt";
	static final String OUT_FILE_NAME = "OVER250000.txt";
	static final String DELIM = "\t";
	public static void main(String[] args)
	{
		System.out.println("Let's see how many state employees make over $250,000 and work at USC.");
		analyzeEmployeeFile(IN_FILE_NAME);
		System.out.println("Results have been printed to "+OUT_FILE_NAME);
	}
	public static void analyzeEmployeeFile(String fileName)
	{
		try
		{
			Scanner readFile = new Scanner(new File(fileName));
			System.out.println(readFile.nextLine());
			String result_ST = "";
			while (readFile.hasNextLine())
			{
				String fileLine = readFile.nextLine();
				String[] parseLine = fileLine.split(DELIM);
				if (Integer.parseInt(parseLine[parseLine.length-1]) > 250000 && parseLine[0].equalsIgnoreCase("UNIVERSITY OF SOUTH CAROLINA"))
				{
					System.out.println(fileLine);
					//al.add(fileLine);
					result_ST = result_ST.concat(fileLine+"\n");
				}
	
			}
			readFile.close();
//			for (int i=0; i<al.size(); i++)
//			{
//				printToSalaryFile(OUT_FILE_NAME, al.get(i));
//			}
			printToSalaryFile(OUT_FILE_NAME, result_ST);
		}catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		//TODO: Fill this in
	}
	public static void printToSalaryFile(String fileName, String text)
	{
		//TODO: Fill this in
		try
		{
			PrintWriter fileWrite = new PrintWriter(new FileOutputStream(fileName));
			fileWrite.println(text);
			fileWrite.close();
		}catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
