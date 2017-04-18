package MyCode;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class MainDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(CountAndSay(5));

	}
	
	/*Count and Say*/
	
	public static String CountAndSay(int n)
	{
		if (n <= 0) return "";
		
		int index = 1;
		
		String current = "1";
		
		while(index < n)
		{
			int count = 1;
			StringBuilder sb = new StringBuilder();
			for (int i=1; i<current.length(); i++)
			{
				if (current.charAt(i) == current.charAt(i-1))
				{
					count++;
				}
				else
				{
					sb.append(count);
					sb.append(current.charAt(i-1));
					count = 1;
				}
			}
			sb.append(count);
			sb.append(current.charAt(current.length()-1));
			current = sb.toString();
			index++;
		}
		
		return current;
	}
	
	/*Four Sum*/
	
	public static List<List<Integer>> FourSum(int[] nums)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) return result;
		Arrays.sort(nums);
		for (int i=0; i<nums.length - 3; i++)
		{
			if (i!=0 && nums[i] == nums[i-1]) continue;
			for (int j=i+1; j<nums.length - 2; j++)
			{
				if (j != i+1 && nums[j] == nums[j-1]) continue;
				int left = j+1, right = nums.length - 1;
				while(left < right)
				{
					if (nums[i] + nums[j] + nums[left] + nums[right] == 0) 
					{
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[left]);
						list.add(nums[right]);
						result.add(list);
						left++;
						right--;
						while (left < right && nums[left] == nums[left-1])
							left++;
						while (left < right && nums[right] == nums[right+1])
							right--;
					}
					else if(nums[i] + nums[j] + nums[left] + nums[right] > 0)
					{
						right--;
					}
					else
					{
						left++;
					}
				}
			}
		}
		return result;
	}
	
	/*Three Sum*/
	
	public static List<List<Integer>> ThreeSum(int[] nums)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if (nums == null || nums.length == 0) return result;
		
		Arrays.sort(nums);
		
		for (int i=0; i<nums.length-2; i++)
		{
			if (i != 0 && nums[i] == nums[i-1]) continue;
			
			int left = i + 1, right = nums.length - 1;
			while (left < right)
			{
				
				if (nums[left] + nums[right] + nums[i] == 0)
				{
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(nums[i]);
					list.add(nums[left]);
					list.add(nums[right]);
					result.add(list);
					left++;
					right--;
					while(left < right && nums[left] == nums[left-1])
						left++;
					while(left < right && nums[right] == nums[right+1])
						right--;
				}
				else if (nums[left] + nums[right] + nums[i] > 0)
				{
					right--;
				}
				else
				{
					left++;
				}
			}
		}
		return result;
	}
	
	public static char findDifference(String s, String t)
	{
		char res = ' ';
		Map<Character, Integer> hashmap = new HashMap<Character, Integer>();
		for (int i=0; i<s.length(); i++)
		{
			char ch = s.charAt(i);
			if (hashmap.containsKey(ch))
			{
				int val = hashmap.get(ch);
				hashmap.put(ch, val+1);
			}
			else
			{
				hashmap.put(ch, 1);
			}
		}
		
		for (int i=0; i<t.length(); i++)
		{
			char ch = t.charAt(i);
			if (hashmap.containsKey(ch))
			{
				int val = hashmap.get(ch);
				if (val > 1)
				{
					hashmap.put(ch, val-1);
				}
				else
				{
					hashmap.remove(ch);
				}
			}
			else
			{
				return ch;
			}
		}
		return res;
	}
	
	/*Word Break I*/
	public static boolean WordBreakI_DP(String s, Set<String> dict)
	{
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		
		for (int i=0; i<s.length(); i++)
		{
			if (!dp[i]) continue;
			
			for (String str : dict)
			{
				int len = str.length();
				int end = i + len;
				
				if (end > s.length()) continue;
				
				if (dp[end]) continue;
				
				if (s.substring(i, end).equals(str))
					dp[end] = true;
			}
		}
		
		return dp[s.length()];
	}
	
	/* divide integer without division */
	public static void divison(int num, int deno){ 
		int res = 0;
		while(num > deno){ 
			num = num - deno; 
			res++;
		} 
		System.out.println(res); 
	}
	
	/*Minimum Window Substring*/
	public static String MinWindowSubstring(String s, String t)
	{
		if (t.length() > s.length()) return "";
		
		String result = "";
		
		//count characters in String t
		Map<Character, Integer> t_map = new HashMap<Character, Integer>();
		for (int i=0; i<t.length(); i++)
		{
			char c = t.charAt(i);
			if (t_map.containsKey(c))
			{
				t_map.put(c, t_map.get(c) + 1);
			}
			else
			{
				t_map.put(c, 1);
			}
		}
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		int minLen = s.length();
		
		int count = 0;
		
		int left = 0;
		
		for (int i=0; i<s.length(); i++)
		{
			char c = s.charAt(i);
			if (t_map.containsKey(c))
			{
				if (map.containsKey(c))
				{
					if (map.get(c) < t_map.get(c))
					{
						count++;
					}
					map.put(c, map.get(c)+1);
				}
				else
				{
					count++;
					map.put(c, 1);
				}
			}
			
			if (count == t.length())
			{
				char lc = s.charAt(left);
				while(!map.containsKey(lc) || map.get(lc) > t_map.get(lc))
				{
					if(map.containsKey(lc) && map.get(lc) > t_map.get(lc))
						left++;
					lc = s.charAt(left);
				}
				
				if (i-left + 1 < minLen)
				{
					minLen = i - left + 1;
					result = s.substring(left, i+1);
				}
			}
		}
		return result;
	}
}	
