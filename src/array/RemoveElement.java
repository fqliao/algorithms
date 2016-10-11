package array;

import java.util.Arrays;

public class RemoveElement {

	public static void main(String[] args) {
		int[] nums = {3,2,2,3};
		System.out.println(removeElement(nums, 3));
		System.out.println(Arrays.toString(nums));
	}
	
    public static int removeElement(int[] nums, int val) {
        int i = 0,k=0;
        while(i < nums.length )
        {
            if(nums[i] != val)
            {
                nums[k++] = nums[i];
            }
            i++;
        }
        return k;
    }
}
