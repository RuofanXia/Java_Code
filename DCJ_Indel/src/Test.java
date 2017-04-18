import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static void main(String[] args)
	{
		ListNode head = new ListNode(1, 2, 0, 0);
		head.next = new ListNode(3, 4, 0, 0);
		head.next.next = new ListNode(5, 6, 0, 0);
		printInfo(head);
		func(head);
		System.out.println("----");
		printInfo(head);
		
		int[] data = {0,1,0,1,1,0,1,1,0};
		List<Integer> list = new ArrayList<Integer>();
		for (int i=0; i<data.length; i++)
		{
			list.add(data[i]);
		}
		int[] ret = mergeRunType(list);
		for (int i=0; i<ret.length; i++)
		{
			System.out.println(ret[i]);
		}
	}
	
	public static void func(ListNode head)
	{
		ListNode thirdNode = head.next.next;
		head.next = thirdNode;
		thirdNode.prev = head;
	}
	
	public static void printInfo(ListNode head)
	{
		ListNode ptr = head;
		while(ptr != null)
		{
			System.out.println(ptr.first + ", " + ptr.second);
			ptr = ptr.next;
		}
	}
	
	public static int[] mergeRunType(List<Integer> runs)
	{
		List<Integer> temp = new ArrayList<Integer>();
		if (runs.size() <= 1) 
		{
			int[] ret = new int[runs.size()];
			ret[0] = runs.get(0);
			return ret;
		}
		
		int prev = runs.get(0);
		temp.add(prev);
		for(int i=1; i<runs.size(); i++)
		{
			int current = runs.get(i);
			if (prev != current)
			{
				temp.add(current);
				prev = current;
			}
		}
		int[] ret = new int[temp.size()];
		for (int i=0; i<temp.size(); i++)
		{
			ret[i] = temp.get(i);
		}
		
		return ret;
	}
}
