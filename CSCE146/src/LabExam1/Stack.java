package LabExam1;

public class Stack<T> {
	private Node<T> head = null;
	class Node<E>{
		E data;
		Node<E> next;
		Node(E data){
			this.data = data;
			this.next = null;
		}
	}
	
	/* check if the stack is empty*/
	public boolean isEmpty(){
		if (head != null)
		{
			return false;
		}
		return true;
	}
	
	/*push method*/
	public void push(T newElement){
		//new object holds new element val 
		//find the last element, then append after it.
		Node<T> newNode = new Node<T>(newElement);
		//case 1: if head is null, stack is empty, then head = new element
		if (head == null)
		{
			head = newNode;
			return;
		}
		//otherwise
		Node<T> ptr = head;
		while(ptr.next != null)
		{
			ptr = ptr.next;
		}
		ptr.next = newNode;
	}
	
	/*pop method*/
	public T pop(){
		//case 1: if head is null return null;
		if (head == null)
		{
			return null;
		}
		else if (head.next == null)
		{
			T val = (T)head.data;
			head = null;
			return val;
		}
		//otherwise
		Node<T> ptr = head;
		
		while (ptr.next.next != null)
		{
			ptr = ptr.next;
		}
		
		T val = (T) ptr.next.data;
		ptr.next = null;
		return val;
	}
	
	/*show the stack*/
	public void show(){

		Node<T> pos = head;
		while (pos != null)
		{
			System.out.println(pos.data);
			pos = pos.next;
		}
		
	}
}
