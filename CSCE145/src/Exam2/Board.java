package Exam2;

import java.util.Random;

public class Board {
	public static final int BOARD_SIZE = 5;
	Space[][] board;
	public Board()
	{
		board = new Space[BOARD_SIZE][BOARD_SIZE];
	}
	
	public void initialize()
	{
		Random r = new Random();
		int row = r.nextInt(BOARD_SIZE);
		int col = r.nextInt(BOARD_SIZE);
		for (int i=0; i<BOARD_SIZE;i++)
		{
			for (int j=0; j<BOARD_SIZE; j++)
			{
				if (i == row && j == col)
				{
					board[i][j] = new Space(false, true);
				}
				else
				{
					board[i][j] = new Space(false, false);
				}
			}
		}
	}
	
	public boolean isSecretSquare(int row, int col)
	{
		board[row][col].setHasBeenUncovered(true);
		if (board[row][col].getIsSecretSquare()) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void printBoard()
	{
		for (int i=0; i<BOARD_SIZE; i++)
		{
			for (int j=0; j<BOARD_SIZE; j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
