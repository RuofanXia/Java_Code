
public class minHeap {
	int[] list;
	public minHeap(){
		list = new int[100];
		for (int i=0; i<100; i++)
		{
			list[i] = -1;
		}
	}
	
	public void insert(int val)
	{
		int index = 0;
		for (int i=1; i<100; i++)
		{
			if (list[i] == -1)
			{
				//find the available position
				index = i;
				list[i] = val;
				break;
			}
		}
		//compare the new value with its parent
		while(index/2>0)
		{
			//get parent value
			int parent = list[index/2] ;
			if (val<parent)
			{
				//swap
				list[index/2] = val;
				list[index] = parent;
			}
			else
			{
				break;
			}
			index = index/2;
		}
	}
	
	public void printHeap()
	{
		for(int i=1; i<100; i++)
		{
			if (list[i] != -1)
			{
				System.out.println(list[i]);
			}
		}
	}
	
	public void heapSort()
	{
		//copy the original array
		int t_array[] = new int[list.length];
		for (int i=0; i<list.length; i++)
		{
			t_array[i] = list[i];
		}
		
		while(t_array[1] != -1)
		{
			System.out.println(t_array[1]);
			//get he last val's index
			int index=0;
			for (int i=1; i<100; i++)
			{
				if (t_array[i] == -1)
				{
					index = i-1;
					break;
				}
			}
			t_array[1] = t_array[index];
			t_array[index] = -1;
			//heapify the new array
			int j=1;
			while(((t_array[j] > t_array[2*j]) &&(t_array[2*j]!=-1)) || ((t_array[j] > t_array[2*j+1])&&(t_array[2*j+1])!=-1))
			{
				if ((t_array[2*j]!=-1) && (t_array[2*j+1]) !=-1)
				{
					//find the relative smaller one of the two children
					if (t_array[2*j]>t_array[2*j+1])
					{
						//swap the smaller one with the parent
						int temp = t_array[2*j+1];
						t_array[2*j+1] = t_array[j];
						t_array[j] = temp;
						j = 2*j+1;
					}
					else
					{
						int temp = t_array[2*j];
						t_array[2*j] = t_array[j];
						t_array[j] = temp;
						j = 2*j;
					}
				}
				else if(t_array[2*j]!=-1)
				{
					int temp = t_array[2*j];
					t_array[2*j] = t_array[j];
					t_array[j] = temp;
					j = 2*j;
				}
				else 
				{
					int temp = t_array[2*j+1];
					t_array[2*j+1] = t_array[j];
					t_array[j] = temp;
					j = 2*j+1;
				}
			}
			
		}
	}
	
	public void remove()
	{
		//get he last val's index
		int index=0;
		for (int i=1; i<100; i++)
		{
			if (list[i] == -1)
			{
				index = i-1;
				break;
			}
		}
		list[1] = list[index];
		list[index] = -1;
		//heapify the new array
		int j=1;
		while(((list[j] > list[2*j]) &&(list[2*j]!=-1)) || ((list[j] > list[2*j+1])&&(list[2*j+1])!=-1))
		{
			if ((list[2*j]!=-1) && (list[2*j+1]) !=-1)
			{
				//find the relative smaller one of the two children
				if (list[2*j]>list[2*j+1])
				{
					//swap the smaller one with the parent
					int temp = list[2*j+1];
					list[2*j+1] = list[j];
					list[j] = temp;
					j = 2*j+1;
				}
				else
				{
					int temp = list[2*j];
					list[2*j] = list[j];
					list[j] = temp;
					j = 2*j;
				}
			}
			else if(list[2*j]!=-1)
			{
				int temp = list[2*j];
				list[2*j] = list[j];
				list[j] = temp;
				j = 2*j;
			}
			else 
			{
				int temp = list[2*j+1];
				list[2*j+1] = list[j];
				list[j] = temp;
				j = 2*j+1;
			}
		}
	}
	
	public static void main(String[] args)
	{
		minHeap mh = new minHeap();
		int[] data = {21,37,49,11,23,1,13,16,33,17};
		for (int i=0; i<data.length; i++)
		{
			mh.insert(data[i]);
		}
		System.out.println("Printing Heap");
		mh.printHeap();
		System.out.println("Testing heap sort");
		mh.heapSort();
		System.out.println("Removing an element from the heap");
		mh.remove();
		System.out.println("The element removed and heap now is");
		mh.printHeap();
	}
}
