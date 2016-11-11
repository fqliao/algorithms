package search.squential;

import java.util.Arrays;

/**
 * @decription:顺序查找
 * 时间复杂度：O(n) O(1)
 * 优化：
 * 1 利用哨兵法，减少循环变量的依次比较
 * 2 将常需查找的数据放在靠后的位置，不常需要查找的元素放在靠前的位置
 * 适用场景：数据无序，数据量小
 * @version:1.0
 * @date: 2016年11月11日下午4:11:55
 * @author: lfq
 * 
 */
public class SquentialSearch {

	public static void main(String[] args) {
		int[] nums = {1,3,2,4};
		System.out.println(search(nums, 0)+" "+Arrays.toString(nums));
		System.out.println(search(nums, 1)+" "+Arrays.toString(nums));
		System.out.println(search(nums, 3)+" "+Arrays.toString(nums));
		System.out.println(search(nums, 4)+" "+Arrays.toString(nums));
		System.out.println(search(nums, 5)+" "+Arrays.toString(nums));

	}
	
	public static int search(int[] nums,int key)
	{
		if(nums == null)
			return -1;
		if(nums[0] == key)
			return 0;
		
		int firstValue = nums[0];//保存第一个值
		nums[0] = key;//埋下哨兵 目的在于减少循环时对循环变量的每次判断，优化性能
		
		int i = nums.length - 1;
		while(nums[i] != key)
			i--;
		nums[0] = firstValue;//还回数组，不更改数组的内容
		if(i == 0)
			return -1;
		return i;
	}

}
