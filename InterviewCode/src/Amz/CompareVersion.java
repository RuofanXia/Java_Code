package Amz;

public class CompareVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int compareVersion(String version1, String version2)
	{
		String[] data1 = version1.split("\\.");
		String[] data2 = version2.split("\\.");
		
		int index = 0;
		while(index < data1.length || index < data2.length)
		{
			if (index < data1.length && index < data2.length)
			{
				if (Integer.parseInt(data1[index]) < Integer.parseInt(data2[index]))
				{
					return -1;
				}
				else if (Integer.parseInt(data1[index]) > Integer.parseInt(data2[index]))
				{
					return 1;
				}
			}
			else if (index < data1.length)
			{
				if (Integer.parseInt(data1[index]) != 0)
				{
					return 1;
				}
			}
			else if (index < data2.length)
			{
				if (Integer.parseInt(data2[index]) != 0)
				{
					return -1;
				}
			}
			index++;
		}
		
		return 0;
	}

}
