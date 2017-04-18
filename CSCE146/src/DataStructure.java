//Brendan Masi
import java.util.*;
public class DataStructure {
	static Random r = new Random();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arrList =new ArrayList<Integer>();
		Random r =new Random();
		int number=r.nextInt(11)+10;
		for(int i=0;i<number;i++)
		{
			arrList.add(r.nextInt(100));
		}
		for(int i : arrList)
		{
			System.out.println(i);
		}
		
		quickSort(arrList, 0, arrList.size()-1);
		System.out.println("After sorting!");
		for(int i=0; i< arrList.size();i++)
		{
			System.out.println(arrList.get(i));
		}
		
		System.out.println("Queue!");
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0;i<number;i++)
		{
			q.add(arrList.get(i));
		}
		
		while(!q.isEmpty()) /* q.isEmpty will return false if there are values in the queue, add '!' mark*/
		{
			System.out.println(q.poll());
		}
		System.out.println("Stack!");
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<number;i++)
		{ 
			stack.push(arrList.get(i));
		}
		while(stack.isEmpty() == false)
		{
			System.out.println(stack.pop());
		}
		
	}
	
	
	
	public static void quickSort(ArrayList<Integer> a, int left, int right)
	{
		int index=partition(a,left,right);
		if(left<index-1)
		{
			quickSort(a,left,index-1);
		}
		if(index<right)//still things to be sorted
		{
			quickSort(a,index,right);  /* index replace index-1 */
		}
	}
	public static int partition(ArrayList<Integer> a, int left, int right)
	{
		int i=left;
		int j=right;
		
		int pivot=a.get((left+right)/2);
		while(i<=j)
		{
			while(a.get(i)<pivot)
			{
				i++;//correct position so move forward
				
			}
			while(a.get(j)>pivot)   /*index incorrect*/
			{
				j--;//correct position
			}
			if(i<=j)
			{
				int temp =a.get(i);
				a.set(i, a.get(j));
				a.set(j, temp);
				i++;
				j--;
			}
		}
		return i;
	}

}
