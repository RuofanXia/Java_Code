package Amz;

public class MyStack<T> {
	static class StackNode<T>{
		private StackNode<T> next;
		private T val;
		public StackNode(T x)
		{
			this.next = null;
			this.val = x;
		}
	}
	
	private StackNode<T> top;
	
	public MyStack()
	{
		top = null;
	}
	
	public void push(StackNode<T> node)
	{
		if (top == null)
		{
			top = node;
		}
		else
		{
			node.next = top;
			top = node;
		}
	}
	
	public T pop()
	{
		if (top == null) return null;
		StackNode<T> ret = top;
		top = top.next;
		
		return ret.val;
	}
	
	public T peek()
	{
		return top.val;
	}
	
	public boolean isEmpty()
	{
		return top == null;
	}
}
