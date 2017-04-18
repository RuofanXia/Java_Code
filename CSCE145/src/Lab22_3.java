import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Lab22_3 {
	public static final String READ_IN_FILE = "grade.txt";
	public static void main(String[] args)
	{
		int labs_score = 0;
		int labs_count = 0;
		
		int hw_score = 0;
		int hw_count = 0;
		int hw_lowst = 100;
		
		int exam1_score = 0;
		int exam2_score = 0;
		int lab_exam1 = 0;
		int lab_exam2 = 0;
		int final_exam = 0;
		int extra_credit_score = 0;
		
		try
		{
			Scanner readFile = new Scanner(new File(READ_IN_FILE));
			while(readFile.hasNextLine())
			{
				String line = readFile.nextLine();
				if (line.equalsIgnoreCase("labs"))
				{
					while(readFile.hasNextInt())
					{
						labs_score += readFile.nextInt();
						labs_count++;
					}
					
				}
				else if (line.equalsIgnoreCase("homework"))
				{
					while(readFile.hasNextInt())
					{
						int value = readFile.nextInt();
						if (value < hw_lowst)
						{
							hw_lowst = value;
						}
						hw_score += value;
						hw_count++;
					}
				}
				else if (line.equalsIgnoreCase("exam 1"))
				{
					while(readFile.hasNextInt())
					{
						exam1_score = readFile.nextInt();
					}
				}
				else if (line.equalsIgnoreCase("exam 2"))
				{
					while(readFile.hasNextInt())
					{
						exam2_score = readFile.nextInt();
					}
				}
				else if (line.equalsIgnoreCase("lab exam 1"))
				{
					while(readFile.hasNextInt())
					{
						lab_exam1 = readFile.nextInt();
					}
				}
				else if (line.equalsIgnoreCase("lab exam 2"))
				{
					while(readFile.hasNextInt())
					{
						lab_exam2 = readFile.nextInt();
					}
				}
				else if (line.equalsIgnoreCase("final"))
				{
					while(readFile.hasNextInt())
					{
						final_exam = readFile.nextInt();
					}
				}
				else if (line.equalsIgnoreCase("extra credit"))
				{
					while(readFile.hasNextInt())
					{
						extra_credit_score += readFile.nextInt();
					}
				}
			}
			readFile.close();
			
			
			
			
			double lab_avg = Math.ceil(labs_score/labs_count);
			System.out.println("Your lab average is " + lab_avg);
			
			double hw_avg = Math.ceil((hw_score-hw_lowst)/(hw_count-1));
			System.out.println("Your homework average is " + hw_avg);
			
			System.out.println("first exam is " + exam1_score); 
			
			System.out.println("first lab exam is " + lab_exam1);
			
			System.out.println("second exam is " + exam2_score); 
			
			System.out.println("second lab exam is " + lab_exam2);
			
			double extra_points = Math.ceil(extra_credit_score*0.02);
			System.out.println("Your extra work total is " + extra_points);
			
			System.out.println("Your final is " + final_exam);
			
			double raw_total = Math.ceil((lab_avg*0.2 + hw_avg*0.3 + (exam1_score + lab_exam1 + exam2_score + lab_exam2 + final_exam)*0.1
					+ extra_points));
			System.out.println("Your raw total is " + raw_total);
			
			if (raw_total >= 90 )
			{
				System.out.println("Your final grade is A");
			}
			else if (raw_total >= 85)
			{
				System.out.println("Your final grade is B+");
			}
			else if (raw_total >= 80)
			{
				System.out.println("Your final grade is B");
			}
			else if (raw_total >= 75)
			{
				System.out.println("Your final grade is C+");
			}
			else if (raw_total >= 70)
			{
				System.out.println("Your final grade is C");
			}
			else if (raw_total >= 65)
			{
				System.out.println("Your final grade is D+");
			}
			else if (raw_total >= 60)
			{
				System.out.println("Your final grade is D");
			}
			else
			{
				System.out.println("Your final grade is F");
			}
			
			
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
