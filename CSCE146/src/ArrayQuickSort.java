/**
 * 
 * @author Ciara Gordon
 *
 */
import java.util.*;
public class ArrayQuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int runs = 3;
		while(runs>0)
		{
			//ArrayList
			ArrayList<Integer> a = new ArrayList<Integer>();
			//randomly setting the size of the array list
			//between 10-20
			int size = r.nextInt(11)+10;
			//populating array with random values b/w 0-99
			System.out.println("Populating the Array List of size "+size);
			for(int i=0;i<size;i++)
			{
				a.add(r.nextInt(100));
			}
			System.out.println("This list contains");
			for(int i : a)
			{
				System.out.println(i);
			}
			//Sorts array using quick sort
			System.out.println("Sorting");
			int[] data = new int[size];
			//adds data from the ArrayList to an integer array
			for(int i=0;i<size;i++)
			{
				data[i]=a.get(i);
			}
			int left=0;int right=size-1;
			quickSort(data,left,right);
			//changes data in the ArrayList to that of the integer array
			for(int i=0;i<size;i++)
			{
				a.set(i, data[i]);
			}
			System.out.println("Printing Sorted Numbers");
			for(int i : a)
			{
				System.out.println(i);
			}
			
			//Queue
			Queue<Integer> q = new LinkedList<Integer>();
			System.out.println("Adding elements in the list to a queue");
			//adds data from ArrayList to a queue
			for(int i=0;i<size;i++)
			{
				q.addAll(a);//enqueue
			}
			System.out.println("Removing and Printing each element from the Queue");
			for(int i=0;i<size;i++)
			{
				System.out.println(q.remove());//dequeue
			}
			
			//Stack
			Stack<Integer> s = new Stack<Integer>();
			System.out.println("Adding elements in the list to a stack");
			//adds data from queue to a stack
			for(int i=0;i<size;i++)
			{
				s.push(q.remove());
			}
			System.out.println("Removing and printing each element from the Stack");
			for(int i=0;i<size;i++)
			{
				System.out.println(s.pop());
			}
			//program will loop 3 times before quitting
			runs--;
		}
	}
	public static void quickSort(int[] a, int left, int right)
	{
		int index = partition(a,left,right);
		if(left < index -1)
		{
			quickSort(a,left,index-1);//left side
		}
		if(index < right)
		{
			quickSort(a,index,right);//right side
		}
	}
	public static int partition(int[] a,int left, int right)
	{
		int i = left;//=0
		int j = right;//=a.length-1
		
		int pivot = a[(left+right)/2];//midpoint
		while(i<=j)
		{
			while(a[i] < pivot)
			{
				i++;//correct position so move forward
			}
			while(a[j] > pivot)
			{
				j--;//correct position
			}
			if(i<=j)//SWAP
			{
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		return i;//index
	}
}
