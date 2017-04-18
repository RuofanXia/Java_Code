import java.util.ArrayList;
import java.util.List;


public class RestoreIPAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<String> restoreIpAddresses(String s){
		List<String> finalResult = new ArrayList<String>();
		List<List<String>> result = new ArrayList<List<String>>();
		dfs(s, 0, new ArrayList<String>(), result);
		
		for(List<String> list : result)
		{
			String temp_str = "";
			for (String str : list)
			{
				temp_str += str + ".";
			}
			temp_str = temp_str.substring(0, temp_str.length()-1);
			finalResult.add(temp_str);
		}
		
		return finalResult;
	}
	
	public static void dfs(String s, int start, List<String> temp, List<List<String>> result)
	{
		if (temp.size() == 4 && start != s.length()) return;
		
		if ((temp.size() + s.length() - start + 1) < 4) return;
		
		if (temp.size() == 4 && start == s.length())
		{
			ArrayList<String> al = new ArrayList<String>(temp);
			result.add(al);
			return;
		}
		
		for(int i=1; i<=3; i++)
		{
			if(i+start > s.length()) return;
			
			String sub = s.substring(start, start+i);
			
			if(i!=1 && s.charAt(start) == '0' ) return;
			
			if (Integer.valueOf(sub) > 255) return;
			
			temp.add(sub);
			dfs(s, start+i, temp, result);
			temp.remove(temp.size()-1);
		}
	}
}
