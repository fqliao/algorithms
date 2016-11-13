package search.sortList;

/**
 * @decription:有序表---> 插值查找
 * mid = low + (high-low)*( key-nums[low])/(nums[high]-nums[low])
 * 注意：不要写成 
 * mid = low + (high-low)*(( key-nums[low])/(nums[high]-nums[low]))
 * 例如：
 *  4 * 2 / 5 = 1 
 *  4 * ( 2 / 5) = 0
     当端点值相等时，mid取low或high均可，其他不变，即为插值查找法
 * 时间复杂度：O(logn) O(1)
 * 优化：
 * 1是对二分法的优化和不同场景的应对方法
 * 适用场景：顺序存储且有序，且静态，即不能频繁的插入或删除，频繁插入或删除还是维持有序，
 * 对数据分布不均匀的列表，性能比二分法好（虽然复杂度一样）当数据分布很不均匀时，
 * 比二分法的优化更加突出。如果分布很均匀，二分法好些。二分法的1/2是固定的，
 * 插值法是没有固定的，每次要计算，有计算代价，增加了一次减法，一次加法，一次除法。
 * @version:1.0
 * @date: 2016年11月11日下午5:37:02
 * @author: lfq
 * 
 */
public class InterpolationSearch {

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
		int low = 0;
		int high = nums.length - 1;;
		while(low <= high)
		{
			int mid = 0;
			if((nums[high] - nums[low]) != 0)
				mid = low + (high - low) * (key-nums[low])/(nums[high]-nums[low]);
			else//端点值相等则都相等
				mid = low;
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
