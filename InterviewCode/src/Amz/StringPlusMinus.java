package Amz;

public class StringPlusMinus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("2"));
	}
	
	public static int solution(String s){  
	    int op = 1;
	    int result = 0;
	    int current = 0;
	    for (int i=0; i<s.length(); i++)
	    {
	    	char ch = s.charAt(i);
	    	if (ch == '-')
	    	{
	    		result = result + op*current;
	    		current = 0;
	    		op = -1;
	    	}
	    	else if (ch == '+')
	    	{
	    		result = result + op*current;
	    		current = 0;
	    		op = 1;
	    	}
	    	else
	    	{
	    		current += Integer.parseInt(s.substring(i, i+1));
	    	}
	    }
	    result = result + op*current;
	    return result;
	}

}
