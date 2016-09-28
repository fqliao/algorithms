package array;
import java.util.Arrays;

/**
 * 由于排了序，返回的下标是排序后的下标，因此不是原数组的下标
 * 用于threeSum或TwoSum调用
 * @author Administrator
 *
 */
public class TwoSumDisorder {

	public static int[] twoSum(int[] nums,int target){
		int[] res = {0,0};
		if(nums.length < 2){
			return null;
		}
		Arrays.sort(nums);
		int i = 0,j = nums.length-1;
		if(2*nums[i] > target || 2*nums[j] < target){
			return null;
		}
		while (i < nums.length-2 && i < j) {
			int sum = nums[i]+nums[j];
			if(sum == target){
				res[0] = i;
				res[1] = j;
			}
			if(sum <= target) while(nums[i] == nums[++i] && i < j);
			if(sum >= target) while(nums[j] == nums[--j] && i < j);
		}
		return res;
	}
	public static void main(String[] args) {
		int[] arr ={2, 3, 4};
		System.out.println(Arrays.toString(twoSum(arr, 6)));

	}

}
