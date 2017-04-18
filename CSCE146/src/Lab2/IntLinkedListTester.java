package Lab2;

public class IntLinkedListTester {
	public static void main (String[] args)
	{
		GenDoubleLinkedList list = new GenDoubleLinkedList();
		
		for (int i=0; i<10; i++)
		{
			list.insert(i);
		}
		
		list.showList();
		System.out.println();
		
		for (int i=0; i<4; i++)
		{
			list.goToNext();
		}
		
		list.insertNodeAfterCurrent(22);
		list.showList();
		System.out.println();
		
		for (int i=0; i<6; i++)
		{
			list.goToNext();
		}
		list.deleteCurrentNode();
		list.showList();
	}
}
