package SyntheticData;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class Misspelling {
	public static boolean containsWord(Map<String, ArrayList<String>> map, String word)
	{
		for (Map.Entry<String, ArrayList<String>> entry : map.entrySet())
		{
			ArrayList<String> list = entry.getValue();
			if (list.contains(word)) return true;
		}
		
		return false;
	}
	
	public static String getCorrectWord(Map<String, ArrayList<String>> map, String word)
	{
		for (Map.Entry<String, ArrayList<String>> entry : map.entrySet())
		{
			ArrayList<String> list = entry.getValue();
			if (list.contains(word)) return entry.getKey();
		}
		
		return "";
	}
	
	public static String getInCorrectWord(Map<String, ArrayList<String>> map, String word)
	{
		Random random = new Random();
		for (Map.Entry<String, ArrayList<String>> entry : map.entrySet())
		{
			ArrayList<String> list = entry.getValue();
			if (entry.getKey().equals(word)) 
			{
				int index = random.nextInt(list.size());
				return list.get(index);
			}
		}
		return "";
	}
}
