package LabExam1;


public class Checker {
	String val;
	Checker(String val)
	{
		this.val = val;
	}
	
	public boolean enclosing(){
		char[] charlist = val.toCharArray();
		char[] opening = {'<', '(', 'Ò', '{'};
		char[] closing = {'>', ')', 'Ó', '}'};
		
		Stack<Character> stack = new Stack<Character>();
		for (int i=0; i<charlist.length; i++)
		{
			char symbol = charlist[i];
			
			if ( contains(symbol, opening))
			{
				stack.push(symbol);
			}
			else if ( contains(symbol, closing))
			{
				int index = indexOf(symbol, closing);
				boolean matchs = match(opening, stack, index); 
				if (matchs == false)
				{
					return false;
				}
			}
		}
		if (!stack.isEmpty())
		{
			return false;
		}
		return true;
	}
	
	public static boolean match(char[] opening, Stack<Character> stack, int index)
	{
		int flip = 0;
		while(!stack.isEmpty())
		{
			if (stack.pop() == opening[index])
			{
				flip = 1;
				break;
			}
		}
		if (flip == 0)
		{
			return false;
		}
		return true;
	}
	
	public static boolean contains(char symbol, char[] list)
	{
		for (int i=0; i<list.length; i++)
		{
			if (list[i] == symbol)
			{
				return true;
			}
		}
		return false;
	}
	
	public static int indexOf (char symbol, char[] list)
	{
		for (int i=0; i<list.length; i++)
		{
			if (list[i] == symbol)
			{
				return i;
			}
		}
		return -1;
	}
}
