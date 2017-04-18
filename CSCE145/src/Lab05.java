import java.util.Scanner;


public class Lab05 {
	public static void main(String[] args){
		System.out.println("Welcome to the BMR calculator!");
		Scanner k1 = new Scanner(System.in);
		
		System.out.println("First are you male or female? Enter M or F");
		String genda = k1.next();
		
		System.out.println("How tall are you in inches?");
		int height = Integer.parseInt(k1.next());
		
		System.out.println("What is your weight in pounds?");
		int weight = Integer.parseInt(k1.next());
		
		System.out.println("What is your age in years?");
		int age = Integer.parseInt(k1.next());

		System.out.println("How would you describe your lifestyle? Sedentary, Somewhat Active, Active, Highly Active?");
		String lifestyle = k1.next();
		
		double bmr = 0;
		if(genda.equals("F")){
			bmr = 655 + (4.3 * weight) + (4.7 * height) - (4.7 * age);
		}else{
			bmr = 66 + (6.3 * weight) + (12.9 * height) - (6.8 * age);
		}
		
		if (lifestyle.equals("Sedentary")){
			bmr = bmr*1.2;
		}
		else if (lifestyle.equals("Somewhat Active")){
			bmr = bmr*1.3;
		}
		else if (lifestyle.equals("Active")){
			bmr = bmr*1.4;
		}
		else {
			bmr = bmr*1.5;
		}
		
		System.out.println("Your BMR is"+ bmr +"calories!");
	}
}
