


public class PalindromeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s= "abcva";
		System.out.println(isPalindrome(s));

	}

	public static boolean isPalindrome(String input)
		{
			if (input == null)
			{
				return false;
			}
			String reversed = reverse(input);
			return input.equals(reversed);
		}
		
		public static String reverse(String str)
		{
			if (str == null)
			{
				return null;
			}
			if (str.length() <= 1)
			{
				return str;
			}
			return reverse(str.substring(1)) + str.charAt(0);
		}

}
