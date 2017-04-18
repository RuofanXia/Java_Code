
public class WiggleSeq {
	
	public static int wiggleMaxLength(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) return nums.length;
        
        int res = 1;
        
        int start = 0;
        
        while(start < nums.length && nums[start] == nums[0])
        {
            start++;
        }
        
        int diff = nums[start] - nums[0];
        
        if (start == 0) return res;
        else res = 2;
        
        int prev = nums[start];
        
        for (int i=start+1; i<nums.length; i++)
        {
            if (diff>0)
            {
                if (nums[i]<prev)
                {
                    res++;
                    prev = nums[i];
                    diff = nums[i] - prev;
                }
                else if (nums[i] > prev)
                {
                    prev = nums[i];
                }
            }
            else 
            {
                if (nums[i] > prev)
                {
                    res++;
                    prev = nums[i];
                    diff = nums[i] - prev;
                }
                else if (nums[i] < prev)
                {
                    prev = nums[i];
                }
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {2,1,4,5,6,3,3,4,8,4};
		System.out.println(wiggleMaxLength(data));
	}

}
