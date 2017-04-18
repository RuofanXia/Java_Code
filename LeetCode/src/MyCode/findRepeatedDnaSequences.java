package MyCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findRepeatedDnaSequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<String> findRepeatedDnaSequences(String str)
	{
		List<String> result = new ArrayList<String>();
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		
		for(int i=0; i<str.length(); i++)
		{
			int index = i;
			while((index+9) < str.length())
			{
				//get the substring
				String substring = str.substring(index, index+10);
				if (!hashmap.containsKey(substring))
				{
					hashmap.put(substring, 1);
				}
				else
				{
					hashmap.put(substring, hashmap.get(substring)+1);
					break;
				}
				index++;
			}
		}
		
		for (Map.Entry<String, Integer> entry : hashmap.entrySet()) {
		    String key = entry.getKey();
		    Integer value = entry.getValue();
		    if(value > 1)
		    {
		    	result.add(key);
		    }
		}
		
		return result;
	}
}
