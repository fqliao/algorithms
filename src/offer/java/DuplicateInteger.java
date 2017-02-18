package offer.java;

import java.util.Arrays;

public class DuplicateInteger {

	public static void main(String[] args) {
		int[] nums = {3,4,3,2,-1,3,3,3};
		int j = judge(nums);
		if(j == -1){
			System.out.println("No dominator");
		}
		else{
			System.out.println("Dominator:"+nums[j]);
		}

	}
	
	public static int judge(int[] nums){
		if(nums == null){
			return -1;
		}
		Arrays.sort(nums);
		int counter = 1;
		for(int i = 0; i < nums.length-1; i++){
			if(nums[i] == nums[i+1]){           
				counter++;
				if((double)counter / nums.length > 0.5){
					return i;
				}
			}
			else{
				counter = 1;
			}
		}
		return -1;
	}

}
