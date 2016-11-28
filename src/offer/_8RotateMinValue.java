package offer;

/**
 * @decription:部分有序-->利用二分查找法
 * 先写测试用例，再设计，双指针很有威力！解决不了特殊情况，就一般情况处理
 * @version:1.0
 * @date: 2016年11月28日下午5:35:03
 * @author: lfq
 * 
 */
public class _8RotateMinValue {

	public static void main(String[] args) throws Exception {
//		int[] nums = {1,2,3,4,5};
//		int[] nums = {3,4,5,1,2};
//		int[] nums = {2,4,5,1,2};
		int[] nums = {1,1,1,1,1};
//		int[] nums = {1,0,1,1,1};
//		int[] nums = {1,1,1,0,1};
//		int[] nums = {-1};
//		int[] nums = null;
		System.out.println(solution(nums));

	}
	
	public static int solution(int[] nums) throws Exception
	{
		if(nums == null)
			throw new Exception("数组为空");
		int p1 = 0, p2 = nums.length-1;
		if(nums[p1] < nums[p2])//没有旋转的情况下,完全有序
			return nums[p1];
		int mid;
		while(p2 - p1 != 1)
		{
			mid = (p1 + p2) / 2;
			if(nums[p1] == nums[mid] && nums[mid] == nums[p2])//顺序查找
				return inOrder(nums);
			if(nums[p1] < nums[mid])
				p1 = mid;
			if(nums[mid] < nums[p2])
				p2 = mid;
		}
		return nums[p2];
	}
	
	private static int inOrder(int[] nums)
	{
		for (int i = 0; i < nums.length - 1; i++) 
		{
			if(nums[i] > nums[i+1])
				return nums[i+1];
		}
		return nums[0];//数组元素都相同
	}
}
