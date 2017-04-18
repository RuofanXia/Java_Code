package Lab2;

public class GenDoubleLinkedList {
	//internal class
	class ListNode{ 
		int data;
		ListNode nextLink;
		ListNode prevLink;
		
		public ListNode()
		{
			this.data = 0;
			this.nextLink = null;
			this.prevLink = null;
		}
		
		public ListNode(int data, ListNode nextLink, ListNode prevLink)
		{
			this.data = data;
			this.nextLink = nextLink;
			this.prevLink = prevLink;
		}
	}
	
	ListNode head;
	ListNode current;
	
	public GenDoubleLinkedList()
	{
		this.head = null;
		this.current = this.head;
	}
	
	public void goToNext()
	{
		if (current.nextLink != null)
		{
			current = current.nextLink;
		}
	}
	
	public void goToPrev()
	{
		if (current.prevLink != null)
		{
			current = current.prevLink;
		}
	}
	
	int getDataAtCurrent()
	{
		if (current != null)
		{
			return current.data;
		}
		else
		{
			System.out.println("current node is null!");
			return 0;
		}
	}
	
	void setDataAtCurrent(int newData)
	{
		if (current != null)
		{
			current.data = newData;
		}
		else
		{
			System.out.println("current node is null!");
		}
	}
	
	void insertNodeAfterCurrent(int data)
	{
		//create new node
		ListNode nNode = new ListNode(data, null, null);
		if (current != null)
		{
			ListNode tempNode = current.nextLink;
			nNode.nextLink = tempNode;
			if (tempNode != null)
				tempNode.prevLink = nNode;
			nNode.prevLink = current;
			current.nextLink = nNode;
		} else if (head != null)
		{
			System.out.println("current is null!");
			System.exit(0);
		}
		else
		{
			System.out.println("empty linked list");
			System.exit(0);
		}
	}
	
	public void insert(int addData)
	{
		ListNode newNode = new ListNode();
		newNode.data = addData;
		if (head == null)
		{
			head = newNode;
			current = head;
			return;
		}
		ListNode position = head;
		ListNode prevPos = null;
		while (position != null)
		{
			prevPos = position;
			position = position.nextLink;
		}
		
		position = newNode;
		prevPos.nextLink = position;
		newNode.prevLink = prevPos;
	}
	
	void deleteCurrentNode()
	{
		ListNode nextNode = current.nextLink;
		ListNode prevNode = current.prevLink;
		if (prevNode == null && nextNode != null)
		{
			head.nextLink = nextNode;
			nextNode.prevLink = head;
			current = nextNode;
		}
		
		else if (prevNode != null && nextNode == null)
		{
			prevNode.nextLink = null;
			current = prevNode;
		}
		else if(prevNode == null && nextNode == null){
			head = null;
			current = null;
		}
		else
		{
			prevNode.nextLink = nextNode;
			nextNode.prevLink = prevNode;
		}
	}
	
	void showList()
	{
		ListNode temp = head;
		while(head != null)
		{
			System.out.println("data: " + head.data);
			head = head.nextLink;
		}
		head = temp;
	}
	
	boolean inList(int data)
	{
		ListNode temp = head;
		while (head != null)
		{
			if (head.data == data)
			{
				head = temp;
				return true;
			}
			head = head.nextLink;
		}
		head = temp;
		return false;
	}
}
