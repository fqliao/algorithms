package sort.countSort;

import java.util.Arrays;

/**
 * @decription:特殊排序--->计数排序
 * 1 时间复杂度：O(n) O(n)
 * 2 稳定性：不稳定
 * 3 辅助空间：O(1)
 * 4 比较：适用数值范围比较小的场合，且能知道或预估最小，最大值，效率最高O(n),线性排序，不适合范围很大的数的排序
 * @version:
 * @date: 2016年11月9日下午9:03:20
 * @author: lfq
 * 
 */
public class CountSort {

	public static void main(String[] args) throws Exception {
		//测试年龄23-50数组排序
		int[] nums = {25,23,26,28,40,35,28,47,47};
		sort(nums, 23, 50);
		System.out.println(Arrays.toString(nums));
	}
	
	public static void sort(int[] nums,int min,int max) throws Exception
	{
		if(nums == null || nums.length < 2)
			return;
		int len = nums.length;
		int[] count = new int[max-min+1];//计数数组
		for (int i = 0; i < len; i++) //计数
		{
			int num = nums[i];
			if(num < min || num > max)//过滤非法数据
				throw new Exception("数据超出范围");
			count[num-min]++;//注意，这里是num-min，起点不是0，而是-min
		}
		int index = 0;//更加计数排列数据的索引
		for (int i = min; i <= max; i++)//更加计数数组按顺序重写排序数据
		{
			for (int j = 0; j < count[i-min]; j++)
			{
				nums[index++] = i;
			}
		}
	}

}
