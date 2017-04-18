package Amz;

import java.util.*;

public class Parenthese {
	
	public static boolean solution1(String str)
	{
		Stack<Character> stack = new Stack<Character>();
		for (int i=0; i<str.length(); i++)
		{
			char ch = str.charAt(i);
			if (ch == '{' || ch == '[' || ch == '(')
			{
				stack.push(ch);
			}
			else if (ch == '}')
			{
				if (!stack.isEmpty() && stack.peek() == '{') stack.pop();
				else return false;
			}
			else if (ch == ']')
			{
				if (!stack.isEmpty() && stack.peek() == '[') stack.pop();
				else return false;
			}
			else
			{
				if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
				else return false;
			}
		}
		
		return stack.isEmpty();
	}
	
	public static int solution2(String str)
	{
		Stack<Character> stack = new Stack<Character>();
		int cnt = 0;
		for (int i=0; i<str.length(); i++)
		{
			char ch = str.charAt(i);
			if (ch == '('){ stack.push(ch); }
			else
			{
				if (!stack.isEmpty() && stack.peek() == '(')
				{
					stack.pop();
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(solution1("[({})]"));
		System.out.println(solution2("()))()"));
	}

}
