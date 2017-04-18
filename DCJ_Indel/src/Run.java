
public class Run {
	Run next;
	ListNode first;
	ListNode last;
	public Run(ListNode first, ListNode last)
	{
		this.first = first;
		this.last = last;
		next = null;
	}
}
