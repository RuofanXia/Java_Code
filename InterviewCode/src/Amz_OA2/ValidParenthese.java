package Amz_OA2;

import java.util.*;

public class ValidParenthese {
	
	public static boolean isValid(String str)
	{
		Stack<Character> stack = new Stack<Character>();
		for (int i=0; i<str.length(); i++)
		{
			char c = str.charAt(i);
			if (c == '}')
			{
				if (!stack.isEmpty() && stack.peek() == '{') stack.pop();
				else return false; 
			}
			else if (c == ')')
			{
				if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
				else return false;
			}
			else if (c == ']')
			{
				if (!stack.isEmpty() && stack.peek() == '[') stack.pop();
				else return false;
			}
			else
			{
				stack.push(c);
			}
		}
		
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("(){[]}"));
	}

}
