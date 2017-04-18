package Exam2;

import java.util.Scanner;
public class SecretSquareGame {
	
	//Used to get user input throughout methods
	static Scanner keyboard;
	//A class constant that is set to the max number of turns
	public static final int MAX_TURNS = 15;
	
	public static void main(String[] args) {
		//Creates a new instance of board
		Board board = new Board();
		keyboard = new Scanner(System.in);
		System.out.println("Welcome to the Secret Square Game!");
		boolean quit = false;
		while(!quit)//Runs until the user chooses to quit
		{
			boolean gameOver = false;
			int numTurns = 0;
			board.initialize();//Initializes a fresh board
			while(!gameOver)//Game Loop
			{
				board.printBoard();//Prints out the board
				printOptions();
				
				//Keeps asking for x y values until they are correct
				int x = 0, y = 0;
				while(!validValues(x = keyboard.nextInt(),y = keyboard.nextInt()))
				{
					System.out.println("Those values are not valid.  Try again.");
				}
				//Increase number of turns
				numTurns++;
				//Win condition
				if(board.isSecretSquare(x, y))
				{
					System.out.println("You win! It took you "+numTurns+" turns.");
					gameOver = true;
				}
				//Lose condition
				else if(numTurns >= MAX_TURNS)
				{
					System.out.println("You lost");
					gameOver = true;
				}
			}
			keyboard.nextLine();//Flushes the keyboard stream buffer
			System.out.println("Would you like to play again? \"Yes\" or \"No\"");
			String input = keyboard.nextLine();
			if(input.equalsIgnoreCase("no"))//Ends the game
			{
				quit = true;
			}
		}
		System.out.println("Goodbye");
	}
	//Prints out the game options
	private static void printOptions()
	{
		System.out.println("Enter an X value (0 to 4) followed by a Y value (0 to 4)\nFor reference, the top left corner is 0 0");
	}
	//Determines if a particular x and y value are within the board's indices
	private static boolean validValues(int x, int y)
	{
		return x>=0 && x<Board.BOARD_SIZE && y>=0 && y<Board.BOARD_SIZE;
	}


}