
public class ListNode {
	ListNode next;
	ListNode prev;
	int first;
	int second;
	int[] label; 
	int tag;	// 0-genome A, 1-genome B
	int visited; // 0-not visited, 1-visited first, 2-visited second, 3-visited both
	public ListNode(int first, int second, int tag, int visited)
	{
		this.first = first;
		this.second = second;
		this.tag = tag;
		this.visited = visited;
	}
	public ListNode(int first, int second, int tag, int[] label, int visited)
	{
		this.first = first;
		this.second = second;
		this.tag = tag;
		this.label = new int[label.length];
		for (int i=0; i<label.length; i++)
		{
			this.label[i] = label[i];
		}
		this.visited = visited;
	}
}
