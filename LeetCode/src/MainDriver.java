import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainDriver {
	
	//subarray sum equals to target leetcode
	
	
	/*No_1*/
	public static int[] twoSum(int[] data, int target)
	{
		int[] indices = new int[2];
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (int i=0; i<data.length; i++)
		{
			int current = target - data[i];
			if (hashMap.containsKey(current))
			{
				indices[0] = hashMap.get(current);
				indices[1] = i;
				return indices;
			}
			else
			{
				hashMap.put(data[i], i);
			}
		}
		return indices;
	}
	
	/*
	 * No 61 Rotate List
	 * Given a list, rotate the list to the right by k places, where k is non-negative.
	 * For example:
	 * Given 1->2->3->4->5->NULL and k = 2,
	 * return 4->5->1->2->3->NULL.
	 */
	
	public static ListNode RotateList(ListNode head, int k)
	{
		int len = 0;
		ListNode ptr = head;
		while(ptr!=null)
		{
			len++;
			ptr = ptr.next;
		}
		if (len == 0) return head;
		k = k % len;
		if (k == 0) return head;
		ListNode second_ptr = head;
		
		while(k>0)
		{
			second_ptr = second_ptr.next;
			k--;
		}
		
		ListNode first_ptr = head;
		
		while(second_ptr.next!=null)
		{
			second_ptr = second_ptr.next;
			first_ptr = first_ptr.next;
		}
		
		ListNode ret = first_ptr.next;
		first_ptr.next = null;
		second_ptr.next = head;
		
		return ret;
	}
	
	/*
	 * No_75 Sort Color
	 */
	
	public static void sortColor(int[] nums)
	{
		int[] colors = new int[3];
		for (int num : nums)
		{
			colors[num]++;
		}
		
		int i = 0;
		for (int j=0; j<3; j++)
		{
			while(colors[j]-->0)
			{
				nums[i++] = j;
			}
		}
	}
	
	/* No. 82. Remove Duplicates from Sorted List II
	 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
	 * For example,
	 * Given 1->2->3->3->4->4->5, return 1->2->5.
	 * Given 1->1->1->2->3, return 2->3.
	 */
	
	public static ListNode Remove_duplicate_II(ListNode head)
	{
		if (head == null || head.next == null) return head;
		
		ListNode dummy = new ListNode(0);
		ListNode ptr = dummy;
		ListNode prev_node = head;
		ListNode current_node = head.next;
		int cnt = 0;
		
		while(current_node != null)
		{
			if (current_node.val == prev_node.val)
			{
				cnt++;
				current_node = current_node.next;
			}
			else 
			{
				if (cnt == 0)
				{
					ptr.next = prev_node;
					ptr = ptr.next;
					prev_node = current_node;
					current_node = current_node.next;
				}
				else
				{
					prev_node = current_node;
					cnt = 0;
					current_node = current_node.next;
				}
			}
				
		}
		
		if (cnt != 0)
		{
			ptr.next = null;
		}
		else
		{
			ptr.next = prev_node;
		}
		
		return dummy.next;
	}
	
	/**
	 * No 83
	 * @param head
	 * @return
	 */
	public static ListNode Remove_duplicate(ListNode head)
	{
		if (head == null || head.next == null) return head;
		
		ListNode sorted_ptr = head;
		ListNode move_ptr = head.next;
		
		while(move_ptr != null)
		{
			if (sorted_ptr.val != move_ptr.val)
			{
				sorted_ptr.next = move_ptr;
				sorted_ptr = sorted_ptr.next;
				move_ptr = move_ptr.next;
			}
			else
			{
				move_ptr = move_ptr.next;
			}
		}
		
		if (sorted_ptr.next != null)
		{
			sorted_ptr.next = null;
		}
		
		return head;
	}
	
	/*
	 * No 86. Partition List
	 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
	 * You should preserve the original relative order of the nodes in each of the two partitions.
	 * For example,
	 * Given 1->4->3->2->5->2 and x = 3,
	 * return 1->2->2->4->3->5.
	 */
	
	/*
    public static ListNode Partition_List(ListNode head, int x)
    {
    	if (head == null || head.next == null) return head;
    	
    	ListNode les_head = new ListNode(0);
    	ListNode les_ptr = les_head;
    	ListNode grt_head = new ListNode(1);
    	ListNode grt_ptr = grt_head;
    }
    */
	
	/*
	 * No_118. Pascal's Triangle
	 */
	
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        for (int i=0; i<numRows; i++)
        {
        	List<Integer> list = new ArrayList<Integer>();
        	for (int j=0; j<i+1; j++)
    		{
    			if (j == 0 || j == i)
    			{
    				list.add(1);
    			}
    			else
    			{
    				//get the previous
    				List<Integer> prev = res.get(i-1);
    				list.add(prev.get(j) + prev.get(j-1));
    			}
    		}
        	res.add(list);
        }
        
        return res;
    }
	
	/*
	 * No 136 Single Number
	 */
	
	public static int Single_Number(int[] nums)
	{
		Set<Integer> hashset = new HashSet<Integer>();
		for (int i=0; i<nums.length; i++)
		{
			if (!hashset.add(nums[i]))
				hashset.remove(nums[i]);
		}
		
		return hashset.iterator().next();
	}
	
	/*No_167
	 * input array is sorted
	 * two pointer O(n)
	 * binary search O(nlgn)
	 */
	//method 1 : two pointer
	public static int[] twoSum_II(int[] data, int target)
	{
		int i = 0, j = data.length-1;
		int[] res = new int[2];
		while(i < j)
		{
			if (data[i] + data[j] < target)
			{
				i++;
			}
			else if(data[i] + data[j] > target)
			{
				j--;
			}
			else
			{
				res[0] = i+1;
				res[1] = j+1;
				return res;
			}
		}
		
		return res;
	}
	
	//method 2 : binary search
	public static int[] twoSum_II_BS(int[] numbers, int target)
	{
		int[] res = new int[2];
		for (int i=0; i<numbers.length; i++)
		{
			int index = bs_helper(numbers, target - numbers[i]);
			if (index != i && index != -1)
			{
				if (i < index)
				{
					res[0] = i+1;
					res[1] = index+1;
				}
				else
				{
					res[0] = index+1;
					res[1] = i+1;
				}
				
				return res;
			}
		}
		
		return res;
	}
	
	private static int bs_helper(int[] numbers, int target)
	{
		int i = 0, j = numbers.length-1;
		while(i <= j)
		{
			int mid_index = i + (j-i) / 2;
			int mid = numbers[mid_index];
			if (mid < target)
			{
				i = mid_index + 1;
			}
			else if (mid > target)
			{
				j = mid_index - 1;
			}
			else
			{
				return mid_index;
			}
		}
		return -1;
	}
	
	/*
	 * No.217. Contains Duplicate
	 */
	
	public static boolean Contain_Duplicate(int[] nums)
	{
		Set<Integer> set = new HashSet<Integer>();
		for (int i : nums)
		{
			if (!set.add(i)) return true;
			//hashset add remove, contains all cost O(1)
		}
		//for each is better than for loop?
		return false;
	}
	
	/*
	 * 223. Rectangle Area
	 */
	
	public static int ReactangleArea(int A, int B, int C, int D, int E, int F, int G, int H)
	{
		int overlap = 0;
		if (F > D || B > H || E > C || A > G) overlap = 0;
		else
		{
			int left_x = Math.max(A, E);
			int left_y = Math.max(B, F);
			int top_x = Math.min(C, G);
			int top_y = Math.min(D, H);
			
			overlap = (top_x - left_x) * (top_y - left_y);
		}
		
		
		return (C-A)*(D-B) + (G-E)*(H-F) - overlap;
	}
	
	/*
	 * No_283 Move Zeroes
	 *  two pointer
	 *  
	 */
	
	public static void Move_Zeros(int[] numbers)
	{
		int i = 0, j = 0;
		while(j < numbers.length)
		{
			if (numbers[j] == 0)
			{
				j++;
			}
			else
			{
				numbers[i++] = numbers[j++];
			}
		}
		
		while(i < numbers.length)
		{
			numbers[i++] = 0;
		}
	}
	
	/* 328. Odd Even Linked List
	 * Given a singly linked list, group all odd nodes together followed by the even nodes. 
	 * Please note here we are talking about the node number and not the value in the nodes.
	 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
	 * Example:
	 * Given 1->2->3->4->5->NULL,
	 * return 1->3->5->2->4->NULL.
	 */
	
	public static ListNode Odd_Even_LinkList(ListNode head)
	{
		if (head == null || head.next == null || head.next.next == null) return head;
		
		ListNode ptr = head;
		ListNode odd_head = new ListNode(1);
		ListNode odd_ptr = odd_head;
		ListNode even_head = new ListNode(2);
		ListNode even_ptr = even_head;
		while(ptr.next != null && ptr.next.next != null)
		{
			ListNode temp = ptr.next.next;
			odd_ptr.next = ptr;
			odd_ptr = odd_ptr.next;
			even_ptr.next = ptr.next;
			even_ptr = even_ptr.next;
			ptr = temp;
		}
		
		if (ptr.next == null)
		{
			odd_ptr.next = ptr;
			odd_ptr = odd_ptr.next;
			even_ptr.next = null;
		}	
		else
		{
			odd_ptr.next = ptr;
			ptr = ptr.next;
			odd_ptr = odd_ptr.next;
			even_ptr.next = ptr;
			even_ptr = even_ptr.next;
		}
		odd_ptr.next = even_head.next;
		
		return odd_head.next;
	}
	
	/*largest first two val*/
	public static void FirstTwoLargest(int[] nums)
	{
		int largest = 0;
		int second_largest = 0;
		for (int i=0; i<nums.length; i++)
		{
			if (nums[i] > largest)
			{
				second_largest = largest;
				largest = nums[i];
			}	
		}
		
		System.out.println(largest);
		System.out.println(second_largest);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int[] testCase = {1,2,3,4,4,9,56,90};
		int[] res = twoSum_II_BS(testCase, 8);
		for (int i=0; i<res.length; i++)
		{
			System.out.println(res[i]);
		}
		*/
		/*
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		*/
		int[] testCase = {1,2,3,4,4,9,56,90};
		//System.out.println(ReactangleArea(-2, -2, 2, 2, 3, 3, 4, 4));
		FirstTwoLargest(testCase);
	}

}
