package Amz;

public class WindowSum {
	
	public static int[] solution(int[] data, int k)
	{
		if (data.length <= k) return data;
		
		int[] res = new int[data.length - k + 1];
		
		int sum = 0;
		
		for (int i=0; i<k; i++)
		{
			sum += data[i];
		}
		
		res[0] = sum;
		
		for (int i=k; i<data.length; i++)
		{
			res[i-k+1] = res[i-k] + data[i] - data[i-k];
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//11 14 18 22 29 30 
		int[] data = {2,3,4,2,5,7,8,9,6};
		int[] output = solution(data, 4);
		for(int i: output) System.out.print(i + " ");
	}

}
