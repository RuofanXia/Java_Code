import java.util.*;

public class Components {
	
	public static List<ListNode> getAllComponent(ListNode ga, ListNode gb)
	{
		List<ListNode> components = new ArrayList<ListNode>();
		
		ListNode head_a = ga;
		ListNode head_b = gb;
		while(!allVisited(head_a))
		{
			Pair startPoint = getSearchValue(head_a);
			ListNode startNode = startPoint.node;
			System.out.println("start: " + startPoint.value);
			ListNode ptr = new ListNode(startNode.first, startNode.second, startNode.tag, startNode.visited);
			if (startNode.label != null)
			{
				int[] labels = new int[startNode.label.length];
				for (int i=0; i<labels.length; i++)
				{
					labels[i] = startNode.label[i];
				}
				ptr.label = labels;
			}
			ListNode ptr_head = ptr;
			int original_start = startPoint.value;
			int start = startPoint.value;
			while(true)
			{
				ListNode gb_return = getNextNode(head_b, start);
				ListNode copy = new ListNode(gb_return.first, gb_return.second, gb_return.tag, gb_return.visited);
				if (gb_return.label != null)
				{
					int[] labels = new int[gb_return.label.length];
					for (int i=0; i<labels.length; i++)
					{
						labels[i] = gb_return.label[i];
					}
					copy.label = labels;
				}
				copy.prev = ptr;
				ptr.next = copy;
				ptr = ptr.next;
				start = ptr.first == start ? ptr.second : ptr.first;
				if (start == 0)
				{
					components.add(ptr_head);
					System.out.println("AB path");
					break;
				}
				ListNode ga_return = getNextNode(head_a, start);
				System.out.println("ga_return: " + ga_return.first +"," +ga_return.second);
				/*
				try {
				    Thread.sleep(3000);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
				*/
				resetVisitedValue(ga_return, start);
				
				ListNode cp_ga_return = new ListNode(ga_return.first, ga_return.second, ga_return.tag, ga_return.visited);
				if (ga_return.label != null)
				{
					int[] labels = new int[ga_return.label.length];
					for (int i=0; i<labels.length; i++)
					{
						labels[i] = ga_return.label[i];
					}
					cp_ga_return.label = labels;
				}
				cp_ga_return.prev = ptr;
				ptr.next = cp_ga_return;
				ptr = ptr.next;
				start = ptr.first == start ? ptr.second : ptr.first;
				if (start == 0)
				{
					components.add(ptr_head);
					System.out.println("AA path");
					break;
				}
				else if (start == original_start)
				{
					components.add(ptr_head);
					System.out.println("CIRCILE");
					break;
				}
				else
				{
					resetVisitedValue(ga_return, start);
				}
			}
		}
		
		return components;
	}
	
	public static ListNode getNextNode(ListNode list, int val)
	{
		int index = getIndex(list, val);
		if (index == -1)
		{
			System.out.println("didn't find the node, Exception!");
			System.exit(0);
		}
		ListNode head = list;
		while(index>0)
		{
			head = head.next;
			index--;
		}
		
		return head;
	}
	
	public static int getIndex(ListNode list, int val)
	{
		if (list == null) return -1;
		
		int index = 0;
		
		ListNode head = list;
		
		while(head != null)
		{
			if (head.first == val || head.second == val)
			{
				return index;
			}
			index++;
			head = head.next;
		}
		
		return -1;
	}
	
	public static Pair getSearchValue(ListNode head)
	{
		ListNode ptr = head;
		
		while(ptr != null)
		{
			if (ptr.visited == 3) 
			{
				ptr = ptr.next;
			}
			else if(!(ptr.first == 0 && ptr.second == 0))
			{
				if (ptr.first == 0)
				{
					ptr.visited = 3;
					return new Pair(ptr, ptr.second);
				}
				else if (ptr.second == 0)
				{
					ptr.visited = 3;
					return new Pair(ptr, ptr.first);
				}
				else
				{
					if (ptr.visited == 0)
					{
						ptr.visited = 1;
						return new Pair(ptr, ptr.first);
					}
					else if (ptr.visited == 1)
					{
						ptr.visited = 3;
						return new Pair(ptr, ptr.second);
					}
					else if (ptr.visited == 2)
					{
						ptr.visited = 3;
						return new Pair(ptr, ptr.first);
					}
				}
			}
			else if (ptr.first == 0 && ptr.second == 0)
			{
				ptr = ptr.next;
			}
		}
		
		return null;
	}
	
	public static void resetVisitedValue(ListNode node, int value)
	{
		if (node.visited == 0 && value == node.first)
		{
			if (node.second == 0)
			{
				node.visited = 3;
			}
			else
			{
				node.visited = 1;
			}
		}
		else if (node.visited == 0 && value == node.second)
		{
			if (node.first == 0)
			{
				node.visited = 3;
			}
			else
			{
				node.visited = 2;
			}
		}
		else if (node.visited == 1 && value == node.second)
		{
			node.visited = 3;
		}
		else if(node.visited == 2 && value == node.first)
		{
			node.visited = 3;
		}
	}
	
	public static ListNode retTail(ListNode head)
	{
		if (head == null || head.next == null) return head;
		
		ListNode ptr = head;
		
		while(ptr.next != null)
		{
			ptr = ptr.next;
		}
		
		return ptr;
	}
	
	public static boolean allVisited(ListNode head)
	{
		ListNode ptr = head;
		while(ptr != null)
		{
			if (!(ptr.first == 0 && ptr.second == 0))
			{
				if (ptr.visited != 3) return false;
			}
			ptr = ptr.next;
		}
		
		return true;
	}
	
	//calculate all Runs
	//AA(epsilon), AA(A), AA(B), AA(AB), BB(epsilon), BB(A), BB(B), BB(AB), AB(epsilon), AB(A), AB(B), AB(AB), AB(BA)
	public static void computeRuns(List<ListNode> components)
	{
		int[] cnts = new int[13];
		for(ListNode head : components)
		{
			//check if the component is circle
			if(checkCircular(head)) continue;
			
		}
	}
	
	public static int getRunType(ListNode head)
	{
		int run_num = 0;
		ListNode firstNode = head;
		ListNode ptr = head;
		List<Integer> run_type = new ArrayList<Integer>();
		while(ptr.next != null)
		{
			if (ptr.label != null && ptr.label.length>0)
			{
				run_type.add(ptr.tag);
			}
			ptr = ptr.next;
		}
		if (ptr.label != null && ptr.label.length > 0)
		{
			run_type.add(ptr.tag);
		}
		ListNode lastNode = ptr;
		//merge consecutive 0 or 1 in run
		//AA(epsilon), AA(A), AA(B), AA(AB), BB(epsilon), BB(A), BB(B), BB(AB), AB(epsilon), AB(A), AB(B), AB(AB), AB(BA)
		int[] mergedRuns = mergeRunType(run_type);
		if (mergedRuns.length == 0)
		{
			//AA(epsilon)
			if (firstNode.tag == 0 && lastNode.tag == 0)
			{
				return 0;
			}
			//AB(epsilon)
			else if ((firstNode.tag == 0 && lastNode.tag == 1) || (firstNode.tag == 1 && lastNode.tag == 0))
			{
				return 8;
			}
			//BB(epsilon)
			else if (firstNode.tag == 1 && lastNode.tag == 1)
			{
				return 4;
			}
		}
		else
		{
			//AA
			if (firstNode.tag == 0 && lastNode.tag == 0)
			{
				//AA(A)
				if ((mergedRuns.length % 2 == 1) && (mergedRuns[0] == 0 && mergedRuns[mergedRuns.length-1] == 0)) 
				{
					return 1; 
				}
				//AA(B)
				else if ((mergedRuns.length % 2 == 1) && (mergedRuns[0] == 1 && mergedRuns[mergedRuns.length-1] == 1)) 
				{
					return 2;
				}
				//AA(AB)
				else if (((mergedRuns.length % 2 == 0) && (mergedRuns[0] == 0 && mergedRuns[mergedRuns.length-1] == 1))
						|| ((mergedRuns.length % 2 == 0) && (mergedRuns[0] == 1 && mergedRuns[mergedRuns.length-1] == 0)))
						{
							return 3;
						}
			}
			//BB
			else if (firstNode.tag == 1 && lastNode.tag == 1)
			{
				
			}
		}
	}
	
	public static int[] mergeRunType(List<Integer> runs)
	{
		if (runs == null || runs.size() == 0) return new int[0];
		List<Integer> temp = new ArrayList<Integer>();
		if (runs.size() == 1) 
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
	
	public static void validComponent(List<ListNode> components)
	{
		//merge two component with same node
		int[] index = existedIdenticalNodes(components);
		while(index[0]!=-1 && index[1]!=-1)
		{
			int i = index[0];
			int j = index[1];
			System.out.println(i);
			System.out.println(j);
			ListNode first = components.get(i);
			ListNode second = components.get(j);
			if (first.first == second.first && first.second == second.second)
			{
				components.remove(i);
				components.remove(j-1);
				components.add(mergeTwoComponents(first, second));
			}
			index = existedIdenticalNodes(components);
		}
		
		for (int i=0; i<components.size(); i++)
		{
			connectHeadTail(components.get(i));
		}
	}
	
	public static int[] existedIdenticalNodes(List<ListNode> components)
	{
		for (int i=0; i<components.size(); i++)
		{
			for (int j=i+1; j<components.size(); j++)
			{

				ListNode first = components.get(i);
				ListNode second = components.get(j);
				if (first.first == second.first && first.second == second.second)
				{
					int[] ret = new int[2];
					ret[0] = i;
					ret[1] = j;
					return ret;
				}
			}
		}
		int[] ret = {-1, -1};
		return ret;
	}
	
	public static void connectHeadTail(ListNode head)
	{
		if (head == null || head.next == null) return;
		
		ListNode tail = head;
		
		while(tail.next != null)
		{
			tail = tail.next;
		}
		
		if (tail.first == head.first && tail.second == head.second)
		{
			tail.prev.next = head;
			head.prev = tail.prev;
		}
 	}
	
	public static ListNode mergeTwoComponents(ListNode node1, ListNode node2)
	{
		ListNode ret;
		//get first tail
		ListNode ptr1 = node1;
		while(ptr1.next != null)
		{
			ptr1 = ptr1.next;
		}
		//get second tail
		ListNode ptr2 = node2;
		while(ptr2.next != null)
		{
			ptr2 = ptr2.next;
		}
		if (ptr1.tag == 0)
		{
			ret = reversedDoubleLinkedList(node1);
			node1.next = node2.next;
			if (node2.next != null)
			{
				node2.next.prev = node1;
			}
		}
		else
		{
			ret = reversedDoubleLinkedList(node2);
			node2.next = node1.next;
			if (node1.next != null)
			{
				node1.next.prev = node2;
			}
		}
		
		return ret;
	}
	
	public static ListNode reversedDoubleLinkedList(ListNode head)
	{
		if (head == null || head.next == null) return head;
		
		ListNode prev = null;
		ListNode ptr = head;
		
		while(ptr != null)
		{
			ListNode temp = ptr.next;
			ptr.next = prev;
			if (prev != null)
			{
				prev.prev = ptr;
			}
			prev = ptr;
			ptr = temp;
		}
		
		return prev;
	}
	
	public static boolean checkCircular(ListNode head)
	{
		if (head == null || head.next == null) return false;
		
		ListNode original_head = head;
		ListNode ptr = head;
		
		while(ptr != null)
		{
			if(ptr.next == original_head) return true;
			ptr = ptr.next;
		}
		
		return false;
	}
}	
