package DotProduct;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DotProduct {
	public int ComputeInnerProduct(Map<String, Integer> first, Map<String, Integer> second)
	{
	    int sum = 0;
	    
	    for(Map.Entry<String, Integer> entry : first.entrySet())
	    {
	    	if (second.containsKey(entry.getKey())) sum += first.get(entry.getKey())*second.get(entry.getKey());
	    }

	    return sum;
	}
	
	public double ComputeDistance(Map<String, Integer> first, Map<String, Integer> second)
	{
	    int numerator = ComputeInnerProduct(first, second);

	    double denominator = Math.sqrt(ComputeInnerProduct(first, first) * ComputeInnerProduct(second, second));

	    return Math.acos(numerator / denominator);
	}
	
	public Map<String, Integer> ComputeFrequency(List<String> input)
	{
	    Map<String, Integer> result = new HashMap<String, Integer>();

	    for (int i = 0; i < input.size(); i++)
	    {
	        if (result.containsKey(input.get(i)))
	        {
	        	result.put(input.get(i), result.get(input.get(i))+1);
	        }
	        else
	        {
	            result.put(input.get(i), 1);
	        }
	    }

	    return result;
	}
	
	public List<String> GetWords(String filename)
	{
		String line;
		ArrayList<String> result = new ArrayList<String>();
		try
		{
			InputStream fis = new FileInputStream(filename);
		    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
		    BufferedReader br = new BufferedReader(isr);
		    while ((line = br.readLine()) != null) {
		    	String[] words = line.split(" ");
		    	for (String word : words)
		    	{
		    		result.add(word);
		    	}
		    }
		    br.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return result;
	}
}
