package Amz;


public class reverseSecondHalf {
	
	public static ListNode solution(ListNode head)
	{
		if (head == null || head.next == null) return head;
		
		//find the middle point of the list
		ListNode fake = new ListNode(0);
		fake.next = head;
		
		ListNode fast = fake, slow = fake;
		
		while (fast.next != null && fast.next.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode secondHalf = slow.next;
		
		ListNode prev = null;
		ListNode ptr = secondHalf;
		
		while (ptr != null)
		{
			ListNode temp = ptr.next;
			ptr.next = prev;
			prev = ptr;
			ptr = temp;
		}
		
		slow.next = prev;
		
		return fake.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		ListNode res = solution(head);
		
		while(res!=null)
		{
			System.out.println(res.val);
			res = res.next;
		}
	}

}
