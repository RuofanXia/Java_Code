package SyntheticData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoadMisspelData {
	public static Map<String, ArrayList<String>> LoadMissp(String path)
	{
		File file = new File(path);
		Map<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			ArrayList<String> list = null;
			String key = "";
			while ((line = br.readLine()) != null) {
				
				if (line != "" && line.charAt(0) == '$')
				{
					if (!key.equals(""))
					{
						hashMap.put(key, list);
					}
					key = line.substring(1);
					list = new ArrayList<String>();
				}
				else
				{
					list.add(line);
				}
			}
			
			hashMap.put(key, list);
			br.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		return hashMap;
	}
	
	public static Map<String, ArrayList<String>> LoadWikiMissp(String path)
	{
		File file = new File(path);
		Map<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] strs = line.split("->");
				if (hashMap.containsKey(strs[1]))
				{
					ArrayList<String> list = hashMap.get(strs[1]);
					list.add(strs[0]);
				}
				else
				{
					ArrayList<String> list = new ArrayList<String>();
					list.add(strs[0]);
					hashMap.put(strs[1], list);
				}
			}
			
			br.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		return hashMap;
	}
}
