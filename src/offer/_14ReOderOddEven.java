package offer;

import java.util.Arrays;

/**
 * @decription:将数组中的奇数放前面，偶数放后面，双指针操作
 * @version:1.0
 * @date: 2017年2月22日下午8:35:14
 * @author: lfq
 * 
 */
public class _14ReOderOddEven {

	public static void main(String[] args) {
		int[] nums = {2,4,5,1,3};
		reOrder(nums);
		System.out.println(Arrays.toString(nums));

	}
	
	public static void reOrder(int[] nums){
		if(nums == null || nums.length < 2){
			return;
		}
		int p1 = 0, p2 = nums.length-1;
		while(p1 < p2){
			while(p1 < p2 && (nums[p1] & 0x1) == 1)
				p1++;
			while(p1 < p2 && (nums[p2] & 0x1) == 0)
				p2--;
			if(p1 < p2){
				swap(nums, p1, p2);
			}
		}
	}

	private static void swap(int[] nums, int p1, int p2) {
		int temp = nums[p1];
		nums[p1] = nums[p2];
		nums[p2] = temp;
	}

}
