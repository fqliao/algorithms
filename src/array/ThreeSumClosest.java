package array;

import java.util.Arrays;

public class ThreeSumClosest {
	
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        //对特殊情况做判断
        int min = nums[0]+nums[1]+nums[2], max = nums[n-3]+nums[n-2]+nums[n-1];
        if (target<=min) return min;
        if (target>=max) return max;
        //找到最大差距
        int c = max-target;
        int left=0, right=n-1;
        while (left<=right-2) {
            int l=left+1, r=right-1, cur=Integer.MAX_VALUE;
            while (l<=r) {
                int m = (l+r)/2;
                int t = nums[left]+nums[right]+nums[m]-target;
                if (t==0) return target;
                if (t>0) r = m-1;
                else l = m+1;
                if (Math.abs(t)<Math.abs(cur)) cur = t;
            }
            if (cur>0) right--;
            else left++;
            if (Math.abs(cur)<Math.abs(c)) c = cur;
        }
       return (target+c);
     }
    
	public static void main(String[] args) {
		int[] nums = {-1,2,1,-4};
		System.out.println(threeSumClosest(nums, 1));

	}

}
