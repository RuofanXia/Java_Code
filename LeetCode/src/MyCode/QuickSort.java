package MyCode;

import java.util.Arrays;

public class QuickSort {
	
	public static void QuickSortRecursively(int[] nums, int start, int end)
	{
		if (nums == null || nums.length == 0) return;
		if (start >= end) return;
		int middle = start + (end - start) / 2;
		int pivot = nums[middle];
		
		int left = start, right = end;
		
		while (left <= right)
		{
			while (nums[left] < pivot)
				left++;
			while (nums[right] > pivot)
				right--;
			if (left <= right)
			{
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
				left++;
				right--;
			}
			
			if (start < right)
				QuickSortRecursively(nums, start, right);
			if (left < end)
				QuickSortRecursively(nums, left, end);
				
		}
	}
	
	public static void main(String[] args)
	{
		int[] nums = {9,6,3,1,4,6,8,2,5};
		System.out.println(Arrays.toString(nums));
		QuickSortRecursively(nums, 0, nums.length-1);
		System.out.println(Arrays.toString(nums));
	}
}
