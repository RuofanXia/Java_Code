package Amz_OA2;

public class reverseSecondHalf {
	
	public static ListNode solution(ListNode head)
	{
		ListNode fake = new ListNode(0);
		fake.next = head;
		
		//find the middle point
		ListNode fast = fake;
		ListNode slow = fake;
		
		while(fast.next != null && fast.next.next != null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}
		
		ListNode secondHalf = slow.next;
		
		//reverse the second half
		ListNode prev = null;
		ListNode ptr = secondHalf;
		
		while(ptr != null)
		{
			ListNode temp = ptr.next;
			ptr.next = prev;
			prev = ptr;
			ptr = temp;
		}
		
		slow.next = prev;
		
		return head;
	}
	
	
	public static ListNode solution2(ListNode head)
	{
		if (head == null || head.next == null) return head;
		
		ListNode fakeHead = new ListNode(0);
		
		fakeHead.next = head;
		
		ListNode slow = fakeHead, fast = fakeHead;
		
		while(fast.next != null && fast.next.next != null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}
		
		ListNode secondHalf = slow.next;
		
		//reverse the second half list
		
		ListNode prev = null;
		
		ListNode ptr = secondHalf;
		
		while(ptr != null)
		{
			ListNode temp = ptr.next;
			ptr.next = prev;
			prev = ptr;
			ptr = temp;
		}
		
		slow.next = prev;
		
		return head;
	}
	
	public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode res = solution2(head);
		
		while(res!=null)
		{
			System.out.println(res.val);
			res = res.next;
		}
	}
}
