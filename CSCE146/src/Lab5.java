import java.util.Arrays;
import java.util.Random;


public class Lab5 {
	public static void main(String[] args){
		int[] a = new int[1000];
		Random r = new Random();
		for (int i=0; i<a.length; i++){
			a[i] = i;
		}
		
		//in randomly order
		for (int i=0; i<a.length; i++){
			int index = r.nextInt(a.length);
			int temp = a[index];
			a[index] = a[i];
			a[i] = temp;
		}
		
		//pick a number randomly
		sorted(a);
		
		int avg_linear = 0;
		int avg_binary = 0;
		
		int num_linear = 20;
		int num_binary = 20;
		for (int i=0; i<20; i++){
			int v = a[r.nextInt(a.length)];
			int linearCheck = linearSearch(v, a) ;
			int binaryCheck = binarySearch(v, a);

			if (linearCheck!= -1){
				System.out.println("Searching using linear search Found!");
				avg_linear += linearCheck;
			}
			else
			{
				System.out.println("Linear search not found!");
				num_linear--;
			}
			if (binaryCheck != -1){
				System.out.println("Searching using binary search Found!");
				avg_binary += binaryCheck;
			}
			else
			{
				System.out.println("Binary search not found!");
				num_binary--;
			}
			
			System.out.println("Linear Checks: " + linearCheck);
			System.out.println("Binary Checks: " + binaryCheck);	
		}
		
		System.out.println("The average number of checks for 20 were:");
		System.out.println("Linear Search " + avg_linear/num_linear);
		System.out.println("Binary Search " + avg_binary/num_binary);
	}
	
	public static int[] sorted(int[] a){
		Arrays.sort(a);
		
		return a;
	}
	
	public static int linearSearch(int v, int[] a){
		int check = 0;
		for (int i=0; i<a.length; i++)
		{
			check++;
			if (v == a[i])
			{
				return check;
			}
		}
		return -1;
	}
	
	public static int binarySearch(int v, int[] a){
		int m = a.length / 2;
		if (a[m] == v){
			return 1;
		}
		
		else if(a[m] < v){
			int[] na = Arrays.copyOfRange(a, m+1, a.length);
			return binarySearch(v, na) + 1;
		}
		
		else if(a[m] > v){
			int[] na = Arrays.copyOfRange(a, 0, m);
			return binarySearch(v, na) + 1;
		}
		return -1;
	}
}
