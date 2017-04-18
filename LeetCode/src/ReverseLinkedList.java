import java.util.Stack;


public class ReverseLinkedList {
	ListNode head;
	class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	public void addList(){
		head = new ListNode(1);
		head.next = new ListNode(2);
	}
	public ListNode reverseList() {
        Stack<ListNode> stack = new Stack<ListNode>();
        if (head == null || head.next == null) return head;
        while (head != null)
        {
            stack.push(head);
            head = head.next;
        }
        ListNode retHead = null;
        ListNode pointer = null;
        if (!stack.empty()) pointer = stack.pop();
        retHead = pointer;
        while(!stack.empty())
        {
            pointer.next = stack.pop();
            //System.out.println(pointer.next.val);
            pointer = pointer.next;
            pointer.next = null;
        }
        while(retHead != null)
        {
        	System.out.println(retHead.val);
        	retHead = retHead.next;
        	
        }
        return retHead;
    }
	
	public static void main(String args[])
	{
		ReverseLinkedList rll = new ReverseLinkedList();
		rll.addList();
		rll.reverseList();
	}
}
