import java.util.*;

public class combination {
	
	
	public static void main(String[] args)
	{
		List<String> result = new ArrayList<String>();
		dfs_backtracking("abc", 0, "", result, new boolean[3]);
		System.out.println(result.size());
		for (int i=0; i<result.size(); i++)
		{
			System.out.println(result.get(i));
		}
	}
	
	public static void dfs_backtracking(String str, int len, String current, List<String> result, boolean[] visit)
	{
		if (len == str.length()) result.add(current);
		
		for (int i=0; i<str.length(); i++)
		{
			if (!visit[i])
			{
				current += str.substring(i, i+1);
				visit[i] = true;
				dfs_backtracking(str, len+1, current, result, visit);
				current = current.substring(0, current.length()-1);
				visit[i] = false;
			}
		}
	}
}	


