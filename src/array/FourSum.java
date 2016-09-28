package array;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class FourSum {
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		int len = nums.length;
		if (nums == null || len < 4)
			return res;
		
		Arrays.sort(nums);

		int max = nums[len - 1];
		if (4 * nums[0] > target || 4 * max < target)
			return res;

		int i, z;
		for (i = 0; i < len-3; i++) {
			z = nums[i];
			if (i > 0 && z == nums[i - 1])// avoid duplicate
				continue;
			if (z + 3 * max < target) // z is too small
				continue;
			if (4 * z > target) // z is too large
				break;
			if (4 * z == target) { // z is the boundary
				if (i + 3 < len && nums[i + 3] == z)
					res.add(Arrays.asList(z, z, z, z));
				break;
			}

			threeSumForFourSum(nums, target - z, i + 1, res, z);
		}

		return res;
	}

	public void threeSumForFourSum(int[] nums, int target, int i, ArrayList<List<Integer>> res,
			int z1) {

		int max = nums[nums.length-1];
		if (3 * nums[i] > target || 3 * max < target)
			return;
        while(i < nums.length - 2) {
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target) res.add(Arrays.asList(z1,nums[i], nums[j], nums[k]));
                if(sum <= target) while(nums[j] == nums[++j] && j < k);
                if(sum >= target) while(nums[k] == nums[--k] && j < k);
            }
            while(nums[i] == nums[++i] && i < nums.length - 2);
        }
	}
   
	public static void main(String[] args) throws IOException {
		FourSum solution = new FourSum();
		int[] nums = {-1,-5,-5,-3,2,5,0,4};
		List<List<Integer>> fourSum = solution.fourSum(nums, -7);
		System.out.println(fourSum);
		
	}

}
