package RPSGame;

import java.util.Scanner;

public class RPSHumanPlayer extends RPSPlayer {
	
	Scanner keyboard;
	
	public RPSHumanPlayer()
	{
		super();
		keyboard = new Scanner(System.in);
	}
	
	public void chooseGesture()
	{
		super.setGesture(keyboard.next());
	}
}
