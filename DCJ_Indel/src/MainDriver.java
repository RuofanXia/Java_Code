
import java.util.*;

public class MainDriver {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<List<Integer>>> all_data = PreProcessData.ReadInData();
		System.out.println();
		Set<Integer> set = PreProcessData.equalGene(all_data);
		if (all_data.size() < 2)
		{
			System.out.println("genomes number is smaller than 2!");
			System.exit(0);
		}
		ListNode[] linkedlist_ga = PreProcessData.convertLinkedList(all_data.get(0), set, 0);
		ListNode[] linkedlist_gb = PreProcessData.convertLinkedList(all_data.get(1), set, 1);
		
		for (int i=0; i<linkedlist_ga.length-1; i++)
		{
			ListNode tail =Components.retTail(linkedlist_ga[i]);
			tail.next = linkedlist_ga[i+1];
			linkedlist_ga[i+1].prev = tail;
		}
		
		for (int i=0; i<linkedlist_gb.length-1; i++)
		{
			ListNode tail = Components.retTail(linkedlist_gb[i]);
			tail.next = linkedlist_gb[i+1];
			linkedlist_ga[i+1].prev = tail;
		}
		
		//PreProcessData.printLinkedListWithLabel(linkedlist_ga[0]);
		//System.out.println("===================================");
		//PreProcessData.printLinkedListWithLabel(linkedlist_gb[0]);
		
		//get the component from these two linked list
		List<ListNode> component = Components.getAllComponent(linkedlist_ga[0], linkedlist_gb[0]);
		
		Components.validComponent(component);
		System.out.println(component.size());
		for (int i=0; i<component.size(); i++)
		{
			printLinkList(component.get(i));
			System.out.println("=========================");
		}
		
		
		
		/*
		Set<Integer> set = PreProcessData.equalGene(all_data);
		for (int i: set)
		{
			System.out.print(i + " ");
		}
		System.out.println();
		List<HashMap<Integer, int[]>> tables = PreProcessData.genearteTable(all_data.get(0), set);
		HashMap<Integer, int[]> order_tables = tables.get(0);
		HashMap<Integer, int[]> gene_tables = tables.get(1);
		
		for (Map.Entry<Integer, int[]> entry : order_tables.entrySet())
		{
			int[] entry_val = entry.getValue();
			System.out.println(entry.getKey() + ": " + entry_val[0] + " " + entry_val[1]);
		}
		
		System.out.println("================================");
		
		for (Map.Entry<Integer, int[]> entry : gene_tables.entrySet())
		{
			int[] entry_val = entry.getValue();
			System.out.println(entry.getKey() + ": " + entry_val[0] + " " + entry_val[1]);
		}
		*/
	}
	
	public static void printLinkList(ListNode head)
	{
		if (!Components.checkCircular(head))
		{
			ListNode ptr = head;
			while(ptr != null)
			{
				System.out.println("first: " + ptr.first + ", " + "second: " + ptr.second);
				if (ptr.label != null)
				{
					for (int i=0; i<ptr.label.length; i++)
					{
						System.out.print(ptr.label[i] + " ");
					}
					System.out.println();
				}
				ptr = ptr.next;
			}
		}
		//if the linklist is circle
		else
		{
			System.out.println("circle:");
			ListNode ptr = head;
			ListNode original_head = head;
			System.out.println("first: " + ptr.first + ", " + "second: " + ptr.second);
			ptr = ptr.next;
			while(ptr != original_head)
			{
				System.out.println("first: " + ptr.first + ", " + "second: " + ptr.second);
				ptr = ptr.next;
			}
		}
	}
}