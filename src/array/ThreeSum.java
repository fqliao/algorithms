package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int length = nums.length;
		if(length < 3) return result;
        Arrays.sort(nums);
        int i = 0;
        if(3*nums[0] > 0 || 3*nums[length-1] < 0){
        	return result;
        }
        while(i < length - 2) {
            if(nums[i] > 0  || (nums[i] == 0 && nums[i+1] > 0)) break;
            int j = i + 1;
            int k = length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                if(sum <= 0) while(nums[j] == nums[++j] && j < k);
                if(sum >= 0) while(nums[k] == nums[--k] && j < k);
            }
            while(nums[i] == nums[++i] && i < length - 2);
        }
        return result;
    }
    
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(nums));
	}

}
