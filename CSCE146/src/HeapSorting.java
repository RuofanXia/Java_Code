
public class HeapSorting {
public static final int DEFAULT_SIZE=100;
private int[] heap;
private int size;

	public HeapSorting()
	{
		heap=new int[DEFAULT_SIZE];
		size=0;
		for(int i=0; i<heap.length;i++)
		{
			heap[i]=-1;
		}
	}
	
	public HeapSorting(int length)
	{
		if(length>0)
		{
			heap=new int[length];
			size=0;
		}
	}
	
	public void Insert(int value)
	{
		if(size>=heap.length)
		{
			System.out.println("Heap is full");
			return;
		}
		heap[size]=value;
		//bubble up
		bubbleUp();
		size++;
	}
	
	private void bubbleUp()
	{
		int index=this.size;
		while(index>0)
		{
			int parentIndex = index%2!=0?(index-1)/2:(index-2)/2;
			if(parentIndex>=0&&heap[index]<heap[parentIndex])
			{
				//out of order
				int temp=heap[parentIndex];
				heap[parentIndex]=heap[index];
				heap[index]=temp;
			}
			else
			{
				break;
			}
			index=parentIndex;
		}
	}
	public int peek()
	{
		if(heap==null)
		{
			return -1;
		}
		return heap[0];	
	}
	
	public int delete()
	{
		int retVal=peek();
		heap[0]=heap[size-1];
//		System.out.println(heap[size-1]+" ##");
		heap[size-1]=-1;
		
		//bubble down
		size--;
		bubbleDown();
		
		return retVal;
	}
	
	private void bubbleDown()
	{
		int index=0;
		while(index*2+1<size)
		{
			int smallIndex=index*2+1;//assume left is smaller
			if(index*2+2<size && heap[index*2+1]>heap[index*2+2])
			{
				smallIndex=index*2+2;//right is smaller
			}
			
			if(heap[index]>heap[smallIndex])
			{
				int temp=heap[index];
				heap[index]=heap[smallIndex];
				heap[smallIndex]=temp;
			}
			
			else
			{
				break;
			}
			
			index=smallIndex;
		}
	}
	public void print()
	{
		for(int val:heap)
		{
			if(val==-1)
			{
				break;
			}
			System.out.println(val);
		}
	}
	public void heapSort()
	{
		HeapSorting tempHeap = new HeapSorting();
		int[]cloneHeap=heap.clone();
		for(int i=0;i<size;i++)
		{
			tempHeap.Insert(cloneHeap[i]);
		}
		
		for(int i=size; i>0; i--)
		{
			System.out.println(tempHeap.delete());
		}
	}
	
	public static void main(String[] args)
	{
		HeapSorting mh = new HeapSorting();
		int[] data = {21,37,49,11,23,1,13,16,33,17};
		for (int i=0; i<data.length; i++)
		{
			mh.Insert(data[i]);
		}
		System.out.println("Printing Heap");
		mh.print();
		System.out.println("Testing heap sort");
		mh.heapSort();
		System.out.println("Removing an element from the heap");
		mh.delete();
		System.out.println("The element removed and heap now is");
		mh.print();
	}
	
}
