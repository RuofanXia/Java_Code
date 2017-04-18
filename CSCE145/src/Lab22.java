import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Lab22 {
	public static final String READ_IN_FILE = "perfect.txt";
	public static void main(String[] args)
	{
		try
		{
			Scanner readFile = new Scanner(new File(READ_IN_FILE));
			String longString = "";
			while(readFile.hasNextLine())
			{
				longString = longString.concat(readFile.nextLine() + " ");
			}
			readFile.close();
			int index_labs = longString.indexOf("LABS");
			int index_hw = longString.indexOf("HOMEWORK");
			int index_exam1 = longString.indexOf("EXAM 1");
			int index_exam2 = longString.indexOf("EXAM 2");
			int index_lexam1 = longString.indexOf("LAB EXAM 1");
			int index_lexam2 = longString.indexOf("LAB EXAM 2");
			int index_final = longString.indexOf("FINAL");
			int index_extra = longString.indexOf("EXTRA CREDIT");
			
			
			String labs = longString.substring(index_labs+5, index_hw);
			String[] labslist = labs.split(" ");
			int lab_scores = 0;
			for (int i=0; i<labslist.length; i++)
			{
				lab_scores += Integer.parseInt(labslist[i]);
			}
			
			String hw = longString.substring(index_hw+9, index_exam1);
			String[] hwlist = hw.split(" ");
			int hw_scores = 0;
			int lowest_hw = 100;
			for (int i=0; i<hwlist.length; i++)
			{
				if (Integer.parseInt(hwlist[i]) < lowest_hw)
				{
					lowest_hw = Integer.parseInt(hwlist[i]);
				}
				hw_scores += Integer.parseInt(hwlist[i]);
			}
			hw_scores = hw_scores - lowest_hw;
			
			String exam1 = longString.substring(index_exam1+7, index_exam2-1);
			int exam1_scores = Integer.parseInt(exam1);
			
			String exam2 = longString.substring(index_exam2+7, index_lexam1-1);
			int exam2_scores = Integer.parseInt(exam2);
			
			String lexam1 = longString.substring(index_lexam1+11, index_lexam2-1);
			int lexam1_scores = Integer.parseInt(lexam1);
			
			String lexam2 = longString.substring(index_lexam2+11, index_final-1);
			int lexam2_scores = Integer.parseInt(lexam2);
			
			String finals = longString.substring(index_final+6, index_extra-1);
			int finals_scores = Integer.parseInt(finals);
			
			String extra = longString.substring(index_extra+13);
			String[] extralist = extra.split(" ");
			int extra_scores = 0;
			for (int i=0; i<extralist.length; i++)
			{
				extra_scores += Integer.parseInt(extralist[i]);
			}
			
			
			
			double lab_avg = Math.ceil(lab_scores/labslist.length);
			System.out.println("Your lab average is " + lab_avg);
			
			double hw_avg = Math.ceil(hw_scores/(hwlist.length-1));
			System.out.println("Your homework average is " + hw_avg);
			
			System.out.println("first exam is " + exam1_scores); 
			
			System.out.println("first lab exam is " + lexam1_scores);
			
			System.out.println("second exam is " + exam2_scores); 
			
			System.out.println("second lab exam is " + lexam2_scores);
			
			double extra_points = Math.ceil(extra_scores*0.02);
			System.out.println("Your extra work total is " + extra_points);
			
			System.out.println("Your final is " + finals_scores);
			
			double raw_total = Math.ceil((lab_avg*0.2 + hw_avg*0.3 + (exam1_scores + lexam1_scores + exam2_scores + lexam2_scores + finals_scores)*0.1
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
