
public class nextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,5,3,4 };
		nextPermutation(nums);
	}
	
	public static void nextPermutation(int[] nums) {
	    if(nums == null || nums.length<2)
	        return;
	 
	    int p=0;            
	    for(int i=nums.length-2; i>=0; i--){
	        if(nums[i]<nums[i+1]){
	            p=i;
	            break;
	        }    
	    }
	 
	    int q = 0;
	    for(int i=nums.length-1; i>p; i--){
	        if(nums[i]> nums[p]){
	            q=i;
	            break;
	        }    
	    }
	    
	    System.out.println(p);
	    System.out.println(q);
	 
	    if(p==0 && q==0){
	        reverse(nums, 0, nums.length-1);
	        return;
	    }
	 
	    int temp=nums[p];
	    nums[p]=nums[q];
	    nums[q]=temp;
	 
	    if(p<nums.length-1){
	        reverse(nums, p+1, nums.length-1);
	    }
	}
	 
	public static void reverse(int[] nums, int left, int right){
	    while(left<right){
	        int temp = nums[left];
	        nums[left]=nums[right];
	        nums[right]=temp;
	        left++;
	        right--;
	    }
	}
}
