
public class ReverseLLDirectly {
	ListNode head;
	class ListNode{
		int data;
		ListNode next;
		ListNode(int data)
		{
			this.data = data;
		}
	}
	
	public void addNode(int data)
	{
		ListNode node = new ListNode(data);
		node.next = null;
		if (head == null) {head = node; return;}
		ListNode saveHead = head;
		while(head.next != null)
		{
			head = head.next;
		}
		head.next = node;
		head = saveHead;
	}
	
	public void reverse()
	{
		if (head == null || head.next == null) return;
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = null;
		while(head != null)
		{
			ListNode head_next = head.next;
			ListNode fakeNext = fakeHead.next;
			fakeHead.next = head;
			head.next = fakeNext;
			head = head_next;
		}
		
		head = fakeHead.next;
	}
	
	public void printll()
	{
		ListNode original_head = head;
		while(head != null)
		{
			System.out.println(head.data);
			head = head.next;
		}
		//reset the head
		head = original_head;
	}
}
