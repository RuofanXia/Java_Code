import java.util.Scanner;

public class LabExam1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the bouncing ball program!");
		Scanner keyboard = new Scanner(System.in);
		double velocity = keyboard.nextDouble();
		int bounce_time = 5;
		int time = 0;
		double height = 0;
		
		while (bounce_time>0)
		{
			while(height >=0 )
			{
				System.out.println("Time: " + time + " Height: " + height);
				time++;
				height += velocity;
				velocity -= 32;
			}
			System.out.println("BOUNCE!");
			height = height *0.5*(-1);
			velocity = velocity* 0.5*(-1);
			bounce_time--;
		}
	}

}
