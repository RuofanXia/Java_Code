package Amz;

public class AtoI {
	public int solution(String str)
	{
		str = str.trim();
		char flag = '+';
		int index = 0;	
		if (str.charAt(index) == '+')
		{
			index++;
		}
		else if (str.charAt(index) == '-')
		{
			index++;
			flag = '-';
		}
		double current = 0;
		while(index < str.length())
		{
			char c = str.charAt(index);
			if (c>='0' && c<='9')
			{
				current = current*10 + (c - '0');
				index++;
			}
			else
			{
				index++;
				break;
			}
		}
		
		if (flag == '-')
		{
			current = (-1) * current;
		}
		
		if (current > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (current < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return (int)current;
	}
}
