package RPSGame;

import java.util.Random;

public class RPSComputerPlayer extends RPSPlayer{
	Random rand;
	public RPSComputerPlayer()
	{
		super();
		rand = new Random();
	}
	
	public void chooseGesture()
	{
		int random_num = rand.nextInt(3);
		String ges = "";
		if (random_num == 0) 
		{
			ges = "rock";
		}
		else if (random_num == 1)
		{
			ges = "paper";
		}
		else
		{
			ges = "scissors";
		}
		
		super.setGesture(ges);
	}
}
