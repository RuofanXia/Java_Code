package Lab3;

public class GenArrayQueue<T> {
	
	private T[] queue;
	private static int DEFAULT_SIZE = 100;
	private int lastSpot = -1;
	private int headSpot = -1;
	
	public GenArrayQueue()
	{
		queue = (T[]) new Object[DEFAULT_SIZE];
	}
	
	public GenArrayQueue(int t_size)
	{
		DEFAULT_SIZE = t_size;
		queue = (T[]) new Object[t_size];
	}
	
	public void enqueue(T val)
	{
		if (lastSpot + 1 < DEFAULT_SIZE)
		{
			if (headSpot == -1)
			{
				headSpot = 0;
			}
			queue[lastSpot + 1] = val;
			lastSpot++;
		}
		else if (headSpot > 0)
		{
			queue[headSpot - 1] = val;
			headSpot--;
		}
		else
		{
			System.out.println("queue is full!");
			System.exit(0);
		}
	}
	
	public T dequeue()
	{
		T rv = null;
		if (headSpot >=0 && headSpot < DEFAULT_SIZE)
		{
			rv = queue[headSpot];
			//remove the first
			headSpot++;
		}
		
		return rv;
	}
	
	public T peek()
	{
		T rv = null;
		if (headSpot >=0 && headSpot < DEFAULT_SIZE)
		{
			rv = queue[headSpot];
		}
		
		return rv;
	}
	
	public void showQueue()
	{
		while(headSpot <= lastSpot)
		{
			System.out.println(queue[headSpot]);
			headSpot++;
		}
	}
}
