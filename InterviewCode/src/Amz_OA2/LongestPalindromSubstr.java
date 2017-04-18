package Amz_OA2;

public class LongestPalindromSubstr {
	
	public static String Solution(String str)
	{
		String longest = str.substring(0, 1);
		
		if (str == null || str.length()<2) return str;
		
		for (int i=0; i<str.length(); i++)
		{
			String ret = helper(str, i, i);
			if (ret.length()>longest.length())
			{
				longest = ret;
			}
			ret = helper(str, i, i+1);
			if (ret.length()>longest.length())
			{
				longest = ret;
			}
		}
		
		return longest;
	}
	
	public static String helper(String str, int start, int end)
	{
		while(start>=0 && end < str.length() && str.charAt(start) == str.charAt(end))
		{
			start--;
			end++;
		}
		
		return str.substring(start+1, end);
	}
	
	public static void main(String[] args)
	{
		System.out.println(Solution("babad"));
	}
}
