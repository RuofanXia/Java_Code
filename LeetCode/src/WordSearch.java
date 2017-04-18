import java.util.ArrayList;


public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean solution(char[][] board, String word)
	{
		for(int i=0; i<board.length; i++)
		{
			for(int j=0; j<board[0].length; j++)
			{
				if(dfs(board, word, i, j, 0)) return true;
			}
		}
		
		return false;
	}
	
	public static boolean dfs(char[][] board, String word, int i, int j, int k)
	{
		int row = board.length;
		int col = board[0].length;
		
		if(i<0 || j<0 || i>=row || j>=col) return false;
		
		if(board[i][j] == word.charAt(k))
		{
			char temp = board[i][j];
			board[i][j] = '#';
			if (k == word.length()-1) return true;
			else if(dfs(board, word, i-1, j, k+1)
				 || dfs(board, word, i, j+1, k+1)
				 || dfs(board, word, i+1, j, k+1)
				 || dfs(board, word, i, j-1, k+1))
			{
				return true;
			}
		}
		
		return false;
	}
}
