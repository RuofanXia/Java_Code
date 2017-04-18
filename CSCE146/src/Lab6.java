import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;


public class Lab6 {
	public static void main(String[] args)
	{
		int counter = 3;
		while (counter>0)
		{
			ArrayList<Integer> alist = new ArrayList<Integer>();
			Random r = new Random();
			int num = r.nextInt(11) + 10;
			System.out.println("Populating the Array List of Size " + num );
			for (int i=0; i<num; i++)
			{
				alist.add(r.nextInt(100));
			}
			
			System.out.println("This list contains");
			for (int i=0; i<num; i++)
			{
				System.out.println(alist.get(i));
			}
			
			System.out.println("Sorting");
			quickSort(alist, 0, alist.size()-1);
			System.out.println("Printing Sorted Numbers");
			for (int i=0; i<alist.size(); i++)
			{
				System.out.println(alist.get(i));
			}
			System.out.println("Adding elements in the list to a queue");
			Queue<Integer> queue = new LinkedList<Integer>();
			for (int i=0; i<num; i++)
			{
				queue.add(alist.get(i));
			}
			System.out.println("Removing and Printing each element from the Queue");
			for (int i=0; i<num; i++)
			{
				System.out.println(queue.poll());
			}
			System.out.println("Adding elements in the list to a stack");
			Stack<Integer> stack = new Stack<Integer>();
			for (int i=0; i<num; i++)
			{
				stack.push(alist.get(i));
			}
			System.out.println("Removing and printing each element from the Stack");
			for (int i=0; i<num; i++)
			{
				System.out.println(stack.pop());
			}
			counter--;
		}
	}
	
	public static void quickSort(ArrayList<Integer> alist, int low, int high) {
		if (alist.isEmpty() || alist.size() == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = alist.get(middle);
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (alist.get(i) < pivot) {
				i++;
			}
 
			while (alist.get(j) > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = alist.get(i);
				alist.set(i, alist.get(j));
				alist.set(j, temp);
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSort(alist, low, j);
 
		if (high > i)
			quickSort(alist, i, high);
	}
}
