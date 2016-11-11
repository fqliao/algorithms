package search.sortList;


/**
 * @decription:有序表查找--->二分查找
 * 时间复杂度：O(logn) O(1)
 * 优化：
 * 1 用迭代，不用递归
 * 适用场景：顺序存储且有序，且静态，即不能频繁的插入或删除，频繁插入或删除还是维持有序，那么也可以用二分查找
 * @version:1.0
 * @date: 2016年11月11日下午5:09:09
 * @author: lfq
 * 
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,6};
		System.out.println(search(nums,0));
		System.out.println(search(nums,1));
		System.out.println(search(nums,3));
		System.out.println(search(nums,4));
		System.out.println(search(nums,5));

	}
	
	public static int search(int[] nums,int key)
	{
		if(nums == null)
			return -1;
		int len = nums.length-1;
		int low = 0;
		int high = len;
		int mid;
		while(low <= high)//用循环迭代，不要递归
		{
			mid = (low + high) / 2;
			if(nums[mid] > key)
				high = mid - 1;
			else if(nums[mid] < key)
				low = mid + 1;
			else
				return mid;
		}
		return -1;
	}
}
