package StudentLabExam1;
//char ArrayStack
//Chance Reynolds
//Lab Exam 1

//This class brought to you by Don Landrum
public class ArrayStack <T> {
	public static final int DEFAULT_SIZE = 100;
	public T[] stack;
	int headIndex; //points to last inserted element, NOT first empty element
	public ArrayStack(){//default constructor of size 100
		this.stack = (T[]) new Object[DEFAULT_SIZE]; //this is typecasting
		this.headIndex = 0;
	}
	public void push(T aData){
		if(headIndex+1>=stack.length){//if the stack is full
			System.out.println("Cannot be added. Stack is full.");
			return;
		}
		if(stack[0] == null){//if the stack is empty
			stack[0] = aData;
			return;
		}
		headIndex++;//if the stack is not empty
		stack[headIndex] = aData;
	}
	public T pop(){
		T aPop = stack[headIndex];//copies the object at the head
		stack[headIndex] = null;//sets the object at the head to null
		headIndex--;//moves the head back one space
		if(headIndex<0){//unless the head was already at index 0
			headIndex = 0;
		}
		return aPop;
	}
}