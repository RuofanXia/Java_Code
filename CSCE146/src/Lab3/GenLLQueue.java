package Lab3;

public class GenLLQueue<T> {
	
	class ListNode{
		private T data;
		private ListNode link;
		public ListNode(){
			this.data = null;
			this.link = null;
		}
	}
	
	private ListNode head;
	private ListNode tail;
	
	public GenLLQueue(){
		this.head = null;
		this.tail = null;
	}
	
	public void enqueue(T val)
	{
		ListNode newNode = new ListNode();
		newNode.data = val;

		if(head == null)
		{
			head = newNode;
			tail = newNode;
		}
		else
		{
			tail.link = newNode;
			tail = newNode;
		}
	}
	
	public T dequeue()
	{
		if (head != null)
		{
			T val = head.data;
			head = head.link;
			return val;
		}
		return null;
	}
	
	public T peek()
	{
		if (head != null)
		{
			return head.data;
		}
		return null;
	}
	
	public void showQueue()
	{
		ListNode position = head;
		while (position != null)
		{
			System.out.println(position.data);
			position = position.link;
		}
	}
}
