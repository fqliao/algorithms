package array;

import java.util.Arrays;

public class MoveZeroes {
	public static void main(String[] args) {
		int[] A = {0,1,0,3,12};
		int[] moveZeroes = moveZeroes(A);
		System.out.println(Arrays.toString(moveZeroes));
	}
	
    public static int[] moveZeroes(int[] nums) {
    	int j = 0;
    	for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) 
			{
				nums[j++] = nums[i];
			}
		}
    	Arrays.fill(nums, j, nums.length, 0);
    	return nums;
    }
}
