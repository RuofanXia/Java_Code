package Amz_OA2;

import java.util.*;

public class CountValidParenthese {
	
	public static int solution(String str)
	{
		int cnt = 0;
		Stack<Character> stack = new Stack<Character>();
		
		for (int i=0; i<str.length(); i++)
		{
			char c = str.charAt(i);
			if (c == '(')
			{
				stack.push(c);
			}
			else
			{
				if (!stack.isEmpty() && stack.peek() == '(')
				{
					cnt++;
					stack.pop();
				}
			}
		}
		
		return cnt;
	}
	
	public static int solution2(String data)
	{
		Stack<Character> stack = new Stack<Character>();
		
		int count = 0;
		
		for (int i=0; i<data.length(); i++)
		{
			char c = data.charAt(i);
			if (c == '(' )
			{
				stack.push(c);
			}
			else 
			{
				if (!stack.isEmpty() && stack.peek() == '(')
				{
					count++;
					stack.pop();
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args)
	{
		System.out.println(solution(")))()"));
	}
}
