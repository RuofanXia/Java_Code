public class IntDoubleLinkedListTester {

	public static void main(String[] args) {
		IntDoubleLinkedList list = new IntDoubleLinkedList();
		
		for(int i=0;i<10;i++) {
			list.insert(i);
		}
		
		list.showList();
		System.out.println();
		
		for(int i=0;i<4;i++) {
			list.goToNext();
		}
		
		list.insertNodeAfterCurrent(22);
		list.showList();
		System.out.println();
		
		list.resetIteration();	
		
		for(int i=0;i<6;i++) {
			list.goToNext();
		}
		
		list.showList();
		System.out.println();
		
		for (int i = 0; i<2; i++) {
			list.goToPrevious();
		}
		
		list.insertNodeAfterCurrent(33);
		list.showList();
		System.out.println();
		list.setDataAtCurrent(49);
		list.showList();
		System.out.println();
		System.out.println(list.getDataAtCurrent());
		System.out.println();
		list.deleteCurrentNode();
		
		System.out.println("Is 33 in the list now? " + list.inList(33));
		System.out.println();
		System.out.println("6 in the list? " + list.inList(6));
		System.out.println("19 in the list? " + list.inList(19));
		
	}
}

